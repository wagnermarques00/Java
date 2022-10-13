package br.com.alura.java8.test;

import br.com.alura.java8.model.Course;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class CourseExample {

	public static void main(String[] args) {
		List<Course> courses = new ArrayList<>();
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

		System.out.println("-> Finding a course that has more than 100 students");
		courses.stream()
				.filter(course -> course.getStudents() >= 100)
				.findAny()
				.ifPresent(course -> System.out.println(course.getName())); // Java 8

		System.out.println("-> Finding the average number of students enrolled");
		OptionalDouble averageStudents = courses.stream()
				.mapToInt(Course::getStudents)
				.average();
		averageStudents.ifPresent(a -> System.out.println(averageStudents.getAsDouble())); // 90.75

		System.out.println("-> Collecting all courses with more than 100 students in a list");
		List<Course> coursesWithMoreThan100StudentsList = courses.stream()
				.filter(course -> course.getStudents() >= 100)
				.collect(Collectors.toList());
		coursesWithMoreThan100StudentsList.forEach(course -> System.out.println(course.getName()));
		/*
		 * Java 8
		 * JavaScript
		 */

		System.out.println("-> Collecting all courses with more than 100 students in a map");
		Map<String, Integer> coursesWithMoreThan100StudentsMap = courses.stream()
				.filter(course -> course.getStudents() >= 100)
				.collect(Collectors.toMap(Course::getName, Course::getStudents));
		System.out.println(coursesWithMoreThan100StudentsMap); // {JavaScript=150, Java 8=113}

		System.out.println("-> Same as above, but in a parallelStream(Multithreading) with a forEach to print");
		courses.parallelStream()
				.filter(student -> student.getStudents() >= 100)
				.collect(Collectors.toMap(Course::getName, Course::getStudents))
				.forEach((name, studentsNumber) -> System.out.println(name + " has " + studentsNumber + " students!"));
		/*
		 * JavaScript has 150 students!
		 * Java 8 has 113 students!
		 */

	}

}
