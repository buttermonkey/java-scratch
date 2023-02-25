package rawlists;

import java.util.Collection;
import java.util.function.Function;

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

	@Override
	public void parse(String value) {
		set.parse(value, Function.identity());
	}
}
