package convexhull;


import java.util.Arrays;

/**
 * onvexHull Algorithm - Graham scan
 * <pre>
 * <b>History:</b>
 *    hsnam, 1.0, 2018.1.17 init Commit
 * </pre>
 *
 * @author hsnam
 * @version 1.0
 * @see
 */
public class ConvexHull {
    //http://secmem.tistory.com/554
    //http://119.201.123.184/30stair/convex_hull/convex_hull.php?pname=convex_hull
    // wiki
    //https://en.wikibooks.org/wiki/Algorithm_Implementation/Geometry/Convex_hull/Monotone_chain
    /*private Point[] point;
    public ConvexHull(Point[] p){
        this.point = p;
    }*/

    private static long crossProduct (Point O, Point A, Point B){
        return (A.x - O.x) * (B.y - O.y) - (A.y - O.y) * (B.x - O.x);
    }//백터 외적

    public Point[] convex_hull(Point[] point){
        if(point.length > 1){
            int n = point.length;
            int k = 0;
            Point[] H =new Point[2*n];


            Arrays.sort(point);

            for(int i=0; i<n; ++i){
                while(k>=2 && crossProduct(H[k-2], H[k-1], point[i]) <= 0)
                    k--;
                H[k++] = point[i];
            }//Build lower hull

            for (int i = n - 2, t = k + 1; i >= 0; i--) {
                while(k>=t && crossProduct(H[k-2], H[k-1], point[i]) <= 0)
                    k--;
                H[k++] =point[i];
            }//Build upper hull
            if(k>1){
                H = Arrays.copyOfRange(H, 0, k - 1); // remove non-hull vertices after k; remove k - 1 which is a duplicate
            }
            return H;
        }else if(point.length<= 1){
            return  point;
        }else{
            return null;
        }
    }


}
