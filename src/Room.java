
public class Room implements RoomStats {
	private int ID;
	private String Doorcolor;
	private double length;
	private double width;
	private Item item;
	private int EnemyHP;

	public Room(int iD, String doorcolor, double length, double width, Item item, int EnemyHP) {
		super();
		ID = iD;
		Doorcolor = doorcolor;
		this.length = length;
		this.width = width;
		this.item = item;
		this.EnemyHP = EnemyHP;
	}

	public int getEnemyHP() {
		return EnemyHP;
	}

	public void setEnemyHP(int enemyHP) {
		EnemyHP = enemyHP;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getDoorcolor() {
		return Doorcolor;
	}

	public void setDoorcolor(String doorcolor) {
		Doorcolor = doorcolor;
	}

	public boolean isSafe() {
		if (Doorcolor.equals("Green"))
			return true;
		return false;
	}

	public double CalcArea() {
		return length * width;
	}

	public String toString() {
		return "ID: " + ID + "\nDoor Color: " + Doorcolor + "\nLength: " + length + "\nWidth: " + width
				+ "\nContains Item: " + item;
	}
}
