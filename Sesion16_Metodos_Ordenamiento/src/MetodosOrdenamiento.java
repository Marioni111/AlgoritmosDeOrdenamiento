import java.util.Arrays;

public class MetodosOrdenamiento {

	static long tInicio;
	static long tFin;
	static long tiempo;
	static int contVueltas;
	static int contComparaciones;
	static int contIntercambios;
	
	static class Burbuja{
		
		public static void ordenarBurbujaUno(int numeros[]) {
			
			tInicio = System.currentTimeMillis();
			
			int aux = 0;
			
			for(int i = 0; i < numeros.length; i++) {
				
				for(int j = 0; j < (numeros.length-1); j++) {
					
					if(numeros[j] > numeros[j+1]) {
						
						aux = numeros[j];
						numeros[j] = numeros[j+1];
						numeros[j+1] = aux;
						contIntercambios += 1;
					}
					contComparaciones += 1;
				}
				contVueltas +=1;
			}
			tFin = System.currentTimeMillis();	
		}
		
		public static void ordenarBurbujaDos(int numeros[]) {
			
			tInicio = System.currentTimeMillis();
			
			int i = 1;
			boolean ordenado = false;
			
			while(i<numeros.length && ordenado == false) {
				
				int aux;
				
				i +=1;
				ordenado = true;
				
				for(int j = 0; j < (numeros.length-1); j++) {
					if(numeros[j] > numeros[j+1]) {
						ordenado = false;
						aux = numeros[j];
						numeros[j] = numeros[j+1];
						numeros[j+1] = aux;	
						contIntercambios += 1;
					}
					contComparaciones += 1;
				}
				contVueltas += 1;
			}
			tFin = System.currentTimeMillis();
		}

		public static void ordenarBurbujaTres(int numeros[]) {
			
			tInicio = System.currentTimeMillis();
			
			int i = 1;
			int aux = 0;
			boolean ordenado = true;
			
			do{
				i++;
				ordenado = true;
				for(int j=0; j<numeros.length-i; j++){
					if(numeros[j] > numeros[j+1]){
						ordenado = false;
						aux = numeros[j];
						numeros[j] = numeros[j+1];
						numeros[j+1] = aux;
						contIntercambios ++;
					}
					contComparaciones ++;
				}
				contVueltas ++;
			}while(!(i<numeros.length) || ordenado==true);
			tFin = System.currentTimeMillis();
		}
	}//class burbuja

static class QuickSort{
	
	public static int particion(int arr[], int menor, int mayor) {
		
		int pivot = arr[mayor];
		int i = (menor - 1);
		
		for(int j = menor; j < mayor;j++) {
			if(arr[j] < pivot) {
				i++;
				
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				contIntercambios ++;
			}
			contComparaciones ++;
		}
		
		int temp = arr[i+1];
		arr[i+1] = arr[mayor];
		arr[mayor] = temp;
		contIntercambios ++;
		
		tFin = System.currentTimeMillis();
		
		return i+1;
	}
	
	public static void sort (int arr[], int menor, int mayor) {
		
		tInicio = System.currentTimeMillis();
		
		if(menor < mayor) {
			int pi = particion(arr, menor, mayor);
			contComparaciones ++;
			sort(arr, menor, pi-1);
			sort(arr, pi + 1, mayor);
			contVueltas += 2;
		}
	}
}

static class ShellSort{

	public static int sort(int arr[]) {
		
		tInicio = System.currentTimeMillis();
		
		int n = arr.length; 
		for (int gap = n/2; gap > 0; gap /= 2){ 
			for (int i = gap; i < n; i += 1){ 
				int temp = arr[i];
				int j;
				contComparaciones ++;
				for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) 
					arr[j] = arr[j - gap];
					arr[j] = temp; 
					contIntercambios ++;
			}
			contVueltas ++;
		} 
		
		tFin = System.currentTimeMillis();
		return 0; 
	}
	
}

static class Radix{
	
