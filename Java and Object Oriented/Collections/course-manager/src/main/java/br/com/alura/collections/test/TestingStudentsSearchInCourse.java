package br.com.alura.collections.test;

import br.com.alura.collections.model.Course;
import br.com.alura.collections.model.Lesson;
import br.com.alura.collections.model.Student;

public class TestingStudentsSearchInCourse {

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

		System.out.println("Who is the student with registration number 429266418?");
		Student student = javaCollections.searchRegistrationNumber(429266418);
		System.out.println(student); // null

		System.out.println("Who is the student with registration number 429266419?");
		Student anotherStudent = javaCollections.searchRegistrationNumber(429266419);
		System.out.println(anotherStudent); // {Student: Asano Keigo, id: 429266419}

	}

}
