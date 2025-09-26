package simplealgos;

public class DeterministicSelect {
    static int select(int[] a,int k,Metrics m){ m.start(); int v=sel(a,0,a.length-1,k,m);
        System.out.println("Select "+m.stop()+"ms c="+m.c); return v; }
    static int sel(int[] a,int l,int r,int k,Metrics m){
        while(true){
            if(l==r) return a[l];
            m.in();
            int piv=a[l+(r-l)/2];
            int p=part(a,l,r,piv,m);
            int rank=p-l;
            if(k==rank){ m.out(); return a[p]; }
            else if(k<rank) r=p-1;
            else { k-=rank+1; l=p+1; }
            m.out();
        }
    }
    static int part(int[] a,int l,int r,int piv,Metrics m){
        int s=l;
        for(int i=l;i<=r;i++){ m.cmp(); if(a[i]<piv){ int t=a[i];a[i]=a[s];a[s++]=t; } }
        return s-1;
    }
}