//ip: String[] operations
//op: sum of all points
//DS: Stack
//Plan: Keep running total, use stack, peek, and running total to calculate points.

class Solution {
    public int calPoints(String[] operations) {
        int sum = 0;
        int num = 0;
        ArrayList<Integer> st = new ArrayList<>();
        for(String s : operations) {
            switch(s) {
                case "C":
                    sum -= st.get(st.size() - 1);
                    st.remove(st.size() - 1);
                    break;
                case "D":
                    num = st.get(st.size() - 1) * 2;
                    st.add(num);
                    sum += num;
                    break;
                case "+":
                    num = st.get(st.size() - 2) + st.get(st.size() - 1);
                    st.add(num);
                    sum += num;
                    break;
                default:
                    num = Integer.parseInt(s);
                    sum += num;
                    st.add(num);
                break;
            }
        }
        return sum;
    }
}