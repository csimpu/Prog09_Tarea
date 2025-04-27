/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.damel.objetos;

/**
 * La clase que gestiona las Cuentas de Ahorro.<br>
 *
 * Es una subclase de {@link CuentaBancaria} y hereda todos sus atributos y
 * métodos.<br><br>
 *
 * Programación DAM Modalidad Virtual - Curso 2024/2025
 *
 * @author Borja Piñero
 */
public class CuentaAhorro extends CuentaBancaria {

    // Atributos de CuentaAhorro
    private double interesAnual; //El interés que genera la cuenta de ahorro

    /**
     * Constructor de la clase.
     *
     * @param iban El IBAN de la cuenta.
     * @param titular El titular de la cuenta, un objeto de la clase Persona.
     * @param saldo El saldo de la cuenta.
     * @param interesAnual El intrés que genera la cuenta.
     */
    public CuentaAhorro(String iban, Persona titular, double saldo, double interesAnual) {
        super(iban, titular, saldo); // Inicializa los atributos de la clase padre
        this.interesAnual = interesAnual;
    }
    
    /**
     * Getter para InteresAnual.
     * @return devuelve el valor de {@code InteresAnual}
     */
    public double getInteresAnual() {
        return interesAnual;
    }

    /**
     * Sobreescribe el metodo abstracto devolverInfoString de la clase padre que
     * implementa la interfaz Imprimible
     * @return devuelve una {@code String} con la información de la cuenta
     * @see com.damel.interfaces.Imprimible
     * @see CuentaBancaria#devolverInfoString() 
     */
    @Override
    public String devolverInfoString() {
        return "Cuenta Ahorro\nIBAN: " + iban
                + "\nTitular: " + titular.getNombre() + " " + titular.getApellidos()
                + "\nSaldo: " + saldo + " Eur"
                + "\nTipo de interes anual: " + interesAnual + "%";
    }

}
