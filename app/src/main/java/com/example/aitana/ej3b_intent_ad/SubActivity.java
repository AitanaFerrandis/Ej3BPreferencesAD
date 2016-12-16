package com.example.aitana.ej3b_intent_ad;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {

    TextView txtPrefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        txtPrefs = (TextView) findViewById(R.id.txtPrefs);

        //nos creamos otra vez el sharedPreferences y le pasamos el archivo del main activity y ponemos modo privado
        SharedPreferences mySharedPreferences = getSharedPreferences(MainActivity.PREFS, Activity.MODE_PRIVATE);

        //recogemos todos los datos del archivo preferencias
        String nombre = mySharedPreferences.getString("Nombre", "");
        String fechanacim = mySharedPreferences.getString("Fecha de nacimiento", "");
        String dni = mySharedPreferences.getString("DNI","");
        String sexo = mySharedPreferences.getString("Sexo","");

        //mostramos todos los datos que hemos recogido
        txtPrefs.setText("Nombre: "+nombre+"\n"+"Fecha de nacimiento: "+fechanacim+"\n"+"DNI: "+dni+"\n"+"Sexo: "+sexo);


    }

}
