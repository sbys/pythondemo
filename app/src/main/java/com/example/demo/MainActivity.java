package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initPython();
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callPythonCode();
            }
        });

    }
    private void initPython(){
        if(!Python.isStarted())
            Python.start(new AndroidPlatform(this));
    }
    void callPythonCode(){
        Python py=Python.getInstance();
        Toast.makeText(this, ""+py.getModule("hello").callAttr("add",1,2), Toast.LENGTH_SHORT).show();
    }
}
