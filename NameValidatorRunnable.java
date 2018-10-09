import java.time.DateTimeException;
import java.time.LocalDate;

public class NameValidatorRunnable implements Runnable{
	public String fileName = null;
	public String result = "";

	public NameValidatorRunnable(String fileNmae) {
		// TODO Auto-generated constructor stub
		this.fileName = fileNmae;
	}
	@Override
	public void run() {
		String fileExt = fileName.substring(fileName.indexOf(".") + 1, fileName.length());

		String name[] = fileName.substring(0, fileName.indexOf(".")).split("_");
		String resultFailure = "File '" + fileName + "' failed validation.";
		if (name.length != 4) {
			System.out.println(resultFailure);
			System.out.println("File format should be 'Test_<portfoliocode>_<ddmmyyyy>_<2digit-sequencenumber>.csv'");
			result = resultFailure
					+ "File format should be 'Test_<portfoliocode>_<ddmmyyyy>_<2digit-sequencenumber>.csv'";
			return;
		}
		String resultSuccess = "File '" + fileName + "' passed validation.";
		String additionalComments = null;
		if (!name[0].equals("Test")) {
			additionalComments = "Prefix for the file should be ‘Test’ found ‘" + name[0] + "’ .";
			System.out.println(resultFailure);
			System.out.println(additionalComments);
			result = resultFailure + additionalComments;
			return;
		}

		if (name[1].equals("A") || name[1].equals("B") || name[1].equals("C")) {

		} else {
			additionalComments = "PortfolioCode should be A/B/C found " + name[1] + ".";
			System.out.println(resultFailure);
			System.out.println(additionalComments);
			result = resultFailure + additionalComments;
			return;
		}
		if (name[2].length() == 8) {
			int year = Integer.parseInt(name[2].substring(4, 8));
			int months = Integer.parseInt(name[2].substring(2, 4));
			int day =  Integer.parseInt(name[2].substring(0, 2));
			try {
				LocalDate.of(year, months, day);
			} catch (DateTimeException e) {
				additionalComments = "Valuation Date is not a valid date format 'ddmmyyyy’.";
				System.out.println(resultFailure);
				System.out.println(additionalComments);
				result = resultFailure + additionalComments;
				return;
			}

		} else {

			additionalComments = "Valuation Date is not a valid date format 'ddmmyyyy’.";
			System.out.println(resultFailure);
			System.out.println(additionalComments);
			result = resultFailure + additionalComments;
			return;

		}


		if (name[3].length() != 2) {
				System.out.println(resultFailure);
				System.out.println("sequence number should be 2digit");
				result = resultFailure + additionalComments;
				return;
		}
		if (!fileExt.equals("csv")) {
			additionalComments = "Invalid File format.Expected ‘csv' found " + fileExt + " .";
			System.out.println(resultFailure);
			System.out.println(additionalComments);
			result = resultFailure + additionalComments;
			return;
		}
		result = resultSuccess;
		System.out.println(resultSuccess);
	}

	public String getResult() {
		return this.result;
	}



}
