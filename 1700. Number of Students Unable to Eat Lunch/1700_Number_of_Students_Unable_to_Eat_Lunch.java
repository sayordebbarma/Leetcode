class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        LinkedList<Integer> queue = new LinkedList<>();
        LinkedList<Integer> stack = new LinkedList<>();
        int unableToEat = 0;

        for (int student : students) queue.add(student);

        for (int sandwich : sandwiches) stack.push(sandwich);

        while (!queue.isEmpty()) {
            if (queue.peekFirst() == stack.peekLast()) {
                queue.pollFirst();
                stack.pollLast();
                unableToEat = 0;
            } else {
                unableToEat++;
                queue.addLast(queue.pollFirst());  
            }

            if (unableToEat == queue.size()) return unableToEat;
        }

        return unableToEat;
    }
}
