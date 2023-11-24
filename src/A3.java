
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
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
		
		Queue<Avenger> queue = new LinkedList<>();
	    Iterator<Avenger> iterator = alphabeticalBST.iterator();
	    while (iterator.hasNext()) {
	    	queue.add(iterator.next());
	    }
	    while (!queue.isEmpty()) {
	    	Avenger addToQueue = queue.remove();
	    	mentionBST.add(addToQueue, new AvengerComparatorMentionOrder());
	    	mostPopularAvengerBST.add(addToQueue, new AvengerComparatorFreqDesc());
	    	mostPopularPerformerBST.add(addToQueue, new AvengerPerformerComparatorFreqDesc());
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
							captainAmerica.setMentionIndex(alphabeticalBST.size());
						}
						increment(index2, captainAmerica);
					}
					else if (index1 == 1) {
						if (!checkIfExist(ironMan)) {
							ironMan = createNew(index1);
							alphabeticalBST.add(ironMan);
							ironMan.setMentionIndex(alphabeticalBST.size());
						}
						increment(index2, ironMan);
					}
					else if (index1 == 2) {
						if (!checkIfExist(blackWidow)) {
							blackWidow = createNew(index1);
							alphabeticalBST.add(blackWidow);
							blackWidow.setMentionIndex(alphabeticalBST.size());
						}
						increment(index2, blackWidow);
					}
					else if (index1 == 3) {

						if (!checkIfExist(hulk)) {
							hulk = createNew(index1);
							alphabeticalBST.add(hulk);
							hulk.setMentionIndex(alphabeticalBST.size());
						}
						increment(index2, hulk);
					}
					else if (index1 == 4) {

						if (!checkIfExist(blackPanther)) {
							blackPanther = createNew(index1);
							alphabeticalBST.add(blackPanther);
							blackPanther.setMentionIndex(alphabeticalBST.size());
						}
						increment(index2, blackPanther);
					}
					else if (index1 == 5) {
						if (!checkIfExist(thor)) {
							thor = createNew(index1);
							alphabeticalBST.add(thor);
							thor.setMentionIndex(alphabeticalBST.size());
						}
						increment(index2, thor);
					}
					else if (index1 == 6) {
						if (!checkIfExist(hawkEye)) {
							hawkEye = createNew(index1);
							alphabeticalBST.add(hawkEye);
							hawkEye.setMentionIndex(alphabeticalBST.size());
						}
						increment(index2, hawkEye);
					}
					else if (index1 == 7) {
						if (!checkIfExist(warMachine)) {
							warMachine = createNew(index1);
							alphabeticalBST.add(warMachine);
							warMachine.setMentionIndex(alphabeticalBST.size());
						}
						increment(index2, warMachine);
					}
					else if (index1 == 8) {
						if (!checkIfExist(spiderMan)) {
							spiderMan = createNew(index1);
							alphabeticalBST.add(spiderMan);
							spiderMan.setMentionIndex(alphabeticalBST.size());
						}
						increment(index2, spiderMan);
					}
					else if (index1 == 9) {
						if (!checkIfExist(winterSoldier)) {
							winterSoldier = createNew(index1);
							alphabeticalBST.add(winterSoldier);
							winterSoldier.setMentionIndex(alphabeticalBST.size());
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
		BST<Avenger> topNAvengerBST = new BST<Avenger>();
		BST<Avenger> topNPerformerBST = new BST<Avenger>();
		Queue<Avenger> queue = new LinkedList<>();
		Iterator<Avenger> iterator;
		
		System.out.println("Total number of words: " + totalwordcount);
		System.out.println("Number of Avengers Mentioned: " + alphabeticalBST.size());
		System.out.println();

		System.out.println("All avengers in the order they appeared in the input stream:");
		mentionBST.printInOrder();
		System.out.println();
		
		System.out.println("Top " + topN + " most popular avengers:");
		queue.clear();
	    iterator = mostPopularAvengerBST.iterator();
	    while (iterator.hasNext()) {
	    	queue.add(iterator.next());
	    }
	    while (!queue.isEmpty() && topNAvengerBST.size() < topN) {
	    	Avenger addToQueue = queue.remove();
	    	topNAvengerBST.add(addToQueue, new AvengerComparatorFreqDesc());
	    }
	    topNAvengerBST.printInOrder();
		System.out.println();

		System.out.println("Top " + topN + " most popular performers:");
		queue.clear();
	    iterator = mostPopularPerformerBST.iterator();
	    while (iterator.hasNext()) {
	    	queue.add(iterator.next());
	    }
	    while (!queue.isEmpty() && topNPerformerBST.size() < topN) {
	    	Avenger addToQueue = queue.remove();
	    	topNPerformerBST.add(addToQueue, new AvengerPerformerComparatorFreqDesc());
	    }
	    topNPerformerBST.printInOrder();
		System.out.println();

		System.out.println("All mentioned avengers in alphabetical order:");
		alphabeticalBST.printInOrder();
		System.out.println();
		
		System.out.println("Height of the mention order tree is : " + mentionBST.height() + " (Optimal height for this tree is : " + mentionBST.optimalHeight(mentionBST.size()) + ")");
		System.out.println("Height of the alphabetical tree is : " + alphabeticalBST.height() + " (Optimal height for this tree is : " + alphabeticalBST.optimalHeight(alphabeticalBST.size()) + ")");
		System.out.println("Height of the most frequent tree is : " + mostPopularAvengerBST.height() + " (Optimal height for this tree is : " + mostPopularAvengerBST.optimalHeight(mostPopularAvengerBST.size()) + ")");
		System.out.println("Height of the most frequent performer tree is : " + mostPopularPerformerBST.height() + " (Optimal height for this tree is : " + mostPopularPerformerBST.optimalHeight(mostPopularPerformerBST.size()) + ")");
	}
}
