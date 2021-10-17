package com.example.scriptureprompt;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class ScripturePrompt extends AppCompatActivity {

    private EditText bookId;
    private EditText chapterId;
    private EditText verseId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Called when the user taps the Submit Button*/
    public void submitScripture(View view){
        //Intent for next activity
        Intent intent = new Intent(this, ScriptureDisplay.class);

        String book = bookId.getText().toString();
        String chapter = chapterId.getText().toString();
        String verse = verseId.getText().toString();

        intent.putExtra("BOOK", book);
        intent.putExtra("CHAPTER", chapter);
        intent.putExtra("VERSE", verse);

        Log.d(this.getLocalClassName(), "About to create intent with" + book + " " + chapter + ": "
                + verse + ".");

        startActivity(intent);
    }

    public void loadScripture(View view) {
        // Get a shared preferences handle for the application
        SharedPreferences sharedPref = getSharedPreferences(
                "Scripture.txt", Context.MODE_PRIVATE);

        // Get the configuration values
        String book = sharedPref.getString("BOOK", "");
        String chapter = sharedPref.getString("CHAPTER", "");
        String verse = sharedPref.getString("VERSE", "");

        // Populate the Text Fields
        bookId.setText(book);
        chapterId.setText(chapter);
        verseId.setText(verse);

    }

}