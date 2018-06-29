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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.searchbutton);
        final EditText editText = findViewById(R.id.urltext);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString();
                try {
                    if (text.startsWith("http://")) {
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(text));
                        startActivity(intent);
                    } else {
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(("http://" + text)));
                        startActivity(intent);
                    }
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(MainActivity.this, R.string.exceptiontoast, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
