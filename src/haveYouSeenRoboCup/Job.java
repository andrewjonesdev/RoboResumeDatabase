package haveYouSeenRoboCup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import utilityForHire.UtilityMySql;

public class Job {
	private String jobTitle = "Graphic Designer";
	private ArrayList <String> duties = new ArrayList();
	private ArrayList <Duty> dutyList = new ArrayList();
	private Connection con = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	private int id = 0;
	private int count = 1;
	private String forName = "com.mysql.jdbc.Driver";
	private String driverConnection = "jdbc:mysql://localhost/Customer?user=root&password=password";
	//private String driverConnection = "jdbc:mysql://localhost/roboResume?user=root&password=root";
	private String table = "Customer";
	private String primaryKeyName = "CustomerID";
	private int primaryKeyID = 0;
	private Work work = new Work();
	private int workID = work.getID();
	public Job(){
		//duties.add("Design Cards");
		String jobTitle = "Graphic Designer";
		workID = work.getID();
		try{
			Class.forName(forName);
            con = DriverManager.getConnection(driverConnection);
			stmt = con.createStatement();
			String sql  = "INSERT INTO JobR (jobTitle,jobWork) VALUES (?,?);";
			PreparedStatement p = con.prepareStatement(sql);
			p.setString(1, jobTitle);
			p.setInt(2, workID);
			p.executeUpdate();
			//con.commit();
			}catch (SQLException e) {
				e.printStackTrace();
			}catch (ClassNotFoundException e) {
				e.printStackTrace();
		}
		primaryKeyID = getLastID();
	}
	public Job(String jT, Work wo){
		jobTitle = jT;
		work = wo;
		workID = wo.getID();
		try{
			Class.forName(forName);
            con = DriverManager.getConnection(driverConnection);
			stmt = con.createStatement();
			String sql  = "INSERT INTO JobR (jobTitle,jobWork) VALUES (?,?);";
			PreparedStatement p = con.prepareStatement(sql);
			p.setString(1, jobTitle);
			p.setInt(2, workID);
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
	public String getJobTitle(){
		return UtilityMySql.getStringMySql(forName, driverConnection, jobTitle, "jobTitle", table, primaryKeyName, primaryKeyID);
	}
	public Work getWork(){
		return work;
	}
	public void setJobTitle(String jT){
		UtilityMySql.setStringMySql(forName, driverConnection, jobTitle, jT, "jobTitle", table, primaryKeyName, primaryKeyID);
	}
	public void setWork(Work wo){
		wo = work;
		UtilityMySql.setIntMySql(forName, driverConnection, workID, wo.getID(), "jobWork", table, primaryKeyName, primaryKeyID);
	}
	/*
	public void addDuty(String d){
		
		Duty duty = new Duty(d);
		dutyList.add(duty);
		count++;
		try{
			Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/roboResume?"
                                + "user=root&password=password");
			stmt = con.createStatement();
			String sql  = "UPDATE DutyR SET dutyJob = ? WHERE jobID = ?;";
			PreparedStatement p = con.prepareStatement(sql);
			p.setInt(1, id);
			p.setInt(2, duty.getID());
			p.executeUpdate();
			rs.next();
			
			}catch (SQLException e) {
				e.printStackTrace();
			}catch (ClassNotFoundException e) {
				e.printStackTrace();
		}
		/*try{
			Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/roboResume?"
                                + "user=root&password=password");
			stmt = con.createStatement();
			String sql  = "ALTER TABLE DutyR ADD duty? INTEGER;";
			PreparedStatement p = con.prepareStatement(sql);
			duties.add(d);
			p.setString(1, Integer.toString(count));
			p.executeUpdate();
			rs.next();
			
			}catch (SQLException e) {
				e.printStackTrace();
			}catch (ClassNotFoundException e) {
				e.printStackTrace();
		}
		try{
			Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/roboResume?"
                                + "user=root&password=password");
			stmt = con.createStatement();
			String sql  = "UPDATE DutyR SET duty? = ? WHERE dutyID = ?;";
			PreparedStatement p = con.prepareStatement(sql);
			p.setString(1, Integer.toString(count));
			p.setInt(2, duty.getID());
			p.setInt(3, id);
			p.executeUpdate();
			rs.next();
			
			}catch (SQLException e) {
				e.printStackTrace();
			}catch (ClassNotFoundException e) {
				e.printStackTrace();
		}
		try{
			Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/roboResume?"
                                + "user=root&password=password");
			stmt = con.createStatement();
			String sql  = "SELECT JobR.duty? = DutyR.dutyID FROM JobR INNER JOIN DutyR ON JobR.duty? = DutyR.dutyID;";
			PreparedStatement p = con.prepareStatement(sql);
			p.setString(1, Integer.toString(count));
			p.setString(2, Integer.toString(count));
			p.executeUpdate();
			rs.next();
			
			}catch (SQLException e) {
				e.printStackTrace();
			}catch (ClassNotFoundException e) {
				e.printStackTrace();
		}*//*
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
