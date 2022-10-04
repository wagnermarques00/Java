package br.com.alura.collections.model;

public class Lesson implements Comparable<Lesson>{
	private final String lessonTitle;
	private final Integer lessonTimeInMinutes;

	public Lesson(String lessonTitle, Integer lessonTimeInMinutes) {
		this.lessonTitle = lessonTitle;
		this.lessonTimeInMinutes = lessonTimeInMinutes;
	}

	public String getLessonTitle() {
		return lessonTitle;
	}

	public Integer getLessonTimeInMinutes() {
		return lessonTimeInMinutes;
	}

	@Override
	public String toString() {
		return "{Lesson: " + lessonTitle + ", " + lessonTimeInMinutes + " minutes}";
	}

	@Override
	public int compareTo(Lesson anotherLesson) {
		return this.lessonTitle.compareTo(anotherLesson.lessonTitle);
	}
}
