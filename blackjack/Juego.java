public class Juego {
    private Mazo mazo;
    private Mano jugador;
    private Mano dealer;
    private Console console;

    public Juego() {
        mazo = new Mazo();
        jugador = new Mano();
        dealer = new Mano();
        console = new Console();
    }

    public void jugar() {
        jugador.agregar(mazo.sacar());
        dealer.agregar(mazo.sacar());
        jugador.agregar(mazo.sacar());
        dealer.agregar(mazo.sacar());

        System.out.println("Tu mano:");
        jugador.mostrar();
        System.out.println("Carta visible del dealer:");
        dealer.mostrar();

        while (!jugador.estaBusted()) {
            String opcion = console.readString("¿Otra carta? (s/n): ");
            if (opcion.equalsIgnoreCase("s")) {
                jugador.agregar(mazo.sacar());
                jugador.mostrar();
            } else {
                break;
            }
        }

        if (jugador.estaBusted()) {
            System.out.println("¡Te pasaste! Pierdes.");
            return;
        }

        while (dealer.calcularValor() < Blackjack.VALOR_DEALER_MINIMO) {
            dealer.agregar(mazo.sacar());
        }

        System.out.println("Mano del dealer:");
        dealer.mostrar();

        int totalJugador = jugador.calcularValor();
        int totalDealer = dealer.calcularValor();

        if (dealer.estaBusted() || totalJugador > totalDealer) {
            System.out.println("¡Ganaste!");
        } else if (totalJugador < totalDealer) {
            System.out.println("Perdiste.");
        } else {
            System.out.println("Empate.");
        }
    }
}
