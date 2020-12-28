package thesis;

import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.classifiers.trees.J48;
import weka.classifiers.Evaluation;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Random;
	
public class ICInstances {
	
	public static void main(String[] args) throws Exception {
		// Load training set
		DataSource source = new DataSource("/Desktop/MSc_in_CE_thesis/part1/car.arff");
		Instances trainDataset = source.getDataSet();
		
		// Set class index to the last attribute
		trainDataset.setClassIndex(trainDataset.numAttributes() - 1);
		
		//Create and build the classifier
		J48 tree = new J48();				// J48 is an algorithm used to generate a decision tree
		tree.buildClassifier(trainDataset); // Generates the classifier(decision tree)
		
		// The classifier has built by the training set. 
		// The evaluation has initialized with the training set and then evaluate using the test set
		// Load test set for evaluation
		DataSource source2 = new DataSource("/Desktop/MSc_in_CE_thesis/part1/testDataset.arff");
		Instances testDataset = source2.getDataSet();
		
		// Set class index to the last attribute
		testDataset.setClassIndex(testDataset.numAttributes() - 1);
		
		// Evaluate model
		Evaluation eval = new Evaluation(testDataset);
		Random rand = new Random(1);
		int folds = 10;
		//eval.evaluateModel(tree, testDataset);
		eval.crossValidateModel(tree, testDataset, folds, rand);
		
		System.out.println(eval.toSummaryString("\n=== Evaluation Results ===\n", false));
		System.out.println("\n=== Incorrectly Classified Instances === " + (int)eval.incorrect() + "\n");
		
		//List<String> newDataset = new ArrayList<String>();
		//int classIndex = testDataset.numAttributes()-1;
		
		double[] predictions = eval.evaluateModel(tree, testDataset);
		
		File fout = new File("/Desktop/MSc_in_CE_thesis/part1/iCInstances.arff");
		FileOutputStream fos = new FileOutputStream(fout);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
        
		// Loop through the instances of testDataset and make predictions
        for (int i=0; i < testDataset.numInstances(); i++) {
        	
            double realValue = testDataset.instance(i).classValue(); // test data
            
            // Wrongly Classified Instances
            if(realValue != predictions[i]) {
            	
            	//newDataset.add("\n" + testDataset.instance(i).toString()); 
                bw.write(testDataset.instance(i).toString());
            	bw.newLine();
            	
	            System.out.println(testDataset.instance(i).toString());
            	
            }
            
        }
        
        bw.close();
        
        // Write Wrongly Classified Instances into a file 
        // weka.core.SerializationHelper.write("/Users/eskad/Desktop/DM/inputData/wCInstances.arff", newDataset);
        
	}
	

}
