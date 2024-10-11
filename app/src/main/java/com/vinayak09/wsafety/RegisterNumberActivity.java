package com.vinayak09.wsafety;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterNumberActivity extends AppCompatActivity {

    private static final int MAX_CONTACTS = 5;
    private EditText[] editTextNumbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_number);


        editTextNumbers = new EditText[]{
                findViewById(R.id.numberEdit1),
                findViewById(R.id.numberEdit2),
                findViewById(R.id.numberEdit3),
                findViewById(R.id.numberEdit4),
                findViewById(R.id.numberEdit5)
        };

        loadSavedNumbers();
    }

    private void loadSavedNumbers() {
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        for (int i = 0; i < MAX_CONTACTS; i++) {
            String number = sharedPreferences.getString("ENUM" + i, "");
            editTextNumbers[i].setText(number);
        }
    }

    public void saveNumbers(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        for (int i = 0; i < MAX_CONTACTS; i++) {
            String number = editTextNumbers[i].getText().toString().trim();
            editor.putString("ENUM" + i, number);
        }

        editor.apply();
        Toast.makeText(this, "Contact numbers saved!", Toast.LENGTH_SHORT).show();
        finish();
    }

}
