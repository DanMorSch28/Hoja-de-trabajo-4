/**
Rodrigo Corona 15102
Daniel Morales 15526
junit Test
*/

import static org.junit.Assert.*;


public class CalculadoraTest {

    @org.junit.Test
    public void testEvaluar() throws Exception {
        assertEquals(15.0, Calculadora.evaluar("1 2 + 4 * 3 +"), 0.00000000000000001);
        assertEquals(0.5, Calculadora.evaluar("1 2 /"), 0.00000000000000001);
        assertEquals(3, Calculadora.evaluar("1 2 +"), 0.00000000000000001);
        assertEquals(-1, Calculadora.evaluar("1 2 -"), 0.00000000000000001);
        assertEquals(20, Calculadora.evaluar("5 4 *"), 0.00000000000000001);
    }
}