	public static void radix(int[] arreglo) {
		
		tInicio = System.currentTimeMillis();
		
		int x, i, j;
		
		for(x=Integer.SIZE-1; x>=0; x--){  //numero de bit para representar un entero en 2 complementos binarios
			
			int auxiliar[]= new int[arreglo.length]; // sirve para mover los numeros
			j=0;
			for(i=0;i<arreglo.length; i++ ){  
				
				boolean mover= arreglo[i]<<x>=0; // true o un false
				
				if(x==0 ? !mover: mover){ //evaluar y comparar 
					auxiliar[j]= arreglo[i]; //correcto
					j++;
					
				}else{ //de lo contrario
					arreglo[i-j]= arreglo[i]; 
				}
				contComparaciones ++;
			}
			for(i=j; i<auxiliar.length; i++){ //copiar lo del arreglo auxiliar
				auxiliar[i]= arreglo[i-j];
				contIntercambios ++;
			}
			contVueltas ++;
			arreglo = auxiliar;
		}
		tFin = System.currentTimeMillis();
		System.out.println(Arrays.toString(arreglo));
		System.out.println("Tiempo de procesamiento: " + (tFin-tInicio));
		System.out.println("Vueltas: " + contVueltas);
		System.out.println("Comparaciones: " + contComparaciones);
		System.out.println("Intercambio: " + contIntercambios);
		System.out.println();
	}
}

static class Intercalacion{
	
	public static void intercalacion(int[] arregloA, int[] arregloB){

			int i,j,k;
			
			int arregloC[] = new int [arregloA.length + arregloB.length]; 
			
			//Repetir minetras los arreglos A y B tengan elementos a comparar 
			for (i = j = k = 0; i < arregloA.length &&  j < arregloB.length ; k++) {
				if (arregloA[i]< arregloB[j]) {
					arregloC[k]= arregloA[i];
					i++;
					
				}else {
					arregloC[k]=arregloB[j];
					j++;
				}
				
			}
			
			// Añadir sobrantes del arreglo A en caso de haberlos 
		for(; i < arregloA.length; i++, k++ ) {
			arregloC[k]= arregloA[i];
		    }
		// Añadir sobrantes del arreglo B en caso de haberlos 
		
		for(; j < arregloB.length; j++, k++ ) {
			arregloC[k]= arregloA[j];
		    }
		}
}

static class MezclaDirecta{
	
	public static int[] mezclaDirecta(int[] arreglo) {
		
		tInicio = System.currentTimeMillis();
		
		int i, j, k;
		
		if(arreglo.length > 1) {
			
			int nElementosIzq = arreglo.length/2;
			int nElementosDer = arreglo.length - nElementosIzq;
			int arregloIzq[] = new int[nElementosIzq];
			int arregloDer[] = new int[nElementosDer];
			
			//Cepiando los elementos al primer arreglo
			for(i = 0; i < nElementosIzq; i++) {
				arregloIzq[i] = arreglo[i];
				contIntercambios++;
			}
			//Copiando los elementos al segundo arreglo
			for (i = nElementosIzq; i < nElementosIzq + nElementosDer; i++) {
				arregloDer[i-nElementosIzq] = arreglo[i];
				contIntercambios++;
			}
			//Recursividad
			arregloIzq = mezclaDirecta(arregloIzq);
			arregloDer = mezclaDirecta(arregloDer);
			contVueltas +=2;
			
			i = 0;
			j = 0;
			k = 0;
			
			while(arregloIzq.length != j && arregloDer.length != k) {
				if(arregloIzq[j] < arregloDer[k]) {
					arreglo[i] = arregloIzq[j];
					i++;
					j++;
					contIntercambios++;
				}else {
					arreglo[i] = arregloDer[k];
					i++;
					k++;
					contIntercambios++;
				}
				contComparaciones++;
			}
			//Arreglo final
			while(arregloIzq.length != j) {
				arreglo[i] = arregloIzq[j];
				i++;
				j++;
				contIntercambios++;
			}
			while(arregloDer.length != k) {
				arreglo[i] = arregloDer[k];
				i++;
				k++;
				contIntercambios++;
			}
		}//fin del if
		
		tFin = System.currentTimeMillis();	
		
		return arreglo;
		
	}
}

	public void limpiarContadores() {
		tInicio = 0;
		tFin = 0;
		contComparaciones = 0;
		contIntercambios = 0;
		contVueltas = 0;
	}
	//Metodo para imprimir el vector
	public void mostrarVector(int vector[]) {
		System.out.println(Arrays.toString(vector));
		System.out.println("Tiempo de procesamiento: " + (tFin-tInicio));
		System.out.println("Vueltas: " + contVueltas);
		System.out.println("Comparaciones: " + contComparaciones);
		System.out.println("Intercambio: " + contIntercambios);
		System.out.println();
	}
}//class metodosOrdenamiento