package br.com.alura.collections.test;

import br.com.alura.collections.model.Course;
import br.com.alura.collections.model.Lesson;
import br.com.alura.collections.model.Student;

public class TestingCoursesWithStudents {

	public static void main(String[] args) {
		Course javaCollections = new Course("Mastering Java Collections", "Byakuya Kuchiki");

		javaCollections.add(new Lesson("Working with ArrayLists", 21));
		javaCollections.add(new Lesson("Creating a lesson", 20));
		javaCollections.add(new Lesson("Modeling with collections", 22));

		Student s1 = new Student("Asano Keigo", 429266419);
		Student s2 = new Student("Asano Mizuho", 269169922);
		Student s3 = new Student("Arisawa Tatsuki", 222055768);

		javaCollections.enrollStudent(s1);
		javaCollections.enrollStudent(s2);
		javaCollections.enrollStudent(s3);

		System.out.println("-> Showing students");
		javaCollections.getStudents().forEach( student -> System.out.println(student));
		/*
		 * {Student: Asano Mizuho, id: 269169922}
		 * {Student: Asano Keigo, id: 429266419}
		 * {Student: Arisawa Tatsuki, id: 222055768}
		 */

		
	}

}
