package br.com.alura.java8.test;

import br.com.alura.java8.model.Course;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CourseExample {

	public static void main(String[] args) {
		List<Course> courses = new ArrayList<Course>();
		courses.add(new Course("Python", 45));
		courses.add(new Course("JavaScript", 150));
		courses.add(new Course("Java 8", 113));
		courses.add(new Course("C", 55));

		System.out.println("-> Sort by number of Students using lambda functions");
		courses.sort(Comparator.comparing(course -> course.getStudents()));
		courses.forEach(string -> System.out.println(string.getName()));
		/*
		 * Python
		 * C
		 * Java 8
		 * JavaScript
		 */

		System.out.println("-> Sort by course name using method references");
		courses.sort(Comparator.comparing(Course::getName));
		courses.forEach(string -> System.out.println(string.getName())); // You cant use method references in this case
		/*
		 * C
		 * Java 8
		 * JavaScript
		 * Python
		 */

		System.out.println("-> Filtering courses with more than 100 students(Showing names)");
		courses.stream()
				.filter(course -> course.getStudents() >= 100)
				.forEach(course -> System.out.println(course.getName()));
		/*
		 * Java 8
		 * JavaScript
		 */

		System.out.println("-> Filtering courses with more than 100 students(Showing number of students)");
		courses.stream()
				.filter(course -> course.getStudents() >= 100)
				.map(Course::getStudents)
				.forEach(System.out::println);
		/*
		 * 113
		 * 150
		 */

		System.out.println("-> Totaling the courses with more than 100 students");
		Integer totalStudents = courses.stream()
				.filter(course -> course.getStudents() >= 100)
				.mapToInt(Course::getStudents)
				.sum();
		System.out.println(totalStudents); // 263

	}

}
