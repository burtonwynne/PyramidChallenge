import java.util.ArrayList;

public class Pyramid {

	public static void main(String[] args) {
		int numberOfRows = 9;//the depth of the pyramid.
		ArrayList<Integer> currentRow = new ArrayList<Integer>();
		ArrayList<Integer> previousRow = null;
		currentRow.add(1);//the first row "1"
		printRow(currentRow);
		for(int index = 0; index < (numberOfRows - 1); index++){
			previousRow = currentRow;
			currentRow = getNextRow(previousRow);
			printRow(currentRow);
		}
	}
	
	public static void printRow(ArrayList<Integer> row){
		StringBuffer buffer = new StringBuffer();
		for (int value : row) {
			buffer.append(value);
			buffer.append(" ");
		}
		System.out.println(buffer.toString());
	}
	
	public static ArrayList<Integer>getNextRow(ArrayList<Integer> oldRow){
		ArrayList<Integer> nextRow = new ArrayList<Integer>();
		int currentValue = oldRow.get(0);//set the current value to the first value in the row.
		int count = 0;// initialize count to zero.
		
		//iterate through all values in the row.
		for (int value: oldRow) {
			//if the current value is equal to the 
			//iterated value then increment the count.
			if(value == currentValue){
				count++;
			}else{
			//other wise add the count and current value
			// to the new row.  Set the current value to 
			// the iterated value
				nextRow.add(count);
				nextRow.add(currentValue);
				currentValue = value;
				count = 1;
			}
		}
		//Finally add the final count and value
		//to the new row.
		nextRow.add(count);
		nextRow.add(currentValue);
		return nextRow;
	}
}
