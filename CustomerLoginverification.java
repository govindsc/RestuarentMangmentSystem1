/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author admin
 */
public class CustomerLoginverification extends HttpServlet {

  private     Connection con;
  private  PreparedStatement ps;
    
    public void init(){try{
                 con=Data.connect();
                String sql="SELECT * FROM users where email=? AND password=?";  
              ps=con.prepareStatement(sql);
    }catch(Exception e){
   e.printStackTrace(); }
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                PrintWriter out = response.getWriter();

        String email=request.getParameter("email");
        String password=request.getParameter("password");
        
 try{
                ps.setString(1, email);
                ps.setString(2, password);
                ResultSet rs=ps.executeQuery();
                boolean b=rs.next();
                if(b==true){
                    
                    //fetchind
                    HttpSession sesion=request.getSession();
                    //store data in session
                    sesion.setAttribute("user",email);
                     
                    String ch=request.getParameter("c1");
                    if(ch!=null){
                    // CREAT COOKIES OBJECTS
                      Cookie c1=new Cookie("id", email);
                      Cookie c2= new Cookie("pw",password);
                    c1.setMaxAge(60*60*24*7);                
                    c2.setMaxAge(60*60*24*7);

                      response.addCookie(c1);
                      response.addCookie(c2);
                    }
                  
                    
                  response.sendRedirect("buyerpage.jsp");
                }else{
                    response.sendRedirect("index.jsp");
                }
                con.close();
            }catch(Exception e ){
            e.printStackTrace();}
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
