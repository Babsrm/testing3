package funciones;
/**
 * Librería de funciones útiles para un proyecto.
 * @author Barbara
 *
 */
public class Utilidades {
	
	/**
	 * Constructor de la clase sin parámetros. Genera un objeto vacío el cual después debe instanciarse para darle valores.
	 */
	public Utilidades() {	
	}
	
	/**
	 * Número de horas semanales para un trabajador.
	 */
	public static final int HORASJORNADA = 38;
	
	/**
	 * Procedimiento para definir la nota de un estudiante según un baremo. Se ha de indicar la nota del estudiante.
	 * @param nota double Debe de estar comprendida entre los valores 0 y 10, ambos incluídos.
	 * @return Devuelve String con el resultado:
	 * Suspenso para notas inferiores a 5.
	 * Bien para notas entre 5 y menor que 6,5.
	 * Notable para notas comprendidas entre 6,5 y menor que 8,5.
	 * Sobresaliente para notas comprendidas entre 8,5 y menor que 10.
	 * Matrícula para nota = 10.
	 * @throws ArithmeticException cuando la nota no está comprendida entre 0 y 10.
	 */
	public String devuelveNota(double nota) {
		String descripcion = "Matrícula";
		
		if (nota<0.0 || nota >10) {
			throw new ArithmeticException("La nota debe estar entre 0.0 y 10");
		} else if (nota<5.0) {
			descripcion="Suspenso";
		} else if (nota <6.5) {
			descripcion = "Bien";
		} else if (nota<8.5) {
			descripcion ="Notable";
		} else if (nota<10) {
			descripcion ="Sobresaliente";
		} else {
			descripcion = "Matrícula";
		}
		return descripcion;
	}
	/**
	 * Procedimiento para el cálculo del salario con horas extras. Se han de indicar el número de horas trabajadas, el precio de las horas normales y el precio de las horas extra.
	 * @param numHoras int Número de horas trabajadas
	 * @param precioHoras double Precio de las horas normales
	 * @param precioExtras double Precio de las horas extras
	 * @return double Salario
	 */
	public double calculaSalario(int numHoras, double precioHoras, double precioExtras) {
		int extras=0;
		int horas=numHoras;
		if (numHoras>HORASJORNADA) {
			extras = numHoras-HORASJORNADA;
			horas = HORASJORNADA;
		}
		return horas*precioHoras+extras*precioExtras;		
	}
	
	/**
	 * Procedimiento que calcula el cuántos divisores tiene un número proporcionado por el usuario.
	 * @param num int Número indicado por el usuario.
	 * @return int Total de divisores de num.
	 */
	public int cuentaDivisores(int num) {
		int cuenta=0;
		
		for (int i = 1; i <= num; i++) {
			if (num%i==0) {
				cuenta++;
			}
		}
		return cuenta;
	}
	/**
	 * Procedimiento que, dado un array (vector), nos indica cuál es el número de menor valor en él.
	 * @param v int Vector de números enteros.
	 * @return int Número de menor valor.
	 */
	public int devuelveMenor(int v[]) {
		int menor=v[0];
		for (int i = 0; i < v.length; i++) {
			if (v[i] < menor) {
				menor=v[i];
			}
		}
		return menor;
	}
	/**
	 * Procedimiento que ordena los elementos de un array(vector) dado.
	 * @param v int Vector de números enteros.
	 * @return vector int del mismo tamaño que el vector dado, con sus elementos ordenados de meonr a mayor.
	 */
	public int [] burbuja(int[] v)
    {
      int auxiliar;
      int[] ordenado;
      for(int i = 1; i < v.length; i++)
      {
        for(int j = 0;j < v.length-i;j++)
        {
          if(v[j] > v[j+1])
          {
            auxiliar = v[j];
            v[j] = v[j+1];
            v[j+1] = auxiliar;
          }   
        }
      }
      ordenado = v;
      return ordenado;
    }
}
