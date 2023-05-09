package com.danrley.projetofirebase;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

public class Home extends AppCompatActivity {
    private FirebaseAuth usuario = FirebaseAuth.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


    }

    public void deslogarUsuario(View view){
        // Desligar usuario
        usuario.signOut();
        finish();
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
}