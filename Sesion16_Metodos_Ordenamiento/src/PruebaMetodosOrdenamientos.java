import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class PruebaMetodosOrdenamientos {

	public static void main(String[] args) {
		
		Random rnd = new Random();
		
		Scanner entrada = new Scanner(System.in);
		MetodosOrdenamiento mo = new MetodosOrdenamiento();
		
		//vector de un millon

		int []v1 = new int[1000];
		int []v2 = new int[10000];
		int []v3 = new int[100000];
		int []v4 = new int[1000000];
		
		//int datos[] = {30, 200, 6, 10, 65, 70, 150, 4, 200, 1};
		
		//Objt.clone()
		//System.arrayCopy
		//Arrays.copyOf(array, long)
		//Arrays.copyOfRage(array, long)
		
		int op3 = 0;
		int datos [] = new int[0];
				
		System.out.println("Selecciona un tamaño de arreglo");
		System.out.println("1)1000 \n2)10000 \n3)100000 \n3)1000000 \n-----------------------------");
		op3 = entrada.nextInt();
		System.out.println("Generando cadena...");
		
		switch (op3) {
		case 1:
			
			for(int i = 0; i < v1.length; i++) {
				v1[i] = rnd.nextInt(100);
			}
			
			datos = new int[v1.length];
			System.arraycopy(v1, 0, datos, 0, datos.length);
			
			break;
		case 2:
			
			for(int i = 0; i < v2.length; i++) {
				v2[i] = rnd.nextInt(100);
			}
			
			datos = new int[v2.length];
			System.arraycopy(v2, 0, datos, 0, datos.length);
			
			break;
		case 3:
			
			for(int i = 0; i < v3.length; i++) {
				v3[i] = rnd.nextInt(100);
			}
			
			datos = new int[v3.length];
			System.arraycopy(v3, 0, datos, 0, datos.length);
			
			break;
		case 4:
			
			for(int i = 0; i < v4.length; i++) {
				v4[i] = rnd.nextInt(100);
			}
			
			datos = new int[v4.length];
			System.arraycopy(v4, 0, datos, 0, datos.length);
			
			break;
		default:
			System.out.println("Ingresa una opcion valida");
			
			break;
		}
		
		int op = 0;
		int cont = 0;
		int op2 = 0;
		
		int copia [] = new int[datos.length];
		
		System.out.println("Metodo des ordenado: ");
		System.out.println(Arrays.toString(datos));
		System.out.println();
		
		System.out.println("Selecciona un metodo de ordenamiento: ");
		
		do{
			System.out.println("1)Burbuja \n2)QuickSort \n3)ShellSort \n4)Radix \n5)hola \n6)Mezcla Directa \n7)Salir\n-----------------------------");
			op = entrada.nextInt();
			switch(op) {
				case 1 :
					System.out.println("Selecciona un metodo");
					System.out.println("1)Burbuja uno \n2)Burbuja dos \n3)Burbuja tres \n-----------------------------");
					op2 = entrada.nextInt();
					switch (op2) {
					case 1:
						System.arraycopy(datos, 0, copia, 0, datos.length);
						mo.limpiarContadores();
						MetodosOrdenamiento.Burbuja.ordenarBurbujaUno(copia);
						System.out.println("Metodo ordenado por burbuja uno: ");
						mo.mostrarVector(copia);
						break;
					case 2:
						System.arraycopy(datos, 0, copia, 0, datos.length);
						mo.limpiarContadores();
						MetodosOrdenamiento.Burbuja.ordenarBurbujaDos(copia);
						System.out.println("Metodo ordenado por burbuja dos: ");
						mo.mostrarVector(copia);
						break;
					case 3:
						System.arraycopy(datos, 0, copia, 0, datos.length);
						mo.limpiarContadores();
						MetodosOrdenamiento.Burbuja.ordenarBurbujaTres(copia);
						System.out.println("Metodo ordenado por burbuja tres: ");
						mo.mostrarVector(copia);
						break;
					}
					
					break;
				case 2 :
					int n = datos.length;
					System.arraycopy(datos, 0, copia, 0, datos.length);
					mo.limpiarContadores();
					MetodosOrdenamiento.QuickSort.sort(copia, 0, n-1);
					System.out.println("Metodo ordenado por quicksort: ");
					mo.mostrarVector(copia);
					break;
				case 3 :
					System.arraycopy(datos, 0, copia, 0, datos.length);
					mo.limpiarContadores();
					MetodosOrdenamiento.ShellSort.sort(copia);
					System.out.println("Metodo ordenado por ShellSort: ");
					mo.mostrarVector(copia);
					break;
				case 4 :
					System.arraycopy(datos, 0, copia, 0, datos.length);
					mo.limpiarContadores();
					System.out.println("Metodo ordenado por Radix:");
					MetodosOrdenamiento.Radix.radix(copia);
					break;
				case 5 :
					System.arraycopy(datos, 0, copia, 0, datos.length);
					mo.limpiarContadores();
					//MetodosOrdenamiento.Intercalacion.intercalacion(arregloA, arregloB); Metodo incompleto
					System.out.println("Metodo ordenado por intercalacion:");
					break;
				case 6 :
					System.arraycopy(datos, 0, copia, 0, datos.length);
					mo.limpiarContadores();
					System.out.println("Metodo ordenado por mezcla directa");
					MetodosOrdenamiento.MezclaDirecta.mezclaDirecta(copia);
					mo.mostrarVector(copia);
					break;
				case 7 :
					cont ++;
					break;
			}
		}while(cont<1);
		System.out.println("Nos vemos");
	}
}