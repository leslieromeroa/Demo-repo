import java.util.Scanner;

public class CalculadoraEstadistica {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int cantidad = pedirCantidad(entrada);
        double suma = 0;
        double sumaCuadrados = 0;

        for (int i = 1; i <= cantidad; i++) {
            double numero = pedirNumero(entrada, i);
            suma += numero;
            sumaCuadrados += numero * numero;
        }

        double media = calcularMedia(suma, cantidad);
        double desviacion = calcularDesviacion(sumaCuadrados, suma, cantidad);

        mostrarResultados(media, desviacion);

        entrada.close();
    }

    static int pedirCantidad(Scanner entrada) {
        int cantidad;
        do {
            System.out.print("¿Cuántos números vas a ingresar? ");
            cantidad = entrada.nextInt();
        } while (cantidad <= 0);
        return cantidad;
    }

    static double pedirNumero(Scanner entrada, int indice) {
        System.out.print("Número " + indice + ": ");
        return entrada.nextDouble();
    }

    static double calcularMedia(double suma, int cantidad) {
        return suma / cantidad;
    }

    static double calcularDesviacion(double sumaCuadrados, double suma, int cantidad) {
        double media = suma / cantidad;
        return Math.sqrt(sumaCuadrados / cantidad - media * media);
    }

    static void mostrarResultados(double media, double desviacion) {
        System.out.println("===========================================");
        System.out.println("Media: " + media);
        System.out.println("Desviación estándar: " + desviacion);
        System.out.println("===========================================");
    }
}
