import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean ejecutando = true;

        while (ejecutando) {
            mostrarEstado();
            mostrarMenu();

            System.out.print("Elige una opción [1-9]: ");
            int opcion = scanner.nextInt();
            
            switch (opcion) {
                case 1 -> moverBarajaADescarte();
                case 2 -> moverDescarteAPalo();
                case 3 -> moverDescarteAColumna();
                case 4 -> moverPaloAColumna();
                case 5 -> moverColumnaAPalo();
                case 6 -> moverColumnaAColumna();
                case 7 -> voltearColumna();
                case 8 -> voltearDescarteEnBaraja();
                case 9 -> {
                    System.out.println("👋 Saliendo del juego.");
                    ejecutando = false;
                }
                default -> System.out.println("⚠️ Opción inválida. Intenta de nuevo.");
            }

            System.out.println();
        }

        scanner.close();
    }

    private static void moverBarajaADescarte() {
        System.out.println("➡️ Mover de Baraja a Descarte");
    }

    private static void moverDescarteAPalo() {
        System.out.println("➡️ Mover de Descarte a Palo");
    }

    private static void moverDescarteAColumna() {
        System.out.println("➡️ Mover de Descarte a Columna");
    }

    private static void moverPaloAColumna() {
        System.out.println("➡️ Mover de Palo a Columna");
    }

    private static void moverColumnaAPalo() {
        System.out.println("➡️ Mover de Columna a Palo");
    }

    private static void moverColumnaAColumna() {
        System.out.println("➡️ Mover de Columna a Columna");
    }

    private static void voltearColumna() {
        System.out.println("➡️ Voltear carta de Columna");
    }

    private static void voltearDescarteEnBaraja() {
        System.out.println("➡️ Voltear Descarte en Baraja");
    }

    private static void mostrarMenu() {
        System.out.println("OPCIONES>");
        System.out.println("  1. Mover de Baraja a Descarte");
        System.out.println("  2. Mover de Descarte a Palo");
        System.out.println("  3. Mover de Descarte a Columna");
        System.out.println("  4. Mover de Palo a Columna");
        System.out.println("  5. Mover de Columna a Palo");
        System.out.println("  6. Mover de Columna a Columna");
        System.out.println("  7. Voltear carta de Columna");
        System.out.println("  8. Voltear Descarte en Baraja");
        System.out.println("  9. Salir");
        System.out.println();
    }

    private static void mostrarEstado() {
        System.out.println("BARAJA: [? ?]");
        System.out.println("Descarte: [Q ♦️][7 ♦️][9 ♣️]\n");

        System.out.println("1º Palo: [A ♥️]");
        System.out.println("2º Palo: [A ♦️]");
        System.out.println("3º Palo: No hay cartas en el palo");
        System.out.println("4º Palo: No hay cartas en el palo\n");

        System.out.println("Columna [1]: [3 ♠️]");
        System.out.println("Columna [2]: [K ♥️]");
        System.out.println("Columna [3]: [? ?][? ?][7 ♠️]");
        System.out.println("Columna [4]: [? ?][? ?][? ?]");
        System.out.println("Columna [5]: [? ?][? ?][? ?][? ?][X ♥️]");
        System.out.println("Columna [6]: [? ?][? ?][? ?][? ?][? ?][6 ♥️]");
        System.out.println("Columna [7]: [? ?][? ?][? ?][? ?][? ?][? ?][9 ♥️]");
        System.out.println();
    }
}
