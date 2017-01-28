package com.example.janto.ejercicio02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText txtNombre, txtPeso, txtEstatura;
    CheckBox chEjercicio;
    RadioButton rdHombre, rdMujer;
    Button btnCalcular, btnLimpiar, btnInformacion;


    private boolean Valido(){
        boolean isValido = true;

        if (txtNombre.getText().toString().length()==0){
            txtNombre.setError("introduzca su nombre");
            isValido = false;
        }
        if (txtPeso.getText().toString().length()==0){
            txtPeso.setError("introduzca su peso");
            isValido = false;
        }
        if (txtEstatura.getText().toString().length()==0){
            txtEstatura.setError("introduzca su estarura");
            isValido = false;
        }

        if(rdHombre.isChecked()==false & rdMujer.isChecked()==false){
            rdMujer.setError("Elija su género");
            rdHombre.setError("Elija su género");
            isValido = false;
        }
        return isValido;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Se relacionan los objetos del xml
        txtNombre=(EditText)findViewById(R.id.txtNombre);
        txtPeso=(EditText)findViewById(R.id.txtPeso);
        txtEstatura=(EditText)findViewById(R.id.txtEstatura);
        chEjercicio=(CheckBox)findViewById(R.id.chEjercicio);
        rdHombre=(RadioButton)findViewById(R.id.rdHombre);
        rdMujer=(RadioButton)findViewById(R.id.rdMujer);
        btnCalcular=(Button)findViewById(R.id.btnCalcular);
        btnLimpiar=(Button)findViewById(R.id.btnLimpiar);
        btnInformacion=(Button)findViewById(R.id.btnInformacion);



        btnCalcular.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Persona p = new Persona();//objeto de la clase persona
                if(Valido()) {

                        p.setNombre(txtNombre.getText().toString());
                        p.setPeso(Double.parseDouble(txtPeso.getText().toString()));
                        p.setEstatura(Double.parseDouble(txtEstatura.getText().toString()));


                        if (chEjercicio.isChecked()) {
                            p.setEjercicio((byte) 1);
                        } else {
                            p.setEjercicio((byte) 0);
                        }
                        if (rdHombre.isChecked()) {
                            p.setSexo('H');
                        } else {
                            p.setSexo('M');
                        }
                        p.calcularImc();


                        String resul = p.toString();


                        short status = p.calcularStatus();
                        switch (status) {
                            case 1:
                                Intent i = new Intent(MainActivity.this, Main2Activity.class);
                                i.putExtra("datos", resul + "");
                                startActivity(i);
                                break;
                            case 2:
                                Intent i2 = new Intent(MainActivity.this, Main3Activity.class);
                                i2.putExtra("datos", resul + "");
                                startActivity(i2);
                                break;

                            case 3:
                                Intent i3 = new Intent(MainActivity.this, Main4Activity.class);
                                i3.putExtra("datos", resul + "");
                                startActivity(i3);
                                break;
                            default:
                                Intent i4 = new Intent(MainActivity.this, MainActivity.class);
                                startActivity(i4);
                        }
                }
            }
        });


        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                txtNombre.setText("");
                txtPeso.setText("");
                txtEstatura.setText("");
                chEjercicio.setChecked(false);
                rdHombre.setChecked(false);
                rdMujer.setChecked(false);
            }
        });



        btnInformacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent i = new Intent(MainActivity.this, Main5Activity.class);
                startActivity(i);
            }
        });

    }
    }

