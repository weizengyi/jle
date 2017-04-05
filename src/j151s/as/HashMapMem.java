package j151s.as;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

public class HashMapMem {
	
	@Test
	public void hashMapMem(){
		Map<String,String> map = new HashMap<String,String>() ;
		final Runtime rt = Runtime.getRuntime() ;
		rt.addShutdownHook(new Thread(){
			public void run(){
				StringBuffer sb = new StringBuffer();
				long heapMaxSize = rt.maxMemory() >> 20;
				sb.append("max heap size:" + heapMaxSize + " M\n");
				long total = rt.totalMemory() >> 20;
				sb.append("total memory size:" + total + " M\n");
				long free = rt.freeMemory() >> 20;
				sb.append("free memory size:" + free + " M\n");
			}
		}
		);
		
		for(int i = 0 ; i < 393217 ; i ++){
			map.put("key"+i, "value"+i);
		}
	}

}
