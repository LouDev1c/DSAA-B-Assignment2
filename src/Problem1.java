import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Problem1 {
    public static void main(String[] args) {
        /* 利用文件读入的方式可以得到动态数组numbers存放所需数组,之后对numbers进行操作即可
        ArrayList<Integer> numbers = new ArrayList<>();
        String file = "src/TestData.txt";
        String str = null;
        //读取文件
        try {
            //文件读取
            FileReader fr = new FileReader(file);
            //行读取
            LineNumberReader r = new LineNumberReader(fr);
            int number = 2;
            int lines = 0;
            String txt = "";
            //取得第二行一整行字符串
            while (txt != null) {
                lines++;
                txt = r.readLine();
                if (lines == number) {
                    str = txt;
                }
            }
            //将第二行按空格分开存到字符串数组strings中
            String[] strings = new String[0];
            if (str != null) {
                strings = str.split(" ");
            }
            //遍历strings，将其中元素改变数据类型后存入numbers
            for(String num : strings){
                numbers.add(Integer.parseInt(num));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        */
        int n = StdIn.readInt();
        int[] arr = StdIn.readAllInts();
        int res = Counter(arr);
        StdOut.println(res);
    }
    // 使用并归排序对子序列进行排序并统计交换次数
    public static int mergeSort(int[] arr, int left, int mid, int right, int[] temp){
        int counter = 0;
        int i = 0;
        int j = left;
        int k = mid + 1;
        while(j <= mid && k <= right){
            if(arr[j] < arr[k]){ temp[i++] = arr[j++]; }
            else{ temp[i++] = arr[k++]; counter += k-i;}
        }
        //若左边序列还有剩余，则将其全部放进tmp[]中
        while(j <= mid){ temp[i++] = arr[j++]; }
        while(k <= right){ temp[i++] = arr[k++]; }
        for(int t = 0; t < i; t++){ arr[left + t] = temp[t]; }
        return counter;
    }
    public static int merge(int[] arr, int left, int right, int[] temp){
        int counter = 0;
        if(left < right){
            int mid = (right + left)/2;
            counter += merge(arr, left, mid, temp); //对左边序列进行归并排序并计数
            counter += merge(arr, mid+1, right, temp);  //对右边序列进行归并排序并计数
            counter += mergeSort(arr, left, mid, right, temp);    //合并两个有序序列并计数
        }
        return counter;
    }
    //用一种更好的方式来输出结果
    public static int Counter(int[] arr) {
        int[] temp = new int[arr.length];
        return merge(arr, 0, arr.length - 1, temp);
    }
}
