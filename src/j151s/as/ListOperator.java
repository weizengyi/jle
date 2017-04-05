package j151s.as;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

public class ListOperator {
	
	@Test
	public void addAll(){
		List<String> list1 = new ArrayList<String>() ;
		list1.add("A");
		list1.add("B");
		
		List<String> list2 = new ArrayList<String>() ;
		list2.add("C");
		list2.add("B");
		
		list1.addAll(list2);
		for(String s : list1)
			System.out.println(s);
	}

	
	@Test
	public void retainAll(){
		List<String> list1 = new ArrayList<String>() ;
		list1.add("A");
		list1.add("B");
		
		List<String> list2 = new ArrayList<String>() ;
		list2.add("C");
		list2.add("B");
		
		list1.retainAll(list2);
		for(String s : list1)
			System.out.println(s);
	}
	
	@Test
	public void removeAll(){
		List<String> list1 = new ArrayList<String>() ;
		list1.add("A");
		list1.add("B");
		
		List<String> list2 = new ArrayList<String>() ;
		list2.add("C");
		list2.add("B");
		
		list1.removeAll(list2);
		for(String s : list1)
			System.out.println(s);
	}
	
	@Test
	public void removeAllAddAll(){
		List<String> list1 = new ArrayList<String>() ;
		list1.add("A");
		list1.add("B");
		
		List<String> list2 = new ArrayList<String>() ;
		list2.add("C");
		list2.add("B");
		
		list2.removeAll(list1);
		list1.addAll(list2);
		for(String s : list1)
			System.out.println(s);
	}
}
