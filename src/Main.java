import java.util.Scanner;

public class Main {
    public static Scanner cin = new Scanner(System.in);
    public static void main(String[] args) {
        menuPrincipal();
    }
    public static void menuPrincipal(){
        int eleccion = 0;
        do {
            System.out.println("\n\t\t<------MENU PRINCIPAL----->");
            System.out.println("1. Seleccionar Usuario\n2. Registrar Bicicletas\n3. Visualizar bicicletas\n4. Editar usuario");
            System.out.print("\tOpcion: ");
            eleccion = cin.nextInt();
        }while (eleccion!=0);
        
        
    }
}
