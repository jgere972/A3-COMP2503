
import java.util.Scanner;

/**
 * COMP 2503 Fall 2023 Assignment 3 Avenger Statistics
 * 
 * This program reads a input stream and keeps track of the statistics for avengers
 * mentioned by name, alias, or performer's last name.
 * The program uses a BST
 * for storing the data. Multiple BSTs with alternative orderings are
 * constructed to show the required output.
 * 
 * @author Maryam Elahi
 * @date Fall 2023
 */

public class A3 {

	public String[][] avengerRoster = { { "captainamerica", "rogers", "evans" }, { "ironman", "stark", "downey" },
			{ "blackwidow", "romanoff", "johansson" }, { "hulk", "banner", "ruffalo" },
			{ "blackpanther", "tchalla", "boseman" }, { "thor", "odinson", "hemsworth" },
			{ "hawkeye", "barton", "renner" }, { "warmachine", "rhodes", "cheadle" },
			{ "spiderman", "parker", "holland" }, { "wintersoldier", "barnes", "stan" } };

	private int topN = 4;
	private int totalwordcount = 0;
	private Scanner input = new Scanner(System.in);
	private BST<Avenger> alphabticalBST = new BST<>();
//	private BST<Avenger> mentionBST = new BST<Avenger>(new AvengerComparatorMentionOrder());
//	private BST<Avenger> mostPopularAvengerBST = new BST<Avenger>(new AvengerComparatorFreqDesc());
//	private BST<Avenger> mostPopularPerformerBST = new BST<Avenger>(new AvengerPerformerComparatorFreqDesc());
	
	private Avenger captainAmerica;
	private Avenger ironMan;
	private Avenger blackWidow;
	private Avenger hulk;
	private Avenger blackPanther;
	private Avenger thor;
	private Avenger hawkEye;
	private Avenger warMachine;
	private Avenger spiderMan;
	private Avenger winterSoldier;
	
	public static void main(String[] args) {
		A3 a3 = new A3();
		a3.run();
	}

	public void run() {
		readInput();
		createdAlternativeOrderBSTs();
		printResults();
	}

	private void createdAlternativeOrderBSTs() {
		/* TODO:
		 *   - delete the following two avengers (if they exist) from the alphabetical tree
		 *   	- barton
		 *   	- banner
		 *   use the tree iterator to do an in-order traversal of the alphabetical tree,
		 *   and add avengers to the other trees with alternative ordering
		 */
	}

	/**
	 * read the input stream and keep track how many times avengers are mentioned by
	 * alias or last name or performer name.
	 */
	private void readInput() {
		/* Create a mention index counter and initialize it to 1
		 * While the scanner object has not reached end of stream, 
		 * 	- read a word. 
		 * 	- clean up the word 
		 * 	- if the word is not empty, add the word count. 
		 * 	- Check if the word is either an avenger alias or last name, or performer last name then
		 *		- Create a new avenger object with the corresponding alias and last name and performer last name.
		 *		- check if this avenger has already been added to the alphabetically ordered tree
		 *			- if yes, increase the corresponding frequency count for the object already in the tree.
		 *			- if no, add the newly created avenger to the alphabetically ordered BST, 
		 *				- remember to set the frequency and the mention index.
		 * You need to think carefully about how you are keeping track of the mention order by setting the mention order for each new avenger.
		 */
		totalwordcount = 0;
		while (input.hasNext()) {
			String word = input.next();
			word = word.trim().toLowerCase().split("'")[0].replaceAll("[^\\\\sa-zA-Z]", "");
			if (word.length() != 0) totalwordcount++;
			matchIncrement(word, avengerRoster);
		}
		input.close();
	}
	
