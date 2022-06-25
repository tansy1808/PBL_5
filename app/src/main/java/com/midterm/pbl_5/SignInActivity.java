package com.midterm.pbl_5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignInActivity extends AppCompatActivity {
    private LinearLayout layoutSignUp;
    private EditText edtEmail,edtPassword;
    private Button btnSignIn;
    private ProgressDialog progressDialog;
    private LinearLayout layoutForgotPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        initUi();
        initListener();
    }
    private void initUi() {
        progressDialog = new ProgressDialog(this);

        layoutSignUp = findViewById(R.id.layout_sign_up);
        edtEmail = findViewById(R.id.inputEmail);
        edtPassword = findViewById(R.id.inputPassword);
        btnSignIn = findViewById(R.id.btnLogin);
        layoutForgotPassword = findViewById(R.id.layout_forgot_password);
    }
    private void initListener() {
        layoutSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignInActivity.this,SignUpActivity.class);
                startActivity(intent);
            }
        });
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OnCliclkSignIn();
            }
        });
        layoutForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OnClickForgotPassword();
            }
        });
    }

    private void OnCliclkSignIn() {
        String strEmail = edtEmail.getText().toString().trim();
        String strPassword = edtPassword.getText().toString().trim();
        FirebaseAuth auth = FirebaseAuth.getInstance();
        progressDialog.show();
        auth.signInWithEmailAndPassword(strEmail, strPassword)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if (task.isSuccessful()) {
                            Intent intent = new Intent(SignInActivity.this,MainActivity.class);
                            startActivity(intent);
                            finishAffinity();
                        } else {
                            Toast.makeText(SignInActivity.this, "Error"+ task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
    private void OnClickForgotPassword() {
        progressDialog.show();
        FirebaseAuth auth = FirebaseAuth.getInstance();
        String emailAddress = "nguyentansy1@gmail.com";

        auth.sendPasswordResetEmail(emailAddress)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        progressDialog.dismiss();
                        if (task.isSuccessful()) {
                            Toast.makeText(SignInActivity.this,"Email sent",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}