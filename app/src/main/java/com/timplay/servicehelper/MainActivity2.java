package com.timplay.servicehelper;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

import static android.app.PendingIntent.getActivity;

public class MainActivity2 extends AppCompatActivity {

    private static final String TAG = "myapp";
    private HashMap<String, String> partsMap = null;

    final Dialog dialog = null;
    int alphaOrange = adjustAlpha(Color.WHITE, 150);
    ArrayList<ImageView> imagesList = new ArrayList<>();
    ImageView iv1;
    ImageView iv2;
    ImageView iv3;
    ImageView iv4;
    ImageView iv5;



    public MainActivity2() throws FileNotFoundException {
    }

    @Override
    public void onResume(){
        super.onResume();
        System.out.println(iv1.getDrawable().getColorFilter());
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main2);
        ConstraintLayout l = (ConstraintLayout) findViewById(R.id.Layout);
        //alphaOrange = adjustAlpha(Color.WHITE, 150);
        final SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        final String message = intent.getStringExtra(MainActivity3.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        System.out.println("Message " + message);

        try {
            partsMap = parseList();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Button buttonToList = (Button) findViewById(R.id.buttonToList);
        Button buttonMark = (Button) findViewById(R.id.buttonMark);
        Button buttonClean = (Button) findViewById(R.id.buttonClean);

        final Dialog dialog = new Dialog(MainActivity2.this, R.style.CustomDialog);

        if ((getResources().getConfiguration().screenLayout &
                Configuration.SCREENLAYOUT_SIZE_MASK) ==
                Configuration.SCREENLAYOUT_SIZE_XLARGE) {
            // on a large screen device ...
            dialog.setContentView(R.layout.dialog);
        } else dialog.setContentView(R.layout.dialog);

        iv1 = (ImageView) findViewById(R.id.imageView1);
        iv2 = (ImageView) findViewById(R.id.imageView2);
         iv3 = (ImageView) findViewById(R.id.imageView3);
         iv4 = (ImageView) findViewById(R.id.imageView4);
         iv5 = (ImageView) findViewById(R.id.imageView5);

        ImageView iv7 = (ImageView) findViewById(R.id.imageView7);
        ImageView iv10 = (ImageView) findViewById(R.id.imageView10);
        ImageView iv11 = (ImageView) findViewById(R.id.imageView11);
        ImageView iv13 = (ImageView) findViewById(R.id.imageView13);
        ImageView iv16 = (ImageView) findViewById(R.id.imageView16);
        ImageView iv17 = (ImageView) findViewById(R.id.imageView17);
        ImageView iv18 = (ImageView) findViewById(R.id.imageView18);
        ImageView iv19 = (ImageView) findViewById(R.id.imageView19);
        ImageView iv20 = (ImageView) findViewById(R.id.imageView20);
        ImageView iv21 = (ImageView) findViewById(R.id.imageView21);
        ImageView iv22 = (ImageView) findViewById(R.id.imageView22);
        ImageView iv23 = (ImageView) findViewById(R.id.imageView23);
        ImageView iv24 = (ImageView) findViewById(R.id.imageView24);
        ImageView iv25 = (ImageView) findViewById(R.id.imageView25);
        ImageView iv26 = (ImageView) findViewById(R.id.imageView26);
        ImageView iv27 = (ImageView) findViewById(R.id.imageView27);
        ImageView iv28 = (ImageView) findViewById(R.id.imageView28);
        ImageView iv29 = (ImageView) findViewById(R.id.imageView29);
        ImageView iv30 = (ImageView) findViewById(R.id.imageView30);
        ImageView iv31 = (ImageView) findViewById(R.id.imageView31);
        ImageView iv32 = (ImageView) findViewById(R.id.imageView32);
        ImageView iv33 = (ImageView) findViewById(R.id.imageView33);
        ImageView iv34 = (ImageView) findViewById(R.id.imageView34);
        ImageView iv35 = (ImageView) findViewById(R.id.imageView35);
        ImageView iv352 = (ImageView) findViewById(R.id.imageView352);
        ImageView iv36 = (ImageView) findViewById(R.id.imageView36);
        ImageView iv37 = (ImageView) findViewById(R.id.imageView37);

        ImageView iv38 = (ImageView) findViewById(R.id.imageView38);
        ImageView iv39 = (ImageView) findViewById(R.id.imageView39);
        ImageView iv40 = (ImageView) findViewById(R.id.imageView40);
        ImageView iv41 = (ImageView) findViewById(R.id.imageView41);
        ImageView iv42 = (ImageView) findViewById(R.id.imageView42);
        ImageView iv43 = (ImageView) findViewById(R.id.imageView43);
        ImageView iv44 = (ImageView) findViewById(R.id.imageView44);
        ImageView iv45 = (ImageView) findViewById(R.id.imageView45);
        ImageView iv46 = (ImageView) findViewById(R.id.imageView46);
        ImageView iv47 = (ImageView) findViewById(R.id.imageView47);
        ImageView iv48 = (ImageView) findViewById(R.id.imageView48);
        ImageView iv49 = (ImageView) findViewById(R.id.imageView49);
        ImageView iv50 = (ImageView) findViewById(R.id.imageView50);
        ImageView iv51 = (ImageView) findViewById(R.id.imageView51);
        ImageView iv52 = (ImageView) findViewById(R.id.imageView52);
        ImageView iv53 = (ImageView) findViewById(R.id.imageView53);
        ImageView iv55 = (ImageView) findViewById(R.id.imageView55);
        ImageView iv56 = (ImageView) findViewById(R.id.imageView56);
        ImageView iv57 = (ImageView) findViewById(R.id.imageView57);
        ImageView iv58 = (ImageView) findViewById(R.id.imageView58);
        ImageView iv59 = (ImageView) findViewById(R.id.imageView59);
        ImageView iv60 = (ImageView) findViewById(R.id.imageView60);
        ImageView iv61 = (ImageView) findViewById(R.id.imageView61);
        ImageView iv63 = (ImageView) findViewById(R.id.imageView63);
        ImageView iv64 = (ImageView) findViewById(R.id.imageView64);
        ImageView iv65 = (ImageView) findViewById(R.id.imageView65);
        ImageView iv66 = (ImageView) findViewById(R.id.imageView66);
        ImageView iv67 = (ImageView) findViewById(R.id.imageView67);
        ImageView iv69 = (ImageView) findViewById(R.id.imageView69);
        ImageView iv72 = (ImageView) findViewById(R.id.imageView72);
        ImageView iv73 = (ImageView) findViewById(R.id.imageView73);
        ImageView iv75 = (ImageView) findViewById(R.id.imageView75);
        ImageView iv78 = (ImageView) findViewById(R.id.imageView78);
        ImageView iv79 = (ImageView) findViewById(R.id.imageView79);
        ImageView iv80 = (ImageView) findViewById(R.id.imageView80);
        ImageView iv81 = (ImageView) findViewById(R.id.imageView81);
        ImageView iv812 = (ImageView) findViewById(R.id.imageView812);
        ImageView iv94 = (ImageView) findViewById(R.id.imageView94);

//
        imagesList.add(iv1);
        imagesList.add(iv2);
        imagesList.add(iv3);
        imagesList.add(iv4);
        imagesList.add(iv5);
        imagesList.add(iv7);
        imagesList.add(iv10);
        imagesList.add(iv11);
        imagesList.add(iv13);
        imagesList.add(iv17);
        imagesList.add(iv16);
        imagesList.add(iv18);
        imagesList.add(iv19);
        imagesList.add(iv20);
        imagesList.add(iv21);
        imagesList.add(iv22);
        imagesList.add(iv23);
        imagesList.add(iv24);
        imagesList.add(iv25);
        imagesList.add(iv26);
        imagesList.add(iv27);
        imagesList.add(iv28);
        imagesList.add(iv29);
        imagesList.add(iv30);
        imagesList.add(iv31);
        imagesList.add(iv32);
        imagesList.add(iv33);
        imagesList.add(iv34);
        imagesList.add(iv35);
        imagesList.add(iv352);
        imagesList.add(iv36);
        imagesList.add(iv37);
        imagesList.add(iv38);
        imagesList.add(iv39);
        imagesList.add(iv40);
        imagesList.add(iv41);
        imagesList.add(iv42);
        imagesList.add(iv43);
        imagesList.add(iv44);
        imagesList.add(iv45);
        imagesList.add(iv46);
        imagesList.add(iv47);
        imagesList.add(iv48);
        imagesList.add(iv49);
        imagesList.add(iv50);
        imagesList.add(iv51);
        imagesList.add(iv52);
        imagesList.add(iv53);
        imagesList.add(iv55);
        imagesList.add(iv56);
        imagesList.add(iv57);
        imagesList.add(iv58);
        imagesList.add(iv59);
        imagesList.add(iv60);
        imagesList.add(iv61);

        imagesList.add(iv63);
        imagesList.add(iv64);

        imagesList.add(iv65);
        imagesList.add(iv66);

        imagesList.add(iv67);
        imagesList.add(iv69);
        imagesList.add(iv72);
        imagesList.add(iv73);
        imagesList.add(iv75);
        imagesList.add(iv78);
        imagesList.add(iv79);
        imagesList.add(iv80);
        imagesList.add(iv81);
        imagesList.add(iv812);
        imagesList.add(iv94);


        for (int i = 0, imagesListSize = imagesList.size(); i < imagesListSize; i++) {
            ImageView image = imagesList.get(i);
            image.getDrawable().mutate();
            setListener(image, i+1, sharedPref);
        }

        buttonClean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alphaOrange = adjustAlpha(Color.WHITE, 150);
                for (int i = 0, imagesListSize = imagesList.size(); i < imagesListSize; i++) {
                    ImageView image = imagesList.get(i);
                    image.getDrawable().setColorFilter(alphaOrange, PorterDuff.Mode.SRC_ATOP);
                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putString(String.valueOf(i), "WHITE");
                    editor.apply();
                    writeFileOnInternalStorage(getApplicationContext(), "choosen.txt", "", false);

                }
            }
        });

        buttonToList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alphaOrange = 0;
                imagesList.clear();
                Intent i = new Intent(getApplicationContext(),MainActivity3.class);
                        startActivity(i);
            }
        });

        buttonMark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
                Window window = dialog.getWindow();
                window.setLayout(ConstraintLayout.LayoutParams.MATCH_PARENT, ConstraintLayout.LayoutParams.WRAP_CONTENT);

                Button cancelDialog = (Button) dialog.findViewById(R.id.cancelDialog);
                cancelDialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        dialog.dismiss();
                    }
                });

                ImageView imR = (ImageView) dialog.findViewById(R.id.imageViewRed);

                imR.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        SharedPreferences.Editor editor = sharedPref.edit();
                        editor.putString(getString(R.string.colorname), "RED");
                        editor.apply();

                        alphaOrange = adjustAlpha(Color.RED, 150);
                        dialog.dismiss();

                    }
                });
                ImageView imB = (ImageView) dialog.findViewById(R.id.imageViewBlue);
                imB.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        SharedPreferences.Editor editor = sharedPref.edit();
                        editor.putString(getString(R.string.colorname), "BLUE");
                        editor.apply();
                        alphaOrange = adjustAlpha(Color.BLUE, 150);
