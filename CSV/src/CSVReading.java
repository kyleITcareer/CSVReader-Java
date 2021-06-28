import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CSVReading {
	
	public static void main(String[] args) {
		String path = "C:/Users/17342/Documents/testCSV.csv";
		String line = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			
			while((line = br.readLine()) != null) {
				String[] values = line.split(",");	
				if(values[3].contains("PART TIME")) {
					System.out.println("Person: "
							+ values[0]
							+ ", Salary: " 
							+ "$"
							+ (((Double.parseDouble(values[1]) * Double.parseDouble(values[2])) * 4) * 12)
							);
				} if(values[3].contains("FULL TIME")) {
					// parse for FT, then calculate based off rates * Hrs with a cap of 50k
					System.out.println("Person: "
							+ values[0]
							+ ", Salary: " 
							+ "$"
							+ (
									(((Double.parseDouble(values[1]) * Double.parseDouble(values[2])) * 4) * 12) >= 50000 ? 
											50000 : ((Double.parseDouble(values[1]) * Double.parseDouble(values[2])) * 4) * 12
							));

				} else {
					System.out.println("Person: "
							+ values[0]
							+ ", Salary: " 
							+ "$"
							+ (
									(((Double.parseDouble(values[1]) * Double.parseDouble(values[2])) * 4) * 12) + 10000)
							);

				}
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
