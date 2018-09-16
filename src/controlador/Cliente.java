package controlador;

public class Cliente {
    
    private String nombre;
    private String cc;
    private Fecha fechaNac;
    private int noCuentas;

    public Cliente() {
    }

    public Cliente(String nombre, String cc, Fecha fechaNac, int noCuentas) {
        this.nombre = nombre;
        this.cc = cc;
        this.fechaNac = fechaNac;
        this.noCuentas = noCuentas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public Fecha getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Fecha fechaNac) {
        this.fechaNac = fechaNac;
    }

    public int getNoCuentas() {
        return noCuentas;
    }

    public void setNoCuentas(int noCuentas) {
        this.noCuentas = noCuentas;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nombre=" + nombre + ", cc=" + cc + ", fechaNac=" + fechaNac + ", noCuentas=" + noCuentas + '}';
    }
    
}
