package builder;

import java.util.Objects;

public class Interval {
	private final Bound lowerBound;
	private final Bound upperBound;

	private Interval(Bound lowerBound, Bound upperBound) {
		this.lowerBound = Objects.requireNonNull(lowerBound);
		this.upperBound = Objects.requireNonNull(upperBound);
	}

	public double getLowerBound() {
		return lowerBound.value();
	}
	public boolean isLowerBoundIncluded() {
		return lowerBound.relativePosition() == 0;
	}
	public double getUpperBound() {
		return upperBound.value();
	}
	public boolean isUpperBoundIncluded() {
		return upperBound.relativePosition() == 0;
	}

	public enum BoundType {
		INCLUSIVE, EXCLUSIVE
	}

	public static Builder anInterval() {
		return new Builder();
	}
	public static class Builder {
		private Bound lowerBound = null;
		private Bound upperBound = null;

		public Builder from(double value, BoundType boundType) {
			lowerBound = Bound.createLowerBound(value, boundType == BoundType.INCLUSIVE);
			return this;
		}
		public Builder to(double value, BoundType boundType) {
			upperBound = Bound.createUpperBound(value, boundType == BoundType.INCLUSIVE);
			return this;
		}
		public Interval build() {
			return new Interval(lowerBound, upperBound);
		}
	}

	private record Bound(double value, int relativePosition) implements Comparable<Bound> {
		public static Bound createLowerBound(double value, boolean isIncluded) {
			return new Bound(value, isIncluded ? 0 : 1);
		}
		public static Bound createUpperBound(double value, boolean isIncluded) {
			return new Bound(value, isIncluded ? 0 : -1);
		}

		public static Bound max(Bound a, Bound b) {
			return a.compareTo(b) > 0 ? a : b;
		}
		public static Bound min(Bound a, Bound b) {
			return a.compareTo(b) < 0 ? a : b;
		}

		@Override
		public int compareTo(Bound other) {
			int result = Double.compare(this.value, other.value);
			return result == 0 ? result : Integer.compare(this.relativePosition, other.relativePosition);
		}
	}
}
