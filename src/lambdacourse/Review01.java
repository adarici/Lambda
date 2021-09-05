package lambdacourse;

import java.util.ArrayList;
import java.util.List;

public class Review01 {

	public static void main(String[] args) {
		List<Integer> l = new ArrayList<Integer>();
        l.add(12);
        l.add(9);
        l.add(131);
        l.add(14);
        l.add(9);
        l.add(10);
        l.add(4);
        l.add(12);
        l.add(15);
        listElements(l);
        System.out.println();
        listElementsEven(l);
        System.out.println();
        listOfEvenElementsFunctional( l);
        System.out.println();
        squareOfOddListElements( l);
        System.out.println();
        squareOfOddListElementsFunctional(l);
        System.out.println();
        cubeOfDistinctOddListElements(l);
        System.out.println();
        theSumOfTheSquaresOfDistinctEvenElements(l);
	}
	   /*
	    1)Create a method to print the list elements on the console
	    in the same line with a space between two consecutive elements.
	    (Structured)
	    */
	public static void listElements(List<Integer> list) {
		for (Integer w : list) {
			System.out.print(w+" ");
		}}
	/*
	 2)Create a method to print the even list elements on the console 
	 in the same line with a space between two consecutive elements.
	 (Structured)
	 */
	public static void listElementsEven(List<Integer> l) {
		for (Integer w : l) {
			if(w%2==0) {
				System.out.print(w+" ");
			}
		}
	}
	/*
	 *2)Create a method to print the even list elements on the console
	  in the same line with a space between two consecutive elements.
	  (Functional)
	 */
	public static void listOfEvenElementsFunctional(List<Integer> l) {
		l.stream().
		filter(t->t%2==0).
		forEach(t->System.out.printf( t + " "));
	}
	  /*
	3)Create a method to print the square of odd list elements on the 
		console in the same line with a space between 
		two consecutive elements.
	     */
	public static void squareOfOddListElements(List<Integer> l) {
		for (Integer w : l) {
			if(w%2!=0) {
				System.out.print(w*w+" ");
			}
		}
	}
	  /*
		3)Create a method to print the square of odd list elements on the 
			console in the same line with a space between 
			two consecutive elements. (Functional)
		     */
	//map() is used to change the value of elements
	public static void squareOfOddListElementsFunctional(List<Integer> l) {
		l.stream().
		filter(t->t%2!=0).
		map(t->t*t).
		forEach(t->System.out.print(t+" "));
	}
	/*
	 4)Create a method to print the cube of distinct odd list elements 
	 	on the console in the same line with a space 
	 	between two consecutive elements.
	 */
	public static void cubeOfDistinctOddListElements(List<Integer>l) {
		l.stream().
		distinct().
		filter(t->t%2!=0).
		map(t->t*t*t).
		forEach(t->System.out.print(t+" "));
	}
/*
 *5)Create a method to calculate the sum of the squares of distinct 
 *even elements
 */
	public static void theSumOfTheSquaresOfDistinctEvenElements(List<Integer>l) {
	Integer sum = l.
	stream().
	distinct().
	filter(t->t%2==0).
	map(t->t*t).
	reduce(0,(t ,u)->t+u);
	System.out.println(sum);
	}
}