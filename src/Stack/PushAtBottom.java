package Stack;

public class PushAtBottom {
    public static void pushAtBottom(int value, Stack stack) {
        if (stack.isEmpty()) {
            stack.push(value);
        }
        int top = stack.pop();
        pushAtBottom(top, stack);
        stack.push(value);

    }


    public static void main(String[] args) {
         Stack stack = new Stack(6);
         stack.push(1);
         stack.push(2);
         stack.push(3);
         System.out.println(" "+stack.pop());
        pushAtBottom(3, stack);
    }
}
