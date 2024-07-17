package com.mycompany.reservasientos;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ReservAsientos {

    public static void main(String[] args) {

        ReservAsientos reser = new ReservAsientos();

        String reserAsientos[][] = new String[10][10];

        for (int f = 0; f < 10; f++) {
            for (int c = 0; c < 10; c++) {

                reserAsientos[f][c] = "L";

            }
        }

        int sumando = 0;
        int cont = 0;
        int fila = 0;
        int asiento = 0;
        String seguirOno = "";

        //fores para mostar las filas y las columnas
        //reser.mostrarAsien(sumando, cont, reserAsientos);
        Scanner teclado = new Scanner(System.in);
        Scanner teclado2 = new Scanner(System.in);
        //para salir o no
        while (!seguirOno.equalsIgnoreCase("no")) {

            reser.mostrarAsien(sumando, cont, reserAsientos);

            boolean validarNumero = false;

            //while para verificar si ingreso numeros
            while (!validarNumero) {
                System.out.println("ingerese la fila q desea , Que fila deseas? indicacion fila es ------------------>");

                try {
                    fila = teclado.nextInt();
                    validarNumero = true;
                } catch (InputMismatchException e) {
                    System.out.println("Entrada no válida. Por favor ingrese un número.");
                    teclado.next();
                }

            }

            if (fila < 10) {

                validarNumero = false;

                while (!validarNumero) {
                    System.out.println("ingerese el asiento q desea reservar , Que asiento desea desde la fila q escojio");
                    if (teclado.hasNextInt()) {
                        asiento = teclado.nextInt();
                        validarNumero = true;
                    } else {
                        System.out.println("Entrada no válida. Por favor ingrese un número.");
                        teclado.next();
                    }

                }

                if (asiento < 10) {

                    if (!reserAsientos[fila][asiento].equals("X")) {

                        reserAsientos[fila][asiento] = "X";
                        reser.mostrarAsien(sumando, cont, reserAsientos);
                        System.out.println("reserva hecha con exito");

                    } else {
                        System.out.println("el asiento no esta disponible escoja denuevo o puede dejr de reservar");
                    }

                    //para validar solo letras
                    boolean validarLetras = false;

                    while (!validarLetras) {
                        System.out.println("Desea seguir reservando? si o no");
                        
                        seguirOno = teclado2.next();
                        
                        if (seguirOno.matches("[a-zA-Z]+")) {
                            validarLetras = true;
                        }else {
                            System.out.println("ingrese porfavor letras");
                        }
                    }
                    
                    
                } else {

                    System.out.println("no existe este asiento");

                }
            } else {
                System.out.println("esta fila no existe o carateres desconocidos");
            }
        }
    }

    //
    //
    //
    //
    //
    //
    //
    //
    //metodo para mostrar 
    public void mostrarAsien(int sumando, int cont, String reserAsientos[][]) {

        //fores para mostar las filas y las columnas
        for (int i = 0; i < 10; i++) {

            if (i == 0) {
                System.out.print(" ");
            }

            System.out.print(" " + sumando);
            sumando = sumando + 1;
        }

        sumando = 0;

        System.out.println("");

        for (int f = 0; f < 10; f++) {
            for (int c = 0; c < 10; c++) {

                if (sumando == cont) {
                    System.out.print(sumando + " ");
                    cont = cont + 1;
                }
                System.out.print(reserAsientos[f][c] + " ");

            }
            sumando = sumando + 1;
            System.out.println("");
        }

    }
    //ignorar
    /*
    public void Montototal (List<Ticket> listaTickets) {
        
        double total = 0.0; 
        
        for (Ticket ticket : listaTickets) {
            total = total + ticket.getPrecio();
        }
        
        System.out.println("El total de todos los tickets es: " + total);
        
    }*/

}
