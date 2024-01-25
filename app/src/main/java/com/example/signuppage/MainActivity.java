package com.example.signuppage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button Regbutton;
    EditText Fullname, Username, Password, Email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Regbutton = findViewById(R.id.Regbutton);
        Fullname = findViewById(R.id.Fullnameedit);
        Username = findViewById(R.id.usernameedit);
        Password = findViewById(R.id.passwordedit);
        Email = findViewById(R.id.emailedit);
        Regbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailedit, Passwordedit, Fullnme, usrname;
                emailedit = String.valueOf(Email.getText());
                Passwordedit = String.valueOf(Password.getText());
                Fullnme = String.valueOf(Fullname.getText());
                usrname = String.valueOf(Username.getText());



                if (TextUtils.isEmpty(emailedit)) {
                    Toast.makeText(MainActivity.this, "Enter your email", Toast.LENGTH_SHORT).show();
                    Email.setError("Email is Required");
                    Email.requestFocus();
                } else if (!Patterns.EMAIL_ADDRESS.matcher(emailedit).matches()) {
                    Toast.makeText(MainActivity.this, "Please Re-enter your email", Toast.LENGTH_SHORT).show();
                    Email.setError("Valid Email is Required");
                    Email.requestFocus();
                } else if (TextUtils.isEmpty(Passwordedit)) {
                    Toast.makeText(MainActivity.this, "Enter your password", Toast.LENGTH_SHORT).show();
                    Password.setError("Password is Required");
                    Password.requestFocus();
                } else if (Passwordedit.length() < 8) {
                    Toast.makeText(MainActivity.this, "Password Should be atleast 8 digits", Toast.LENGTH_SHORT).show();
                    Password.setError("Password is Too Weak");
                    Password.requestFocus();
                } else if (TextUtils.isEmpty(Fullnme)) {
                    Toast.makeText(MainActivity.this, "Enter your Full name", Toast.LENGTH_SHORT).show();
                    Fullname.setError("Full Name is Required");
                    Fullname.requestFocus();
                } else if (TextUtils.isEmpty(usrname)) {
                    Toast.makeText(MainActivity.this, "Enter your username", Toast.LENGTH_SHORT).show();
                    Username.setError("Username is Required");
                    Username.requestFocus();
                } else {

                }
            }
        });
    }

}