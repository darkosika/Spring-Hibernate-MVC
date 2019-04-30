package com.okaplan.testdb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class testDbServlet
 */
public class testDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public testDbServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//set up connection variables
		String user="root";
		String pass="root";
		
		String jdbcUrl="jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC";
		String driver="com.mysql.jdbc.Driver";
		//get connection to db
		try {
			PrintWriter out=response.getWriter();
			out.println("Connecting db:"+ jdbcUrl);
			Class.forName(driver);
			Connection myconn=DriverManager.getConnection(jdbcUrl, user, pass);
			out.println("SUCCESS");
			myconn.close();
		} catch (Exception e) {
			throw new ServletException(e);
		}
		//
	}

}
