package models;

public class BGBean {

	int red, green, blue;

	public BGBean() {
		super();
		
		this.red = 255;
		this.green = 0;
		this.blue = 0;
	}

	public void setBlue (int blue) {
		this.blue = blue;
	}
	public int getR() {
		return red;
	}

	public void setR(int r) {
		this.red = r;
	}

	public int getG() {
		return green;
	}

	public void setG(int g) {
		this.green = g;
	}

	public int getB() {
		return blue;
	}

	public void setB(int b) {
		this.blue = b;
	}
	
	
	
}
