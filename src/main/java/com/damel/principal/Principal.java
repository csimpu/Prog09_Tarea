/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.damel.principal;

import com.damel.objetos.*;
import com.damel.banco.*;
import com.damel.utilidades.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

/**
 * La clase que gestiona el menú principal del programa<br><br>
 *
 * Programación DAM Modalidad Virtual - Curso 2024/2025
 *
 * @author Borja Piñero
 */
public class Principal {

    private static Banco banco = new Banco();
    private static Scanner entrada = new Scanner(System.in);
    // Añado el nombre del archivo que se generará
    private static final String NOMBRE_ARCHIVO_CLIENTES = "ListadoClientesIBAN.txt";

    /**
     * Metodo main de la clase.<br>
     *
     * Inicia el programa, muestra el menú principal y procesa las opciones
     * seleccionadas
     *
     * @param args No utilizado.
     */
    public static void main(String[] args) {
        int opcion;

        do {
            menuGestorCuentas();

            try {
                opcion = Integer.parseInt(entrada.nextLine());
                switch (opcion) {
                    case 1 ->
                        nuevaCuenta();
                    case 2 ->
                        listarCuentas();
                    case 3 ->
                        informacionCuenta();
                    case 4 ->
                        ingresarSaldo();
                    case 5 ->
                        retirarSaldo();
                    case 6 ->
                        consultarSaldo();
                    case 7 ->
                        borrarCuenta();
                    case 8 ->
                        listadoClientes();
                    case 9 -> {
                        banco.guardarCuentas();
                        System.out.println("Gracias por usar el servicio. Cerrando...");
                    }
                    case 0 ->
                        mostrarAyuda();
                    default ->
                        System.out.println("Opcion no valida: Introduzca un numero del 0 al 7");
                }
            } catch (NumberFormatException eNFE) {
                System.err.println("Error: Debes introducir un numero valido.");
                opcion = 0;
            }
        } while (opcion != 9);

        entrada.close();
    }

    /**
     * Muestra el menú principal de consola.
     */
    private static void menuGestorCuentas() {
        System.out.println("*************************************");
        System.out.println("*         Gestor de cuentas         *");
        System.out.println("*************************************");
        System.out.println("[1] - Abrir una cuenta");
        System.out.println("[2] - Listar cuentas disponibles");
        System.out.println("[3] - Obtener datos de una cuenta");
        System.out.println("[4] - Realizar un ingreso");
        System.out.println("[5] - Realizar una retirada");
        System.out.println("[6] - Consultar el saldo");
        System.out.println("[7] - Eliminar una cuenta");
        System.out.println("[8] - Listado de clientes");
        System.out.println("[9] - Salir               [0] - Ayuda");
        System.out.println("*************************************");
        System.out.print("Introduce una opcion: ");
    }

    /**
     * Muestra el submenú de Tipo de Cuenta.
     */
    private static void submenuTipoCuenta() {
        System.out.println("*************************************");
        System.out.println("*          Tipo de cuenta           *");
        System.out.println("*************************************");
        System.out.println("[1] - Cuenta de Ahorro");
        System.out.println("[2] - Cuenta Corriente Personal");
        System.out.println("[3] - Cuenta Corriente de Empresa");
        System.out.println("*************************************");
        System.out.print("Introduce una opcion: ");
    }

