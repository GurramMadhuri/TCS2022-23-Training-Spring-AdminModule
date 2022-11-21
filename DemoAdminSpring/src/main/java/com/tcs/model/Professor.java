package com.tcs.model;

public class Professor {
private int ProfessorId;
public Professor() {}
public Professor(int professorId) {
	super();
	ProfessorId = professorId;
}

public int getProfessorId() {
	return ProfessorId;
}

public void setProfessorId(int professorId) {
	ProfessorId = professorId;
}

}
