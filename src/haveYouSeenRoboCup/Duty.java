package haveYouSeenRoboCup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import utilityForHire.UtilityMySql;

public class Duty {
	private String dutyTitle = "";
	private ArrayList <String> duties = new ArrayList();
	private Connection con = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	private String forName = "com.mysql.jdbc.Driver";
	private String driverConnection = "jdbc:mysql://localhost/roboResume?user=root&password=password";
//	private String driverConnection = "jdbc:mysql://localhost/roboResume?user=root&password=root";
	private String table = "DutyR";
	private String primaryKeyName = "dutyID";
	private int primaryKeyID = 0;
	private Job job = new Job();
	public Duty(){
		//duties.add("Design Cards");
		dutyTitle = "Make Designs";
		try{
			Class.forName(forName);
            con = DriverManager.getConnection(driverConnection);
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
		primaryKeyID = getLastID();
	}
	public Duty(String dT, Job jo){
		dutyTitle = dT;
		job = jo;
		try{
			Class.forName(forName);
            con = DriverManager.getConnection(driverConnection);
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
		primaryKeyID = getLastID();
	}
	private int getLastID(){
		return UtilityMySql.getLastID(forName, driverConnection, table, primaryKeyName);
	}
	public int getID(){
		return primaryKeyID;
	}
	public String getdutyTitle(){
		return UtilityMySql.getStringMySql(forName, driverConnection, dutyTitle, "", table, primaryKeyName, primaryKeyID);
	}
	public Job getJob(){
		return job;
	}
	public void setDutyTitle(String dT){
		UtilityMySql.setStringMySql(forName, driverConnection, dutyTitle, dT, "dutyTitle", table, primaryKeyName, primaryKeyID);
	}
	public void setJob(Job jo){
		job = jo;
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
