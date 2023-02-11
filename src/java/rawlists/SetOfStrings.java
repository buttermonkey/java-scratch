package rawlists;

import java.util.Collection;

public class SetOfStrings implements ISet {
	private final SetImpl<String> set;

	public SetOfStrings(Collection<String> elements) {
		set = SetImpl.createStringSet(elements);
	}

	public boolean contains(Object data) {
		if (data instanceof Collection<?> collection)
			return set.contains((Collection<String>) collection);
		else if (data instanceof String stringData)
			return set.contains(stringData);
		else
			return false;
	}
}
