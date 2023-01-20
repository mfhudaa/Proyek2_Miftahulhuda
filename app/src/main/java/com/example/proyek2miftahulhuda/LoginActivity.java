package com.example.proyek2miftahulhuda;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class LoginActivity extends AppCompatActivity {
    EditText eNim,ePass;
    Button bLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        eNim = findViewById(R.id.eLoginNim);
        ePass= findViewById(R.id.eLoginPass);
        bLogin= findViewById(R.id.bLogin);
        bLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void  onClick(View view){
                btnLogin();
            }
        });
    }
    public void  btnLogin (){
        String nim,pass;
        nim = eNim.getText().toString();
        pass = ePass.getText().toString();
        if(pass.equals("admin")){
            Toast.makeText(this,"Selamat Datang "+nim,Toast.LENGTH_LONG).show();
            Intent intent = new Intent(LoginActivity.this,UtamaActivity.class);
            intent.putExtra("nim",nim);
            startActivity(intent);
        }else{
            showDialog();
        }
    }
    public void  showDialog(){
        AlertDialog.Builder pesanSalah = new AlertDialog.Builder(this);
        pesanSalah.setTitle("Error!!!");
        pesanSalah
                .setMessage("Maaf, Email atau Password Salah")
                .setIcon(R.drawable.error)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
        AlertDialog alertDialog = pesanSalah.create();
        alertDialog.show();
    }
}