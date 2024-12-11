package set;

import java.util.List;

public class Permisos {
    private List<String> botones;
    private List<String> restricciones;

    // Getters y Setters
    public List<String> getBotones() {
        return botones;
    }

    public void setBotones(List<String> botones) {
        this.botones = botones;
    }

    public List<String> getRestricciones() {
        return restricciones;
    }

    public void setRestricciones(List<String> restricciones) {
        this.restricciones = restricciones;
    }

    @Override
    public String toString() {
        return "Permisos{" +
               "botones=" + botones +
               ", restricciones=" + restricciones +
               '}';
    }
}