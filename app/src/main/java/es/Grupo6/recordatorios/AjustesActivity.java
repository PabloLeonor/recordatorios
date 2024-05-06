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

public class AjustesActivity extends AppCompatActivity {

    private Button botonBorrarAjustes;
    private Button botonCerrarSesionAjustes;
    private Button botonAtrasAjustes;
    private Intent pasaPantallas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ajustes);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //===========================declaración de variables Layout========================================================
        botonBorrarAjustes=(Button) findViewById(R.id.botonBorrarAjustes);
        botonCerrarSesionAjustes=(Button) findViewById(R.id.botonCerrarSesionAjustes);
        botonAtrasAjustes =(Button) findViewById(R.id.botonAtrasAjustes);

        //==========código botones=================

        botonBorrarAjustes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AjustesActivity.this, "En construcción", Toast.LENGTH_LONG).show();
            }

            });
        botonCerrarSesionAjustes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AjustesActivity.this,"En construcción", Toast.LENGTH_LONG).show();

            }
        });

        botonAtrasAjustes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pasaPantallas = new Intent(AjustesActivity.this, PrincipalActivity.class);
                finish();
                startActivity(pasaPantallas);

            }
        });
    }
}