package com.developers.carlos.tareacontactos;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

public class ConfirmarActivity extends AppCompatActivity {

    private TextView tvNombre, tvTelefono, tvEmail, tvFecha, tvDescripcion;
    Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tvNombre = (TextView) findViewById(R.id.tvNombre);
        tvTelefono = (TextView) findViewById(R.id.tvTelefono);
        tvEmail = (TextView) findViewById(R.id.tvEmail);
        tvFecha = (TextView) findViewById(R.id.tvFecha);
        tvDescripcion = (TextView) findViewById(R.id.tvDescripcion);

        extras = getIntent().getExtras();

        tvNombre.setText(extras.getString(MainActivity.PUT_NOMBRE));
        tvTelefono.setText("Teléfono: "+extras.getString(MainActivity.PUT_TELEFONO));
        tvEmail.setText("Email: "+extras.getString(MainActivity.PUT_EMAIL));
        tvFecha.setText("Fecha nacimiento: "+extras.getString(MainActivity.PUT_FECHA));
        tvDescripcion.setText("Descripcion "+extras.getString(MainActivity.PUT_DESCRIPCION));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enviarParametros();
            }
        });
    }

    public void enviarParametros(){
        Intent intent = new Intent(this,MainActivity.class);
        intent.putExtra(MainActivity.PUT_NOMBRE,extras.getString(MainActivity.PUT_NOMBRE));
        intent.putExtra(MainActivity.PUT_TELEFONO,extras.getString(MainActivity.PUT_TELEFONO));
        intent.putExtra(MainActivity.PUT_EMAIL,extras.getString(MainActivity.PUT_EMAIL));
        intent.putExtra(MainActivity.PUT_DESCRIPCION,extras.getString(MainActivity.PUT_DESCRIPCION));
        intent.putExtra(MainActivity.PUT_FECHA,extras.getString(MainActivity.PUT_FECHA));
        startActivity(intent);
        finish();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if(keyCode==KeyEvent.KEYCODE_BACK){
            enviarParametros();
        }
        return super.onKeyDown(keyCode, event);
    }
}
