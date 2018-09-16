package controlador;

public class Cuenta {

    private String noCuenta;
    private String nombreTitular;
    private Fecha fechaCreacion;
    private double monto;
    private double ultimoRetiro;
    private double ultimaConsignacion;

    public Cuenta() {
        
    }

    public Cuenta(String noCuenta, String nombreTitular, Fecha fechaCreacion, double monto, double ultimoRetiro, double ultimaConsignacion) {
        this.noCuenta = noCuenta;
        this.nombreTitular = nombreTitular;
        this.fechaCreacion = fechaCreacion;
        this.monto = monto;
        this.ultimoRetiro = ultimoRetiro;
        this.ultimaConsignacion = ultimaConsignacion;
    }

    public String getNoCuenta() {
        return noCuenta;
    }

    public void setNoCuenta(String noCuenta) {
        this.noCuenta = noCuenta;
    }

    public String getNombreTitular() {
        return nombreTitular;
    }

    public void setNombreTitular(String nombreTitular) {
        this.nombreTitular = nombreTitular;
    }

    public Fecha getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Fecha fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public double getUltimoRetiro() {
        return ultimoRetiro;
    }

    public void setUltimoRetiro(double ultimoRetiro) {
        this.ultimoRetiro = ultimoRetiro;
    }

    public double getUltimaConsignacion() {
        return ultimaConsignacion;
    }

    public void setUltimaConsignacion(double ultimaConsignacion) {
        this.ultimaConsignacion = ultimaConsignacion;
    }
    
    

    @Override
    public String toString() {
        return "Cuenta{" + "noCuenta=" + noCuenta + ", nombreTitular=" + nombreTitular + ", fechaCreacion=" + fechaCreacion + ", monto=" + monto + ", ultimoRetiro=" + ultimoRetiro + ", ultimaConsignacion=" + ultimaConsignacion + '}';
    }
    
}
