public class UseGeometric2 {

	public static void main(String[] args) {
	
		GeometricFigure2[] figures = new GeometricFigure2[10];
		
		for(int i = 0; i < 5; i++) {
		
			figures[i] = new Square2(3, i + 1);
		}
		
		for(int i = 5; i < 10; i++) {
		
			figures[i] = new Triangle2(3, i + 1);
		}
		
		for(GeometricFigure2 g : figures) {
		
			g.displaySides();
		}
	}
}
