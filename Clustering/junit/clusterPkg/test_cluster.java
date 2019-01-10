package clusterPkg;

import static org.junit.Assert.*;
import org.junit.Test;
import junit.framework.*;

public class test_cluster extends TestCase 
{
	//@Test
	//public void test() 
	//{
		//fail("Not yet implemented");
	//}
	public void testConstructor01()
	{
		int id = 3;
		cluster c = new cluster(id); 
	}
	
	public void testaddpoint() throws Exception
	{
		int dim = 2;
		double[] arr = new double[dim];
		arr[0] = 1.0;
		arr[1] = 0.7;
		point p = new point(dim, arr);
		cluster c = new cluster(1);
		c.addpoint(p);
		point p1 = c.points.get(0);
		assertTrue(p1.equals(p));
	}
	
	public void testaddpoint1() throws Exception
	{
		int dim = 2;
		double[] arr = new double[dim];
		arr[0] = 1.0;
		arr[1] = 0.7;
		point p = new point(dim, arr);
		int dim1 = 2;
		double[] arr1 = new double[dim1];
		arr1[0] = 3.7;
		arr1[1] = 1.1;
		point p1 = new point(dim1, arr1);
		cluster c = new cluster(1);
		c.addpoint(p);
		c.addpoint(p1);
		point pt = c.points.get(1);
		assertTrue(pt.equals(p1));
	}
	
	public void testremovepoint() throws Exception
	{
		int dim = 2;
		double[] arr = new double[dim];
		arr[0] = 1.0;
		arr[1] = 0.7;
		point p = new point(dim, arr);
		int dim1 = 2;
		double[] arr1 = new double[dim1];
		arr1[0] = 3.7;
		arr1[1] = 1.1;
		point p1 = new point(dim1, arr1);
		cluster c = new cluster(1);
		c.addpoint(p);
		c.addpoint(p1);
		c.removepoint(p);
		point pt = c.points.get(0);
		assertTrue(pt.equals(p1));
	}
	
	public void testsize() throws Exception
	{
		int dim = 2;
		double[] arr = new double[dim];
		arr[0] = 1.0;
		arr[1] = 0.7;
		point p = new point(dim, arr);
		int dim1 = 2;
		double[] arr1 = new double[dim1];
		arr1[0] = 3.7;
		arr1[1] = 1.1;
		point p1 = new point(dim1, arr1);
		cluster c = new cluster(1);
		c.addpoint(p);
		c.addpoint(p1);
		c.removepoint(p);
		int sz = c.size();
		assertTrue(sz == 1);
	}
	
	public void testsetCentroid() throws Exception
	{
		int dim = 2;
		double[] arr = new double[dim];
		arr[0] = 1.0;
		arr[1] = 0.7;
		point p = new point(dim, arr);
		int dim1 = 2;
		double[] arr1 = new double[dim1];
		arr1[0] = 3.7;
		arr1[1] = 1.1;
		point p1 = new point(dim1, arr1);
		cluster c = new cluster(1);
		c.addpoint(p);
		c.addpoint(p1);
		c.setCentroid(p1);
		point pt = c.centroid;
		assertTrue(pt.equals(p1));
	}
	
	public void testevaluateCentroid() throws Exception
	{
		int dim = 2;
		double[] arr = new double[dim];
		arr[0] = 1.0;
		arr[1] = 0.7;
		point p = new point(dim, arr);
		int dim1 = 2;
		double[] arr1 = new double[dim1];
		arr1[0] = 3.7;
		arr1[1] = 1.1;
		point p1 = new point(dim1, arr1);
		cluster c = new cluster(1);
		c.addpoint(p);
		c.addpoint(p1);
		c.evaluateCentroid();
		point pt = c.centroid;
		int dimExp =2;
		double[] arrExp = new double[dimExp];
		arrExp[0] = (arr[0]+arr1[0])/2 ;
		arrExp[1] = (arr[1]+arr1[1])/2;
		point ptExp = new point(dimExp, arrExp); 
		assertTrue(pt.equals(ptExp));
	}
}
