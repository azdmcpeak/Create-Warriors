import java.util.Scanner;

public class Viking extends Warriors {


    private String Armor;

    private String weapon;


    //constructor for viking
    public Viking() {
    }

    //main constructor for viking
    public Viking(String name, String Armor, String Weapon) {
        super(name, Armor, Weapon, 16);
    }

    //constructor that only takes in a name
    public Viking(String Name){
        super(Name);

    }

    //choosing a weapon
    public void Chosen_Weapon(String weapon) {
        Scanner input = new Scanner(System.in);

        while (!weapon.toLowerCase().equals("axe") && !weapon.toLowerCase().equals("ulfberht")) {
            System.out.println("Please enter Axe or Ulfberht.");
            weapon = input.nextLine();
        }

        super.setWeapon(weapon);
    }

    //choosing armor
    public void Chosen_Armor(String armor) {
        Scanner input = new Scanner(System.in);

        while (!armor.toLowerCase().equals("chest plate") && !armor.toLowerCase().equals("helmet") && !armor.toLowerCase().equals("gauntlets")) {
            System.out.println("Please choose, Chest plate, Helmet, or Gauntlets.");
            armor = input.nextLine();
        }

        super.setArmor(armor);

    }




    public String toString() {
        return "Viking Name: " + super.Name + " | "+ "Weapon: " + super.Weapon +  " | "+ "Armor: " + super.Armor +  " | "+"Health: " + super.Health ;
    }
}
