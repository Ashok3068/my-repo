import java.util.*;

public class LetterToPhoneCombination {

    public static void main(String[] args) {

        System.out.println(letterCombinations1("219"));

    }

    static public List<String> letterCombinations(String digits) {

        Map<Integer, List> numberToAlphabets = new HashMap<>();
        numberToAlphabets.put(2, Arrays.asList(new String[]{"a", "b", "c"}));
        numberToAlphabets.put(3, Arrays.asList(new String[]{"d", "e", "f"}));
        numberToAlphabets.put(4, Arrays.asList(new String[]{"g", "h", "i"}));
        numberToAlphabets.put(5, Arrays.asList(new String[]{"j", "k", "l"}));
        numberToAlphabets.put(6, Arrays.asList(new String[]{"m", "n", "o"}));
        numberToAlphabets.put(7, Arrays.asList(new String[]{"p", "q", "r", "s"}));
        numberToAlphabets.put(8, Arrays.asList(new String[]{"t", "u", "v"}));
        numberToAlphabets.put(9, Arrays.asList(new String[]{"w", "x", "y", "z"}));


        int digitIndex = 0;
        List<String> stringList = new ArrayList<>();
        while (digitIndex < digits.length()) {
            if (numberToAlphabets.containsKey(Character.getNumericValue(digits.charAt(digitIndex)))) {
                stringList = getCombinations(stringList, numberToAlphabets.get(Character.getNumericValue(digits.charAt(digitIndex))));
            }
            ++digitIndex;

        }
        return stringList;


    }

    static List<String> getCombinations(List<String> integers1, List<String> integers2) {
        List<String> s = new ArrayList();
        int i = 0;
        if (integers1.size() != 0 && integers2.size() != 0) {
            while (i < integers1.size()) {
               int j = 0;
                while (j < integers2.size()) {
                    s.add(integers1.get(i) + integers2.get(j));
                    ++j;
                }
                ++i;
            }
        } else if (integers1.size() != 0) {
            while (i < integers1.size()) {
                s.add(integers1.get(i));
                ++i;
            }
        } else if (integers2.size() != 0) {
            while (i < integers2.size()) {
                s.add(integers2.get(i));
                ++i;
            }
        }
        return s;


    }

    private static List<String> combinations = new ArrayList<>();
    private static Map<Character, String> letters = Map.of(
            '2', "abc", '3', "def", '4', "ghi", '5', "jkl",
            '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");
    private static String phoneDigits;

    public static List<String> letterCombinations1(String digits) {
        // If the input is empty, immediately return an empty answer array
        if (digits.length() == 0) {
            return combinations;
        }

        // Initiate backtracking with an empty path and starting index of 0
        phoneDigits = digits;
        backtrack(0, new StringBuilder());
        return combinations;
    }

    private static void backtrack(int index, StringBuilder path) {
        // If the path is the same length as digits, we have a complete combination
        if (path.length() == phoneDigits.length()) {
            combinations.add(path.toString());
            return; // Backtrack
        }

        // Get the letters that the current digit maps to, and loop through them
        String possibleLetters = letters.get(phoneDigits.charAt(index));
        for (char letter: possibleLetters.toCharArray()) {
            // Add the letter to our current path
            path.append(letter);
            // Move on to the next digit
            backtrack(index + 1, path);
            // Backtrack by removing the letter before moving onto the next
            path.deleteCharAt(path.length() - 1);
        }
    }
}
