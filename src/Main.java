import java.util.Scanner;

public class Main {
    public static Scanner cin = new Scanner(System.in);
    public static void main(String[] args) {
        menuPrincipal();
    }
    public static void menuPrincipal(){
        int eleccion = -1;
        do {
            System.out.println("\n\t\t<------MENU PRINCIPAL----->");
            System.out.println("1. Seleccionar Usuario\n2. Visualizar bicicletas\n3. Editar usuario\n5. Ver rutas");
            System.out.print("\tOpcion: ");
            eleccion = cin.nextInt();
            switch (eleccion){
                case 1:
                    menuUsuarios("maria");
                    break;
                case 2:
            }
        }while (eleccion!=0);
    }
    public static void menuUsuarios(String nombreUser){
        int eleccion = 0;
        do {
            System.out.println("\n\t\t<------MENU USUARIO----->\n\t\tUsuario: "+ nombreUser);
            System.out.println("1. Ver bicicletas\n2. Rutas\n3. Registrar bici");
            System.out.print("\tOpcion: ");
            eleccion = cin.nextInt();
            switch (eleccion){
                case 1:
                    break;
                case 2:
            }
        }while (eleccion!=0);
    }
}
