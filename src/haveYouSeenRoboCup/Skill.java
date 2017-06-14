package haveYouSeenRoboCup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import utilityForHire.UtilityMySql;

public class Skill {
	private String skillName = "";
	private String rating = "";
	private Connection con = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	private String forName = "com.mysql.jdbc.Driver";
	private String driverConnection = "jdbc:mysql://localhost/Customer?user=root&password=password";
	//private String driverConnection = "jdbc:mysql://localhost/roboResume?user=root&password=root";
	private String table = "SkillR";
	private String primaryKeyName = "skillID";
	private int primaryKeyID = 0;

	public Skill(){
		skillName = "Adobe Illustrator";
		rating = "Godlike";
		try{
			Class.forName(forName);
            con = DriverManager.getConnection(driverConnection);
			stmt = con.createStatement();
			String sql  = "INSERT INTO SkillR (skillName,skillRating) VALUES (?,?);";
			PreparedStatement p = con.prepareStatement(sql);
			p.setString(1, skillName);
			p.setString(2, rating);
			p.executeUpdate();
			//con.commit();
			}catch (SQLException e) {
				e.printStackTrace();
			}catch (ClassNotFoundException e) {
				e.printStackTrace();
		}
		primaryKeyID = getLastID();
	}
	public Skill(String sN, String ra){
		skillName = sN;
		rating = ra;
		try{
			Class.forName(forName);
            con = DriverManager.getConnection(driverConnection);
			stmt = con.createStatement();
			String sql  = "INSERT INTO SkillR (skillName,skillRating) VALUES (?,?);";
			PreparedStatement p = con.prepareStatement(sql);
			p.setString(1, sN);
			p.setString(2, ra);
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
	public String getSkillName(){
		return UtilityMySql.getStringMySql(forName, driverConnection, skillName, "skillName", table, primaryKeyName, primaryKeyID);
	}
	public String getRating(){
		return UtilityMySql.getStringMySql(forName, driverConnection, rating, "skillRating", table, primaryKeyName, primaryKeyID);
	}
	public void setSkillName(String sN){
		UtilityMySql.setStringMySql(forName, driverConnection, skillName, sN, "skillName", table, primaryKeyName, primaryKeyID);
	}
	public void setRating(String ra){
		UtilityMySql.setStringMySql(forName, driverConnection, rating, ra, "skillRating", table, primaryKeyName, primaryKeyID);
	}
	
	public String toString(){
		return String.format("%s, %s", skillName, rating);
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
