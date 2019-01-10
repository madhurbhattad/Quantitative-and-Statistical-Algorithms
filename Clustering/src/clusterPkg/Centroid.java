package clusterPkg;

public class Centroid 
{
	public int clusterid;
	public point centroid;
	
	public Centroid(int _id, point _point)
	{
		this.clusterid = _id;
		this.centroid = _point;
	}
}
