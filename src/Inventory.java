import java.util.ArrayList;

public class Inventory {
	protected ArrayList<Item> Inv;

	public Inventory(ArrayList<Item> inv) {
		super();
		Inv = inv;
	}

	public boolean isEmpty() {
		if (Inv.size() == 0) {
			
			return true;}
		return false;
	}

	public void addItem(Item item) {
		if (!item.isBig()) {
			Inv.add(item);
	//	System.out.println("Item has been added.");
			}
		else{
			System.out.println("Item is too big!");
		}
	}

	public void deleteItem(Item item) {
		Inv.remove(item);
		System.out.println("Item has been removed.");
	}

	
	public void sortItems() {
		for (int i = 0; i < Inv.size(); i++) {
			for (int j = i + 1; j < Inv.size(); j++) {
				if (Inv.get(i).getId() > Inv.get(j).getId()) {
					Item temp = Inv.get(i);
					Inv.set(i, Inv.get(j));
					Inv.set(j, temp);
				}
			}
		}
	}

	public ArrayList<Key> getAllKeys() {
		ArrayList<Key> temp = new ArrayList<>();
		for (int i = 0; i < Inv.size(); i++) {
			if (Inv.get(i) instanceof Key)
				temp.add((Key) Inv.get(i));
		}
		return temp;
	}

	public ArrayList<Weapon> getAllWeapons() {
		ArrayList<Weapon> temp = new ArrayList<>();
		for (int i = 0; i < Inv.size(); i++) {
			if (Inv.get(i) instanceof Weapon)
				temp.add((Weapon) Inv.get(i));
		}
		return temp;
	}

	public Key searchKey(int id) {
		for (int i = 0; i < Inv.size(); i++) {
			if (Inv.get(i).getId() == id) {
				System.out.println((Key) Inv.get(i));
				return (Key) Inv.get(i);
			}
		}
		System.out.println("No Such Key is Found.");
		return null;
	}

	public void displayItems() {
		System.out.println();
		for (int i = 0; i < Inv.size(); i++) {
			System.out.println(Inv.get(i));
		}
		System.out.println();
	}

}
