import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class ServerDemo2 extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
{	
    PrintWriter out=response.getWriter();
	out.println("<html>");
	out.println("<body>");

	String s1=request.getParameter("u1");
	String s2=request.getParameter("u2");
	
	try
	{
	
	  Class.forName("com.mysql.cj.jdbc.Driver");
	  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/java55?useSSL=false","root","root");
	  Statement st=con.createStatement();
	  st.executeUpdate("insert into login values('"+s1+"','"+s2+"')");
                   con.close();
          	//  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/java55?useSSL=false","root","root");

}

catch(Exception e1)
{
	System.out.println(e1);
}
	response.sendRedirect("login.html");
	out.println("</body>");
	out.println("</html>");
        out.close();
}
}