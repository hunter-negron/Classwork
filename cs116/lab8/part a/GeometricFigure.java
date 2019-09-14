public abstract class GeometricFigure {

	protected int height;
	protected int width;
	protected double area;
	
	public GeometricFigure() {
	
		height = 0;
		width = 0;
		area = 0.0;
	}
	
	public GeometricFigure(int h, int w) {
	
		height = h;
		width = w;
	}
	
	public abstract double area();
	
	public int getHeight() {
	
		return height;
	}
	
	public int getWidth() {
	
		return width;
	}
	
	public void setHeight(int h) {
	
		height = h;
	}
	
	public void setWidth(int w) {
	
		width = w;
	}
	
	public String toString() {
	
		String str = "";
		str = "Height: " + height + "\n";
		str += "width: " + width + "\n";
		return str;
	}
}
