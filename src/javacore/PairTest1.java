package javacore;

public class PairTest1 {
	
	public static Pair<String>minmax(String[] a){
		if(a==null || a.length ==0 ) return null ;
		String min = a[0];
		String max = a[0];
		for(int i = 1 ; i < a.length;i++){
			if(min.compareTo(a[i])>0)  min = a[i];
			if(max.compareTo(a[i])<0)  max = a[i];
		}
		return new Pair<String>(min,max);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <T extends Comparable> Pair<T> minmaxT(T[] a){
		if(a==null || a.length == 0 ) return null;
		T min = a[0];
		T max = a[0];
		for(int i = 0 ; i < a.length ;i++){
			if(min.compareTo(a[i])>0) min =a[i];
			if(max.compareTo(a[i])<0) max =a[i];
		}
		return new Pair<T>(min,max);
	}
}
