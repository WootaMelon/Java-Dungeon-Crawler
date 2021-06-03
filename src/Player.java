import java.util.ArrayList;
import java.util.Random;

public class Player {
	protected String name;
	protected double height;
	protected double HP;
	protected Inventory Backpack;
	protected Room insideRoom;

	public Player(String name, double height, double hP,  Inventory Backpack) {
		super();
		this.name = name;
		this.height = height;
		HP = hP;
		this.Backpack = Backpack;
		insideRoom = null;
	}

	public double increaseHP(int amount) {
		HP += amount;
		return HP;
	}

	public double decreaseHP(int amount) {
		HP -= amount;
		return HP;
	}

	public void EnterRoom(Room room) {
		if (insideRoom == null) {
			ArrayList<Key> temp = Backpack.getAllKeys();
			for (int i = 0; i < temp.size(); i++) {
				if (room.getID() == temp.get(i).getId()) {
					insideRoom = room;
					
				}
			}

			if (insideRoom instanceof Room) {
				System.out.println(name + " has entered the room");

				if (!room.isSafe()) {
					decreaseHP(40);
				System.out.println("The room is poisonous!\nPlayer HP: "+this.getHP()+"\n");}
			} else {
				System.out.println("Corresponding key not found");
			}
		} else {
			System.out.println(name + " is already in a room\n");
		}

	}

	public void grabItem() {
		if (insideRoom instanceof Room) {
			if(insideRoom.getItem() instanceof Item) {
				System.out.println(name + " found a "+insideRoom.getItem().getShape() +" on the desk.");
				Backpack.addItem(insideRoom.getItem());
				if(!insideRoom.getItem().isBig()) {
			System.out.println(insideRoom.getItem().getShape() + " was succesfully added");
			insideRoom.setItem(null);}
				
					
			}
			else
				System.out.println("Room does not contain any items.\n");
		}
		else
			System.out.println(name + "is not in a room.\n");
		
	}

	public void attack(String s) {
		Random rand = new Random();
		if (insideRoom instanceof Room) {
			if(insideRoom.getEnemyHP()>0) {
		ArrayList<Weapon> temp = Backpack.getAllWeapons();
		Weapon w1 = null;
		for (int i = 0; i < temp.size();i++) {
			if (temp.get(i).shape.equalsIgnoreCase(s)) {
			w1 = temp.get(i);
			break;}
		}
		if(w1 ==null) {
			System.out.println("Weapon not found.");
		}
		else {
			if(rand.nextInt(10)>2) {
			System.out.println("Suddenly, a wild monster appeared.\n"+name + " decided to attack.");
		int weapondmg = w1.getDMG();
			int oldhp=insideRoom.getEnemyHP();
			insideRoom.setEnemyHP(insideRoom.getEnemyHP() - weapondmg);
			
	
			if(insideRoom.getEnemyHP()<=0) {
				System.out.println("Enemy has died.");}
			else {
				System.out.println("Old Enemy HP: "+oldhp);
				System.out.println("Enemy HP: " +insideRoom.getEnemyHP()+"\n");}}
			else {
				
				this.setHP(this.getHP()-20);
				System.out.println("Suddenly, a wild monster appeared.\n"+name + " decided to attack.");
				System.out.println("You missed!"+ "\nPlayer HP: " +this.getHP()+"\n");}}
		}
			else
				System.out.println("Room does not have any enemies.\n");
			
			}
		else
			System.out.println(name + "is not in a room.\n");
		
	}
	
	public void exitRoom() {
		insideRoom=null;
		System.out.println(name+" decided to leave the room.\n");
	}
	
	

	public double getHP() {
		return HP;
	}

	public void setHP(double hP) {
		HP = hP;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

	public Room getInsideRoom() {
		return insideRoom;
	}

	public void setInsideRoom(Room insideRoom) {
		this.insideRoom = insideRoom;
	}

	public String toString() {
		return "Player Name: " + name + "\nPlayer Height: " + height + "\nPlayer Health Points: " + HP +"\n";
	}

}
