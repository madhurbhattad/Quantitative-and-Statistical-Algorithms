package clusterPkg;

import java.util.Random;

public class kmeans 
{
	public int k;
	public point[] datapt;
	public Centroid[] center;
	public cluster[] ourcluster;
	
	public kmeans(int _k, point[] _pt) throws Exception
	{
		this.k = _k;
		int dim = _pt[0].dimensions;

		this.datapt = new point[(_pt.length)];
		this.center = new Centroid[_k];
		this.ourcluster = new cluster[_k];

		int[] ints = new Random().ints(0, ((_pt.length)-1)).distinct().limit(_k).toArray();
		
		for(int i=0; i<_pt.length; i++)
		{
			this.datapt[i] = _pt[i];
		}
		
		for(int j=0; j< _k; j++)
		{
			point p = _pt[(ints[j])];
			this.center[j] = new Centroid(j+1, p);
			this.ourcluster[j] = new cluster(j+1);
			this.ourcluster[j].centroid = p;
		}
	}
	
	public void implementkmeanAlgo(int count) throws Exception
	{
		int repeat = count;
		while(repeat > 0)
		{
			// Implement Algorithm
			// Going from centers to cluster Step
			for(int i=0; i<datapt.length; i++)
			{
				int id = datapt[i].kthNearestCentroid(this.center, 1);
				this.ourcluster[id-1].addpoint(datapt[i]);
			}
			
			// Going from cluster to centers step
			for(int j=0; j< this.k; j++)
			{
				this.ourcluster[j].evaluateCentroid();
				this.center[j] = new Centroid(j+1,this.ourcluster[j].centroid);					
			}
			repeat--;
		}
	}
	
	public double distancekmean(point geocenter) throws Exception
	{
		double meandistance = 0;
		for(int i =0; i<this.k; i++)
		{
			meandistance = meandistance + geocenter.distance(this.center[i].centroid);
		}
		meandistance = meandistance/(this.k);
		return meandistance;
	}
	
	public double efficiency(double idealdist, double ourdist)
	{
		double eff = 0.0;
		if(idealdist >= ourdist)
		{
			if(ourdist == 0)
			{
				eff = 0.0;
			}
			else
			{
				eff = ((ourdist)/(idealdist)) ; 
			}
		}
		else
		{
			eff = Math.exp((idealdist-ourdist));
		}
		return eff;
	}
	
	public static void main(String[] args) throws Exception 
	{
		// Generating 5 unique random integers between 0 and 100 
		//int[] ints = new Random().ints(0, 100).distinct().limit(5).toArray();
		//System.out.println("abc");
		int dim = 2;
		point[] dataarr = new point[10000];
		for(int ix =0; ix<100; ix++)
		{
			for(int iy=0; iy<100; iy++)
			{
				double[] temparr = new double[2];
				temparr[0]= (double) ix;
				temparr[1]= (double) iy;
				point temppoint = new point(2, temparr);
				dataarr[((100*ix)+iy)]= temppoint;
			}
		}
		int k = 500;
		// The below line is required for running code for k>100
		// This basically just changes the settings in collection.sort
		System.setProperty("java.util.Arrays.useLegacyMergeSort", "true");
		kmeans Obj = new kmeans(k, dataarr);
		Obj.implementkmeanAlgo(100);
		for(int it=0; it< Obj.center.length; it++)
		{
			System.out.println("id: " + Obj.center[it].clusterid);
			double dx = Obj.center[it].centroid.getCoordinatei(0);
			System.out.println("x: " + Double.toString(dx));
			double dy = Obj.center[it].centroid.getCoordinatei(1);
			System.out.println("y: " + Double.toString(dy));
		}
		double[] geoArr = new double[2];
		geoArr[0] = 45.5;
		geoArr[1] = 45.5;
		point geocenter = new point(2, geoArr);
		double avgDist = Obj.distancekmean(geocenter);
		System.out.println("avgDist = " + avgDist);
		double idealDist = 37.97;
		double efficiency = Obj.efficiency(idealDist, avgDist);
		System.out.println(efficiency);
	}
}
