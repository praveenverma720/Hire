package com.omnify.hire;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.FragmentManager;

public class MainActivity extends AppCompatActivity {
Button btnr,btnq,btnm,btnstart,btnstop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnr=(Button)findViewById(R.id.btnr);
        btnq = (Button) findViewById(R.id.btnq);
        btnm = (Button)findViewById(R.id.btnm);

    }
       public void ChangeFragment(View view)
    {
        Fragment fragment;
        if(view == btnr)
        {

            fragment = new frandom();
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.output1,fragment);
            ft.commit();
        }
        if(view == btnq)
        {

            fragment = new fsort();
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.output1,fragment);
            ft.commit();
        }
        if(view == btnm)
        {

            fragment = new fmerge();
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.output1,fragment);
            ft.commit();
        }

    }
    }
