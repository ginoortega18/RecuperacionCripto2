/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import dao.MedicoJpaController;
import dto.Medico;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Lenovo
 */
@WebServlet(name = "ListarAlumno", urlPatterns = {"/listaralumno"})
public class ListarAlumno extends HttpServlet {

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
            out.println("<title>Servlet ListarAlumno</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ListarAlumno at " + request.getContextPath() + "</h1>");
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
    List<Medico> lista = dao.findMedicoEntities(); // Tu DAO de médico

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    for (Medico m : lista) {

        String fechaFormateada = "";
        if (m.getFechNaciMedi() != null) {
            fechaFormateada = sdf.format(m.getFechNaciMedi());
        }

        out.println("<tr>");
        out.println("<td>" + m.getCodiMedi() + "</td>");
        out.println("<td>" + m.getNdniMedi() + "</td>");
        out.println("<td>" + m.getAppaMedi() + "</td>");
        out.println("<td>" + m.getApmaMedi() + "</td>");
        out.println("<td>" + m.getNombMedi() + "</td>");
        out.println("<td>" + fechaFormateada + "</td>");
        out.println("<td>" + m.getLogiMedi() + "</td>");

        out.println("<td>"
                + "<button class='btn btn-warning m-2' onclick='abrirModalEditar(\""
                + m.getCodiMedi() + "\", \""
                + m.getNdniMedi() + "\", \""
                + m.getAppaMedi() + "\", \""
                + m.getApmaMedi() + "\", \""
                + m.getNombMedi() + "\", \""
                + fechaFormateada + "\", \""
                + m.getLogiMedi() + "\")'>"
                + "<i class='fas fa-pencil-alt'></i></button>"

                + "<button class='btn btn-danger' onclick='confirmarEliminar(\""
                + m.getCodiMedi() + "\")'>"
                + "<i class='fas fa-trash'></i></button>"

                + "</td>");
        out.println("</tr>");
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
