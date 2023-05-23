import Controlador.DataBase;
import Controlador.ViewMainController;
import Modelo.BicicletaModel;
import Modelo.CronometroModel;
import Modelo.PersonaModel;
import Modelo.RutasModel;
import Vista.ViewMenuMain;

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
        ViewMainController controller = new ViewMainController(dataBase);
        ViewMenuMain main = new ViewMenuMain(controller);
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
}
