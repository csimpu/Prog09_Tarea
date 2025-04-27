/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.damel.objetos;

/**
 * Clase que gestiona los titulares de las cuentas<br><br>
 * 
 * Programación DAM Modalidad Virtual - Curso 2024/2025
 *
 * @author Borja Piñero
 */
public class Persona {

    private String nombre,
            apellidos,
            dni;

    /**
     * Constructor de la clase
     * 
     * @param nombre El nombre del titular.
     * @param apellidos Los apellidos del titular.
     * @param dni El DNI del titular.
     */
    public Persona(String nombre, String apellidos, String dni) {

        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;

    }

    /**
     * Getter para Nombre
     * @return devuelve el nombre del titular
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Setter para nombre
     * @param nombre El nombre del titular
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Getter para apellidos
     * @return devuelve los Apellidos del titular.
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Setter para Apellidos
     * @param apellidos Los apellidos del titular
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * Getter para dni
     * @return devuelve el DNI
     */
    public String getDni() {
        return dni;
    }

    /**
     * Setter para dni
     * @param dni El DNI del titular
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * Método toString de Persona
     * @return devuelve una {@code String} con los datos del titular de la cuenta
     */
    @Override
    public String toString() {
        return "Persona:" 
                + "\nNombre: " + nombre 
                + "\nApellidos: " + apellidos 
                + "\nDNI:" + dni;
    }

}
