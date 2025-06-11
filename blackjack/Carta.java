public class Carta {
    private int palo;
    private int numero;

    private final String[] PALOS = {"♠️", "♣️", "♦️", "♥️"};
    private final String[] NUMEROS = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

    public Carta(int palo, int numero) {
        this.palo = palo;
        this.numero = numero;
    }

    public void mostrar() {
        System.out.print("[" + NUMEROS[numero] + PALOS[palo] + "] ");
    }

    public int getValor() {
        if (numero == 0) return Blackjack.VALOR_AS;
        if (numero >= 10) return Blackjack.VALOR_FIGURA;
        return numero + 1;
    }

    public boolean esAs() {
        return numero == 0;
    }
}
