import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class LoginDemo1 extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
{
	String s1=request.getParameter("u1");
	String s2=request.getParameter("u2");
	PrintWriter out=response.getWriter();
	out.println("<html>");
	out.println("<body>");
	
	try
	{
	
	  Class.forName("com.mysql.cj.jdbc.Driver");
	  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/java55?allowPublicKeyRetrieval=true&useSSL=false","root","root");
	  Statement st=con.createStatement();
	  ResultSet rs=st.executeQuery("select * from login where Name='"+s1+"'and Password='"+s2+"'");
	  if(rs.next())
	  {
              HttpSession session=request.getSession();
              session.setAttribute("uname",s1);
              
            //Cookie ck=new Cookie("un","Shyam");
         //   ck.setMaxAge(60*30);
             // response.addCookie(ck);   
		response.sendRedirect("mymenu1"); 
	  }
	  else
	  {
		out.println("invalid user name and password");  
	  }
	  con.close();
}

catch(Exception e1)
{
	out.println(e1);
}
	//out.println("<h1>Data Insert</h1>");
	out.println("</body>");
	out.println("</html>");
}
}