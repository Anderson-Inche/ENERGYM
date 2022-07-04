package com.inche.energymapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.inche.energymapplication.entidad.Clase;
import java.util.UUID;

public class RegistroActivity extends AppCompatActivity {

    EditText txtClase,txtProfesor,txtCupos,txtFecha,txtHora;
    Button buttonRegistrar;
    Clase claseGym;

    FirebaseDatabase database;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        asignarReferencia();
        iniciaFirebase();
    }

    private void iniciaFirebase(){
        FirebaseApp.initializeApp(this);
        database = FirebaseDatabase.getInstance();
        reference = database.getReference();
    }
    private void asignarReferencia(){
        txtClase = findViewById(R.id.txtCurso);
        txtProfesor = findViewById(R.id.txtProfesor);
        txtCupos = findViewById(R.id.txtCupos);
        txtFecha = findViewById(R.id.txtFecha);
        txtHora = findViewById(R.id.txtHora);
        buttonRegistrar = findViewById(R.id.buttonRegistrar);

        buttonRegistrar.setOnClickListener(v -> {
            capturarDatos();
            reference.child("Clase").child(claseGym.getId()).setValue(claseGym);
            Toast.makeText(this, "REGISTRO EXITOSO", Toast.LENGTH_SHORT).show();
        });
    }
    private void capturarDatos(){
        boolean validar = true;
        String descripcion = txtClase.getText().toString();
        String profesor = txtClase.getText().toString();
        String cupos = txtCupos.getText().toString();
        String fecha = txtFecha.getText().toString();
        String hora = txtHora.getText().toString();

        if (descripcion.isEmpty()){
            txtClase.setError("Este campo no puede quedar  vcacio");
            validar = false;
        }
        if(profesor.isEmpty()){
            txtClase.setError("Este campo no puede quedar  vcacio");
            validar = false;
        }
        if(cupos.isEmpty()){
            txtClase.setError("Este campo no puede quedar  vcacio");
            validar = false;
        }
        if(fecha.isEmpty()){
            txtClase.setError("Este campo no puede quedar  vcacio");
            validar = false;
        }
        if(hora.isEmpty()){
            txtClase.setError("Este campo no puede quedar  vcacio");
            validar = false;
        }
        if (validar) {
            int valor = Integer.parseInt(cupos);
            claseGym = new Clase(UUID.randomUUID().toString(), descripcion, profesor, valor, fecha, hora);
        }
    }
}