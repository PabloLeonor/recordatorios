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

public class PrincipalActivity extends AppCompatActivity {

    /*
    * PrincipalActivity es donde ocurre "el main" del programa, el menú prinicpal vaya, tiene
    * un calendario central que muestra la semana y botones que te llevan a las demás activitys
    * */
    private Button botonOpcionesPrincipal;
    private Button botonAvisosPrincipal;
    private Button botonCompartirPrincipal;
    private Button botonTareasPrincipal;

    private Intent pasaPantallas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_principal);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //===========================declaración de variables Layout========================================================

        botonOpcionesPrincipal=(Button) findViewById(R.id.botonOpcionesPrincipal);
        botonAvisosPrincipal=(Button) findViewById(R.id.botonAvisosPrincipal);
        botonCompartirPrincipal=(Button) findViewById(R.id.botonCompartirPrincipal);
        botonTareasPrincipal=(Button) findViewById(R.id.botonTareasPrincipal);

        //==========código botones=================
        botonOpcionesPrincipal.setOnClickListener(new View.OnClickListener() {//<==ajustes
            @Override
            public void onClick(View v) {
                pasaPantallas = new Intent(PrincipalActivity.this, AjustesActivity.class);

                startActivity(pasaPantallas);

            }
        });

        botonAvisosPrincipal.setOnClickListener(new View.OnClickListener() {//<==avisos
            @Override
            public void onClick(View v) {
                pasaPantallas = new Intent(PrincipalActivity.this, AvisosActivity.class);

                startActivity(pasaPantallas);

            }
        });

        botonCompartirPrincipal.setOnClickListener(new View.OnClickListener() {//<==compartir
            @Override
            public void onClick(View v) {
                Toast.makeText(PrincipalActivity.this,"En construcción", Toast.LENGTH_LONG).show();


            }
        });

        botonTareasPrincipal.setOnClickListener(new View.OnClickListener() {//<==Tareas
            @Override
            public void onClick(View v) {
                Toast.makeText(PrincipalActivity.this,"En construcción", Toast.LENGTH_LONG).show();


            }
        });




    }
}