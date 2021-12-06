class BasicCalculator {
    public int calculate(String s) {
        c=0;
        return eval(s);    
    }
     static int c=0;
    public int eval(String s){

        Integer n1=null;
        int mul=1;
        int num=0;
        while(c<s.length()){
            // System.out.println(n1+" "+mul+" "+c);
            if(s.charAt(c)==')'){
                return (int) n1;
                
            }

            if(s.charAt(c)=='('){
                int brackets=1;
                c++; 
                    if(n1==null)
                     n1= (mul*eval(s));
                    else {   
                      n1= n1+mul*(eval(s));
                    }      
            }
            else if(s.charAt(c)=='+')
                mul=1;
            
            else if(s.charAt(c)=='-')
                    mul=-1;  
            
            else if(isDigit(s.charAt(c))){
                num=0;
                while(c<s.length()&&isDigit(s.charAt(c))){
                    num*=10;
                    num+=(s.charAt(c)-'0');
                    c++;
                }
                c--;
                if(n1==null) n1=(mul*num);
                else{n1=n1+(mul*num);
                    }
            
            }else{
                c++;
                continue;
            }
            c++;
        }
        
        return n1==null? 0: n1;
    }
 public static boolean isDigit(char c) {
        return '0' <= c && c <= '9';
    }
}
