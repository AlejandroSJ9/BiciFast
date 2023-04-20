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

    @Override
    public String toString() {
        // Convertir los atributos a una cadena en el formato "nombre|apellido|id|phoneNumber|pass"
        return nombre + "|" + apellido + "|" + id + "|" + phoneNumber + "|" + pass;
    }

    // Método estático para crear un objeto Persona a partir de una cadena en el formato "nombre|apellido|id|phoneNumber|pass"
    public static Persona fromString(String personaString) {
        String[] partes = personaString.split("\\|"); // Separar los atributos por el delimitador

        // Obtener los atributos de la cadena
        String nombre = partes[0];
        String apellido = partes[1];
        int id = Integer.parseInt(partes[2]);
        String phoneNumber = partes[3];
        String pass = partes[4];

        // Crear un nuevo objeto Persona con los atributos obtenidos
        return new Persona(nombre, apellido, id, phoneNumber, pass);
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

