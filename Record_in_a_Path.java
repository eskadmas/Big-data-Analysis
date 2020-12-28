package thesis_second_task;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import weka.classifiers.Evaluation;
import weka.classifiers.trees.J48;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class Record_in_a_Path {
	
	public static void main(String[] args) throws Exception {
		// Load training set
		DataSource source = new DataSource("/Users/eskad/Desktop/MSc_in_CE_thesis/part2/car.arff");
		Instances trainDataset = source.getDataSet();
		
		// Set class index to the last attribute
		trainDataset.setClassIndex(trainDataset.numAttributes() - 1);
		
		// Create and build the classifier
		J48 tree = new J48();
		tree.buildClassifier(trainDataset);
		//tree.toSource("TreeSource");
		
		// The classifier has built by the training set. 
		// The evaluation has initialized with the train set and then evaluate using the test set
		// Load test set for evaluation
		DataSource source2 = new DataSource("/Users/eskad/Desktop/MSc_in_CE_thesis/part2/testDataset.arff");
		Instances testDataset = source2.getDataSet();
		
		// Set class index to the last attribute
		testDataset.setClassIndex(testDataset.numAttributes() - 1);
		
		// Evaluate model
		Evaluation eval = new Evaluation(trainDataset);
		Random rand = new Random(1);
		int folds = 10;
		eval.evaluateModel(tree, testDataset);
		//eval.crossValidateModel(tree, testDataset, folds, rand);
		
		System.out.println("% The number of correctly classified instances are: " + (int)eval.correct());
		
		File fout = new File("/Users/eskad/Desktop/MSc_in_CE_thesis/part2/record_in_a_path.arff");
		FileOutputStream fos = new FileOutputStream(fout);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
		
		double[] predictions = eval.evaluateModel(tree, testDataset);
        Set<String> paths = new HashSet<String>();
        
		// Loop through the instances of testDataset and make predictions
        for (int i=0; i < testDataset.numInstances(); i++) {
        	
        	TreeSource.classify(testDataset.instance(i).toString().split(","));
        	
            double realValue = testDataset.instance(i).classValue(); // test data
            
            // Add Path of Correctly Classified Instances to 'paths'
            if(realValue == predictions[i]) {
            	
            	paths.add(TreeSource.path.toString());
	            
            }
            
        } 
        
        System.out.println("% The number of paths of correctly classified instances are: " + paths.size() + "\n");
        System.out.println("@RELATION carEvaluation \n");
		System.out.println("@ATTRIBUTE buying {high,low,med,vhigh,null}");
		System.out.println("@ATTRIBUTE maint {high,low,med,vhigh,null}");
		System.out.println("@ATTRIBUTE doors {2,3,4,5more,null}");
		System.out.println("@ATTRIBUTE persons {2,4,more,null}");
		System.out.println("@ATTRIBUTE lug_boot {big,med,small,null}");
		System.out.println("@ATTRIBUTE safety {high,low,med,null}");
		System.out.println("@ATTRIBUTE class {acc,good,unacc,vgood} \n");
		System.out.println("@DATA");
		
        for(String path : paths){
        	
        	String attrWithValue = path.replace("}", "");
        	String [] attr = new String[7];
        	
        	for(String str:attrWithValue.split(",")) {
        		if(str.contains("buying"))
        			attr[0] = str.substring(str.lastIndexOf("=")+1);
        		if(str.contains("maint"))
        			attr[1] = str.substring(str.lastIndexOf("=")+1);
        		if(str.contains("doors"))
        			attr[2] = str.substring(str.lastIndexOf("=")+1);
        		if(str.contains("persons"))
        			attr[3] = str.substring(str.lastIndexOf("=")+1);
        		if(str.contains("lug_boot"))
        			attr[4] = str.substring(str.lastIndexOf("=")+1);
        		if(str.contains("safety"))
        			attr[5] = str.substring(str.lastIndexOf("=")+1);
        		
        		attr[6] = str.substring(str.lastIndexOf("=")+1);
        		
        	}
        	
			attr[1] = "," + attr[1];
			attr[2] = "," + attr[2];
			attr[3] = "," + attr[3];
			attr[4] = "," + attr[4];
			attr[5] = "," + attr[5];
			attr[6] = "," + attr[6];

        	bw.write(attr[0] + attr[1] + attr[2] + attr[3] + attr[4] + attr[5] + attr[6]);
        	bw.newLine();
        	
        	System.out.println(attr[0] + attr[1] + attr[2] + attr[3] + attr[4] + attr[5] + attr[6]);
    	}
       
        bw.close();

	}

}
