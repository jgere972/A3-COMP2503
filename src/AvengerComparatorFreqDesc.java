import java.util.Comparator;

public class AvengerComparatorFreqDesc implements Comparator <Avenger>{

	@Override
	/**
	 * Total order:
	 * descending order of total frequency 
	 * in case of tie, in ascending alphabetical order of performer's last name
	 */
	public int compare(Avenger a1, Avenger a2) {
		int diff = a2.getTotalCount() - a1.getTotalCount();
		if (diff == 0) {
			return a1.getActor().compareTo(a2.getActor());
		}
		return diff;
	}
}

