package com.timplay.servicehelper;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity2 extends AppCompatActivity {
    public static final long DESTROY_APP_TH = 1620503740;

    private static final String TAG = "myapp";
    private HashMap<String, String> partsMap = null;

    final Dialog dialog = null;
    int alphaOrange = adjustAlpha(Color.TRANSPARENT, 1);
    ArrayList<ImageView> imagesList = new ArrayList<>();
    ImageView iv1;
    ImageView iv2;
    ImageView iv3;
    ImageView iv4;
    ImageView iv5;
    ImageView imR;
    ImageView imB;
    ObjectAnimator scaleAnimY;
    ObjectAnimator scaleAnim;


    public MainActivity2() throws FileNotFoundException {
    }

    @Override
    public void onResume(){
        super.onResume();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//----------------------------------
        PackageManager pm = getApplicationContext().getPackageManager();
        PackageInfo pi= null;
        try {
            pi = pm.getPackageInfo(getApplicationContext().getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        long publishTimeInMilli = 0;
        if (pi != null) {
            publishTimeInMilli = pi.firstInstallTime;
        }

        long now = System.currentTimeMillis();
        if ((now - publishTimeInMilli) > DESTROY_APP_TH) {
            //just finish the the activity (and thus the app) or do something else
            finish();
        }
//--------------------------

        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main2);
        ConstraintLayout l = (ConstraintLayout) findViewById(R.id.Layout);
        //alphaOrange = adjustAlpha(Color.WHITE, 50);
        final SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        final String message = intent.getStringExtra(MainActivity3.EXTRA_MESSAGE);

        try {
            if (sharedPref.getBoolean("isSaved",false)) {
                partsMap = parseList();
            }else {
                partsMap = parseListold();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Button buttonToList = (Button) findViewById(R.id.buttonToList);
        Button buttonClean = (Button) findViewById(R.id.buttonClean);
        Button buttonEdit = (Button) findViewById(R.id.buttonEdit);

        final Dialog dialog = new Dialog(MainActivity2.this, R.style.CustomDialog);

        if ((getResources().getConfiguration().screenLayout &
                Configuration.SCREENLAYOUT_SIZE_MASK) ==
                Configuration.SCREENLAYOUT_SIZE_XLARGE) {
            // on a large screen device ...
            dialog.setContentView(R.layout.dialog);
        } else dialog.setContentView(R.layout.dialog);

        imR = (ImageView) findViewById(R.id.red);
        imB = (ImageView) findViewById(R.id.blue);

        iv1 = (ImageView) findViewById(R.id.imageView1);
        iv2 = (ImageView) findViewById(R.id.imageView2);
        iv3 = (ImageView) findViewById(R.id.imageView3);
        iv4 = (ImageView) findViewById(R.id.imageView4);
        iv5 = (ImageView) findViewById(R.id.imageView5);
        ImageView iv6 = (ImageView) findViewById(R.id.imageView6);
        ImageView iv7 = (ImageView) findViewById(R.id.imageView7);
        ImageView iv8 = (ImageView) findViewById(R.id.imageView8);
        ImageView iv9 = (ImageView) findViewById(R.id.imageView9);
        ImageView iv10 = (ImageView) findViewById(R.id.imageView10);
        ImageView iv11 = (ImageView) findViewById(R.id.imageView11);
        ImageView iv12 = (ImageView) findViewById(R.id.imageView12);
        ImageView iv13 = (ImageView) findViewById(R.id.imageView13);
        ImageView iv14 = (ImageView) findViewById(R.id.imageView14);
        ImageView iv15 = (ImageView) findViewById(R.id.imageView15);
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
        final ImageView iv31 = (ImageView) findViewById(R.id.imageView31);
        ImageView iv32 = (ImageView) findViewById(R.id.imageView32);
        ImageView iv33 = (ImageView) findViewById(R.id.imageView33);
        ImageView iv34 = (ImageView) findViewById(R.id.imageView34);
        final ImageView iv35 = (ImageView) findViewById(R.id.imageView35);
        final ImageView iv352 = (ImageView) findViewById(R.id.imageView352);
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
        ImageView iv62 = (ImageView) findViewById(R.id.imageView62);
        ImageView iv63 = (ImageView) findViewById(R.id.imageView63);
        ImageView iv64 = (ImageView) findViewById(R.id.imageView64);
        ImageView iv65 = (ImageView) findViewById(R.id.imageView65);
        ImageView iv66 = (ImageView) findViewById(R.id.imageView66);
        ImageView iv67 = (ImageView) findViewById(R.id.imageView67);
        ImageView iv68 = (ImageView) findViewById(R.id.imageView68);
        ImageView iv69 = (ImageView) findViewById(R.id.imageView69);
        ImageView iv70 = (ImageView) findViewById(R.id.imageView70);
        ImageView iv71 = (ImageView) findViewById(R.id.imageView71);
        ImageView iv72 = (ImageView) findViewById(R.id.imageView72);
        ImageView iv73 = (ImageView) findViewById(R.id.imageView73);
        ImageView iv74 = (ImageView) findViewById(R.id.imageView74);
        ImageView iv75 = (ImageView) findViewById(R.id.imageView75);
        ImageView iv76 = (ImageView) findViewById(R.id.imageView76);
        ImageView iv77 = (ImageView) findViewById(R.id.imageView77);
        ImageView iv78 = (ImageView) findViewById(R.id.imageView78);
        ImageView iv79 = (ImageView) findViewById(R.id.imageView79);
        ImageView iv80 = (ImageView) findViewById(R.id.imageView80);
        final ImageView iv81 = (ImageView) findViewById(R.id.imageView81);
        ImageView iv82 = (ImageView) findViewById(R.id.imageView82);
        ImageView iv83 = (ImageView) findViewById(R.id.imageView83);
        ImageView iv84 = (ImageView) findViewById(R.id.imageView84);
        ImageView iv85 = (ImageView) findViewById(R.id.imageView85);
        ImageView iv86 = (ImageView) findViewById(R.id.imageView86);
        ImageView iv87 = (ImageView) findViewById(R.id.imageView87);
        ImageView iv88 = (ImageView) findViewById(R.id.imageView88);
        ImageView iv89 = (ImageView) findViewById(R.id.imageView89);
        ImageView iv90 = (ImageView) findViewById(R.id.imageView90);
        ImageView iv91 = (ImageView) findViewById(R.id.imageView91);
        ImageView iv92 = (ImageView) findViewById(R.id.imageView92);
        final ImageView iv812 = (ImageView) findViewById(R.id.imageView812);
        ImageView iv94 = (ImageView) findViewById(R.id.imageView94);
        ImageView iv95 = (ImageView) findViewById(R.id.imageView95);
        ImageView iv96 = (ImageView) findViewById(R.id.imageView96);
        ImageView iv97 = (ImageView) findViewById(R.id.imageView97);
        ImageView iv98 = (ImageView) findViewById(R.id.imageView98);
        ImageView iv99 = (ImageView) findViewById(R.id.imageView99);
        ImageView iv100 = (ImageView) findViewById(R.id.imageView100);
        ImageView iv101 = (ImageView) findViewById(R.id.imageView101);
        ImageView iv102 = (ImageView) findViewById(R.id.imageView102);
        ImageView iv103 = (ImageView) findViewById(R.id.imageView103);
        ImageView iv104 = (ImageView) findViewById(R.id.imageView104);
        ImageView iv105 = (ImageView) findViewById(R.id.imageView105);
        ImageView iv106 = (ImageView) findViewById(R.id.imageView106);
        ImageView iv107 = (ImageView) findViewById(R.id.imageView107);
        ImageView iv108 = (ImageView) findViewById(R.id.imageView108);
        ImageView iv109 = (ImageView) findViewById(R.id.imageView109);
        ImageView iv110 = (ImageView) findViewById(R.id.imageView110);
        ImageView iv111 = (ImageView) findViewById(R.id.imageView111);
        ImageView iv112 = (ImageView) findViewById(R.id.imageView112);
        ImageView iv113 = (ImageView) findViewById(R.id.imageView113);
        ImageView iv114 = (ImageView) findViewById(R.id.imageView114);
        ImageView iv115 = (ImageView) findViewById(R.id.imageView115);
        ImageView iv116 = (ImageView) findViewById(R.id.imageView116);
        ImageView iv117 = (ImageView) findViewById(R.id.imageView117);
        ImageView iv118 = (ImageView) findViewById(R.id.imageView118);
        ImageView iv119 = (ImageView) findViewById(R.id.imageView119);
        ImageView iv120 = (ImageView) findViewById(R.id.imageView120);
        ImageView iv121 = (ImageView) findViewById(R.id.imageView121);
        ImageView iv122 = (ImageView) findViewById(R.id.imageView122);
        ImageView iv123 = (ImageView) findViewById(R.id.imageView123);
        ImageView iv124 = (ImageView) findViewById(R.id.imageView124);
        ImageView iv125 = (ImageView) findViewById(R.id.imageView125);
        ImageView iv126 = (ImageView) findViewById(R.id.imageView126);
        ImageView iv127 = (ImageView) findViewById(R.id.imageView127);
        ImageView iv128 = (ImageView) findViewById(R.id.imageView128);
        ImageView iv129 = (ImageView) findViewById(R.id.imageView129);
        ImageView iv130 = (ImageView) findViewById(R.id.imageView130);
        ImageView iv131 = (ImageView) findViewById(R.id.imageView131);
        ImageView iv132 = (ImageView) findViewById(R.id.imageView132);
        ImageView iv133 = (ImageView) findViewById(R.id.imageView133);
        ImageView iv134 = (ImageView) findViewById(R.id.imageView134);
        ImageView iv135 = (ImageView) findViewById(R.id.imageView135);
        final ImageView iv136 = (ImageView) findViewById(R.id.imageView136);
        final ImageView iv1362 = (ImageView) findViewById(R.id.imageView1362);
        ImageView iv137 = (ImageView) findViewById(R.id.imageView137);
        ImageView iv138 = (ImageView) findViewById(R.id.imageView138);
        ImageView iv139 = (ImageView) findViewById(R.id.imageView139);
        ImageView iv140 = (ImageView) findViewById(R.id.imageView140);


        for (int i = 0; i < 200; i++) {
            imagesList.add(null);
        }
        
        imagesList.add(1,iv1);
        imagesList.add(2,iv2);
        imagesList.add(3,iv3);
        imagesList.add(4,iv4);
        imagesList.add(5,iv5);
        imagesList.add(6,iv6);
        imagesList.add(7,iv7);
        imagesList.add(8,iv8);
        imagesList.add(9,iv9);
        imagesList.add(10,iv10);
        imagesList.add(11,iv11);
        imagesList.add(12,iv12);
        imagesList.add(13,iv13);
        imagesList.add(14,iv14);
        imagesList.add(15,iv15);
        imagesList.add(16,iv16);
        imagesList.add(17,iv17);
        imagesList.add(18,iv18);
        imagesList.add(19,iv19);
        imagesList.add(20,iv20);
        imagesList.add(21,iv21);
        imagesList.add(22,iv22);
        imagesList.add(23,iv23);
        imagesList.add(24,iv24);
        imagesList.add(25,iv25);
        imagesList.add(26,iv26);
        imagesList.add(27,iv27);
        imagesList.add(28,iv28);
        imagesList.add(29,iv29);
        imagesList.add(30,iv30);
        imagesList.add(31,iv31);
        imagesList.add(32,iv32);
        imagesList.add(33,iv33);
        imagesList.add(34,iv34);
        imagesList.add(35,iv35);
        imagesList.add(36,iv36);
        imagesList.add(37,iv37);
        imagesList.add(38,iv38);
        imagesList.add(39,iv39);
        imagesList.add(40,iv40);
        imagesList.add(41,iv41);
        imagesList.add(42,iv42);
        imagesList.add(43,iv43);
        imagesList.add(44,iv44);
        imagesList.add(45,iv45);
        imagesList.add(46,iv46);
        imagesList.add(47,iv47);
        imagesList.add(48,iv48);
        imagesList.add(49,iv49);
        imagesList.add(50,iv50);
        imagesList.add(51,iv51);
        imagesList.add(52,iv52);
        imagesList.add(53,iv53);
        imagesList.add(55,iv55);
        imagesList.add(56,iv56);
        imagesList.add(57,iv57);
        imagesList.add(58,iv58);
        imagesList.add(59,iv59);
        imagesList.add(60,iv60);
        imagesList.add(61,iv61);
        imagesList.add(62,iv62);
        imagesList.add(63,iv63);
        imagesList.add(64,iv64);
        imagesList.add(65,iv65);
        imagesList.add(66,iv66);
        imagesList.add(67,iv67);
        imagesList.add(68,iv68);
        imagesList.add(69,iv69);
        imagesList.add(70,iv70);
        imagesList.add(71,iv71);
        imagesList.add(72,iv72);
        imagesList.add(73,iv73);
        imagesList.add(74,iv74);
        imagesList.add(75,iv75);
        imagesList.add(76,iv76);
        imagesList.add(77,iv77);
        imagesList.add(78,iv78);
        imagesList.add(79,iv79);
        imagesList.add(80,iv80);
        imagesList.add(81,iv81);
        imagesList.add(82,iv82);
        imagesList.add(83,iv83);
        imagesList.add(84,iv84);
        imagesList.add(85,iv85);
        imagesList.add(86,iv86);
        imagesList.add(87,iv87);
        imagesList.add(88,iv88);
        imagesList.add(89,iv89);
        imagesList.add(90,iv90);
        imagesList.add(91,iv91);
        imagesList.add(92,iv92);
        imagesList.add(94,iv94);
        imagesList.add(95,iv95);
        imagesList.add(96,iv96);
        imagesList.add(97,iv97);
        imagesList.add(98,iv98);
        imagesList.add(99,iv99);
        imagesList.add(100,iv100);
        imagesList.add(101,iv101);
        imagesList.add(102,iv102);
        imagesList.add(103,iv103);
        imagesList.add(104,iv104);
        imagesList.add(105,iv105);
        imagesList.add(106,iv106);
        imagesList.add(107,iv107);
        imagesList.add(108,iv108);
        imagesList.add(109,iv109);
        imagesList.add(110,iv110);
        imagesList.add(111,iv111);
        imagesList.add(112,iv112);
        imagesList.add(113,iv113);
        imagesList.add(114,iv114);
        imagesList.add(115,iv115);
        imagesList.add(116,iv116);
        imagesList.add(117,iv117);
        imagesList.add(118,iv118);
        imagesList.add(119,iv119);
        imagesList.add(120,iv120);
        imagesList.add(121,iv121);
        imagesList.add(122,iv122);
        imagesList.add(123,iv123);
        imagesList.add(124,iv124);
        imagesList.add(125,iv125);
        imagesList.add(126,iv126);
        imagesList.add(127,iv127);
        imagesList.add(128,iv128);
        imagesList.add(129,iv129);
        imagesList.add(130,iv130);
        imagesList.add(131,iv131);
        imagesList.add(132,iv132);
        imagesList.add(133,iv133);
        imagesList.add(134,iv134);
        imagesList.add(135,iv135);
        imagesList.add(136,iv136);
        imagesList.add(137,iv137);
        imagesList.add(138,iv138);
        imagesList.add(139,iv139);
        imagesList.add(140,iv140);
        imagesList.add(141,iv352);
        imagesList.add(142,iv812);
        imagesList.add(143,iv1362);

        for (int i = 0, imagesListSize = imagesList.size(); i < imagesListSize; i++) {
            if (imagesList.get(i)!=null) {
                ImageView image = imagesList.get(i);
                image.getDrawable().mutate();
                setListener(image, i, sharedPref);
                image.setTag(1);
            }
        }

        iv812.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (scaleAnim!=null){
                    scaleAnim.cancel();
                    scaleAnimY.cancel();
                }

                for (int i = 0, imagesListSize = imagesList.size(); i < imagesListSize; i++) {
                    if (imagesList.get(i)!=null) {
                        imagesList.get(i).setScaleX(1.0f);
                        imagesList.get(i).setScaleY(1.0f);
                    }
                }

                if(iv81.getTag().equals(1)){

                    if (partsMap != null) {
                        String color = sharedPref.getString(getString(R.string.colorname), "TRANSPARENT");
                        if (color.equals("RED"))  {
                            removeLine(getApplicationContext(), "choosen.txt", 81 + ":" + partsMap.get(String.valueOf(81))+ "!R");
                            writeFileOnInternalStorage(getApplicationContext(), "choosen.txt", 81 + ":" + partsMap.get(String.valueOf(81)) + "!B" + "\n", true);
                        } else{
                            removeLine(getApplicationContext(), "choosen.txt", 81 + ":" + partsMap.get(String.valueOf(81))+ "!B");
                            writeFileOnInternalStorage(getApplicationContext(), "choosen.txt", 81 + ":" + partsMap.get(String.valueOf(81)) + "!R" +  "\n", true);
                        }
                    }

                    String color = sharedPref.getString(getString(R.string.colorname), "TRANSPARENT");

                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putString(String.valueOf(81), color);
                    editor.putString(String.valueOf(142), color);
                    editor.apply();
                    iv812.getDrawable().setColorFilter(alphaOrange, PorterDuff.Mode.SRC_ATOP);
                    iv812.setTag(2);
                    iv81.getDrawable().setColorFilter(alphaOrange, PorterDuff.Mode.SRC_ATOP);
                    iv81.setTag(2);
                }else{
                    imR.setScaleX(1);
                    imR.setScaleY(1);
                    imB.setScaleX(1);
                    imB.setScaleY(1);
                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putString(String.valueOf(81), "TRANSPARENT");
                    editor.putString(String.valueOf(142), "TRANSPARENT");
                    editor.apply();
                    alphaOrange = adjustAlpha(Color.WHITE, 1);

                    iv81.getDrawable().setColorFilter(alphaOrange, PorterDuff.Mode.SRC_ATOP);
                    iv81.setTag(1);
                    iv812.getDrawable().setColorFilter(alphaOrange, PorterDuff.Mode.SRC_ATOP);
                    iv812.setTag(1);
                    removeLine(getApplicationContext(), "choosen.txt", 81 + ":" + partsMap.get(String.valueOf(81))+ "!B");
                    removeLine(getApplicationContext(), "choosen.txt", 81 + ":" + partsMap.get(String.valueOf(81))+ "!R");

                    String col = sharedPref.getString(String.valueOf(81), "TRANSPARENT");
                    if (col.equals("RED"))  {
                        alphaOrange = adjustAlpha(Color.RED, 50);
                    }
                    if (col.equals("BLUE"))    {
                        alphaOrange = adjustAlpha(Color.BLUE, 50);
                    }
                    if (col.equals("TRANSPARENT"))        {
                        alphaOrange = adjustAlpha(Color.WHITE, 1);
                    }
                }

                Toast.makeText(getApplicationContext(), partsMap.get(String.valueOf(81)), Toast.LENGTH_SHORT).show();
            }
        });

        iv1362.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                if (scaleAnim!=null){
                    scaleAnim.cancel();
                    scaleAnimY.cancel();
                }

                for (int i = 0, imagesListSize = imagesList.size(); i < imagesListSize; i++) {
                    if (imagesList.get(i)!=null) {
                        imagesList.get(i).setScaleX(1.0f);
                        imagesList.get(i).setScaleY(1.0f);
                    }
                }

                if(iv136.getTag().equals(1)){

                    if (partsMap != null) {
                        String color = sharedPref.getString(getString(R.string.colorname), "TRANSPARENT");
                        if (color.equals("RED"))  {
                            removeLine(getApplicationContext(), "choosen.txt", 136 + ":" + partsMap.get(String.valueOf(136))+ "!R");
                            writeFileOnInternalStorage(getApplicationContext(), "choosen.txt", 136 + ":" + partsMap.get(String.valueOf(136)) + "!B" + "\n", true);
                        } else{
                            removeLine(getApplicationContext(), "choosen.txt", 136 + ":" + partsMap.get(String.valueOf(136))+ "!B");
                            writeFileOnInternalStorage(getApplicationContext(), "choosen.txt", 136 + ":" + partsMap.get(String.valueOf(136)) + "!R" +  "\n", true);
                        }

                    }

                    String color = sharedPref.getString(getString(R.string.colorname), "TRANSPARENT");

                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putString(String.valueOf(136), color);
                    editor.putString(String.valueOf(143), color);

                    editor.apply();
                    iv1362.getDrawable().setColorFilter(alphaOrange, PorterDuff.Mode.SRC_ATOP);
                    iv1362.setTag(2);
                    iv136.getDrawable().setColorFilter(alphaOrange, PorterDuff.Mode.SRC_ATOP);
                    iv136.setTag(2);
                }else{
                    imR.setScaleX(1);
                    imR.setScaleY(1);
                    imB.setScaleX(1);
                    imB.setScaleY(1);
                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putString(String.valueOf(136), "TRANSPARENT");
                    editor.putString(String.valueOf(143), "TRANSPARENT");

                    editor.apply();
                    alphaOrange = adjustAlpha(Color.WHITE, 1);

                    iv136.getDrawable().setColorFilter(alphaOrange, PorterDuff.Mode.SRC_ATOP);
                    iv136.setTag(1);
                    iv1362.getDrawable().setColorFilter(alphaOrange, PorterDuff.Mode.SRC_ATOP);
                    iv1362.setTag(1);
                    removeLine(getApplicationContext(), "choosen.txt", 136 + ":" + partsMap.get(String.valueOf(136))+ "!B");
                    removeLine(getApplicationContext(), "choosen.txt", 136 + ":" + partsMap.get(String.valueOf(136))+ "!R");

                    String col = sharedPref.getString(String.valueOf(136), "TRANSPARENT");

                    if (col.equals("RED"))  {
                        alphaOrange = adjustAlpha(Color.RED, 50);
                    }
                    if (col.equals("BLUE"))    {
                        alphaOrange = adjustAlpha(Color.BLUE, 50);
                    }
                    if (col.equals("TRANSPARENT"))        {
                        alphaOrange = adjustAlpha(Color.WHITE, 1);
                    }
                }

                Toast.makeText(getApplicationContext(), partsMap.get(String.valueOf(136)), Toast.LENGTH_SHORT).show();
            }
        });

        iv352.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                if (scaleAnim!=null){
                    scaleAnim.cancel();
                    scaleAnimY.cancel();
                }

                for (int i = 0, imagesListSize = imagesList.size(); i < imagesListSize; i++) {
                    if (imagesList.get(i)!=null) {
                        imagesList.get(i).setScaleX(1.0f);
                        imagesList.get(i).setScaleY(1.0f);
                    }
                }
                if(iv35.getTag().equals(1)){

                    if (partsMap != null) {
                        String color = sharedPref.getString(getString(R.string.colorname), "TRANSPARENT");
                        if (color.equals("RED"))  {
                            removeLine(getApplicationContext(), "choosen.txt", 35 + ":" + partsMap.get(String.valueOf(35))+ "!R");
                            writeFileOnInternalStorage(getApplicationContext(), "choosen.txt", 35 + ":" + partsMap.get(String.valueOf(35)) + "!B" + "\n", true);
                        } else{
                            removeLine(getApplicationContext(), "choosen.txt", 35 + ":" + partsMap.get(String.valueOf(35))+ "!B");
                            writeFileOnInternalStorage(getApplicationContext(), "choosen.txt", 35 + ":" + partsMap.get(String.valueOf(35)) + "!R" +  "\n", true);
                        }

                    }

                    String color = sharedPref.getString(getString(R.string.colorname), "TRANSPARENT");

                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putString(String.valueOf(35), color);
                    editor.putString(String.valueOf(141), color);

                    editor.apply();
                    iv352.getDrawable().setColorFilter(alphaOrange, PorterDuff.Mode.SRC_ATOP);
                    iv352.setTag(2);
                    iv35.getDrawable().setColorFilter(alphaOrange, PorterDuff.Mode.SRC_ATOP);
                    iv35.setTag(2);
                }else{
                    imR.setScaleX(1);
                    imR.setScaleY(1);
                    imB.setScaleX(1);
                    imB.setScaleY(1);
                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putString(String.valueOf(35), "TRANSPARENT");
                    editor.putString(String.valueOf(141), "TRANSPARENT");

                    editor.apply();
                    alphaOrange = adjustAlpha(Color.WHITE, 1);

                    iv35.getDrawable().setColorFilter(alphaOrange, PorterDuff.Mode.SRC_ATOP);
                    iv35.setTag(1);
                    iv352.getDrawable().setColorFilter(alphaOrange, PorterDuff.Mode.SRC_ATOP);
                    iv352.setTag(1);
                    removeLine(getApplicationContext(), "choosen.txt", 35 + ":" + partsMap.get(String.valueOf(35))+ "!B");
                    removeLine(getApplicationContext(), "choosen.txt", 35 + ":" + partsMap.get(String.valueOf(35))+ "!R");

                    String col = sharedPref.getString(String.valueOf(35), "TRANSPARENT");
                    if (col.equals("RED"))  {
                        alphaOrange = adjustAlpha(Color.RED, 50);
                    }
                    if (col.equals("BLUE"))    {
                        alphaOrange = adjustAlpha(Color.BLUE, 50);
                    }
                    if (col.equals("TRANSPARENT"))        {
                        alphaOrange = adjustAlpha(Color.WHITE, 1);
                    }
                }

                Toast.makeText(getApplicationContext(), partsMap.get(String.valueOf(35)), Toast.LENGTH_SHORT).show();
            }
        });

        iv81.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (scaleAnim!=null){
                    scaleAnim.cancel();
                    scaleAnimY.cancel();
                }

                for (int i = 0, imagesListSize = imagesList.size(); i < imagesListSize; i++) {
                    if (imagesList.get(i)!=null) {
                        imagesList.get(i).setScaleX(1.0f);
                        imagesList.get(i).setScaleY(1.0f);
                    }
                }
                if (iv81.getTag().equals(1)){

                    if (partsMap != null) {
                        String color = sharedPref.getString(getString(R.string.colorname), "TRANSPARENT");
                        if (color.equals("RED"))  {
                            removeLine(getApplicationContext(), "choosen.txt", 81 + ":" + partsMap.get(String.valueOf(81))+ "!R");
                            writeFileOnInternalStorage(getApplicationContext(), "choosen.txt", 81 + ":" + partsMap.get(String.valueOf(81)) + "!B" + "\n", true);
                        } else{
                            removeLine(getApplicationContext(), "choosen.txt", 81 + ":" + partsMap.get(String.valueOf(81))+ "!B");
                            writeFileOnInternalStorage(getApplicationContext(), "choosen.txt", 81 + ":" + partsMap.get(String.valueOf(81)) + "!R" +  "\n", true);

                        }
                    }

                    String color = sharedPref.getString(getString(R.string.colorname), "TRANSPARENT");

                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putString(String.valueOf(81), color);
                    editor.putString(String.valueOf(142), color);
                    editor.apply();
                    iv812.getDrawable().setColorFilter(alphaOrange, PorterDuff.Mode.SRC_ATOP);
                    iv812.setTag(2);
                    iv81.getDrawable().setColorFilter(alphaOrange, PorterDuff.Mode.SRC_ATOP);
                    iv81.setTag(2);
                }else{
                    imR.setScaleX(1);
                    imR.setScaleY(1);
                    imB.setScaleX(1);
                    imB.setScaleY(1);
                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putString(String.valueOf(81), "TRANSPARENT");
                    editor.putString(String.valueOf(142), "TRANSPARENT");
                    editor.apply();
                    alphaOrange = adjustAlpha(Color.WHITE, 1);

                    iv81.getDrawable().setColorFilter(alphaOrange, PorterDuff.Mode.SRC_ATOP);
                    iv81.setTag(1);
                    iv812.getDrawable().setColorFilter(alphaOrange, PorterDuff.Mode.SRC_ATOP);
                    iv812.setTag(1);
                    removeLine(getApplicationContext(), "choosen.txt", 81 + ":" + partsMap.get(String.valueOf(81))+ "!B");
                    removeLine(getApplicationContext(), "choosen.txt", 81 + ":" + partsMap.get(String.valueOf(81))+ "!R");

                    String col = sharedPref.getString(String.valueOf(81), "TRANSPARENT");
                    if (col.equals("RED"))  {
                        alphaOrange = adjustAlpha(Color.RED, 50);
                    }
                    if (col.equals("BLUE"))    {
                        alphaOrange = adjustAlpha(Color.BLUE, 50);
                    }
                    if (col.equals("TRANSPARENT"))        {
                        alphaOrange = adjustAlpha(Color.WHITE, 1);
                    }
                }

                Toast.makeText(getApplicationContext(), partsMap.get(String.valueOf(81)), Toast.LENGTH_SHORT).show();
            }
        });

        iv136.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                if (scaleAnim!=null){
                    scaleAnim.cancel();
                    scaleAnimY.cancel();
                }

                for (int i = 0, imagesListSize = imagesList.size(); i < imagesListSize; i++) {
                    if (imagesList.get(i)!=null) {
                        imagesList.get(i).setScaleX(1.0f);
                        imagesList.get(i).setScaleY(1.0f);
                    }
                }

                if(iv136.getTag().equals(1)){

                    if (partsMap != null) {
                        String color = sharedPref.getString(getString(R.string.colorname), "TRANSPARENT");
                        if (color.equals("RED"))  {
                            removeLine(getApplicationContext(), "choosen.txt", 136 + ":" + partsMap.get(String.valueOf(136))+ "!R");
                            writeFileOnInternalStorage(getApplicationContext(), "choosen.txt", 136 + ":" + partsMap.get(String.valueOf(136)) + "!B" + "\n", true);
                        } else{
                            removeLine(getApplicationContext(), "choosen.txt", 136 + ":" + partsMap.get(String.valueOf(136))+ "!B");
                            writeFileOnInternalStorage(getApplicationContext(), "choosen.txt", 136 + ":" + partsMap.get(String.valueOf(136)) + "!R" +  "\n", true);

                        }
                    }

                    String color = sharedPref.getString(getString(R.string.colorname), "TRANSPARENT");

                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putString(String.valueOf(136), color);
                    editor.putString(String.valueOf(143), color);

                    editor.apply();
                    iv1362.getDrawable().setColorFilter(alphaOrange, PorterDuff.Mode.SRC_ATOP);
                    iv1362.setTag(2);
                    iv136.getDrawable().setColorFilter(alphaOrange, PorterDuff.Mode.SRC_ATOP);
                    iv136.setTag(2);
                }else{
                    imR.setScaleX(1);
                    imR.setScaleY(1);
                    imB.setScaleX(1);
                    imB.setScaleY(1);
                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putString(String.valueOf(136), "TRANSPARENT");
                    editor.putString(String.valueOf(143), "TRANSPARENT");

                    editor.apply();
                    alphaOrange = adjustAlpha(Color.WHITE, 1);

                    iv136.getDrawable().setColorFilter(alphaOrange, PorterDuff.Mode.SRC_ATOP);
                    iv136.setTag(1);
                    iv1362.getDrawable().setColorFilter(alphaOrange, PorterDuff.Mode.SRC_ATOP);
                    iv1362.setTag(1);
                    removeLine(getApplicationContext(), "choosen.txt", 136 + ":" + partsMap.get(String.valueOf(136))+ "!B");
                    removeLine(getApplicationContext(), "choosen.txt", 136 + ":" + partsMap.get(String.valueOf(136))+ "!R");

                    String col = sharedPref.getString(String.valueOf(136), "TRANSPARENT");

                    if (col.equals("RED"))  {
                        alphaOrange = adjustAlpha(Color.RED, 50);
                    }
                    if (col.equals("BLUE"))    {
                        alphaOrange = adjustAlpha(Color.BLUE, 50);
                    }
                    if (col.equals("TRANSPARENT"))        {
                        alphaOrange = adjustAlpha(Color.WHITE, 1);
                    }
                }

                Toast.makeText(getApplicationContext(), partsMap.get(String.valueOf(136)), Toast.LENGTH_SHORT).show();
            }
        });

        iv35.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                if (scaleAnim!=null){
                    scaleAnim.cancel();
                    scaleAnimY.cancel();
                }

                for (int i = 0, imagesListSize = imagesList.size(); i < imagesListSize; i++) {
                    if (imagesList.get(i)!=null) {
                        imagesList.get(i).setScaleX(1.0f);
                        imagesList.get(i).setScaleY(1.0f);
                    }
                }

                if(iv35.getTag().equals(1)){

                    if (partsMap != null) {
                        String color = sharedPref.getString(getString(R.string.colorname), "TRANSPARENT");
                        if (color.equals("RED"))  {
                            removeLine(getApplicationContext(), "choosen.txt", 35 + ":" + partsMap.get(String.valueOf(35))+ "!R");
                            writeFileOnInternalStorage(getApplicationContext(), "choosen.txt", 35 + ":" + partsMap.get(String.valueOf(35)) + "!B" + "\n", true);
                        } else{
                            removeLine(getApplicationContext(), "choosen.txt", 35 + ":" + partsMap.get(String.valueOf(35))+ "!B");
                            writeFileOnInternalStorage(getApplicationContext(), "choosen.txt", 35 + ":" + partsMap.get(String.valueOf(35)) + "!R" +  "\n", true);

                        }
                    }

                    String color = sharedPref.getString(getString(R.string.colorname), "TRANSPARENT");

                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putString(String.valueOf(35), color);
                    editor.putString(String.valueOf(141), color);

                    editor.apply();
                    iv352.getDrawable().setColorFilter(alphaOrange, PorterDuff.Mode.SRC_ATOP);
                    iv352.setTag(2);
                    iv35.getDrawable().setColorFilter(alphaOrange, PorterDuff.Mode.SRC_ATOP);
                    iv35.setTag(2);
                }else{
                    imR.setScaleX(1);
                    imR.setScaleY(1);
                    imB.setScaleX(1);
                    imB.setScaleY(1);
                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putString(String.valueOf(35), "TRANSPARENT");
                    editor.putString(String.valueOf(141), "TRANSPARENT");

                    editor.apply();
                    alphaOrange = adjustAlpha(Color.WHITE, 1);

                    iv35.getDrawable().setColorFilter(alphaOrange, PorterDuff.Mode.SRC_ATOP);
                    iv35.setTag(1);
                    iv352.getDrawable().setColorFilter(alphaOrange, PorterDuff.Mode.SRC_ATOP);
                    iv352.setTag(1);
                    removeLine(getApplicationContext(), "choosen.txt", 35 + ":" + partsMap.get(String.valueOf(35))+ "!B");
                    removeLine(getApplicationContext(), "choosen.txt", 35 + ":" + partsMap.get(String.valueOf(35))+ "!R");

                    String col = sharedPref.getString(String.valueOf(35), "TRANSPARENT");
                    if (col.equals("RED"))  {
                        alphaOrange = adjustAlpha(Color.RED, 50);
                    }
                    if (col.equals("BLUE"))    {
                        alphaOrange = adjustAlpha(Color.BLUE, 50);
                    }
                    if (col.equals("TRANSPARENT"))        {
                        alphaOrange = adjustAlpha(Color.WHITE, 1);
                    }
                }

                Toast.makeText(getApplicationContext(), partsMap.get(String.valueOf(35)), Toast.LENGTH_SHORT).show();
            }
        });
        



        imR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                imR.setScaleX(2);
                imR.setScaleY(2);
                imB.setScaleX(1);
                imB.setScaleY(1);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString(getString(R.string.colorname), "RED");
                editor.apply();
                alphaOrange = adjustAlpha(Color.RED, 50);
                for (int i = 0, imagesListSize = imagesList.size(); i < imagesListSize; i++) {
                    if (imagesList.get(i)!=null) {
                        ImageView image = imagesList.get(i);
                        image.getDrawable().mutate();
                        image.setTag(1);
                    }
                }

            }
        });
        imB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imR.setScaleX(1);
                imR.setScaleY(1);
                imB.setScaleX(2);
                imB.setScaleY(2);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString(getString(R.string.colorname), "BLUE");
                editor.apply();
                alphaOrange = adjustAlpha(Color.BLUE, 50);
                for (int i = 0, imagesListSize = imagesList.size(); i < imagesListSize; i++) {
                    if (imagesList.get(i)!=null) {
                        ImageView image = imagesList.get(i);
                        image.getDrawable().mutate();

                        image.setTag(1);
                    }
                }

            }
        });

        buttonClean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imR.setScaleX(1);
                imR.setScaleY(1);
                imB.setScaleX(1);
                imB.setScaleY(1);
                alphaOrange = adjustAlpha(Color.WHITE, 1);
                for (int i = 0, imagesListSize = imagesList.size(); i < imagesListSize; i++) {
                    if (imagesList.get(i)!=null) {
                        ImageView image = imagesList.get(i);
                        image.getDrawable().setColorFilter(alphaOrange, PorterDuff.Mode.SRC_ATOP);
                        SharedPreferences.Editor editor = sharedPref.edit();
                        editor.putString(String.valueOf(i), "TRANSPARENT");
                        editor.apply();
                        writeFileOnInternalStorage(getApplicationContext(), "choosen.txt", "", false);
                    }
                }
               // alphaOrange = adjustAlpha(Color.WHITE, 1);

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

        buttonEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              smallDialog(dialog,sharedPref);
            }
        });


        if (message != null) {
          //  if (message .equals("toScheme")) {
                for (int i = 0, imagesListSize = imagesList.size(); i < imagesListSize; i++) {
                    if (imagesList.get(i)!=null) {
                        ImageView image = imagesList.get(i);
                        image.getDrawable().mutate();
                        image.setTag(2);
                    }
                }
              if (!message .equals("toScheme")) {
                  final ImageView anim = imagesList.get(Integer.parseInt(message));
//                  anim.animate().setDuration(500).alpha(0)
//                          .withEndAction(new Runnable() {
//                              @Override
//                              public void run() {

//                                  anim.animate().setDuration(500).alpha(1);
//                              }
//                          });


                  scaleAnim = ObjectAnimator.ofFloat(anim, "scaleX", 1.0f, 2.0f);
                  scaleAnimY = ObjectAnimator.ofFloat(anim, "scaleY", 1.0f, 2.0f);

                  scaleAnim.setDuration(500);
                  scaleAnim.setRepeatCount(ValueAnimator.INFINITE);
                  scaleAnim.setRepeatMode(ValueAnimator.REVERSE);
                  scaleAnim.start();
                  scaleAnimY.setDuration(500);
                  scaleAnimY.setRepeatCount(ValueAnimator.INFINITE);
                  scaleAnimY.setRepeatMode(ValueAnimator.REVERSE);
                  scaleAnimY.start();

//                  Animation animBlink = AnimationUtils.loadAnimation(getApplicationContext(),
//                          R.anim.blink);
//                  anim.setVisibility(View.VISIBLE);
//                  anim.startAnimation(animBlink);


              }



//            TextView dialogText = (TextView) dialog.findViewById(R.id.dialogText);
//
//            System.out.println(message);
//            if (message.equals("1")){
//                System.out.println("test1");
//                dialogText.setText("Выберите цвет для " + partsMap.get(message));
//                smallDialog(iv1, dialog);
//            }
//            if (message.equals("2")){
//                System.out.println("test2");
//                dialogText.setText("Выберите цвет для " + partsMap.get(message));
//                smallDialog(iv2, dialog);
//            }
//            if (message.equals("3")){
//                System.out.println("test3");
//                dialogText.setText("Выберите цвет для " + partsMap.get(message));
//                smallDialog(iv3, dialog);
//            }
//            if (message.equals("4")){
//                System.out.println("test4");
//                dialogText.setText("Выберите цвет для " + partsMap.get(message));
//                smallDialog(iv4, dialog);
//            }
//            if (message.equals("5")){
//                System.out.println("test5");
//                dialogText.setText("Выберите цвет для " + partsMap.get(message));
//                smallDialog(iv5, dialog);
//            }

        }

    }

    public void smallDialog(final Dialog dialog, final SharedPreferences sharedPreferences) {
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
        final EditText editText = dialog.findViewById(R.id.editTextTextPersonName);
        editText.setText("");
        try {
            if (sharedPreferences.getBoolean("isSaved",false)) {
                for (String s:parseList2()) {
                    editText.append(s);
                    editText.append("\n");
                }            }
            else {
                for (String s:parseListRaw()) {
                    editText.append(s);
                    editText.append("\n");
                }            }
        } catch (IOException e) {
            e.printStackTrace();
        }



        Button saveList = (Button) dialog.findViewById(R.id.saveList);
        saveList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeListToInternalStorage(getApplicationContext(),"list.txt", String.valueOf(editText.getText()),false);
                try {
                    if (sharedPreferences.getBoolean("isSaved",false)) {
                        partsMap = parseList();
                    }else {
                        partsMap = parseListold();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("isSaved", true);
                editor.apply();
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

    public void writeListToInternalStorage(Context mcoContext, String sFileName, String sBody, boolean append) {
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

    public void removeLine(Context mcoContext, String sFileName, String row) {

        ArrayList<String> buf = new ArrayList<>();
        File dir = new File(mcoContext.getFilesDir(), "list");
        FileInputStream is;
        BufferedReader reader;
        final File file = new File(dir, sFileName);

        try {
            if (file.exists()) {
                is = new FileInputStream(file);
                reader = new BufferedReader(new InputStreamReader(is));

                for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                    if (!line.equals(row)) buf.add(line);
                }
            }
            writeFileOnInternalStorage(getApplicationContext(), "choosen.txt", "", false);

            for (int i = 0; i < buf.size(); i++) {
                String el = buf.get(i);
                writeFileOnInternalStorage(getApplicationContext(), "choosen.txt", el + "\n", true);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setListener(final ImageView v, final int partNr, final SharedPreferences sharedPref) {

        String col = sharedPref.getString(String.valueOf(partNr), "TRANSPARENT");
        if (col.equals("RED"))  {
            alphaOrange = adjustAlpha(Color.RED, 50);
            v.getDrawable().setColorFilter(alphaOrange, PorterDuff.Mode.SRC_ATOP);

        }
        if (col.equals("BLUE"))    {
            alphaOrange = adjustAlpha(Color.BLUE, 50);
            v.getDrawable().setColorFilter(alphaOrange, PorterDuff.Mode.SRC_ATOP);

        }
        if (col.equals("TRANSPARENT"))        {
            alphaOrange = adjustAlpha(Color.WHITE, 1);
            v.getDrawable().setColorFilter(alphaOrange, PorterDuff.Mode.SRC_ATOP);

        }


        v.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                if (scaleAnim!=null){
                    scaleAnim.cancel();
                    scaleAnimY.cancel();
                }

                for (int i = 0, imagesListSize = imagesList.size(); i < imagesListSize; i++) {
                    if (imagesList.get(i)!=null) {
                        imagesList.get(i).setScaleX(1.0f);
                        imagesList.get(i).setScaleY(1.0f);
                    }
                }


                if(v.getTag().equals(1)){
                    if (partsMap != null) {
                        String color = sharedPref.getString(getString(R.string.colorname), "TRANSPARENT");
                        if (color.equals("RED"))  {
                            removeLine(getApplicationContext(), "choosen.txt", partNr + ":" + partsMap.get(String.valueOf(partNr))+ "!R");
                            writeFileOnInternalStorage(getApplicationContext(), "choosen.txt", partNr + ":" + partsMap.get(String.valueOf(partNr)) + "!B" +   "\n", true);
                        }
                        if (color.equals("BLUE"))  {
                            removeLine(getApplicationContext(), "choosen.txt", partNr + ":" + partsMap.get(String.valueOf(partNr))+ "!B");
                            writeFileOnInternalStorage(getApplicationContext(), "choosen.txt", partNr + ":" + partsMap.get(String.valueOf(partNr)) + "!R" +   "\n", true);
                        }

                    }

                    String color = sharedPref.getString(getString(R.string.colorname), "TRANSPARENT");

                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putString(String.valueOf(partNr), color);
                    editor.apply();

                    v.getDrawable().setColorFilter(alphaOrange, PorterDuff.Mode.SRC_ATOP);

                    v.setTag(2);
                    System.out.println("Choosed");
                }else{
                    imR.setScaleX(1);
                    imR.setScaleY(1);
                    imB.setScaleX(1);
                    imB.setScaleY(1);
                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putString(String.valueOf(partNr), "TRANSPARENT");
                    editor.putString(getString(R.string.colorname), "TRANSPARENT");
                    editor.apply();
                    alphaOrange = adjustAlpha(Color.WHITE, 1);

                    v.getDrawable().setColorFilter(alphaOrange, PorterDuff.Mode.SRC_ATOP);

                    v.setTag(1);
                    System.out.println("UnChoosed");

                    removeLine(getApplicationContext(), "choosen.txt", partNr + ":" + partsMap.get(String.valueOf(partNr))+ "!B");
                    removeLine(getApplicationContext(), "choosen.txt", partNr + ":" + partsMap.get(String.valueOf(partNr))+ "!R");

                    String col = sharedPref.getString(String.valueOf(partNr), "TRANSPARENT");
                    if (col.equals("RED"))  {
                        alphaOrange = adjustAlpha(Color.RED, 50);

                    }
                    if (col.equals("BLUE"))    {
                        alphaOrange = adjustAlpha(Color.BLUE, 50);

                    }
                    if (col.equals("TRANSPARENT"))        {
                        alphaOrange = adjustAlpha(Color.WHITE, 1);

                    }
                }

                Toast.makeText(getApplicationContext(), partsMap.get(String.valueOf(partNr)), Toast.LENGTH_SHORT).show();
            }
        });
    }


    public HashMap<String, String> parseListold() throws IOException {
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


    public HashMap<String, String> parseList() throws IOException {
        File dir = new File(getApplicationContext().getFilesDir(), "list");
        File gpxfile = new File(dir, "list.txt");
        HashMap<String, String> map = new HashMap<String, String>();

        String line;
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(gpxfile)));
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

        reader.close();
        return map;
    }

    public ArrayList<String> parseListRaw() throws IOException {
        InputStream fileInputStream = getResources().openRawResource(R.raw.list);
        HashMap<String, String> map = new HashMap<String, String>();

        String line;
        BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream));
        ArrayList<String> list = new ArrayList<>();


        while ((line = reader.readLine()) != null) {
            list.add(line);
        }

//    for (String key : map.keySet())
//    {
//        System.out.println("_"+key + "=>" + map.get(key)+"_");
//    }
        reader.close();
        return list;
    }

    public ArrayList<String> parseList2() throws IOException {
        File dir = new File(getApplicationContext().getFilesDir(), "list");
        File gpxfile = new File(dir, "list.txt");
        ArrayList<String> list = new ArrayList<>();

        String line;
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(gpxfile)));
        while ((line = reader.readLine()) != null) {
            list.add(line);
        }

//    for (String key : map.keySet())
//    {
//        System.out.println("_"+key + "=>" + map.get(key)+"_");
//    }
        reader.close();
        return list;
    }
}