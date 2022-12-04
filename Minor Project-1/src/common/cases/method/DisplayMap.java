package common.cases.method;
import java.util.ArrayList;

public class DisplayMap extends DisplayStat{
	public void display_Map() 
	{
		System.out.println("\t Pune Metro Map");
		System.out.println("\t------------------");
		System.out.println("----------------------------------------------------\n");
		ArrayList<String> keys = new ArrayList<>(vtces.keySet());

		for (String key : keys) 
		{
			String str = key + " =>\n";
			Vertex vtx = vtces.get(key);
			ArrayList<String> vtxnbrs = new ArrayList<>(vtx.nbrs.keySet());
			
			for (String nbr : vtxnbrs)
			{
				str = str + "\t" + nbr + "\t";
				// to be check
                			if (nbr.length()<16)
                			str = str + "\t";
                			if (nbr.length()<8)
                			str = str + "\t";
                			str = str + vtx.nbrs.get(nbr) + "\n";
                			
			}
			System.out.println(str);
		}
		System.out.println("\t------------------");
		System.out.println("---------------------------------------------------\n");

	}
}
