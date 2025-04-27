/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.damel.objetos;

import java.io.Serializable;

/**
 * Clase abstracta que sirve de plantilla de los dos tipos de Cuentas 
 * Corrientes.<br>
 *
 * Es una subclase de {@link CuentaBancaria} y hereda todos sus atributos y
 * métodos, y, a su vez, es la clase padre de {@link CuentaCorrientePersonal} y
 * {@link CuentaCorrienteEmpresa}<br><br>
 *
 * Programación DAM Modalidad Virtual - Curso 2024/2025
 *
 * @author Borja Piñero
 */
public abstract class CuentaCorriente extends CuentaBancaria implements Serializable {

    private static final long SerialVersionUID = 1L; // identificador para la serialización
    protected String entidadesAutorizadas;

    /**
     * Constructor de la clase. Define los metodos que heredrán las clases
     * hijas y los que esta clase hereda de la clase padre.
     * 
     * @param iban El IBAN de la cuenta.
     * @param titular El titular de la cuenta
     * @param saldo El saldo de la cuenta
     * @param entidadesAutorizadas Las entidades que pueden domiciliar recibos 
     * en la cuenta.
     */
    public CuentaCorriente(String iban, Persona titular, double saldo, String entidadesAutorizadas) {
        super(iban, titular, saldo); //Inicializa los atributos de la clase padre
        this.entidadesAutorizadas = entidadesAutorizadas;
    }

    /**
     * Getter para EntidadesAutorizadas.<br>
     * Permite a las clases hijas obtener el listado de entidades autorizadas
     * para domiciliar recibos.
     * @return devuelve una {@code String} con las entidades autorizadas.
     */
    public String getEntidadesAutorizadas() {
        return entidadesAutorizadas;
    }

}
