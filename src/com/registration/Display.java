package com.registration;

import java.io.IOException;
import java.io.PrintWriter;
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

/**
 * Servlet implementation class Display
 */
@WebServlet("/Display")
public class Display extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String D= req.getParameter("lan");
		String c="c";
		String g="cp";
		String f="Java";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/register","root","root");
			
			
			if(D.equals(c)){
			PreparedStatement st=con.prepareStatement("select * from clist where c=c ");
			
			ResultSet rs=st.executeQuery();
			PrintWriter out= resp.getWriter();
			while(rs.next())
			{
				out.println(rs.getString("Fname")+" "+rs.getString("Lname")+" "+rs.getString("Pno")+" "+rs.getString("Email")+" ");
				
			}
			}
			if(D.equals(g)){
				PreparedStatement st=con.prepareStatement("select * from clist where c++=cp");
			
				ResultSet rs=st.executeQuery();
				
				PrintWriter out= resp.getWriter();
				while(rs.next())
				{
					resp.getWriter().println(rs.getString("Fname")+" "+rs.getString("Lname")+" "+rs.getString("Pno")+" "+rs.getString("Email")+" ");
				}
				}
			if(D.equals(f)){
				PreparedStatement st=con.prepareStatement("select * from clist where Java=Java");
				
				ResultSet rs=st.executeQuery();
				
				PrintWriter out= resp.getWriter();
				while(rs.next())
				{
					
					out.println(rs.getString("Fname")+" "+rs.getString("Lname")+" "+rs.getString("Pno")+" "+rs.getString("Email")+" ");
				}
				}
			
			} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

}
