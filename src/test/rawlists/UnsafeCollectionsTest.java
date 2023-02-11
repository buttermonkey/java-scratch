package rawlists;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class UnsafeCollectionsTest {

	@Test
	void listOfStringsDetectsString() {
		List<String> list = List.of("Markus", "Karin");
		assertTrue(UnsafeCollections.listContainsItem(list, "Markus"));
		assertFalse(UnsafeCollections.listContainsItem(list, "Nobody"));
	}

	@Test
	void listOfDoubleDetectsDouble() {
		List<Double> list = List.of(1., -42.42);
		assertTrue(UnsafeCollections.listContainsItem(list, 1.));
		assertFalse(UnsafeCollections.listContainsItem(list, 0.));
	}

	@Test
	void listOfStringsDetectsDouble() {
		List<String> list = List.of("Markus", String.valueOf(1.));
		assertTrue(UnsafeCollections.listContainsItem(list, "Markus"));
		assertTrue(UnsafeCollections.listContainsItem(list, String.valueOf(1.0)));
	}

	@Test
	void playground() {
		ISet setOfStrings = new SetOfStrings(List.of("Markus", "Karin", "Philipp"));
		ISet setOfDoubles = new SetOfDoubles(List.of(1., -42.42, 0.));

		assertTrue(setOfStrings.contains("Karin"));
		assertFalse(setOfStrings.contains("Nobody"));
		assertTrue(setOfStrings.contains(List.of("Markus", "Philipp")));
		assertFalse(setOfStrings.contains(List.of("Markus", "Nobody")));

		assertTrue(setOfDoubles.contains(1.));
		assertFalse(setOfDoubles.contains(1234.));
		assertTrue(setOfDoubles.contains(List.of(1., 0.)));
		assertFalse(setOfDoubles.contains(List.of(1., 1234.)));

		assertFalse(setOfStrings.contains(0.));
		assertFalse(setOfStrings.contains(List.of(1., 0.)));

//		assertFalse(setOfStrings.contains(List.of(new FakeType())));
	}

	private static class FakeType {
		@Override
		public boolean equals(Object o) {
			throw new RuntimeException("This just blows up. For fun.");
		}

		@Override
		public int hashCode() {
			throw new RuntimeException("This just blows up. For cash.");
		}
	}
}