//                        finish();
//                        Intent i = new Intent(getApplicationContext(),MainActivity3.class);
//                        startActivity(i);
                        dialog.dismiss();

                    }
                });
                ImageView imW = (ImageView) dialog.findViewById(R.id.imageViewWhite);
                imW.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {


                        SharedPreferences.Editor editor = sharedPref.edit();
                        editor.putString(getString(R.string.colorname), "WHITE");
                        editor.apply();
                        alphaOrange = adjustAlpha(Color.WHITE, 150);
                        dialog.dismiss();
                    }
                });

            }
        });


        if (message != null) {
            TextView dialogText = (TextView) dialog.findViewById(R.id.dialogText);

            System.out.println(message);
            if (message.equals("1")){
                System.out.println("test1");
                dialogText.setText("Выберите цвет для " + partsMap.get(message));
                smallDialog(iv1, dialog);
            }
            if (message.equals("2")){
                System.out.println("test2");
                dialogText.setText("Выберите цвет для " + partsMap.get(message));
                smallDialog(iv2, dialog);
            }
            if (message.equals("3")){
                System.out.println("test3");
                dialogText.setText("Выберите цвет для " + partsMap.get(message));
                smallDialog(iv3, dialog);
            }
            if (message.equals("4")){
                System.out.println("test4");
                dialogText.setText("Выберите цвет для " + partsMap.get(message));
                smallDialog(iv4, dialog);
            }
            if (message.equals("5")){
                System.out.println("test5");
                dialogText.setText("Выберите цвет для " + partsMap.get(message));
                smallDialog(iv5, dialog);
            }

        }

    }

    public void smallDialog(final ImageView v, final Dialog dialog) {
        dialog.show();
        Window window = dialog.getWindow();
        window.setLayout(ConstraintLayout.LayoutParams.MATCH_PARENT, ConstraintLayout.LayoutParams.WRAP_CONTENT);

        Button cancelDialog = (Button) dialog.findViewById(R.id.cancelDialog);
        cancelDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();
            }
        });

        ImageView imR = (ImageView) dialog.findViewById(R.id.imageViewRed);

        imR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                alphaOrange = adjustAlpha(Color.RED, 150);
                System.out.println("colorToRed");
                v.getDrawable().setColorFilter(alphaOrange, PorterDuff.Mode.SRC_OVER);
                dialog.dismiss();

            }
        });
        ImageView imB = (ImageView) dialog.findViewById(R.id.imageViewBlue);
        imB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                System.out.println("colorToBlue");
                alphaOrange = adjustAlpha(Color.BLUE, 150);
                v.getDrawable().setColorFilter(alphaOrange, PorterDuff.Mode.SRC_OVER);
                dialog.dismiss();

            }
        });
        ImageView imW = (ImageView) dialog.findViewById(R.id.imageViewWhite);
        imW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                System.out.println("colorToWhite");
                alphaOrange = adjustAlpha(Color.WHITE, 150);
                v.getDrawable().setColorFilter(alphaOrange, PorterDuff.Mode.SRC_ATOP);
                dialog.dismiss();
            }
        });

    }

    public int adjustAlpha(int color, float factor) {
        int alpha = Math.round(Color.alpha(color) * factor);
        int red = Color.red(color);
        int green = Color.green(color);
        int blue = Color.blue(color);
        return Color.argb(alpha, red, green, blue);
    }


    public void writeFileOnInternalStorage(Context mcoContext, String sFileName, String sBody, boolean append) {
        File dir = new File(mcoContext.getFilesDir(), "list");
        if (!dir.exists()) {
            dir.mkdir();
        }

        try {
            File gpxfile = new File(dir, sFileName);
            FileWriter writer = new FileWriter(gpxfile, append);
            writer.append(sBody);
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void setListener(final ImageView v, final int partNr, final SharedPreferences sharedPref) {


        String col = sharedPref.getString(String.valueOf(partNr), "WHITE");
        System.out.println(col+partNr);
        if (col.equals("RED"))  {
            System.out.println("toRed");
            alphaOrange = adjustAlpha(Color.RED, 150);
            v.getDrawable().setColorFilter(alphaOrange, PorterDuff.Mode.SRC_OVER);

        }
        if (col.equals("BLUE"))    {
            System.out.println("toBlue");
            alphaOrange = adjustAlpha(Color.BLUE, 150);
            v.getDrawable().setColorFilter(alphaOrange, PorterDuff.Mode.SRC_OVER);

        }
        if (col.equals("WHITE"))        {
            System.out.println("toWhite");
            alphaOrange = adjustAlpha(Color.WHITE, 150);
            v.getDrawable().setColorFilter(alphaOrange, PorterDuff.Mode.SRC_ATOP);

        }


        v.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {


                if (partsMap != null) {
                    writeFileOnInternalStorage(getApplicationContext(), "choosen.txt", partNr + ":" + partsMap.get(String.valueOf(partNr)) + "\n", true);
                }

                String color = sharedPref.getString(getString(R.string.colorname), "WHITE");

                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putString(String.valueOf(partNr), color);
                    editor.apply();

                v.getDrawable().setColorFilter(alphaOrange, PorterDuff.Mode.SRC_OVER);

                Toast.makeText(getApplicationContext(), partsMap.get(String.valueOf(partNr)), Toast.LENGTH_SHORT).show();
            }
        });
    }


    public HashMap<String, String> parseList() throws IOException {
        InputStream fileInputStream = getResources().openRawResource(R.raw.list);
        HashMap<String, String> map = new HashMap<String, String>();

        String line;
        BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream));
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(":", 2);
            if (parts.length >= 2) {
                String key = parts[0].replaceAll("\\s+", "");
                String value = parts[1];
                map.put(key, value);
            } else {
                // System.out.println("ignoring line: " + line);
            }
        }

//    for (String key : map.keySet())
//    {
//        System.out.println("_"+key + "=>" + map.get(key)+"_");
//    }
        reader.close();
        return map;
    }


}