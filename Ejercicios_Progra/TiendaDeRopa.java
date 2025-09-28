import java.util.Scanner;

public class TiendaDeRopa {
    public static void main(String[] args) {
    
        final double precioPantalon = 8.0;
        final double precioCamiseta = 5.0;
        final double precioZapato = 12.0;

       
        Scanner entrada = new Scanner(System.in);

        System.out.println("Cuanto dinero dispones para gastar?");
        double dineroCliente = entrada.nextDouble();

        System.out.println("Elige tu compra:");
        System.out.println("1. Pantalon = 8 euros");
        System.out.println("2. Camiseta = 5 euros");
        System.out.println("3. Zapatos = 12 euros");
        
        
        int eleccionDeProducto = entrada.nextInt();

        
        System.out.print("¿Cuántos productos deseas comprar?");
        int cantidadProducto = entrada.nextInt();

        double precioTotal = 0.0;  
        
        if (eleccionDeProducto == 1) {
            precioTotal = calcularTotal(cantidadProducto, precioPantalon);
        } else if (eleccionDeProducto == 2) {
            precioTotal = calcularTotal(cantidadProducto, precioCamiseta);
        } else if (eleccionDeProducto == 3) {
            precioTotal = calcularTotal(cantidadProducto, precioZapato);
        } else {
            System.out.println("Opción no válida.");
            return;  
        }

        
        String mensajeFinal = (dineroCliente >= precioTotal) 
            ? "Compra realizada con éxito! El total es: " + precioTotal + "€." 
            : "No tienes suficiente dinero. Te faltan: " + (precioTotal - dineroCliente) + "€.";

        System.out.println(mensajeFinal);

        
        entrada.close();
    }

    static double calcularTotal(int cantidad, double precioProducto) {
        return cantidad * precioProducto;
    }
}
