public class TextChecker {
    public static boolean isPalindrome(String word) {
        String reversedWord = new StringBuilder(word).reverse().toString();
        return word.equals(reversedWord);
    }

    public static boolean isSameChars(String word) {
        for (int current = 0; current < word.length(); current++) {
            if (word.charAt(current) != word.charAt(0)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAscendingChars(String word) {
        int next;
        if (!isSameChars(word)) {
            for (int current = 0; current < word.length() - 1; current++) {
                next = current + 1;
                if (word.charAt(current) > word.charAt(next)) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }
}
