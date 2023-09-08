import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Stack;
public class Problem2 {
    public static void main(String[] args) throws Exception{
        String n_str = StdIn.readString();
        long k = StdIn.readLong();
        //题目要求k <= n.length()且除0之外n不含先导0，那么大于时或是有先导0都应当是有问题的
        if( k > n_str.length() || n_str.charAt(0) == '0'){
            throw new Exception("输入有问题");
        }
        //当k = n.length()时，这么多位都被删除掉，结果就是0了
        if( k == n_str.length()){
            StdOut.println(0);
            System.exit(0);
        }
        //其余的就是k <= n.length()的情况
        Stack<Character> stack = new Stack<>();
        long counter = 0;
        //从n_str第一位开始前后两位作比较，只要前<后就把前删去直到处理k次
        for (char element : n_str.toCharArray()) {
            while (!stack.isEmpty() && counter < k && stack.peek() <= element) {
                stack.pop();
                counter++;
            }
            stack.push(element);
        }
        // 将结果转换为字符串，因为栈顺序与结果相同，但是pop时后进先出，所以过程结束后要反转字符串
        StringBuilder str = new StringBuilder();
        while (!stack.isEmpty()) {
            str.append(stack.pop());
        }
        str.reverse();
        StdOut.println(str);
    }
}
