package pattern;

public class Geometry {
	public static void main(String[] args) {
		printObject(new Rectangle(5, 7));
		printObject(new Rectangle(4, 2));
	}

	private static void printObject(Object obj) {
		if (obj instanceof Rectangle rectangle) {
			System.out.println("rectangle = " + rectangle);
		}
	}
}
