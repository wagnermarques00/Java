package br.com.alura.collections.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Course {
	private String name;
	private String instructor;
	private List<Lesson> lessons = new ArrayList<>();
	private Set<Student> students = new HashSet<>();

	public Course(String name, String instructor) {
		this.name = name;
		this.instructor = instructor;
	}

	public void add(Lesson lesson) {
		this.lessons.add(lesson);
	}

	public void enrollStudent(Student student) {
		this.students.add(student);
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
		return Collections.unmodifiableSet(students);
	}

	@Override
	public String toString() {
		return "{Course: " + name + ", " + instructor + ", total time: " + this.getTotalTimeInMinutes() + " minutes, Lessons: " + this.lessons + "}";
	}

	public int getTotalTimeInMinutes() {
		return this.lessons.stream().mapToInt(Lesson::getLessonTimeInMinutes).sum();
	}

}
