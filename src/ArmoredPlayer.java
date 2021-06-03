
public class ArmoredPlayer extends Player {
	private int ArmorAmount;

	public ArmoredPlayer(String name, double height, double hP, int armorAmount, Inventory Backpack) {
		super(name, height, hP, Backpack);
		ArmorAmount = armorAmount;
		this.HP = hP;
		HP += ArmorAmount;
	}

	public double increaseHP(int amount) {

		HP += amount;
		return HP;
	}

	public double decreaseHP(int amount) {

		HP -= amount;
		return HP;
	}

	public String toString() {
		return "Player Name: " + name + "\nPlayer Height: " + height + "\nTotal Player Health Points With Armor: " + HP
				+ "\nArmor Amount:" + ArmorAmount +"\n";
	}
}
