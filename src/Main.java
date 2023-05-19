import Controlador.DataBase;
import Controlador.ViewMainController;
import Modelo.BicicletaModel;
import Modelo.CronometroModel;
import Modelo.PersonaModel;
import Modelo.RutasModel;
import Vista.ViewMain;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static Scanner cin = new Scanner(System.in);
    public static DataBase dataBase = new DataBase();
    public static ArrayList<RutasModel> rutas = new ArrayList<>();
    public static void main(String[] args) {
        RutasModel ruta1 = new RutasModel("Ruta A" , 5);
        RutasModel ruta2 = new RutasModel("Ruta B" , 2);
        RutasModel ruta3 = new RutasModel("Ruta C" , 3);
        RutasModel ruta4 = new RutasModel("Ruta D" , 15);
        rutas.add(ruta1);
        rutas.add(ruta2);
        rutas.add(ruta3);
        rutas.add(ruta4);
        rutas.set(0, ruta1);
        rutas.set(1, ruta2);
        rutas.set(2, ruta3);
        rutas.set(3, ruta4);
        //menuInicio();
        ViewMainController controller = new ViewMainController();
        ViewMain main = new ViewMain(controller);
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
                    PersonaModel personaModel = registrarPersonaMenu();
                    BicicletaModel bicicletaModel = registarBicicletaMenu(personaModel);
                    dataBase.agregarBicicletaEnPersona(personaModel, bicicletaModel);
                    break;
            }
        }while (eleccion!=0);
    }
    public static PersonaModel registrarPersonaMenu(){
        PersonaModel p;
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
            p = new PersonaModel(nombre,apellido,documento,numero,pass);
        }catch (Exception e){
            System.out.println("Error, intente nuevamente");
            return registrarPersonaMenu();
        }
        return p;
    }

    public static BicicletaModel registarBicicletaMenu(PersonaModel personaModel){
        BicicletaModel b1;
        try{
            cin.nextLine();
            System.out.println("Ingrese la marca de su bicicleta: ");
            String marca1= cin.nextLine();
            System.out.println("Ingrese el id de su bicicleta: ");
            int id1 = cin.nextInt();
            cin.nextLine();
            System.out.println("Ingrese el color de su bicicleta: ");
            String color1 = cin.nextLine();
            b1 = new BicicletaModel(marca1,id1,color1, personaModel,false);
        }catch (Exception e){
            System.out.println("Error al ingresar los datos!");
            return registarBicicletaMenu(personaModel);
        }
        return b1;
    }
    public static void menuUsuarios(PersonaModel personaModel){
        int eleccion = 0;
        do {
            System.out.println("\n\t\t<------MENU USUARIO----->\n\t\tUsuario: "+ personaModel.getNombre());
            System.out.println("1. Ver bicicletas\n2. Rutas\n3. Registrar bici\n4. Eliminar bici\n5. Actualizar bici");
            System.out.print("\tOpcion: ");
            eleccion = cin.nextInt();

            switch (eleccion){
                case 1:
                    dataBase.imprimirBicicletas(personaModel);
                    break;
                case 2:
                    menuUsuariosRutas();
                    break;
                case 3:
                    dataBase.agregarBicicletaEnPersona(personaModel,registarBicicletaMenu(personaModel));
                    break;
                case 4:
                    dataBase.imprimirBicicletas(personaModel);
                    System.out.print("\n\tCual bicicleta vas a eliminar?: \nOpcion");
                    int biciElegir = cin.nextInt();
                    dataBase.eliminarBicicleta(personaModel,dataBase.buscarBicicletaUsuario(personaModel,biciElegir-1));
                    break;
                case 5:
                    dataBase.imprimirBicicletas(personaModel);
                    cin.nextLine();
                    System.out.print("\n\tCual bicicleta vas a editar?: \nOpcion");
                    int biciEditar = cin.nextInt();
                    BicicletaModel bicicletaModelEdit = dataBase.buscarBicicletaUsuario(personaModel,biciEditar-1);
                    dataBase.actualizarBicicleta(personaModel,registarBicicletaMenu(personaModel), bicicletaModelEdit);
                default:
                    System.out.println("Opcion invalida, por favor digite una valida");

            }
        }while (eleccion!=0);
    }
    public static void menuUsuariosRutas(){
        CronometroModel cronometro = new CronometroModel();
        int eleccion = 0;
        do {
            System.out.println("\n\t\t<----Menu Rutas Usuario---->\n1. Regitrar tiempo en ruta específica\n2. Ver mis tiempos en las rutas\n\tOpcion: ");
            eleccion = cin.nextInt();
            switch (eleccion){
                case 1:
                    String rpt;
                    System.out.println("Presione Enter para iniciar el cronometro: ");
                    cin.nextLine();
                    rpt= cin.nextLine();
                    System.out.println("Tiempo: ");
                    cronometro.iniciar();
                    cronometro.pausar();
                    break;
                case 2:
            }
        }while (eleccion!=0);
    }
    public static void menuRegistrarTiempoRuta(){

    }
}
