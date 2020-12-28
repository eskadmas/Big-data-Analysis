package thesis;

//import required classes
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import java.util.Random;
import weka.classifiers.Evaluation;
import weka.classifiers.trees.J48;

public class DTModel {

	public static void main(String[] args) throws Exception {
		// Load training set
		DataSource source = new DataSource("/Desktop/MSc_in_CE_thesis/part1/car.arff");
		Instances trainDataset = source.getDataSet();
		
		// Set class index to the last attribute
		trainDataset.setClassIndex(trainDataset.numAttributes() - 1);
		
		// Create and build the classifier
		J48 tree = new J48();
		tree.buildClassifier(trainDataset);
		
		System.out.println("=== Run Information ===\n");
		System.out.println("Relation: " + trainDataset.relationName() + "\n");
		System.out.println("Instances: " + trainDataset.numInstances() + "\n");
		System.out.println("Attributes: " + trainDataset.numAttributes() + "\n");
		
		for(int i=0; i<7; i++) {
			System.out.println("            " + trainDataset.attribute(i).name() + "\n");  
		}
		
		System.out.println("=== Classifier model (full training set) ===\n");
		System.out.println(tree.toString()+"\n");
		
		// The classifier has built by the training set. 
		// The evaluation has initialized with the train set and then evaluate using the test set
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

		System.out.println("=== Stratified cross-validation ===");
		System.out.println(eval.toSummaryString("=== Summary ===\n", false));
		System.out.println(eval.toClassDetailsString("=== Detailed Accuracy By Class ===\n"));
		
		// Confusion Matrix
		System.out.println(eval.toMatrixString("=== Confusion Matrix ===\n"));
	}

}
