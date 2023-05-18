package Modelo;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.ArrayList;
// Verificar que no se sobreescriba los datos en las mismas rutas.
public class CronometroModel {
    private long tiempoTranscurrido = 0;
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
            Scanner cin =new Scanner(System.in);
            while (enEjecucion){
                System.out.println(" ");
                System.out.println("\nDesea pausar el cronometro? si/no");
                System.out.println(">");
                String respuesta = cin.nextLine();
                if(respuesta.equalsIgnoreCase("si")){
                    pausar();
                }
            }
        }
    }

    public long pausar() {
        String rpt;
        Scanner cin = new Scanner(System.in);

        if (enEjecucion) {
            tarea.cancel();
            enEjecucion = false;
        }
        long tiempoAnterior = tiempoTranscurrido;

        System.out.println("Desea continuar? si/no");
        rpt = cin.next();
        if (rpt.equalsIgnoreCase("si")) {
            tiempoTranscurrido = tiempoAnterior;
            iniciar();
        } else if (rpt.equalsIgnoreCase("no")) {
            return tiempoTranscurrido;
        }
        long tiempoFinal= tiempoTranscurrido;
        return tiempoFinal;
    }




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

