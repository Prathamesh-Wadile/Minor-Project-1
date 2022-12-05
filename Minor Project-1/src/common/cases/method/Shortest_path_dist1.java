package common.cases.method;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import common.utlities.base1;
import common.utlities.common_method1;

public class Shortest_path_dist1 extends Shortest_time1 {
	public void shortest_path_distance(BufferedReader inp) throws IOException {
		System.out.println("ENTER THE SOURCE AND DESTINATION STATIONS");
		String s1 = inp.readLine();
		String s2 = inp.readLine();
	
		HashMap<String, Boolean> processed2 = new HashMap<>();
		if(!base1.containsVertex(s1,common_method1.vtces) || !base1.containsVertex(s2,common_method1.vtces) || !this.hasPath(s1, s2, processed2))
			System.out.println("THE INPUTS ARE INVALID");
		
		else 
		{
			ArrayList<String> str = this.get_Interchanges(this.Get_Minimum_Distance(s1, s2));
			int len = str.size();
			System.out.println("SOURCE STATION : " + s1);
			System.out.println("DESTINATION STATION : " + s2);
			System.out.println("DISTANCE : " + str.get(len-1));
			//System.out.println("NUMBER OF INTERCHANGES : " + str.get(len-2));
			System.out.println(str);
			System.out.println("~~~~~~~~~~~~~");
			System.out.println("START  ==>  " + str.get(0));
			for(int i=1; i<len-3; i++)
			{
				System.out.println(str.get(i));
			}
			System.out.print(str.get(len-3) + "   ==>    END");
			System.out.println("\n~~~~~~~~~~~~~");
		}
	}
}
