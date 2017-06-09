package haveYouSeenRoboCup;

//import java.util.ArrayList;

public class Work {
	private String jobTitle = "";
	private String employer = "";
	private String startMonth = "";
	private String endMonth = "";
	private int startYear = 0;
	private int endYear = 0;
	//private ArrayList <String> duties = new ArrayList();
	private Job job = new Job(); 
	
	public Work(){
		//jobTitle = "Graphic Designer";
		jobTitle = job.getJobTitle();
		employer = "Hallmark";
		startMonth = "M.F.A.";
		endMonth = "Arizona State University";
		startYear = 2010;
		endYear = 2017;
		//job.addDuty("Design Cards");
	}
	public Work(String jT, String em, String sM, String eM, int sY, int eY){
		jobTitle = jT;
		employer = em;
		startMonth = sM;
		endMonth = eM;
		startYear = sY;
		endYear = eY;
	}
	
	public String getJobTitle(){
		return job.getJobTitle();
	}
	public String getEmployer(){
		return employer;
	}
	public String getStartMonth(){
		return startMonth;
	}
	public String getEndMonth(){
		return endMonth;
	}
	public int getStartYear(){
		return startYear;
	}
	public int getEndYear(){
		return endYear;
	}
	public void setJobTitle(String jT){
		job.setJobTitle(jT);
	}
	public void setEmployer(String em){
		employer = em;
	}
	public void setStartMonth(String sM){
		startMonth = sM;
	}
	public void setEndMonth(String eM){
		endMonth = eM;
	}
	public void setStartYear(int sY){
		startYear = sY;
	}
	public void setEndYear(int eY){
		endYear = eY;
	}
	public void addDuty(String d){
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
