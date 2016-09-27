package com.developers.carlos.tareacontactos;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    TextInputEditText nombre,telefono,descripcion,email;
    EditText fecha;

    Bundle extras;

    public static final String PUT_NOMBRE = "put_nombre";
    public static final String PUT_TELEFONO = "put_telefono";
    public static final String PUT_EMAIL = "put_email";
    public static final String PUT_DESCRIPCION = "put_descripcion";
    public static final String PUT_FECHA = "put_fecha";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        extras = getIntent().getExtras();

        nombre = (TextInputEditText) findViewById(R.id.nombre);
        telefono = (TextInputEditText) findViewById(R.id.telefono);
        email = (TextInputEditText) findViewById(R.id.email);
        descripcion = (TextInputEditText) findViewById(R.id.descripcion);
        fecha = (EditText) findViewById(R.id.fecha);
        if(extras!=null){
            vaciarInfo();
        }

    }

    public void vaciarInfo(){
        nombre.setText(extras.getString(PUT_NOMBRE));
        telefono.setText(extras.getString(PUT_TELEFONO));
        email.setText(extras.getString(PUT_EMAIL));
        fecha.setText(extras.getString(PUT_FECHA));
        descripcion.setText(extras.getString(PUT_DESCRIPCION));
    }

    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getFragmentManager(), "datePicker");
    }

    public void onClickSiguiente(View v){
        Intent intent = new Intent(this,ConfirmarActivity.class);
        intent.putExtra(PUT_NOMBRE,this.nombre.getText().toString());
        intent.putExtra(PUT_TELEFONO,this.telefono.getText().toString());
        intent.putExtra(PUT_EMAIL,this.email.getText().toString());
        intent.putExtra(PUT_DESCRIPCION,this.descripcion.getText().toString());
        intent.putExtra(PUT_FECHA,this.fecha.getText().toString());
        startActivity(intent);
        finish();
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        month=month+1;
        fecha.setText(dayOfMonth + "/" + month + "/" + year);
    }

    public static class DatePickerFragment extends DialogFragment {

        public DatePickerFragment() {}

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {

            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);
            //setStyle(DialogFragment.STYLE_NO_TITLE,android.R.style.Theme_Material);
            return new DatePickerDialog(getActivity(), (MainActivity)getActivity(), year, month, day);

        }

    }
}
