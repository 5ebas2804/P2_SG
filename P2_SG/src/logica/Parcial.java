package logica;

import excepciones.DesbordamientoExcepcion;
import excepciones.IndeterminacionExcepcion;
import excepciones.ResultadoNoEnteroExcepcion;

public class Parcial {

    public int calcularPotencia(int b, int e) throws DesbordamientoExcepcion, ResultadoNoEnteroExcepcion, IndeterminacionExcepcion {
       
        // Validar indeterminacion matematica (0^0)
        if (b == 0 && e == 0) {
            throw new IndeterminacionExcepcion("Indeterminacion (0^0)");
        }
        // Validar base 0 con exponente positivo o negativo
        if (b == 0) {
            if (e < 0) {
                throw new ResultadoNoEnteroExcepcion("El segundo numero es negativo, por lo cual reusltara en infinto");
            }
            return 0; 
        }
        // Cualquier nuemro elevado a la 0 es 1
        if (e == 0) {
            return 1;
        }
        
        // Exponente negativo
        if (e < 0) {
            if (b == 1) return 1;
            if (b == -1) return (e % 2 == 0) ? 1 : -1;
            // Para cualquier otra base, el resultado esta entre -1 y 1
            throw new ResultadoNoEnteroExcepcion("Exponente negativo: El resultado esw decimal y el mwtodo debe retornar un entero.");
        }
        
        // Calculo de la potencia con validación de desbordamiento de int
        int resultado = 1;
        for (int i = 0; i < e; i++) {
            long calculoTemporal = (long) resultado * b;
            //Si se pasa de este valor, el nuumero no esta entre loq ue adminte un entero
            if (calculoTemporal > Integer.MAX_VALUE || calculoTemporal < Integer.MIN_VALUE) {
                throw new DesbordamientoExcepcion("Desbordamiento: El resultado se pasa de los 32bits");
            }
            // Si lo cumple se vuelve a int para dar el reusltado
            resultado = (int) calculoTemporal;
        }
        return resultado;
    }
}