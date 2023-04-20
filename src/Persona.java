public class Persona {
    private String nombre;
    private String apellido;
    private int id;
    private String phoneNumber;

    private String pass;


    public Persona(String nombre, String apellido, int id, String phoneNumber,String  pass) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.pass = pass;
    }
    public Persona(){

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
