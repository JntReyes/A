
package mx.edu.utng.muertos.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mx.edu.utng.muertos.model.Muerto;
import mx.edu.utng.muertos.util.UtilDB;

/**
 *
 * @author Jeanette Berenice Reyes Rivera
 */
public class MuertoDAOImp implements MuertoDAO{

    private Connection connection;
    
    public MuertoDAOImp(){
        connection = UtilDB.getConnection();
    }
    
    @Override
    public void agregarMuerto(Muerto muerto) {
        try {
          String query = "INSERT INTO muertos (edad, servicio, "
                  + " fecha_ingreso, fecha_fallecido, resultado) VALUES (?,?,?,?,?)";
            PreparedStatement ps = connection.prepareCall(query);
            ps.setString(1, muerto.getEdad());
            ps.setString(2, muerto.getServicio());
            ps.setString(3, muerto.getFechaIngreso());
            ps.setString(4, muerto.getFechaFallecido());
            ps.setString(5, muerto.getResultado());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void borrarMuerto(int idMuerto) {
        try {
             String query = "DELETE FROM muertos WHERE id_muerto = ?";
             PreparedStatement ps = connection.prepareCall(query);
             ps.setInt(1, idMuerto);
             ps.executeUpdate();
             ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void cambiarMuerto(Muerto muerto) {
    try {
          String query = "UPDATE muertos SET edad = ?, "
                  + " servicio= ?, fecha_ingreso=?, fecha_fallecido=?, resultado=? WHERE "
                  + " id_muerto = ?";
            PreparedStatement ps = connection.prepareCall(query);
            ps.setString(1, muerto.getEdad());
            ps.setString(2, muerto.getServicio());
            ps.setString(3, muerto.getFechaIngreso());
            ps.setString(4, muerto.getFechaFallecido());
            ps.setString(5, muerto.getResultado());
            ps.setInt(6, muerto.getIdMuerto());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
   public List<Muerto> desplegarMuertos() {
        List<Muerto> muertos = new ArrayList<Muerto>();
        try{
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(
                "SELECT * FROM muertos");
            while (resultSet.next()) {
              Muerto muerto = new Muerto(
              resultSet.getInt("id_muerto"),
              resultSet.getString("edad"),
              resultSet.getString("servicio"),
              resultSet.getString("fecha_ingreso"),
              resultSet.getString("fecha_fallecido"),
              resultSet.getString("resultado"));
              muertos.add(muerto);
            }
            resultSet.close();
            statement.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return muertos;
    }

    @Override
    public Muerto elegirMuerto(int idMuerto) {
       Muerto muerto = new Muerto();
        try{
        PreparedStatement statement = 
                connection.prepareStatement(
                        "SELECT * FROM muertos WHERE "
                                + " id_muerto = ?");
        statement.setInt(1, idMuerto);
        ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
              muerto.setIdMuerto(
                      resultSet.getInt("id_muerto"));
              muerto.setEdad(
                      resultSet.getString("edad"));
              muerto.setServicio(
                      resultSet.getString("servicio"));
              muerto.setFechaIngreso(
                      resultSet.getString("fecha_ingreso"));
              muerto.setFechaFallecido(
                      resultSet.getString("fecha_fallecido"));
              muerto.setResultado(
                      resultSet.getString("resultado"));
             
            }
            resultSet.close();
            statement.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return muerto;
    }

    
    
}

