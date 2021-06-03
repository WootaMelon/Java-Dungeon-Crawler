
public abstract class Item implements ItemStats {
	protected String shape;
	protected int size;
	protected String color;
	protected int id;
	
	public Item(int id,String shape, int size, String color) {
		this.shape = shape;
		this.size = size;
		this.color = color;
		this.id = id;
	}

	public String getShape() {
		return shape;
	}

	public void setShape(String shape) {
		this.shape = shape;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public abstract boolean isBig();
	

	public String toString() {
		return "Item: " + shape + ", size: " + size + ", color: " + color + ", id: " + id;
	}

}
