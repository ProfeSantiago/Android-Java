package com.example.administrador.camarabasica;

import android.Manifest;
import android.app.Activity;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Principal extends AppCompatActivity {

    private static final int SOLICITUD_DE_CAMARA = 1888;
    private static final int CODIGO_PERMISO_CAMARA = 100;
    private ImageView elImageView;
    Button Camara_Btn;
    private String laRutaDeLaFoto;

    private File creArchivoImagen() throws IOException {
        String laFecha =
                new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String elNombreDeLaImagen = "LaFoto" + laFecha;

        File laCarpeta = Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES);

        File image = File.createTempFile(elNombreDeLaImagen,".jpg",laCarpeta);
        laRutaDeLaFoto = "file:" + image.getAbsolutePath();
        return image;
    }//Fin creArchivoImagen ----------------------------

    private void RevisaCamara(Context context) {
        if (context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)){
            Toast.makeText(this, "Cámara detectada", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "No se detectó la Cámara",
                    Toast.LENGTH_LONG).show();
        }
    }// Fin RevisaCamara ----------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        RevisaCamara(this);

        elImageView = (ImageView) findViewById(R.id.elImageView);
        Camara_Btn=(Button) findViewById(R.id.Camara_Btn);

        Camara_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkSelfPermission(Manifest.permission.CAMERA) !=
                        PackageManager.PERMISSION_GRANTED) {

                    requestPermissions(new String[]{ Manifest.permission.CAMERA,
                                    Manifest.permission.WRITE_EXTERNAL_STORAGE},
                            CODIGO_PERMISO_CAMARA);

                } else {
                    Intent elIntentDeCamara = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(elIntentDeCamara, SOLICITUD_DE_CAMARA);
                }
            }
        });// Fin setOnClickListener ----------------------------
    }//Fin onCreate

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == SOLICITUD_DE_CAMARA && resultCode == Activity.RESULT_OK) {
            try {
                Bitmap laFoto = MediaStore.Images.Media.getBitmap(this.getContentResolver(),
                        Uri.parse(laRutaDeLaFoto));
                if (laFoto != null) {
                    elImageView.setImageBitmap(laFoto);
                } else {
                    Toast.makeText(this, "Error Capturando la imagen",
                            Toast.LENGTH_LONG).show();
                }
            } catch (Exception e) {
                Toast.makeText(getApplicationContext(),
                        e.getMessage(),Toast.LENGTH_LONG).show();
            }
        }
    }//Fin onActivityResult

}
