class Solution {
    public double myPow(double x, int n) {
        boolean xneg=false;
        long nn=n;
        if(x<0){
            x=x*-1;
            xneg=true;
        }
        if(n<0){
            nn=n;
            nn*=-1;
        }
        double res=pow(x,nn);
        if(xneg && n%2!=0){
            res*=-1;
        }
        if(n<0){
            res=1/res;
        }
        return res;
    }
    
    public double pow(double x, long n){
        if(n==0)
            return 1;
        
        double temp= pow(x,n/2);
        temp=temp*temp*(n%2==1?x:1);
        return temp;
        
    }
    
    
    
}
