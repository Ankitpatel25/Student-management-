import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LogoutDemo2 extends HttpServlet
{
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
		{
                    HttpSession session=request.getSession();
                  session.invalidate();
             // Cookie ck=new Cookie("un","");
               //ck.setMaxAge(0);
               //response.addCookie(ck);
		response.sendRedirect("login.html"); 
                }
}