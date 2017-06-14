package haveYouSeenRoboCup;

import java.util.ArrayList;

public class MakeResume {
	public static void main (String[] args){
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
	}
}
