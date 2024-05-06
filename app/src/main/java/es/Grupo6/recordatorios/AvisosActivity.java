package es.Grupo6.recordatorios;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AvisosActivity extends AppCompatActivity {

    private Button botonAtrasAvisos;
    private Intent pasaPantallas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_avisos);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //======================declaración de variables Layout===================================

        botonAtrasAvisos=(Button)  findViewById(R.id.botonAtrasAvisos);

        //==========código Layout=================

        botonAtrasAvisos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pasaPantallas = new Intent(AvisosActivity.this, PrincipalActivity.class);
                finish();
                startActivity(pasaPantallas);

            }
        });

    }
}