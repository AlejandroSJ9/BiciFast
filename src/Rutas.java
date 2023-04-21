import java.util.HashMap;

public class Rutas {
    //persona y el tiempo que le tomo hacer esa ruta
    private HashMap<Persona,Integer> competidores;
    private String nombreRuta;
    private int distanciaEnKM;

    public Rutas(String nombreRuta, int distanciaEnKM){
        this.nombreRuta = nombreRuta;
        this.distanciaEnKM = distanciaEnKM;
        competidores = new HashMap<>();
    }

    public Rutas(){

    }

    public void agregarCompetidores(Persona p, int tiempo){
        this.competidores.put(p,tiempo);
    }

    public int obtenerTiempoCompetidor(Persona persona){
        return this.competidores.get(persona);
    }

    public HashMap<Persona, Integer> getCompetidores() {
        return competidores;
    }

    public void setCompetidores(HashMap<Persona, Integer> competidores) {
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
