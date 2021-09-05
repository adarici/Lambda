package lambdacourse;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FunctionalProgramming05Dt {

	public static void main(String[] args) {
		
		Course courseTurkishDay = new Course("Summer", "Turkish Day", 97, 128);
		Course courseTurkishNight = new Course("Winter", "Turkish Night", 98, 154);
		Course courseEnglishDay = new Course("Spring", "English Day", 95, 132);
		Course courseEnglishNight = new Course("Winter", "English Night", 93, 144);
		
		List<Course> coursesList = new ArrayList<>();
		coursesList.add(courseTurkishDay);
		coursesList.add(courseTurkishNight);
		coursesList.add(courseEnglishDay);
		coursesList.add(courseEnglishNight);
		
		System.out.println(checkAvgScore(coursesList, 91));//true
		
		System.out.println(checkCourseName(coursesList, "Turkish"));//true
		
		System.out.println(getCourseWhoseAvgScoreIsHighest(coursesList));
		
		System.out.println(sortInAscSkipSome(coursesList, 2));
		
		System.out.println(sortInAscSkipSomeGetSome(coursesList, 1, 2));//ED 95 and TD 97

	}
	
    //1)Create a method to check if all average scores are greater than 91
	public static boolean checkAvgScore(List<Course> coursesList, int x) {
		
		boolean result = coursesList.stream().allMatch(t->t.getAverageScore()>x);
		
		return result;
		
	}
	
    //2)Create a method to check if at least one of the course names contains "Turkish" word
	public static boolean checkCourseName(List<Course> coursesList, String str) {
		
		return coursesList.stream().anyMatch(t->t.getCourseName().contains(str));
		
	}
	
    //3)Create a method to print the course whose average score is the highest
	public static Course getCourseWhoseAvgScoreIsHighest(List<Course> coursesList) {
		
		return coursesList.stream().sorted(Comparator.comparing(Course::getAverageScore).reversed()).findFirst().get();
		
	}
	
    //4)Sort the list elements according to the average score in ascending order and skip first 2 elements
	public static List<Course> sortInAscSkipSome(List<Course> coursesList, int skipNum){
		
		return coursesList.stream().sorted(Comparator.comparing(Course::getAverageScore)).skip(skipNum).collect(Collectors.toList());
		
	}
	
	//5)Sort the list elements according to the average score in ascending order and print just 3rd one
	public static List<Course> sortInAscSkipSomeGetSome(List<Course> coursesList, int skipNum, int limitNum){
		
		return coursesList.stream().sorted(Comparator.comparing(Course::getAverageScore)).skip(skipNum).limit(limitNum).collect(Collectors.toList());
		
	}

}