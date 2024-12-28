package exercise;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class readFiles {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String[] information = { "TV LED,1290.99,1,Electronics", "Video Game Chair,350.50,3,Furniture", "Iphone,900.00,2,Electronics",
				"Samsung Galaxy 9,850.00,2,Electronics", "Table for 6 people,950.00,4,Furniture" };
		String path = sc.nextLine();
				
		String pathOutPut = sc.nextLine();
		
		boolean newFileTypes = new File(path + "\\types").mkdir();
		System.out.println(newFileTypes);
		String pathTypes = sc.nextLine();

		ArrayList<String> outPutLines = new ArrayList<String>();
		Double objectTypesTotalElectronics = 0.0, objectTypesTotalForniture = 0.0;
		
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path + "\\exercise"))) {
			int position = 0;
			for (String paramStr : information) {
				
				bw.write(paramStr);
				String[] splited = paramStr.split(",");
				
				Double objectValue = Double.parseDouble(splited[1]); 
				Integer objectQuantity = Integer.parseInt(splited[2]);
				
				objectToSell obejctSell = new objectToSell(splited[0], objectValue, objectQuantity,splited[3]);
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
			//new updated
			try (BufferedWriter bwTypes = new BufferedWriter(new FileWriter(pathTypes))){
				for (String paramStr : information) {
					String[] splited = paramStr.split(",");
					
					if (splited[3].equals("Electronics")) {
						Double objectValue = Double.parseDouble(splited[1]);
						Integer objectQuantity = Integer.parseInt(splited[2]);
						
						objectTypesTotalElectronics += objectValue * objectQuantity;
						
					} else {
						Double objectValue = Double.parseDouble(splited[1]);
						Integer objectQuantity = Integer.parseInt(splited[2]);
						
						objectTypesTotalForniture += objectValue * objectQuantity;
					}
				}
				bwTypes.write("Electronics," + objectTypesTotalElectronics);
				bwTypes.newLine();
				bwTypes.write("Forniture," + objectTypesTotalForniture);
				bwTypes.newLine();
				
				System.out.println("Electronics," + objectTypesTotalElectronics);
				System.out.println("Forniture," + objectTypesTotalForniture);
			} catch (IOException e) {
				e.printStackTrace();
			}
			//
		} catch (IOException e) {
			e.printStackTrace();
		}

		finally {
			System.out.println("Finished !");
			sc.close();
		}
	}

}
