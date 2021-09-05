package lambdacourse;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FunctionalProgramming03 {

	public static void main(String[] args) {
		
		List<String> l = new ArrayList<>();
        l.add("Ali");
        l.add("Ali");
        l.add("Mark");
        l.add("Amanda");
        l.add("Christopher");
        l.add("Jackson");
        l.add("Mariano");
        l.add("Alberto");
        l.add("Tucker");
        l.add("Benjamin");
        
        printUppercase1(l);
        System.out.println();
        printUppercase2(l);
        System.out.println();
        printSortedByLength(l);
        System.out.println();
        printDistinctSortedByLastChar(l);
        System.out.println();
        printSortedByLengthThenFirstChar(l);
        System.out.println();
        //printRemoveIfStartingAOrN(l);
        System.out.println();
        lengthSquareDistinctReversed(l);
        System.out.println();
        checkLengthToBeLessThanTwelve(l);
        System.out.println();
        checkInitials(l);
        System.out.println();
        checkLastChar(l);
		

	}

    //1) Create a method to print all list elements in uppercase
	//1.Way
	public static void printUppercase1(List<String> l) {		
		l.stream().map(String::toUpperCase).forEach(Utils::printInTheSameLineWithASpace);		
	}
	
	//2.Way:
	public static void printUppercase2(List<String> l) {		
		l.replaceAll(String::toUpperCase);
		System.out.println(l);
	}
	
    //2) Create a method to print the elements after ordering according to their lengths
	public static void printSortedByLength(List<String> l) {		
		l.stream().sorted(Comparator.comparing(String::length)).forEach(System.out::println);		
	}
	
    //3) Create a method to sort the distinct elements by using their last characters
	public static void printDistinctSortedByLastChar(List<String> l) {		
		l.stream().distinct().sorted(Comparator.comparing(t->t.charAt(t.length()-1))).forEach(System.out::println);	
	}
	
    //4) Create a method to sort the elements according to their lengths then according to their first character
	public static void printSortedByLengthThenFirstChar(List<String> l) {		
		l.stream().sorted(Comparator.comparing(String::length).thenComparing(t->t.charAt(0))).forEach(System.out::println);		
	}
	
    //5) Remove the elements if the length of the element is greater than 5
//	public static void removeIfLengthGreaterThanFive(List<String> l) {		
//		l.removeIf(t->t.length()>5);		
//		System.out.println("The length of all elements is less than 5: " + l);		
//	}
	
    //6) Remove the elements if the element is starting with 'A', 'a' or ending with 'N', 'n'
//	public static void printRemoveIfStartingAOrN(List<String> l) {
//		l.removeIf(t-> t.charAt(0) == 'A' ||  t.charAt(0) == 'a' || t.charAt(t.length()-1) == 'N' || t.charAt(t.length()-1) == 'n');
//		System.out.println("======> " + l);
//	}
	
    //7) Create a method which takes the square of the length of every element, prints them distinctly in reverse order
	public static void lengthSquareDistinctReversed(List<String> l) {	
		l.stream().map(String::length).map(Utils::getSquare).distinct().sorted(Comparator.reverseOrder()).forEach(Utils::printInTheSameLineWithASpace);		
	}
	
	//8) Create a method to check if the lengths of all elements are less than 12
	public static void checkLengthToBeLessThanTwelve(List<String> l){	
		//Returns whether all elements of this stream match the provided condition
		boolean result = l.stream().allMatch(t->t.length()<12);
		System.out.println(result);		
	}
	
	//9) Create a method to check if the initial of any element is not ‘X’
	public static void checkInitials(List<String> l){
		//Returns whether no elements of this stream match the provided condition
		boolean result = l.stream().noneMatch(t->t.startsWith("X"));
		System.out.println(result);
		
	}
	
    //10) Create a method to check if at least one of the elements ending with "R"
	public static void checkLastChar(List<String> l){
		//Returns whether any elements of this stream match the provided condition
		boolean result = l.stream().anyMatch(t->t.endsWith("R"));		
		System.out.println(result);	
	}

}