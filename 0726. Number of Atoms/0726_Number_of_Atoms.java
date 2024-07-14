class Solution {
    public String countOfAtoms(String formula) {
        Map<String, Integer> atomCounts = parseFormula(formula, 0, formula.length());
        StringBuilder result = new StringBuilder();
        List<String> sortedAtoms = new ArrayList<>(atomCounts.keySet());
        Collections.sort(sortedAtoms);
        
        for (String atom : sortedAtoms) {
            result.append(atom);
            int count = atomCounts.get(atom);
            if (count > 1) result.append(count);
        }
        
        return result.toString();
    }

    private Map<String, Integer> parseFormula(String formula, int start, int end) {
        Map<String, Integer> atomCounts = new HashMap<>();
        int i = start;

        while (i < end) {
            if (formula.charAt(i) == '(') {
                int openParens = 1;
                int j = i + 1;
                while (openParens > 0) {
                    if (formula.charAt(j) == '(') openParens++;
                    else if (formula.charAt(j) == ')') openParens--;
                    j++;
                }
                
                Map<String, Integer> innerCounts = parseFormula(formula, i + 1, j - 1);
                
                int k = j;
                while (k < end && Character.isDigit(formula.charAt(k))) {
                    k++;
                }
                int multiplier = (k == j) ? 1 : Integer.parseInt(formula.substring(j, k));
                
                for (Map.Entry<String, Integer> entry : innerCounts.entrySet()) {
                    atomCounts.put(entry.getKey(), atomCounts.getOrDefault(entry.getKey(), 0) + entry.getValue() * multiplier);
                }
                
                i = k;
            } else {
                int j = i + 1;
                while (j < end && Character.isLowerCase(formula.charAt(j))) {
                    j++;
                }
                String atom = formula.substring(i, j);
                
                int k = j;
                while (k < end && Character.isDigit(formula.charAt(k))) {
                    k++;
                }
                int count = (k == j) ? 1 : Integer.parseInt(formula.substring(j, k));
                
                atomCounts.put(atom, atomCounts.getOrDefault(atom, 0) + count);
                
                i = k;
            }
        }
        
        return atomCounts;
    }
}
