# NameValidator
This is a maven project which check if the files at a given location have a valid name format or not.
Steps to run  this project
1. Import the project in eclipse as a maven project.
2. Change the location field in config.properties file to the location of your folder.
3. Run the project.

List of files :
1.FileValidator (entry point)
2.NameValidatorRunnable (Runnable class)
3.config.properties (property file)
4.pom.xml
5.FileValidatorTest (test file to test the FileValidator class)
6.TestNameValidatorRunnable


This program takes the location of files and number of threads from the property file and create the given threads.Each thread takes one file name from the location and checks if the file name is a valid format or not.


assumptions-


1.Name is not valid if any one of the 5 checks are not correct(1.Test, 2. Portfolio code, date (ddmmyyyy),2 digit sequence number, extention(.csv)).

2.Program will print the first error which will come first from traversing from left.

3.Date can be past or future date.

4.Date string must have 8 character for a valid format.
6.It is case sensitive.It will give error if file name starts with “test” in place of “Test”


