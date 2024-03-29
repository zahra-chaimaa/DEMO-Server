package jcolibri.method.retrieve.NNretrieval.similarity.local.similaritry;

import java.util.*;

import jcolibri.exception.NoApplicableSimilarityFunctionException;
import jcolibri.method.retrieve.NNretrieval.similarity.LocalSimilarityFunction;
import jcolibri.method.retrieve.NNretrieval.similarity.local.interfaces.NormalizedStringDistance;
import jcolibri.method.retrieve.NNretrieval.similarity.local.interfaces.NormalizedStringSimilarity;



public class Cosine extends ShingleBased implements NormalizedStringDistance, NormalizedStringSimilarity, LocalSimilarityFunction{

/**
* Implements Cosine Similarity between strings. The strings are first
* transformed in vectors of occurrences of k-shingles (sequences of k
* characters). In this n-dimensional space, the similarity between the two
* strings is the cosine of their respective vectors.
*
* @param k
*/
public Cosine(final int k) {
super(k);
}

/**
* Implements Cosine Similarity between strings. The strings are first
* transformed in vectors of occurrences of k-shingles (sequences of k
* characters). In this n-dimensional space, the similarity between the two
* strings is the cosine of their respective vectors.
* Default k is 3.
*/
public Cosine() {
super();
}

/**
* Compute the cosine similarity between strings.
* @param s1 The first string to compare.
* @param s2 The second string to compare.
* @return The cosine similarity in the range [0, 1]
* @throws NullPointerException if s1 or s2 is null.
*/
public final double similarity(final String s1, final String s2) {
if (s1 == null) {
    throw new NullPointerException("s1 must not be null");
}

if (s2 == null) {
    throw new NullPointerException("s2 must not be null");
}

if (s1.equals(s2)) {
    return 1;
}

if (s1.length() < getK() || s2.length() < getK()) {
    return 0;
}

Map<String, Integer> profile1 = getProfile(s1);
Map<String, Integer> profile2 = getProfile(s2);

return dotProduct(profile1, profile2)
        / (norm(profile1) * norm(profile2));
}



/**
* Compute the norm L2 : sqrt(Sum_i( v_i�)).
*
* @param profile
* @return L2 norm
*/
private static double norm(final Map<String, Integer> profile) {
double agg = 0;

for (Map.Entry<String, Integer> entry : profile.entrySet()) {
    agg += 1.0 * entry.getValue() * entry.getValue();
}

return Math.sqrt(agg);
}

private static double dotProduct(
    final Map<String, Integer> profile1,
    final Map<String, Integer> profile2) {

// Loop over the smallest map
Map<String, Integer> small_profile = profile2;
Map<String, Integer> large_profile = profile1;
if (profile1.size() < profile2.size()) {
    small_profile = profile1;
    large_profile = profile2;
}

double agg = 0;
for (Map.Entry<String, Integer> entry : small_profile.entrySet()) {
	Integer i=large_profile.get(entry.getKey());
    if (i==null) {
        continue;
    }
    agg += 1.0 * entry.getValue() * i;
}

return agg;
}

/**
* Return 1.0 - similarity.
* @param s1 The first string to compare.
* @param s2 The second string to compare.
* @return 1.0 - the cosine similarity in the range [0, 1]
* @throws NullPointerException if s1 or s2 is null.
*/
public double compute(Object caseObject, Object queryObject) throws NoApplicableSimilarityFunctionException {
	// TODO Auto-generated method stub
	return 0;
}


public final double distance(final String s1, final String s2) {
return 1.0 - similarity(s1, s2);
}

public double similarity(
    final Map<String, Integer> profile1,
    final Map<String, Integer> profile2) {

return dotProduct(profile1, profile2)
        / (norm(profile1) * norm(profile2));
}

@Override
public boolean isApplicable(Object caseObject, Object queryObject) {
	// TODO Auto-generated method stub
	return false;
}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
Cosine c = new Cosine();
double m = c.distance("Grippe","Can");
double n = c.distance("Grippe","Diabete");
double s = c.distance("Cance","Diabete");
System.out.println("la distance\n1-\t"+m+"\n2-\t"+n+"\n3-"+s);
	}


	

}
