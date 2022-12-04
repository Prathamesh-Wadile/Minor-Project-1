package common.utlities;
import java.util.ArrayList;
import java.util.HashMap;

public class base1{
	
	
	public class Vertex 
	{
		public HashMap<String, Integer> nbrs = new HashMap<>();
	}
	public int numVetex(HashMap<String, Vertex> vtces1) 
	{
		return vtces1.size();
	}

	public static boolean containsVertex(String vname,HashMap<String, Vertex> vtces1) 
	{ 
		return vtces1.containsKey(vname);
	}

	public void addVertex(String vname,HashMap<String, Vertex> vtces1) 
	{
		Vertex vtx = new Vertex();
		vtces1.put(vname, vtx);
	}

	public void removeVertex(String vname,HashMap<String, Vertex> vtces1) 
	{
		Vertex vtx = vtces1.get(vname);
		ArrayList<String> keys = new ArrayList<>(vtx.nbrs.keySet());

		for (String key : keys) 
		{
			Vertex nbrVtx = vtces1.get(key);
			nbrVtx.nbrs.remove(vname);
		}

		vtces1.remove(vname);
	}

	public int numEdges(HashMap<String, Vertex> vtces1) 
	{
		ArrayList<String> keys = new ArrayList<>(vtces1.keySet());
		int count = 0;

		for (String key : keys) 
		{
			Vertex vtx = vtces1.get(key);
			count = count + vtx.nbrs.size();
		}

		return count / 2;
	}

	public boolean containsEdge(String vname1, String vname2,HashMap<String, Vertex> vtces1) 
	{
		Vertex vtx1 = vtces1.get(vname1);
		Vertex vtx2 = vtces1.get(vname2);
		
		if (vtx1 == null || vtx2 == null || !vtx1.nbrs.containsKey(vname2)) {
			return false;
		}

		return true;
	}

	public void addEdge(String vname1, String vname2, int value,HashMap<String, Vertex> vtces1) 
	{
		Vertex vtx1 = vtces1.get(vname1); 
		Vertex vtx2 = vtces1.get(vname2); 

		if (vtx1 == null || vtx2 == null || vtx1.nbrs.containsKey(vname2)) {
			return;
		}

		vtx1.nbrs.put(vname2, value);
		vtx2.nbrs.put(vname1, value);
	}

	public void removeEdge(String vname1, String vname2,HashMap<String, Vertex> vtces1) 
	{
		Vertex vtx1 = vtces1.get(vname1);
		Vertex vtx2 = vtces1.get(vname2);
		
		//check if the vertices given or the edge between these vertices exist or not
		if (vtx1 == null || vtx2 == null || !vtx1.nbrs.containsKey(vname2)) {
			return;
		}

		vtx1.nbrs.remove(vname2);
		vtx2.nbrs.remove(vname1);
	}

}

