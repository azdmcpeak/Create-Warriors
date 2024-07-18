import java.util.Scanner;

public class Spartan extends Warriors{

    //main constructor
    public Spartan(){
    }

    //constructor for taking only a name
    public Spartan(String Name){
        super(Name);

    }

    //primary constructor
    public Spartan(String Name,String Armor,String Weapon){
        super(Name,Armor,Weapon,20);
    }

    //constructor for choosing a weapon
    public void Chosen_Weapon(String weapon) {
        Scanner input = new Scanner(System.in);

        while (!weapon.toLowerCase().equals("dory") && !weapon.toLowerCase().equals("xiphos")) {
            System.out.println("Please choose Dory or Xiphos.");
            weapon = input.nextLine();
        }
        super.setWeapon(weapon);

    }


    //constructor for choosing a armor
    public void Chosen_Armor(String armor){
        Scanner input = new Scanner(System.in);

        while (!armor.toLowerCase().equals("chest plate") && !armor.toLowerCase().equals("helmet") && !armor.toLowerCase().equals("gauntlets")) {
            System.out.println("Please choose, Chest plate, Helmet, or Gauntlets.");
            armor = input.nextLine();
        }

        super.setArmor(armor);
    }



    public String toString(){
        return "Spartan Name: " +  super.Name + " | "+ "Weapon: " + super.Weapon + " | " + "Armor: " + super.Armor + " | " + "Health: " + super.Health;
    }



}
