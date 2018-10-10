package pkjaya;

class DrawCircle {

	// Mid-Point Algorithm
	
	public static void midPointCircleDraw(int coord_X, int coord_Y, int r) {
		int x = r, y = 0;
		System.out.print("(" + (x + coord_X) + ", " + (y + coord_Y) + ")");
		
		if (r > 0) {
			System.out.print("(" + (x + coord_X) + ", " + (-y + coord_Y) + ")");
			System.out.print("(" + (y + coord_X) + ", " + (x + coord_Y) + ")");
			System.out.println("(" + (-y + coord_X) + ", " + (x + coord_Y) + ")");
		}
		int d = 1 - r;
		while(x > y){
			y++;
			if (d <= 0) d += 2 * y + 1;
			else {
				x--;
				d += 2 * y - 2 * x + 1;
			}
			if (x < y)
				break;
		
			System.out.print("(" + (x + coord_X) + ", " + (y + coord_Y) + ")");
			System.out.print("(" + (-x + coord_X) + ", " + (y + coord_Y) + ")");
			System.out.print("(" + (x + coord_X) + ", " + (-y + coord_Y) + ")");
			System.out.println("(" + (-x + coord_X) + ", " + (-y + coord_Y) + ")");
			if (x != y) {
				System.out.print("(" + (y + coord_X) + ", " + (x + coord_Y) + ")");
				System.out.print("(" + (-y + coord_X) + ", " + (x + coord_Y) + ")");
				System.out.print("(" + (y + coord_X) + ", " + (-x + coord_Y) + ")");
				System.out.println("(" + (-y + coord_X) + ", " + (-x + coord_Y) + ")");
			}
		}
	}

	public static void main(String[] args) {
		midPointCircleDraw(1, 1, 10);
		System.out.println("---------------");
		midPointCircleDraw(2, 2, 9);
		System.out.println("---------------");
		midPointCircleDraw(3, 3, 8);
		System.out.println("---------------");
		midPointCircleDraw(4, 4, 7);
		System.out.println("---------------");
		midPointCircleDraw(5, 5, 6);
		System.out.println("---------------");
		midPointCircleDraw(6, 6, 5);
		System.out.println("---------------");
		midPointCircleDraw(7, 7, 4);
		System.out.println("---------------");
		midPointCircleDraw(8, 8, 3);
		System.out.println("---------------");
		midPointCircleDraw(9, 9, 2);
		System.out.println("---------------");
		midPointCircleDraw(10, 10, 1);		
		System.out.println("---------------");
	}
}