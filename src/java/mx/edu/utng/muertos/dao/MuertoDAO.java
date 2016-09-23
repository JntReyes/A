
package mx.edu.utng.muertos.dao;
import java.util.List;
import mx.edu.utng.muertos.model.Muerto;

/**
 *
 * @author Jeanette Berenice Reyes Rivera
 */
public interface MuertoDAO {
    void agregarMuerto(Muerto muerto);
    void borrarMuerto(int idMuerto);
    void cambiarMuerto(Muerto muerto);
    List<Muerto> desplegarMuertos();
    Muerto elegirMuerto(int idMuerto);

}
