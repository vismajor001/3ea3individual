package Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Model {
	public static final String fileName = "data/savedData.txt";
	private Transaction[] transactionList = new Transaction[10];
	private int N = 0;

	public Model() {
		open();
	}
	// push a transaction into a array, the location depend on int N//
	public void add(Transaction b) {
		if (N < transactionList.length) {
			transactionList[N] = b;
			N++;
		} else {
			// resize the array
			transactionList = Resize.resizeArray(transactionList);
			transactionList[N] = b;
			N++;
		}

	}

	// save the an array into txt file ,number of row and colume first because
	// it needs the [row][col] for loading//
	public void save() {
		PrintWriter writer;
		try {
			writer = new PrintWriter(fileName);

			for (Transaction i : transactionList) {
				if (i==null) break;
				writer.println(i.toString());
			}
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Cannot find the output file");
		}
	}

	public void open() {
		Scanner scanner;
		try {
			scanner = new Scanner(new File(fileName));

			// file format: "amount,description,date,user"
			while (scanner.hasNextLine()) {
				String current = scanner.nextLine();
				String[] lst = current.split(",");
				Transaction t = new Transaction(Float.parseFloat(lst[0]),
						lst[1], lst[2], lst[3]);
				add(t);
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Cannot find the input file");
		}
	}
	public Transaction[] getTransactionList(){
		return transactionList;
	}

	

}
