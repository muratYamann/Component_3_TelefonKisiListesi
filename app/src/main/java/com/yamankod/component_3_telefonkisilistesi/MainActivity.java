package com.yamankod.component_3_telefonkisilistesi;

import android.os.Bundle;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Murat 
 */

public class MainActivity extends Activity {
    private EditText editText;
    private Button button;
    private Intent intent1, intent2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.editText1);
        button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                try {
                    String data = editText.getText().toString();
                    intent1 = new Intent(Intent.ACTION_PICK, Uri.parse(data));
                    startActivityForResult(intent1, 1);
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), e.getMessage(),	Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            switch (requestCode) {
                case 1: {
                    if (resultCode == Activity.RESULT_OK) {
                        String selectedContact = data.getDataString();
                        editText.setText(selectedContact);
                        intent2 = new Intent(Intent.ACTION_VIEW, Uri.parse(selectedContact));
                        startActivity(intent2);
                    } else {
                        editText.setText("Selection CANCELLED " + requestCode + " "	+ resultCode);
                    }
                    break;
                }
            }
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), e.getMessage(),	Toast.LENGTH_LONG).show();
        }
    }
}








