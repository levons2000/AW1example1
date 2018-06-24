package com.example.levon.levoogle;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.searchbutton);
        editText = findViewById(R.id.urltext);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (editText.getText().toString().startsWith("http://")) {
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(editText.getText().toString()));
                        startActivity(intent);
                    } else {
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(("http://" + editText.getText().toString())));
                        startActivity(intent);
                    }
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(MainActivity.this, "Browsera petq unikum jan", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
