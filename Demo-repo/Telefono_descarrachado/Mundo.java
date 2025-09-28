import java.util.Scanner;

class Mundo {
    private Ludoteca ludoteca;
    private int tiempoTotal;
    private Scanner scanner;

    public Mundo(Ludoteca unaLudoteca, int tiempoApertura) {
        ludoteca = unaLudoteca;
        tiempoTotal = tiempoApertura;
        scanner = new Scanner(System.in);
    }

    public void iniciarSimulacion() {
        for (int minuto = 0; minuto < tiempoTotal; minuto++) {
            System.out.println("=".repeat(30));
            System.out.println("Minuto " + minuto);

            if (llegaNiño()) {
                Niño niño = generarNiño();
                ludoteca.recibirNiño(niño);
            }

            ludoteca.actualizar();
            ludoteca.verEstado();

            scanner.nextLine();
        }
    }

    private boolean llegaNiño() {
        return Math.random() > 0.5;
    }

    private Niño generarNiño() {
        String nombre = inventarNombre();
        System.out.println("Llega " + nombre);
        return new Niño(nombre);
    }

    private String inventarNombre() {
        String[] nombres = {
            "Andrés Elías A.C.", "Pablo A.D.A.", "Diego Alejandro B.M.", "Aníbal B.G.",
            "Umut B.", "Javier Enrique C.S.", "Fernando William C.M.", "Pablo C.R.",
            "Cayetano C.R.", "Iker C.B.", "Mario D.R.M.", "Adrián D.Q.", "Paula Qing D.G.",
            "Veronika Alexandra E.M.", "Eduardo David E.R.", "Hugo F.N.", "Adrián G.A.",
            "David G.C.", "César G.E.", "Diego G.N.", "Miguel G.C.", "Santiago G.D.L.T.R.",
            "Juan René I.S.J.", "Pablo L.T.", "Daniel L.A.", "Álvaro L.S.", "Maura M.N.",
            "Neco M.S.", "Diego M.T.", "Sergio Alejandro M.R.", "Sebastián N.R."
        };
        return nombres[(int) (Math.random() * nombres.length)];
    }

    public static void main(String[] args) {
        Ludoteca ludoteca = new Ludoteca();
        Mundo mundo = new Mundo(ludoteca, 120);
        mundo.iniciarSimulacion();
    }
}
