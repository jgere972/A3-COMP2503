public class Avenger implements Comparable<Avenger> {

	private String name;
	private String alias;
	private String actor;
	private int nameCount;
	private int aliasCount;
	private int actorCount;

	// Constructor
	public Avenger(String alias, String name, String actor) {
		this.name = name;
		this.alias = alias;
		this.actor = actor;
		nameCount = 0;
		aliasCount = 0;
		actorCount = 0;
	}

	// Getters
	public String getName() {
		return name;
	}

	public String getAlias() {
		return alias;
	}

	public String getActor() {
		return actor;
	}
	public int getNameCount() {
		return nameCount;
	}

	public int getAliasCount() {
		return aliasCount;
	}

	public int getActorCount() {
		return actorCount;
	}
	//Incrementing the Counters
	public void incrementNameCount() {
		nameCount++;
	}

	public void incrementAliasCount() {
		aliasCount++;
	}

	public void incrementActorCount() {
		actorCount++;
	}

	@Override
	public boolean equals(Object obj) {		//Matching compareTo to order Alias alphabetically
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		Avenger av = (Avenger) obj;
		if (this.alias.compareTo(av.getAlias()) == 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int compareTo(Avenger a) {		//Order Alias alphabetically
		return this.alias.compareTo(a.getAlias());
	}
	@Override
	public String toString() {
		return  alias + " aka " + name
				+ " performed by " + actor
				+ " mentioned "
				+ "(n: " + nameCount
				+ " + a: " + aliasCount
				+ " + p: " + actorCount
				+ ")" + " time(s)";
	}

}