package thesis_second_task;

import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.classifiers.trees.J48;
import weka.classifiers.Evaluation;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Random;
	
public class IncorrectlyClassifiedInstances {
	
	public static void main(String[] args) throws Exception {
		// Load training set
		DataSource source = new DataSource("/Users/eskad/Desktop/MSc_in_CE_thesis/part2/car.arff");
		Instances trainDataset = source.getDataSet();
		
		// Set class index to the last attribute
		trainDataset.setClassIndex(trainDataset.numAttributes() - 1);
		
		//Create and build the classifier
		J48 tree = new J48();				// J48 is an algorithm used to generate a decision tree
		tree.buildClassifier(trainDataset); // Generates the classifier(decision tree)
		
		// The classifier has built by the training set. 
		// The evaluation has initialized with the training set and then evaluate using the test set
		// Load test set for evaluation
		DataSource source2 = new DataSource("/Users/eskad/Desktop/MSc_in_CE_thesis/part2/testDataset.arff");
		Instances testDataset = source2.getDataSet();
		
		// Set class index to the last attribute
		testDataset.setClassIndex(testDataset.numAttributes() - 1);
		
		// Evaluate model
		Evaluation eval = new Evaluation(testDataset);
		Random rand = new Random(1);
		int folds = 10;
		eval.evaluateModel(tree, testDataset);
		//eval.crossValidateModel(tree, testDataset, folds, rand);
		
		System.out.println("% The number of incorrectly classified instances are: " + (int)eval.incorrect() + "\n");
		System.out.println("@RELATION carEvaluation \n");
		System.out.println("@ATTRIBUTE buying {high,low,med,vhigh}");
		System.out.println("@ATTRIBUTE maint {high,low,med,vhigh}");
		System.out.println("@ATTRIBUTE doors {2,3,4,5more}");
		System.out.println("@ATTRIBUTE persons {2,4,more}");
		System.out.println("@ATTRIBUTE lug_boot {big,med,small}");
		System.out.println("@ATTRIBUTE safety {high,low,med}");
		System.out.println("@ATTRIBUTE class {acc,good,unacc,vgood} \n");
		System.out.println("@DATA");
		
		File fout = new File("/Users/eskad/Desktop/MSc_in_CE_thesis/part2/incorrectlyClassifiedInstances.arff");
		FileOutputStream fos = new FileOutputStream(fout);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
		
		double[] predictions = eval.evaluateModel(tree, testDataset);
        
		// Loop through the instances of testDataset and make predictions
        for (int i=0; i < testDataset.numInstances(); i++) {
        	
            double realValue = testDataset.instance(i).classValue(); // test data
            
            // Wrongly Classified Instances
            if(realValue != predictions[i]) {
            	
                bw.write(testDataset.instance(i).toString());
            	bw.newLine();
            	
	            System.out.println(testDataset.instance(i).toString());
            	
            }
            
        }
        
        bw.close();
        
	}
	

}
