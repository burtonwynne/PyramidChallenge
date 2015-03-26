import java.util.ArrayList;

public class Pyramid {
	public static void main(String[] args) {
		
		int numberOfRows = -1;//the depth of the pyramid.
		if(args.length == 0){
			System.out.println("Command: java Pyramid <2-26>");
			System.exit(1);
		}else{
			try{
				numberOfRows = Integer.parseInt(args[0]);
				if(numberOfRows < 2){
					System.out.println("Argument '" + args[0] + "' must be greater than 1.");
					System.exit(1);
				}else if(numberOfRows > 26){
					System.out.println("Argument '" + args[0] + "' must be less than 26.");
					System.exit(1);
				}else{
					System.out.println("Numbers of rows: " + numberOfRows);
				}
			}catch(NumberFormatException nfe){
				System.out.println("Argument '" + args[0] + "' is not a number.");
				System.exit(1);
			}
		}
		
		ArrayList<Integer> currentRow = new ArrayList<Integer>();
		ArrayList<Integer> previousRow = null;
		currentRow.add(1);//the first row "1"
		printRow(currentRow, 1);
		for(int index = 1; index < numberOfRows; index++){
			previousRow = currentRow;
			currentRow = getNextRow(previousRow);
			printRow(currentRow, index + 1);
		}
	}
	
	public static void printRow(ArrayList<Integer> row, int rowNumber){
		StringBuffer buffer = new StringBuffer();
		buffer.append("Row ").append(rowNumber).append(": ");
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
