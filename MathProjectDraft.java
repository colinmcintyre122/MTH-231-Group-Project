import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


/**
 * Code for the math project (MTH 231). Not done yet. 
 * 
 * 
 * 
 * TODO figure out how to find the list of possible subsets. everything else is done.
 * 
 * 
 * 
 * @author Daniel Townsend
 *
 */
public class MathProjectDraft {

	public static void main(String[] args) {
		
		Scanner inputReader = new Scanner(System.in);
		
		System.out.print("Enter a value for n: ");
		int numOfElements = inputReader.nextInt(); // n
		
		System.out.print("Enter a value for k: ");
		int sizeOfSubsets = inputReader.nextInt(); // k
		inputReader.close();
		
		System.out.println(numOfElements + " choose " + sizeOfSubsets + " is "
				           + countPossibleSubsets(numOfElements, sizeOfSubsets));
		
		ArrayList<ArrayList<Integer>> listOfSubsets = new ArrayList<ArrayList<Integer>>();

		printSubsets(listOfSubsets);
	}
	
	/**
	 * Finds the factorial of an integer.
	 * 
	 * @param n the integer to find the factorial of.
	 * @return an integer holding the factorial of n.
	 */
	public static int factorial(int n) {
		if (n == 1) {
			return 1;
		} else {
			return n * factorial(n - 1);
		}
	}
	
	/**
	 * Counts the possible subsets of n choose k using the given formula.
	 * 
	 * @param n the number of elements in the "main" set.
	 * @param k the number of elements in the subsets.
	 * @return an integer which is the result of the n choose k formula.
	 */
	public static int countPossibleSubsets(int n, int k) {
		if(k == 0 || n < k) {
			return 0;
		}
		return (factorial(n)) / (factorial(k) * factorial(n - k));
	}

	// WORK IN PROGRESS
	private static void getPossibleSubsets(int n, int k, ArrayList<ArrayList<Integer>> listOfSubsets) {
		
		
		// probably need to use recursion here
		
		
		
	}
	
	/**
	 * Prints all the ArrayLists within an ArrayList formatted nicely.
	 * 
	 * @param listOfSubsets an ArrayList of Integer ArrayLists that holds all the
	 * possible subsets given n and k.
	 */
	public static void printSubsets(ArrayList<ArrayList<Integer>> listOfSubsets) {
		System.out.println();
		for(int i = 0; i < listOfSubsets.size(); i++) {
			System.out.print(i + 1 + ". {");
			for(int j = 0; j < listOfSubsets.get(i).size(); j++) {
				
				if(j != listOfSubsets.get(i).size() - 1) {
					System.out.print(listOfSubsets.get(i).get(j) + ", ");
				} else {
					System.out.println(listOfSubsets.get(i).get(j) + "}");
				}				
			}
		}
	}
	
}
