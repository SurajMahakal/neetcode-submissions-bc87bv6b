class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (String token: tokens) {
            switch (token) {
                case "+" -> {
                    int ans = stack.pop() + stack.pop();
                    stack.push(ans);
                }
                case "*" -> {
                    int ans = stack.pop() * stack.pop();
                    stack.push(ans);
                }
                case "-" -> {
                    int temp = stack.pop();
                    stack.push(stack.pop() - temp);
                }
                case "/" -> {
                    int div = stack.pop();
                    stack.push(stack.pop() / div);
                }

                default -> stack.push(Integer.parseInt(token));
            };
        }

        return stack.pop();
    }
}
