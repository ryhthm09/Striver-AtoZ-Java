class Solution {
    public void moveZeroes(int[] nums) {
        int j=-1;
        //Finding the first zero
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                j=i;
                break;
            }
        }
        if(j==-1)return;//if no zeros then return
        //Iterating after the first zero and then swapping non zero element
        for(int i=j+1;i<nums.length;i++){
            if(nums[i]!=0){
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
                j++;
            }
        }
        
    }
}