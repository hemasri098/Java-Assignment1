
import java.util.*;
import java.util.logging.Logger;
import java.io.*;
import java.util.regex.Pattern;


public class RegularExpression {
	
	// to search for files in given directory
	public static File[] searchFilesInDirectory(String directory) {
        File dir = new File(directory);
        File []files = dir.listFiles(); // returns list of files in a specified directory
        return files;
    }
	
    // to check for filename which matched with given regular expression
    public static boolean ifPatternMatches(String expression, String fileName) {
        if(Pattern.matches(expression, fileName)) 
            return true;
        return false;
    }

    // returns all the paths of files
    public static void returnListofFilePaths(String directory, String expression){
    	Logger LOGGER = Logger.getAnonymousLogger();
        File []files = searchFilesInDirectory(directory);
        try{
            for (File file : files) {
            	// checking whether is it a file type and return file if it matches with given regular expression
                if (file.isFile() && ifPatternMatches(expression, file.getName())) {
                	LOGGER.info(file.getAbsolutePath());
                } 
                // if it is directory type searching inside the directory
                else if (file.isDirectory()) {  		
                    String folderpath = file.getAbsolutePath();
                    returnListofFilePaths(folderpath, expression);    
                }
            }
        }
        catch(NullPointerException e) {
            LOGGER.info("No such Files Found with that expression in the path " + directory);
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Logger LOGGER = Logger.getAnonymousLogger();
        LOGGER.info("Enter regular expression to search for files \nEnter STOPSEARCH to stop");
        String expression = "^.*\\.txt$";
        while((expression = sc.next()).length() > 0) { 
        	if(!(expression).equals("STOPSEARCH"))              // takes input continuously until I enter STOPSEARCH
        		returnListofFilePaths("/home", expression);
        	else {
        		LOGGER.info("search stopped");
        		break;
        	}
        }
    }

}
