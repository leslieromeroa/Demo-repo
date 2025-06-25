import java.util.Scanner;


class CalculadorPreguntas {

    private int numeroCarnet;

    public CalculadorPreguntas(int numeroCarnet) {
        this.numeroCarnet = numeroCarnet;
    }

    private int[] obtenerDigitos() {
        int[] digitos = new int[10];
        int temp = numeroCarnet;
        for (int i = 9; i >= 0; i--) {
            digitos[i] = temp % 10;
            temp /= 10;
        }
        return digitos;
    }

    private int contarCoincidencias(int[] array, int valor) {
        int count = 0;
        for (int i : array) {
            if (i == valor) {
                count++;
            }
        }
        return count;
    }

    public int[] calcularPreguntas() {
        int[] digitos = obtenerDigitos();

        int sumaPares = 0;
        int sumaImpares = 0;

        for (int i = 0; i < digitos.length; i += 2) {
            sumaPares += digitos[i];
        }

        for (int i = 1; i < digitos.length; i += 2) {
            sumaImpares += digitos[i];
        }

      
        int pregunta1 = (sumaPares % 6);
        int pregunta2 = ((sumaImpares % 6) + 1); 
        if(pregunta1 == 0) pregunta1 = 6; 6
        if(pregunta2 == 0) pregunta2 = 6;

        int pregunta3 = ((sumaPares + sumaImpares) % 6) + 1;

        int[] preguntas = {pregunta1, pregunta2, pregunta3};

       
        for (int i = 0; i < preguntas.length; i++) {
            while (contarCoincidencias(preguntas, preguntas[i]) > 1) {
                preguntas[i]++;
                if (preguntas[i] > 6) {
                    preguntas[i] = 1;
                }
            }
        }
        return preguntas;
    }
}


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese su número de carnet: ");
        int numeroCarnet = scanner.nextInt();

        CalculadorPreguntas calculador = new CalculadorPreguntas(numeroCarnet);

        int[] preguntas = calculador.calcularPreguntas();

        System.out.println("Las preguntas que debe contestar son:");
        for (int pregunta : preguntas) {
            System.out.println(pregunta);
        }

        scanner.close();
    }
}
