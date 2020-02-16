package com.company;
import java.util.*;
import java.io.*;
import java.lang.*;
import java.util.regex.Pattern;


public class RegularExpression {
    public static void returnListofFiles(String directory, String exp) {
        File dir = new File(directory);
        File []filesinDir = dir.listFiles();
        //List <String>paths = new ArrayList<String>();
        //System.out.println(filesinDir);
        if(filesinDir.length > 0){
            for (File file : filesinDir) {
                //System.out.println(file.getName());
                Pattern p = Pattern.compile(exp);
                //System.out.println(p.pattern());
                if (file.isFile() && Pattern.matches(exp, file.getName())) {
                    System.out.println(file.getAbsolutePath());
                } else if (file.isDirectory()) {
                    String folderpath = file.getAbsolutePath();
                    returnListofFiles(folderpath, exp);
                }
            }
        }
    }
    public static void main(String[] args) {
	// write your code here
        Scanner sc = new Scanner(System.in);
        String exp = "*linux*";
        while((exp = sc.next()).length() > 0) {
            //System.out.println(exp);
            returnListofFiles("/home", exp);
        }

    }
}
