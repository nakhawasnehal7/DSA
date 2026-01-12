package Stack;

public class ReverseStack {

    public static void reverse(Stack stack){
        if(stack.isEmpty()){
            return;
        }
        int top = stack.pop();
        reverse(stack);
        pushAtBottom(top, stack);

    }
    public static void pushAtBottom(int value, Stack stack) {
        if (stack.isEmpty()) {
            stack.push(value);
        }
        int top = stack.pop();
        pushAtBottom(top, stack);
        stack.push(value);

    }


    public static void main(String[] args) {

    }
}
