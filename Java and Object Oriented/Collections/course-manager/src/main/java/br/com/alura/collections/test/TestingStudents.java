package br.com.alura.collections.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class TestingStudents {

	public static void main(String[] args) {
		Collection<String> students = new HashSet<>();
		students.add("Asano Keigo");
		students.add("Asano Mizuho");
		students.add("Arisawa Tatsuki");
		students.add("Oscar Joaquín de la Rosa");
		students.add("Hanakari Jinta");
		students.add("Honshō Chizuru");
		students.add("Asano Keigo"); // will not repeat, since it is a Set

		System.out.println("-> Default set of students");
		System.out.println(students); // [Hanakari Jinta, Asano Keigo, Arisawa Tatsuki, Asano Mizuho, Oscar Joaquín de la Rosa, Honshō Chizuru]

		System.out.println("-> Size: " + students.size()); // 6

		System.out.println("-> forEach");
		students.forEach(student -> {
			System.out.println(student);
		});

		System.out.println("-> method references");
		students.forEach(System.out::println);

		System.out.println("-> Asano Mizuho is enrolled");
		boolean asanoIsEnrolled = students.contains("Asano Mizuho");
		System.out.println(asanoIsEnrolled);

		System.out.println("-> Set after removing one student");
		students.remove("Asano Keigo");
		System.out.println(students); // [Hanakari Jinta, Arisawa Tatsuki, Asano Mizuho, Oscar Joaquín de la Rosa, Honshō Chizuru]

		System.out.println("-> Putting the Set in a List and sorting the results");
		List<String> studentsOnList = new ArrayList<>(students);
		Collections.sort(studentsOnList);
		System.out.println(studentsOnList); // [Arisawa Tatsuki, Asano Mizuho, Hanakari Jinta, Honshō Chizuru, Oscar Joaquín de la Rosa]



	}

}
