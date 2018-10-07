package pkjaya;

public class DrawLineMethod {

	void undefinedLine(int x1, int y1, int x2, int y2) {
		for (int i = Math.min(y1, y2); i <= Math.max(y1, y2); i++)
			System.out.println("X --> " + x1 + " Y --> " + i);
	}

	void mathMethod(int x1, int y1, int x2, int y2) {
		System.out.println("Math Method \nBetween (" + x1 +"," + y1 +")" + " & (" + x2 +"," + y2 +")");
		// Undefined Equation m = 1/0
		if (x2 - x1 == 0)
			undefinedLine(x1, y1, x2, y2);

		// Normal Line Equation
		else {
			double m = (float) (y2 - y1) / (x2 - x1);
			double b = y1 - (m * x1);
			for (int i = Math.min(x1, x2); i <= Math.max(x1, x2); i++)
				System.out.println("X --> " + (int) Math.round(i) + " Y --> " + (int) Math.round((m * i) + b));
		}
	}

	void incrementalMethod(int x1, int y1, int x2, int y2) {
		System.out.println("Incremental Method \nBetween (" + x1 +"," + y1 +")" + " & (" + x2 +"," + y2 +")");

		// to save the values and add slope
		int mini;
		double yPlusSlope,xPlusSlope = Math.min(x1, x2);

		// Undefined Equation m = 1/0
		if (x2 - x1 == 0)
			undefinedLine(x1, y1, x2, y2);

		// Normal Line Equation
		else {
			double m = (float) (y2 - y1) / (x2 - x1);
			// slope less than or equal 1
			if (Math.abs(m) <= 1) {
				yPlusSlope = x2 == (mini = Math.min(x1, x2)) ? y2 : y1;
				for (int i = Math.min(x1, x2); i <= Math.max(x1, x2); i++) { 
					System.out.println("X --> " + (int) Math.round(i) + " Y --> " + (int) Math.round(yPlusSlope));
					yPlusSlope += m;
				}
			}
			else {
				// slope more than 1
				xPlusSlope = y2 == (mini = Math.min(y1, y2)) ? x2 : x1;
				for (int i = Math.min(y1, y2); i <= Math.max(y1, y2); i++) {
					System.out.println("X --> " + (int) Math.round(xPlusSlope) + " Y --> " + i);
					xPlusSlope += (1.0 / m);
				}
			}
		}
	}

	void midPointMethod(int x1, int y1, int x2, int y2) {
		System.out.println("Mid-Point Method \nBetween (" + x1 +"," + y1 +")" + " & (" + x2 +"," + y2 +")");

		// Undefined Equation m = 1/0
		if (x2 - x1 == 0)
			undefinedLine(x1, y1, x2, y2);

		// Normal Line Equation
		else {
			// Math Calculations
			int dx = x2 - x1;
			int dy = y2 - y1;
			int d = 2 * dy - (dx);
			int increE = 2 * dy;
			int incrNE = 2 * (dy-dx);
			double yPlusD = y1;
			int incrY = (int) Math.round(1.0 * (y2 - y1) / (x2 - x1));

			for (int i = x1 + 1; i < x2; i++) {

				// East Direction
				if (d <= 0) {
					System.out.print("E ");
					d += increE;
				} else {
					System.out.print("NE ");
					d += incrNE;
					yPlusD += incrY;
				}
				System.out.println("X --> " + (int) Math.round(i) + " Y --> " + (int) Math.round(yPlusD));
			}
		}
	}

	public static void main(String[] args) {
		DrawLineMethod graphics = new DrawLineMethod();
		for (int i = 0; i < 10; i++) {
			graphics.mathMethod((int) (Math.random() * 101), (int) (Math.random() * 101), (int) (Math.random() * 101),
					(int) (Math.random() * 101));
			System.out.println("\n- Hassan Elseoudy -\n");
		}
		for (int i = 0; i < 10; i++) {
			graphics.incrementalMethod((int) (Math.random() * 101), (int) (Math.random() * 101),
					(int) (Math.random() * 101), (int) (Math.random() * 101));
			System.out.println("\n- Hassan Elseoudy -\n");
		}
		for (int i = 0; i < 10; i++) {
			graphics.midPointMethod(1,1,5,3);
			System.out.println("\n- Hassan Elseoudy -\n");
		}
	}

}
