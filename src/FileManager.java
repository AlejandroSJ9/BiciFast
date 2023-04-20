import java.io.*;
import java.util.*;

public class FileManager implements Serializable{
    // Método para cargar un HashMap desde un archivo de texto

    public FileManager() {
    }

    public static DataBase cargarHashMapDesdeArchivo(String nombreArchivo) {
        HashMap<Persona, ArrayList<Bicicleta>> hashMap = new HashMap<>();
        DataBase dataBase = new DataBase(hashMap);
        try {
            File archivo = new File(nombreArchivo);
            if (!archivo.exists()) {
                archivo.createNewFile();
                return dataBase;
            }

            FileInputStream fis = new FileInputStream(archivo);
            ObjectInputStream ois = new ObjectInputStream(fis);

            hashMap = (HashMap<Persona, ArrayList<Bicicleta>>) ois.readObject();

            ois.close();
            fis.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return dataBase;
    }

    // Método para guardar un HashMap en un archivo de texto
    public static void guardarHashMapEnArchivo(String nombreArchivo, DataBase db) {
        try {
            FileOutputStream fos = new FileOutputStream(nombreArchivo);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(db.getDataBase());

            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
