import java.util.Scanner;

public class Main {
    public static Scanner cin = new Scanner(System.in);
    public static DataBase dataBase = new DataBase();
    public static void main(String[] args) {
        menuInicio();
    }
    //menu que se pone apenas se ejecuta el programa
    public static void menuInicio(){
        Scanner scanner = new Scanner(System.in);
        int eleccion;
        do{
            System.out.print("\n\t\t<----MENU INGRESO---->\n1. Ingreso ADMIN\n2. Ingreso usuarios\n\tOpcion: ");
            eleccion = cin.nextInt();
            cin.nextLine();
            switch (eleccion){
                case 1:
                    menuPrincipalAdministrador();
                    break;
                case 2:
                    System.out.println("Ingresa solo tu nombre: ");
                    String nombre = cin.nextLine();
                    System.out.println("Ingresa tu contraseña: ");
                    String pass = cin.nextLine();
                    //verifica si la persona que trajo existe en la base de datos
                    if(dataBase.validarLogIn(nombre,pass) == null){
                        System.out.println("Datos incorrectos");
                        break;
                    }else{
                        Persona p = dataBase.validarLogIn(nombre,pass);
                        menuUsuarios(p);
                    }
            }
        }while(eleccion!=0);
    }
    public static void menuPrincipalAdministrador(){
        int eleccion = -1;
        do {
            System.out.println("\n\t\t<------MENU PRINCIPAL----->");
            //Metodos crud
            System.out.println("1. Listas Usuario\n2. Agregar Usuario\n3. Borrar Usuario\n4. Editar Usuario\n5. Ver rutas");
            System.out.print("\tOpcion: ");
            eleccion = cin.nextInt();
            switch (eleccion){
                case 1:

                    break;
                case 2:
                    //Ingreso de la bicicleta y los datos del usuario
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
                    System.out.println("Ingrese su contraseña: ");
                    String pass = cin.nextLine();
                    // se creo un objeto de la clase bicicleta y persona donde se envian los datos pedidos anteriormente
                    Bicicleta bicicleta = new Bicicleta(marca,id,color,new Persona(nombre,apellido,documento,numero,pass));
                    // Creacion objeto persona
                    Persona persona = new Persona(nombre,apellido,documento,numero,pass);
                    dataBase.agregarBicicletaEnPersona(persona,bicicleta);
                    break;

            }
        }while (eleccion!=0);
    }
    public static void menuUsuarios(Persona persona){
        int eleccion = 0;
        do {
            System.out.println("\n\t\t<------MENU USUARIO----->\n\t\tUsuario: "+ persona.getNombre());
            System.out.println("1. Ver bicicletas\n2. Rutas\n3. Registrar bici\n4. Eliminar bici\n5. Actualizar bici");
            System.out.print("\tOpcion: ");
            eleccion = cin.nextInt();

            switch (eleccion){
                case 1:
                        dataBase.imprimirBicicletas(persona);
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
