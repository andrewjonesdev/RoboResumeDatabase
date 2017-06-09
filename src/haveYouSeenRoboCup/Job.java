package haveYouSeenRoboCup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Job {
	private String jobTitle = "Graphic Designer";
	private ArrayList <String> duties = new ArrayList();
	private ArrayList <Duty> dutyList = new ArrayList();
	private Connection con = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	private int id = 0;
	private int count = 1;
	public Job(){
		duties.add("Design Cards");
		try{
			Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/roboResume?"
                                + "user=root&password=password");
			stmt = con.createStatement();
			String sql  = "INSERT INTO JobR (jobTitle) VALUES (?);";
			PreparedStatement p = con.prepareStatement(sql);
			p.setString(1, jobTitle);
			p.executeUpdate();
			//con.commit();
			}catch (SQLException e) {
				e.printStackTrace();
			}catch (ClassNotFoundException e) {
				e.printStackTrace();
		}
		id = getLastID();
	}
	public Job(String jT){
		jobTitle = jT;
		try{
			Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/roboResume?"
                                + "user=root&password=password");
			stmt = con.createStatement();
			String sql  = "INSERT INTO JobR (jobTitle) VALUES (?);";
			PreparedStatement p = con.prepareStatement(sql);
			p.setString(1, jT);
			p.executeUpdate();
			jobTitle = jT;
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
			String sql  = "select jobID from JobR;";
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
	public String getJobTitle(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/roboResume?"
                                + "user=root&password=password");
			stmt = con.createStatement();
			String sql  = "select dutyTitle from JobR where jobID = ?";
			PreparedStatement p = con.prepareStatement(sql);
			p.setInt(1, id);
			rs = p.executeQuery();
			rs.next();
			jobTitle = rs.getString("dutyTitle");
			return jobTitle;
			}catch (SQLException e) {
				e.printStackTrace();
			}catch (ClassNotFoundException e) {
				e.printStackTrace();
		}
		return jobTitle;
	}
	public void setJobTitle(String jT){
		try{
			Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/roboResume?"
                                + "user=root&password=password");
			stmt = con.createStatement();
			String sql  = "UPDATE JobR SET jobTitle = ? WHERE jobID = ?;";
			PreparedStatement p = con.prepareStatement(sql);
			jobTitle = jT;
			p.setString(1, jT);
			p.setInt(2, id);
			p.executeUpdate();
			rs.next();
			
			}catch (SQLException e) {
				e.printStackTrace();
			}catch (ClassNotFoundException e) {
				e.printStackTrace();
		}
	}
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
		}*/
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
	}
}
