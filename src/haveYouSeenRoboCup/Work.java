package haveYouSeenRoboCup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import utilityForHire.UtilityMySql;

//import java.util.ArrayList;

public class Work {
	private String jobTitle = "";
	private String employer = "";
	private String startMonth = "";
	private String endMonth = "";
	private int startYear = 0;
	private int endYear = 0;
	private Connection con = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	private String forName = "com.mysql.jdbc.Driver";
	private String driverConnection = "jdbc:mysql://localhost/roboResume?user=root&password=password";
//	private String driverConnection = "jdbc:mysql://localhost/roboResume?user=root&password=root";
	private String table = "WorkR";
	private String primaryKeyName = "workID";
	private int primaryKeyID = 0;
	//private ArrayList <String> duties = new ArrayList();
	//private Job job = new Job(); 
	
	public Work(){
		//jobTitle = "Graphic Designer";
		//jobTitle = job.getJobTitle();
		employer = "Hallmark";
		startMonth = "M.F.A.";
		endMonth = "Arizona State University";
		startYear = 2010;
		endYear = 2017;
		try{
			Class.forName(forName);
            con = DriverManager.getConnection(driverConnection);
			stmt = con.createStatement();
			String sql  = "INSERT INTO WorkR (employer,startMonth,startYear,endMonth,endYear) VALUES (?,?,?,?,?);";
			PreparedStatement p = con.prepareStatement(sql);
			p.setString(1, employer);
			p.setString(2, startMonth);
			p.setInt(3, startYear);
			p.setString(4, endMonth);
			p.setInt(5, endYear);
			p.executeUpdate();
			//con.commit();
			}catch (SQLException e) {
				e.printStackTrace();
			}catch (ClassNotFoundException e) {
				e.printStackTrace();
		}
		primaryKeyID = getLastID();
		
		//job.addDuty("Design Cards");
	}
	public Work(/*String jT,*/ String em, String sM, String eM, int sY, int eY){
		//jobTitle = jT;
		employer = em;
		startMonth = sM;
		endMonth = eM;
		startYear = sY;
		endYear = eY;
		try{
			Class.forName(forName);
            con = DriverManager.getConnection(driverConnection);
			stmt = con.createStatement();
			String sql  = "INSERT INTO WorkR (employer,startMonth,startYear,endMonth,endYear) VALUES (?,?,?,?,?);";
			PreparedStatement p = con.prepareStatement(sql);
			p.setString(1, employer);
			p.setString(2, startMonth);
			p.setInt(3, startYear);
			p.setString(4, endMonth);
			p.setInt(5, endYear);
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
	/*public String getJobTitle(){
		return job.getJobTitle();
	}*/
	public String getEmployer(){
		return UtilityMySql.getStringMySql(forName, driverConnection, employer, "employer", table, primaryKeyName, primaryKeyID);
	}
	public String getStartMonth(){
		return UtilityMySql.getStringMySql(forName, driverConnection, startMonth, "startMonth", table, primaryKeyName, primaryKeyID);
	}
	public String getEndMonth(){
		return UtilityMySql.getStringMySql(forName, driverConnection, endMonth, "endMonth", table, primaryKeyName, primaryKeyID);
	}
	public int getStartYear(){
		return UtilityMySql.getIntMySql(forName, driverConnection, startYear, "startYear", table, primaryKeyName, primaryKeyID);
	}
	public int getEndYear(){
		return UtilityMySql.getIntMySql(forName, driverConnection, endYear, "endYear", table, primaryKeyName, primaryKeyID);
	}
	/*public void setJobTitle(String jT){
		job.setJobTitle(jT);
	}*/
	public void setEmployer(String em){
		UtilityMySql.setStringMySql(forName, driverConnection, employer, em, "employer", table, primaryKeyName, primaryKeyID);
	}
	public void setStartMonth(String sM){
		UtilityMySql.setStringMySql(forName, driverConnection, startMonth, sM, "startMonth", table, primaryKeyName, primaryKeyID);
	}
	public void setEndMonth(String eM){
		UtilityMySql.setStringMySql(forName, driverConnection, endMonth, eM, "endMonth", table, primaryKeyName, primaryKeyID);
	}
	public void setStartYear(int sY){
		UtilityMySql.setIntMySql(forName, driverConnection, startYear, sY, "startYear", table, primaryKeyName, primaryKeyID);
	}
	public void setEndYear(int eY){
		UtilityMySql.setIntMySql(forName, driverConnection, endYear, eY, "endYear", table, primaryKeyName, primaryKeyID);
	}
/*	public void addDuty(String d){
		job.addDuty(d);
	}
	public String getAt(int i){
		return job.getDutyAt(i-1);
	}
	public void clearDuties(){
		job.clearDuties();
	}
	public String toString(){
		String output = "";
		
		output += String.format("%s\n%s\n%s %s - %s %s\n", job.getJobTitle(), employer, startMonth,  startYear, endMonth, endYear);
		for(int count = 0; count < job.dutySize(); count++){
			if(count == job.dutySize()-1){
				output+=(String.format("-Duty %s, %s",count+1, job.getDutyAt(count)));
				//System.out.print("TS2x");
			}
			else{
				output+=(String.format("-Duty %s, %s\n",count+1, job.getDutyAt(count)));
				//System.out.print("TS1x");
			}
		}
		//System.out.print(output);
		return output;
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
