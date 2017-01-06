package com.google;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Demo
 */
public class Demo extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Demo() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    PrintWriter out=response.getWriter();
	    String id=request.getParameter("id");
	    String name=request.getParameter("name");
	    String salary=request.getParameter("salary");
	    try
	    {
	    	Class.forName("org.apache.hive.jdbc.HiveDriver");
	    	  Connection con = DriverManager.getConnection("jdbc:hive2://10.10.0.30:10000/kiran", "hive", "");
	    	  PreparedStatement ps=con.prepareStatement(  
	    			  "insert into ki values(?,?,?)");  
	    			    
	    			  ps.setString(1,id);  
	    			  ps.setString(2,name);  
	    			  ps.setString(3,salary);  
	    			      			            
	    			  int i=ps.executeUpdate();  
	    			  if(i>0)  
	    			  out.print("You are successfully registered...");  
	    			        
	    			            
	    			  }catch (ClassNotFoundException e2)
	                {
	    				  e2.printStackTrace();
	    				  }
	                    catch (SQLException e) {
						e.printStackTrace();
					}  
	    			            
	    			  out.close();  
	    			  }  
	    }

