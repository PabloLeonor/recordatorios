/*****************
TFG- GRUPO 6
 Aplicación Recordatorio

 Descripción de la apliación:

 Por :
 Marc Badia Botifoll
 Giovanni Lazarte Rivera
 Pablo Leonor Gil
 José Javier Tudela Sáiz
******************/


package es.Grupo6.recordatorios;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    //MainActivity simplemente es un spash que durará 2 segundos donde pasará a PrincipalActivity si hay usuario activo
    //si no,pasará a la pantalla InicioActivity

    //Por hacer aquí, comprobar si el usuario en cuestión existe.

    private Intent pasaPantallas;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });



        //=========================código para pasar a la siguiente pantalla===================
        //como no se ha progremado ningun registro de momento pasa automáticamente al inicio de sesión.
        TimerTask temporizador =new TimerTask() {

            @Override
            public void run() {
                pasaPantallas = new Intent(MainActivity.this, InicioActivity.class);
                finish();
                startActivity(pasaPantallas);

            }
          };
        Timer tiempoDeEspera = new Timer();
        tiempoDeEspera.schedule(temporizador,2000);//<==2 Segundos de tiempo
        }
    }
