/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.damel.utilidades;

import java.util.Scanner;

/**
 * Clase que contiene métodos que realizan tareas no relacionadas con la tarea
 * principal del programa.
 * 
 * Programación DAM Modalidad Virtual - Curso 2024/2025
 *
 * @author Borja Piñero
 */
public class Utilidades {

    /**
     * Pausa la ejecución del programa hasta que el usuario presiones la tecla
     * ENTER, permitiendo una mejor lectura de los elementos de cada submenú
     *
     */
    public static void enterParaSalir() {

        Scanner entrada = new Scanner(System.in);

        System.out.println();

        System.out.print("Presiona ENTER para continuar...");
        System.out.println();

        entrada.nextLine();

    }

}
