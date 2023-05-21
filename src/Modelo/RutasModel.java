package Modelo;

import Modelo.PersonaModel;

import java.util.HashMap;
import java.util.Map;

public class RutasModel {
    //persona y el tiempo que le tomo hacer esa ruta
    private HashMap<PersonaModel,Long> competidores;
    private String nombreRuta;
    private int distanciaEnKM;

    public RutasModel(String nombreRuta, int distanciaEnKM){
        this.nombreRuta = nombreRuta;
        this.distanciaEnKM = distanciaEnKM;
        competidores = new HashMap<>();
    }

    public RutasModel(){

    }
    public void imprimirPorCondicionPersona(PersonaModel personaModelFiltro){
        int contador = 1;
        for(Map.Entry<PersonaModel,Long> entry : competidores.entrySet()){
            PersonaModel personaModelDB = entry.getKey();
            Long tiempoDB = entry.getValue();
            if(personaModelFiltro.equals(personaModelDB)){
                System.out.println(this.nombreRuta + " : \n" + contador + ". " + tiempoDB);
            }
        }
    }
    public void agregarCompetidores(PersonaModel p, Long tiempo){
        this.competidores.put(p,tiempo);
    }

    public Long obtenerTiempoCompetidor(PersonaModel personaModel){
        return this.competidores.get(personaModel);
    }

    public HashMap<PersonaModel, Long> getCompetidores() {
        return competidores;
    }

    public void setCompetidores(HashMap<PersonaModel, Long> competidores) {
        this.competidores = competidores;
    }

    public String getNombreRuta() {
        return nombreRuta;
    }

    public void setNombreRuta(String nombreRuta) {
        this.nombreRuta = nombreRuta;
    }

    public int getDistanciaEnKM() {
        return distanciaEnKM;
    }

    public void setDistanciaEnKM(int distanciaEnKM) {
        this.distanciaEnKM = distanciaEnKM;
    }
}
