package funciones;


import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class UtilidadesTest {
	//para poder hacer las comprobaciones, tengo que definir el objeto de la clase. entonces creo este objeto utils de la clase utilidades
	private static Utilidades utils;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
		//aquí la instancio. cada vez que vaya a hacer los test, me lo instancia
		//si no la instancio, queda sin memoria, su valor es null
		utils = new Utilidades();
	}

	@Test
	void testDevuelveNota() {
		assertThrows(ArithmeticException.class, 
				()-> utils.devuelveNota(-2));
		assertEquals("Suspenso", utils.devuelveNota(4));
		assertEquals("Bien", utils.devuelveNota(6.4));
		assertEquals("Notable", utils.devuelveNota(8.4));
		assertEquals("Sobresaliente", utils.devuelveNota(8.5));
		assertEquals("Matrícula", utils.devuelveNota(10));
	}

	@Test
	void testCalculaSalario() {
		assertEquals(100, utils.calculaSalario(10, 10, 25),"Error en el test: el resultado debería de haber sido 100");
		assertEquals(430, utils.calculaSalario(40, 10, 25),"Error en el test: el resultado debería de haber sido 430");
	}

	@Test
	void testCuentaDivisores() {
		assertEquals(2, utils.cuentaDivisores(7),"Error en el test: el resultado debería de haber sido 2"); 
		//divisible entre 1 y 7
		assertEquals(4, utils.cuentaDivisores(6),"Error en el test: el resultado debería de haber sido 4"); 
		//divisible entre 1,2,3,6
		assertEquals(4, utils.cuentaDivisores(10),"Error en el test: el resultado debería de haber sido 4");
		//divisible entre 1,2,5,10
	}

	@Test
	void testDevuelveMenor() {
		int vector [] = {1,2,3,4,5};
		//aunque se le deba pasar como parámetro un vector a la función, no significa que después tenga que hacer el equals con el array. esta función me devuelve un double, por lo que simplemente tengo que hacer un assertequals del resultado esperado
		assertEquals(1, utils.devuelveMenor(vector), "Error en el test: el resultado debería de haber sido 1");
	}

	@Test
	void testBurbuja() {
		int original [] = {8,-4,16,2,-8};
		int ordenado [] = {-8,-4,2,8,16};
		int ordenadoMal [] = {-4,-8,2,16,8};
		utils.burbuja(original);
		assertArrayEquals(original, ordenado, "Vector no ordenado correctamente.");
	
//		assertArrayEquals(original, ordenadoMal, "Vector no ordenado correctamente.");
		
	}

}
