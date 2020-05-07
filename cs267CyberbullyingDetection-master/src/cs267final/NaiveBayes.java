package cs267final;
import java.util.*;

/**
 * There are two categories, 0 represents non-cyberbullying, 1 represents cyberbullying
 * @author Anqi Wang Anket Sah
 *
 */
public class NaiveBayes {

	//key is feature, word value is appearance of the featured word in each category
	private Map<String,Map<Integer,Integer>> featureCount; //count features in each classification
	
	private Map<Integer,Integer> classifierCount; //count appearance of the classifier
	
	//private Map<String,Map<Integer,Double>> probClassifyCount;
	
	public NaiveBayes(Map<String,Map<Integer,Integer>> featureCount,Map<Integer,Integer> classifierCount) {
		this.featureCount = featureCount;
		this.classifierCount = classifierCount;
		//this.probClassifyCount = probClassifyCount;
	}
	
	public NaiveBayes() {
		featureCount = new HashMap<>();
		classifierCount = new HashMap<>();
	//	probClassifyCount = new HashMap<>();
	}
	
	/**
	 * It processes each cleaned message. 
	 * It records features and classifier by updating featureCount and classifierCount
	 * @param data 
	 * @param category
	 */
	public void loadData(List<String> data,int category) {
		if(data==null || data.size()==0) return;
		if(!classifierCount.containsKey(category)) {
			classifierCount.put(category,0);
		}
		int cCount = classifierCount.get(category);
		classifierCount.put(category, cCount+1);
		for(String s: data) {
			//update featureCount
			if(!featureCount.containsKey(s)) {
				Map<Integer,Integer> tempMap = new HashMap<>();
				tempMap.put(0,0);
				tempMap.put(1,0);
				featureCount.put(s,tempMap);
			}
			Map<Integer,Integer> temp = featureCount.get(s);
			temp.put(category,temp.get(category)+1);
			featureCount.put(s,temp);
		}
	}
	
	/**
	 * Get number of occurrences of features in each category
	 * @param feature
	 * @param category
	 * @return the feature count
	 */
	public int getCountOfFeature(String feature, int category) {
		if(feature == null || category<0 ||category >1) {
			return 0;
		}
		return featureCount.get(feature).get(category);
	}
	
	/**
	 * Get number of messages of category
	 * @param category
	 * @return the classifier count
	 */
	public int getCountOfCategory(int category) {
		if(category<0 ||category >1) {
			return 0;
		}
		return classifierCount.get(category);
	}
	
	/**
	 * Return probability of each category
	 * @param category
	 * @return
	 */
	public double getCategoryProb(int category) {
		int categoryCount = this.getCountOfCategory(category);
		int total = this.getCountOfCategory(0) +this.getCountOfCategory(1);
		return (double)categoryCount / (double) total;
	}
	
	/**
	 * It calculates probability of each feature i in each category
	 * Weighted probability in order to improve accuracy, add default weight to each count by 1
	 * @param feature
	 * @param category
	 */
	public double getWeightedProb(String feature,int category) {
		int defaultWeight = 1;
		int featureInCategory = 0 ;
		int featureInAll = 0;
		if(featureCount.containsKey(feature)) {
			if(featureCount.get(feature).containsKey(category)) {
				featureInCategory = featureCount.get(feature).get(category);
			}
			
			if(featureCount.get(feature).containsKey(1)&&featureCount.get(feature).containsKey(0)) {
				featureInAll = featureCount.get(feature).get(0) +featureCount.get(feature).get(1);
			}
			
		}
		double basicProb = (double)featureInCategory / (double)featureInAll;
		double weiProb = (double)(featureInCategory+defaultWeight) / (double)(featureInAll+2*defaultWeight);
		double p = 0.5;
		double weiProb1 = (p * defaultWeight + featureInAll * basicProb)/(featureInAll+defaultWeight);
		
		return weiProb;
		
	}
	
	
//	public double getWeightedProb(String feature,int category) {
//		if(!probClassifyCount.containsKey(feature)) {
//			return 0.5;
//		}
//		
//		if(!probClassifyCount.get(feature).containsKey(category)&& !probClassifyCount.get(feature).containsKey(category)) {
//			
//		}
//		return probClassifyCount.get(feature).get(category);
//	}
//	
	/**
	 * Calculate the probability of the given data in each category. 
	 * Choose the maximum result as its final category. 
	 * Formula: probability = prob(category) * prob(f1|category)
	 * @param data
	 * @return
	 */
	public String naiveBay(List<String> message) {
		 double cyberProb = 1.0;
		 double cyberNonProb = 1.0;
		 double cyberProbLog = 0.0;
		 double cyberNonProbLog = 0.0;
		 for(String s: message) {
			 double cyberTemp = getWeightedProb(s,0);
			 cyberProb *= cyberTemp;
			 cyberProbLog += Math.log(cyberTemp);
			 double nonCyberTemp = getWeightedProb(s,1);
			 cyberNonProb *= nonCyberTemp;
			 cyberNonProbLog += Math.log(nonCyberTemp);
		 }
		 cyberProb *= getCategoryProb(0);
		 cyberNonProb *= getCategoryProb(1);
		 
		 if(cyberProbLog>cyberNonProbLog) {
			 return "cyberbullying";
		 }
		 return "normal";
		 
	}
	
	/**
	 * Load train data into featureCount and classifierCount
	 * calculate probability of each word in each category
	 * @param data
	 * @param category
	 */
//	public void trainModel(List<List<String>> data,int category) {
//		for(List<String> list:data) {
//			this.loadData(list, category);
//			
//		}
//		
//		
//	}
}
