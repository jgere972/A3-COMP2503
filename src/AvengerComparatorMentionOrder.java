import java.util.Comparator;

public class AvengerComparatorMentionOrder implements Comparator<Avenger> {
	@Override
	public int compare(Avenger a1, Avenger a2) {
		int diff = a2.getMentionIndex() - a1.getMentionIndex();
		return diff;
	}
}
