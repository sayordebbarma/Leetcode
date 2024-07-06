class Solution {
    public int passThePillow(int n, int time) {
        int position = 1;
        int direction = 1;

        for (int i = 0; i < time; i++) {
            position += direction;

            if (position == n || position == 1) direction = -direction;
        }

        return position;
    }
}
