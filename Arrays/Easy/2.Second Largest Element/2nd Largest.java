//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input = sc.nextLine();
            Scanner ss = new Scanner(input);
            while (ss.hasNextInt()) {
                arr.add(ss.nextInt());
            }
            Solution ob = new Solution();
            int ans = ob.print2largest(arr);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int print2largest(List<Integer> arr) {
        // Code Here
        int max1=-1;
        int max2=-1;
        //use two variables max1 to store maximum and max2 to store second maximum
        for(int i=0;i<arr.size();i++){
            //if you find any greater element than update it as max and update max2 as max1
            if(arr.get(i)>max1){
                max2=max1;
                max1=arr.get(i);
            //else if you find any element maximum than max2 but it is not equal to maxi then it is max2
            }else if(arr.get(i)>max2 && arr.get(i)!=max1){
                max2=arr.get(i);
            }
        }
        return max2;
    }
}