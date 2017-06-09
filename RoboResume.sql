create schema roboResume;
use roboResume;
 
create table EducationR
(
	eduCourse varchar (255),
    eduDegree varChar (255),
    eduSchool varChar (255),
	eduGradYear integer,
    eduResume integer,
    eduID integer auto_increment,
    primary key (eduID)
);

create table WorkR
(
	job integer,
    employer varChar (255),
    startMonth varChar (255),
	startYear integer,
    endMonth varChar (255),
	endYear integer,
    workResume integer,
    workID integer auto_increment,
    primary key (workID)
);

create table JobR
(
    jobTitle varChar (255),
	jobWork integer,
    jobID integer auto_increment,
    primary key (jobID)
);

create table DutyR
(
    dutyTitle varChar (255),
    dutyJob integer,
    dutyID integer auto_increment,
    primary key (dutyID)
);

create table SkillR
(
    skillName varChar (255),
    skillRating varChar (255),
	skillResume integer,
    skillID integer auto_increment,
    primary key (skillID)
);

create table ResumeR
(
	resumeFirst varchar (255),
    resumeLast varChar (255),
    resumeEmail varChar (255),
    resumeID integer auto_increment,
    primary key (resumeID)
);

SELECT WorkR.workID, JobR.jobWork
FROM WorkR
INNER JOIN JobR ON WorkR.workID = JobR.jobWork;

SELECT JobR.jobID = DutyR.dutyJob
FROM JobR
INNER JOIN DutyR ON JobR.jobID = DutyR.dutyJob;

SELECT ResumeR.resumeID = EducationR.eduResume
FROM ResumeR
INNER JOIN EducationR ON ResumeR.resumeID = EducationR.eduResume;

SELECT ResumeR.ResumeID = WorkR.workResume
FROM ResumeR
INNER JOIN WorkR ON ResumeR.ResumeID = WorkR.workResume;

SELECT ResumeR.resumeID = SkillR.skillResume
FROM ResumeR
INNER JOIN SkillR ON ResumeR.resumeID = SkillR.skillResume;

show create table EducationR;
show create table WorkR;
show create table JobR;
show create table DutyR; 
show create table SkillR; 
show create table ResumeR; 
select* from EducationR;
select* from WorkR;
select* from JobR;
select* from DutyR;
select* from SkillR;
select* from ResumeR;
describe EducationR;
describe WorkR;
describe JobR;
describe DutyR; 
describe SkillR;
describe ResumeR;