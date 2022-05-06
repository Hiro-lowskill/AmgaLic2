package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class authen extends AppCompatActivity {
    private EditText edEmail, edSecName;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authen);
        init();
    }
    private void init(){
        edEmail = findViewById(R.id.edEmail);
        edSecName = findViewById(R.id.edSecName);
        mAuth = FirebaseAuth.getInstance();
    }
    public void OnClickSignIn(View view){
        if(!TextUtils.isEmpty(edEmail.getText().toString()) && !TextUtils.isEmpty(edSecName.getText().toString())) {
            mAuth.signInWithEmailAndPassword(edEmail.getText().toString(),edSecName.getText().toString()).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(getApplicationContext(),"User Sign In", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(authen.this,MainActivity.class);
                        startActivity(i);

                    }
                    else{
                        Toast.makeText(getApplicationContext(),"User not Sign In", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
    public void btn(View view){
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }
}