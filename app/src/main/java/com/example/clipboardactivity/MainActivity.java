package com.example.clipboardactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity
{
    EditText textbox, pastebox;
    Button copy,paste,clear,cut;
    private ClipboardManager myClipboard;
    private ClipData myClip;

        @Override
        protected void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            textbox = (EditText) findViewById(R.id.et1);
            pastebox = (EditText) findViewById(R.id.et2);
            copy = (Button) findViewById(R.id.copy);
            paste = (Button) findViewById(R.id.paste);
            clear = (Button) findViewById(R.id.clear);
            cut = (Button) findViewById(R.id.cut);

            myClipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);

            copy.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View v)
                {
                    String text;
                    text = textbox.getText().toString();

                    myClip = ClipData.newPlainText("text", text);
                    myClipboard.setPrimaryClip(myClip);

                    Toast.makeText(getApplicationContext(), "Text Copied",
                            Toast.LENGTH_SHORT).show();
                }
            });

            paste.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View v) {
                    ClipData abc = myClipboard.getPrimaryClip();
                    ClipData.Item item = abc.getItemAt(0);

                    String text = item.getText().toString();
                    pastebox.setText(text);

                    Toast.makeText(getApplicationContext(), "Text Pasted",
                            Toast.LENGTH_SHORT).show();
                }
            });
            clear.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    textbox.setText("");
                    pastebox.setText("");

                }
            });
            cut.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    String text1;
                    text1=textbox.getText().toString();
                    myClip = ClipData.newPlainText("text1", text1);
                    myClipboard.setPrimaryClip(myClip);

                    Toast.makeText(getApplicationContext(), "Text Cut",
                            Toast.LENGTH_SHORT).show();
                    textbox.setText("");

                }
            });
        }

    }