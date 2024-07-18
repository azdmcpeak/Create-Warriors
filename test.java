import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class test {
    public static void main(String[] args) throws IOException {

        //scanner for the user input
        Scanner input = new Scanner(System.in);

        //importing spartan class
        Spartan spartan = new Spartan();

        //importing samurai class
        Samurai samurai = new Samurai("","","");

        //importing viking class
        Viking viking = new Viking("","","");

        //importing warrior manager class
        WarriorManager WM = new WarriorManager();


        //list to store the warriors to import them to Warrior manager class
        ArrayList<String> thelist = new ArrayList<>();

        String filename = "Text.txt";

        //reading in a text file.
        File file = new File(filename);

        //Scanner for scanning in the data for the file
        Scanner scan = new Scanner(file);

        //while loop for reading in each line of the file and writing it to the array list
        while (scan.hasNextLine()){
            thelist.add(scan.nextLine());
        }

        //for loop to taking in each element of the arraylist, break it down into sections of...
        //name, weapon, armor and health.
        //take those individual substrings to make up a warrior to place that warrior into the warrior management class
        for (String s : thelist) {
            //name
            int startname = s.indexOf("Name") + 6;
            int endname = s.indexOf("|");
            String name = s.substring(startname, endname);


            //weapon
            int startwep = s.indexOf("Weapon") + 8;
            int endwep = s.indexOf("Armor") - 3;
            String weapon = s.substring(startwep, endwep);

            //armor
            int startarmor = s.indexOf("Armor") + 6;
            int endarmor = s.indexOf("Health") - 3;
            String armor = s.substring(startarmor, endarmor);

            //health

            int starthealth = s.indexOf("Health") + 8;
            int Health = Integer.parseInt(s.substring(starthealth));

            Warriors warriors = new Warriors(name, armor, weapon,Health);
            WM.addData(warriors);
        }


        //condition for loop
        boolean continueloop = true;

        //loop to prompt user to create a warrior, remove an exiting warrior, search for a warrior or exit the loop.
        while (continueloop){
            System.out.println("Would you like to Create, Remove ,Search or Exit?");
            String response = input.nextLine();

            //option for exiting the loop
            if(response.equalsIgnoreCase("exit")){
                break;
            }

            //option for creating a warrior
            if (response.equalsIgnoreCase("create")) {

                System.out.println("Would you like to create a Spartan, Samurai or Viking?");
                String Userinput = input.nextLine();

                //condition for creating spartan
                if (Userinput.equalsIgnoreCase("spartan")) {
                    System.out.println("Choose a name for your Spartan: ");
                    String name = input.nextLine();


                    System.out.println("Lets pick out a weapon. Dory or xiphos? ");
                    String weapon = input.nextLine();
                    //calling weapon method from spartan class
                    spartan.Chosen_Weapon(weapon);

                    System.out.println("Lets get some protection. You get one piece, choose wisely. Chest plate, Helmet or Gauntlets");
                    String armor = input.nextLine();
                    //calling armor method from spartan class
                    spartan.Chosen_Armor(armor);

                    //adding the spartan to the Warrior manager class
                    WM.addData(new Spartan(name, spartan.getArmor(), spartan.getWeapon()));

                    //writing the spartan to the text file
                    FileWriter(filename, new Spartan(name, spartan.getArmor(), spartan.getWeapon()));


                    //option for creating samurai
                } else if (Userinput.equalsIgnoreCase("samurai")) {
                    System.out.println("Choose a name for your Samurai: ");
                    String name = input.nextLine();


                    System.out.println("Lets pick out a weapon. Katana or Nodachi? ");
                    String weapon = input.nextLine();
                    //calling weapon method from samurai class
                    samurai.Chosen_Weapon(weapon);

                    System.out.println("Lets get some protection. You get one piece, choose wisely. Chest plate, Helmet or Gauntlets");
                    String armor = input.nextLine();
                    //calling armor method from samurai class
                    samurai.Chosen_Armor(armor);

                    //adding samurai to Warrior manager class
                    WM.addData(new Samurai(name, armor, weapon));

                    //writing the samurai to the file
                    FileWriter(filename, new Samurai(name, samurai.getArmor(), samurai.getWeapon()));

                    //option for creating a viking
                } else if (Userinput.equalsIgnoreCase("viking")) {
                    System.out.println("Choose a name for your Viking: ");
                    String name = input.nextLine();


                    System.out.println("Lets pick out a weapon. Axe or Ulfberht? ");
                    String weapon = input.nextLine();
                    //calling method for weapon creation from viking class
                    viking.Chosen_Weapon(weapon);

                    System.out.println("Lets get some protection. You get one piece, choose wisely. Chest plate, Helmet or Gauntlets");
                    String armor = input.nextLine();
                    //calling method for armor creation from viking class
                    viking.Chosen_Armor(armor);

                    //adding viking to the warrior manager class
                    WM.addData(new Viking(name, armor, weapon));
                    //writing the viking to the file
                    FileWriter(filename, new Viking(name, viking.getArmor(), viking.getWeapon()));
                }

                //loop for running through the warrior creator again
                //if the user enters no, sets continueloop to false.
                System.out.println("Do you want to create another Warrior? Yes or No?");
                String again = input.nextLine();
                if (again.equalsIgnoreCase("no")) {
                    continueloop = false;
                }

            //option for the user to removing a warrior
            } if (response.equalsIgnoreCase("remove")){
                for(Object s: thelist){
                    System.out.println(s);
                }

                //prompting for the removal of a spartan, samurai or a viking
                System.out.println("Would you like to remove for a Spartan, Samurai or Viking?");
                String userresponse = input.nextLine();

                //if the user chooses spartan
                if(userresponse.equalsIgnoreCase("spartan")){
                    System.out.println("What is the name of the Spartan you want to remove");
                    userresponse = input.nextLine();
                    //creates a new spartan for searching with the name of the spartan the user wants to delete
                    Spartan deletespartan = new Spartan(userresponse);
                    //using that new spartan for calling the remove
                    WM.removeData(deletespartan);
                }

                //if the user chooses samurai
                if(userresponse.equalsIgnoreCase("samurai")){
                    System.out.println("What is the name of the Samurai you want to search for?");
                    userresponse = input.nextLine();
                    //creating a new samurai for searching for the samurai they want to delete.
                    Samurai deletesamurai = new Samurai(userresponse);
                    //calling method from warrior manager class to remove the the samurai
                    WM.removeData(deletesamurai);
                }

                //if the user chooses viking
                if(userresponse.equalsIgnoreCase("viking")){
                    System.out.println("What is the name of the Viking you want to search for?");
                    userresponse = input.nextLine();
                    //creating a new viking with the name of the viking t he user wants to delete
                    Viking deleteviking = new Viking(userresponse);
                    //calling remove method from warrior manager class
                    WM.removeData(deleteviking);
                }
                //printing list to verify the warrior was deleted
                System.out.println(WM);

            }


            //if  the user chooses search
            if(response.equalsIgnoreCase("search")){
                System.out.println("Would you like to search for a Spartan, Samurai or Viking?");
                String userresponse = input.nextLine();

                if(userresponse.equalsIgnoreCase("spartan")){
                    System.out.println("What is the name of the Spartan you want to search for?");
                    userresponse = input.nextLine();
                    //creating spartan with the name of  the spartan the user wants to search for
                    Spartan searchyspartan = new Spartan(userresponse);
                    //calling search method from warrior manager class
                    WM.searchFor(searchyspartan);
                }


                if(userresponse.equalsIgnoreCase("samurai")){
                    System.out.println("What is the name of the Samurai you want to search for?");
                    userresponse = input.nextLine();
                    //creating samurai with the name of  the samurai the user wants to search for
                    Samurai searchysamurai = new Samurai(userresponse);
                    //calling search method from warrior manager class
                    WM.searchFor(searchysamurai);
                }


                if(userresponse.equalsIgnoreCase("viking")){
                    System.out.println("What is the name of the Viking you want to search for?");
                    userresponse = input.nextLine();
                    //creating viking with the name of  the viking the user wants to search for
                    Viking searchyviking = new Viking(userresponse);
                    //calling search method from warrior manager class
                    WM.searchFor(searchyviking);
                }


            }
        }

        WM.sortData();

        }







    public static void FileWriter(String TheFileName, Warriors warriors) throws IOException {

        //holding the name of the file to write to
        String filename = TheFileName;
        //creating file writer, passing it the filename to write to
        FileWriter writer = new FileWriter(filename,true);
        //creating bufferedwriter and passing it writer
        BufferedWriter bw = new BufferedWriter(writer);
        //writes the string value of warriors to the list
        bw.write(String.valueOf(warriors));
        //writing a new line for new warriors to be written to
        bw.newLine();
        //closing the file
        bw.close();
    }


}
