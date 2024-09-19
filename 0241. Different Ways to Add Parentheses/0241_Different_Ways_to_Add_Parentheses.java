class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> leftResults = diffWaysToCompute(expression.substring(0, i));
                List<Integer> rightResults = diffWaysToCompute(expression.substring(i + 1));
                
                for (int left : leftResults) {
                    for (int right : rightResults) {
                        if (c == '+') result.add(left + right);
                        else if (c == '-') result.add(left - right);
                        else if (c == '*') result.add(left * right);
                    }
                }
            }
        }
        
        if (result.isEmpty()) result.add(Integer.parseInt(expression));
        
        return result;
    }
}
