import java.util.HashMap;
import java.util.Map;

public class ContiguousArr {
    public static void main(String[] args) {
        int[] arr = { 0, 1, 0 };
        System.out.println(maxLenContiguousSubArr(arr));

    }

    private static int maxLenContiguousSubArr(int[] nums) {

        Map<Integer, Integer> sumToMinIdx = new HashMap<>();
        int[] prefix = new int[nums.length];
        int maxLength = 0;

        prefix[0] = (nums[0] == 0) ? -1 : 1;
        sumToMinIdx.put(0, -1);
        sumToMinIdx.put(prefix[0], 0);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 0) {
                prefix[i] = prefix[i - 1] - 1;
            } else {
                prefix[i] = prefix[i - 1] + 1;
            }

            if (sumToMinIdx.containsKey(prefix[i])) {
                maxLength = Math.max(maxLength, i - sumToMinIdx.get(prefix[i]));
            } else {
                sumToMinIdx.put(prefix[i], i);
            }

        }

        return maxLength;
    }
}
