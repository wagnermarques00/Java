package br.com.alura.collections.test;

import br.com.alura.collections.model.Course;
import br.com.alura.collections.model.Lesson;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestingCourses2 {

	public static void main(String[] args) {
		Course javaCollections = new Course("Mastering Java Collections", "Byakuya Kuchiki");

		javaCollections.add(new Lesson("Working with ArrayLists", 21));
		javaCollections.add(new Lesson("Creating a lesson", 20));
		javaCollections.add(new Lesson("Modeling with collections", 22));

		List<Lesson> immutableLessons = javaCollections.getLessons();
		System.out.println("-> Lessons before sort");
		System.out.println(immutableLessons); // [{Lesson: Working with ArrayLists, 21 minutes}, {Lesson: Creating a lesson, 20 minutes}, {Lesson: Modeling with collections, 22 minutes}]

		System.out.println("-> Lesson after sort");
		List<Lesson> lessons = new ArrayList<>(immutableLessons);
		Collections.sort(lessons);
		System.out.println(lessons); // [{Lesson: Creating a lesson, 20 minutes}, {Lesson: Modeling with collections, 22 minutes}, {Lesson: Working with ArrayLists, 21 minutes}]

		System.out.println("-> Total minutes so far");
		System.out.println(javaCollections.getTotalTimeInMinutes()); // 63

		System.out.println("-> Course toString");
		System.out.println(javaCollections); // {Course: Mastering Java Collections, Byakuya Kuchiki, total time: 63 minutes, Lessons: [{Lesson: Working with ArrayLists, 21 minutes}, {Lesson: Creating a lesson, 20 minutes}, {Lesson: Modeling with collections, 22 minutes}]}
	}

}
