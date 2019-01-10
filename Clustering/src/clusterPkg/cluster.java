package clusterPkg;

import java.util.ArrayList;
import java.util.List;

public class cluster 
{
	public int clusterid;
	public point centroid;
	public List<point> points;
	
	public cluster(int _id)
	{
		this.clusterid = _id;
		this.centroid = null;
		this.points = new ArrayList<point>();
	}
	
	public void addpoint(point p)
	{
		points.add(p);
	}
	
	public void removepoint(point p)
	{
		points.remove(p);
	}
	
	public int size()
	{
		return points.size();
	}
	
	public void setCentroid(point p)
	{
		centroid = p; 
	}
	
	//public point getCentroid()
	//{
		//return this.centroid;
	//}
	// From a given list of points in a cluster, this method evaluates centroid
	public void evaluateCentroid() throws Exception
	{
		int sz = points.size();
		int dim=0;
		if(!(points.isEmpty()))
		{
			dim = points.get(0).dimensions;
		}
		double[] arr = new double[dim];
		for(int i=0; i<dim; i++)
		{
			arr[i] = 0.0;
		}	
		for(int jt=0; jt<sz; jt++)
		{
			for(int it=0; it<dim; it++)
			{
				arr[it]= arr[it] + points.get(jt).getCoordinatei(it);
			}
		}
		for(int j=0; j<dim; j++)
		{
			arr[j] = arr[j]/sz;
		}
		point geometricCenter = new point(dim, arr);
		this.centroid = geometricCenter;
	}
}
