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
				()-> utils.devuelveNota(-2)); //sale del límite <0
		assertThrows(ArithmeticException.class, 
				()-> utils.devuelveNota(11)); //excede del límite >10
		assertEquals("Suspenso", utils.devuelveNota(4));
		assertEquals("Suspenso", utils.devuelveNota(0));
		assertEquals("Bien", utils.devuelveNota(5));
		assertEquals("Bien", utils.devuelveNota(6.4));
		assertEquals("Notable", utils.devuelveNota(6.5));
		assertEquals("Notable", utils.devuelveNota(8.4));
		assertEquals("Sobresaliente", utils.devuelveNota(8.5));
		assertEquals("Sobresaliente", utils.devuelveNota(9.2));
		assertEquals("Matrícula", utils.devuelveNota(10));
	}

	@Test
	void testCalculaSalario() {
		assertEquals(100, utils.calculaSalario(10, 10, 25),"Error en el test: el resultado debería de haber sido 100");
		assertEquals(430, utils.calculaSalario(40, 10, 25),"Error en el test: el resultado debería de haber sido 430");
		assertEquals((Utilidades.HORASJORNADA)*10+50, utils.calculaSalario(Utilidades.HORASJORNADA+2, 10, 25),"Error en el test: el resultado debería de haber sido 430");
		assertEquals(380, utils.calculaSalario(38, 10, 25),"Error en el test: el resultado debería de haber sido 380");
		assertEquals(Utilidades.HORASJORNADA*10, utils.calculaSalario(Utilidades.HORASJORNADA, 10, 25),"Error en el test: el resultado debería de haber sido 380");
		assertThrows(ArithmeticException.class, 
				()-> utils.calculaSalario(-4, 1, 3));
		assertThrows(ArithmeticException.class, 
				()-> utils.calculaSalario(4, -1, 3));
		assertThrows(ArithmeticException.class, 
				()-> utils.calculaSalario(4, 1, -3));
		assertThrows(ArithmeticException.class, 
				()-> utils.calculaSalario(0, 8, 9));
		assertThrows(ArithmeticException.class, 
				()-> utils.calculaSalario(8, 0, 9));
		assertThrows(ArithmeticException.class, 
				()-> utils.calculaSalario(8, 9, 0));
		
	}

	@Test
	void testCuentaDivisores() {
		assertEquals(2, utils.cuentaDivisores(7),"Error en el test: el resultado debería de haber sido 2"); 
		//divisible entre 1 y 7
		assertEquals(4, utils.cuentaDivisores(1),"Error en el test: el resultado debería de haber sido 4"); 
		//divisible entre 1
		assertEquals(4, utils.cuentaDivisores(10),"Error en el test: el resultado debería de haber sido 4");
		//divisible entre 1,2,5,10
	}

	@Test
	void testDevuelveMenor() {
		int vector [] = {-14,2,18,45,-50};
		//aunque se le deba pasar como parámetro un vector a la función, no significa que después tenga que hacer el equals con el array. esta función me devuelve un double, por lo que simplemente tengo que hacer un assertequals del resultado esperado
		assertEquals(-50, utils.devuelveMenor(vector), "Error en el test: el resultado debería de haber sido -50");
	}

	@Test
	void testAlgoritmoBurbuja() {
		int original1 [] = {8,-4,16,2,-8};
		int original2 [] = {5,8,77,90,0};
		int original3 [] = {7,8,9,10,11};
		int ordenado1 [] = {-8,-4,2,8,16};
		int ordenado2 [] = {0,5,8,77,90};
		int ordenado3 [] = {7,8,9,10,11};

		assertArrayEquals(utils.algoritmoBurbuja(original1), ordenado1, "Vector no ordenado correctamente.");
		assertArrayEquals(utils.algoritmoBurbuja(original2), ordenado2, "Vector no ordenado correctamente.");
		assertArrayEquals(utils.algoritmoBurbuja(original3), ordenado3, "Vector no ordenado correctamente.");
		
		
	}

}
