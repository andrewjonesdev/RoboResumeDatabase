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
	private Work work = new Work();
	private int workID = work.getID();
	public Duty(){
		//duties.add("Design Cards");
		dutyTitle = "Make Designs";
		workID = work.getID();
		try{
			Class.forName(forName);
            con = DriverManager.getConnection(driverConnection);
			stmt = con.createStatement();
			String sql  = "INSERT INTO DutyR (dutyTitle,dutyWork) VALUES (?,?);";
			PreparedStatement p = con.prepareStatement(sql);
			p.setString(1, dutyTitle);
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
	public Duty(String dT, Work wo){
		dutyTitle = dT;
		work = wo;
		try{
			Class.forName(forName);
            con = DriverManager.getConnection(driverConnection);
			stmt = con.createStatement();
			String sql  = "INSERT INTO DutyR (dutyTitle,dutyWork) VALUES (?,?);";
			PreparedStatement p = con.prepareStatement(sql);
			p.setString(1, dutyTitle);
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
	public String getdutyTitle(){
		return UtilityMySql.getStringMySql(forName, driverConnection, dutyTitle, "dutyTitle", table, primaryKeyName, primaryKeyID);
	}
	public Work getWork(){
		return work;
	}
	public void setDutyTitle(String dT){
		UtilityMySql.setStringMySql(forName, driverConnection, dutyTitle, dT, "dutyTitle", table, primaryKeyName, primaryKeyID);
	}
	public void setWork(Work wo){
		work = wo;
		UtilityMySql.setIntMySql(forName, driverConnection, workID, wo.getID(), "dutyWork", table, primaryKeyName, primaryKeyID);
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
