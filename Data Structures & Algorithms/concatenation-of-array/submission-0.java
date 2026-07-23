class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] concat = new int[2 * nums.length];
        int modulo = nums.length;
        for (int i = 0; i < concat.length; i++){
            int index = i % modulo;
            concat[i] = nums[index];
        }
        return concat;
    }
}