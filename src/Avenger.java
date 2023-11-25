public class Avenger implements Comparable<Avenger> {

	private String heroName;
	private String heroAlias;
	private String performer;
	private int nameFreq;
	private int aliasFreq;
	private int performerFreq;
	private int mentionIndex;

	// Constructor
	public Avenger(String alias, String name, String actor) {
		this.heroName = name;
		this.heroAlias = alias;
		this.performer = actor;
		nameFreq = 0;
		aliasFreq = 0;
		performerFreq = 0;
	}

	// Getters
	public String getName() {
		return heroName;
	}

	public String getAlias() {
		return heroAlias;
	}

	public String getActor() {
		return performer;
	}

	public int getNameCount() {
		return nameFreq;
	}

	public int getAliasCount() {
		return aliasFreq;
	}

	public int getActorCount() {
		return performerFreq;
	}
	
	public int getTotalCount() {
		return nameFreq + aliasFreq + performerFreq;
	}

	// Incrementing the Counters
	public void incrementNameCount() {
		nameFreq++;
	}

	public void incrementAliasCount() {
		aliasFreq++;
	}

	public void incrementActorCount() {
		performerFreq++;
	}

	public void setMentionIndex(int i) {
		mentionIndex = i;
	}
	
	public int getMentionIndex() {
		return mentionIndex;
	}
	
	
	/**
	 * Overrides the equals method to check if two Avenger objects are equal based on their Alias.
	 * 
	 * @param obj The object to compare with this Avenger
	 * @return True if the heroAlias of both Avengers are equal, false otherwise
	 */
	@Override
	public boolean equals(Object obj) { // Matching compareTo to order Alias alphabetically
		if (obj == null) return false;
		if (obj == this) return true;
		Avenger av = (Avenger) obj;
		if (this.heroAlias.compareTo(av.getAlias()) == 0) return true;
		else return false;
	}
	
	
	/**
	 * Overrides the toString method to provide a string representation of Avengers. 
	 * The string includes heroAlias, heroName, performer, and frequency counts
	 * 
	 * @return A formatted string representing the Avenger object
	 */
	@Override
	public String toString() {
		return heroAlias + " aka " + heroName + " performed by " + performer + " mentioned " + "(n: " + nameFreq
				+ " + a: " + aliasFreq + " + p: " + performerFreq + ")" + " time(s)";
	}
	
	
	/**
	 * Overrides the compareTo method to provide a natural ordering based on Alias.
	 * 
	 * @param other The Avenger object to compare with this Avenger
	 * @return A negative, zero, or positive if the Avenger is less than, equal to,
	 *         or greater than the specified Avenger, based on their Alias
	 */
	@Override
	public int compareTo(Avenger other) {
		if (other == null) return -1;
		return this.getAlias().compareTo(other.getAlias());
	}
}