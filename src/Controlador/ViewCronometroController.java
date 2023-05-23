package Controlador;

import Modelo.CronometroModel;
import Vista.ViewCronometro;

public class ViewCronometroController {

    private ViewCronometro viewCronometro;
    private CronometroModel cronometro=new CronometroModel();


    public void iniciarCronometro(){
        cronometro.iniciar();
    }

    public void pausarCronometro(){
        cronometro.pausar();
    }

    public void reanudarCronometro(){
        cronometro.reanudar();
    }

    public void finalizarCronometro(){
        cronometro.finalizar();
    }



}
