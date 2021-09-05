package lambdacourse;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class FunctionalProgramming04Dt {

	public static void main(String[] args) {
		
		List<Integer> l = new ArrayList<Integer>();
        l.add(12);
        l.add(9);
        l.add(13);
        l.add(4);
        l.add(9);
        l.add(2);
        l.add(4);
        l.add(12);
        l.add(15);
        
        getSumOfAllElements(l);
        
        getSumOfIntFrom7To100A();
        
        getSumOfIntFrom7To100B();
        
        getSumOfIntFromXToY(-24, 1000);//500200
        
        getMultiplicationOfIntFromXToY(2, 11);//2*3*4*5...*11=39916800
        
        calcFactorial(5);//If you use more than 12 it gives ArithmeticException: integer overflow because the result is 
                         //greater than the maximum value of integer
        
        getSumOfEvensInTheGivenRange(2, 8); //2+4+6+8 = 20 ==> Fast is slow and slow is fast in IT
        
        getSumOfDigitsInTheGivenRange(23, 27);//5+6+7+8+9=35

	}
	
    //1)Create a method to find the sum of all elements in the list
	public static void getSumOfAllElements(List<Integer> l) {
		//In functional programming some methods like reduce() must be the last method, that kind of methods are called "terminal methods"
		Integer sum = l.stream().reduce(0, Math::addExact);		
		System.out.println(sum);		
	}
	
	//2)Create a method to find the sum of integers from 7 to 100
	//1.Way:
	public static void getSumOfIntFrom7To100A() {
		
		Integer sum = IntStream.range(7, 101).reduce(0, Math::addExact);
		
		System.out.println(sum);
		
	}
	
	//2.Way:
	public static void getSumOfIntFrom7To100B() {
		
		Integer sum = IntStream.rangeClosed(7, 100).reduce(0, Math::addExact);
		
		System.out.println(sum);
		
	}
	
	//3.Way:
	public static void getSumOfIntFromXToY(int x, int y) {
		
		Integer sum = IntStream.rangeClosed(x, y).reduce(0, Math::addExact);
		
		System.out.println(sum);	
		
	}
	
	//3)Create a method to find the multiplication of the integers from 2(inclusive) to 11(inclusive)
	public static void getMultiplicationOfIntFromXToY(int x, int y) {
		
		Integer prod = IntStream.rangeClosed(x, y).reduce(1, Math::multiplyExact);
		
		System.out.println(prod);
		
	}
	
	//4)Create a method to calculate the factorial of a given number.(5 factorial = 1*2*3*4*5  ==> 5! = 1*2*3*4*5)
	public static void calcFactorial(int x) {
		
		Integer factorial = IntStream.rangeClosed(1, x).reduce(1, Math::multiplyExact);
		
		System.out.println(factorial);
		
	}
	
	//5)Create a method to calculate the sum of even integers between given two integers
	public static void getSumOfEvensInTheGivenRange(int x, int y) {
		
		Integer sum = IntStream.rangeClosed(x, y).filter(Utils::checkToBeEven).reduce(0, Math::addExact);
		
		System.out.println(sum);
		
	}

	//6)Create a method to calculate the sum of digits of every integers between given two integers
	//  23 and 27 ---->  24==>6, 25==>7, 26==>8    ----> 6 + 7 + 8 = 21 
	public static void getSumOfDigitsInTheGivenRange(int x, int y) {
		
		//Instead of "reduce(0, Math::addExact)" you can use sum()
		Integer sumOfDigits = IntStream.rangeClosed(x, y).map(Utils::getSumOfDigits).sum();
		
		System.out.println(sumOfDigits);
		
	}

}