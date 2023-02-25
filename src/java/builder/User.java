package builder;

import builder.Interval.BoundType;

import static builder.Interval.BoundType.*;
import static builder.Interval.anInterval;
import static java.lang.Double.NEGATIVE_INFINITY;
import static java.lang.Double.POSITIVE_INFINITY;

public class User {
	public static void main(String[] args) {
		Interval negativeNumbers = anInterval()
				.from(NEGATIVE_INFINITY)
				.to(0., EXCLUSIVE);

		Interval positiveNumbers = anInterval().from(0., EXCLUSIVE).to(POSITIVE_INFINITY);

		Interval wholeNumberLine = anInterval().from(NEGATIVE_INFINITY).to(POSITIVE_INFINITY);

		double lb = negativeNumbers.getLowerBound();
		boolean lbi = negativeNumbers.isLowerBoundIncluded();
		double ub = negativeNumbers.getUpperBound();
		boolean ubi = negativeNumbers.isUpperBoundIncluded();

		double lowerBound = 0.;
		double upperBound = 0.;
		BoundType lowerBoundType = lbi ? INCLUSIVE : EXCLUSIVE;
		BoundType upperBoundType = ubi ? INCLUSIVE : EXCLUSIVE;

		Interval nr = anInterval()
				.from(lowerBound, lowerBoundType)
				.to(upperBound, upperBoundType);
	}
}
