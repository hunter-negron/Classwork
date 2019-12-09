public class UseGeometric {

	public static void main(String[] args) {
	
		GeometricFigure[] figures = new GeometricFigure[10];
		
		for(int i = 0; i < 5; i++) {
		
			figures[i] = new Square(3, i + 1);
		}
		
		for(int i = 5; i < 10; i++) {
		
			figures[i] = new Triangle(3, i + 1);
		}
		
		for(GeometricFigure g : figures) {
		
			System.out.println(g.area());
		}
	}
}
