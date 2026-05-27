import java.util.HashMap;
import java.util.Map;

class MoveZeroes {
    public void moveZeroes(int[] nums) {

        int write = 0;
        for(int i=0;i<nums.length;i++){
            int cur = nums[i];
            if(cur!=0) {
                nums[write] = cur;
                write++;
            }
        }
        for(int i=write;i<nums.length;i++){
            nums[i] = 0;
        }
    }
}