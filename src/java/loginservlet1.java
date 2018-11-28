import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hp
 */
public class loginservlet1 extends HttpServlet {

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
            
            String uname = request.getParameter("email");
		String pswd = request.getParameter("password");
		
                
 Class.forName("com.mysql.jdbc.Driver");  
        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/poject","root","");  
String LoginQuery = "select* from signup";
Statement stmt = conn.createStatement();  
ResultSet rs = stmt.executeQuery(LoginQuery);  
int flag = 0;
while(rs.next())  
{
    String r = rs.getString("email");
    System.out.println("r: " +r);
    String s = rs.getString("password");
    System.out.println("s: " +s);
if(uname.equals(r))
{
    if(pswd.equals(s))
    {
        flag = 1;
    } 
    
}
}
if(flag == 1)
{
    RequestDispatcher rd = request.getRequestDispatcher("home.html");
            rd.forward(request , response);
}
else
{
    out.println("Login unsuccessful");
}

//conn.close();  

}
       catch(Exception e)
       {
           System.out.println(e);
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
