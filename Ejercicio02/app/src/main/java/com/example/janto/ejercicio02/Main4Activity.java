package com.example.janto.ejercicio02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main4Activity extends AppCompatActivity {

    private TextView txtDatos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        txtDatos = (TextView)findViewById(R.id.txtResul3);

        Bundle bundle = getIntent().getExtras();

        txtDatos.setText(bundle.getString("datos"));
    }
}
