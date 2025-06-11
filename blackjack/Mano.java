public class Mano {
    private Carta[] cartas = new Carta[BlackjackConstantes.MAX_CARTAS_EN_MANO];
    private int cantidad = 0;

    public void agregar(Carta carta) {
        if (cantidad < cartas.length) {
            cartas[cantidad++] = carta;
        }
    }

    public void mostrar() {
        for (int i = 0; i < cantidad; i++) {
            cartas[i].mostrar();
        }
        System.out.println(" => Total: " + calcularValor());
    }

    public int calcularValor() {
        int total = 0;
        int ases = 0;

        for (int i = 0; i < cantidad; i++) {
            total += cartas[i].getValor();
            if (cartas[i].esAs()) ases++;
        }

        while (total > BlackjackConstantes.VALOR_MAXIMO && ases > 0) {
            total -= 10;
            ases--;
        }

        return total;
    }

    public boolean estaBusted() {
        return calcularValor() > BlackjackConstantes.VALOR_MAXIMO;
    }
}

