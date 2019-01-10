package clusterPkg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class point 
{
	protected int dimensions;
	protected double[] coordinate;
	
	public point(int _dimensions, double[] _coordinate) throws Exception
	{
		this.dimensions = _dimensions; 
		this.coordinate = new double[_dimensions];
		if(_coordinate.length != _dimensions)
		{
			throw new Exception("dimension mismatch!");
		}
		else
		{
		   for(int i=0; i<_dimensions;i++)
		   {
			   this.coordinate[i] = _coordinate[i];
		   }
		}
	}
	
	public int getNumberOfDimensions()
	{
		return this.dimensions;
	}
	
	public double getCoordinatei(int i)
	{
		return this.coordinate[i];
	}
	
	public double distance(point p) throws Exception
	{
		double dist = 0.0;
		if(this.dimensions != p.dimensions)
		{
			throw new Exception("dimension mismatch!");
		}
		for(int i=0; i< p.dimensions; i++)
		{
			dist = dist+(p.getCoordinatei(i)-this.getCoordinatei(i))*(p.getCoordinatei(i)-this.getCoordinatei(i));
		}
		dist = Math.sqrt(dist);
		double distRounded = Math.round(dist * 100D) / 100D;
		return distRounded;
	}
	
	public boolean equals(Object object)
	{
		if(this == object)
		{
			return true;
		}
		if(!(object instanceof point))
		{
			return false;
		}
		point p = (point) object;
		int flag = 0;
		if(p.dimensions == this.dimensions)
		{
			flag = 1;
		}
		double TOL = 0.01;
		for(int i=0; i<p.dimensions;i++)
		{
			if(((p.getCoordinatei(i)-this.getCoordinatei(i))>TOL)||((this.getCoordinatei(i)-p.getCoordinatei(i))>TOL))
			{
				flag = flag*0;
			}
		}
		if(flag == 1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	// This method finds the kth nearest centroid to a given point
	public int kthNearestCentroid(Centroid[] centroid, int k) throws Exception
	{
		int id = 0;
		int size = centroid.length;
		double[] dist = new double[size];
		List<Pair<Centroid, Double>> distancelist = new ArrayList<>();

		if(this.dimensions != centroid[0].centroid.dimensions)
		{
			throw new Exception("dimension mismatch!");
		}		
		else
		{
			for(int i=0; i< size; i++)
			{
				dist[i] = this.distance(centroid[i].centroid);
				distancelist.add(new Pair<Centroid, Double>(centroid[i], dist[i]));
			}
			Collections.sort(distancelist, new Comparator<Pair<Centroid, Double> >()
			{
				@Override
				public int compare(final Pair<Centroid, Double> obj1, final Pair<Centroid, Double> obj2)
				{
					if(obj1.o2 > obj2.o2)
					{
						return 1;
					}
					else if(obj1.o2 == obj2.o2)
					{
						return 0;
					}
					else
					{
						return -1;
					}
				}
			});
		}
		return distancelist.get(k-1).o1.clusterid;
	}
}
