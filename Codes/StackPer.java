import java.util.*;

public class StackPer {
    static boolean isStackPermutation(int[] input, int[] output, int n) {
        Stack<Integer> stack = new Stack<>();
        int j = 0;

        for (int i = 0; i < n; i++) {
            stack.push(input[i]);
            while (!stack.isEmpty() && stack.peek() == output[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Size:");
        int n = scanner.nextInt();

        int[] input = new int[n];
        int[] output = new int[n];

        System.out.println("Input array:");
        for (int i = 0; i < n; i++) {
            input[i] = scanner.nextInt();
        }

        System.out.println("Output array:");
        for (int i = 0; i < n; i++) {
            output[i] = scanner.nextInt();
        }

        if (isStackPermutation(input, output, n)) {
            System.out.println("Possible");
        } else {
            System.out.println("Not Possible");
        }
    }
}