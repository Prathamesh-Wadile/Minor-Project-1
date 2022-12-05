package common.cases.method;
import java.util.ArrayList;
import common.utlities.common_method1;

public class DisplayStat extends common_method1  {
	public  void display_Stat() 
	{
		System.out.println("\n***********************************************************************\n");
		ArrayList<String> keys = new ArrayList<>(vtces.keySet());
		int i=1;
		for(String key : keys) 
		{
			System.out.println(i + ". " + key);
			i++;
		}
		System.out.println("\n***********************************************************************\n");
	}
}
