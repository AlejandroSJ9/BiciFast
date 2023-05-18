package Modelo;

import org.apache.commons.math4.legacy.analysis.UnivariateFunction;
import org.apache.commons.math4.legacy.analysis.integration.SimpsonIntegrator;

public class IntegralModel {

        public double calcularAhorro(RutasModel ruta) {
            double emisionesBicicletas = 0.005;
            double emisionesAutomovil = 0.186;

            UnivariateFunction funcionDiferenciaEmisiones = new UnivariateFunction() {
                @Override
                public double value(double x) {
                    return emisionesAutomovil - emisionesBicicletas;
                }
            };

            SimpsonIntegrator integrador = new SimpsonIntegrator();
            double distancia = (double) ruta.getDistanciaEnKM();
            double ahorroEmisiones = integrador.integrate(1000, funcionDiferenciaEmisiones, 0, distancia);

            return ahorroEmisiones;
        }
    }
