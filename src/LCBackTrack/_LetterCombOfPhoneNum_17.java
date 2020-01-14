package LCBackTrack;

import java.util.ArrayList;
import java.util.List;

public class _LetterCombOfPhoneNum_17 {
    public static List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return new ArrayList<>();
        List<String> result = new ArrayList<>();
        Pair[] pairs = new Pair[8];
        for (int i = 2; i <= 9; i++)
        {
            pairs[i-2] = new Pair(Integer.toString(i));
        }
        backtrack("", digits, result, pairs);
        return result;
    }

    public static void backtrack(String combination, String digits, List<String> result, Pair[] pairs)
    {
        if (digits.length() == 0)
        {
            result.add(combination);
        }

        else
        {
            ArrayList<String> currentChars = pairs[Integer.parseInt(digits.substring(0,1)) - 2].chars;
            for (int i = 0; i < currentChars.size(); i++)
            {
                backtrack(combination + currentChars.get(i), digits.substring(1), result, pairs);
            }
        }
    }

    private static class Pair
    {
        public ArrayList<String> chars;

        public Pair(String num)
        {
            chars = new ArrayList<>();
            switch (num)
            {
                case "2":
                    chars.add("a");
                    chars.add("b");
                    chars.add("c");
                    break;

                case "3":
                    chars.add("d");
                    chars.add("e");
                    chars.add("f");
                    break;

                case "4":
                    chars.add("g");
                    chars.add("h");
                    chars.add("i");
                    break;

                case "5":
                    chars.add("j");
                    chars.add("k");
                    chars.add("l");
                    break;

                case "6":
                    chars.add("m");
                    chars.add("n");
                    chars.add("o");
                    break;

                case "7":
                    chars.add("p");
                    chars.add("q");
                    chars.add("r");
                    chars.add("s");
                    break;

                case "8":
                    chars.add("t");
                    chars.add("u");
                    chars.add("v");
                    break;

                case "9":
                    chars.add("w");
                    chars.add("x");
                    chars.add("y");
                    chars.add("z");
                    break;
            }
        }
    }
}


// L(digits[i:j]) =
// digits[i].char[0] + L(digits[i+1:j]) ||
// digits[i].char[1] + L(digits[i+1:j]) ||
// ...


