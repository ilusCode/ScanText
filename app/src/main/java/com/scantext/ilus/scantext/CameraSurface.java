package com.scantext.ilus.scantext;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.text.TextBlock;
import com.google.android.gms.vision.text.TextRecognizer;

import java.io.IOException;

public class CameraSurface extends AppCompatActivity {

    SurfaceView cameraView;
    ImageView imageView;
    TextView textView;
    CameraSource cameraSource;
    final int RequestCameraPermissionID = 1001;

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case RequestCameraPermissionID:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                        return;
                    }
                    try {
                        cameraSource.start(cameraView.getHolder());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
        }
    }

    Boolean cbCorreo;
    Boolean cbDireccion;
    Boolean cbEdad;
    Boolean cbNombre;
    Boolean cbFConsulta;
    Boolean cbSala;
    Boolean cbTelefono;
    Boolean cbTodo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_surface);

        cameraView = (SurfaceView) findViewById(R.id.surface_view);
        textView = (TextView) findViewById(R.id.textView);
        final TextRecognizer textRecognizer = new TextRecognizer.Builder(getApplicationContext()).build();
        if (!textRecognizer.isOperational()) {
            Log.w("CameraActivity", "Detector dependencies are not yet available");
        } else {
            cameraSource = new CameraSource.Builder(getApplicationContext(), textRecognizer)
                    .setFacing(CameraSource.CAMERA_FACING_BACK)
                    .setRequestedPreviewSize(1280, 1024)
                    .setRequestedFps(2.0f)
                    .setAutoFocusEnabled(true)
                    .build();
            cameraView.getHolder().addCallback(new SurfaceHolder.Callback() {
                @Override
                public void surfaceCreated(SurfaceHolder holder) {
                    try {
                        if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                            ActivityCompat.requestPermissions(CameraSurface.this,
                                    new String[]{Manifest.permission.CAMERA},
                                    RequestCameraPermissionID);
                            return;
                        }
                        cameraSource.start(cameraView.getHolder());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

                }

                @Override
                public void surfaceDestroyed(SurfaceHolder holder) {
                    cameraSource.stop();
                }
            });
            textRecognizer.setProcessor(new Detector.Processor<TextBlock>() {
                @Override
                public void release() {

                }

                @Override
                public void receiveDetections(Detector.Detections<TextBlock> detections) {
                    final SparseArray<TextBlock> items = detections.getDetectedItems();

                    if (items.size() != 0) {
                        textView.post(new Runnable() {

                            @Override
                            public void run() {
                                final StringBuilder stringBuilder = new StringBuilder();
                                for (int i = 0; i < items.size(); ++i) {
                                    TextBlock item = items.valueAt(i);
                                    stringBuilder.append(item.getValue());
                                    stringBuilder.append(" ");
                                }
                                textView.setText(stringBuilder.toString());

                                cbCorreo = getIntent().getExtras().getBoolean("idCorreo");
                                cbDireccion = getIntent().getExtras().getBoolean("idDireccion");
                                cbEdad = getIntent().getExtras().getBoolean("idEdad");
                                cbFConsulta = getIntent().getExtras().getBoolean("idFConsulta");
                                cbNombre = getIntent().getExtras().getBoolean("idNombre");
                                cbSala = getIntent().getExtras().getBoolean("idSala");
                                cbTelefono = getIntent().getExtras().getBoolean("idTelefono");
                                cbTodo = getIntent().getExtras().getBoolean("idTodo");

                                FloatingActionButton btncap = (FloatingActionButton) findViewById(R.id.fab_Capture);
                                btncap.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        Intent i = new Intent(CameraSurface.this, ViewCamera.class);
                                        i.putExtra("scan", stringBuilder.toString());

                                        i.putExtra("idCorreo", cbCorreo.toString());
                                        i.putExtra("idDireccion", cbDireccion.toString());
                                        i.putExtra("idEdad", cbEdad.toString());
                                        i.putExtra("idFConsulta", cbFConsulta.toString());
                                        i.putExtra("idNombre", cbNombre.toString());
                                        i.putExtra("idSala", cbSala.toString());
                                        i.putExtra("idTelefono", cbTelefono.toString());
                                        i.putExtra("idTodo", cbTodo.toString());

                                        startActivity(i);
                                    }
                                });

                            }
                        });
                    }
                }
            });

        }

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i=new Intent(this,MainActivity.class);
        startActivity(i);
    }
}
