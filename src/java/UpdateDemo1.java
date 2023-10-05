import java.io.*;
import javax.servlet.*;
import java.sql.*;
import javax.servlet.http.*;

public class UpdateDemo1 extends HttpServlet
{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
		{
		PrintWriter out=response.getWriter();
                out.println("<html>");
                out.println("<body>");
                String s1=request.getParameter("n1");
                String s2=request.getParameter("n2");
                String s3=request.getParameter("n3");
                String s4=request.getParameter("n4");
                String s5=request.getParameter("n5");
                 
try
{
    Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/java55?useSSL=false","root","root");
	  Statement st=con.createStatement();
	st.executeUpdate("update insmarks set Name='"+s2+"',phy='"+s3+"',Chem='"+s4+"',Maths='"+s5+"' where RollNo='"+s1+"'");
      //  rd=request.getRequestDispatcher("Data Inserted");
      response.sendRedirect("ShowallDemo1");
                con.close();
  }
                catch(Exception e1)
{
	out.println(e1);
}
out.println("</body>");
out.println("</html>");
}
}
                
       

                