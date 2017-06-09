package haveYouSeenRoboCup;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Education edu1 = new Education("Basketball", "Masters of Arts", "Kentucky University", 2017);
		Education edu2 = new Education();
		
		System.out.println(edu1.toString());
		System.out.println(edu2.toString());
		System.out.println(edu1.getID());
		System.out.println(edu2.getID());
		edu1.setCourseOfStudy("Rap");
		System.out.println(edu1.getCourseOfStudy());
		edu1.setSchool("Duke");
		System.out.println(edu1.getSchool());
		edu2.setSchool("Harvard");
		System.out.println(edu2.getSchool());
		System.out.println(edu1.toString());
		System.out.println(edu2.toString());
		edu1.setDegree("PhD in Athletic Education");
		System.out.println(edu1.getDegree());
		edu2.setDegree("PhD in Arts Education");
		System.out.println(edu2.getDegree());
		System.out.println(edu1.toString());
		System.out.println(edu2.toString());
		edu1.setGradYear(2012);
		System.out.println(edu1.getGradYear());
		edu2.setGradYear(2012);
		System.out.println(edu2.getGradYear());
		System.out.println(edu1.toString());
		System.out.println(edu2.toString());
		
		Skill skill1 = new Skill("Java", "Excellent");
		Skill skill2 = new Skill();
		System.out.println(skill1.getID());
		System.out.println(skill2.getID());
		System.out.println(skill1.toString());
		System.out.println(skill2.toString());
		skill1.setSkillName("Basketball");
		skill2.setSkillName("Rap");
		System.out.println(skill1.getSkillName());
		System.out.println(skill2.getSkillName());
		System.out.println(skill1.toString());
		System.out.println(skill2.toString());
		skill1.setRating("Superb");
		skill2.setRating("Divine");
		System.out.println(skill1.getRating());
		System.out.println(skill2.getRating());
		System.out.println(skill1.toString());
		System.out.println(skill2.toString());
		
	}

}
