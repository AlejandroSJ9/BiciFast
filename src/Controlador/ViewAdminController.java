package Controlador;

import Vista.ViewMenuAdministrador;

public class ViewAdminController {

    private ViewMenuAdministrador menuAdministrador ;

    public void iniciarVista(){
        menuAdministrador = new ViewMenuAdministrador(this);
        menuAdministrador.showView();
    }
}