	// can iterate through the BST and find how many nodes are there, and set mention index to nodeCount +1 (if 0, then number 1 so and so)
	// index1 is for the [] in roster, so avengers
	// index2 is for the [][] in roster, so name/alias/performer
	public void matchIncrement(String word, String[][] avengerRoster) {
		for (int index1 = 0; index1 < 10; index1 ++) {
			for (int index2 = 0; index2 < 3; index2 ++ ) {
				if (word.equals(avengerRoster[index1][index2])) {
					if (index1 == 0) {
						captainAmerica = createNew(index1);
						increment(index2, captainAmerica);
						if (!checkIfExist(captainAmerica)) {
							// add to alphabetical bst
						}
					}
					else if (index1 == 1) {
						ironMan = createNew(index1);
						increment(index2, ironMan);
						if (!checkIfExist(ironMan)) {
							// add to alphabetical bst
						}
					}
					else if (index1 == 2) {
						blackWidow = createNew(index1);
						increment(index2, blackWidow);
						if (!checkIfExist(blackWidow)) {
							// add to alphabetical bst
						}
					}
					else if (index1 == 3) {
						hulk = createNew(index1);
						increment(index2, hulk);
						if (!checkIfExist(hulk)) {
							// add to alphabetical bst
						}
					}
					else if (index1 == 4) {
						blackPanther = createNew(index1);
						increment(index2, blackPanther);
						if (!checkIfExist(blackPanther)) {
							// add to alphabetical bst
						}
					}
					else if (index1 == 5) {
						thor = createNew(index1);
						increment(index2, thor);
						if (!checkIfExist(thor)) {
							// add to alphabetical bst
						}
					}
					else if (index1 == 6) {
						hawkEye = createNew(index1);
						increment(index2, hawkEye);
						if (!checkIfExist(hawkEye)) {
							// add to alphabetical bst
						}
					}
					else if (index1 == 7) {
						warMachine = createNew(index1);
						increment(index2, warMachine);
						if (!checkIfExist(warMachine)) {
							// add to alphabetical bst
						}
					}
					else if (index1 == 8) {
						spiderMan = createNew(index1);
						increment(index2, spiderMan);
						if (!checkIfExist(spiderMan)) {
							// add to alphabetical bst
						}
					}
					else if (index1 == 9) {
						winterSoldier = createNew(index1);
						increment(index2, winterSoldier);
						if (!checkIfExist(winterSoldier)) {
							// add to alphabetical bst
						}
					}
				}
			}
		}
	}
	
	public int nodeCount(BST<Avenger> bst) {
		
	}
	
	public Avenger createNew(int index) {
		Avenger newAvenger = new Avenger(avengerRoster[index][0], avengerRoster[index][1], avengerRoster[index][2]);
		return newAvenger;
	}
	
	public void increment(int index, Avenger av) {
		if (index == 0) {
			av.incrementAliasCount();
		}
		else if (index == 1) {
			av.incrementNameCount();
		}
		else {
			av.incrementActorCount();
		}
	}
	
	public boolean checkIfExist(Avenger av) {
		// iterate through entire tree to create a queue? then check through queue?
	}

	/**
	 * print the results
	 */
	private void printResults() {
		// Todo: Print the total number of words (this total should not include words that are all digits or punctuation.)
		System.out.println("Total number of words: " + totalwordcount);
		// TODO: Print the number of mentioned avengers after deleting "barton" and "banner".
		//System.out.println("Number of Avengers Mentioned: " + ??);
		System.out.println();

		System.out.println("All avengers in the order they appeared in the input stream:");
		// TODO: Print the list of avengers in the order they appeared in the input
		// Make sure you follow the formatting example in the sample output
		System.out.println();
		
		System.out.println("Top " + topN + " most popular avengers:");
		// TODO: Print the most popular avengers, see the instructions for tie breaking
		// Make sure you follow the formatting example in the sample output
		System.out.println();

		System.out.println("Top " + topN + " most popular performers:");
		// TODO: Print the most popular performers, see the instructions for tie breaking
		// Make sure you follow the formatting example in the sample output
		System.out.println();

		System.out.println("All mentioned avengers in alphabetical order:");
		// TODO: Print the list of avengers in alphabetical order
		System.out.println();

		// TODO: Print the actual height and the optimal height for each of the four trees.
//		System.out.println("Height of the mention order tree is : " + ??
//				+ " (Optimal height for this tree is : " + ?? + ")");
//		System.out.println("Height of the alphabetical tree is : " + ??
//				+ " (Optimal height for this tree is : " + ?? + ")");
//		System.out.println("Height of the most frequent tree is : " + ??
//				+ " (Optimal height for this tree is : " + ?? + ")");
//		System.out.println("Height of the most frequent performer tree is : " + ??
//		+ " (Optimal height for this tree is : " + ?? + ")");
	}
}
