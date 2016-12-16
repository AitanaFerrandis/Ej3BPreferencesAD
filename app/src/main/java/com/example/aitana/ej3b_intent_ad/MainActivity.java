package com.example.aitana.ej3b_intent_ad;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnAlmacena;
    EditText editxtNombre, editxtDNI, editxtFN;
    RadioButton rbHombre, rbMujer;

    //creamos el archivo donde vamos a guardar las preferencias
    static final String PREFS = "My preferences";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editxtDNI = (EditText) findViewById(R.id.editxtDNI);
        editxtFN = (EditText) findViewById(R.id.editxtFN);
        editxtNombre = (EditText) findViewById(R.id.editxtNombre);
        btnAlmacena = (Button) findViewById(R.id.btnAlmacena);
        rbHombre = (RadioButton) findViewById(R.id.rbHombre);
        rbMujer = (RadioButton) findViewById(R.id.rbMujer);


        btnAlmacena.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               //cuando le damos al botón almacena comprueba que todos los datos están rellenados, si es así, llama al método guardaPreferencias();
                //de lo contrario muestra un mensaje para que se rellenen todos
                if (editxtDNI.getText().toString().equals("")
                    || editxtFN.getText().toString().equals("")
                    || editxtNombre.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Deben estar todos los campos rellenados, gracias.", Toast.LENGTH_SHORT).show();
                }else{
                    guardaPreferencias();
                }
            }
        });
    }

    //el método guardaPreferencias crea el sharedPreferences y le pasa el archivo donde guardarlo y lo pone en modo privado
    public void guardaPreferencias(){
        SharedPreferences mySharedPreferences = getSharedPreferences(PREFS, Activity.MODE_PRIVATE);
        //guardamos todas las preferencias con el editor
        SharedPreferences.Editor editor = mySharedPreferences.edit();
        editor.putString("Nombre",editxtNombre.getText().toString());
        editor.putString("Fecha de nacimiento", editxtFN.getText().toString());
        editor.putString("DNI", editxtDNI.getText().toString());
        //comprobamos cual de los dos está seleccionado y según el que sea mandamos una información u otra
        if(rbHombre.isChecked()){
            editor.putString("Sexo", "Hombre");
        }else if (rbMujer.isChecked()){
            editor.putString("Sexo", "Mujer");
        }
        //actualizamos el fichero y con el intent vamos al subActivity
        editor.commit();
        Intent i = new Intent(getApplicationContext(), SubActivity.class);
        startActivity(i);

    }


}
