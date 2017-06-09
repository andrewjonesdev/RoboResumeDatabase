package haveYouSeenRoboCup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Duty {
	private String dutyTitle = "Make Designs";
	private ArrayList <String> duties = new ArrayList();
	private Connection con = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	private int id = 0;
	public Duty(){
		//duties.add("Design Cards");
		try{
			Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/roboResume?"
                                + "user=root&password=password");
			stmt = con.createStatement();
			String sql  = "INSERT INTO DutyR (dutyTitle) VALUES (?);";
			PreparedStatement p = con.prepareStatement(sql);
			p.setString(1, dutyTitle);
			p.executeUpdate();
			//con.commit();
			}catch (SQLException e) {
				e.printStackTrace();
			}catch (ClassNotFoundException e) {
				e.printStackTrace();
		}
		id = getLastID();
	}
	public Duty(String dT){
		dutyTitle = dT;
		try{
			Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/roboResume?"
                                + "user=root&password=password");
			stmt = con.createStatement();
			String sql  = "INSERT INTO DutyR (dutyTitle) VALUES (?);";
			PreparedStatement p = con.prepareStatement(sql);
			p.setString(1, dT);
			p.executeUpdate();
			dutyTitle = dT;
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
			String sql  = "select dutyID from DutyR;";
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
	public String getdutyTitle(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/roboResume?"
                                + "user=root&password=password");
			stmt = con.createStatement();
			String sql  = "select dutyTitle from DutyR where dutyID = ?";
			PreparedStatement p = con.prepareStatement(sql);
			p.setInt(1, id);
			rs = p.executeQuery();
			rs.next();
			dutyTitle = rs.getString("dutyTitle");
			return dutyTitle;
			}catch (SQLException e) {
				e.printStackTrace();
			}catch (ClassNotFoundException e) {
				e.printStackTrace();
		}
		return dutyTitle;
	}
	public void setDutyTitle(String dT){
		try{
			Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/roboResume?"
                                + "user=root&password=password");
			stmt = con.createStatement();
			String sql  = "UPDATE DutyR SET dutyTitle = ? WHERE dutyID = ?;";
			PreparedStatement p = con.prepareStatement(sql);
			dutyTitle = dT;
			p.setString(1, dT);
			p.setInt(2, id);
			p.executeUpdate();
			rs.next();
			
			}catch (SQLException e) {
				e.printStackTrace();
			}catch (ClassNotFoundException e) {
				e.printStackTrace();
		}
	}
	/*public void addDuty(String d){
		duties.add(d);
	}
	public String getDutyAt(int d){
		return duties.get(d);
	}
	public void clearDuties(){
		duties.clear();
	}
	public int dutySize()
	{
		return duties.size();
	}*/
}
