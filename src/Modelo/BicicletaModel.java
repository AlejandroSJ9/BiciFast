package Modelo;

public class BicicletaModel {
    private String marca;
    private int unique_id;
    private String color;
    private PersonaModel persona;
    private boolean robada;


    public BicicletaModel(String marca, int unique_id, String color, PersonaModel persona, boolean robada) {
        this.marca = marca;
        this.unique_id = unique_id;
        this.color = color;
        this.persona = persona;
        this.robada = robada;
    }
    public BicicletaModel(){

    }

    @Override
    public String toString() {
        // Convertir los atributos a una cadena en el formato "marca|unique_id|color|persona|robada"
        return marca + "|" + unique_id + "|" + color + "|" + persona.toString() + "|" + robada;
    }

    // Método estático para crear un objeto Bicicleta a partir de una cadena en el formato "marca|unique_id|color|persona|robada"
    public static BicicletaModel fromString(String bicicletaString) {
        String[] partes = bicicletaString.split("\\|"); // Separar los atributos por el delimitador

        // Obtener los atributos de la cadena
        String marca = partes[0];
        int unique_id = Integer.parseInt(partes[1]);
        String color = partes[2];
        PersonaModel persona = PersonaModel.fromString(partes[3]);
        boolean robada = Boolean.parseBoolean(partes[4]);

        // Crear un nuevo objeto Bicicleta con los atributos obtenidos
        return new BicicletaModel(marca, unique_id, color, persona, robada);
    }
    
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getUnique_id() {
        return unique_id;
    }

    public void setUnique_id(int unique_id) {
        this.unique_id = unique_id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public PersonaModel getPersona() {
        return persona;
    }

    public void setPersona(PersonaModel persona) {
        this.persona = persona;
    }

    public boolean isRobada() {
        return robada;
    }

    public void setRobada(boolean robada) {
        this.robada = robada;
    }
}
