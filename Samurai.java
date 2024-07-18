import java.util.Scanner;

public class Samurai extends Warriors {


    private String Armor;

    private String weapon;

    //constructor for samurai
    public Samurai(){
    }

    //constructor only taking in a name
    public Samurai(String Name){
        super(Name);

    }
    //main constructor for samurai
    public Samurai(String name,String Armor,String Weapon){
        super(name,Armor,Weapon, 25);

    }


    //gives option for choosing a weapon
    public void Chosen_Weapon(String weapon) {
        Scanner input = new Scanner(System.in);
        while (!weapon.toLowerCase().equals("katana") && !weapon.toLowerCase().equals("nodachi")) {
            System.out.println("Please choose Katana or Nodachi.");
            weapon = input.nextLine();

        }
        super.setWeapon(weapon);
    }

    //gives option for choosing armor
    public void Chosen_Armor(String armor){
        Scanner input = new Scanner(System.in);

        while (!armor.toLowerCase().equals("chest plate") && !armor.toLowerCase().equals("helmet") && !armor.toLowerCase().equals("gauntlets")) {
            System.out.println("Please choose, Chest plate, Helmet, or Gauntlets.");
            armor = input.nextLine();
        }

        super.setArmor(armor);
    }



    public String toString(){
        return "Samurai Name: " +  super.Name +  " | "+ "Weapon: " + super.Weapon + " | "+"Armor: " + super.Armor + " | "+ "Health: " +  super.Health;
    }
}
