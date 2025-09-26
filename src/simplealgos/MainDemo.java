package simplealgos;

import java.util.*;

public class MainDemo {
    static int[] rndArr(int n){ Random r=new Random(); int[] a=new int[n];
        for(int i=0;i<n;i++) a[i]=r.nextInt(n*10); return a; }
    static boolean sorted(int[] a){ for(int i=1;i<a.length;i++) if(a[i-1]>a[i]) return false; return true; }

    public static void main(String[] args){
        Metrics m=new Metrics();
        int n=3000;
        int[] base=rndArr(n);

        int[] a1=base.clone(); MergeSort.sort(a1,m); System.out.println("Sorted? "+sorted(a1));
        m=new Metrics();
        int[] a2=base.clone(); QuickSort.sort(a2,m); System.out.println("Sorted? "+sorted(a2));
        m=new Metrics();
        int k=n/2; int val=DeterministicSelect.select(base.clone(),k,m);
        System.out.println("Median value = "+val);
        m=new Metrics();
        ClosestPair.P[] pts=new ClosestPair.P[1000];
        Random r=new Random();
        for(int i=0;i<pts.length;i++) pts[i]=new ClosestPair.P(r.nextDouble()*1000,r.nextDouble()*1000);
        double d=ClosestPair.run(pts,m);
        System.out.println("Closest distance = "+d);
    }
}