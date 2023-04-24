import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.ArrayList;

// Verificar que no se sobreescriba los datos en las mismas rutas.
public class Cronometro {
    private long tiempoTranscurrido = 0;
    private Timer timer;
    private TimerTask tarea;
    private boolean enEjecucion;
    private ArrayList<Long> tiemposGuardados;

    public Cronometro() {
        timer = new Timer();
        enEjecucion = false;
        tiemposGuardados = new ArrayList<Long>();
    }

    public void iniciar() {
        if (!enEjecucion) {
            tarea = new TimerTask() {
                @Override
                public void run() {
                    tiempoTranscurrido += 1;
                    System.out.println("\r" + formatoTiempo(tiempoTranscurrido));
                }
            };
            timer.schedule(tarea, 0, 1);
            enEjecucion = true;
        }
    }

    public void pausar() {
        String rpt;
        Scanner cin = new Scanner(System.in);

        if (enEjecucion) {
            tarea.cancel();
            enEjecucion = false;
        }
        long tiempoAnterior= tiempoTranscurrido;

        System.out.println("Desea continuar? si/no");
        rpt= cin.next();
        if(rpt.equalsIgnoreCase("si")){
            tiempoTranscurrido= tiempoAnterior;
            iniciar();
        }
        else{
            tiemposGuardados.add(tiempoTranscurrido);
        }
    }


    public ArrayList<Long> getTiemposGuardados() {
        return tiemposGuardados;
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
