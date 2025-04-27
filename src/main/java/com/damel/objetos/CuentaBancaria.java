/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.damel.objetos;

import com.damel.interfaces.Imprimible;

/**
 * Clase abstracta que sirve como plantilla para las demás cuentas bancarias.
 * Contiene los atributos comunes a todas e implementa la interfaz Imprimible.
 *
 * Programación DAM Modalidad Virtual - Curso 2024/2025
 *
 * @author Borja Piñero
 */
public abstract class CuentaBancaria implements Imprimible {

    protected String iban;
    protected double saldo;
    protected Persona titular;

    /**
     * Constructor de la clase abstracta. Define los atributos comunes a las
     * clases hijas.
     *
     * @param iban El IBAN de la cuenta.
     * @param titular El titular de la cuenta. Un objeto de la clase Persona.
     * @param saldo El saldo de la cuenta
     */
    public CuentaBancaria(String iban, Persona titular, double saldo) {

        this.iban = iban;
        this.titular = titular;
        this.saldo = saldo;

    }

    /**
     * Suma una cantidad de saldo al que tiene la cuenta.
     * 
     * @param cantidad La cantidad que se suma.
     */
    public void ingresar(double cantidad) {
        saldo += cantidad;
    }

    /**
     * Retira una cantidad de saldo de la cuenta.
     * @param cantidad La cantidad que se retira.
     * @return si el saldo de la cuenta es mayor o igual que la cantidad a retirar, 
     * hace la retirada y devuelve {@code true}.<br>
     * devuelve {@code false)} si la cantidad a retirar es mayor que el saldo en
     * la cuenta.
     */
    public boolean retirar(double cantidad) {
        if (saldo >= cantidad) {
            saldo -= cantidad;
            return true;
        }
        return false;
    }

    /**
     * Getter para IBAN.<br>
     * Permite a las clases hijas obtener el IBAN.
     * @return devuelve el IBAN de la cuenta.
     */
    public String getIban() {
        return iban;
    }

    /**
     * Getter para saldo.<br>
     * Permite a las clases hijas obtener el saldo.
     * @return devuelve el saldo de la cuenta
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * Getter para titular.<br>
     * Permite a las clases hijas obtener el titular.
     * @return Devuelve el nombre, apellidos y DNI del titular.
     */
    public Persona getTitular() {
        return titular;
    }

    /**
     * Sobreescribe el método de la interfaz Imprimible, sin implementarlo, pero
     * obligando a las subclases a implementarlo.
     * @return devuelve una {@code String} con la información de la cuenta.
     */
    @Override
    public abstract String devolverInfoString();

}
