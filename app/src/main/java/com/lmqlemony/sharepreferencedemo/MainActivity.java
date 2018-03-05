package com.lmqlemony.sharepreferencedemo;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText ET1, ET2;
    private Button button;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ET1 = findViewById(R.id.textView1);
        ET2 = findViewById(R.id.textView2);
        button = findViewById(R.id.button);
        sharedPreferences = getSharedPreferences("lmqsave", 0);
        ET1.setText(sharedPreferences.getString("name", "号"));
        ET2.setText(sharedPreferences.getString("pwd", "密"));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("name", ET1.getText().toString());
                editor.putString("pwd", ET2.getText().toString());
                editor.commit();
                Toast.makeText(MainActivity.this, "保存成功", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
