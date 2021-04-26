package com.timplay.servicehelper;

import android.content.Intent;
import android.graphics.Color;
import android.os.StrictMode;
import android.view.View;
import android.view.Window;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.android.material.textfield.TextInputEditText;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;

public class MainActivity3 extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.timplay.ServiceHelper.MESSAGE";

    ListView listView;
    ArrayList<String> listItem;
    HashMap<String, String> map;

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

        try {
            map = parseChoosenList();
        } catch (IOException e) {
            e.printStackTrace();
        }

        listItem = new ArrayList<>();
        listItem.addAll(map.values());

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.listitem, android.R.id.text1, listItem);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // TODO Auto-generated method stub
                String value = adapter.getItem(position);
                Toast.makeText(getApplicationContext(), value, Toast.LENGTH_SHORT).show();
                String key = getKeyByValue(map, value);
                sendMessage(view, key);
            }
        });


        Button toScheme = (Button) findViewById(R.id.toScheme);
        toScheme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        Button sendTelegram = (Button) findViewById(R.id.buttonTelegram);
        final TextInputEditText comments = (TextInputEditText) findViewById(R.id.comments);

        sendTelegram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendToTelegram(Objects.requireNonNull(comments.getText()).toString().trim());
            }
        });


    }

    public void sendMessage(View view, String message) {
        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }


    public HashMap<String, String> parseChoosenList() throws IOException {
        File dir = new File(getApplicationContext().getFilesDir(), "list");
        File gpxfile = new File(dir, "choosen.txt");
        HashMap<String, String> map = new HashMap<String, String>();

        String line;
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(gpxfile)));
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
            String[] parts = line.split(":", 2);
            if (parts.length >= 2) {
                String key = parts[0].replaceAll("\\s+", "");
                String value = parts[1];
                map.put(key, value);
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


    public void sendToTelegram(String message) {
        String urlString = "https://api.telegram.org/bot%s/sendMessage?chat_id=%s&text=%s";

        //Add Telegram token (given Token is fake)
        String apiToken = "11744798987:AAG2Di0iF_m31N70jXqqXcUHtbAwzTuLF4k1";

        //Add chatId (given chatId is fake)
        String chatId = "11296042972";
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