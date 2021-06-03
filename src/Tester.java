import java.util.ArrayList;
import java.util.Scanner;

public class Tester {
	public static void main(String[] args) {
		
		Scanner scan= new Scanner(System.in);
		
		ArrayList<Item> items = new ArrayList<>();
		Key keytest = new Key( 13,"Circle", 1, "Golden");
		items.add(new Key(12,"Triangle key",  1,"Brown"));
		items.add(new Key(14,"Square key",  1,"Black"));
		items.add(new Weapon( 1,"Sword", 4, "Silver", 150));
		Inventory Backpack = new Inventory(items);
		Room r1 = new Room(12, "Green", 12, 13, new Weapon(3,"Karambit",4, "Gold", 70), 50);
		Room r2 = new Room(14, "Purple", 12, 13, new Key(16,"Rectangle key",  1,"Black"), 70);
		Room r3 = new Room(16, "Green", 12, 13,new Weapon( 2,"Staff", 5, "Blue", 50), 100);
		Room r4 = new Room(18, "Green", 12, 13,new Weapon( 2,"Kitana", 25, "Purple", 40), 0);
		
		System.out.println("Enter one of two Player types:\nPlayer \t Armored Player");
		boolean v=false;
		Player p1=null;
		
		
		do {
			String x=scan.nextLine();
		if(x.equalsIgnoreCase("Player")) {
			v=true;
			System.out.println("Choose your name");
			String name = scan.next();
			System.out.println("Choose your height");
			double height=scan.nextDouble();
			 p1 = new Player(name,height ,200 , Backpack);
			
		}
		if(x.equalsIgnoreCase("Armored Player")){
			v=true;
				System.out.println("Choose your name");
				String name = scan.next();
				System.out.println("Choose your height");
				double height=scan.nextDouble();
				 p1 = new ArmoredPlayer(name,height ,200 ,100, Backpack);
					
	}
		if(!x.equalsIgnoreCase("Armored Player") &&!(x.equalsIgnoreCase("Player")))
		System.out.println("Invalid Player type, Try again.");
		
	}while(v==false);
		
		System.out.println("Succesfully created Player: \n" +p1);
		System.out.println("Current Inventory: ");
		Backpack.sortItems();
		Backpack.displayItems();
		boolean f=true;
		boolean m=true;
		
		
		System.out.println(p1.getName() + " has entered MAZE MANSION and is on the FIRST FLOOR.");
		System.out.println("On the first floor, "+ p1.getName()+ " found two rooms.");
		
		do {
			f=true;
		System.out.println("Enter one of the rooms, 1 or 2 or 3 or 4\n(5 to exit game)");
		int room=scan.nextInt();
		
		if(room==1) 
			p1.EnterRoom(r1);
		if(room==2)
			p1.EnterRoom(r2);
		if(room==3)
			p1.EnterRoom(r3);
		if(room==4) {
			p1.EnterRoom(r4);
			if(p1.insideRoom==null)
				System.out.println("Hint: Attack monster in Room2");
		}
		if(room==5) {
			m=false;}
			
		
		if(p1.getInsideRoom() instanceof Room) {
		do {
			System.out.println("1.Grab Item \n2.Attack\n3.Exit Room");
			int choice=scan.nextInt();
			if(choice==1) {
				p1.grabItem();
				p1.Backpack.sortItems();
				System.out.println("Current Inventory: ");
				p1.Backpack.displayItems();
			}
			if(choice==2) {
				
				System.out.println("Choose Your Weapon\nCurrent Weapons: ");
				for(int i=0;i<Backpack.getAllWeapons().size();i++)
				System.out.println(Backpack.getAllWeapons().get(i).getShape());
				String weap=scan.next();
				p1.attack(weap);
				boolean dropkey=false;
				if(dropkey==false) {
				if(p1.getInsideRoom() .equals(r2)) {
				if(p1.getInsideRoom().getEnemyHP()<0) {
					p1.Backpack.addItem(new Key(18,"Circle key",2,"Grey"));
					dropkey=true;
				}}}
				
			}
			if(choice==3) {
				f=false;
				System.out.println("Nothing Interesting left to see...");
				p1.exitRoom();
			}
			
	
			}while(f==true&&p1.getHP()>0);}
		
		}while(m==true&&p1.getHP()>0);	
		
		System.out.println("Game Ended.");
		}
		
	}
	
		
		
		
	

