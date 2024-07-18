import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;


public class WarriorManager implements DataStructureWrapper<Warriors> {

    //list for storing objects of warrior type
    ArrayList <Warriors> thelist = new ArrayList<>();



    public String toString() {
        return thelist.toString() + "\n";
    }


    @Override
    //method for adding in objects to the list
    public void addData(Warriors data) {
        thelist.add(data);
    }

    //checking to see if the object is the in the list, if so removes it.
    public Warriors removeData(Warriors data) throws IOException {
        for (int i = 0; i < thelist.size(); i++) {
            if (thelist.get(i).Name.contains(data.Name)) {
                thelist.remove(i);
            }
        }
        return data;
    }

    //sorts list by health level.
    public void sortData() {
        Collections.sort(thelist);
    }


    @Override
    //searching for a warrior, if the warrior is in the list, returns true
    public boolean searchFor(Warriors data) {
        for(int i = 0; i < thelist.size(); i++){
            if (thelist.get(i).Name.contains(data.Name)) {
                System.out.println(thelist.get(i)  + " is in the list.");
                return true;
            }
        }

        System.out.println(data + " was not in the list.");
        return false;
    }


}