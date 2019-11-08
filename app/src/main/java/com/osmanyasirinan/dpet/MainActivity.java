package com.osmanyasirinan.dpet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, EditText.OnEditorActionListener {

    EditText et;
    TextView tv;
    Button btn;
    public String petname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        File f = new File(this.getFilesDir(), "petname");

        if (f.exists()){
            Intent i = new Intent(MainActivity.this, gameActivity.class);
            startActivity(i);
            finish();
        }

        et = (EditText) findViewById(R.id.isimGiris);
        tv = (TextView) findViewById(R.id.textView);
        btn = (Button) findViewById(R.id.button);

        btn.setOnClickListener(this);
        et.setOnEditorActionListener(this);
    }

    @Override
    public void onClick(View view){
        if (et.getText().toString() != null){
            petname = et.getText().toString();

            try{
                FileOutputStream fos = openFileOutput("petname", Context.MODE_PRIVATE);
                fos.write(petname.getBytes());
                fos.close();

                FileOutputStream canf = openFileOutput("petcan", Context.MODE_PRIVATE);
                canf.write(50);
                canf.close();

                FileOutputStream gucf = openFileOutput("petguc", Context.MODE_PRIVATE);
                gucf.write(20);
                canf.close();

                FileOutputStream paraf = openFileOutput("petpara", Context.MODE_PRIVATE);
                paraf.write(10);
                paraf.close();
            }catch (Exception e){
                e.printStackTrace();
            }

            Intent i = new Intent(MainActivity.this, gameActivity.class);
            startActivity(i);
            finish();

            closeKeyboard();
        }
    }

    @Override
    public boolean onEditorAction(TextView tx, int x, KeyEvent ke){
        if (et.getText().toString() != null){
            petname = et.getText().toString();

            try{
                FileOutputStream fos = openFileOutput("petname", Context.MODE_PRIVATE);
                fos.write(petname.getBytes());
                fos.close();
            }catch (Exception e){
                e.printStackTrace();
            }

            Intent i = new Intent(MainActivity.this, gameActivity.class);
            startActivity(i);
            finish();

            closeKeyboard();
        }

        return true;
    }

    private void closeKeyboard(){
        View v = this.getCurrentFocus();
        if (v != null){
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
        }
    }
}
