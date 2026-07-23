//ip: String[] operations
//op: sum of all points
//DS: Stack
//Plan: Keep running total, use stack, peek, and running total to calculate points.

class Solution {
    public int calPoints(String[] operations) {
        int sum = 0;
        int num = 0;
        Stack<Integer> st = new Stack<>();
        for(String s : operations) {
            switch(s) {
                case "C":
                    sum -= st.peek();
                    st.pop();
                    break;
                case "D":
                    num = st.peek() * 2;
                    st.push(num);
                    sum += num;
                    break;
                case "+":
                    int top = st.pop();
                    num = st.peek() + top;
                    st.push(top);
                    st.push(num);
                    sum += num;
                    break;
                default:
                    num = Integer.parseInt(s);
                    sum += num;
                    st.push(num);
                break;
            }
        }
        return sum;
    }
}