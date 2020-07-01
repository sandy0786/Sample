import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class CSVReader {

	public static void main(String[] args) {
		try {
			
			/* Input file csv */
			File file = new File("C:/Users/Sandy/Downloads/Sacramentorealestatetransactions.csv");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			/* read line 1 */
			String line = bufferedReader.readLine();

			/* Output file csv */
			FileWriter fileWriter = new FileWriter("C:/Users/Sandy/Downloads/output.csv");
			
			/* Variable to know first line or not */
			int count = 0;
			
			/* Variable for getting price column index */
			int index = 0;
			
			/* Loop until last line */
			while (line != null) {
				/* splitting line with , to get data based on columns */
				String[] str = line.split(",");
				
				/* Condition satisfies for header row */
				if (count == 0) {
					for (int i = 0; i < str.length; i++) {
						/* if price header found set index position and exit loop*/
						if (str[i].equalsIgnoreCase("price")) {
							index = i;
							break;
						}
					}
				}
				
				/* Write to output file */
				fileWriter.write(str[index] + "\n");
				
				/* Read next line */
				line = bufferedReader.readLine();
				count++;
			}
			
			/* Closing reader and writer objects */
			bufferedReader.close();
			fileWriter.close();

		} catch (Exception e) {
			/* Chances of getting FileNotFoundException, IOException*/
			e.printStackTrace();
		}
	}

}
