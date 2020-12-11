/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

/**
 *
 * @author admin
 */
public class SaveProduct extends HttpServlet {
    private Object mypack;

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
        String pcode="",pname="",pdesc="",pcat="";
    int price = 0;
    byte[] photo = null;
 
        
                    PrintWriter out=response.getWriter();
        DiskFileItemFactory factory=new DiskFileItemFactory();
        ServletFileUpload upload=new ServletFileUpload(factory);
        try  {
            List<FileItem> items=upload.parseRequest(new ServletRequestContext(request));
         for(int i=0;i<items.size();i++){
         FileItem item=items.get(i);
         String name=item.getFieldName();
          if(name.equals("pcode")){
  pcode=item.getString();
  }else if(name.equals("pname")){
  pname=item.getString();
  }else if(name.equals("pdesc")){
  pdesc=item.getString();
  
  }else if(name.equals("pcat")){
  pcat=item.getString();
  }else if(name.equals("price")){
      price=Integer.parseInt(item.getString());
  }else if(name.equals("photo")){
  photo=item.get();
  }
         }
         Connection con=Data.connect();
         String sql="INSERT INTO PRODUCTS  VALUES(?,?,?,?,?,?)";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1,pcode);
                    ps.setString(2,pname);
                     ps.setString(3,pdesc);
                     ps.setString(4,pcat);
                      ps.setInt(5,price);
                      ps.setBytes(6,photo);
                      ps.executeUpdate();
                      con.close();

            out.println("<html>");
            out.println("<head>");
            
            out.println("</head>");
            out.println("<body>");
            out.println("<h3>product "+pname+" saved"+"</h3>");
            out.println("<pre>");

            out.println("<a href=addproduct.jsp>ADD-MORE</a>");
             out.println("<a href=index.jsp>HOME</a>");
            out.println("</pre>");

            out.println("</body>");
            out.println("</html>");
        }catch(Exception e){
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
