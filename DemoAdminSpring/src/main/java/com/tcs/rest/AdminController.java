/**
 * 
 */
package com.tcs.rest;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.model.*;
import com.tcs.constant.*;

/**
 * @author Administrator
 *
 */

@RestController
public class AdminController {
	
private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	//Map to store employees, ideally we should use database
	Map<Integer, Courses> courseList = new HashMap<Integer, Courses>();
	Map<Integer, Students> studentList = new HashMap<Integer, Students>();
	Map<Integer, Professor> ProfessorList = new HashMap<Integer, Professor>();
	Map<Integer, GradeCard> gradeList = new HashMap<Integer, GradeCard>();
	
	public void putMethod3() {
		 gradeList.put(10, new GradeCard(1,"Pass"));
		 gradeList.put(11, new GradeCard(2,"Pass"));
		 gradeList.put(12, new GradeCard(3,"Pass"));
		 
		 gradeList.put(13, new GradeCard(4,"Pass"));
		 
		 
	}
	public void putMethod() {
		 courseList.put(1010, new Courses(1101));
		 courseList.put(1020, new Courses(1102));
		 courseList.put(1030, new Courses(1103));
		 courseList.put(1040, new Courses(1104));
		 
	}
	public void putMethod1() {
		 studentList.put(1011, new Students(1,"Madhuri",1101,1));
		 studentList.put(1022, new Students(2,"sri",1102,0));
		 studentList.put(1033, new Students(3,"vijayasri",1103,1));
		 studentList.put(1044, new Students(4,"Madhu",1104,0));
		 
	}
	public void putMethod2() {
	 ProfessorList.put(1013, new Professor(201));
	 ProfessorList.put(1014, new Professor(202));
	 ProfessorList.put(1015, new Professor(203));
	 ProfessorList.put(1016, new Professor(204));
}
	
	@RequestMapping(value = AdminRestURIConstants.VIEW_STUDENTS, method = RequestMethod.GET)
	public @ResponseBody List<Students> getEnrolledStudents() {
		putMethod1();
		logger.info("List of Students");
		List<Students> student = new ArrayList<Students>();
		Set<Integer> studentIds = studentList.keySet();
		for(Integer i : studentIds) {
			student.add(studentList.get(i));
		}
		return student;
	}
	@RequestMapping(value = AdminRestURIConstants.VIEW_PROFESSORS, method = RequestMethod.GET)
	public @ResponseBody List<Professor> getProfessors() {
		putMethod2();
		logger.info("List of Professors");
		List<Professor> prof = new ArrayList<Professor>();
		Set<Integer> profids = ProfessorList.keySet();
		for(Integer i : profids) {
			prof.add(ProfessorList.get(i));
		}
		return prof;
	}
	@RequestMapping(value = AdminRestURIConstants.VIEW_COURSES, method = RequestMethod.GET)
	public @ResponseBody List<Courses> getCourses() {
		putMethod();
		logger.info("List of Courses");
		List<Courses> cou = new ArrayList<Courses>();
		Set<Integer> courseids = courseList.keySet();
		for(Integer i : courseids) {
			cou.add(courseList.get(i));
		}
		return cou;
	}
	
	@RequestMapping(value = AdminRestURIConstants.ADD_COURSE, method = RequestMethod.POST)
	public @ResponseBody Courses addCourses(@RequestBody Courses cr) {
		putMethod();
		logger.info("Adding of Courses");
		Courses gc = new Courses();
		Set<Integer> courseids = courseList.keySet();
		for(int i:courseids) {
			if(courseList.get(i).getCourseId()!=cr.getCourseId()) {
				gc.setCourseId(cr.getCourseId());
			}
		}
		return gc;
	}




@RequestMapping(value = AdminRestURIConstants.ADD_PROFESSOR, method = RequestMethod.POST)
public @ResponseBody Professor addProfessors(@RequestBody Professor cr) {
	
	logger.info("Adding of Professor");
	Professor gc = new Professor();
	Set<Integer> profids = ProfessorList.keySet();
	for(int i:profids) {
		if(ProfessorList.get(i).getProfessorId()!=cr.getProfessorId()) {
			gc.setProfessorId(cr.getProfessorId());
		}
        }
	return gc;
}
@RequestMapping(value = AdminRestURIConstants.REMOVE_COURSE, method = RequestMethod.POST)
public @ResponseBody void  removeCourses(@RequestBody Courses cr) {
	logger.info("removal of Courses");
	Courses gc = new Courses();
	Set<Integer> courseids = courseList.keySet();
	for(int i:courseids) {
		if(courseList.get(i).getCourseId()==cr.getCourseId()) {
			courseids.remove(cr.getCourseId());
		}
	}
}
@RequestMapping(value = AdminRestURIConstants.GENERATE_REPORT, method = RequestMethod.GET)
public @ResponseBody List<GradeCard> generateReport() {
	putMethod3();
	logger.info("List of Students Result");
	List<GradeCard> grade = new ArrayList<GradeCard>();
	Set<Integer> gra = gradeList.keySet();
	for(Integer i : gra) {
		grade.add(gradeList.get(i));
	}
	return grade;
}
@RequestMapping(value = AdminRestURIConstants.APPROVE_STUDENT, method = RequestMethod.POST)
public @ResponseBody void  approvestudent(@RequestBody Students cr) {
	logger.info("approval of Student");
	Students gc = new Students();
	int st=1;
	Set<Integer> studentids = studentList.keySet();
	for(int i:studentids) {
		if(studentList.get(i).getStudId()==cr.getStudId()) {
			if(cr.getStatus()==0) {
				studentids.remove(cr.getStatus());
				gc.setStatus(1);
		}
			
			
		}
	}
}
}

