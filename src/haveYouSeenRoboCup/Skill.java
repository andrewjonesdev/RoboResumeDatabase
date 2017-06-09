package haveYouSeenRoboCup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Skill {
	private String skillName = "";
	private String rating = "";
	private Connection con = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	private int id = 0;
	
	public Skill(){
		skillName = "Adobe Illustrator";
		rating = "Godlike";
		try{
			Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/roboResume?"
                                + "user=root&password=password");
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
		id = getLastID();
	}
	public Skill(String sN, String ra){
		skillName = sN;
		rating = ra;
		try{
			Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/roboResume?"
                                + "user=root&password=password");
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
		id = getLastID();
	}
	private int getLastID(){
		int output = -1;
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/roboResume?"
                                + "user=root&password=password");
			stmt = con.createStatement();
			String sql  = "select skillID from SkillR;";
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
	public String getSkillName(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/roboResume?"
                                + "user=root&password=password");
			stmt = con.createStatement();
			String sql  = "select skillName from SkillR where skillID = ?";
			PreparedStatement p = con.prepareStatement(sql);
			p.setInt(1, id);
			rs = p.executeQuery();
			rs.next();
			skillName = rs.getString("skillName");
			return skillName;
			}catch (SQLException e) {
				e.printStackTrace();
			}catch (ClassNotFoundException e) {
				e.printStackTrace();
		}
		return skillName;
	}
	public String getRating(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/roboResume?"
                                + "user=root&password=password");
			stmt = con.createStatement();
			String sql  = "select skillRating from SkillR where skillID = ?";
			PreparedStatement p = con.prepareStatement(sql);
			p.setInt(1, id);
			rs = p.executeQuery();
			rs.next();
			rating = rs.getString("skillRating");
			return rating;
			}catch (SQLException e) {
				e.printStackTrace();
			}catch (ClassNotFoundException e) {
				e.printStackTrace();
		}
		return rating;
	}
	public void setSkillName(String sN){
		try{
			Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/roboResume?"
                                + "user=root&password=password");
			stmt = con.createStatement();
			String sql  = "UPDATE SkillR SET skillName = ? WHERE skillID = ?;";
			PreparedStatement p = con.prepareStatement(sql);
			skillName = sN;
			p.setString(1, sN);
			p.setInt(2, id);
			p.executeUpdate();
			rs.next();
			
			}catch (SQLException e) {
				e.printStackTrace();
			}catch (ClassNotFoundException e) {
				e.printStackTrace();
		}
	}
	public void setRating(String ra){
		try{
			Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/roboResume?"
                                + "user=root&password=password");
			stmt = con.createStatement();
			String sql  = "UPDATE SkillR SET skillRating = ? WHERE skillID = ?;";
			PreparedStatement p = con.prepareStatement(sql);
			rating = ra;
			p.setString(1, ra);
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