    /**
     * Muestra el menú Nueva cuenta y crea la nueva cuenta dentro del tipo que
     * le corresponde.
     */
    private static void nuevaCuenta() {
        System.out.println("*************************************");
        System.out.println("*           Nueva cuenta            *");
        System.out.println("*************************************");

        // Datos personales
        System.out.print("Introduce el nombre: ");
        String nombre = entrada.nextLine();
        System.out.print("Introduce los apellidos: ");
        String apellidos = entrada.nextLine();
        System.out.print("Introduce el DNI: ");
        String dni = entrada.nextLine();
        Persona titular = new Persona(nombre, apellidos, dni);

        //Saldo inicial
        double saldo;
        System.out.print("Introduce el saldo inicial: ");

        while (true) {
            try {
                saldo = Double.parseDouble(entrada.nextLine());
                break;
            } catch (NumberFormatException eNFE) {
                System.err.println("Error: Debes introducir un numero.");
            }
        }

        // IBAN cuenta
        String iban;
        String regExIban = "ES\\d{20}";
        do {
            System.out.println("Introduce el IBAN de la cuenta.");
            System.out.println("El formato es ES12345678901234567890");
            iban = entrada.nextLine();
        } while (!iban.matches(regExIban));

        // Submenú selección de cuenta
        int opcion;

        submenuTipoCuenta();
        while (true) {
            try {
                opcion = Integer.parseInt(entrada.nextLine());
                break;
            } catch (NumberFormatException eNFE) {
                System.err.println("Error: Debes introducir un numero.");
                opcion = 0;
            }
        }
        CuentaBancaria cuenta = null;
        switch (opcion) {
            case 1 -> {

                double tipoAnual;

                System.out.println("*************************************");
                System.out.println("*          Cuenta de Ahorro         *");
                System.out.println("*************************************");
                System.out.println("Introduce el tipo de interes anual:");

                while (true) {
                    try {
                        tipoAnual = Double.parseDouble(entrada.nextLine());
                        break;
                    } catch (NumberFormatException eFNE) {
                        System.err.println("Error: Debes introducir un numero.");
                        tipoAnual = 0;

                    }
                }
                cuenta = new CuentaAhorro(iban, titular, saldo, tipoAnual);
            }
            case 2 -> {

                double comisionMantenimiento;

                System.out.println("*************************************");
                System.out.println("*     Cuenta Corriente Personal     *");
                System.out.println("*************************************");
                System.out.println("Introduce las entidades autorizadas.");
                System.out.println("Deben estar separadas por comas.");
                String entidades = entrada.nextLine();
                System.out.println("Introduce la comision de");
                System.out.println("mantenimiento anual");

                while (true) {
                    try {
                        comisionMantenimiento = Double.parseDouble(entrada.nextLine());
                        break;
                    } catch (NumberFormatException eFNE) {
                        System.err.println("Error: Debes introducir un numero.");
                        comisionMantenimiento = 0;

                    }
                }

                cuenta = new CuentaCorrientePersonal(iban, titular, saldo, entidades, comisionMantenimiento);

            }

            case 3 -> {

                double maxDescubierto,
                        interesDescubierto,
                        comisionDescubierto;

                System.out.println("*************************************");
                System.out.println("*    Cuenta Corriente de Empresa    *");
                System.out.println("*************************************");
                System.out.println("Introduce las entidades autorizadas.");
                System.out.println("Deben estar separadas por comas.");
                String entidades = entrada.nextLine();
                System.out.println("Introduce el descubierto maximo");
                System.out.println("permitido: ");

                while (true) {
                    try {
                        maxDescubierto = Double.parseDouble(entrada.nextLine());
                        break;
                    } catch (NumberFormatException eFNE) {
                        System.err.println("Error: Debes introducir un numero.");
                        maxDescubierto = 0;

                    }
                }

                System.out.println("Introduce el tipo de interes por");
                System.out.println("descubierto:");

                while (true) {
                    try {
                        interesDescubierto = Double.parseDouble(entrada.nextLine());
                        break;
                    } catch (NumberFormatException eFNE) {
                        System.err.println("Error: Debes introducir un numero.");
                        interesDescubierto = 0;

                    }
                }

                System.out.println("Introduce la comision fija por");
                System.out.println("descubierto:");

                while (true) {
                    try {
                        comisionDescubierto = Double.parseDouble(entrada.nextLine());
                        break;
                    } catch (NumberFormatException eFNE) {
                        System.err.println("Error: Debes introducir un numero.");
                        comisionDescubierto = 0;

                    }
                }

                cuenta = new CuentaCorrienteEmpresa(iban, titular, saldo, entidades, interesDescubierto, maxDescubierto, comisionDescubierto);

            }

            default ->
                System.out.println("Tipo de cuenta no valido");
        }

        if (banco.abrirCuenta(cuenta)) {
            System.out.println("Cuenta abierta con exito");
        } else {
            System.out.println("No hay espacio para mas cuentas");
        }

        System.out.println("*************************************");

        Utilidades.enterParaSalir();

    }

    /**
     * Muestra el menú Listado de cuentas e implementa el método listadoCuentas
     */
    private static void listarCuentas() {
        System.out.println("*************************************");
        System.out.println("*        Listado de cuentas         *");
        System.out.println("*************************************");

        String[] listado = banco.listadoCuentas();
        if (listado.length == 0) {
            System.out.println("No hay cuentas en el sistema");
        } else {
            //bucle for-each
            for (String cuenta : listado) {
                System.out.println(cuenta);
            }
        }

        System.out.println("*************************************");

        Utilidades.enterParaSalir();
    }

    /**
     * Muestra el menú Información de la cuenta e implementa el método
     * informacionCuenta
     */
    private static void informacionCuenta() {
        System.out.println("*************************************");
        System.out.println("*     Informacion de la cuenta      *");
        System.out.println("*************************************");
        System.out.println("Introduce el IBAN de la cuenta:");
        String iban = entrada.nextLine();
        String datos = banco.informacionCuenta(iban);
        if (datos == null) {
            System.out.println("Error: cuenta no encontrada.");
            System.out.println("Verifica el IBAN");
        } else {
            System.out.println(datos);
        }

        System.out.println("*************************************");

        Utilidades.enterParaSalir();
    }

    /**
     * Muestra el menú Realizar ingreso e implementa el método ingresoCuenta
     */
    private static void ingresarSaldo() {

        double ingreso = 0;

        System.out.println("*************************************");
        System.out.println("*         Realizar ingreso          *");
        System.out.println("*************************************");
        System.out.println("Introduce el IBAN de la cuenta:");
        String iban = entrada.nextLine();

        while (true) {
            System.out.print("Introduce la cantidad: ");
            try {
                ingreso = Double.parseDouble(entrada.nextLine());
                break;
            } catch (NumberFormatException eNFE) {
                System.err.println("Error: Debes introducir un numero");
            }
        }
        if (banco.ingresoCuenta(iban, ingreso)) {
            System.out.println("Ingreso correcto");
        } else {
            System.out.println("Ingreso no realizado");
        }

        System.out.println("*************************************");

        Utilidades.enterParaSalir();
    }

