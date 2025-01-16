public class Ascensor {
    public static void main(String[] args) {
        int[] solicitudes = {3, 1, 5, 2}; 
        int pisoActual = 0;
        int personasDentro = 0;

        while (personasDentro > 0 || solicitudes.length > 0) {
            int siguientePiso = pisoSiguiente(solicitudes, pisoActual);
            pisoActual = siguientePiso;
            System.out.println("Moviéndose al piso: " + pisoActual);

        
            solicitudes = actualizarSolicitudes(solicitudes, pisoActual);
            personasDentro = actualizarPersonas(personasDentro, pisoActual);

            System.out.println("Personas dentro: " + personasDentro);
        }

        System.out.println("El ascensor ha terminado su recorrido.");
    }

   
    public static int pisoSiguiente(int[] solicitudes, int pisoActual) {
        int siguientePiso = -1;
        int diferenciaMinima = 9999; 

        for (int i = 0; i < solicitudes.length; i++) {
            int diferencia = Math.abs(solicitudes[i] - pisoActual);
            if (diferencia < diferenciaMinima) {
                diferenciaMinima = diferencia;
                siguientePiso = solicitudes[i];
            }
        }
        return siguientePiso;
    }


    public static int[] actualizarSolicitudes(int[] solicitudes, int pisoActual) {
      
        int[] nuevasSolicitudes = new int[solicitudes.length - 1];
        int index = 0;

        for (int i = 0; i < solicitudes.length; i++) {
            if (solicitudes[i] != pisoActual) {
                nuevasSolicitudes[index] = solicitudes[i];
                index++;
            }
        }
        return nuevasSolicitudes;
    }

    public static int actualizarPersonas(int personasDentro, int pisoActual) {
        if (pisoActual == 0) {
            return 0; 
        } else {
            return personasDentro + 1; 
        }
    }
}
