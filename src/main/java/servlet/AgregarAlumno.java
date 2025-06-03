/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import dao.MedicoJpaController;
import dto.Medico;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.PasswordUtil;

/**
 *
 * @author Lenovo
 */
@WebServlet(name = "AgregarAlumno", urlPatterns = {"/agregaralumno"})
public class AgregarAlumno extends HttpServlet {

            private MedicoJpaController dao = new MedicoJpaController();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AgregarAlumno</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AgregarAlumno at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    try {
        String ndniMedi = request.getParameter("ndni");
        String appaMedi = request.getParameter("appa");
        String apmaMedi = request.getParameter("apma");
        String nombMedi = request.getParameter("nomb");
        String fechaStr = request.getParameter("fecha");
        String logiMedi = request.getParameter("login");
        String clave = request.getParameter("clave");
        String codigo2FA = request.getParameter("codigo2FA"); // Si lo vas a recibir aquí

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fechaNacimiento = LocalDate.parse(fechaStr, formatter);

        String hashedClave = PasswordUtil.hashPassword(clave);

        Medico nuevo = new Medico();
        nuevo.setNdniMedi(ndniMedi);
        nuevo.setAppaMedi(appaMedi);
        nuevo.setApmaMedi(apmaMedi);
        nuevo.setNombMedi(nombMedi);
        nuevo.setFechNaciMedi(Date.valueOf(fechaNacimiento));
        nuevo.setLogiMedi(logiMedi);

        // Para el código 2FA, si no lo tienes aún, puedes generar uno o dejar vacío por ahora
        if (codigo2FA != null && !codigo2FA.isEmpty()) {
            nuevo.setCodigo2FA(codigo2FA);
        } else {
            nuevo.setCodigo2FA("");  // O generar uno dinámicamente si usas 2FA
        }

        dao.create(nuevo);  // Cambia por tu DAO para Medico

        response.sendRedirect("principal.html");

    } catch (Exception e) {
        e.printStackTrace();
        response.getWriter().println("Error al agregar médico: " + e.getMessage());
    }
}

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
