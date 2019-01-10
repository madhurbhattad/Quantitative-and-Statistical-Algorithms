package clusterPkg;

import static org.junit.Assert.*;
import org.junit.Test;
import junit.framework.*;

public class test_Centroid extends TestCase
{
	//@Test
	//public void test() 
	//{
		//fail("Not yet implemented");
	//}
	public void testCentroidConstructor() throws Exception
	{
		int id =4;
		int dim =2;
		double[] arr = new double[dim];
		arr[0] = 1.0;
		arr[1] = 0.0;
		point p = new point(dim, arr);
		Centroid c = new Centroid(id, p);
	}
}
