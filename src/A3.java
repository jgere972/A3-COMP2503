
import java.util.Iterator;
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
	private BST<Avenger> alphabeticalBST = new BST<Avenger>();
	private BST<Avenger> mentionBST = new BST<Avenger>(new AvengerComparatorMentionOrder());
	private BST<Avenger> mostPopularAvengerBST = new BST<Avenger>(new AvengerComparatorFreqDesc());
	private BST<Avenger> mostPopularPerformerBST = new BST<Avenger>(new AvengerPerformerComparatorFreqDesc());
	
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
	private Avenger toDelete;
	
	Iterator<Avenger> iterator;
	
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
		toDelete = new Avenger("hawkeye", "barton", "renner");
		alphabeticalBST.delete(toDelete);
		toDelete = new Avenger("hulk", "banner", "ruffalo");
		alphabeticalBST.delete(toDelete);
		
		iterator = alphabeticalBST.iterator();
		
		// adding, but not in the right order: find a way to add using the comparators
		for (Avenger av: alphabeticalBST) {
			mentionBST.add(av);
			mostPopularAvengerBST.add(av);
			mostPopularPerformerBST.add(av);
		}
	}

	/**
	 * read the input stream and keep track how many times avengers are mentioned by
	 * alias or last name or performer name.
	 */
	private void readInput() {
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
							alphabeticalBST.add(captainAmerica);
							captainAmerica.setMentionIndex(alphabeticalBST.size() + 1);
						}
					}
					else if (index1 == 1) {
						ironMan = createNew(index1);
						increment(index2, ironMan);
						if (!checkIfExist(ironMan)) {
							alphabeticalBST.add(ironMan);
							ironMan.setMentionIndex(alphabeticalBST.size() + 1);
						}
					}
					else if (index1 == 2) {
						blackWidow = createNew(index1);
						increment(index2, blackWidow);
						if (!checkIfExist(blackWidow)) {
							alphabeticalBST.add(blackWidow);
							blackWidow.setMentionIndex(alphabeticalBST.size() + 1);
						}
					}
					else if (index1 == 3) {
						hulk = createNew(index1);
						increment(index2, hulk);
						if (!checkIfExist(hulk)) {
							alphabeticalBST.add(hulk);
							hulk.setMentionIndex(alphabeticalBST.size() + 1);
						}
					}
					else if (index1 == 4) {
						blackPanther = createNew(index1);
						increment(index2, blackPanther);
						if (!checkIfExist(blackPanther)) {
							alphabeticalBST.add(blackPanther);
							blackPanther.setMentionIndex(alphabeticalBST.size() + 1);
						}
					}
					else if (index1 == 5) {
						thor = createNew(index1);
						increment(index2, thor);
						if (!checkIfExist(thor)) {
							alphabeticalBST.add(thor);
							thor.setMentionIndex(alphabeticalBST.size() + 1);
						}
					}
					else if (index1 == 6) {
						hawkEye = createNew(index1);
						increment(index2, hawkEye);
						if (!checkIfExist(hawkEye)) {
							alphabeticalBST.add(hawkEye);
							hawkEye.setMentionIndex(alphabeticalBST.size() + 1);
						}
					}
					else if (index1 == 7) {
						warMachine = createNew(index1);
						increment(index2, warMachine);
						if (!checkIfExist(warMachine)) {
							alphabeticalBST.add(warMachine);
							warMachine.setMentionIndex(alphabeticalBST.size() + 1);
						}
					}
					else if (index1 == 8) {
						spiderMan = createNew(index1);
						increment(index2, spiderMan);
						if (!checkIfExist(spiderMan)) {
							alphabeticalBST.add(spiderMan);
							spiderMan.setMentionIndex(alphabeticalBST.size() + 1);
						}
					}
					else if (index1 == 9) {
						winterSoldier = createNew(index1);
						increment(index2, winterSoldier);
						if (!checkIfExist(winterSoldier)) {
							alphabeticalBST.add(winterSoldier);
							winterSoldier.setMentionIndex(alphabeticalBST.size() + 1);
						}
					}
				}
			}
		}
	}
	
	public int nodeCount(BST<Avenger> bst) {
		return bst.size();
	}
	
	public Avenger createNew(int index) {
		Avenger newAvenger = new Avenger(avengerRoster[index][0], avengerRoster[index][1], avengerRoster[index][2]);
		return newAvenger;
	}
	
	public void increment(int index, Avenger av) {
		if (index == 0) av.incrementAliasCount();
		else if (index == 1) av.incrementNameCount();
		else av.incrementActorCount();
	}
	
	public boolean checkIfExist(Avenger av) {
		if (alphabeticalBST.find(av) != null) return true;
		else return false;
	}

	/**
	 * print the results
	 */
	private void printResults() {
		System.out.println("Total number of words: " + totalwordcount);
		System.out.println("Number of Avengers Mentioned: " + alphabeticalBST.size());
		System.out.println();

		System.out.println("All avengers in the order they appeared in the input stream:");
		mentionBST.printInOrder();
		System.out.println();
		
		// change to print topN
		System.out.println("Top " + topN + " most popular avengers:");
		mostPopularAvengerBST.printInOrder();
		System.out.println();

		// change to print topN
		System.out.println("Top " + topN + " most popular performers:");
		mostPopularPerformerBST.printInOrder();
		System.out.println();

		System.out.println("All mentioned avengers in alphabetical order:");
		alphabeticalBST.printInOrder();
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
		
		// add optimal heights
		System.out.println("Height of the mention order tree is : " + mentionBST.height());
		System.out.println("Height of the alphabetical order tree is : " + alphabeticalBST.height());
		System.out.println("Height of the most frequent order tree is : " + mostPopularAvengerBST.height());
		System.out.println("Height of the most frequent performer order tree is : " + mostPopularPerformerBST.height());

	}
}
