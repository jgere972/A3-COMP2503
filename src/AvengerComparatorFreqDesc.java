import java.util.Comparator;

public class AvengerComparatorFreqDesc implements Comparator <Avenger>{

	
	/**
	 * Compares two Avenger objects based on their total counts.
	 * 
	 * @param a1 The first Avenger 
	 * @param a2 The second Avenger
	 * @return A negative, zero, or positive if the total count of a1
	 *         is less than, equal to, or greater than the total count of a2.
	 *         If the total counts are equal it compares based on the performers name.
	 */
	@Override
	public int compare(Avenger a1, Avenger a2) {
		int diff = a2.getTotalCount() - a1.getTotalCount();
		if (diff == 0) return a1.getActor().compareTo(a2.getActor());
		return diff;
	}
}

