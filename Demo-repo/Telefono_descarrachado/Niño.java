import java.util.Random;

class Nino {
    private String nombre;
    private Pizarra pizarrin;
    private Random random;

    public Nino(String nombre) {
        this.nombre = nombre;
        this.random = new Random();
    }

    public void recibirPizarrin(Pizarra pizarra) {
        this.pizarrin = pizarra;
    }

    public String getNombre() {
        return nombre;
    }

    public void recibirMensaje(String mensaje) {
        if (pizarrin != null) {
            pizarrin.escribirMensaje(modificarMensaje(mensaje));
            System.out.println("[" + nombre + "] recibe [" + mensaje + "] y ha escrito [" + pizarrin.leerMensaje() + "]");
        }
    }

    private String modificarMensaje(String mensaje) {
        final String ALFABETO = "abcdefghijklmnopqrstuvwxyz";

        for (int i = 0; i < 2; i++) {
            int indiceAleatorio = random.nextInt(mensaje.length());
            char letraAleatoria = ALFABETO.charAt(random.nextInt(ALFABETO.length()));
            mensaje = mensaje.substring(0, indiceAleatorio) + letraAleatoria + mensaje.substring(indiceAleatorio + 1);
        }
        return mensaje;
    }

    public String mostrarMensaje() {
        return pizarrin != null ? pizarrin.leerMensaje() : "";
    }

    public void limpiarPizarrin() {
        if (pizarrin != null) {
            pizarrin.limpiar();
        }
    }
}
