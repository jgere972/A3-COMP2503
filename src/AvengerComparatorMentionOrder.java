import java.util.Comparator;

public class AvengerComparatorMentionOrder implements Comparator <Avenger>{

	@Override
	public int compare(Avenger a1, Avenger a2) {
		return Integer.compare(a1.getMentionIndex(), a2.getMentionIndex());
	}
}

