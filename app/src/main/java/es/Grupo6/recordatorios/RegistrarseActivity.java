package es.Grupo6.recordatorios;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegistrarseActivity extends AppCompatActivity {
    /**
     *     En RegistrarseAcitity se crea el usuario, contraseña.
     *     aquí se debería cifrar los datos y recosntruirlos en el servidor(servidor online)
     */
    protected Button botonNuevaCuentaRegistrarse;
    protected EditText idUsuarioRegistrarse;
    protected EditText idEmailRegistrarse;
    protected EditText idContrasennaRegistrarse;
    protected EditText idContrasennaCompruebaRegistrarse;
    private Intent pasaPantallas;
    protected DataBaseSQL baseDeDatos;

    private String nombreUsuario;
    private String contraUsuario;
    private String contraUsuarioComprueba;
    private String emailUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registrarse);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //objetos
        CifradoFacil cifrante = new CifradoFacil();

//variables interfaz:
        botonNuevaCuentaRegistrarse=(Button) findViewById(R.id.botonNuevaCuentaRegistrarse);//unico botón, te registras
        idUsuarioRegistrarse=(EditText) findViewById(R.id.idUsuarioRegistrarse);
        idEmailRegistrarse=(EditText) findViewById(R.id.idEmailRegistrarse);
        idContrasennaRegistrarse=(EditText) findViewById(R.id.idContrasennaRegistrarse);
        idContrasennaCompruebaRegistrarse=(EditText) findViewById(R.id.idContrasennaCompruebaRegistrarse);


        //CONEXIÓN BD
        baseDeDatos = new DataBaseSQL(this);
        System.out.println("@.-estás en la BD en RegistrarseActivity");






        //==========================funciones botones================
        botonNuevaCuentaRegistrarse.setOnClickListener(new View.OnClickListener() {//Si alguno de los campos NO se rellena,la cosa falla<-----

            @Override
            public void onClick(View v) {
                //En primer lugar introducimos los datos de los campos

            nombreUsuario= idUsuarioRegistrarse.getText().toString();
            contraUsuario = idContrasennaRegistrarse.getText().toString();
            contraUsuarioComprueba= idContrasennaCompruebaRegistrarse.getText().toString();
            emailUsuario= idEmailRegistrarse.getText().toString();

            //comprobamos si el e-mail es válido viendo si el string introducido contiene un @
                if(!emailUsuario.contains("@") ){
                    Toast.makeText(RegistrarseActivity.this,R.string.textoEmailNoValido, Toast.LENGTH_LONG).show();

                }else if(baseDeDatos.correoExistenteSiNo(emailUsuario)){
                    Toast.makeText(RegistrarseActivity.this,R.string.textoCorreoYaExiste, Toast.LENGTH_LONG).show();
                }
                else if(!contraUsuario.equals(contraUsuarioComprueba)|| contraUsuario.equals("")|| contraUsuarioComprueba.equals("")){
                    Toast.makeText(RegistrarseActivity.this,R.string.textoContrasennaNoValida, Toast.LENGTH_LONG).show();
                }else if(nombreUsuario.equals("")){
                    Toast.makeText(RegistrarseActivity.this,R.string.textoUsuaioNoValido, Toast.LENGTH_LONG).show();

                }
                else {//Si se cumple todo lo anterior, se cifra la contraña y se guarda el usuario y el correo.
                    Toast.makeText(RegistrarseActivity.this,R.string.textoUsuarioCreado, Toast.LENGTH_LONG).show();
                    baseDeDatos.crearUsuario(nombreUsuario,emailUsuario,cifrante.cifradoHASHMD5(contraUsuario));
                    pasaPantallas = new Intent(RegistrarseActivity.this, InicioActivity.class);
                    finish();
                    startActivity(pasaPantallas);

                }
            }
        });


    }

}