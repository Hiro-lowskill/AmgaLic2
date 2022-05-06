package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class autoriz extends AppCompatActivity {
    private EditText edEmail, edSecName;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autoriz);
        init();
    }

    @Override
    protected void onStart(){
        super.onStart();
        FirebaseUser cUser = mAuth.getCurrentUser();
        if(cUser != null){
            Toast.makeText(this,"User not null", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"User null", Toast.LENGTH_SHORT).show();
        }
    }

    private void init(){
        edEmail = findViewById(R.id.edEmail);
        edSecName = findViewById(R.id.edSecName);
        mAuth = FirebaseAuth.getInstance();
    }
    public void OnClickSignUp(View view){
        if(!TextUtils.isEmpty(edEmail.getText().toString()) && !TextUtils.isEmpty(edSecName.getText().toString())) {
            mAuth.createUserWithEmailAndPassword(edEmail.getText().toString(),edSecName.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(getApplicationContext(),"User Sign Up", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"User not Sign Up", Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }
        else{
            Toast.makeText(getApplicationContext(),"Please write", Toast.LENGTH_SHORT).show();
        }
    }
}