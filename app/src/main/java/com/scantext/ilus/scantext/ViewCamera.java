package com.scantext.ilus.scantext;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Date;

import static com.scantext.ilus.scantext.Buscar_Datos.busca_Correo;
import static com.scantext.ilus.scantext.Buscar_Datos.busca_Direccion;
import static com.scantext.ilus.scantext.Buscar_Datos.busca_Edad;
import static com.scantext.ilus.scantext.Buscar_Datos.busca_FechaConsulta;
import static com.scantext.ilus.scantext.Buscar_Datos.busca_Nombre;
import static com.scantext.ilus.scantext.Buscar_Datos.busca_Sala;
import static com.scantext.ilus.scantext.Buscar_Datos.busca_Telefono;


public class ViewCamera extends AppCompatActivity {

    String cbCorreo;
    String cbDireccion;
    String cbEdad;
    String cbNombre;
    String cbFConsulta;
    String cbSala;
    String cbTelefono;
    String cbTodo;
    private String bCorreo;
    TextView tv;
    String texto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_camera);

        cbCorreo = getIntent().getStringExtra("idCorreo");
        cbDireccion = getIntent().getStringExtra("idDireccion");
        cbEdad = getIntent().getStringExtra("idEdad");
        cbFConsulta = getIntent().getStringExtra("idFConsulta");
        cbNombre = getIntent().getStringExtra("idNombre");
        cbSala = getIntent().getStringExtra("idSala");
        cbTelefono = getIntent().getStringExtra("idTelefono");
        cbTodo = getIntent().getStringExtra("idTodo");

        tv = (TextView) findViewById(R.id.edittext);
        //tv.setText(getIntent().getExtras().get("scan").toString());
        int banCorreo = 0;
        int banDireccion = 0;
        int banEdad = 0;
        int banFConsulta = 0;
        int banNombre = 0;
        int banSala = 0;
        int banTelefono = 0;
        int banTodo = 0;

        if (cbCorreo.equals("true")) {
            Toast.makeText(getBaseContext(), "Correo", Toast.LENGTH_SHORT).show();
            banCorreo = 1;
        }
        if (cbDireccion.equals("true")) {
            Toast.makeText(getBaseContext(), "Dirección", Toast.LENGTH_SHORT).show();
            banDireccion = 1;
        }

        if (cbEdad.equals("true")) {
            Toast.makeText(getBaseContext(), "Edad", Toast.LENGTH_SHORT).show();
            banEdad = 1;
        }
        if (cbFConsulta.equals("true")) {
            Toast.makeText(getBaseContext(), "Fecha de Consulta", Toast.LENGTH_SHORT).show();
            banFConsulta = 1;
        }
        if (cbNombre.equals("true")) {
            Toast.makeText(getBaseContext(), "Nombre", Toast.LENGTH_SHORT).show();
            banNombre = 1;
        }
        if (cbSala.equals("true")) {
            Toast.makeText(getBaseContext(), "Sala", Toast.LENGTH_SHORT).show();
            banSala = 1;
        }
        if (cbTelefono.equals("true")) {
            Toast.makeText(getBaseContext(), "Telefono", Toast.LENGTH_SHORT).show();
            banTelefono = 1;
        }
        if (cbTodo.equals("true")) {
            Toast.makeText(getBaseContext(), "Todo", Toast.LENGTH_SHORT).show();
            banTodo = 1;
        }

        texto = getIntent().getExtras().get("scan").toString();
        String txt = agregarTexto(texto, banCorreo, banDireccion, banEdad, banFConsulta, banNombre, banSala, banTelefono, banTodo);
        tv.setText(txt);
        FloatingActionButton btnSave = (FloatingActionButton) findViewById(R.id.fab_Save);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tv.getText() != "") {
                    Date horaActual = new Date();
                    Object hora = horaActual.getTime();
                    String filename = "ScanText_" + hora.toString() + ".txt";
                    String str = tv.getText().toString();
                    try {
                        File tarjeta = Environment.getExternalStorageDirectory();
                        File file = new File(tarjeta.getAbsolutePath(), filename);
                        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(file));
                        osw.write(str);
                        osw.flush();
                        osw.close();
                        Switch swCompartir = (Switch) findViewById(R.id.switchCompartir);
                        Boolean switchState = swCompartir.isChecked();
                        if (switchState == true) {
                            file.setReadable(true, false);
                            final Intent intent = new Intent(android.content.Intent.ACTION_SEND);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(file));
                            intent.setType("text/plain");
                            startActivity(intent);
                        }
                        if (switchState == false) {
                            Intent inicio = new Intent(ViewCamera.this, MainActivity.class);
                            startActivity(inicio);
                            tv.setText("");
                        }
                        Toast.makeText(getBaseContext(), "Guardado " + " " + filename, Toast.LENGTH_SHORT).show();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    if (tv.getText() == "") {
                        Toast.makeText(getBaseContext(), "ScanText Error 1", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        tv.setText("");
        Intent i=new Intent(this,CameraSurface.class);
        startActivity(i);
    }
    private String agregarTexto(String texto, int banCorreo, int banDireccion, int banEdad, int banFConsulta, int banNombre, int banSala, int banTelefono, int banTodo) {
        ArrayList<String> txt = new ArrayList<>();
        if (banTodo == 1 && banCorreo == 0 && banDireccion == 0 && banEdad == 0 && banFConsulta == 0 && banNombre == 0 && banSala == 0 && banTelefono == 0) {
            txt.add(texto);
        } else {
            if (banCorreo == 1) {
                String bCorreo = busca_Correo(texto);
                txt.add("Correo: " + bCorreo);

            } else {
                txt.add("");
            }

            if (banDireccion == 1) {
                String bDireccion = busca_Direccion(texto);
                txt.add("Direccion: " + bDireccion);
            } else {
                txt.add("");
            }

            if (banEdad == 1) {
                String bEdad = busca_Edad(texto);
                txt.add("Edad: " + bEdad);
            } else {
                txt.add("");
            }

            if (banFConsulta == 1) {
                String bFConsulta = busca_FechaConsulta(texto);
                txt.add("Fecha de Consulta: " + bFConsulta);
            } else {
                txt.add("");
            }

            if (banNombre == 1) {
                String bNombre = busca_Nombre(texto);
                txt.add("Nombre: " + bNombre);
            } else {
                txt.add("");
            }

            if (banSala == 1) {
                String bSala = busca_Sala(texto);
                txt.add("Sala: " + bSala);
            } else {
                txt.add("");
            }

            if (banTelefono == 1) {
                String bTelefono = busca_Telefono(texto);
                txt.add("Telefono: ");
            } else {
                txt.add("");
            }
        }

        //for (int i = 0; i <= txt.size(); i++) {
        //    txtRespuesta = txtRespuesta + txt.get(i) + "\n";
        //}
        //return txtRespuesta;
        return txt.toString();
    }

    static String txtRespuesta = "";
}
