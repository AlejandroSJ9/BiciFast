package Modelo;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.ArrayList;
// Verificar que no se sobreescriba los datos en las mismas rutas.
public class CronometroModel {
    private long tiempoTranscurrido = 0;
    private long tiempoAnterior=0;
    private Timer timer;
    private TimerTask tarea;
    private boolean enEjecucion;


    public CronometroModel() {
        timer = new Timer();
        enEjecucion = false;
    }

    public void iniciar() {
        if (!enEjecucion) {
            tarea = new TimerTask() {
                @Override
                public void run() {
                    tiempoTranscurrido += 1;
                    System.out.print("\r" + formatoTiempo(tiempoTranscurrido));
                }
            };
            timer.schedule(tarea, 0, 1000);
            enEjecucion = true;
        }
    }

    public void pausar() {
        if (enEjecucion) {
            tarea.cancel();
            enEjecucion = false;
            tiempoAnterior= tiempoTranscurrido;
        }
    }

    public void reanudar(){
        if(!enEjecucion){
            tiempoTranscurrido= tiempoAnterior;
            iniciar();
        }
    }

    public long finalizar(){
        pausar();
        return tiempoTranscurrido;
    }

    /*public long getTiempoTomado(){
        return tiempoTranscurrido;
    }
    */



    private static String formatoTiempo(long tiempo) {
        long milisegundos = tiempo % 1000;
        long segundos = (tiempo / 1000) % 60;
        long minutos = (tiempo / 1000) / 60;

        return String.format("%02d:%02d.%03d", minutos, segundos, milisegundos);
    }

    public void imprimir() {
        System.out.println(formatoTiempo(tiempoTranscurrido));
    }
}

