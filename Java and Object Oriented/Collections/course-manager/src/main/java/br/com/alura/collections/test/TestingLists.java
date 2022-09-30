package br.com.alura.collections.test;

import java.util.ArrayList;
import java.util.Collections;

public class TestingLists {

	public static void main(String[] args) {
		String lesson1 = "Deepening your knowledge of lists";
		String lesson2 = "Modeling the Lesson class";
		String lesson3 = "Working with Courses and Sets";

		ArrayList<String> lessons = new ArrayList<>();
		lessons.add(lesson1);
		lessons.add(lesson2);
		lessons.add(lesson3);

		System.out.println("-> Raw toString");
		System.out.println(lessons); // [Deepening your knowledge of lists, Modeling the Lesson class, Working with Courses and Sets]

		lessons.remove(lesson1); // -> Remove with the reference
		lessons.remove(0); // -> Remove with the position in the array. Will remove lesson2, because lesson1 was removed before
		System.out.println("-> Raw toString after removal\n" + lessons); // [Working with Courses and Sets]

		lessons.add(lesson2); // Just resetting to get back to two elements

		System.out.println("-> ForEach(manual) lesson");
		for(String lesson : lessons) {
			System.out.println("Lesson: " + lesson);
			/*
			 * Lesson: Working with Courses and Sets
			 * Lesson: Modeling the Lesson class
			 */
		}

		System.out.println("-> Assigning value through a list");
		String firstLesson = lessons.get(0); // lesson2
		System.out.println("The first lesson is: " + firstLesson);

		System.out.println("-> Using the .size() method");
		for(int i = 0; i < lessons.size(); i++) { // The size of the lessons array at this moment is 2
			System.out.println("* Lesson: " + lessons.get(i));
			/*
			 * * Lesson: Working with Courses and Sets
			 * * Lesson: Modeling the Lesson class
			 */
		}

		System.out.println("-> Using the .forEach() method");
		lessons.forEach(lesson -> {System.out.println("- " + lesson);});
		/*
		 * For better reading, we can also do it in the way below:
		 * lessons.forEach(lesson -> {
		 * 			System.out.println("- " + lesson);
		 * 	});
		 */
		/*
		 * - Lesson: Working with Courses and Sets
		 * - Lesson: Modeling the Lesson class
		 */

		System.out.println("-> Collections.sort");
		Collections.sort(lessons);
		System.out.println(lessons); // [Modeling the Lesson class, Working with Courses and Sets]
	}

}
