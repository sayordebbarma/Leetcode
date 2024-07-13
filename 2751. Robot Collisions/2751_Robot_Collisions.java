class Robot {
    public int index;
    public int position;
    public int health;
    public char direction;

    public Robot(int index, int position, int health, char direction) {
        this.index = index;
        this.position = position;
        this.health = health;
        this.direction = direction;
    }
}

class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        Robot[] robots = new Robot[n];
        List<Robot> stack = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            robots[i] = new Robot(i, positions[i], healths[i], directions.charAt(i));
        }

        Arrays.sort(robots, Comparator.comparingInt(robot -> robot.position));

        for (Robot robot : robots) {
            if (robot.direction == 'R') {
                stack.add(robot);
            } else {
                while (!stack.isEmpty() && stack.get(stack.size() - 1).direction == 'R') {
                    Robot top = stack.get(stack.size() - 1);
                    if (robot.health > top.health) {
                        robot.health -= 1;
                        stack.remove(stack.size() - 1);
                    } else if (robot.health == top.health) {
                        robot.health = 0;
                        stack.remove(stack.size() - 1);
                        break;
                    } else {
                        top.health -= 1;
                        robot.health = 0;
                        break;
                    }
                }
                if (robot.health > 0) {
                    stack.add(robot);
                }
            }
        }

        Collections.sort(stack, Comparator.comparingInt(robot -> robot.index));

        for (Robot robot : stack) {
            result.add(robot.health);
        }

        return result;
    }
}
