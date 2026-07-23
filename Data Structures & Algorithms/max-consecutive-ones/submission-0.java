//Given: binary array nums, 
//Return: Max number of consecutive 1s in array

//Brute-force: O(n) 

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int runningTotal = 0;
        if (nums.length == 1) return nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                runningTotal++;
            } else {
                runningTotal = 0;
            }
            if (runningTotal > max) {
                max = runningTotal;
            }
        }
        return max;
    }
}