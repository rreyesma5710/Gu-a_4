package controlador;

public class Fecha {
    
    private int d, m, a;
    
    public Fecha() {
        this.d = 0;
        this.m = 0;
        this.a = 0;
    }

    public Fecha(int d, int m, int a) {
        this.d = d;
        this.m = m;
        this.a = a;
    }

    public int getDia() {
        return d;
    }

    public void setDia(int d) {
        this.d = d;
    }

    public int getMes() {
        return m;
    }

    public void setMes(int m) {
        this.m = m;
    }

    public int getAño() {
        return a;
    }

    public void setAño(int a) {
        this.a = a;
    }
    
    public void calcularEdad() {
    
    }

    @Override
    public String toString() {
        return d + "/" + m + "/" + a;
    }

    
}
