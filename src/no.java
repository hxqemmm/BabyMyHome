import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class no extends HttpServlet{
 
	public void service(HttpServletRequest req, HttpServletResponse res) 
    throws ServletException, IOException{
    }
    public void doGet(HttpServletRequest req, HttpServletResponse res) 
    throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("doGet Hello World!");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
    public void doPost(HttpServletRequest req, HttpServletResponse res) 
    throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("doPost Hello World!");
        out.println("</body>");
    }
} 
