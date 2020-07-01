import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class FileNames {

	static List<String> saveData(File file1) {
		List<String> list = new ArrayList<>();
		try {
			FileReader fileReader = new FileReader(file1);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line = bufferedReader.readLine();
			while (line != null) {
				list.add(line);
				line = bufferedReader.readLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public static void main(String[] args) {
		
		/* Read input files */
		File file1 = new File("C:/Users/Sandy/Downloads/file1.txt");
		File file2 = new File("C:/Users/Sandy/Downloads/file2.txt");

		/* call saveData method to save filenames in a list*/
		List<String> list1 = saveData(file1);
		List<String> list2 = saveData(file2);
		
		/* removing filenames from first file which are there n second file */
		list2.forEach(l -> {
			list1.remove(l);
		});
		
		System.out.println(list1);
	}

}
