public class Almacen {
    public static void main(String[] args) {
        
        int[][] almacen = {
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0}
        };

       
        int[] posicionAlmacen = {0, 0};

        
        imprimirAlmacen(almacen);

        agregarProductosAleatorios(almacen, 5);

      
        imprimirAlmacen(almacen);
    }


    public static void agregarProductosAleatorios(int[][] almacen, int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            
            int fila = (int) (Math.random() * almacen.length);
            int columna = (int) (Math.random() * almacen[fila].length);
            
            while (almacen[fila][columna] > 0) {
                fila = (int) (Math.random() * almacen.length);
                columna = (int) (Math.random() * almacen[fila].length);
            }
            
           
            almacen[fila][columna] = 1; 
        }
    }

    
    public static void imprimirAlmacen(int[][] almacen) {
        System.out.println("Estado actual del almacén:");
        for (int i = 0; i < almacen.length; i++) {
            for (int j = 0; j < almacen[i].length; j++) {
                System.out.print(almacen[i][j] + " "); 
            }
            System.out.println(); 
        }
     
    }
}
