import java.util.scanner;

public class controlDeNotas {
    public static void main(String[] args) {
        
        Scanner entrada = new Scanner(System.in);

        static String verificarAprobacion (double nota){
            if (nota>= 5){
                return "aprobado";
            }else{
                return "Suspendido";
            }
        System.out.print("Introduce la nota del estudiante (0-10): ");
        double nota = entrada.nextDouble();

        String resultado = verificarAprobacion;

        System.out.println('El estudiante obtuvo + resultado' + resultado);

        entrada.close();

        static String verificarAprobacion (double nota){
            if (nota>= 5){
                return "aprobado";
            }else{
                return "Suspendido";
            }
        }   
    }
