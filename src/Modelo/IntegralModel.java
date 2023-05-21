package Modelo;

public abstract class IntegralModel {
    public  double integral(double a, double b, int n) {
        if(n%2==1) n++;
        double h = (b-a)/n;
        double suma= f(a)+f(b);
        for(int i=1; i<n; i+=2){
            suma +=4*f(a+i*h);
        }
        for(int i=2; i<n; i+=2){
            suma+=2*f(a+i*h);
        }
        return (suma*h/3);
        }
        abstract public double f(double x);
    }
