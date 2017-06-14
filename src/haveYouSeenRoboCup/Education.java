 package haveYouSeenRoboCup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import utilityForHire.UtilityMySql;




public class Education {
	private String courseOfStudy = "";
	private String degree = "";
	private String school = "";
	private int gradYear = 0;
	private Connection con = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	private String forName = "com.mysql.jdbc.Driver";
	private String driverConnection = "jdbc:mysql://localhost/roboResume?user=root&password=password";
//	private String driverConnection = "jdbc:mysql://localhost/roboResume?user=root&password=root";
	private String table = "EducationR";
	private String primaryKeyName = "eduID";
	private int primaryKeyID = 0;
	private Resume resume = new Resume();
	public Education(){
		courseOfStudy = "Graphic Design";
		degree = "M.F.A.";
		school = "Arizona State University";
		gradYear = 2010;
		try{
			Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(driverConnection);
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
		primaryKeyID = getLastID();
		
	}
	public Education(String cOS, String deg, String sch, int gY, Resume re){
		courseOfStudy = cOS;
		degree = deg;
		school = sch;
		gradYear = gY;
		resume = re;
		try{
			Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(driverConnection);
			stmt = con.createStatement();
			String sql  = "INSERT INTO EducationR (eduCourse,eduDegree,eduSchool,eduGradYear) VALUES (?,?,?,?);";
			PreparedStatement p = con.prepareStatement(sql);
			p.setString(1, courseOfStudy);
			p.setString(2, degree);
			p.setString(3, school);
			p.setInt(4, gradYear);
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
		primaryKeyID = getLastID();
	}
	private int getLastID(){

		return UtilityMySql.getLastID(forName, driverConnection, table, primaryKeyName);
	}
	public int getID(){
		return primaryKeyID;
	}
	public String getCourseOfStudy(){
		return UtilityMySql.getStringMySql(forName, driverConnection, courseOfStudy, "eduCourse", table, primaryKeyName, primaryKeyID);
	}
	public String getDegree(){
		return UtilityMySql.getStringMySql(forName, driverConnection, degree, "eduDegree", table, primaryKeyName, primaryKeyID);
	}
	public String getSchool(){
		return UtilityMySql.getStringMySql(forName, driverConnection, school, "eduSchool", table, primaryKeyName, primaryKeyID);
	}
	public int getGradYear(){
		return UtilityMySql.getIntMySql(forName, driverConnection, gradYear, "eduGradYear", table, primaryKeyName, primaryKeyID);
	}
	public Resume getResume(){
		return resume;
	}
	public void setCourseOfStudy(String cOS){
		UtilityMySql.setStringMySql(forName, driverConnection, courseOfStudy, cOS, "eduCourse", table, primaryKeyName, primaryKeyID);
	}
	public void setDegree(String deg){
		UtilityMySql.setStringMySql(forName, driverConnection, degree, deg, "eduDegree", table, primaryKeyName, primaryKeyID);
	}
	public void setSchool(String sch){
		UtilityMySql.setStringMySql(forName, driverConnection, school, sch, "eduSchool", table, primaryKeyName, primaryKeyID);
	}
	public void setGradYear(int gY){
		UtilityMySql.setIntMySql(forName, driverConnection, gradYear, gY, "eduGradYear", table, primaryKeyName, primaryKeyID);
	}
	public void setResume(Resume re){
		resume = re;
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
