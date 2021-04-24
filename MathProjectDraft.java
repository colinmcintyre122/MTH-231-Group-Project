import java.util.ArrayList;
import java.util.Scanner;

/**
 * MTH 231 Group Project code. Produces a list of all distinct subsets
 * of size k from the set {1, 2, 3,..., n}. Also, using the definition
 * of n choose k, this program calculates the value of n choose k.
 * 
 * Group Members: Anthoney Brey, Colin McIntyre, Daniel Townsend, Dalong Wang,
 *                Elton Zeng, Isabella Wilson & Yuming Deng.
 */
public class MathProjectDraft {

	public static void main(String[] args) {
		
		Scanner inputReader = new Scanner(System.in);
		
		// get n (number of elements to choose from)
		System.out.print("Enter a value for n: ");
		int numOfElements = inputReader.nextInt(); // n
		
		// get k (size of subsets)
		System.out.print("Enter a value for k: ");
		int sizeOfSubsets = inputReader.nextInt(); // k
		inputReader.close();
		
		// print how many possible subsets there are given n and k
		System.out.println(numOfElements + " choose " + sizeOfSubsets + " is "
				           + countPossibleSubsets(numOfElements, sizeOfSubsets));
		
		// print and generate the possible subsets given n and k
		ArrayList<ArrayList<Integer>> listOfSubsets = new ArrayList<ArrayList<Integer>>();
		getPossibleSubsets(numOfElements, sizeOfSubsets, new ArrayList<Integer>(), listOfSubsets, 1);
		printSubsets(listOfSubsets);
	}
	
	/**
	 * Recursively finds the factorial of an integer.
	 * 
	 * @param n the integer to find the factorial of.
	 * @return the factorial of n as an integer.
	 */
	public static int factorial(int n) {
		if (n == 1) {
			return 1;
		} else {
			return n * factorial(n - 1);
		}
	}
	
	/**
	 * Counts the number of possible subsets of n choose k 
	 * using the given formula.
	 * 
	 * @param n the number of elements to choose from to create
	 * subsets.
	 * @param k the number of elements in the subsets.
	 * @return the result of the n choose k formula as an integer.
	 */
	public static int countPossibleSubsets(int n, int k) {
		return (factorial(n)) / (factorial(k) * factorial(n - k));
	}
	
	/**
	 * Recursively generates all the possible subsets based on the n and k
	 * values.
	 * 
	 * @param n the number of elements to choose from to create
	 * subsets.
	 * @param k the number of elements in the subsets.
	 * @param subset an ArrayList of Integers which represents the current
	 *        subset.
	 * @param listOfSubsets an ArrayList of ArrayLists of Integers which holds
	 *        all the possible subsets.
	 * @param start the starting value to add to the subset. Initially, the
	 *        value 1 is passed as the argument.
	 */
	public static void getPossibleSubsets(int n, int k, ArrayList<Integer> subset,  ArrayList<ArrayList<Integer>> listOfSubsets, int start) {
		
		// the base case. when building up the subsets, we know a subset is
		// "complete" if its size is equal to k.
		if(subset.size() == k) {
			listOfSubsets.add(subset);
			return;
		} 
		
		/*
		 * This for loop loops through all the integers 1 through n
		 * inclusive. Each time, we add the index to the current subset and
		 * call the method again but with the starting index equal to the
		 * previous index plus one. 
		 */
		for(int i = start; i <= n; i++) {
			/*
			 * We call the method again on a copy of the subset because ArrayLists are
			 * passed by reference, so we don't want to continually edit the same
			 * subset/ArrayList.
			 */
			ArrayList<Integer> copySet = new ArrayList<Integer>(subset);
			copySet.add(i);
			getPossibleSubsets(n, k, copySet, listOfSubsets, i + 1);
		}
	}
	  
	/**
	 * Prints all the ArrayLists within an ArrayList formatted as such:
	 * 1. {1, 2} 
	 * 2. {1, 3}
	 * 3. {2, 3}
	 * 
	 * @param listOfSubsets an ArrayList of Integer ArrayLists which holds all the
	 * possible subsets made with the given n and k values.
	 */
	public static void printSubsets(ArrayList<ArrayList<Integer>> listOfSubsets) {
		System.out.println();
		for(int i = 0; i < listOfSubsets.size(); i++) {
			
			System.out.print(i + 1 + ". {");
			for(int j = 0; j < listOfSubsets.get(i).size(); j++) {
				
				if(j != listOfSubsets.get(i).size() - 1) {
					System.out.print(listOfSubsets.get(i).get(j) + ", ");
				} else {
					// if we reach the end of a subset, we use a "}"
					System.out.println(listOfSubsets.get(i).get(j) + "}");
				}				
			}
		}
	}
	
}
