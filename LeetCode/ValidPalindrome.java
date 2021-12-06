class Solution {
    public boolean isPalindrome(String s) {
        int i=0;
        int j=s.length()-1;
        s=s.toLowerCase();
        while(i<j){
            if(!Character.isLetter(s.charAt(i))&&!Character.isDigit(s.charAt(i))){
                i++;
                continue;
            }
            if(!Character.isLetter(s.charAt(j))&&!Character.isDigit(s.charAt(j))){
                j--;
                continue;
            }
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;

        }
        return true;
    }
}
