import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class MaxNumberofKSumPairs {
    public int maxOperations(int[] nums, int k) {

        Arrays.sort(nums);
        int left =0;
        int right = nums.length-1;

        int answer = 0;

        while(true){

            if(left>=right){
                break;
            }

            int sum = nums[left]+nums[right];
            if(sum==k){
                answer++;
                left++;
                right--;
            }else if(sum<k){
                left++;
            }else{
                right--;
            }
        }
        return answer;
    }
}