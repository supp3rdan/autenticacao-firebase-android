package com.danrley.projetofirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Cadastro extends AppCompatActivity {
    private FirebaseAuth usuario = FirebaseAuth.getInstance();
    EditText etEmail, etSenha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        etEmail = findViewById(R.id.etEmail);
        etSenha = findViewById(R.id.etSenha);
    }

    public void criarUsuario(View view){
        String email = etEmail.getText().toString();
        String senha = etSenha.getText().toString();
        //Cadastro de usuario
        usuario.createUserWithEmailAndPassword(email, senha)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Log.i("CreateUser", "Sucesso ao cadastrar usuário!");

                            Toast.makeText(getApplicationContext(), "Usuário criado com sucesso", Toast.LENGTH_SHORT).show();
                            finish();

                        } else {
                            Log.i("CreateUser", "Erro ao cadastrar usuário!");
                            Toast.makeText(getApplicationContext(), "Algo deu errado", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }

}