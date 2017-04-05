package j151s.as;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.lang.builder.CompareToBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.testng.annotations.Test;

public class SubListTest {

	@Test
	public void subListView(){
		List<String> c = new ArrayList<String>() ;
		c.add("A");
		c.add("B");
		List<String> c1 = new ArrayList<String>(c);
		List<String> c2 = c.subList(0, c.size());
		c2.add("C");
		System.out.println("c equals c1 : "+ c.equals(c1));
		System.out.println("c equals c2 : "+ c.equals(c2));
		System.out.println("c == c1     : "+ (c==c1));
		System.out.println("c == c2     : "+ (c==c2));
	}
	
	
	@Test
	public void subListRemoveWithForLoop(){
		List<Integer> initData = Collections.nCopies(100, 0);
		List<Integer> list = new ArrayList<Integer>(initData);
		for(int i = 0 , size = list.size() ; i < size ;i++){
			if(i >= 20 && i < 30)
				list.remove(i);
		}
	}
	
	@Test
	public void subListRemoveWithSubListClear(){
		List<Integer> initData = Collections.nCopies(100, 0);
		List<Integer> list = new ArrayList<Integer>(initData);
		list.subList(20,30).clear();
	}
	
	
	
	@Test
	public void subListSort(){
		List<Employee> list = new ArrayList<Employee>(5);
		
		list.add(new Employee(1001,"张三",Position.Boss));
		
		list.add(new Employee(1006,"赵七",Position.Manager));
		list.add(new Employee(1003,"王五",Position.Manager));
		
		list.add(new Employee(1002,"李四",Position.Staff));
		list.add(new Employee(1005,"马六",Position.Staff));
		
//		Collections.sort(list,new PositionComparator());
		Collections.sort(list);
		for(Employee e : list){
			System.out.println(e);
		}
	}
	
	enum  Position{
		Boss,Manager,Staff
	}

	class Employee implements Comparable<Employee>{
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Position getPosition() {
			return position;
		}

		public void setPosition(Position position) {
			this.position = position;
		}

		private int id;
		private String name;
		private Position position;
		
		Employee(int id,String name,Position position){
			this.id = id;
			this.name = name;
			this.position = position ;
		}

		@Override
		public int compareTo(Employee o) {
			// TODO Auto-generated method stub
			
//			int compareInt = new CompareToBuilder().append(position, o.position).toComparison();
//			if(compareInt == 0)
//				return new  CompareToBuilder().append(id, o.id).toComparison();
//			else
//				return compareInt ;
			
			return new CompareToBuilder().append(position, o.position).append(id, o.id).toComparison();
		}
		
		@Override
		public String toString(){
			return ToStringBuilder.reflectionToString(this);
		}	
	}
	
	class PositionComparator implements Comparator<Employee>{

		@Override
		public int compare(Employee o1, Employee o2) {
			// TODO Auto-generated method stub
			return o1.getPosition().compareTo(o2.getPosition());
		}
		
	}
}
