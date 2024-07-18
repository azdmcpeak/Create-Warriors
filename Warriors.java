public class Warriors implements Comparable<Warriors> {

    //name for warrior
    protected String Name;

    //health for warrior
    protected int Health;

    //armor for warrior
    protected String Armor;

    //weapon for warrior
    protected String Weapon;

    //generic constructor for warrior
    public Warriors() {
    }

    //main constructor for the warrior class
    public Warriors(String TheName, String armor, String weapon, int health) {
        this.Name = TheName;
        this.Armor = armor;
        this.Weapon = weapon;
        this.Health = health;

    }



    //constuctor taking in only a name
    public Warriors(String name) {
        this.Name = name;
    }


    public String getArmor() {
        return Armor;
    }

    public void setArmor(String armor) {
        this.Armor = armor;
    }

    public String getWeapon() {
        return Weapon;
    }


    public void setWeapon(String weapon) {
        this.Weapon = weapon;
    }


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getHealth() {
        return Health;
    }

    public void setHealth(int health) {
        this.Health = health;
    }

    public String toString(){
        return "Samurai Name: " +  this.Name +  " | "+ "Weapon: " + this.Weapon + " | "+"Armor: " + this.Armor + " | "+ "Health: " +  this.Health;
    }

    //comparator for warriors
    public int compareTo(Warriors w) {
        if (this.Health > w.Health) {
            return -1;
        } else if (this.Health < w.Health) {
            return 1;
        } else {
            return 0;
        }
    }


}
