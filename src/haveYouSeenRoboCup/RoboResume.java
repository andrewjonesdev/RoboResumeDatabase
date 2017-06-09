package haveYouSeenRoboCup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class RoboResume {
//Need To create object for person that inherits education experience and skills
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean againExt = false;
		boolean againInt = false;
		boolean againDuty = false;
		//boolean againGradYear = false;
		boolean keepLooping = false;
		String yesOrNo = "";
		Scanner strScan = new Scanner(System.in);
		Scanner numScan = new Scanner(System.in);
		String nameInput = "";
		String email = "";
		ArrayList <String> resumeBullets = new ArrayList(); 
		String selection = "";
		String education = "";
		//String work = "";
		//String skill = "";
		//String rating = "";
		int countBullets = 0;
		Education eduC = new Education();
		Work workC = new Work();
		Skill skillC = new Skill();
		ArrayList <String> name = new ArrayList();
		ArrayList <String> degree = new ArrayList();
		ArrayList <String> school = new ArrayList();
		ArrayList <String> major = new ArrayList();
		ArrayList <String> jobTitle = new ArrayList();
		ArrayList <String> employer = new ArrayList();
		ArrayList <String> duty = new ArrayList();
		ArrayList <String> skill = new ArrayList();
		ArrayList <String> rating = new ArrayList();
		int startYear = 0;
		int endYear = 0;
		
		System.out.println("Welcome to Robo Resume)");
		do{
			countBullets = 0;
			do{
				System.out.println("Please enter your name)");
				String nameCheck = strScan.nextLine();
				if(!nameCheck.isEmpty()){
					keepLooping = false;
					try{
						name = capitalizeSentence(nameCheck);	
					}catch (IndexOutOfBoundsException e)
					{
						System.out.println("Your name was not recognized. Please try again)");
						keepLooping = true;
						continue;
					}
					
					//String nameInput = "";
					nameInput = name.get(0);
					if(name.size()>1){
						for(int count = 1; count < name.size(); count ++){
							nameInput += name.get(count);
						}
					}
				
				}
				else{
					System.out.println("Your name was not recognized. Please try again)");
					keepLooping = true;
				}
			}while(keepLooping);
			do{
				System.out.println("Please enter your email)");
				email = strScan.nextLine();
				if (!email.isEmpty()&&email.length()>=7&&(email.contains("@")&&(email.contains(".com")||email.contains(".gov")||email.contains(".org")||email.contains(".net")))){
				
					keepLooping = false;
				}
				else{
					System.out.println("Your email was not recognized. Please try again.");
					keepLooping = true;
				}
			}while(keepLooping);
			
			do{
				System.out.println("Select 1 to enter an Educational Achievement)\nSelect 2 to enter a Work Experience)\nSelect 3 to enter a Skill)");
				selection = strScan.nextLine();	
				do{
				if(selection.equals("1")||selection.equals("2")||selection.equals("3"))	
				{
					keepLooping = false;
					if(selection.equals("1")){
							//keepLooping = false;
							System.out.println("Enter an Educational Achievement)");
							/*do{
								System.out.println("What is the degree you have obtained?)");
								try{
											degree = capitalizeSentence(strScan.nextLine());	
								}catch (IndexOutOfBoundsException e)
								{
									System.out.println("Your degree was not recognized. Please try again)");
									keepLooping = true;
									continue;
								}
								
								String degreeInput = "";
								degreeInput = degree.get(0);
								if(degree.size()>1){
									for(int count = 1; count < degree.size(); count ++){
										degreeInput += degree.get(count);
									}
								}
								eduC.setDegree("1" + degreeInput);
								keepLooping=false;
							}while(keepLooping);*/
							educationSentenceCheck("degree", eduC, keepLooping, degree, 1, strScan);
							/*do{
								System.out.println("What School did you attend?)");
								try{
									school = capitalizeSentence(strScan.nextLine());	
								}catch (IndexOutOfBoundsException e)
								{
									System.out.println("Your school was not recognized. Please try again)");
									keepLooping = true;
									continue;
								}
										String schoolInput = "";
								schoolInput = school.get(0);
								if(school.size()>1){
									for(int count = 1; count < school.size(); count ++){
										schoolInput += school.get(count);
									}
								}
							keepLooping=false;
							eduC.setSchool(schoolInput);
							}
							while(keepLooping);*/
							educationSentenceCheck("school", eduC, keepLooping, school, 2, strScan);
							/*do{
								System.out.println("What was your major?)");
								try{
									major = capitalizeSentence(strScan.nextLine());	
								}catch (IndexOutOfBoundsException e)
								{
									System.out.println("Your major was not recognized. Please try again)");
									keepLooping = true;
									continue;
								}
								
								String majorInput = "";
								majorInput = major.get(0);
								if(major.size()>1){
									for(int count = 1; count < major.size(); count ++){
										majorInput += major.get(count);
									}
								}
								keepLooping = false;
								eduC.setCourseOfStudy(majorInput);
							}
							while(keepLooping);*/
							educationSentenceCheck("major", eduC, keepLooping, major, 3, strScan);
							int gradYear = 0;
							do{
							System.out.println("What year did you graduate?)");
							//checks if letters are input
								if (numScan.hasNextInt()){
									gradYear = numScan.nextInt();
									keepLooping = false;
									//checks if the user has given a date that hasn't occured yet
		
									//checks if date is real or not. B.C. is not accepted
									if(gradYear<0 || (Integer.toString(gradYear )).length()!=4){
										System.out.println("The year you entered wasn't valid. Please try again.");	
										keepLooping = true;
									}

								}else{
									System.out.println("You didn't submit a whole number. Please try again.");
									numScan.next();
									keepLooping = true;
									continue;
								}
							}while(keepLooping);
							eduC.setGradYear(gradYear);
							resumeBullets.add(eduC.toString());
						}
					else if(selection.equals("2")){
						//keepLooping = false;
						System.out.println("Enter a Work Experience)");
						/*do{
							System.out.println("What is/was your job title during this experience?)");
							try{
								jobTitle = capitalizeSentence(strScan.nextLine());	
							}catch (IndexOutOfBoundsException e)
							{
								System.out.println("Your job title was not recognized. Please try again)");
								keepLooping = true;
								continue;
							}
									String jobTitleInput = "";
							jobTitleInput = jobTitle.get(0);
							if(jobTitle.size()>1){
								for(int count = 1; count < jobTitle.size(); count ++){
									jobTitleInput += jobTitle.get(count);
								}
							}
						keepLooping=false;
						workC.setJobTitle("2"+jobTitleInput);
						}while(keepLooping);*/
						
						//System.out.print(workC.getJobTitle());
						workSentenceCheck("job title", workC, keepLooping, jobTitle, 1, strScan );
						/*do{
							System.out.println("Who is/was your employer?)");
							try{
								employer = capitalizeSentence(strScan.nextLine());	
							}catch (IndexOutOfBoundsException e)
							{
								System.out.println("Your employer was not recognized. Please try again)");
								keepLooping = true;
								continue;
							}
									String employerInput = "";
							employerInput = employer.get(0);
							if(employer.size()>1){
								for(int count = 1; count < employer.size(); count ++){
									employerInput += employer.get(count);
								}
							}
						keepLooping=false;
						workC.setEmployer(employerInput);
						}while(keepLooping);*/	
						workSentenceCheck("employer", workC, keepLooping, employer, 2, strScan );
						do{
							try{
								System.out.println("What month and year did you start [ex. June 2016]?)");
								String [] monthYear = (strScan.nextLine()).split(" ");
								workC.setStartMonth(capitalizeWord(monthYear[0]));
								startYear = Integer.parseInt(monthYear[1]);
								if(monthYear[1].length()!=4){
									System.out.println("Invalid Year)");
									keepLooping = true;
									continue;
								}
								workC.setStartYear((Integer.parseInt(monthYear[1])));
								System.out.println("What month and year did you end [ex. June 2016]?)");
								monthYear = (strScan.nextLine()).split(" ");
								workC.setEndMonth(capitalizeWord(monthYear[0]));
								endYear = Integer.parseInt(monthYear[1]);
								if(monthYear[1].length()!=4){
									System.out.println("Invalid Year)");
									keepLooping = true;
									continue;
								}
								workC.setEndYear((Integer.parseInt(monthYear[1])));
							}catch(IndexOutOfBoundsException | NumberFormatException e){
								System.out.println("Month and Year not recognized. Please try again)");
								keepLooping = true;
								continue;
							}
							if(startYear>endYear){
								System.out.println("End year should be greater than start year. Please try again)");
								keepLooping = true;
								continue;
							}
							else{
								keepLooping = false;
							}
						}
						while(keepLooping);
						System.out.println("What were your duties?)");
						workC.clearDuties();
						do{	
							/*do{
								System.out.println("Enter a duty)");
								try{
									duty = capitalizeSentence(strScan.nextLine());	
								}catch (IndexOutOfBoundsException e)
								{
									System.out.println("Your duty was not recognized. Please try again)");
									keepLooping = true;
									continue;
								}
										String dutyInput = "";
								dutyInput = duty.get(0);
								if(duty.size()>1){
									for(int count = 1; count < duty.size(); count ++){
										dutyInput += duty.get(count);
									}
								}
							keepLooping=false;
							workC.addDuty(dutyInput);
						}while(keepLooping);*/
							workSentenceCheck("duty", workC, keepLooping, duty, 3, strScan);
						System.out.print("You can enter another duty. ");
						}while(letsGoAgain(yesOrNo, againDuty, strScan));
						resumeBullets.add(workC.toString());
					}
					else{
						//keepLooping = false;
						System.out.println("Enter a Skill)");
						
						/*do{
							System.out.println("Enter one of your skills)");
							try{
								skill = capitalizeSentence(strScan.nextLine());	
							}catch (IndexOutOfBoundsException e)
							{
								System.out.println("Your skill was not recognized. Please try again)");
								keepLooping = true;
								continue;
							}
									String skillInput = "";
							skillInput = skill.get(0);
							if(skill.size()>1){
								for(int count = 1; count < skill.size(); count ++){
									skillInput += skill.get(count);
								}
							}
						keepLooping=false;
						skillC.setSkillName("3"+skillInput);
						}while(keepLooping);*/
						skillSentenceCheck("skill", skillC, keepLooping, skill, 1, strScan);
						/*do{
							System.out.println("Enter a Rating for this Skill)");
							try{
								rating = capitalizeSentence(strScan.nextLine());	
							}catch (IndexOutOfBoundsException e)
							{
								System.out.println("Your rating was not recognized. Please try again)");
								keepLooping = true;
								continue;
							}
									String ratingInput = "";
							ratingInput = rating.get(0);
							if(rating.size()>1){
								for(int count = 1; count < rating.size(); count ++){
									ratingInput += rating.get(count);
								}
							}
						keepLooping=false;
						skillC.setRating(ratingInput);
						}while(keepLooping);*/
						//skill = "2"+skill+", "+rating;
						skillSentenceCheck("rating", skillC, keepLooping, rating, 2, strScan);
						resumeBullets.add(skillC.toString());
					}
				}
				else{
					System.out.println("Invalid response. Please try again.");
					//System.out.println("Select 1 to enter an Educational Achievement)\nSelect 2 to enter a Work Experience)\nSelect 3 to enter a Skill)");
					keepLooping = false;
					//numScan.next();
					continue;
				}
				}while(keepLooping);
				System.out.print("You can enter another achievement. ");
			}while(letsGoAgain(yesOrNo, againInt, strScan));
			System.out.println(resumeGenerator(nameInput, email,listSort(resumeBullets, '1', '2', '3')));
			//Where the resume print goes
			System.out.print("You can enter another resume. ");
		}while(letsGoAgain(yesOrNo, againExt, strScan));
		strScan.close();
		numScan.close();
	}
	public static String resumeGenerator(String name, String email, String[][] achievements){
		String output = "";
		String[] edWoSk = {"Education:\n", "Work:\n", "Skills:\n"};
		output += (name +"\n");
		output += (email +"\n");
		
		for (int countExt = 0; countExt < achievements.length; countExt++){
			output+=("\n"+edWoSk[countExt]+"\n");
			for(int countInt = 0; countInt < achievements[0].length; countInt++){
				if(achievements[countExt][countInt].isEmpty()){
					countInt = achievements[0].length;
					//System.out.print("RB2");
				}
				/*else if (countInt==achievements[countExt].length-1||achievements[countExt][countInt+1].isEmpty()==true){
					output += (achievements[countExt][countInt].substring(1));
				}*/
				else{
					output += (achievements[countExt][countInt]+"\n");
					//System.out.print("RB");
				}
			}
			
		}
		
		
		return output;
	}
	public static  String[][] listSort (ArrayList <String> myList, char delim1, char delim2, char delim3){
		String[][] outputList = new String [3][20];
		for (String[] row: outputList){
			Arrays.fill(row, "");
		}
		int count1 = 0;
		int count2 = 0;
		int count3 = 0;
			for (int countExt = 0; countExt<myList.size(); countExt++){
				if(Character.toString(delim1).equals(myList.get(countExt).substring(0,1))){
				outputList[0][count1] = (myList.get(countExt)).substring(1);
				count1++;
				}
				else if(Character.toString(delim2).equals(myList.get(countExt).substring(0,1))){
					outputList[1][count2] = (myList.get(countExt)).substring(1);
					count2++;
					//System.out.print("LS");
					}
				else if(Character.toString(delim3).equals(myList.get(countExt).substring(0,1))){
					outputList[2][count3] = (myList.get(countExt)).substring(1);
					count3++;
					}
			}
			
		
		return outputList;
	}
	
	public static boolean letsGoAgain(String yesOrNo, boolean again, Scanner strScan){
		do{
			System.out.println("Do you want to continue? Y or N");
			yesOrNo = strScan.nextLine();
			//in case the user types "y" or "n" it will still go through
			yesOrNo = yesOrNo.toUpperCase();
			if(yesOrNo.equals("Y")){
				again = true;
			}
			else if(yesOrNo.equals("N")){
				again = false;
			}
			else{
				System.out.println("You didn't type \"Y\" or \"N\". please try again");
			}
			
		}while((!(yesOrNo.equals("Y"))) && (!(yesOrNo.equals("N"))));
		
		return again;
	}
	
	public static ArrayList <String> capitalizeSentence(String split){
		String [] postSplit = split.split(" ");
		ArrayList <String> output = new ArrayList();
		if(postSplit.length>1){
			for(int count = 0; count < postSplit.length; count++){
				if(count==postSplit.length-1){
					output.add(capitalizeWord(postSplit[count]));
				}
				else{
					output.add(capitalizeWord(postSplit[count]) + " ");
				}
			}
		}
		else{
			output.add(capitalizeWord(postSplit[0]));
		}
		return output;
	}
	public static String capitalizeWord(String word){
		return ((word.substring(0, 1)).toUpperCase() + (word.substring(1)).toLowerCase());
	}

	
	public static void workSentenceCheck(String type, Work workC, boolean keepLooping, ArrayList <String> list, int whichVar, Scanner strScan ){
		do{
			
			switch (whichVar){
			case 1:
				System.out.println(String.format("What is/was your %s?)", type));
				break;
			case 2:
				System.out.println(String.format("Who is/was your %s?)", type));
				break;
			case 3:
				System.out.println(String.format("Enter %s?)", type));
		}
			try{
				list = capitalizeSentence(strScan.nextLine());	
			}catch (IndexOutOfBoundsException e)
			{
				System.out.println(String.format("Your %s was not recognized. Please try again)", type));
				keepLooping = true;
				continue;
			}
					String input = "";
			input =list.get(0);
			if(list.size()>1){
				for(int count = 1; count < list.size(); count ++){
					input += list.get(count);
				}
			}
			keepLooping=false;
			switch (whichVar){
				case 1:
					workC.setJobTitle("2" + (input));
					break;
				case 2:
					workC.setEmployer(input);
					break;
			}
		}while(keepLooping);	
	}
	
	public static void educationSentenceCheck(String type, Education eduC, boolean keepLooping, ArrayList <String> list, int whichVar, Scanner strScan ){
		do{
			switch (whichVar){
			case 1:
				System.out.println(String.format("What is the %s you have obtained?)", type));
				break;
			case 2:
				System.out.println(String.format("What %s did you attend?)", type));
				break;
			case 3:
				System.out.println(String.format("What was your %s?)", type));
		}

			try{
				list = capitalizeSentence(strScan.nextLine());	
			}catch (IndexOutOfBoundsException e)
			{
				System.out.println(String.format("Your %s was not recognized. Please try again)", type));
				keepLooping = true;
				continue;
			}
					String input = "";
			input =list.get(0);
			if(list.size()>1){
				for(int count = 1; count < list.size(); count ++){
					input += list.get(count);
				}
			}
			keepLooping=false;
			switch (whichVar){
				case 1:
					eduC.setDegree("1" + (input));
					break;
				case 2:
					eduC.setSchool(input);
					break;
				case 3:
					eduC.setCourseOfStudy(input);
			}
		}while(keepLooping);	
	}
	public static void skillSentenceCheck(String type, Skill skillC, boolean keepLooping, ArrayList <String> list, int whichVar, Scanner strScan ){
		do{
			switch (whichVar){
			case 1:
				System.out.println(String.format("Enter a %s)", type));
				break;
			case 2:
				System.out.println(String.format("Enter a Rating for this %s)", type));
				break;
		}

			try{
				list = capitalizeSentence(strScan.nextLine());	
			}catch (IndexOutOfBoundsException e)
			{
				System.out.println(String.format("Your %s was not recognized. Please try again)", type));
				keepLooping = true;
				continue;
			}
					String input = "";
			input =list.get(0);
			if(list.size()>1){
				for(int count = 1; count < list.size(); count ++){
					input += list.get(count);
				}
			}
			keepLooping=false;
			switch (whichVar){
				case 1:
					skillC.setSkillName("3" + (input));
					break;
				case 2:
					skillC.setRating(input);
					break;
			}
		}while(keepLooping);	
	}
}

