import java.util.Scanner;

public class escalasAcordes {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

       
        System.out.println("Ingrese la nota a trabajar: 1: Do, 2: Do#, 3: Re, 4: Re#, 5: Mi, 6: Fa, 7: Fa#, 8: Sol, 9: Sol#, 10: La, 11: La#, 12: Si");
        int opcion = scanner.nextInt(); 

        String[] notas = {"Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si"};
        String[] tonosYSemitonos = {"T", "T", "S", "T", "T", "T", "S"}; 

        
        int indexNotaBase = opcion - 1;  
        StringBuilder escala = new StringBuilder();
        int[] posiciones = new int[8];  
        posiciones[0] = indexNotaBase;

        for (int i = 1; i < posiciones.length; i++) {
            int siguientePos = (posiciones[i - 1] + (tonosYSemitonos[i - 1].equals("T") ? 2 : 1)) % 12;
            posiciones[i] = siguientePos;
        }


        System.out.print("Ha elegido la nota " + notas[indexNotaBase] + "\nLa escala de " + notas[indexNotaBase] + " Mayor es: ");
        for (int i = 0; i < posiciones.length; i++) {
            escala.append("[").append(notas[posiciones[i]]).append("]");
            if (i < posiciones.length - 1) {
                escala.append(" / ");
            }
        }
        System.out.println(escala.toString());

        
        String acorde = "[" + notas[posiciones[0]] + "] / [" + notas[(posiciones[0] + 4) % 12] + "] / [" + notas[(posiciones[0] + 7) % 12] + "]";
        System.out.println("El acorde de " + notas[indexNotaBase] + " Mayor está conformado por: " + acorde);
        
        
        scanner.close();
    }
}

