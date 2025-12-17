class Stack {
    private java.util.Stack<Character> stack = new java.util.Stack<>();

    public void push(char item) {
        stack.push(item);
    }

    public char pop() {
        if (isEmpty()) {
            return Character.MIN_VALUE; // Null equivalent
        }
        return stack.pop();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public char peek() {
        if (isEmpty()) {
            return Character.MIN_VALUE;
        }
        return stack.peek();
    }
}

public class Valid_Paranthesis {
    public static boolean isValid(String s) {
        Stack st = new Stack();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(' || c == '{' || c == '[') {
                st.push(c);
            } else {
                if (st.isEmpty()) {
                    return false;
                }

                if (c == ')' && st.peek() == '(') {
                    st.pop();
                } else if (c == '}' && st.peek() == '{') {
                    st.pop();
                } else if (c == ']' && st.peek() == '[') {
                    st.pop();
                } else {
                    return false;
                }
            }
        }

        return st.isEmpty();
    }

    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(isValid(s)); // true
    }
}
