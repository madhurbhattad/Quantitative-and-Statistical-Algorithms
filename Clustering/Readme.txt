This is read-me file for Clustering algorithm in Java.

The java project consists of point class, cluster class, Centroid class, Pair class, kmeans class and kmeans1 class.
All this classes along with their unit tests should be in a same java package. In the project that package is named as clusterPkg.

For the stopping criteria in kmeans and kmeans1 algorithm we use number of iterations. That is the algorithm loops through for a given number of iterations before stopping.
While kmeans is the implementation of standard Llyod's algorithm, the kmeans1 algorithm is the algorithm in which sizes of every cluster is fixed. 

The point class consists of dimension and coordinates as instance variables.
The cluster class consists of an integer cluster id, a point centroid and a list of points belonging to that array.
The centroid class consists of an integer cluster id that maps a particular centroid to the respective cluster, and a point centroid.

There are main methods in kmeans and kmeans1 classes. These classes represent our main algorithms. Running these gives us the centroid ids and there respective co-ordinates.
Note the constructor of kmeans1 class takes an input of maximum acceptable cluster size in addition to kmeans.
implementkmeanAlgo/implementkmean1Algo are methods in respective classes that takes an integer count as input. The method is then implemented count number of times.

For the purpose of testing efficiency, we calculate the mean distance of each of the centroids obtained from the geometric center of the data points. 
Now consider a good analytical solution (say for example dividing x-axis in 4s and y-axis in 5's). We calculate the mean distance of each centroid for this solution. 
For the case of the mean distance, say d, of analytical solution, we equate efficiency equals 1. 
For solutions with mean distance d1, if 0<d1<d, we find efficiency by linear interpolation between (0,0) and (d,1). This comesout to be d1/d. 
For solutions with mean distance d1, if d1>d, we find efficiency by using exponential decay function. (exp((d-d1)/d))
Note d1< 0  is a invalid case.


On running the implementation for kmean algorithm for 100 iterations, we got efficiency of 0.97
When we run implementation for kmean1 algorithm for 10 iterations, which takes about an hour, we got efficiency of 0.83



