package test;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import logica.Parcial;
import static org.junit.jupiter.api.Assertions.*;
import excepciones.DesbordamientoExcepcion;
import excepciones.IndeterminacionExcepcion;
import excepciones.ResultadoNoEnteroExcepcion;
public class ParcialTest {

    private Parcial parcial;

    @BeforeEach
    public void setUp() {
        parcial = new Parcial();
    }
    
    //pruebas de excepciones

    @Test
    public void testIndeterminacionCeroElevadoACero() {
        assertThrows(IndeterminacionExcepcion.class, () -> {parcial.calcularPotencia(0, 0);}, 
        		"Debe lanzar mensaje de indeterminacion cuando se hace 0^0");
    }

    @Test
    public void testBaseCeroExponenteNegativo() {
        assertThrows(ResultadoNoEnteroExcepcion.class, () -> {parcial.calcularPotencia(0, -5);}, 
        		"Debe lanzar mensaje de error por division por cero");
    }

    @Test
    public void testExponenteNegativoBaseComun() {
        assertThrows(ResultadoNoEnteroExcepcion.class, () -> {parcial.calcularPotencia(2, -3);}, 
        		"Debe lanzar error de numero no entero porque el resultado seria decimal");
    }

    @Test
    public void testDesbordamiento() {
        assertThrows(DesbordamientoExcepcion.class, () -> {
            parcial.calcularPotencia(2, 31);}, 
        		"Debe lanzar mensje de desbordamiento por que se pasa de los 32 bits de int");
    }

    @Test
    public void testDesbordamientoNegativo() {
        assertThrows(DesbordamientoExcepcion.class, () -> {parcial.calcularPotencia(-10, 11);}, 
        		"Debe lanzar mensje de desbordamiento por que se pasa de los 32 bits de int");
    }

    // pruebas de reusltados correctos


    @Test
    public void testBaseCeroExponentePositivo() throws Exception {
        int resultado = parcial.calcularPotencia(0, 5);
        assertEquals(0, resultado, "0 elevado a cualquier positivo debe ser 0");
    }

    @Test
    public void testExponenteCeroBaseCualquiera() throws Exception {
        int resultado = parcial.calcularPotencia(5, 0);
        assertEquals(1, resultado, "Cualquier numero elevado a la 0 debe ser 1");
    }

    @Test
    public void testBaseUnoExponenteNegativo() throws Exception {
        int resultado = parcial.calcularPotencia(1, -100);
        assertEquals(1, resultado, "1 elevado a cualquier numero sigue siendo 1");
    }

    @Test
    public void testBaseMenosUnoExponenteNegativoPar() throws Exception {
        int resultado = parcial.calcularPotencia(-1, -4);
        assertEquals(1, resultado, "-1 elevado a una potencia negativa par debe ser 1");
    }

    @Test
    public void testBaseMenosUnoExponenteNegativoImpar() throws Exception {
        int resultado = parcial.calcularPotencia(-1, -5);
        assertEquals(-1, resultado, "-1 elevado a una potencia negativa impar debe ser -1");
    }

    @Test
    public void testCalculoNormalPositivo() throws Exception {
        int resultado = parcial.calcularPotencia(2, 3);
        assertEquals(8, resultado, "2^3 debe ser 8");
    }

    @Test
    public void testCalculoNormalNegativo() throws Exception {
        int resultado = parcial.calcularPotencia(-2, 3);
        assertEquals(-8, resultado, "(-2)^3 debe ser -8");
    }
}