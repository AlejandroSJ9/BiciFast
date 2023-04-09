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
            //Metodos crud
            System.out.println("1. Seleccionar Usuario\n2. Agregar Usuario\n3. Borrar Usuario\n4.Editar Usuario\n5. Ver rutas");
            System.out.print("\tOpcion: ");
            eleccion = cin.nextInt();
            switch (eleccion){
                case 1:
                    menuUsuarios("maria");
                    break;
                case 2:
                    //Se pidio el ingreso de la bicicleta y los datos del usuario
                    Scanner cin = new Scanner(System.in);
                    System.out.println("Ingrese la marca de su bicicleta: ");
                    String marca= cin.nextLine();
                    System.out.println("Ingrese el id de su bicicleta: ");
                    int id = cin.nextInt();
                    cin.nextLine();
                    System.out.println("Ingrese el color de su bicicleta: ");
                    String color = cin.nextLine();
                    System.out.println("Digite su nombre: ");
                    String nombre = cin.nextLine();
                    System.out.println("Digite sus apellidos: ");
                    String apellido = cin.nextLine();
                    System.out.println("Digite su numero de documento: ");
                    int documento = cin.nextInt();
                    cin.nextLine();
                    System.out.println("Digite su numero de celular: ");
                    String numero = cin.nextLine();
                    // se creo un objeto de la clase bicicleta y persona donde se envian los datos pedidos anteriormente
                    Bicicleta bicicleta = new Bicicleta(marca,id,color,new Persona(nombre,apellido,documento,numero));

                    break;

            }
        }while (eleccion!=0);
    }
    public static void menuUsuarios(String nombreUser){
        int eleccion = 0;
        do {
            System.out.println("\n\t\t<------MENU USUARIO----->\n\t\tUsuario: "+ nombreUser);
            System.out.println("1. Ver bicicletas\n2. Rutas\n3. Registrar bici");
            System.out.println("1. Seleccionar Usuario\n2. Registrar Bicicletas\n3. Visualizar bicicletas\n4. Editar usuario\n0.Salir");
            System.out.print("\tOpcion: ");
            eleccion = cin.nextInt();

            switch (eleccion){
                case 1:

                    break;
                case 2:

                    break;
                case 3:
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Opcion invalida, por favor digite una valida");

            }
            switch (eleccion){
                case 1:
                    break;
                case 2:
            }
        }while (eleccion!=0);
    }
}
