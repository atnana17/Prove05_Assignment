package com.example.scriptureprompt;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ScriptureDisplay extends AppCompatActivity {
    private String book;
    private String chapter;
    private String verse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scripture_display);

        Intent intent = getIntent();
        book = intent.getStringExtra("BOOK");
        chapter = intent.getStringExtra("CHAPTER");
        verse = intent.getStringExtra("VERSE");

        String scripture = book + " " + chapter + ": " + verse;
        Log.d(this.getLocalClassName(), "Received intent with " + scripture);
        TextView scriptureObject = findViewById(R.id.textView2);
        scriptureObject.setText(scripture);
    }

    public void saveScripture(View view) {
        // Get a shared preferences handle for the application
        SharedPreferences sharedPref = getSharedPreferences(
                "Scripture.txt", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        // Set the configuration values and commit
        editor.putString("BOOK", book);
        editor.putString("CHAPTER", chapter);
        editor.putString("VERSE", verse);
        editor.apply();

        // Display Toast to User
        Toast.makeText(this, "Scripture Saved", Toast.LENGTH_SHORT).show();
    }
}