package exercise;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class readFiles {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String[] information = { "TV LED,1290.99,1", "Video Game Chair,350.50,3", "Iphone,900.00,2",
				"Samsung Galaxy 9,850.00,2" };
		String path = sc.nextLine();
				
		String pathOutPut = sc.nextLine();

		ArrayList<String> outPutLines = new ArrayList<String>();
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
			int position = 0;
			for (String paramStr : information) {
				
				bw.write(paramStr);
				String[] splited = paramStr.split(",");
				
				Double objectValue = Double.parseDouble(splited[1]); 
				Integer objectQuantity = Integer.parseInt(splited[2]);
				
				objectToSell obejctSell = new objectToSell(splited[0], objectValue, objectQuantity);
				outPutLines.add(obejctSell.getObjectName() + "," + obejctSell.total(obejctSell));
				
				try (BufferedWriter bwOutput = new BufferedWriter(new FileWriter(pathOutPut))){		
					if (position == outPutLines.size() - 1) {
						for (String outLineParam : outPutLines) {	
							bwOutput.write(outLineParam);
							bwOutput.newLine();
						}
					}
				
				} catch (IOException e) {
					e.printStackTrace();
				}

				bw.newLine();
				position += 1;
			}
			
			for (String lineOutPut : outPutLines) {
				System.out.println(lineOutPut);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		finally {
			System.out.println("Finished !");
			sc.close();
		}
	}

}
