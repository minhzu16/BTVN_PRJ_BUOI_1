/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author LEGION 5 PRO
 */
@WebServlet(urlPatterns = {"/Registercontroller"})
public class Registercontroller extends HttpServlet {

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
            out.println("<title>Servlet Registercontroller</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Registercontroller at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
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
    PrintWriter pw = response.getWriter();
    response.setContentType("text/html;charset=UTF-8");

    String Uname = request.getParameter("Username");
    String email = request.getParameter("Email");
    String pass = request.getParameter("Password");
    String cfpass = request.getParameter("CfPassword");

    // Kiểm tra dữ liệu đầu vào
    if (!validateInput(Uname) || !validateInput(email) || !validateInput(pass) || !validateInput(cfpass)) {
        pw.println("Không được để trống ô nhập!");
        return;
    }

    // Kiểm tra mật khẩu xác nhận
    if (!pass.equals(cfpass)) {
        pw.println("Mật khẩu xác nhận không khớp!");
        return;
    }

    // Hiển thị thông tin nhập hợp lệ
    pw.println("Đăng ký thành công");
    pw.println("Username: " + Uname );
    pw.println("Email: " + email);
    }
    
    public static boolean validateInput(String input) {
    return input != null && !input.trim().isEmpty();
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
