package thesis;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Random;

import weka.classifiers.Evaluation;
import weka.classifiers.trees.J48;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class CCInstances {

	public static void main(String[] args) throws Exception {
		// Load training set
		DataSource source = new DataSource("/Desktop/MSc_in_CE_thesis/part1/car.arff");
		Instances trainDataset = source.getDataSet();
		
		// Set class index to the last attribute
		trainDataset.setClassIndex(trainDataset.numAttributes() - 1);
		
		// Create and build the classifier
		J48 tree = new J48();
		tree.buildClassifier(trainDataset);
		
		// The classifier has built by the training set. 
		// The evaluation has initialised with the train set and then evaluate using the test set
		// Load test set for evaluation
		DataSource source2 = new DataSource("/Desktop/MSc_in_CE_thesis/part1/testDataset.arff");
		Instances testDataset = source2.getDataSet();
		
		// Set class index to the last attribute
		testDataset.setClassIndex(testDataset.numAttributes() - 1);
		
		// Evaluate model
		Evaluation eval = new Evaluation(trainDataset);
		Random rand = new Random(1);
		int folds = 10;
		//eval.evaluateModel(tree, testDataset);
		eval.crossValidateModel(tree, testDataset, folds, rand);
		System.out.println("\n=== Correctly Classified Instances === " + (int)eval.correct() + "\n");
		
		double[] predictions = eval.evaluateModel(tree, testDataset);
		
		File fout = new File("/Desktop/MSc_in_CE_thesis/part1/cCInstances.arff");
		FileOutputStream fos = new FileOutputStream(fout);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
        
		// Loop through the instances of testDataset and make predictions
        for (int i=0; i < testDataset.numInstances(); i++) {
        	
            double realValue = testDataset.instance(i).classValue(); // test data
            
            // Correctly Classified Instances
            if(realValue == predictions[i]) {
            	
            	bw.write(testDataset.instance(i).toString());
            	bw.newLine();
            	
	            System.out.println(testDataset.instance(i).toString());
	            
            }
            
        } 
        
        bw.close();

	}

}
