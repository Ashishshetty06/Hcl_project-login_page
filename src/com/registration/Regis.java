package com.registration;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Regis")
public class Regis extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public Regis() {
        super();
        
    }

	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String Fname= req.getParameter("Fname");
		String Lname= req.getParameter("Lname");
		String mob= req.getParameter("Pno");
		String email= req.getParameter("email");
		String lan1=req.getParameter("lan1");
		String lan2=req.getParameter("lan2");
		String lan3=req.getParameter("lan3");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/register","root","root");
			PreparedStatement st=con.prepareStatement("select Pno from clist where Pno=? and Email=? ");
			st.setString(1,mob);
			st.setString(2,email);
			ResultSet rs= st.executeQuery();
			if(rs.next()==false)
			{
				PreparedStatement st1=con.prepareStatement("insert into clist values(?,?,?,?,?,?,?)");
				st1.setString(1,Fname);
				st1.setString(2, Lname);
				st1.setString(3, mob );
				st1.setString(4, email );
				st1.setString(5, lan1);
				st1.setString(6, lan2);
				st1.setString(7, lan3);
				st1.executeUpdate();
				
				res.sendRedirect("loginsucc.jsp");
			}
			else{
				res.sendRedirect("Display.jsp");
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
		
			e.printStackTrace();
		}
		
	}

}
