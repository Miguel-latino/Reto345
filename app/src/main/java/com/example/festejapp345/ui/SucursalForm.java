package com.example.festejapp345.ui;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.festejapp345.R;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class SucursalForm extends AppCompatActivity {

    private final int REQUEST_CODE_GALLERY = 999;
    private Button btnInsertar, btnChoose;
    private EditText edtName;
    private TextView tvLocalization;
    private ImageView imgSelected;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sucursal_form);

        btnInsertar = (Button) findViewById(R.id.btnInsertar);
        btnChoose = (Button) findViewById(R.id.btnChoose);
        edtName = (EditText) findViewById(R.id.editName);
        tvLocalization = (TextView) findViewById(R.id.tvLocalization);
        imgSelected = (ImageView) findViewById(R.id.imgSelected);

        btnInsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Insertar", Toast.LENGTH_SHORT).show();
            }
        });

        btnChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityCompat.requestPermissions(
                        SucursalForm.this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        REQUEST_CODE_GALLERY
                );
            }
        });

    }

    @Override
    public  void onRequestPermissionsResult(int requestCode, @NonNull int[] grantResults) {
        if(requestCode  == REQUEST_CODE_GALLERY){
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, REQUEST_CODE_GALLERY);
            }else{
                Toast.makeText(getApplicationContext(), "Sin Permisos", Toast.LENGTH_SHORT).show();
            }
            return;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        if(requestCode == REQUEST_CODE_GALLERY && resultCode == RESULT_OK && data != null){
            Uri uri = data.getData();
            try {
                InputStream inputStream = getContentResolver().openInputStream(uri);
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                imgSelected.setImageBitmap(bitmap);
            }catch (FileNotFoundException e){
                e.setStackTrace();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }








}

