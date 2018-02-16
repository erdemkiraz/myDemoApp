
package com.mycompany.app;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;


public class App {
    public static List < String > chooseAndMerge(Integer[] index1, List < Integer > index2, String[] set1, List < String > set2) {
    	if(index1 == null || index2 == null || set1 == null || set2 == null) {
    		System.out.println("Null parameters.");
    		return null;
    	}
    	List < String > result = new ArrayList < String >();
        for(Integer x : index1) {
        	if(x >= 0 && x < set1.length)
        		result.add(set1[x]);
        }
        for(Integer x : index2) {
        	if(x >= 0 && x < set2.size())
        		result.add(set2.get(x));
        }
        Collections.sort(result);
        return result;
    }
}
