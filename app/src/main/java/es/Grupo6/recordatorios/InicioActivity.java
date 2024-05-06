package es.Grupo6.recordatorios;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class InicioActivity extends AppCompatActivity {

    /**
     *
     * Actividad de inicio de sesión
     *
    **/
    private Intent pasaPantallas;

    private Button botonContrasennaOlvidadaInicio;
    private Button botonLoginInicio;
    private Button botonNuevaCuentaInicio;
    protected DataBaseSQL baseDeDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_inicio);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //<-------------------Establecemos la base de datos


        try {

            baseDeDatos = new DataBaseSQL(this);







            System.out.println("@.- Base de datos creada con éxito");
            //======================pruebas bases de datos==================
            //baseDeDatos.eliminarBaseDeDatos();
      //  baseDeDatos.borrarTablas();

        baseDeDatos.mostrarTablas();
        } catch (Exception e) {
            System.out.println("@.-Error 1 Fallo en la creación de la base de datos");

            throw new RuntimeException(e);
        }

        baseDeDatos.mostrarUsuarios();
        //System.out.println("@.- "+baseDeDatos.correoExistenteSiNo("colegas@MiCorreo.es"));






        botonContrasennaOlvidadaInicio= (Button) findViewById(R.id.botonContrasennaOlvidadaInicio);// he olvidado mi contraseña
        botonLoginInicio=(Button) findViewById(R.id.botonLoginInicio);//iniciar sesión
        botonNuevaCuentaInicio=(Button) findViewById(R.id.botonNuevaCuentaInicio); //Se crea una nueva cuneta



        //=================funciones botones========================

        botonContrasennaOlvidadaInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(InicioActivity.this,"En construcción", Toast.LENGTH_LONG).show();


            }
        });

        botonLoginInicio.setOnClickListener(new View.OnClickListener() {//lleva a prinicpal
            @Override
            public void onClick(View v) {
                pasaPantallas = new Intent(InicioActivity.this, PrincipalActivity.class);
                finish();
                startActivity(pasaPantallas);
            }
        });

        botonNuevaCuentaInicio.setOnClickListener(new View.OnClickListener() {//lleva a registro
            @Override
            public void onClick(View v) {
                pasaPantallas= new Intent(InicioActivity.this,RegistrarseActivity.class);
                finish();
                startActivity(pasaPantallas);
            }
        });

    }
}