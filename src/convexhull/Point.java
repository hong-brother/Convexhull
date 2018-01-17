package convexhull;

import java.util.Comparator;

public class Point implements  Comparable<Point>{
    int x, y;

    @Override
    public int compareTo(Point point) {
        if(this.x ==point.x){
            return this.y - point.y;
        }else{
            return this.x - point.x;
        }
    }


    public String toString(){
        return "("+x + "," + y+")";
    }


}

//참조
/*Comparable - 기본 정렬기준을 구현하는데 사용.
Comparator - 기본 정렬기준 외에 다른 기준으로 정렬하고자할 때 사용.*/

