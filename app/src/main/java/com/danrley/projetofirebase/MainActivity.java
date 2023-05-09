package com.danrley.projetofirebase;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private DatabaseReference referencia = FirebaseDatabase.getInstance().getReference();
    private FirebaseAuth usuario = FirebaseAuth.getInstance();
    EditText etEmail, etSenha;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etEmail = findViewById(R.id.etEmail);
        etSenha = findViewById(R.id.etSenha);


    }

    public void logarUsuario(View view){
        String email = etEmail.getText().toString();
        String senha = etSenha.getText().toString();
        // logar usuario
        usuario.signInWithEmailAndPassword(email, senha)
                .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Log.i("signIn", "Sucesso logar usuário!");
                            telaHome();

                        } else {
                            Log.i("signIn", "Erro logar usuário!");
                        }
                    }
                });

    }
    public boolean usuarioLogado(View view){
        boolean logado = false;
        //Verificando usuário logado
        if(usuario.getCurrentUser() != null){
            Log.i("LoginUser", "Usuario logado!");
            logado = true;
        } else {
            Log.i("LoginUser", "Usuario não logado!");
        }
        return logado;
    }
    public void deslogarUsuario(View view){
        // Desligar usuario
        usuario.signOut();
    }


    public void telaHome(){
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }

    public void telaCadastro(View view){
        Intent intent = new Intent(this, Cadastro.class);
        startActivity(intent);
    }
}