    /**
     * Muestra el menú Realizar retirada e implementa el método retiradaCuenta.
     */
    private static void retirarSaldo() {

        double retirada = 0;

        System.out.println("*************************************");
        System.out.println("*         Realizar retirada         *");
        System.out.println("*************************************");
        System.out.println("Introduce el IBAN de la cuenta:");
        String iban = entrada.nextLine();

        while (true) {

            System.out.print("Introduce la cantidad: ");

            try {
                retirada = Double.parseDouble(entrada.nextLine());
                break;
            } catch (NumberFormatException eNFE) {
                System.err.println("Error: Debes introducir un numero");
            }
        }
        if (banco.retiradaCuenta(iban, retirada)) {
            System.out.println("Retirada de efectivo realizada");

        } else {
            System.out.println("No se ha realizado la retirada");
        }

        System.out.println("*************************************");

        Utilidades.enterParaSalir();
    }

    /**
     * Muestra el menú Consulta de saldo e implementa el método obtenerSaldo.
     */
    private static void consultarSaldo() {
        System.out.println("*************************************");
        System.out.println("*         Consulta de saldo         *");
        System.out.println("*************************************");
        System.out.println("Introduce el IBAN de la cuenta:");
        String iban = entrada.nextLine();
        double saldo = banco.obtenerSaldo(iban);
        if (saldo == -1) {
            System.out.println("No existe la cuenta");
        } else {
            System.out.println("Tiene un saldo de " + saldo + " Eur");
        }

        System.out.println("*************************************");

        Utilidades.enterParaSalir();
    }

    /**
     * Muestra el menú Eliminar cuenta e implementa el metodo eliminarCuenta
     */
    private static void borrarCuenta() {
        System.out.println("*************************************");
        System.out.println("*          Eliminar cuenta          *");
        System.out.println("*************************************");
        System.out.println("Introduce el IBAN de la cuenta:");
        String iban = entrada.nextLine();

        int resultadoEliminar = banco.eliminarCuenta(iban);

        switch (resultadoEliminar) {
            case 0 ->
                System.out.println("Cuenta eliminada correctamente");
            case -1 ->
                System.out.println("Error: No se ha encontrado la cuenta");
            case -2 ->
                System.out.println("Error: La cuenta tiene saldo");
        }

        System.out.println("*************************************");

        Utilidades.enterParaSalir();
    }

    /**
     * Genera un fichero de texto con el listado de los clientes y los IBAN de 
     * sus cuentas. Indica también el total de cuentas que hay
     */
    private static void listadoClientes() {
        System.out.println("*************************************");
        System.out.println("*        Listado de clientes        *");
        System.out.println("*************************************");

        // Obtengo la lista de las cuentas
        ArrayList<CuentaBancaria> cuentas = banco.getCuentas();

        try (PrintWriter escritor = new PrintWriter(new FileWriter(NOMBRE_ARCHIVO_CLIENTES))) {
            for (CuentaBancaria cuenta : cuentas) {
                escritor.println("Propietario: " + cuenta.getTitular().getNombre() 
                        + " " + cuenta.getTitular().getApellidos() + cuenta.getIban());
            }
            escritor.println("Numero total de cuentas: " + cuentas.size());
            System.out.println("Fichero '" + NOMBRE_ARCHIVO_CLIENTES + "' generado correctamente.");
        } catch (IOException eIOE) {
            System.err.println("Error al generar el fichero: " + eIOE.getMessage());
        }
        System.out.println("*************************************");

        Utilidades.enterParaSalir();
    }

    /**
     * Muestra el menú de ayuda.
     */
    private static void mostrarAyuda() {
        System.out.println("*************************************");
        System.out.println("*               Ayuda               *");
        System.out.println("*************************************");
        System.out.println("[1] - Anade una nueva cuenta");
        System.out.println("[2] - Lista las cuentas del banco");
        System.out.println("[3] - Muestra informacion de la");
        System.out.println("      cuenta seleccionada");
        System.out.println("[4] - Permite realizar un ingreso en");
        System.out.println("      la cuenta seleccionada");
        System.out.println("[5] - Permite realizar una retirada");
        System.out.println("      de saldo en la cuenta elegida");
        System.out.println("[6] - Permite consultar el saldo de ");
        System.out.println("      la cuenta seleccionada");
        System.out.println("[7] - Permite eliminar una cuenta ");
        System.out.println("      del banco");
        System.out.println("[8] - Genera un informe con los");
        System.out.println("      clientes del banco");
        System.out.println("*************************************");
        Utilidades.enterParaSalir();
    }
}
