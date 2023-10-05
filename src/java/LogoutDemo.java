import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LogoutDemo extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
{
 PrintWriter out=response.getWriter();
 response.sendRedirect("login.html");
 out.close();
}
}