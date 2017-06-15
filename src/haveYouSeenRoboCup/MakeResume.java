package haveYouSeenRoboCup;

import java.util.ArrayList;

public abstract class MakeResume {
	/*public static void main (String[] args){
		String firstName = "Andrew";
		String lastName = "Jones";
		String email = "sample@email.com";
		Resume resume = new Resume (firstName, lastName, email);
		
		ArrayList <Education> eduList = new ArrayList();
		String courseOfStudy = "Software Engineering";
		String degree = "Bachelors of Applied Science";
		String school = "Arizona State University";
		int gradYear = 2016;
		Education education = new Education (courseOfStudy, degree, school, gradYear, resume);
		eduList.add(education);
		
		ArrayList <Work> workList = new ArrayList();
		String jobTitle = "Coder";
		String employer = "Google";
		String startMonth = "May";
		String endMonth = "December";
		int startYear = 2016;
		int endYear = 2017;
		Work work = new Work (jobTitle,employer, startMonth, endMonth, startYear, endYear, resume);
		workList.add(work);
		
		ArrayList <Duty> dutyList = new ArrayList();
		String dutyTitle = "Computer Programming";
		Duty duty = new Duty (dutyTitle, work);
		dutyList.add(duty);
		
		ArrayList <Skill> skillList = new ArrayList();
		String skillName = "Java";
		String rating = "Godlike";
		Skill skill = new Skill (skillName, rating, resume);
		skillList.add(skill);
		
		//ArrayList <Education> eduList = new ArrayList();
		String courseOfStudy2 = "Software Engineering2";
		String degre2 = "Bachelors of Applied Science2";
		String school2 = "Arizona State University2";
		int gradYear2 = 2016;
		Education education2 = new Education (courseOfStudy, degree, school, gradYear, resume);
		eduList.add(education);
		
		//ArrayList <Work> workList = new ArrayList();
		String jobTitle2 = "Coder2";
		String employer2 = "Google2";
		String startMonth2 = "May2";
		String endMonth2 = "December2";
		int startYear2 = 2016;
		int endYear2 = 2017;
		Work work2 = new Work (jobTitle2,employer2, startMonth2, endMonth2, startYear2, endYear2, resume);
		workList.add(work2);
		
		//ArrayList <Duty> dutyList = new ArrayList();
		String dutyTitle2 = "Computer Programming2";
		Duty duty2 = new Duty (dutyTitle2, work2);
		dutyList.add(duty);
		
		//ArrayList <Skill> skillList = new ArrayList();
		String skillName2 = "Java2";
		String rating2 = "Godlike2";
		Skill skill2 = new Skill (skillName2, rating2, resume);
		skillList.add(skill2);
		
		String output = "";
		output += (resume.getfirstName()+" "+resume.getLastName() +"\n");
		output += (resume.getEmail() +"\n");
		output += "\nEducation:\n\n";
		for(int countEdu = 0; countEdu < eduList.size(); countEdu++){
			if(eduList.get(countEdu).getResume().getID()==resume.getID()){
				output+=String.format("%s in %s\n%s, %s\n", eduList.get(countEdu).getDegree(), eduList.get(countEdu).getCourseOfStudy(), eduList.get(countEdu).getSchool(), eduList.get(countEdu).getGradYear());
			}
		}
		output += "\nWork:\n\n";
		int dutyNum=0;
		for(int countWork = 0; countWork < workList.size(); countWork++){
			if(workList.get(countWork).getResume().getID()==resume.getID()){
				for(int countDuty = 0; countDuty < dutyList.size(); countDuty++){
					output += String.format("%s\n%s\n%s %s - %s %s\n", workList.get(countWork).getJobTitle(), workList.get(countWork).getEmployer(), workList.get(countWork).getStartMonth(),  workList.get(countWork).getStartYear(), workList.get(countWork).getEndMonth(), workList.get(countWork).getEndYear());
					if(dutyList.get(countDuty).getWork().getID()==workList.get(countWork).getID()){
						output+=String.format("-Duty %s, %s\n",dutyNum+1, dutyList.get(countDuty).getdutyTitle());
								dutyNum++;
					}
				}
			}
		}
		output += "\nSkill:\n\n";
		for(int countSkill = 0; countSkill < skillList.size(); countSkill++){
			if(skillList.get(countSkill).getResume().getID()==resume.getID()){
				output+=String.format("%s, %s\n", skillList.get(countSkill).getSkillName(), skillList.get(countSkill).getRating());
			}
		}
		System.out.println(output);
	}*/
	public static String generateResume(Resume resume, ArrayList <Education> eduList, ArrayList <Work> workList, ArrayList <Duty> dutyList, ArrayList <Skill> skillList){
		String output = "";
		output += (resume.getfirstName()+" "+resume.getLastName() +"\n");
		output += (resume.getEmail() +"\n");
		output += "\nEducation:\n\n";
		for(int countEdu = 0; countEdu < eduList.size(); countEdu++){
			if(eduList.get(countEdu).getResume().getID()==resume.getID()){
				output+=String.format("%s in %s\n%s, %s\n", eduList.get(countEdu).getDegree(), eduList.get(countEdu).getCourseOfStudy(), eduList.get(countEdu).getSchool(), eduList.get(countEdu).getGradYear());
			}
		}
		output += "\nWork:\n\n";
		int dutyNum=0;
		for(int countWork = 0; countWork < workList.size(); countWork++){
			if(workList.get(countWork).getResume().getID()==resume.getID()){
				output += String.format("%s\n%s\n%s %s - %s %s\n", workList.get(countWork).getJobTitle(), workList.get(countWork).getEmployer(), workList.get(countWork).getStartMonth(),  workList.get(countWork).getStartYear(), workList.get(countWork).getEndMonth(), workList.get(countWork).getEndYear());
				for(int countDuty = 0; countDuty < dutyList.size(); countDuty++){
					if(dutyList.get(countDuty).getWork().getID()==workList.get(countWork).getID()){
						output+=String.format("-Duty %s, %s\n",dutyNum+1, dutyList.get(countDuty).getdutyTitle());
								dutyNum++;
					}
				}
				dutyNum=0;
			}
		}
		output += "\nSkill:\n\n";
		for(int countSkill = 0; countSkill < skillList.size(); countSkill++){
			if(skillList.get(countSkill).getResume().getID()==resume.getID()){
				output+=String.format("%s, %s\n", skillList.get(countSkill).getSkillName(), skillList.get(countSkill).getRating());
			}
		}
		return output;
	}
	public static String generateResumeHTML(Resume resume, ArrayList <Education> eduList, ArrayList <Work> workList, ArrayList <Duty> dutyList, ArrayList <Skill> skillList){
		String output = "";
		output += ("<div id = \"name\">"+resume.getfirstName()+" "+resume.getLastName() +"<br/></div>");
		output += ("<div id = \"email\">"+resume.getEmail() +"<br/></div>");
		output += "<div id = \"eduHead\"><br/>Education:<br/><br/></div>";
		for(int countEdu = 0; countEdu < eduList.size(); countEdu++){
			if(eduList.get(countEdu).getResume().getID()==resume.getID()){
				output+=String.format("<div class = \"education\">%s in %s<br/>%s, %s<br/></div>", eduList.get(countEdu).getDegree(), eduList.get(countEdu).getCourseOfStudy(), eduList.get(countEdu).getSchool(), eduList.get(countEdu).getGradYear());
			}
		}
		output += "<div id = \"workHead\"><br/>Work:<br/><br/></div>";
		int dutyNum=0;
		for(int countWork = 0; countWork < workList.size(); countWork++){
			if(workList.get(countWork).getResume().getID()==resume.getID()){
				output += String.format("<div class = \"work\">%s<br/>%s<br/>%s %s - %s %s<br/></div>", workList.get(countWork).getJobTitle(), workList.get(countWork).getEmployer(), workList.get(countWork).getStartMonth(),  workList.get(countWork).getStartYear(), workList.get(countWork).getEndMonth(), workList.get(countWork).getEndYear());
				for(int countDuty = 0; countDuty < dutyList.size(); countDuty++){
					if(dutyList.get(countDuty).getWork().getID()==workList.get(countWork).getID()){
						output+=String.format("<div class = \"duty\">-Duty %s, %s<br/></div>",dutyNum+1, dutyList.get(countDuty).getdutyTitle());
								dutyNum++;
					}
				}
				dutyNum=0;
			}
		}
		output += "<div id = \"skillHead\"><br/>Skill:<br/><br/></div>";
		for(int countSkill = 0; countSkill < skillList.size(); countSkill++){
			if(skillList.get(countSkill).getResume().getID()==resume.getID()){
				output+=String.format("<div class = \"skill\">%s, %s<br/></div>", skillList.get(countSkill).getSkillName(), skillList.get(countSkill).getRating());
			}
		}
		return output;
	}
	public static String generateResumeBootStrap(Resume resume, ArrayList <Education> eduList, ArrayList <Work> workList, ArrayList <Duty> dutyList, ArrayList <Skill> skillList){
		String output = "";
		output+="  <div class=\"wrapper\">"
		       +" <div class=\"sidebar-wrapper\">"
	           +"<div class=\"profile-container\">"
	           +"<img class=\"profile\" src=\"assets/images/profile.png\" alt=\"\" />";
		output += ("<h1 class=\"name\">"+resume.getfirstName()+" "+resume.getLastName() +"</h1></div>");
	    output+="<div class=\"contact-container container-block\">"
	               +"<ul class=\"list-unstyled contact-list\">";
	    output+="<li class=\"email\"><i class=\"fa fa-envelope\"></i><a href=\"mailto: "+resume.getEmail() +"\">"+resume.getEmail()+"</a></li></ul></div>";
	    
	    output+="";
		output += "<div class=\"education-container container-block\">"
               +"<h2 class=\"container-block-title\">Education:</h2>";
		for(int countEdu = 0; countEdu < eduList.size(); countEdu++){
			if(eduList.get(countEdu).getResume().getID()==resume.getID()){
				output+=String.format("<div class=\"item\"><h4 class=\"degree\">%s in %s</h4><h5 class=\"meta\">%s</h5><div class=\"time\">%s</div></div>", eduList.get(countEdu).getDegree(), eduList.get(countEdu).getCourseOfStudy(), eduList.get(countEdu).getSchool(), eduList.get(countEdu).getGradYear());
			}
		}
		output+="</div></div>";
		output+="<div class=\"main-wrapper\">"
	           +"<section class=\"section experiences-section\">"
	           +"<h2 class=\"section-title\"><i class=\"fa fa-briefcase\"></i>Experiences</h2>";
		int dutyNum=0;
		for(int countWork = 0; countWork < workList.size(); countWork++){
			if(workList.get(countWork).getResume().getID()==resume.getID()){
				output += String.format("<div class=\"item\"><div class=\"meta\"><div class=\"upper-row\"><h3 class=\"job-title\">%s</h3><div class=\"time\">%s %s - %s %s</div></div><div class=\"company\">%s</div></div>", workList.get(countWork).getJobTitle(), workList.get(countWork).getStartMonth(),  workList.get(countWork).getStartYear(), workList.get(countWork).getEndMonth(), workList.get(countWork).getEndYear(), workList.get(countWork).getEmployer());
				output+="<div class=\"details\">";
				for(int countDuty = 0; countDuty < dutyList.size(); countDuty++){
					if(dutyList.get(countDuty).getWork().getID()==workList.get(countWork).getID()){
						output+=String.format("<p>-Duty %s, %s</p>",dutyNum+1, dutyList.get(countDuty).getdutyTitle());
								dutyNum++;
					}
				}
				output+="</div></div></section>";
				dutyNum=0;
			}
		}
		output+= "<section class=\"skills-section section\">"
               +"<h2 class=\"section-title\"><i class=\"fa fa-rocket\"></i>Skills &amp; Proficiency</h2>";
		for(int countSkill = 0; countSkill < skillList.size(); countSkill++){
			if(skillList.get(countSkill).getResume().getID()==resume.getID()){
				output+=String.format("<div class=\"skillset\">                            <div class=\"item\">                        <h3 class=\"level-title\">     %s    </h3> <div class=\"details\"> <p>  %s   </p> </div>    </div>   ", skillList.get(countSkill).getSkillName(), skillList.get(countSkill).getRating());
				//output+=String.format("<div class=\"item\"><h3 class=\"level-title\">%s</h3><div class=\"level-bar\"><div class=\"level-bar-inner\" data-level=\"98%\"></div></div><div class=\"details\"><p>%s</p></div></div>", skillList.get(countSkill).getSkillName(), skillList.get(countSkill).getRating());
			}
		}
		output+="</div></section></div></div>";
		return output;
	}
}
