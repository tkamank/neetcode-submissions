// inp: heights arr, heights[i] = height of ith bar
// Choose any two bars, return maximum amount of water
// left pointer, right pointer
// As we get toward the center, we calculate dist * height (lesser wall)
// Keep global max

// 8 - 1 => 5 * 6

class Solution {
    public int maxArea(int[] heights) {
        int maxArea = -1;
        int leftPointer = 0;
        int rightPointer = heights.length - 1;
        while(leftPointer < rightPointer) {
            int area = Math.min(heights[leftPointer], heights[rightPointer]) * (Math.abs(rightPointer - leftPointer));
            maxArea = Math.max(area, maxArea);
            if (heights[leftPointer] < heights[rightPointer]) {
                leftPointer++;
            } else {
                rightPointer--;
            }
        }
        return maxArea;
    }
}
