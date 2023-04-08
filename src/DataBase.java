import java.util.ArrayList;
import java.util.HashMap;

public class DataBase {
    private HashMap<Persona, ArrayList<Bicicleta>> dataBase;

    //ESte metodo agrega una persona y bicicleta a la base de datos que es un hashmap
    public void agregarBicicletaPersona(Persona p, Bicicleta bicicleta){
        if(!this.dataBase.containsKey(p)){
            this.dataBase.put(p,new ArrayList<Bicicleta>());
        }
        this.dataBase.get(p).add(bicicleta);
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
}
