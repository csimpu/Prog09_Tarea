/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.damel.objetos;

/**
 * La clase que gestiona las Cuentas Corrientes de Empresas.<br>
 *
 * Es una subclase de {@link CuentaCorriente} y hereda todos sus atributos y
 * métodos.<br><br>
 *
 * Programación DAM Modalidad Virtual - Curso 2024/2025
 *
 * @author Borja Piñero
 */
public class CuentaCorrienteEmpresa extends CuentaCorriente {

    private double interesDescubierto;
    private double maxDescubierto;
    private double comisionDescubierto;

    /**
     * Constructor de la clase
     *
     * @param iban El IBAN de la cuenta.
     * @param titular El titular de la cuenta.
     * @param saldo El saldo de la cuenta.
     * @param entidadesAutorizadas Las entidades que pueden domiciliar recibos
     * en la cuenta.
     * @param interesDescubierto El interés que genera un descubierto en la
     * cuenta, en porcentaje.
     * @param maxDescubierto El descubierto máximo que puede tener la cuenta, en
     * euros.
     * @param comisionDescubierto La comisión que se cobra por cada descubierto,
     * en euros.
     */
    public CuentaCorrienteEmpresa(String iban, Persona titular, double saldo, String entidadesAutorizadas, double interesDescubierto, double maxDescubierto, double comisionDescubierto) {
        super(iban, titular, saldo, entidadesAutorizadas);
        this.interesDescubierto = interesDescubierto;
        this.maxDescubierto = maxDescubierto;
        this.comisionDescubierto = comisionDescubierto;
    }

    /**
     * Getter para InteresDEscubierto.
     *
     * @return El interés que se aplica por tener un descubierto, en porcentaje.
     */
    public double getInteresDescubierto() {
        return interesDescubierto;
    }

    /**
     * Getter para MaxDescubierto
     *
     * @return El descubierto máximo que puede tener la cuenta, en euros.
     */
    public double getMaxDescubierto() {
        return maxDescubierto;
    }

    /**
     * Getter para ComisionDescubierto
     *
     * @return La comisión por descubierto que se cobra, en euros.
     */
    public double getComisionDescubierto() {
        return comisionDescubierto;
    }

    /**
     * Método que sobreescribe el método {@link CuentaBancaria#retirar(double)}
     * para permitir que haya un descubierto en este tipo de cuentas.<br>
     *
     * Se permite que la cantidad máxima a retirar sea el saldo total de la
     * cuenta más el valor de {@code maxDescubierto}
     *
     * @param cantidad La cantidad que se retira.
     * @return si el saldo de la cuenta más el descubierto máximo es mayor o igual
     * que la cantidad a retirar, hace la retirada y devuelve {@code true}.<br>
     * devuelve {@code false} si la cantidad a retirar es mayor que el saldo en
     * la cuenta más la cantidad {@code maxDescubierto}.
     */
    @Override
    public boolean retirar(double cantidad) {
        if ((saldo + maxDescubierto) >= cantidad) {
            saldo -= cantidad;
            return true;
        }
        return false;
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
                + "\nMaximo descubierto: " + maxDescubierto + " Eur"
                + "\nInterés por descubierto: " + interesDescubierto + "%"
                + "\nComision por descubieto: " + comisionDescubierto + " Eur"
                + "\nEntidades Autorizadas: " + entidadesAutorizadas;
    }

}
