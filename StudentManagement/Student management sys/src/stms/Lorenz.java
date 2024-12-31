package stms;

import java.io.*;

public class Lorenz {

 public static void display() {
  
  //CSV = Comma-Separated Values 
  //   text file that uses a comma to separate values
  
  String file = "src\\StudentInfo.csv";
  BufferedReader reader = null;
  String line = "";
  
  try {
   reader = new BufferedReader(new FileReader(file));
   while((line = reader.readLine()) != null) {
    
    String[] row = line.split(",");
    //String[] row = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)"); 
//use this if your values already contain commas
    for(String index : row) {
     System.out.printf("%-20s", index);
    }
    System.out.println();
   }
  }
  catch(Exception e) {
   e.printStackTrace();
  }
  finally {
   try {
    reader.close();
   } catch (IOException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
   }
  }
 }
}