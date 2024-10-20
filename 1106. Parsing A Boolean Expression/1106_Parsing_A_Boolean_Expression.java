class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> stack = new Stack<>();

        for (char ch : expression.toCharArray()) {
            if (ch == ',') {
                continue;
            } else if (ch != ')') {
                stack.push(ch);
            } else {
                Stack<Character> tempStack = new Stack<>();
                
                while (stack.peek() != '(') {
                    tempStack.push(stack.pop());
                }
                
                stack.pop();
                
                char operator = stack.pop();
                
                boolean result = false;
                
                if (operator == '!') {
                    char value = tempStack.pop();
                    result = (value == 'f');
                } else if (operator == '&') {
                    result = true;
                    while (!tempStack.isEmpty()) {
                        char value = tempStack.pop();
                        if (value == 'f') result = false;
                    }
                } else if (operator == '|') {
                    result = false;
                    while (!tempStack.isEmpty()) {
                        char value = tempStack.pop();
                        if (value == 't') result = true;
                    }
                }

                stack.push(result ? 't' : 'f');
            }
        }
        
        return stack.pop() == 't';
    }
}
