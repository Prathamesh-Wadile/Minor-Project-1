package common.cases.method;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;
import common.utlities.base1;
import common.utlities.common_method1;


public class Shortest_dist1 extends DisplayMap{
	public static String[] printCodelist()
	{
		System.out.println("List of station along with their codes:\n");
		ArrayList<String> keys = new ArrayList<>(vtces.keySet());
		int i=1,j=0,m=1;
		StringTokenizer stname;
		String temp="";
		String codes[] = new String[keys.size()];
		char c;
		for(String key : keys) 
		{
			stname = new StringTokenizer(key);
			codes[i-1] = "";
			j=0;
			while (stname.hasMoreTokens())
			{
			        temp = stname.nextToken();
			        c = temp.charAt(0);
			        while (c>47 && c<58)
			        {
			                codes[i-1]+= c;
			                j++;
			                c = temp.charAt(j);
			        }
			        if ((c<48 || c>57) && c<123)
			                codes[i-1]+= c;
			}
			if (codes[i-1].length() < 2)
				codes[i-1]+= Character.toUpperCase(temp.charAt(1));
			            
			System.out.print(i + ". " + key + "\t");
			if (key.length()<(22-m))
                			System.out.print("\t");
			if (key.length()<(14-m))
                			System.out.print("\t");
                		if (key.length()<(6-m))
                			System.out.print("\t");
                		System.out.println(codes[i-1]);
			i++;
			if (i == (int)Math.pow(10,m))
			        m++;
		}
		return codes;
	}
	public void Shortest_distance(BufferedReader inp) throws NumberFormatException, IOException {
		ArrayList<String> keys = new ArrayList<>(common_method1.vtces.keySet());
		String codes[] = printCodelist();
		System.out.println("\n1. TO ENTER SERIAL NO. OF STATIONS\n2. TO ENTER CODE OF STATIONS\n3. TO ENTER NAME OF STATIONS\n");
		System.out.println("ENTER YOUR CHOICE:");
	        int ch = Integer.parseInt(inp.readLine());
		int j;
			
		String st1 = "", st2 = "";
		System.out.println("ENTER THE SOURCE AND DESTINATION STATIONS");
		if (ch == 1)
		{
		    st1 = keys.get(Integer.parseInt(inp.readLine())-1);
		    st2 = keys.get(Integer.parseInt(inp.readLine())-1);
		}
		else if (ch == 2)
		{
		    String a,b;
		    a = (inp.readLine()).toUpperCase();
		    for (j=0;j<keys.size();j++)
		       if (a.equals(codes[j]))
		           break;
		    st1 = keys.get(j);
		    b = (inp.readLine()).toUpperCase();
		    for (j=0;j<keys.size();j++)
		       if (b.equals(codes[j]))
		           break;
		    st2 = keys.get(j);
		}
		else if (ch == 3)
		{
		    st1 = inp.readLine();
		    st2 = inp.readLine();
		}
		else
		{
		    System.out.println("Invalid choice");
		    System.exit(0);
		}
	
		HashMap<String, Boolean> processed = new HashMap<>();
		if(!base1.containsVertex(st1,common_method1.vtces) || !base1.containsVertex(st2,common_method1.vtces) || !this.hasPath(st1, st2, processed))
			System.out.println("THE INPUTS ARE INVALID");
		else
		System.out.println("SHORTEST DISTANCE FROM "+st1+" TO "+st2+" IS "+this.dijkstra(st1, st2, false)+"KM\n");
		
	}
}
