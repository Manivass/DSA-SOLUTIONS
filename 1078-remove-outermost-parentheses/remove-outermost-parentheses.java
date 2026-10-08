class Solution {
    public String removeOuterParentheses(String str) {
        Deque<Character> stack = new ArrayDeque<>();
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(') {
                stack.push(ch);
                if (stack.size() > 1)
                    ans.append(ch);
            } else {
                if (stack.size() > 1)
                    ans.append(ch);

                stack.pop();
            }
        }
        return ans.toString();
    }
}