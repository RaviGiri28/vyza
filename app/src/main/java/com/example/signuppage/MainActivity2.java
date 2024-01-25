package com.example.signuppage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    EditText Username2, Password2;
    Button Login;
    TextView Logtxt;
    ProgressBar Logprogress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Username2 = findViewById(R.id.usernameeditsignin);
        Password2 = findViewById(R.id.passwordedit2);
        Login = findViewById(R.id.Loginbtn);
        Logtxt = findViewById(R.id.textlogin);
        Logprogress=findViewById(R.id.LogProgress);

        Logtxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailedit, Passwordedit;

                emailedit = String.valueOf(Username2.getText());
                Passwordedit = String.valueOf(Password2.getText());

                if (TextUtils.isEmpty(emailedit)) {
                    Toast.makeText(MainActivity2.this, "Enter your Email or Username", Toast.LENGTH_SHORT).show();
                    Username2.setError("Username or Email Is Required");
                    Username2.requestFocus();
                } else if (!Patterns.EMAIL_ADDRESS.matcher(emailedit).matches()) {
                    Toast.makeText(MainActivity2.this, "Please Re-enter your email", Toast.LENGTH_SHORT).show();
                    Username2.setError("Valid Email is Required");
                    Username2.requestFocus();

                } else if (TextUtils.isEmpty(Passwordedit)) {
                    Toast.makeText(MainActivity2.this, "Enter your password", Toast.LENGTH_SHORT).show();
                    Password2.setError("Password is Required");
                    Password2.requestFocus();
                }  else if (Passwordedit.length() < 8) {
                    Toast.makeText(MainActivity2.this, "Password Should be atleast 8 digits", Toast.LENGTH_SHORT).show();
                    Password2.setError("Password is Too Weak");
                    Password2.requestFocus();

                } else {
                        Logprogress.setVisibility(View.VISIBLE);
                        loginuser(emailedit,Passwordedit);
                }
            }
        });
    }

    private void loginuser(String emailedit, String passwordedit) {
    }
}
