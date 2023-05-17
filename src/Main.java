import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static Scanner cin = new Scanner(System.in);
    public static DataBase dataBase = new DataBase();
    public static ArrayList<Rutas> rutas = new ArrayList<>();
    public static void main(String[] args) {
        Rutas ruta1 = new Rutas("Ruta A" , 5);
        Rutas ruta2 = new Rutas("Ruta B" , 2);
        Rutas ruta3 = new Rutas("Ruta C" , 3);
        Rutas ruta4 = new Rutas("Ruta D" , 15);
        rutas.add(ruta1);
        rutas.add(ruta2);
        rutas.add(ruta3);
        rutas.add(ruta4);
        rutas.set(0, ruta1);
        rutas.set(1, ruta2);
        rutas.set(2, ruta3);
        rutas.set(3, ruta4);
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
            System.out.println("1. Imprimir Base Datos\n2. Agregar Usuario\n3. Borrar Usuario\n4. Editar Usuario\n5. Ver rutas");
            System.out.print("\tOpcion: ");
            eleccion = cin.nextInt();
            switch (eleccion){
                case 1:
                    dataBase.imprimirHashMap();
                    break;
                case 2:
                    Persona persona = registrarPersonaMenu();
                    Bicicleta bicicleta = registarBicicletaMenu(persona);
                    dataBase.agregarBicicletaEnPersona(persona,bicicleta);
                    break;
            }
        }while (eleccion!=0);
    }
    public static Persona registrarPersonaMenu(){
        Persona p;
        try {
            cin.nextLine();
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
            p = new Persona(nombre,apellido,documento,numero,pass);
        }catch (Exception e){
            System.out.println("Error, intente nuevamente");
            return registrarPersonaMenu();
        }
        return p;
    }

    public static Bicicleta registarBicicletaMenu(Persona persona){
        Bicicleta b1;
        try{
            cin.nextLine();
            System.out.println("Ingrese la marca de su bicicleta: ");
            String marca1= cin.nextLine();
            System.out.println("Ingrese el id de su bicicleta: ");
            int id1 = cin.nextInt();
            cin.nextLine();
            System.out.println("Ingrese el color de su bicicleta: ");
            String color1 = cin.nextLine();
            b1 = new Bicicleta(marca1,id1,color1,persona,false);
        }catch (Exception e){
            System.out.println("Error al ingresar los datos!");
            return registarBicicletaMenu(persona);
        }
        return b1;
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
                    menuUsuariosRutas();
                    break;
                case 3:
                    dataBase.agregarBicicletaEnPersona(persona,registarBicicletaMenu(persona));
                    break;
                case 4:
                    dataBase.imprimirBicicletas(persona);
                    System.out.print("\n\tCual bicicleta vas a eliminar?: \nOpcion");
                    int biciElegir = cin.nextInt();
                    dataBase.eliminarBicicleta(persona,dataBase.buscarBicicletaUsuario(persona,biciElegir-1));
                    break;
                case 5:
                    dataBase.imprimirBicicletas(persona);
                    cin.nextLine();
                    System.out.print("\n\tCual bicicleta vas a editar?: \nOpcion");
                    int biciEditar = cin.nextInt();
                    Bicicleta bicicletaEdit = dataBase.buscarBicicletaUsuario(persona,biciEditar-1);
                    dataBase.actualizarBicicleta(persona,registarBicicletaMenu(persona),bicicletaEdit);
                default:
                    System.out.println("Opcion invalida, por favor digite una valida");

            }
        }while (eleccion!=0);
    }
    public static void menuUsuariosRutas(){
        int eleccion = 0;
        do {
            System.out.println("\n\t\t<----Menu Rutas Usuario---->\n1. Regitrar tiempo en ruta específica\n2. Ver mis tiempos en las rutas\n\tOpcion: ");
            eleccion = cin.nextInt();
            switch (eleccion){
                case 1:

                case 2:

            }
        }while (eleccion!=0);
    }
    public static void menuRegistrarTiempoRuta(){

    }
}
