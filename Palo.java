import java.util.ArrayList;
import java.util.List;

public class Descarte {
    private final List<Carta> cartas;

    public Descarte() {
        cartas = new ArrayList<>();
    }

    public void agregarCarta(Carta carta) {
        if (carta != null) {
            carta.voltear();
            cartas.add(carta);
        }
    }

    public Carta verUltimaCarta() {
        if (cartas.isEmpty()) {
            return null;
        }
        return cartas.get(cartas.size() - 1);
    }
}
