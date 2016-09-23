
package mx.edu.utng.muertos.model;

/**
 *
 * @author Jeanette Berenice Reyes Rivera
 */
public class Muerto {
   private int idMuerto;
   private String edad;
   private String servicio;
   private String fechaIngreso;
   private String fechaFallecido;
   private String resultado;

   public Muerto() {
        this(0,"","","","","");
    }
    
    public Muerto(int idMuerto, String edad, String servicio, String fechaIngreso, String fechaFallecido, String resultado) {
        this.idMuerto = idMuerto;
        this.edad = edad;
        this.servicio = servicio;
        this.fechaIngreso = fechaIngreso;
        this.fechaFallecido = fechaFallecido;
        this.resultado = resultado;
    }

    public int getIdMuerto() {
        return idMuerto;
    }

    public void setIdMuerto(int idMuerto) {
        this.idMuerto = idMuerto;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getFechaFallecido() {
        return fechaFallecido;
    }

    public void setFechaFallecido(String fechaFallecido) {
        this.fechaFallecido = fechaFallecido;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    @Override
    public String toString() {
        return "Muerto{" + "idMuerto=" + idMuerto + ", edad=" + edad + ", servicio=" + servicio + ", fechaIngreso=" + fechaIngreso + ", fechaFallecido=" + fechaFallecido + ", resultado=" + resultado + '}';
    }

}