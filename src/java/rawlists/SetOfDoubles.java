package rawlists;

import java.util.Collection;

public class SetOfDoubles implements ISet {
	private final SetImpl<Double> set;

	public SetOfDoubles(Collection<Double> elements) {
		set = SetImpl.createDoubleSet(elements);
	}

	public boolean contains(Object data) {
		if (data instanceof Collection<?> collection)
			return set.contains((Collection<Double>) collection);
		else if (data instanceof Double doubleData)
			return set.contains(doubleData);
		else
			return false;
	}
}
