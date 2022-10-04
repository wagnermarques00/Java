package br.com.alura.collections.test;

import br.com.alura.collections.model.Course;
import br.com.alura.collections.model.Lesson;

public class TestingCourses {

	public static void main(String[] args) {
		Course javaCollections = new Course("Mastering Java Collections", "Byakuya Kuchiki");
		System.out.println("-> Result before adding lessons");
		System.out.println(javaCollections.getLessons()); // []

		System.out.println("-> Adding one lesson");
		javaCollections.add(new Lesson("Working with ArrayLists", 21));
		System.out.println(javaCollections.getLessons()); // [{Lesson: Working with ArrayLists, 21 minutes}]

		System.out.println("-> Adding two more lessons");
		javaCollections.add(new Lesson("Creating a lesson", 20));
		javaCollections.add(new Lesson("Modeling with collections", 22));
		System.out.println(javaCollections.getLessons()); // [{Lesson: Working with ArrayLists, 21 minutes}, {Lesson: Creating a lesson, 20 minutes}, {Lesson: Modeling with collections, 22 minutes}]





	}

}
