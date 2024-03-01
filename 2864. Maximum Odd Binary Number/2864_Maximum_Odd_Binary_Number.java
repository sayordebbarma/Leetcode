class Solution {
    public String maximumOddBinaryNumber(String s) {
        char chars[] = s.toCharArray();
        int count = 0;
        for(char c : chars) {
            if(c=='1') count++;
        }
        chars[chars.length-1]='1';
        count--;
        int i=0;

        for(int j=1; j<=count; j++) chars[i++]='1';

        for(; i<chars.length-1; i++) chars[i]='0';

        return String.valueOf(chars);
    }
}
