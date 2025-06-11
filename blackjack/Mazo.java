public class Mazo {
    private Carta[] cartas = new Carta[BlackjackConstantes.TOTAL_CARTAS];
    private int tope = 0;

    public Mazo() {
        int index = 0;
        for (int palo = 0; palo < 4; palo++) {
            for (int numero = 0; numero < 13; numero++) {
                cartas[index++] = new Carta(palo, numero);
            }
        }
        tope = BlackjackConstantes.TOTAL_CARTAS;
        barajar();
    }

    private void barajar() {
        for (int i = 0; i < tope; i++) {
            int j = (int)(Math.random() * tope);
            Carta temp = cartas[i];
            cartas[i] = cartas[j];
            cartas[j] = temp;
        }
    }

    public Carta sacar() {
        if (tope == 0) return null;
        return cartas[--tope];
    }

    public boolean estaVacio() {
        return tope == 0;
    }
}
