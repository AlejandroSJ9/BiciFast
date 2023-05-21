package Controlador;

import Modelo.BicicletaModel;
import Modelo.PersonaModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DataBase {
    private HashMap<PersonaModel, ArrayList<BicicletaModel>> dataBase;

    //metodo constructor
    public DataBase() {
        this.dataBase = new HashMap<PersonaModel, ArrayList<BicicletaModel>>();
    }

    //ESte metodo agrega una persona y bicicleta a la base de datos que es un hashmap
    public void agregarPersonaBicicleta(PersonaModel p, BicicletaModel bicicletaModel){
        if(!this.dataBase.containsKey(p)){
            this.dataBase.put(p,new ArrayList<BicicletaModel>());
        }
        this.dataBase.get(p).add(bicicletaModel);
    }

    public void imprimirBicicletas(PersonaModel personaModelLOGIN){
        for(Map.Entry<PersonaModel,ArrayList<BicicletaModel>> entry : this.dataBase.entrySet()){
            PersonaModel personaModelDB = entry.getKey();
            if(personaModelLOGIN == personaModelDB){
                ArrayList<BicicletaModel> bicicletaModelArrayList = entry.getValue();
                int contador = 0;
                for(BicicletaModel b : bicicletaModelArrayList){
                    System.out.println(contador+1+ ". Marca: " + b.getMarca() + " | " + "ID : "+b.getUnique_id() + " | Color: "+ b.getColor() );
                    contador++;
                }
            }else{
                System.out.println("No hay bicicletas");
            }
        }
    }
    //Verifica si la persona existe y si existe se verifica si la bicicleta aparece en la lista de bicicletas de la base de datos
    public void eliminarBicicleta(PersonaModel p, BicicletaModel bicicletaModel){
        if(this.dataBase.containsKey(p)){
            ArrayList<BicicletaModel> listaBici = this.dataBase.get(p);
            if(listaBici.contains(bicicletaModel)){
                listaBici.remove(bicicletaModel);
            }else{
                System.out.println("Bicicleta no existe");
            }
        }
    }
    //funcion verifica si el propietario existe y verifica si la bicicleta que va a editar esta en la lista de sus bicicletas y guarda los nuevos datos
    public void actualizarBicicleta(PersonaModel propitario, BicicletaModel nueva, BicicletaModel antigua){
        if(this.dataBase.containsKey(propitario)){
            ArrayList<BicicletaModel> listaBicicletasAntigua = this.dataBase.get(propitario);
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

    public void actualizarPersona(PersonaModel propietarioAntiguo, PersonaModel propietarioNuevo){
        if(this.dataBase.containsKey(propietarioAntiguo)){
            propietarioAntiguo.setApellido(propietarioNuevo.getApellido());
            propietarioAntiguo.setNombre(propietarioNuevo.getNombre());
            propietarioAntiguo.setPhoneNumber(propietarioNuevo.getPhoneNumber());
            propietarioAntiguo.setId(propietarioNuevo.getId());
        }
    }
    // funcion que verifica si segun el nombre y la contraseña el usuario existe en la base de datos


    public BicicletaModel buscarBicicletaUsuario(PersonaModel personaModel, int posicion){
        ArrayList<BicicletaModel> bicicletaModels = this.dataBase.get(personaModel);
        if (bicicletaModels != null && posicion >= 0 && posicion < bicicletaModels.size()) {
            return bicicletaModels.get(posicion);
        } else {
            System.out.println("Índice fuera de rango o usuario no encontrado");
            return null;
        }
    }

    public HashMap<PersonaModel, ArrayList<BicicletaModel>> getDataBase() {
        return dataBase;
    }

    public void setDataBase(HashMap<PersonaModel, ArrayList<BicicletaModel>> dataBase) {
        this.dataBase = dataBase;
    }
}
