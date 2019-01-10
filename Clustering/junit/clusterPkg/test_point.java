package clusterPkg;

import static org.junit.Assert.*;
import org.junit.Test;
import junit.framework.*;

public class test_point extends TestCase 
{
	//@Test
	//public void test() 
	//{
		//fail("Not yet implemented");
	//}
	public void testconstructor() throws Exception
	{
		int dim =2;
		double[] arr = new double[dim];
		arr[0] = 1.0;
		arr[1] = 0.0;
		point p = new point(dim, arr);
	}
	
	public void testgetNumberOfDimensions() throws Exception
	{
		int dim =2;
		double[] arr = new double[dim];
		arr[0] = 1.0;
		arr[1] = 0.0;
		point p = new point(dim, arr);
		int n = p.getNumberOfDimensions();
		assertTrue(n == dim);
	}
	
	public void testgetCoordinatei() throws Exception
	{
		int dim =2;
		double[] arr = new double[dim];
		arr[0] = 1.0;
		arr[1] = 0.0;
		point p = new point(dim, arr);
		double xi = p.getCoordinatei(0);
		assertTrue(xi == arr[0]);
	}
	
	public void testdistance() throws Exception
	{
		double TOL =0.01;
		int dim1 =2;
		double[] arr1 = new double[dim1];
		arr1[0] = 0.6;
		arr1[1] = 1.0;
		point p1 = new point(dim1, arr1);
		int dim2 =2;
		double[] arr2 = new double[dim2];
		arr2[0] = 0.3;
		arr2[1] = 1.4;
		point p2 = new point(dim2, arr2);
		double dist = p1.distance(p2);
		double d = 0.5;
		assertTrue(((dist-d) <= TOL) || ((d-dist) <= TOL));
	}
	
	public void testequals() throws Exception
	{
		int dim1 =2;
		double[] arr1 = new double[dim1];
		arr1[0] = 0.6;
		arr1[1] = 1.0;
		point p1 = new point(dim1, arr1);
		int dim2 =2;
		double[] arr2 = new double[dim2];
		arr2[0] = 0.6;
		arr2[1] = 1.0;
		point p2 = new point(dim2, arr2);
		assertTrue(p1.equals(p2));
	}
	
	public void testkthNearestCentroid() throws Exception
	{
		Centroid[] ct = new Centroid[3];
		int dim1 =2;
		double[] arr1 = new double[dim1];
		arr1[0] = 0.0;
		arr1[1] = 1.0;
		point p1 = new point(dim1, arr1);
		int dim2 =2;
		double[] arr2 = new double[dim2];
		arr2[0] = 1.0;
		arr2[1] = 0.0;
		point p2 = new point(dim2, arr2);
		int dim3 =2;
		double[] arr3 = new double[dim3];
		arr3[0] = 0.0;
		arr3[1] = 0.0;
		point p3 = new point(dim3, arr3);
		ct[0] = new Centroid(1, p1);
		ct[1] = new Centroid(2, p2);
		ct[2] = new Centroid(3, p3);
		
		int dim =2;
		double[] arr = new double[dim];
		arr[0] = 1.0;
		arr[1] = 1.0;
		point p = new point(dim, arr);
		int check1 = p.kthNearestCentroid(ct, 3);
		assertTrue(check1 == 3);
	}
}
