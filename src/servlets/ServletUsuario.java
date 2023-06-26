package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.UsuarioDTO;
import service.UsuarioService;

/**
 * Servlet implementation class ServletUsuario
 */
@WebServlet("/ServletUsuario")
public class ServletUsuario extends HttpServlet {
	UsuarioService u = new UsuarioService();
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ServletUsuario() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tipo = request.getParameter("tipo");
        if(tipo.equals("iniciarSesion"))
            iniciarSesion(request,response);
        else if (tipo.equals("cerrarSesion"))
        cerrarSesion(request,response);
    }

    private void cerrarSesion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        sesion.invalidate();
        request.setAttribute("msg", "Iniciar sesion");
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    private void iniciarSesion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String login = request.getParameter("txtusuario");
        String password = request.getParameter("txtcontra");
        System.out.println("Login: "+login);
        System.out.println("Clave: "+password);
        UsuarioDTO obj = u.loginusuario(login, password);
        if (obj != null) {
            if (obj.getContraseña().equals(password)) {
                HttpSession sesion = request.getSession();
                sesion.setAttribute("datos", obj);
                request.getRequestDispatcher("menuPrincipal.jsp").forward(request, response);
            }
            else {
                request.setAttribute("msg", "Usuario Incorrecto");
                request.getRequestDispatcher("login.jsp").forward(request, response);

            }
        }
        else {
            request.setAttribute("msg", "Contraseña Incorrecta");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

}