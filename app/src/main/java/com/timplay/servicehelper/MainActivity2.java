package com.timplay.servicehelper;

import android.app.Dialog;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.io.*;
import java.util.HashMap;

public class MainActivity2 extends AppCompatActivity {

    private static final String TAG = "myapp";
    private HashMap<String,String> partsMap = null;

    public MainActivity2() throws FileNotFoundException {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main2);
        ConstraintLayout l = (ConstraintLayout) findViewById(R.id.Layout);

        try {
            partsMap = parseList();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ImageView iv2 = (ImageView) findViewById(R.id.imageView2);
        ImageView iv1 = (ImageView) findViewById(R.id.imageView1);
        ImageView iv3 = (ImageView) findViewById(R.id.imageView3);
        ImageView iv4 = (ImageView) findViewById(R.id.imageView4);
        ImageView iv5 = (ImageView) findViewById(R.id.imageView5);

        setListener(iv1,1);
        setListener(iv2,2);
        setListener(iv3,3);
        setListener(iv4,4);
        setListener(iv5,5);

    }

    public int adjustAlpha(int color, float factor) {
        int alpha = Math.round(Color.alpha(color) * factor);
        int red = Color.red(color);
        int green = Color.green(color);
        int blue = Color.blue(color);
        return Color.argb(alpha, red, green, blue);
    }



    public void writeFileOnInternalStorage(Context mcoContext, String sFileName, String sBody){
        File dir = new File(mcoContext.getFilesDir(), "list");
        if(!dir.exists()){
            dir.mkdir();
        }

        try {
            File gpxfile = new File(dir, sFileName);
            FileWriter writer = new FileWriter(gpxfile);
            writer.append(sBody);
            writer.flush();
            writer.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }


    public void setListener(final ImageView v, final int partNr) {
        v.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                final Dialog dialog = new Dialog(MainActivity2.this, R.style.CustomDialog);
                if ((getResources().getConfiguration().screenLayout &
                        Configuration.SCREENLAYOUT_SIZE_MASK) ==
                        Configuration.SCREENLAYOUT_SIZE_XLARGE) {
                    // on a large screen device ...
                    dialog.setContentView(R.layout.dialog);}

                else dialog.setContentView(R.layout.dialog);


                ImageView imR = (ImageView) dialog.findViewById(R.id.imageViewRed);
                imR.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (partsMap != null){
                            System.out.println(partNr);
                            System.out.println(partsMap.get(String.valueOf(partNr)));
                            writeFileOnInternalStorage(getApplicationContext(),"choosen.txt",partNr+":"+partsMap.get(String.valueOf(partNr)));
                        }
                        int alphaOrange = adjustAlpha(Color.RED, 80);
                        v.getDrawable().setColorFilter(alphaOrange, PorterDuff.Mode.SRC_ATOP);
                        dialog.dismiss();
                    }
                });
                ImageView imB = (ImageView) dialog.findViewById(R.id.imageViewBlue);
                imB.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        int alphaOrange = adjustAlpha(Color.BLUE, 80);
                        v.getDrawable().setColorFilter(alphaOrange, PorterDuff.Mode.SRC_ATOP);
                        dialog.dismiss();
                    }
                });
                ImageView imW = (ImageView) dialog.findViewById(R.id.imageViewWhite);
                imW.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        int alphaOrange = adjustAlpha(Color.WHITE, 80);
                        v.getDrawable().setColorFilter(alphaOrange, PorterDuff.Mode.SRC_ATOP);
                        dialog.dismiss();
                    }
                });


                dialog.show();
                Window window = dialog.getWindow();
                window.setLayout(ConstraintLayout.LayoutParams.MATCH_PARENT, ConstraintLayout.LayoutParams.WRAP_CONTENT);
            }
        });
    }

    public HashMap<String, String> parseChoosenList() throws IOException {
        File dir = new File(getApplicationContext().getFilesDir(), "list");
        File gpxfile = new File(dir, "choosen.txt");
        HashMap<String, String> map = new HashMap<String, String>();

        String line;
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(gpxfile)));
        while ((line = reader.readLine()) != null)
        {
            System.out.println(line);
            String[] parts = line.split(":", 2);
            if (parts.length >= 2)
            {
                String key = parts[0].replaceAll("\\s+","");
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

public HashMap<String, String> parseList() throws IOException {
    InputStream fileInputStream = getResources().openRawResource(R.raw.list);
    HashMap<String, String> map = new HashMap<String, String>();

    String line;
    BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream));
    while ((line = reader.readLine()) != null)
    {
        String[] parts = line.split(":", 2);
        if (parts.length >= 2)
        {
            String key = parts[0].replaceAll("\\s+","");
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