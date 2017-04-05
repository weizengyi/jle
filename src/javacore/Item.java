package javacore;


public class Item implements Comparable<Item>{
	
	private String description;
	private int partNumber;
	
	public Item(String aDescription,int aPartNumber){
		description = aDescription ;
		partNumber = aPartNumber ;
	}
	
	public String getDescription(){
		return description;
	}
	
	public String toString(){
		return "[description="+description+",partNumber="+partNumber+"]";
	}
	
	public boolean equals(Object otherObject){
		if (this == otherObject) return true;
		if(otherObject == null) return false;
		if(getClass()!=otherObject.getClass()) return false;
		Item other = (Item)otherObject;
		return description.equalsIgnoreCase(other.description) && partNumber == other.partNumber;
	}
	
	public int hashCode(){
		return java.lang.Object.class.hashCode();
	}

	@Override
	public int compareTo(Item other) {
		// TODO Auto-generated method stub
		return partNumber - other.partNumber;
	}

}
