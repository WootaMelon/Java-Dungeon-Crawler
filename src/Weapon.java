
public class Weapon extends Item {
	private int DMG;

	public Weapon(int id,String shape, int size, String color,  int DMG) {
		super(id, shape,size, color);
		this.DMG = DMG;
	}

	public boolean isBig() {
		if (size > 7)
			return true;
		return false;
	}

	public int getDMG() {
		return DMG;
	}

	public void setDMG(int dMG) {
		DMG = dMG;
	}

	public String toString() {
		return "Weapon: " + shape + ", size: " + size + ", color: " + color + ", id: " + id + ", DMG: " + DMG;
	}
}
