public class Bicicleta {
    private String marca;
    private int unique_id;
    private String color;
    private boolean robada;
    private Persona persona;


    public Bicicleta(String marca, int unique_id, String color, Persona persona, boolean robada) {
        this.marca = marca;
        this.unique_id = unique_id;
        this.color = color;
        this.persona = persona;
        this.robada = robada;
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

    public boolean isRobada() {
        return robada;
    }

    public void setRobada(boolean robada) {
        this.robada = robada;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }


}
