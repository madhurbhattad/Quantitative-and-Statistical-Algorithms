package clusterPkg;

import static org.junit.Assert.*;
import org.junit.Test;
import junit.framework.*;

public class test_pair extends TestCase
{
	//@Test
	//public void test() 
	//{
		//fail("Not yet implemented");
	//}
	public void testpairconstructor() throws Exception
	{
		Centroid ct;
		double d = 0.0;
		int dim =2;
		double[] arr = new double[dim];
		arr[0] = 1.0;
		arr[1] = 0.0;
		point p = new point(dim, arr);
		int id = 1;
		ct = new Centroid(id, p);
		Pair pr = new Pair(ct,id);
	}
	
	public void testgetFirstObject() throws Exception
	{
		Centroid ct;
		//double d = 0.0;
		int dim =2;
		double[] arr = new double[dim];
		arr[0] = 1.0;
		arr[1] = 0.0;
		point p = new point(dim, arr);
		int id = 1;
		ct = new Centroid(id, p);
		Pair pr = new Pair(ct,id);
		Centroid expectedct = (Centroid)pr.getFirstObject();
		int testid= expectedct.clusterid;
		point testpt = expectedct.centroid;
		assertTrue((testid==id)&&(testpt.equals(p)));
	}
	
	public void testgetSecondObject() throws Exception
	{
		Centroid ct;
		double d = 0.0;
		int dim =2;
		double[] arr = new double[dim];
		arr[0] = 1.0;
		arr[1] = 0.0;
		point p = new point(dim, arr);
		int id = 1;
		ct = new Centroid(id, p);
		Pair pr = new Pair(ct,d);
		double testd = (double)pr.getSecondObject();
		assertTrue(testd == d);
	}
}
