package simplealgos;

import java.util.*;

public class QuickSort {
    static Random R=new Random();
    static void sort(int[] a,Metrics m){ m.start(); qs(a,0,a.length-1,m);
        System.out.println("Quick "+m.stop()+"ms c="+m.c+" depth="+m.mx); }
    static void qs(int[] a,int l,int r,Metrics m){
        while(l<r){
            m.in();
            int p=part(a,l,r,m);
            if(p-l<r-p){ qs(a,l,p-1,m); l=p+1; }
            else{ qs(a,p+1,r,m); r=p-1; }
            m.out();
        }
    }
    static int part(int[] a,int l,int r,Metrics m){
        int piv=a[r],s=l;
        for(int i=l;i<r;i++){ m.cmp(); if(a[i]<piv){ int t=a[i];a[i]=a[s];a[s++]=t; } }
        int t=a[s];a[s]=a[r];a[r]=t; return s;
    }
}