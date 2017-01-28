package com.example.janto.ejercicio02;

/**
 * Created by janto on 18/01/2017.
 */
public class Persona {
    private String nombre;
    private double peso;
    private double estatura;
    private byte ejercicio;//1-0
    private char sexo;//f-m
    private double imc;//dato calculable
    private short status;


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getEstatura() {
        return estatura;
    }

    public void setEstatura(double estatura) {
        this.estatura = estatura;
    }

    public byte getEjercicio() {
        return ejercicio;
    }

    public void setEjercicio(byte ejercicio) {
        this.ejercicio = ejercicio;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public double getImc() {
        return imc;
    }

    public void setImc(double imc) {
        this.imc = imc;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    public void calcularImc(){

        imc=peso/(estatura*estatura);
    }

    public short calcularStatus(){
        short status=0;

        if(imc < 20){
            status = 1;
        }if (imc >= 20 & imc <= 25){
            status = 2;
        }else if (imc > 25){
            status = 3;
        }
        return status;
    }


    @Override
    public String toString() {
        return "{" +
                " Nombre: '" + nombre + '\'' +
                ",\n Peso: " + peso +
                ",\n Estatura: " + estatura +
                ",\n Hace ejercicio(1 = Si, 0 = No): " + ejercicio +
                ",\n Sexo: " + sexo +
                ",\n IMC: " + imc +
                '}';
    }
}
