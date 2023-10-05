import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class SUpdateDemo extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
{
	//String s1=request.getParameter("u");
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
    try
    {
                        Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/java55?useSSL=false","root","root");
			Statement st=con.createStatement();       
			ResultSet rs=st.executeQuery("select * from insmarks where RollNo='"+s1+"'");
			
                        if(rs.next())
                        {
                            out.println("<form action='UpdateDemo1'>");
                            out.println("<center>");
                            out.println("<table cellpadding='20'>");
                            out.println("<tr>");
                            out.println("<td>RollNo</td>");
                            out.println("<td><input type='text' name='n1' value='"+rs.getString(1)+"'></td>");
                            out.println("</tr>");
                           
                            out.println("<tr>");
                            out.println("<td>Name</td>");
                            out.println("<td><input type='text' name='n2' value='"+rs.getString(2)+"'></td>");
                            out.println("</tr>");
                           
                            out.println("<tr>");
                            out.println("<td>Phy</td>");
                            out.println("<td><input type='text' name='n3' value='"+rs.getString(3)+"'></td>");
                            out.println("</tr>");
                           
                            out.println("<tr>");
                            out.println("<td>Chem</td>");
                            out.println("<td><input type='text' name='n4' value='"+rs.getString(4)+"'></td>");
                            out.println("</tr>");
                           
                            out.println("<tr>");
                            out.println("<td>Maths</td>");
                            out.println("<td><input type='text' name='n5' value='"+rs.getString(5)+"'></td>");
                            out.println("</tr>");
                           
                           out.println("</center>");
                           out.println("</table>");
                           out.println("<input type='Submit'value='Update'class='B'>");
                        }
                        out.println("</table>");
                           con.close();
                        }
catch(Exception e1)
{
    out.println(e1);
}
out.println("</center>");
out.println("</html>");
   }
}
            
       
       