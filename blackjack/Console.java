import java.util.Scanner;

public class Console {
    private Scanner scanner = new Scanner(System.in);

    public String readString(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }
}
