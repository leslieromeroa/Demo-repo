import java.util.Scanner;

public class GestionNotas {
    public static final int TOTAL_ALUMNOS = 10;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] notas = pedirNotas(sc, TOTAL_ALUMNOS);

        double media = calcularMedia(notas);
        int aprobados = contarAprobados(notas);
        int suspensos = TOTAL_ALUMNOS - aprobados;
        int max = obtenerMaximo(notas);
        int min = obtenerMinimo(notas);

        mostrarResumen(media, aprobados, suspensos, max, min);
        mostrarGrafico(notas);
        
        sc.close();
    }

    static int[] pedirNotas(Scanner sc, int cantidad) {
        int[] notas = new int[cantidad];
        System.out.println("Introduce las notas de los alumnos:");
        for (int i = 0; i < cantidad; i++) {
            System.out.print("Nota " + (i + 1) + ": ");
            notas[i] = sc.nextInt();
        }
        return notas;
    }

    static double calcularMedia(int[] notas) {
        int suma = 0;
        for (int nota : notas) {
            suma += nota;
        }
        return suma / (double) notas.length;
    }

    static int contarAprobados(int[] notas) {
        int count = 0;
        for (int nota : notas) {
            if (nota >= 5) {
                count++;
            }
        }
        return count;
    }

    static int obtenerMaximo(int[] notas) {
        int max = notas[0];
        for (int nota : notas) {
            if (nota > max) max = nota;
        }
        return max;
    }

    static int obtenerMinimo(int[] notas) {
        int min = notas[0];
        for (int nota : notas) {
            if (nota < min) min = nota;
        }
        return min;
    }

    static void mostrarResumen(double media, int aprobados, int suspensos, int max, int min) {
        System.out.println("\n--- RESUMEN ---");
        System.out.println("Media: " + media);
        System.out.println("Aprobados: " + aprobados);
        System.out.println("Suspensos: " + suspensos);
        System.out.println("Nota máxima: " + max);
        System.out.println("Nota mínima: " + min);
    }

    static void mostrarGrafico(int[] notas) {
        System.out.println("\n--- GRÁFICO DE NOTAS ---");
        for (int i = 0; i < notas.length; i++) {
            System.out.print("Alumno " + (i + 1) + ": ");
            for (int j = 0; j < notas[i]; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
