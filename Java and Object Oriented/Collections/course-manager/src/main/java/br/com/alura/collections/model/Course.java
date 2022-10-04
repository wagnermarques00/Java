package br.com.alura.collections.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Course {
	private final String name;
	private final String instructor;
	private final List<Lesson> lessons = new ArrayList<>();

	public Course(String name, String instructor) {
		this.name = name;
		this.instructor = instructor;
	}

	public void add(Lesson lesson) {
		this.lessons.add(lesson);
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

	@Override
	public String toString() {
		return "{Course: " + name + ", " + instructor + ", total time: " + this.getTotalTimeInMinutes() + " minutes, Lessons: " + this.lessons + "}";
	}

	public int getTotalTimeInMinutes() {
		return this.lessons.stream().mapToInt(Lesson::getLessonTimeInMinutes).sum();
	}
}
