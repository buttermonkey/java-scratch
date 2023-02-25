package rawlists;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

public class SetImpl<T> {
	Set<T> elements = new HashSet<>();

	private SetImpl(Collection<T> elements) {
		this.elements.addAll(elements);
	}

	public static SetImpl<String> createStringSet(Collection<String> elements) {
		return new SetImpl<>(elements);
	}

	public static SetImpl<Double> createDoubleSet(Collection<Double> elements) {
		return new SetImpl<>(elements);
	}

	public boolean contains(T data) {
		if (!(data instanceof String) && !(data instanceof Double))
			throw new IllegalStateException("T must be either String or Double. Found: " + data.getClass());

		return elements.contains(data);
	}

	public boolean contains(Collection<T> collection) {
		return elements.containsAll(collection);
	}

	public void parse(String data, Function<String, T> valueMapper) {
		String value = data.trim();
		elements.add(valueMapper.apply(value));
	}
}
