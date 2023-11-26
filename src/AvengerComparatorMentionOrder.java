import java.util.Comparator;

public class AvengerComparatorMentionOrder implements Comparator <Avenger>{

	
    /**
     * Compares two Avenger objects based on their mention order index
     * 
     * @param a1 The first Avenger
     * @param a2 The second Avenger
     * @return A negative, zero, or a positive if the mention order index of a1
     *         is less than, equal to, or greater than the mention order index of a2.
     */
	@Override
	public int compare(Avenger a1, Avenger a2) {
		return Integer.compare(a1.getMentionIndex(), a2.getMentionIndex());
	}
}

