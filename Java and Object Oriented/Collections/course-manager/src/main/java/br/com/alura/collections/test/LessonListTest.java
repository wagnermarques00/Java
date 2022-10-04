package br.com.alura.collections.test;

import br.com.alura.collections.model.Lesson;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class LessonListTest {

	public static void main(String[] args) {
		Lesson lesson1 = new Lesson("Revisiting ArrayLists", 21);
		Lesson lesson2 = new Lesson("Object lists", 14);
		Lesson lesson3 = new Lesson("Object list relationship", 15);

		ArrayList<Lesson> lessons = new ArrayList<>();
		lessons.add(lesson1);
		lessons.add(lesson2);
		lessons.add(lesson3);
		System.out.println(lessons); // [{Lesson: Revisiting ArrayLists, 21 minutes}, {Lesson: Object lists, 15 minutes}, {Lesson: Object list relationship, 15 minutes}]

		System.out.println("-> Collections.sort");
		Collections.sort(lessons);
		System.out.println(lessons); // [{Lesson: Object list relationship, 15 minutes}, {Lesson: Object lists, 15 minutes}, {Lesson: Revisiting ArrayLists, 21 minutes}]

		System.out.println("-> Comparing with time in Comparator");
		Collections.sort(lessons, Comparator.comparing(Lesson::getLessonTimeInMinutes)); // Same result as bellow
		lessons.sort(Comparator.comparing(Lesson::getLessonTimeInMinutes)); // Same result as above
		System.out.println(lessons); // [{Lesson: Object lists, 14 minutes}, {Lesson: Object list relationship, 15 minutes}, {Lesson: Revisiting ArrayLists, 21 minutes}]





	}

}
