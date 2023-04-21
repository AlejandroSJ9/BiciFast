import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DataBase {
    private HashMap<Persona, ArrayList<Bicicleta>> dataBase;

    //metodo constructor
    public DataBase() {
        this.dataBase = new HashMap<Persona, ArrayList<Bicicleta>>();
    }

    //ESte metodo agrega una persona y bicicleta a la base de datos que es un hashmap
    public void agregarBicicletaEnPersona(Persona p, Bicicleta bicicleta){
        if(!this.dataBase.containsKey(p)){
            this.dataBase.put(p,new ArrayList<Bicicleta>());
        }
        this.dataBase.get(p).add(bicicleta);
    }
    //Funcion que imprime el hash map completo
    public void imprimirHashMap(){
        for(Map.Entry<Persona,ArrayList<Bicicleta>> entry : this.dataBase.entrySet()){
            Persona persona = entry.getKey();
            ArrayList<Bicicleta> bicicletas = entry.getValue();
            System.out.println("- " + persona.getNombre()+" " + persona.getApellido() + " " + persona.getPhoneNumber()) ;
            for(Bicicleta b : bicicletas){
                System.out.println("\t* " + b.getMarca() + " - " + b.getUnique_id() + " ");
            }
        }
    }
    public void imprimirBicicletas(Persona personaLOGIN){
        for(Map.Entry<Persona,ArrayList<Bicicleta>> entry : this.dataBase.entrySet()){
            Persona personaDB = entry.getKey();
            if(personaLOGIN == personaDB){
                ArrayList<Bicicleta> bicicletaArrayList = entry.getValue();
                int contador = 0;
                for(Bicicleta b : bicicletaArrayList){
                    System.out.println(contador+1+ ". " + b.getMarca() + " | " + b.getUnique_id() + " | "+ b.getColor() );
                    contador++;
                }
            }else{
                System.out.println("No hay bicicletas");
            }
        }
    }
    //Verifica si la persona existe y si existe se verifica si la bicicleta aparece en la lista de bicicletas de la base de datos
    public void eliminarBicicleta(Persona p, Bicicleta bicicleta){
        if(this.dataBase.containsKey(p)){
            ArrayList<Bicicleta> listaBici = this.dataBase.get(p);
            if(listaBici.contains(bicicleta)){
                listaBici.remove(bicicleta);
            }else{
                System.out.println("Bicicleta no existe");
            }
        }
    }
    //funcion verifica si el propietario existe y verifica si la bicicleta que va a editar esta en la lista de sus bicicletas y guarda los nuevos datos
    public void actualizarBicicleta(Persona propitario, Bicicleta nueva, Bicicleta antigua){
        if(this.dataBase.containsKey(propitario)){
            ArrayList<Bicicleta> listaBicicletasAntigua = this.dataBase.get(propitario);
            if(listaBicicletasAntigua.contains(antigua)){
                antigua.setColor(nueva.getColor());
                antigua.setMarca(nueva.getMarca());
                antigua.setRobada(nueva.isRobada());
                antigua.setUnique_id(nueva.getUnique_id());

            }else{
                System.out.println("Bicicleta no existe");
            }
        }
    }

    public void actualizarPersona(Persona propietarioAntiguo, Persona propietarioNuevo){
        if(this.dataBase.containsKey(propietarioAntiguo)){
            propietarioAntiguo.setApellido(propietarioNuevo.getApellido());
            propietarioAntiguo.setNombre(propietarioNuevo.getNombre());
            propietarioAntiguo.setPhoneNumber(propietarioNuevo.getPhoneNumber());
            propietarioAntiguo.setId(propietarioNuevo.getId());
        }
    }
    // funcion que verifica si segun el nombre y la contraseña el usuario existe en la base de datos
    public Persona validarLogIn(String user, String password){
        for(Map.Entry<Persona,ArrayList<Bicicleta>> entry: this.dataBase.entrySet()){
            Persona persona = entry.getKey();
            if(persona.getNombre().equals(user) && persona.getPass().equals(password)){
                return persona;
            }
        }
        return null;
    }

    public Bicicleta buscarBicicletaUsuario(Persona persona, int posicion){
        ArrayList<Bicicleta> bicicletas = this.dataBase.get(persona);
        if (bicicletas != null && posicion >= 0 && posicion < bicicletas.size()) {
            return bicicletas.get(posicion);
        } else {
            System.out.println("Índice fuera de rango o usuario no encontrado");
            return null;
        }
    }


}
