public class controlClientes {

    public static void main(String[] args) {
        int[] clientes = new int[10]; 
        boolean[] cajaOcupada = { false, false }; 
        int totalClientes = 0;

      
        for (int i = 0; i < clientes.length; i++) {
            if (Math.random() < 0.5) { 
                clientes[i] = 3; 
                totalClientes++;
            }
        }

        while (totalClientes > 0) {
           
            estadoDeCaja(clientes, cajaOcupada);
            totalClientes = calcularClientesEnFila(clientes);
        }
        System.out.println("Todos los clientes han sido atendidos.");
    }

    public static int calcularClientesEnFila(int[] clientes) {
        int total = 0;
        for (int cliente : clientes) {
            if (cliente > 0) {
                total++;
            }
        }
        return total;
    }

   
    public static void estadoDeCaja(int[] clientes, boolean[] cajaOcupada) {
        for (int i = 0; i < cajaOcupada.length; i++) {
            if (!cajaOcupada[i]) {
                for (int j = 0; j < clientes.length; j++) {
                    if (clientes[j] > 0) {
                       
                        clienteListo(clientes, j);
                        cajaOcupada[i] = true;
                        break; 
                    }
                }
            }
        }

   
        for (int i = 0; i < cajaOcupada.length; i++) {
            if (cajaOcupada[i]) {
                System.out.println("Caja " + (i + 1) + " ocupada.");
            } else {
                System.out.println("Caja " + (i + 1) + " vacía.");
            }
        }
    }

    public static void clienteListo(int[] clientes, int clienteIndex) {
        clientes[clienteIndex]--;
        if (clientes[clienteIndex] == 0) {
            System.out.println("Cliente en posición " + clienteIndex + " listo.");
        }
    }
}
