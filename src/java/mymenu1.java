import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class mymenu1 extends HttpServlet
{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
		{
		PrintWriter out=response.getWriter();
               // Cookie ck[]=request.getCookies();
             //if(ck!=null)
             //{
                
		out.println("<html>");
		out.println("<head>");
		out.println("<link rel='Stylesheet' href='abc.css'>");

       out.println("</head>");
       out.println("<body>");

       out.println("<div id='mymenu'>");
       out.println("<ul><li><a href='Login.html'>Home</a></li><li><a href='insertdemo.html'>Insert</a></li><li><a href='Searchdemo.html'>Search</a></li><li><a href='Update.html'>Update</a></li><li><a href='DeleteDemo.html'>Delete</a></li><li><a href='ShowallDemo1'>Showall</a></li><li><a href='LogoutDemo2'>Logout</a></li>");
		
		out.println("<div id='data'>");
		out.println("<center>");
                HttpSession session=request.getSession();
               String s1=(String)session.getAttribute("uname");
		//out.println(ck[0].getValue());
                                out.println("<h1>Welcome"+s1+"</h1>");
                //out.println("<h1>Welcome</h1>"+ck[0].getValue());
		out.println("</center>");
                   out.println("</body>");
		out.println("</html>");
            // }
            // else
             //{
             //    response.sendRedirect("login.html");
            // }
		out.close();
                
	   }
    }

				