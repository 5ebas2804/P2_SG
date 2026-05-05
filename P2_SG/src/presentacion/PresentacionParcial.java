package presentacion;

import java.util.Scanner;

import excepciones.DesbordamientoExcepcion;
import excepciones.IndeterminacionExcepcion;
import excepciones.ResultadoNoEnteroExcepcion;
import logica.Parcial;

public class PresentacionParcial {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Parcial potencia = new Parcial();

        System.out.print("Ingrese la base: ");
        int base = sc.nextInt();

        System.out.print("Ingrese el exponente: ");
        int exponente = sc.nextInt();

        try {
            int resultado = potencia.calcularPotencia(base, exponente);
            System.out.println("El resultado es: " + resultado);
            
        } catch (DesbordamientoExcepcion | ResultadoNoEnteroExcepcion | IndeterminacionExcepcion e) {
            System.out.println("Error de calculo: " + e.getMessage());
        } 
    }
}