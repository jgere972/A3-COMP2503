
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
		
	    // Create iterators for alphabeticalBST
	    Iterator<Avenger> alphabeticalIterator = alphabeticalBST.iterator();

	    // Add elements to mentionBST
	    while (alphabeticalIterator.hasNext()) {
	        Avenger av = alphabeticalIterator.next();
	        mentionBST.add(av);
	    }

	    // Create a list for sorting based on frequency comparator
	    List<Avenger> sortedByFreq = new ArrayList<>(alphabeticalBST.size());
	    for (Avenger av : alphabeticalBST) {
	        sortedByFreq.add(av);
	    }
	    sortedByFreq.sort(new AvengerComparatorFreqDesc());

	    // Add topN elements based on frequency to mostPopularAvengerBST
	    int freqTopN = topN;
	    if (freqTopN > sortedByFreq.size()) {
	        freqTopN = sortedByFreq.size();
	    }
	    for (Avenger av : sortedByFreq.subList(0, freqTopN)) {
	        mostPopularAvengerBST.add(av);
	    }

	    // Create a list for sorting based on performer frequency comparator
	    List<Avenger> sortedByPerformerFreq = new ArrayList<>(alphabeticalBST.size());
	    for (Avenger av : alphabeticalBST) {
	        sortedByPerformerFreq.add(av);
	    }
	    sortedByPerformerFreq.sort(new AvengerPerformerComparatorFreqDesc());

	    // Add topN elements based on performer frequency to mostPopularPerformerBST
	    int performerTopN = topN;
	    if (performerTopN > sortedByPerformerFreq.size()) {
	        performerTopN = sortedByPerformerFreq.size();
	    }
	    for (Avenger av : sortedByPerformerFreq.subList(0, performerTopN)) {
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
						if (!checkIfExist(captainAmerica)) {
							captainAmerica = createNew(index1);
							alphabeticalBST.add(captainAmerica);
							captainAmerica.setMentionIndex(alphabeticalBST.size() + 1);
						}
						increment(index2, captainAmerica);
					}
					else if (index1 == 1) {
						if (!checkIfExist(ironMan)) {
							ironMan = createNew(index1);
							alphabeticalBST.add(ironMan);
							ironMan.setMentionIndex(alphabeticalBST.size() + 1);
						}
						increment(index2, ironMan);
					}
					else if (index1 == 2) {
						if (!checkIfExist(blackWidow)) {
							blackWidow = createNew(index1);
							alphabeticalBST.add(blackWidow);
							blackWidow.setMentionIndex(alphabeticalBST.size() + 1);
						}
						increment(index2, blackWidow);
					}
					else if (index1 == 3) {

						if (!checkIfExist(hulk)) {
							hulk = createNew(index1);
							alphabeticalBST.add(hulk);
							hulk.setMentionIndex(alphabeticalBST.size() + 1);
						}
						increment(index2, hulk);
					}
					else if (index1 == 4) {

						if (!checkIfExist(blackPanther)) {
							blackPanther = createNew(index1);
							alphabeticalBST.add(blackPanther);
							blackPanther.setMentionIndex(alphabeticalBST.size() + 1);
						}
						increment(index2, blackPanther);
					}
					else if (index1 == 5) {
						if (!checkIfExist(thor)) {
							thor = createNew(index1);
							alphabeticalBST.add(thor);
							thor.setMentionIndex(alphabeticalBST.size() + 1);
						}
						increment(index2, thor);
					}
					else if (index1 == 6) {
						if (!checkIfExist(hawkEye)) {
							hawkEye = createNew(index1);
							alphabeticalBST.add(hawkEye);
							hawkEye.setMentionIndex(alphabeticalBST.size() + 1);
						}
						increment(index2, hawkEye);
					}
					else if (index1 == 7) {
						if (!checkIfExist(warMachine)) {
							warMachine = createNew(index1);
							alphabeticalBST.add(warMachine);
							warMachine.setMentionIndex(alphabeticalBST.size() + 1);
						}
						increment(index2, warMachine);
					}
					else if (index1 == 8) {
						if (!checkIfExist(spiderMan)) {
							spiderMan = createNew(index1);
							alphabeticalBST.add(spiderMan);
							spiderMan.setMentionIndex(alphabeticalBST.size() + 1);
						}
						increment(index2, spiderMan);
					}
					else if (index1 == 9) {
						if (!checkIfExist(winterSoldier)) {
							winterSoldier = createNew(index1);
							alphabeticalBST.add(winterSoldier);
							winterSoldier.setMentionIndex(alphabeticalBST.size() + 1);
						}
						increment(index2, winterSoldier);
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