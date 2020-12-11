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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author admin
 */
public class Products extends HttpServlet {

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
       
    PrintWriter out =response.getWriter();
   try{
       Connection con=Data.connect();
       String sql="SELECT pcode, pname ,pdesc,price FROM PRODUCTS";
       PreparedStatement ps=con.prepareStatement(sql);
       ResultSet rs=   ps.executeQuery();
           out.println("<html>");
           out.println("<head>");          

               out.println("        <link rel="+""+"stylesheet"+""+" href="+""+"productlist.css"+""+">\n" );

           out.println("<head>");

           out.println("<body>");
            out.println("<h2>Select Desired Product</h2>");
            out.println("<hr>");
            while(rs.next()){
                
                String s1=rs.getString(1);
                String s2=rs.getString(2);
                String s3=rs.getString(3);
                                String s4=rs.getString(4);

                out.println("<img src=Imageloader?pcode="+s1+" "+"hiegth="+100+" "+"width="+150+" />");
                out.println("<a href=ProductDetails?code="+s1+">");
                out.println("<h3 class="+"li"+">"+s2+"</h3>");


                out.println("</a>");
                
                out.println("<br>");
                out.println("<h3>Product description:"+s3+"</h3>");
                                out.println("<h3>Price:"+s4+"</h3>");

            }
            
   
   }
   catch(Exception e){
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
