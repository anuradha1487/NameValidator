import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FileValidator {

	public String proFileNmae = "config.properties";
	InputStream in = null;
	public String fileLocation = "";
	public int totalThreads = 0;
	public static void main(String[] args) {

		new FileValidator().getPropertyValues();
	}

	public void getPropertyValues() {
		Properties prop = new Properties();
		try {
			in = new FileInputStream(proFileNmae);
			prop.load(in);
			fileLocation = prop.getProperty("location");
			totalThreads = Integer.parseInt(prop.getProperty("totalThreads"));
			System.out.println("the location is : " + fileLocation);
			getFileList(fileLocation);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void getFileList(String fileLocation) {
		File file = new File(fileLocation);
		File arr[] = null;
		if (file.exists() && file.isDirectory()) {
			arr = file.listFiles();
			ExecutorService exe = Executors.newFixedThreadPool(totalThreads);
			for (int i = 0; i < arr.length; i++) {
				NameValidatorRunnable name = new NameValidatorRunnable(arr[i].getName());
				exe.execute(name);
			}
			exe.shutdown();
		}

		}




}
