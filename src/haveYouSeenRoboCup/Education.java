package haveYouSeenRoboCup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




public class Education {
	private String courseOfStudy = "";
	private String degree = "";
	private String school = "";
	private int gradYear = 0;
	private Connection con = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	private int id = 0;
	
	public Education(){
		courseOfStudy = "Graphic Design";
		degree = "M.F.A.";
		school = "Arizona State University";
		gradYear = 2010;
		try{
			Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/roboResume?"
                                + "user=root&password=password");
			stmt = con.createStatement();
			String sql  = "INSERT INTO EducationR (eduCourse,eduDegree,eduSchool,eduGradYear) VALUES (?,?,?,?);";
			PreparedStatement p = con.prepareStatement(sql);
			p.setString(1, courseOfStudy);
			p.setString(2, degree);
			p.setString(3, school);
			p.setInt(4, gradYear);
			p.executeUpdate();
			//con.commit();
			}catch (SQLException e) {
				e.printStackTrace();
			}catch (ClassNotFoundException e) {
				e.printStackTrace();
		}
		id = getLastID();
		
	}
	public Education(String cOS, String deg, String sch, int gY){
		courseOfStudy = cOS;
		degree = deg;
		school = sch;
		gradYear = gY;
		try{
			Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/roboResume?"
                                + "user=root&password=password");
			stmt = con.createStatement();
			String sql  = "INSERT INTO EducationR (eduCourse,eduDegree,eduSchool,eduGradYear) VALUES (?,?,?,?);";
			PreparedStatement p = con.prepareStatement(sql);
			p.setString(1, cOS);
			p.setString(2, deg);
			p.setString(3, sch);
			p.setInt(4, gY);
			p.executeUpdate();
			System.out.println(1);
			//con.commit();
			}catch (SQLException e) { 
			System.out.println(2);
				e.printStackTrace();
			}catch (ClassNotFoundException e) {
				System.out.println(3);
				e.printStackTrace();
		}
		id = getLastID();
	}
	private int getLastID(){
		int output = -1;
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/roboResume?"
                                + "user=root&password=password");
			stmt = con.createStatement();
			String sql  = "select eduID from EducationR;";
			PreparedStatement p = con.prepareStatement(sql);
			rs=p.executeQuery();
			rs.last();
			output = rs.getInt(1);
			id = output;
			return output;
			//p.setInt(1, id);
			}catch (SQLException e) {
				e.printStackTrace();
			}catch (ClassNotFoundException e) {
				e.printStackTrace();
		}
		return output;
	}
	public int getID(){
		return id;
	}
	public String getCourseOfStudy(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/roboResume?"
                                + "user=root&password=password");
			stmt = con.createStatement();
			String sql  = "select eduCourse from EducationR where eduID = ?";
			PreparedStatement p = con.prepareStatement(sql);
			p.setInt(1, id);
			rs = p.executeQuery();
			rs.next();
			courseOfStudy = rs.getString("eduCourse");
			return courseOfStudy;
			}catch (SQLException e) {
				e.printStackTrace();
			}catch (ClassNotFoundException e) {
				e.printStackTrace();
		}
		return courseOfStudy;
	}
	public String getDegree(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/roboResume?"
                                + "user=root&password=password");
			stmt = con.createStatement();
			String sql  = "select eduDegree from EducationR where eduID = ?";
			PreparedStatement p = con.prepareStatement(sql);
			p.setInt(1, id);
			rs = p.executeQuery();
			rs.next();
			degree = rs.getString("eduDegree");
			return degree;
			}catch (SQLException e) {
				e.printStackTrace();
			}catch (ClassNotFoundException e) {
				e.printStackTrace();
		}
		return degree;
	}
	public String getSchool(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/roboResume?"
                                + "user=root&password=password");
			stmt = con.createStatement();
			String sql  = "select eduSchool from EducationR where eduID = ?";
			PreparedStatement p = con.prepareStatement(sql);
			p.setInt(1, id);
			rs = p.executeQuery();
			rs.next();
			school = rs.getString("eduSchool");
			return school;
			}catch (SQLException e) {
				e.printStackTrace();
			}catch (ClassNotFoundException e) {
				e.printStackTrace();
		}
		return school;
	}
	public int getGradYear(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/roboResume?"
                                + "user=root&password=password");
			stmt = con.createStatement();
			String sql  = "select eduGradYear from EducationR where eduID = ?";
			PreparedStatement p = con.prepareStatement(sql);
			p.setInt(1, id);
			rs = p.executeQuery();
			rs.next();
			gradYear = rs.getInt("eduGradYear");
			return gradYear;
			}catch (SQLException e) {
				e.printStackTrace();
			}catch (ClassNotFoundException e) {
				e.printStackTrace();
		}
		return gradYear;
	}
	public void setCourseOfStudy(String cOS){
		try{
			Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/roboResume?"
                                + "user=root&password=password");
			stmt = con.createStatement();
			String sql  = "UPDATE EducationR SET eduCourse = ? WHERE eduID = ?;";
			PreparedStatement p = con.prepareStatement(sql);
			courseOfStudy = cOS;
			p.setString(1, cOS);
			p.setInt(2, id);
			p.executeUpdate();
			rs.next();
			
			}catch (SQLException e) {
				e.printStackTrace();
			}catch (ClassNotFoundException e) {
				e.printStackTrace();
		}
		
	}
	public void setDegree(String deg){
		try{
			Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/roboResume?"
                                + "user=root&password=password");
			stmt = con.createStatement();
			String sql  = "UPDATE EducationR SET eduDegree = ? WHERE eduID = ?;";
			PreparedStatement p = con.prepareStatement(sql);
			degree = deg;
			p.setString(1, deg);
			p.setInt(2, id);
			p.executeUpdate();
			rs.next();
			
			}catch (SQLException e) {
				e.printStackTrace();
			}catch (ClassNotFoundException e) {
				e.printStackTrace();
		}
	}
	public void setSchool(String sch){
		try{
			Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/roboResume?"
                                + "user=root&password=password");
			stmt = con.createStatement();
			String sql  = "UPDATE EducationR SET eduSchool = ? WHERE eduID = ?;";
			PreparedStatement p = con.prepareStatement(sql);
			school = sch;
			p.setString(1, sch);
			p.setInt(2, id);
			p.executeUpdate();
			rs.next();
			
			}catch (SQLException e) {
				e.printStackTrace();
			}catch (ClassNotFoundException e) {
				e.printStackTrace();
		}
	}
	public void setGradYear(int gY){
		try{
			Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/roboResume?"
                                + "user=root&password=password");
			stmt = con.createStatement();
			String sql  = "UPDATE EducationR SET eduGradYear = ? WHERE eduID = ?;";
			PreparedStatement p = con.prepareStatement(sql);
			gradYear = gY;
			p.setInt(1, gY);
			p.setInt(2, id);
			p.executeUpdate();
			rs.next();
			
			}catch (SQLException e) {
				e.printStackTrace();
			}catch (ClassNotFoundException e) {
				e.printStackTrace();
		}
	}
	public String toString(){
 
		
		return String.format("%s in %s\n%s, %s", degree, courseOfStudy, school, gradYear);
	}

	public String consoleTextFormatter(String text, int nextLine)
	{
		String[] listOfStrings = text.split(" ");
		String output = "";
		for (int count = 0; count < listOfStrings.length; count++){
			if (count%nextLine==0 && count!=0){
				output+=(listOfStrings[count] + "\n");
			}
			else if(count == listOfStrings.length-1){
				output+=listOfStrings[count];
			}
			else{
				output+=(listOfStrings[count] + " ");
			}
				
		}
		return output;
	}
}
