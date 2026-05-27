class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int max = 0;

        while(true){

            if(left==right){
                break;
            }

            if(height[left]<height[right]){
                max = Math.max(height[left]*(right-left),max);
                left++;
            }else{
                max = Math.max(height[right]*(right-left),max);
                right--;
            }

        }
        return max;
    }
}