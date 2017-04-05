package j151s.as;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class ListShuffle {
	
	private int tagCloudNum = 10 ;
	
	private List<String> tagClouds = new ArrayList<String>(tagCloudNum);
	
	@Test
	public void randomSet(){
		Random rand = new Random();
		for(int i = 0 ; i < tagCloudNum ;i++){
			int randomPosition = rand.nextInt(tagCloudNum);
			String temp = tagClouds.get(randomPosition);
			tagClouds.set(i, tagClouds.get(randomPosition));
			tagClouds.set(randomPosition, temp);
		}
	}
	
	@Test
	public void swap(){
		Random rand = new Random();
		for(int i = 0 ; i < tagCloudNum ;i++){
			int randomPosition = rand.nextInt(tagCloudNum);
			Collections.swap(tagClouds, i, randomPosition);
		}
	}
	
	@Test
	public void shuffle(){
		Collections.shuffle(tagClouds);
	}

}
