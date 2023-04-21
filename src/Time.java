
import java.util.TimerTask;
import java.util.ArrayList;
import java.util.Timer;

//Verificar que no se sobreescriba los datos en las mismas rutas.

public class Time {
    private long tiempoTranscurrido=0;
    private Timer time;
    private TimerTask tarea;

    private boolean pausado;
    private long getTiempoTranscurrido;
    private ArrayList<Long> tiemposGuardados;

    public void Cronometro(){
        time =new Timer();
        pausado=true;
        tiemposGuardados= new ArrayList<>();
    }

    public void iniciar(){
        if(pausado){
            tarea= new TimerTask() {
                @Override
                public void run() {
                    tiempoTranscurrido+=1;
                    System.out.println(formatoTiempo(tiempoTranscurrido));
                }
            };
            time.schedule(tarea,0,1);
            pausado=false;
        }
    }

    public void pausar(){
        if(!pausado){
            tarea.cancel();
            tiemposGuardados.add(tiempoTranscurrido);
            pausado=true;
        }
    }

    public ArrayList<Long> getTiemposGuardados() {
        return tiemposGuardados;
    }

    private static String formatoTiempo(long tiempo){
        long milisegundos = tiempo%1000;
        long segundos = (tiempo/1000) %60;
        long minutos = (tiempo/1000)/ 60;

        return String.format("%02d:%02d.%03d", minutos, segundos, milisegundos);
    }

    public void imprimir(){
        System.out.println("\r" + formatoTiempo(tiempoTranscurrido));
    }


}
