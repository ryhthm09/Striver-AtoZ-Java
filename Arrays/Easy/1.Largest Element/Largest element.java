class Solution {
    public static int largest(int n, int[] arr) {
        // code here
        int maxi=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            maxi=Math.max(arr[i],maxi);
        }
        return maxi;
    }
}
