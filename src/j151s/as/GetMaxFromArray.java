package j151s.as;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

import org.testng.annotations.Test;

public class GetMaxFromArray {
	
	
	@Test
	public void testmax(){
		int [] data = {1,2,3,4,5,63,7,8,10,54,67,12};
		System.out.println(getMaxByArraySort(data));
		System.out.println(getMaxByForLoop(data));
		System.out.println(getMaxByTreeSet(data));
		System.out.println(getSecondMaxByTreeSet(data));
	}
	
	private int getMaxByForLoop(int [] data){
		int max = data[0];
		for(int i : data){
			max = max > i ? max : i ;
		}
		return max;
	}
	
	private int getMaxByArraySort(int [] data){
		int [] datac = data.clone();
		Arrays.sort(datac);
		return datac[data.length - 1];
	}
	
	private int getMaxByTreeSet(int [] data){
		Integer[] dataI = new Integer[data.length];
		for(int i = 0 ; i < data.length ; i++){
			dataI[i] = data[i];
		}
		List<Integer> dataList = Arrays.asList(dataI);
		TreeSet<Integer> ts = new TreeSet<Integer>(dataList);
		return ts.last();
	}
	
	private int getSecondMaxByTreeSet(int [] data){
		Integer[] dataI = new Integer[data.length];
		for(int i = 0 ; i < data.length ; i++){
			dataI[i] = data[i];
		}
		List<Integer> dataList = Arrays.asList(dataI);
		TreeSet<Integer> ts = new TreeSet<Integer>(dataList);
		return ts.lower(ts.last());
	}

}
