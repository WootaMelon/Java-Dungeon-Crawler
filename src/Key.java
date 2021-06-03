
public class Key extends Item {
	public Key(int id,String shape, int size, String color) {
		super(id,shape, size, color);

	}

	public boolean isBig() {
		if (size > 2)
			return true;
		return false;
	}

	public String toString() {
		return "Key: " + shape + ", size: " + size + ", color: " + color + ", id: " + id;
	}
}
