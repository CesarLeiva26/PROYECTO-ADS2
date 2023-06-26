package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 

import beans.InformeDTO;
import dao.MySqlInformeDAO;
import service.InformeService;

/**
 * Servlet implementation class ServletInforme
 */
@WebServlet("/ServletInforme")
public class ServletInforme extends HttpServlet {
	InformeService i = new InformeService();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletInforme() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tipo = request.getParameter("tipo");
        if (tipo.equals("listar"))
            listar(request, response);
        else if (tipo.equals("registrar"))
            registrar(request, response);
	}


	private void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    InformeDTO obj = new InformeDTO(0, null, null, null, null, null, null, null, null);
	    String solicitante = request.getParameter("txt_solicitante");
	    String ubicacion = request.getParameter("txt_ubicacion");
	    String fecha = request.getParameter("txt_fecha");
	    String numero = request.getParameter("txt_numero");
	    String incidente = request.getParameter("txt_incidente");
	    String recomendacion = request.getParameter("txt_recomendacion");
	    obj.setCodigoSolicitante(Integer.parseInt(solicitante));
	    obj.setCodigoUbicacion(Integer.parseInt(ubicacion));
	    obj.setFechaSolicitud(fecha);
	    obj.setNumeroIncidente(numero);
	    obj.setCodigoIncidente(Integer.parseInt(incidente));
	    obj.setRecomendaciones(recomendacion);
	    int estado = i.registraInforme(obj);
	    if (estado != -1) {  
	        request.setAttribute("mensaje", "El informe se ha registrado correctamente.");
	        request.getRequestDispatcher("registrarInforme.jsp").forward(request, response);
	    } else {     
	        response.sendRedirect("error.html");
	    }
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<InformeDTO> info = new MySqlInformeDAO().listarInforme();
        request.setAttribute("informes", info);
        request.getRequestDispatcher("consultarIncidente.jsp").forward(request, response);
    }
}