package com.vinayak09.wsafety;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class EmergencyNumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.emergency_numbers_layout);
        Button policeButton = findViewById(R.id.police_button);
        Button womenhelpline = findViewById(R.id.womenhelpline);
        Button fireButton = findViewById(R.id.fire_button);
        Button ambulanceButton = findViewById(R.id.ambulance_button);
        Button womenhelplineDA = findViewById(R.id.women_button);

        policeButton.setOnClickListener(v -> callEmergencyNumber("100"));
        womenhelpline.setOnClickListener(v -> callEmergencyNumber("1091"));
        fireButton.setOnClickListener(v -> callEmergencyNumber("101"));
        ambulanceButton.setOnClickListener(v -> callEmergencyNumber("108"));
        womenhelplineDA.setOnClickListener(v -> callEmergencyNumber("181"));


    }

    private void callEmergencyNumber(String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phoneNumber));
        startActivity(intent);
    }


}

