import java.util.HashMap;
import java.util.Map;

public class Rutas {
    //persona y el tiempo que le tomo hacer esa ruta
    private HashMap<Persona,Long> competidores;
    private String nombreRuta;
    private int distanciaEnKM;

    public Rutas(String nombreRuta, int distanciaEnKM){
        this.nombreRuta = nombreRuta;
        this.distanciaEnKM = distanciaEnKM;
        competidores = new HashMap<>();
    }

    public Rutas(){

    }
    public void imprimirPorCondicionPersona(Persona personaFiltro){
        int contador = 1;
        for(Map.Entry<Persona,Long> entry : competidores.entrySet()){
            Persona personaDB = entry.getKey();
            Long tiempoDB = entry.getValue();
            if(personaFiltro.equals(personaDB)){
                System.out.println(this.nombreRuta + " : \n" + contador + ". " + tiempoDB);
            }
        }
    }
    public void agregarCompetidores(Persona p, Long tiempo){
        this.competidores.put(p,tiempo);
    }

    public Long obtenerTiempoCompetidor(Persona persona){
        return this.competidores.get(persona);
    }

    public HashMap<Persona, Long> getCompetidores() {
        return competidores;
    }

    public void setCompetidores(HashMap<Persona, Long> competidores) {
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
