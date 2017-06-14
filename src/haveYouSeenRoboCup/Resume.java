package haveYouSeenRoboCup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import utilityForHire.UtilityMySql;

public class Resume {
	private String firstName = "";
	private String lastName = "";
	private String email = "";
	private Connection con = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	private String forName = "com.mysql.jdbc.Driver";
	private String driverConnection = "jdbc:mysql://localhost/roboResume?user=root&password=password";
	//private String driverConnection = "jdbc:mysql://localhost/roboResume?user=root&password=root";
	private String table = "ResumeR";
	private String primaryKeyName = "resumeID";
	private int primaryKeyID = 0;

	public Resume(){
		firstName = "Andrew";
		lastName = "Jones";
		email = "andrewjonesexample@email.com";
		try{
			Class.forName(forName);
            con = DriverManager.getConnection(driverConnection);
			stmt = con.createStatement();
			String sql  = "INSERT INTO ResumeR (resumeFirst,resumeLast,resumeEmail) VALUES (?,?,?);";
			PreparedStatement p = con.prepareStatement(sql);
			p.setString(1, firstName);
			p.setString(2, lastName);
			p.setString(3, email);
			p.executeUpdate();
			//con.commit();
			}catch (SQLException e) {
				e.printStackTrace();
			}catch (ClassNotFoundException e) {
				e.printStackTrace();
		}
		primaryKeyID = getLastID();
	}
	public Resume(String fN, String lN, String em){
		firstName = fN;
		lastName = lN;
		email = em;
		try{
			Class.forName(forName);
            con = DriverManager.getConnection(driverConnection);
			stmt = con.createStatement();
			String sql  = "INSERT INTO ResumeR (resumeFirst,resumeLast,resumeEmail) VALUES (?,?,?);";
			PreparedStatement p = con.prepareStatement(sql);
			p.setString(1, firstName);
			p.setString(2, lastName);
			p.setString(3, email);
			p.executeUpdate();
			//con.commit();
			}catch (SQLException e) {
				e.printStackTrace();
			}catch (ClassNotFoundException e) {
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
	public String getfirstName(){
		return UtilityMySql.getStringMySql(forName, driverConnection, firstName, "resumeFirst", table, primaryKeyName, primaryKeyID);
	}
	public String getLastName(){
		return UtilityMySql.getStringMySql(forName, driverConnection, lastName, "resumeLast", table, primaryKeyName, primaryKeyID);
	}
	public String getEmail(){
		return UtilityMySql.getStringMySql(forName, driverConnection, email, "resumeEmail", table, primaryKeyName, primaryKeyID);
	}
	public void setFirstName(String fN){
		UtilityMySql.setStringMySql(forName, driverConnection, firstName, fN, "resumeFirst", table, primaryKeyName, primaryKeyID);
	}
	public void setLastName(String lN){
		UtilityMySql.setStringMySql(forName, driverConnection, lastName, lN, "resumeLast", table, primaryKeyName, primaryKeyID);
	}
	public void setEmail(String em){
		UtilityMySql.setStringMySql(forName, driverConnection, email, em, "resumeEmail", table, primaryKeyName, primaryKeyID);
	}
	/*public String toString(){
		return String.format("%s, %s", skillName, rating);
	}
*/
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
