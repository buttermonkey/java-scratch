package rawlists;

import java.util.Collection;
import java.util.List;

public class UnsafeCollections {
	public static void main(String[] args) {
		List rawStringList = List.of("Markus", "Karin", "Christian");
		List rawDoubleList = List.of(1., 42.42, -234);

	}

	public static <T> boolean listContainsItem(Collection<T> list, Object data) {
		if (data instanceof Collection collection)
			return containsCollection(list, collection);
		else
			return containsItem(list, (T)data);
	}

	private static <T> boolean containsItem(Collection<T> list, T item) {
		return list.contains(item);
	}

	private static <T> boolean containsCollection(Collection<T> list, Collection collection) {
		return list.containsAll(collection);
	}
}
