package br.com.alura.collections.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Course {
	private String name;
	private String instructor;
	private List<Lesson> lessons = new ArrayList<>();
	private Set<Student> students = new HashSet<>();
	private Map<Integer, Student> registrationPerStudent = new HashMap<>();

	public Course(String name, String instructor) {
		this.name = name;
		this.instructor = instructor;
	}

	public void add(Lesson lesson) {
		this.lessons.add(lesson);
	}

	public void enrollStudent(Student student) {
		this.students.add(student);
		this.registrationPerStudent.put(student.getRegistrationNumber(), student);
	}

	public boolean isEnrolled(Student student) {
		return this.students.contains(student);
	}

	public Student searchRegistrationNumber(int registrationNumber) {
		return registrationPerStudent.get(registrationNumber);
	}

	public String getName() {
		return name;
	}

	public String getInstructor() {
		return instructor;
	}

	public List<Lesson> getLessons() {
		return Collections.unmodifiableList(lessons); // Returns an unmodifiable view of the specified list. Read Only.
	}

	public Set<Student> getStudents() {
		return Collections.unmodifiableSet(students); // Returns an unmodifiable view of the specified list. Read Only.
	}

	@Override
	public String toString() {
		return "{Course: " + name + ", " + instructor + ", total time: " + this.calculateTotalTimeInMinutes() + " minutes, Lessons: " + this.lessons + "}";
	}

	public int calculateTotalTimeInMinutes() {
		return this.lessons.stream().mapToInt(Lesson::getLessonTimeInMinutes).sum();
	}

}
