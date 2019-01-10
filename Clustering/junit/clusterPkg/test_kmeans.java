package clusterPkg;

import static org.junit.Assert.*;
import org.junit.Test;
import junit.framework.*;

public class test_kmeans extends TestCase
{
	//@Test
	//public void test() 
	//{
		//fail("Not yet implemented");
	//}
	public void testkmeansconstructor() throws Exception
	{
		int k = 2;
		point[] dataarr = new point[4];
		Centroid[] center = new Centroid[k];
		int dim1 =2;
		double[] arr1 = new double[dim1];
		arr1[0] = 0.0;
		arr1[1] = 1.0;
		point p1 = new point(dim1, arr1);
		dataarr[0] = p1;
		int dim2 =2;
		double[] arr2 = new double[dim2];
		arr2[0] = 1.0;
		arr2[1] = 0.0;
		point p2 = new point(dim2, arr2);
		dataarr[1] = p2;
		int dim3 =2;
		double[] arr3 = new double[dim3];
		arr3[0] = 0.0;
		arr3[1] = 0.0;
		point p3 = new point(dim3, arr3);
		dataarr[2] =p3;
		int dim4 =2;
		double[] arr4 = new double[dim4];
		arr4[0] = 5.0;
		arr4[1] = 0.0;
		point p4 = new point(dim4, arr4);
		dataarr[3] = p4;
		kmeans Obj = new kmeans(k, dataarr);
	}
	
	public void testimplementkmeanAlgo() throws Exception
	{
		int dim = 2;
		point[] dataarr = new point[100];
		for(int ix =0; ix<10; ix++)
		{
			for(int iy=0; iy<10; iy++)
			{
				double[] temparr = new double[2];
				temparr[0]= (double) ix;
				temparr[1]= (double) iy;
				point temppoint = new point(2, temparr);
				dataarr[((10*ix)+iy)]= temppoint;
			}
		}
		int k = 5;
		kmeans Obj = new kmeans(k, dataarr);
		Obj.implementkmeanAlgo(5);
	}
}
