import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        System.out.print("Cantidad de estudiantes: ");
        int n = sc.nextInt();

        List<Estudiante> lista = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int matricula = 100 + rand.nextInt(900);
            double indice = Math.round(rand.nextDouble() * 40.0) / 10.0; // 0.0 a 4.0
            lista.add(new Estudiante(matricula, "Estudiante #" + (i + 1), indice));
        }

        System.out.println("\nLista desordenada:");
        for (Estudiante e : lista) {
            System.out.println(e);
        }

        System.out.print("\n¿Desea ordenar ascendentemente? (true-false): ");
        boolean asc = sc.nextBoolean();

        List<Estudiante> ordenados = ordenarMergeSort(lista, asc);

        System.out.println("\nLista ordenada:");
        for (Estudiante e : ordenados) {
            System.out.println(e);
        }

        sc.close();
    }

    /* Usamos la entrada de datos random para el mejor manejo.
       Primero valida si la lista está vacía o tiene un solo elemento, en cuyo caso no se realizan
       operaciones. Luego aplicamos divide y vencerás, dividiendo la lista en dos mitades de manera
       recursiva hasta que cada sublista tenga un único elementos, después cuando va a mezclar,
       compara los elementos de ambas mitades ya ordenadas y los une en una nueva lista.
*/
    public static List<Estudiante> ordenarMergeSort(List<Estudiante> listaSinOrdenar, boolean ascendente) {
        //Validador en caso de que la lista no tenga estudiantes o solo un 1 estudiante
        if (listaSinOrdenar.size() <= 1) {
            return listaSinOrdenar;
        }

        int mid = listaSinOrdenar.size() / 2;
        List<Estudiante> izquierda = ordenarMergeSort(new ArrayList<>(listaSinOrdenar.subList(0, mid)), ascendente);
        List<Estudiante> derecha = ordenarMergeSort(new ArrayList<>(listaSinOrdenar.subList(mid, listaSinOrdenar.size())), ascendente);

        return merge(izquierda, derecha, ascendente);
    }

    private static List<Estudiante> merge(List<Estudiante> izquierda, List<Estudiante> derecha, boolean ascendente) {
        List<Estudiante> resultado = new ArrayList<>();
        int i = 0, j = 0;

        while (i < izquierda.size() && j < derecha.size()) {
            boolean condicion;
            if (ascendente) {
                condicion = izquierda.get(i).indiceAcademico <= derecha.get(j).indiceAcademico;
            } else {
                condicion = izquierda.get(i).indiceAcademico >= derecha.get(j).indiceAcademico;
            }

            if (condicion) {
                resultado.add(izquierda.get(i++));
            } else {
                resultado.add(derecha.get(j++));
            }
        }
        while (i < izquierda.size()) {
            resultado.add(izquierda.get(i++));
        }
        while (j < derecha.size()){
            resultado.add(derecha.get(j++));
        }

        return resultado;
    }
}