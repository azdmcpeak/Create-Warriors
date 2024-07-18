import java.io.IOException;

public interface DataStructureWrapper<T>  {

	// Add and remove data in your underlying data structure.
	public void addData(T data);


	public T removeData(T data) throws IOException;


	// Sort the data in the underlying data structure using a Comparator.
	public void sortData();
	
	// Return true/false for whether or not data is in your data structure.
	public boolean searchFor(T data);
	
	// Return a String representation of the entire data structure.
	// Be sure and implement toString in all your classes and call 
	// that on each data element.
	public String toString();
}
