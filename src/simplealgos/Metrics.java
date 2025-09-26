package simplealgos;

public class Metrics {
    public long c=0; public int d=0,mx=0; long t;
    public void cmp(){ c++; }
    public void in(){ if(++d>mx) mx=d; }
    public void out(){ d--; }
    public void start(){ t=System.nanoTime(); }
    public double stop(){ return (System.nanoTime()-t)/1e6; }
}
