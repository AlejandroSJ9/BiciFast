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
        RutasModel ruta1 = new RutasModel("Ruta A" , 20);
        rutas.add(ruta1);
        rutas.set(0, ruta1);
        ViewMainController controller = new ViewMainController(dataBase);
        ViewMenuMain main = new ViewMenuMain(controller);
    }
}
