package simplealgos;

public class MergeSort {
    static void sort(int[] a,Metrics m){ m.start(); int[] b=new int[a.length]; ms(a,b,0,a.length-1,m);
        System.out.println("Merge "+m.stop()+"ms c="+m.c+" depth="+m.mx); }
    static void ms(int[] a,int[] b,int l,int r,Metrics m){
        if(l>=r) return;
        m.in();
        int mid=(l+r)/2;
        ms(a,b,l,mid,m);
        ms(a,b,mid+1,r,m);
        int i=l,j=mid+1,k=l;
        while(i<=mid && j<=r){ m.cmp(); b[k++]=a[i]<=a[j]?a[i++]:a[j++]; }
        while(i<=mid) b[k++]=a[i++];
        while(j<=r)   b[k++]=a[j++];
        System.arraycopy(b,l,a,l,r-l+1);
        m.out();
    }
}