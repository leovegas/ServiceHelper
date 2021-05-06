package com.timplay.servicehelper;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.StrictMode;
import android.view.View;
import android.view.Window;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.android.material.textfield.TextInputEditText;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.TelegramBotAdapter;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.request.ForceReply;
import com.pengrad.telegrambot.model.request.ParseMode;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.SendResponse;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;

public class MainActivity3 extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.timplay.ServiceHelper.MESSAGE";

    ListView listView;
    ArrayList<String> listItem;
    HashMap<String, String> mapR;
    HashMap<String, String> mapB;

    @Override
    protected void onPostResume() {
        super.onPostResume();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main3);
        listView = (ListView) findViewById(R.id.listview);
        final SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);


        try {
            mapR = parseChoosenListR();
            mapB = parseChoosenListB();

        } catch (IOException e) {
            e.printStackTrace();
        }

        listItem = new ArrayList<>();

        listItem.addAll(mapB.values());
        listItem.add("       ---------------------------       ");
        listItem.addAll(mapR.values());


        final CustomAdapter adapter = new CustomAdapter(getApplicationContext(), listItem.toArray(new String[0]));
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String value = adapter.getItem(position);
                Toast.makeText(getApplicationContext(), value, Toast.LENGTH_SHORT).show();
                String key = getKeyByValue(mapR, value);
                if (key == null) {
                    key = getKeyByValue(mapB, value);
                }
                sendMessage(view, key);
            }
        });

        final TextInputEditText comments = (TextInputEditText) findViewById(R.id.comments);
        System.out.println(sharedPref.getString("comments", ""));
        comments.setText(sharedPref.getString("comments",""));

        Button toScheme = (Button) findViewById(R.id.toScheme);
        toScheme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String comm = Objects.requireNonNull(comments.getText()).toString().trim();
                System.out.println(comm);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("comments", comm);
                editor.apply();
                sendMessage(v,"toScheme");
            }
        });

        Button sendTelegram = (Button) findViewById(R.id.buttonTelegram);

        sendTelegram.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                StringBuilder sbr = new StringBuilder();
                StringBuilder sbb = new StringBuilder();
                StringBuilder comment = new StringBuilder();
                ArrayList<String> listR = new ArrayList<>(mapB.values());
                ArrayList<String> listB = new ArrayList<>(mapR.values());
                sbr.append("<b>Красные:</b>\n");
                sbb.append("<b>Синие:</b>\n");
                comment.append("<b>Комментарии:</b>\n");
                for (String s:listR) {
                    sbr.append("<pre>"+s+"</pre>").append("\n");
                }
                for (String s:listB) {
                    sbb.append("<pre>"+s+"</pre>").append("\n");
                }

                sendToTelegramBot(sbr.toString() + sbb.toString() + comment.toString() + "<pre>"+Objects.requireNonNull(comments.getText()).toString().trim()+"</pre>");
                Toast.makeText(getApplicationContext(), "Отправлено", Toast.LENGTH_SHORT).show();

            }
        });
    }

    public void sendMessage(View view, String message) {
        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }


    public HashMap<String, String> parseChoosenListR() throws IOException {
        File dir = new File(getApplicationContext().getFilesDir(), "list");
        File gpxfile = new File(dir, "choosen.txt");
        HashMap<String, String> map = new HashMap<String, String>();

        String line;
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(gpxfile)));
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(":", 2);
            if (parts.length >= 2) {
                String key = parts[0].replaceAll("\\s+", "");
                String value = parts[1];
                if (value.endsWith("!R")){
                    map.put(key, value.substring(0, value.length() - 2));
                }
            } else {
                // System.out.println("ignoring line: " + line);
            }
        }


        reader.close();
        return map;
    }
    public HashMap<String, String> parseChoosenListB() throws IOException {
        File dir = new File(getApplicationContext().getFilesDir(), "list");
        File gpxfile = new File(dir, "choosen.txt");
        HashMap<String, String> map = new HashMap<String, String>();

        String line;
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(gpxfile)));
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(":", 2);
            if (parts.length >= 2) {
                String key = parts[0].replaceAll("\\s+", "");
                String value = parts[1];
                if (value.endsWith("!B")){
                    map.put(key, value.substring(0, value.length() - 2));
                }
            } else {
                // System.out.println("ignoring line: " + line);
            }
        }


        reader.close();
        return map;
    }



    public static <T, E> T getKeyByValue(Map<T, E> map, E value) {
        for (Map.Entry<T, E> entry : map.entrySet()) {
            if (Objects.equals(value, entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
        startActivity(intent);
    }

    public void sendToTelegramBot(String message) {


        TelegramBot bot = TelegramBotAdapter.build(apiToken);

        SendMessage request = new SendMessage(chatId, "<b>"+message+"</b> \n")
                .parseMode(ParseMode.HTML)
                .disableWebPagePreview(true)
                .disableNotification(true)
                .replyToMessageId(1)
                .replyMarkup(new ForceReply());

// sync
        SendResponse sendResponse = bot.execute(request);
        boolean ok = sendResponse.isOk();
        Message mess = sendResponse.message();
        System.out.println(mess);
    }



        public void sendToTelegram(String message) {


        String text = message;

        urlString = String.format(urlString, apiToken, chatId, text);

        try {
            URL url = new URL(urlString);
            URLConnection conn = url.openConnection();
            InputStream is = new BufferedInputStream(conn.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}