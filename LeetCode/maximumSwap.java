class Solution {
    public int maximumSwap(int nn) {
       
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int ii=0;
        char[] num = (nn+"").toCharArray();
        while(ii<num.length){
            map.put(num[ii]-'0',ii); //latest occurence overwrites prev
            ii++;
        }
        
        for(int d=9;d>=0;d--){
            if(!map.containsKey(d))
                continue;
            int idx=map.get(d);
            for(int i=0;i<num.length;i++){
                if(i<idx&&num[i]-'0'<d)
                    return swap(num,idx,i);
            }
        }
        return Integer.parseInt(new String(num));
    }
    
    public int swap(char[] num, int i1, int i2){
        char temp=num[i1];
        num[i1]=num[i2];
        num[i2]=temp;
        return Integer.parseInt(new String(num));
    }
}
