import java.util.Scanner;

public class JuegoDados {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int puntosJ1 = 0;
        int puntosJ2 = 0;

        System.out.println("=== Juego de Dados ===");

        while (puntosJ1 < 100 && puntosJ2 < 100) {
            System.out.println("\n--- Turno J1 ---");
            puntosJ1 += jugarTurno();
            System.out.println("Puntos J1: " + puntosJ1);

            System.out.println("\n--- Turno J2 ---");
            puntosJ2 += jugarTurno();
            System.out.println("Puntos J2: " + puntosJ2);

            System.out.println("\nPresiona Enter para continuar...");
            sc.nextLine();
        }

        System.out.println("\n=== Resultado Final ===");
        if (puntosJ1 >= 100) {
            System.out.println("¡Gana J1!");
        } else {
            System.out.println("¡Gana J2!");
        }

        sc.close();
    }

    static int jugarTurno() {
        int d1 = lanzarDado();
        int d2 = lanzarDado();
        int d3 = lanzarDado();
        System.out.println("Dados: " + d1 + " " + d2 + " " + d3);

        if (d1 == d2 && d2 == d3) {
            System.out.println("¡Trío! +6 puntos");
            return 6;
        } else if (d1 == d2 || d2 == d3 || d1 == d3) {
            System.out.println("¡Par! +2 puntos");
            return 2;
        } else {
            int mayor = Math.max(d1, Math.max(d2, d3));
            System.out.println("Todos diferentes. + " + mayor + " puntos");
            return mayor;
        }
    }

    static int lanzarDado() {
        return (int) (Math.random() * 6 + 1);
    }
}
