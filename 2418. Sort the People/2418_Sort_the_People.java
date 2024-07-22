class Solution {
    class Person {
        String name;
        int height;

        Person(String name, int height) {
            this.name = name;
            this.height = height;
        }
    }
    
    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        List<Person> people = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            people.add(new Person(names[i], heights[i]));
        }

        Collections.sort(people, (a, b) -> b.height - a.height);

        String[] sortedNames = new String[n];
        for (int i = 0; i < n; i++) {
            sortedNames[i] = people.get(i).name;
        }

        return sortedNames;
    }
}
