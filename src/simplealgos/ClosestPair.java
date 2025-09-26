package simplealgos;

import java.util.*;

public class ClosestPair {
    static class P{double x,y;P(double x,double y){this.x=x;this.y=y;}}
    static double run(P[] p,Metrics m){
        Arrays.sort(p,Comparator.comparingDouble(a->a.x));
        m.start();
        double d=rec(p,0,p.length-1,m);
        System.out.println("Closest "+m.stop()+"ms c="+m.c+" depth="+m.mx);
        return d;
    }
    static double rec(P[] a,int l,int r,Metrics m){
        int n=r-l+1;
        if(n<=3){
            double best=1e18;
            for(int i=l;i<=r;i++)
                for(int j=i+1;j<=r;j++)
                    best=Math.min(best,dist(a[i],a[j],m));
            return best;
        }
        m.in();
        int mid=(l+r)/2;
        double d=Math.min(rec(a,l,mid,m),rec(a,mid+1,r,m));
        ArrayList<P> s=new ArrayList<>();
        for(int i=l;i<=r;i++)
            if(Math.abs(a[i].x - a[mid].x)<d) s.add(a[i]);
        s.sort(Comparator.comparingDouble(b->b.y));
        for(int i=0;i<s.size();i++)
            for(int j=i+1;j<s.size() && s.get(j).y-s.get(i).y<d;j++)
                d=Math.min(d,dist(s.get(i),s.get(j),m));
        m.out(); return d;
    }
    static double dist(P a,P b,Metrics m){ m.cmp(); return Math.hypot(a.x-b.x,a.y-b.y); }

}