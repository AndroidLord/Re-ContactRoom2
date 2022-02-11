package com.example.re_contactroom2;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.re_contactroom2.Model.Contact;
import com.example.re_contactroom2.Model.ContactViewModel;

public class CreateContact extends AppCompatActivity {
    private EditText editName, editOccupation;
    private Button saveButton;
    private ContactViewModel contactViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_contact);

        editName = findViewById(R.id.edit_name);
        editOccupation = findViewById(R.id.edit_occupation);
        saveButton = findViewById(R.id.save_button);



        saveButton.setOnClickListener(v -> {
            if (!TextUtils.isEmpty(editName.getText()) && !TextUtils.isEmpty(editOccupation.getText())) {

                String name = editName.getText().toString();
                String occuptaion = editOccupation.getText().toString();

                Contact contact = new Contact(name, occuptaion);

                ContactViewModel.insert(contact);
                Toast.makeText(this, "Succesfully stored", Toast.LENGTH_SHORT).show();
                finish();
            } else {
                Toast.makeText(this, "Enter the number", Toast.LENGTH_SHORT).show();
            }
        });

    }
}