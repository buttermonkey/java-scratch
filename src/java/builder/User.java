package builder;

import builder.Interval.BoundType;

import static builder.Interval.BoundType.*;
import static builder.Interval.anInterval;
import static java.lang.Double.NEGATIVE_INFINITY;
import static java.lang.Double.POSITIVE_INFINITY;

public class User {
	public static void main(String[] args) {
		Interval negativeNumbers = anInterval()
				.from(NEGATIVE_INFINITY, INCLUSIVE)
				.to(0., EXCLUSIVE)
				.build();

		Interval positiveNumbers = anInterval().from(0., EXCLUSIVE).to(POSITIVE_INFINITY, INCLUSIVE).build();

		Interval wholeNumberLine = anInterval().from(NEGATIVE_INFINITY, INCLUSIVE).to(POSITIVE_INFINITY, INCLUSIVE).build();

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
				.to(upperBound, upperBoundType)
				.build();
	}
}
