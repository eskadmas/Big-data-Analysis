package thesis_second_task;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class FileMerging {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException { 
        
		// PrintWriter object for mergedFile.arff 
        PrintWriter pw = new PrintWriter("/Users/eskad/Desktop/MSc_in_CE_thesis/part2/mergedFile.arff");
        
        pw.write("% a file that contains incorrectly classified records and a file that contains \n");
		pw.write("% a single record for each path of correctly classified instances are merged here. \n\n");
        pw.write("@RELATION carEvaluation \n\n");
		pw.write("@ATTRIBUTE buying {high,low,med,vhigh,null} \n");
		pw.write("@ATTRIBUTE maint {high,low,med,vhigh,null} \n");
		pw.write("@ATTRIBUTE doors {2,3,4,5more,null} \n");
		pw.write("@ATTRIBUTE persons {2,4,more,null} \n");
		pw.write("@ATTRIBUTE lug_boot {big,med,small,null} \n");
		pw.write("@ATTRIBUTE safety {high,low,med,null} \n");
		pw.write("@ATTRIBUTE class {acc,good,unacc,vgood} \n\n");
		pw.write("@DATA \n");
        
        // BufferedReader object for incorrectlyClassifiedInstances.arff 
        BufferedReader br = new BufferedReader(new FileReader("/Users/eskad/Desktop/MSc_in_CE_thesis/part2/incorrectlyClassifiedInstances.arff")); 
        String line = br.readLine(); 
          
        // Loop to copy each line of incorrectlyClassifiedInstances.arff to mergedFile.arff 
        while (line != null) { 
            pw.println(line); 
            line = br.readLine(); 
        } 
          
        br = new BufferedReader(new FileReader("/Users/eskad/Desktop/MSc_in_CE_thesis/part2/record_in_a_path.arff"));  
        line = br.readLine(); 
          
        // Loop to copy each line of record_in_a_path.arff to mergedFile.arff 
        while(line != null) { 
            pw.println(line); 
            line = br.readLine(); 
        } 
          
        pw.flush(); 
 
        // closing resources 
        br.close(); 
        pw.close(); 
        
        System.out.println("This program merges a file that contains incorrectly classified records and");
        System.out.println("a file that contains a single record for each path of correctly classified instances \n"); 
        System.out.println("The 1st file is: incorrectlyClassifiedInstances.arff"); 
        System.out.println("The 2nd file is: record_in_a_path.arff \n");
        System.out.println("The two files are merged to a third file: mergedFile.arff");
    } 

}
