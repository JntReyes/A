
package mx.edu.utng.muertos.controller;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.edu.utng.muertos.dao.MuertoDAO;
import mx.edu.utng.muertos.dao.MuertoDAOImp;
import mx.edu.utng.muertos.model.Muerto;
public class MuertoController extends HttpServlet {
   private static final String
           LISTA_MUERTOS = "/lista_muertos.jsp";
   private static final String 
           AGREGAR_O_CAMBIAR = "muerto.jsp";
   private MuertoDAO dao;
   
   public MuertoController(){
       dao = new MuertoDAOImp();
   }
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");
        if(action.equalsIgnoreCase("borrar")){
            forward = LISTA_MUERTOS;
            int idMuerto = Integer.parseInt(
                request.getParameter("idMuerto"));
            dao.borrarMuerto(idMuerto);
            request.setAttribute("muertos",
                    dao.desplegarMuertos());
         }else if(action.equalsIgnoreCase("cambiar")){
             forward = AGREGAR_O_CAMBIAR;
             int idMuerto = Integer.parseInt(
                request.getParameter("idMuerto"));
             Muerto muerto = 
                     dao.elegirMuerto(idMuerto);
             request.setAttribute("muerto", muerto);
         } else if(action.equalsIgnoreCase("agregar")){
             forward = AGREGAR_O_CAMBIAR;
         } else{
             forward = LISTA_MUERTOS;
             request.setAttribute("muertos", 
                     dao.desplegarMuertos());
         }
        
        RequestDispatcher view = 
                request.getRequestDispatcher(forward);
        view.forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Muerto muerto = new Muerto();
        muerto.setEdad(request.getParameter("edad"));
        muerto.setServicio(request.getParameter("servicio"));
        muerto.setFechaIngreso(request.getParameter("fechaIngreso"));
        muerto.setFechaFallecido(request.getParameter("fechaFallecido"));
        muerto.setResultado(request.getParameter("resultado"));

        String idMuerto = request.getParameter("idMuerto");
        
        if(idMuerto==null|| idMuerto.isEmpty()||idMuerto.trim().equals("")){
            dao.agregarMuerto(muerto);
        }else{
            muerto.setIdMuerto(
                    Integer.parseInt(idMuerto));
            dao.cambiarMuerto(muerto);
        }
        RequestDispatcher view = 
                request.getRequestDispatcher(LISTA_MUERTOS);
        request.setAttribute("muertos", 
                dao.desplegarMuertos());
        view.forward(request, response);
    }
}
