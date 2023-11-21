
import java.util.ArrayList;
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
	private Avenger cptAmerica = new Avenger(avengerRoster[0][0], avengerRoster[0][1], avengerRoster[0][2]);
	private Avenger ironMan = new Avenger(avengerRoster[1][0], avengerRoster[1][1], avengerRoster[1][2]);
	private Avenger blackWidow = new Avenger(avengerRoster[2][0], avengerRoster[2][1], avengerRoster[2][2]);
	private Avenger hulk = new Avenger(avengerRoster[3][0], avengerRoster[3][1], avengerRoster[3][2]);
	private Avenger blackPan = new Avenger(avengerRoster[4][0], avengerRoster[4][1], avengerRoster[4][2]);
	private Avenger thor = new Avenger(avengerRoster[5][0], avengerRoster[5][1], avengerRoster[5][2]);
	private Avenger hawkEye = new Avenger(avengerRoster[6][0], avengerRoster[6][1], avengerRoster[6][2]);
	private Avenger warMachine = new Avenger(avengerRoster[7][0], avengerRoster[7][1], avengerRoster[7][2]);
	private Avenger spiderMan = new Avenger(avengerRoster[8][0], avengerRoster[8][1], avengerRoster[8][2]);
	private Avenger winterSoldier = new Avenger(avengerRoster[9][0], avengerRoster[9][1], avengerRoster[9][2]);
	private ArrayList<Avenger> possibleAvengers = new ArrayList<>();

	private int topN = 4;
	private int totalwordCount = 0;
	private Scanner input = new Scanner(System.in);
//	private BST<Avenger> alphabticalBST = new BST<>();
	private BST<Avenger> mentionBST = new BST<Avenger>(new AvengerComparatorMentionOrder());
//	private BST<Avenger> mostPopularAvengerBST = new BST<Avenger>(new AvengerComparatorFreqDesc());
//	private BST<Avenger> mostPopularPerformerBST = new BST<Avenger>(new AvengerPerformerComparatorFreqDesc());
	
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
		possibleAvengers.add(cptAmerica);
		possibleAvengers.add(ironMan);
		possibleAvengers.add(blackWidow);
		possibleAvengers.add(hulk);
		possibleAvengers.add(blackPan);
		possibleAvengers.add(thor);
		possibleAvengers.add(hawkEye);
		possibleAvengers.add(warMachine);
		possibleAvengers.add(spiderMan);
		possibleAvengers.add(winterSoldier);
		
		input = new Scanner(System.in);
		while (input.hasNext()) {
			String word = input.next();
			word = word.trim().toLowerCase().split("'")[0].replaceAll("[^\\\\sa-zA-Z]", "");
			if (word.length() != 0) {
				totalwordCount++;
				// Making a list of all possible Avengers
				matchIncrement(word, possibleAvengers); // Updating List of mentioned of Avengers and incrementing counters
			}
		}
		input.close();
	}
	
	/*
	 * Matching and incrementing each Avenger's counts
	 */
	public void matchIncrement(String word, ArrayList<Avenger> avenger) {
		for (int i = 0; i < avenger.size(); i++) {
			if (word.equals(avenger.get(i).getAlias())) {
				avenger.get(i).incrementAliasCount();
				checkList(avenger.get(i));
				return;
			} else if (word.equals(avenger.get(i).getName())) {
				avenger.get(i).incrementNameCount();
				checkList(avenger.get(i));
				return;
			} else if (word.equals(avenger.get(i).getActor())) {
				avenger.get(i).incrementActorCount();
				checkList(avenger.get(i));
				return;
			}
		}
	}
	
	/* 
	 * Checks if an avenger mentioned is found in the avengersList
	 *  If not add the avenger to mentioned BST object
	 */
	private void checkList(Avenger a) {
		if (!(mentionBST.iterator()) {
			avengersList.add(a);
		}
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
