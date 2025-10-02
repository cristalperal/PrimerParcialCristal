import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //String[] arr = {"A", "B", "C", "D", "E", "F", "G", "H"};
        // int t = 3;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese los elementos deseados, separado de espacios, la cantidad debe ser par:");
        String[] arr = sc.nextLine().split(" ");

        int n = arr.length;
        if (n % 2 != 0) {
            System.out.println("¡El número de elementos debe ser par!");
            return;
        }

        System.out.println("Ingrese el valor de T: ");
        int t = sc.nextInt();

        if (t < 1 || t > n) {
            System.out.println("\n Valor de T invalido! ");
        }
        int middle = n / 2;
        System.out.println("Arreglo inicial: ");
        System.out.println(Arrays.toString(arr));

        // Primer algoritmo
        // Algoritmo el cual recorre la cantidad de veces a mover los elementos del arreglo.
        // Usamos un for principal para esto, dentro un for por si el número de iteraciones es impar se va hacia a la izquierda y otro
        // que en el caso contrario va hacia la derecha.
        // La complejidad de este algoritmo va a depender de el número de iteraciones y el tamaño del arreglo.
        // Los casos internos son O(n) en el peor de los casos y como t y n son valores de entrada independientes puede llegar a O(t*n)

        long inicio = System.nanoTime();
        for (int i = 1; i <= t; i++) {
            // izquierda
            if (i % 2 != 0) {
                String arrT = arr[middle - 1];

                for (int j = middle - 1; j > 0; j--) {
                    arr[j] = arr[j - 1];
                }
                arr[0] = arrT;

            } else { // derecha
                String arrT = arr[middle];
                for (int j = middle; j < n - 1; j++) {
                    arr[j] = arr[j + 1];
                }
                arr[n - 1] = arrT;
            }
        }
        System.out.println("\n--Primer algoritmo--");
        System.out.println(Arrays.toString(arr));

        long fin = System.nanoTime();
        long tiempo = fin - inicio;
        System.out.println("Tiempo: " + tiempo + " nanosegundos\n");

        //Segundo algortimo hecho en clase - Prueba de complejidad

       /* long inicio2 = System.nanoTime();
        int half = arr.length / 2;
        for (int i = 1; i <= t; i++) {
            String[] copy = Arrays.copyOf(arr, arr.length);

            if (i % 2 != 0) {
                String[] copyOfRange = Arrays.copyOfRange(copy, 0, half - 1);
                arr[0] = copy[half - 1];
                Arrays.setAll(copyOfRange, index -> {
                    arr[index + 1] = copyOfRange[index];
                    return "";
                });

            } else {
                String[] copyOfRange = Arrays.copyOfRange(copy, half, arr.length - 1);
                arr[half] = copy[arr.length - 1];
                Arrays.setAll(copyOfRange, index -> {
                    int value = half + index;
                    arr[value + 1] = copyOfRange[index];
                    return "";
                });
            }
        }
        System.out.println("--Segundo algoritmo--");
        System.out.println(Arrays.toString(arr));
        long fin2 = System.nanoTime();
        long tiempo2 = fin2 - inicio2;
        System.out.println("Tiempo del segundo algoritmo: " + tiempo2 + " nanosegundos"); */
    }
}