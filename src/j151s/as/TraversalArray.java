package j151s.as;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.RandomAccess;

import org.testng.annotations.Test;

public class TraversalArray {
	
	
	@Test
	public void testAddDeleteList(){
		long start = 0l;
		int stuNum = 80 * 1000 ;
		List<Integer> scores = new ArrayList<Integer>(stuNum);
		start = System.nanoTime();
		for(int i  = 0 , size = scores.size(); i < size ; i++)
			scores.add(i,new Random().nextInt(150));
		System.out.println("time-add on array list : " + (System.nanoTime() - start) +" ns");
		
		start = System.nanoTime();
		for(int i  = 0 , size = scores.size(); i < size; i++)
			scores.remove(i);
		System.out.println("time-remove on array list : " + (System.nanoTime() - start) +" ns");
		
		
		List<Integer> linkedScores = new LinkedList<Integer>();
		start = System.nanoTime();
		for(int i  = 0 ,size = linkedScores.size(); i < size ; i++)
			linkedScores.add(i,new Random().nextInt(150));
		System.out.println("time-add on linked list : " + (System.nanoTime() - start) +" ns");
		
		start = System.nanoTime();
		for(int i  = 0 ,size = linkedScores.size(); i < size; i++)
			linkedScores.remove(i);
		System.out.println("time-remove on array list : " + (System.nanoTime() - start) +" ns");
		
	}
	
	
	@Test
	public void testTraversalArray(){
		int stuNum = 80 * 1000 ;
		List<Integer> scores = new ArrayList<Integer>(stuNum);
		for(int i  = 0 ; i < stuNum ; i++)
			scores.add(new Random().nextInt(150));
		
		long start = 0l;
		
		start=	System.nanoTime();
		System.out.println(getAverageFromAListByForEach(scores));
		System.out.println("time-getAverageFromArrayListByForEach:" +(System.nanoTime() - start) + "ns");
		
		start=	System.nanoTime();
		System.out.println(getAverageFromAListByIndex(scores));
		System.out.println("time-getAverageFromArrayListByIndex:" +(System.nanoTime() - start) + "ns");
	
	
		List<Integer> linkedScores = new LinkedList<Integer>();
		for(int i  = 0 ; i < stuNum ; i++)
			linkedScores.add(new Random().nextInt(150));
		
		start=	System.nanoTime();
		System.out.println(getAverageFromAListByForEach(linkedScores));
		System.out.println("time-getAverageFromLinkedListByForEach:" +(System.nanoTime() - start) + "ns");
	
		start=	System.nanoTime();
		System.out.println(getAverageFromAListByIndex(linkedScores));
		System.out.println("time-getAverageFromLinkedListByIndex:" +(System.nanoTime() - start) + "ns");
		
		start=	System.nanoTime();
		System.out.println(getAverageFromAListByRandomAccess(scores));
		System.out.println("time-getAverageFromArrayListByRandomAccess:" +(System.nanoTime() - start) + "ns");
		
		start=	System.nanoTime();
		System.out.println(getAverageFromAListByRandomAccess(linkedScores));
		System.out.println("time-getAverageFromLinkedListByRandomAccess:" +(System.nanoTime() - start) + "ns");
	
	}
	
	
	private int getAverageFromAListByForEach(List<Integer> list){
		int sum = 0 ;
		for(int i : list)
			sum += i ;
		return sum/list.size() ;
	}
	
	private int getAverageFromAListByIndex(List<Integer> list){
		int sum = 0 ;
		for(int i  = 0 , size = list.size() ; i < size ; i ++){
			sum += list.get(i);
		}
		return sum/list.size();
	}
	
	private int getAverageFromAListByRandomAccess(List<Integer> list){
		int sum = 0;
		if(list instanceof RandomAccess){
			for(int i = 0 ,size = list.size() ; i < size ; i++){
				sum += list.get(i);
			}
		}
		
		else{
			for(int i : list){
				sum += i ;
			}
		}
		
		return sum / list.size() ;
		
	}

}
