import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class InsertDemo1 extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
{
	String s1=request.getParameter("u1");
	String s2=request.getParameter("u2");
	String s3=request.getParameter("u3");
	String s4=request.getParameter("u4");
	String s5=request.getParameter("u5");
	PrintWriter out=response.getWriter();
	out.println("<html>");
	out.println("<body>");
	
	try
	{
	
	  Class.forName("com.mysql.cj.jdbc.Driver");
	  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/java55?useSSL=false","root","root");
	  Statement st=con.createStatement();
	  st.executeUpdate("insert into insmarks values ('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"')");
	response.sendRedirect("ShowallDemo1");  
                  con.close();
}
catch(Exception e1)
{
	System.out.println(e1);
}
	
       // response.sendRedirect("mymenu1.html"); 
	out.println("</body>");
	out.println("</html>");
}
}