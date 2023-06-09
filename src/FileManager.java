import Modelo.BicicletaModel;
import Modelo.PersonaModel;

import java.io.*;
import java.util.*;

public class FileManager {
    // Método para cargar un HashMap desde un archivo de texto
    public static HashMap<PersonaModel, ArrayList<BicicletaModel>> cargarHashMapDesdeArchivo(String nombreArchivo) {
        HashMap<PersonaModel, ArrayList<BicicletaModel>> hashMap = new HashMap<>();

        try {
            File archivo = new File(nombreArchivo);
            if (!archivo.exists()) {
                archivo.createNewFile();
                return hashMap;
            }

            FileInputStream fis = new FileInputStream(archivo);
            ObjectInputStream ois = new ObjectInputStream(fis);

            hashMap = (HashMap<PersonaModel, ArrayList<BicicletaModel>>) ois.readObject();

            ois.close();
            fis.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return hashMap;
    }

    // Método para guardar un HashMap en un archivo de texto
    public static void guardarHashMapEnArchivo(String nombreArchivo, HashMap<PersonaModel, ArrayList<BicicletaModel>> hashMap) {
        try {
            FileOutputStream fos = new FileOutputStream(nombreArchivo);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(hashMap);

            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
