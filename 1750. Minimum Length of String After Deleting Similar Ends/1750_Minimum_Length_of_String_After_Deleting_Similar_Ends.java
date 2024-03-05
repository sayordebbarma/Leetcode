class Solution {
    public int minimumLength(String s) {
        char currChar = '#';
        String reducedStr = s;
        int start = 0;
        int end = s.length()-1;
        
        while(start<end) {
            if(reducedStr.charAt(start) == reducedStr.charAt(end))
                currChar = reducedStr.charAt(start);
            else break;

            while(start<reducedStr.length() && reducedStr.charAt(start)==currChar) start++;

            while(end>0 && reducedStr.charAt(end)==currChar) end--;
            if(start>end) return 0;

            reducedStr = reducedStr.substring(start, end+1);
            start = 0;
            end = reducedStr.length()-1;
        }

        return reducedStr.length();
    }
}
