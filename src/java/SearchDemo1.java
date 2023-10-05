import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class SearchDemo1 extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
{
	//String s1=request.getParameter("un");
	String s1=request.getParameter("u1");
	PrintWriter out=response.getWriter();
	out.println("<html>");
	out.println("<head>");
	
	out.println("<link rel='Stylesheet' href='abc.css'>");

       out.println("</head>");
       out.println("<body>");

       out.println("<div id='mymenu'>");
       out.println("<ul><li>Home</li><li><a href='insertdemo.html'>Insert</a></li><li>Search</li><li>Update</li><li>Delete</li><li>Showall</li><li>logout</li>");
		
		out.println("<div id='data'>");
		out.println("<center>");
	
	try
	{
	
	  Class.forName("com.mysql.cj.jdbc.Driver");
	  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/java55?useSSL=false","root","root");
	  Statement st=con.createStatement();
	  ResultSet rs=st.executeQuery("select * from insmarks where RollNo='"+s1+"'");
	  out.println("<table cellpadding='20'>");
			
	       out.println("<tr>");
			out.println("<th>Rollno</th>");
			out.println("<th>Name</th>");
			out.println("<th>Physics</th>");
			out.println("<th>Chemistry</th>");
			out.println("<th>Maths</th>");
			out.println("</tr>");
			
			while(rs.next())
			{
				out.println("<tr>");
				out.println("<td>"+rs.getString(1)+"</td>");
				out.println("<td>"+rs.getString(2)+"</td>");
				out.println("<td>"+rs.getString(3)+"</td>");
				out.println("<td>"+rs.getString(4)+"</td>");
				out.println("<td>"+rs.getString(5)+"</td>");
				
				out.println("</tr>");
			}
			out.println("</table>");
	  con.close();
        }
catch(Exception e1)
{
	System.out.println(e1);
}
	out.println("</center>");
	out.println("</html>");
}
}