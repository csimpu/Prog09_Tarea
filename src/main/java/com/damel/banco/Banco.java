/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.damel.banco;

import com.damel.objetos.CuentaBancaria;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Clase Banco<br>
 *
 * Clase que gestiona la funcionalidad del banco.<br>
 *
 * Permite gestionar las cuentas bancarias<br><br>
 *
 * Programación DAM Modalidad Virtual - Curso 2024/2025
 *
 * @author Borja Piñero
 */
public class Banco {

    // Defino el arraylist
    private ArrayList<CuentaBancaria> cuentas;
    private int contador;

    /**
     * Constructor de la clase.<br>
     *
     * Inicializa el array y el contador.
     */
    public Banco() {
        cuentas = new ArrayList<>(); // Inicializo el ArrayList
        contador = 0;
    }

    /**
     * Abre una nueva cuenta bancaria.<br>
     *
     * Añade la nueva cuenta al ArrayList
     *
     * @param cuenta la cuenta bancaria
     * @return devuelve {@code true} si la cuenta se añade.
     */
    public boolean abrirCuenta(CuentaBancaria cuenta) {
        return cuentas.add(cuenta); // Añado la cuenta al ArrayList
    }

    /**
     * Genera un listado con información básica de todas las cuentas del banco
     *
     * @return devuelve la lista con el formato especificado
     */
    public String[] listadoCuentas() {
        String[] listado = new String[contador];
        for (int i = 0; i < cuentas.size(); i++) { // Utilizo size() para saber el tamaño del ArrayList
            listado[i] = cuentas.get(i).getIban() // Utilizo get() para obtener la posicion en el ArrayList
                    + "\n" + cuentas.get(i).getTitular().getNombre() + " " + cuentas.get(i).getTitular().getApellidos()
                    + "\n" + cuentas.get(i).getSaldo() + " Eur";
        }
        return listado;
    }

    /**
     * Busca una cuenta por su IBAN y muestra toda la información de esa cuenta,
     * comparando los IBAN de las cuentas almacenadas en el array
     * {@code cuentas} con el IBAN proporcionado.
     *
     * @param iban El IBAN de la cuenta
     * @return devuelve una {@code String} con la información completa de la
     * cuenta si encuentra el IBAN.<br>
     * devuelve {@code null} si no hay coincidencia.
     */
    public String informacionCuenta(String iban) {
        // Para cada elemento cuenta del ArrayList cuentas
        for (CuentaBancaria cuenta : cuentas) {
            if (cuenta.getIban().equals(iban)) {
                return cuenta.devolverInfoString();
            }
        }
        return null;
    }

    /**
     * Realiza un ingreso en la cuenta.<br>
     * Busca una cuenta por su IBAN e ingresa una cantidad en esa cuenta
     *
     * @param iban El IBAN de la cuenta donde se hará el ingreso.
     * @param cantidad La cantidad que se ingresará
     * @return devuelve {@code true} si el IBAN está en el banco.<br>
     * devuelve {@code false} si no encuentra el IBAN.
     */
    public boolean ingresoCuenta(String iban, double cantidad) {
        for (CuentaBancaria cuenta : cuentas) {
            if (cuenta.getIban().equals(iban)) {
                cuenta.ingresar(cantidad);
                return true;
            }
        }
        return false;
    }

    /**
     * Realiza una retirada de efectivo en la cuenta.<br>
     * Busca una cuenta por su IBAN y retira una cantidad en esa cuenta
     *
     * @param iban El IBAN de la cuenta donde se hará la retirada.
     * @param cantidad La cantidad que se retirará
     * @return devuelve {@code true} si se cumple la condición de
     * {@link CuentaBancaria#retirar(double)}.<br>
     * devuelve {@code false} si no encuentra el IBAN.
     */
    public boolean retiradaCuenta(String iban, double cantidad) {
        for (CuentaBancaria cuenta : cuentas) {
            if (cuenta.getIban().equals(iban)) {
                return cuenta.retirar(cantidad);
            }
        }
        return false;
    }

    /**
     * Obtiene el saldo de una cuenta específica.<br>
     * Busca una cuenta por su IBAN y muestra el saldo que tiene esa cuenta.
     *
     * @param iban El IBAN de la cuenta
     * @return devuelve el saldo de la cuenta si encuentra el IBAN.<br>
     * devuelve {@code -1} si no encuentra el IBAN.
     */
    public double obtenerSaldo(String iban) {
        for (CuentaBancaria cuenta : cuentas) {
            if (cuenta.getIban().equals(iban)) {
                return cuenta.getSaldo();
            }
        }
        return -1;
    }

    /**
     * Elimina una cuenta bancaria si existe y no tiene saldo
     *
     * @param iban El iban de la cuenta a eliminar
     * @return 0 si la cuenta se elimina correctamente.<br>
     * -1 si la cuenta no existe.<br>
     * -2 si la cuente tiene saldo.
     */
    public int eliminarCuenta(String iban) {
        // Uso un iterador para elimiar de forma segura
        Iterator<CuentaBancaria> iterador = cuentas.iterator();
        while (iterador.hasNext()) {
            CuentaBancaria cuenta = iterador.next();
            if (cuenta.getIban().equals(iban)) {
                if (cuenta.getSaldo() == 0) {
                    iterador.remove(); //Elimino la cuenta usando el iterador
                    return 0;
                } else {
                    return -2;
                }
            }
        }
        return -1;
    }
}
