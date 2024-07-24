class Solution {
    public int removeDuplicates(int[] nums) {
        int i=0;
        int k=1;
        for(int j=1;j<nums.length;j++){
           if(nums[i]!=nums[j]){
               nums[i+1]=nums[j];
               i++;
               k++;
           }
        }
        return k;
    }
}