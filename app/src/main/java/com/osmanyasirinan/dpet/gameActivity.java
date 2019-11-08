package com.osmanyasirinan.dpet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStreamReader;

public class gameActivity extends AppCompatActivity implements View.OnClickListener {

    Intent i;
    String petname;
    TextView mesaj;
    TextView canT;
    TextView gucT;
    TextView paraT;
    Button savas;
    Button yemek;
    Button uyu;
    Button kaka;
    Button spor;
    Button home;
    oyun oyun = new oyun();
    ImageView pet;
    ImageView zzz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        try{
            FileInputStream fis = openFileInput("petname");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            petname = br.readLine();

            FileInputStream cant = openFileInput("petcan");
            InputStreamReader canti = new InputStreamReader(cant);
            BufferedReader cantix = new BufferedReader(canti);
            oyun.can = cantix.read();

            FileInputStream guct = openFileInput("petguc");
            InputStreamReader gucti = new InputStreamReader(guct);
            BufferedReader guctix = new BufferedReader(gucti);
            oyun.guc = guctix.read();

            FileInputStream parat = openFileInput("petpara");
            InputStreamReader parati = new InputStreamReader(parat);
            BufferedReader paratix = new BufferedReader(parati);
            oyun.para = paratix.read();

            FileInputStream kilot = openFileInput("petkilo");
            InputStreamReader kiloti = new InputStreamReader(kilot);
            BufferedReader kilotix = new BufferedReader(kiloti);
            oyun.kilo = kilotix.read();
        }catch (Exception e){
            e.printStackTrace();
        }

        mesaj = (TextView) findViewById(R.id.mesaj);
        mesaj.setText("Merhaba, bu " + petname + ". Artık beraber takılacaksınız.");

        canT = (TextView) findViewById(R.id.canT);
        gucT = (TextView) findViewById(R.id.gucT);
        paraT = (TextView) findViewById(R.id.paraT);

        canT.setText(oyun.getCan());
        gucT.setText(oyun.getGuc());
        paraT.setText(oyun.getPara());

        savas = (Button) findViewById(R.id.savas);
        yemek = (Button) findViewById(R.id.yemek);
        uyu = (Button) findViewById(R.id.uyu);
        kaka = (Button) findViewById(R.id.kaka);
        spor = (Button) findViewById(R.id.spor);
        home = (Button) findViewById(R.id.home);

        savas.setOnClickListener(this);
        uyu.setOnClickListener(this);
        yemek.setOnClickListener(this);
        kaka.setOnClickListener(this);
        spor.setOnClickListener(this);
        home.setOnClickListener(this);

        pet = (ImageView) findViewById(R.id.pet);
        zzz = (ImageView) findViewById(R.id.zzz);
    }

    public void degerGuncelle(){
        gucT.setText(oyun.getGuc());
        paraT.setText(oyun.getPara());
        canT.setText(oyun.getCan());
    }

    public void guncelle(){
        File canfile = new File(this.getFilesDir(), "petcan");
        canfile.delete();

        File gucfile = new File(this.getFilesDir(), "petguc");
        gucfile.delete();

        File parafile = new File(this.getFilesDir(), "petpara");
        parafile.delete();

        File kilofile = new File(this.getFilesDir(), "petkilo");
        if (kilofile.exists()){
            kilofile.delete();
        }

        try {
            FileOutputStream canfos = openFileOutput("petcan", Context.MODE_PRIVATE);
            canfos.write(oyun.can);
            canfos.close();

            FileOutputStream gucfos = openFileOutput("petguc", Context.MODE_PRIVATE);
            gucfos.write(oyun.guc);
            gucfos.close();

            FileOutputStream parafos = openFileOutput("petpara", Context.MODE_PRIVATE);
            parafos.write(oyun.para);
            parafos.close();

            FileOutputStream kilofos = openFileOutput("petkilo", Context.MODE_PRIVATE);
            kilofos.write(oyun.kilo);
            kilofos.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v){
        if (v.getId() == savas.getId()){
            if (oyun.kaka == true){
                kaka.setVisibility(View.VISIBLE);
                oyun.kaka = false;
            }

            String savasF = oyun.savas();

            mesaj.setText(petname + savasF);

            if (savasF == " çok uykusu var!"){
                zzz.setVisibility(View.VISIBLE);
            }else if (savasF == " çok aç!"){

            }else {
                pet.setImageResource(R.drawable.petsavas);
                degerGuncelle();
                guncelle();
            }
        }else if (v.getId() == yemek.getId()){
            if (oyun.kaka == true){
                kaka.setVisibility(View.VISIBLE);
                oyun.kaka = false;
            }

            String yemekF = oyun.yemekYe();

            mesaj.setText(petname + yemekF);

            if (yemekF == " çok uykusu var!"){
                zzz.setVisibility(View.VISIBLE);
            }else {
                pet.setImageResource(R.drawable.petyemek);
                degerGuncelle();
                guncelle();
            }
        }else if (v.getId() == uyu.getId()){
            if (oyun.kaka == true){
                kaka.setVisibility(View.VISIBLE);
                oyun.kaka = false;
            }

            String uyuF = oyun.uyu();

            mesaj.setText(petname + uyuF);
            pet.setImageResource(R.drawable.petuyu);
            zzz.setVisibility(View.GONE);
            degerGuncelle();
            guncelle();
        }else if (v.getId() == kaka.getId()){
            kaka.setVisibility(View.GONE);
            oyun.kaka = false;
        }else if (v.getId() == spor.getId()){
            if (oyun.kaka == true){
                kaka.setVisibility(View.VISIBLE);
                oyun.kaka = false;
            }

            String sporF = oyun.sporYap();

            mesaj.setText(petname + sporF);

            if (sporF == " çok uykusu var!"){
                zzz.setVisibility(View.VISIBLE);
            }else if (sporF == " çok aç!"){

            }else {
                pet.setImageResource(R.drawable.petspor);
                degerGuncelle();
                guncelle();
            }
        }else if (v.getId() == home.getId()){
            File f = new File(this.getFilesDir(), "evdurum");

            if (f.exists()){
                Intent i = new Intent(gameActivity.this, homeActivity.class);
                startActivity(i);
            }else {
                String homeF = oyun.buyHome();
                mesaj.setText(homeF);

                if (homeF == "Ev satın alındı!"){
                    try {
                        FileOutputStream homefos = openFileOutput("evdurum", Context.MODE_PRIVATE);
                        String strr = "true";
                        homefos.write(strr.getBytes());
                        homefos.close();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
