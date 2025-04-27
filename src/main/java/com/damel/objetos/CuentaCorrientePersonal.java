/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.damel.objetos;

/**
 * La clase que gestiona las Cuentas Corrientes Personales.<br>
 *
 * Es una subclase de {@link CuentaCorriente} y hereda todos sus atributos y
 * métodos.<br><br>
 *
 * Programación DAM Modalidad Virtual - Curso 2024/2025
 *
 * @author Borja Piñero
 */
public class CuentaCorrientePersonal extends CuentaCorriente {

    private double comisionMantenimiento;

    /**
     * Constructor de la clase
     *
     * @param iban El IBAN de la cuenta.
     * @param titular El titular de la cuenta.
     * @param saldo El saldo de la cuenta.
     * @param entidadesAutorizadas Las entidades que pueden domiciliar recibos
     * en la cuenta.
     * @param comisionMantenimiento La comisión de mantenimiento anual, en euros.
     */
    public CuentaCorrientePersonal(String iban, Persona titular, double saldo, String entidadesAutorizadas, double comisionMantenimiento) {
        super(iban, titular, saldo, entidadesAutorizadas);
        this.comisionMantenimiento = comisionMantenimiento;
    }

    /**
     * Getter para ComisionMantenimiento
     * @return Devuelve la comisión de mantenimiento, en euros
     */
    public double getComisionMantenimiento() {
        return comisionMantenimiento;
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
        return "Cuenta Corriente Personal\nIBAN: " + iban
                + "\nTitular: " + titular.getNombre() + " " + titular.getApellidos()
                + "\nSaldo: " + saldo + " Eur"
                + "\nComision de Mantenimiento: " + comisionMantenimiento + " Eur"
                + "\nEntidades Autorizadas: " + entidadesAutorizadas;
    }

}
