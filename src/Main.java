import java.util.Arrays;
import java.util.Random;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static AtomicInteger counterThree = new AtomicInteger(0);
    public static AtomicInteger counterFour = new AtomicInteger(0);
    public static AtomicInteger counterFive = new AtomicInteger(0);
    public static final boolean isTest = false;


    public static void main(String[] args) {
        Random random = new Random();
        String[] texts;
        if (!isTest) {
            texts = new String[100_000];
            for (int i = 0; i < texts.length; i++) {
                texts[i] = TextGenerator.generateText("abc", 3 + random.nextInt(3));
            }
        } else {
            texts = new String[]{"abba", "aaaa", "bbb", "acba", "aabcc", "aaccc", "acb", "cccab", "caa", "bbsbbb"};
            System.out.println(Arrays.toString(texts));
        }
        new Thread(() -> {
            for (String word : texts) {
                if (
                        word.length() == 3
                                && (TextChecker.isSameChars(word)
                                || TextChecker.isPalindrome(word)
                                || TextChecker.isAscendingChars(word))
                ) {
                    counterThree.getAndIncrement();
                }
            }
            System.out.println("Красивых слов с длиной 3: " + counterThree.get());
        }).start();

        new Thread(() -> {
            for (String word : texts) {
                if (
                        word.length() == 4
                                && (TextChecker.isSameChars(word)
                                || TextChecker.isPalindrome(word)
                                || TextChecker.isAscendingChars(word))
                ) {
                    counterFour.getAndIncrement();
                }
            }
            System.out.println("Красивых слов с длиной 4: " + counterFour.get());
        }).start();

        new Thread(() -> {
            for (String word : texts) {
                if (
                        word.length() == 5
                                && (TextChecker.isSameChars(word)
                                || TextChecker.isPalindrome(word)
                                || TextChecker.isAscendingChars(word))
                ) {
                    counterFive.getAndIncrement();
                }
            }
            System.out.println("Красивых слов с длиной 5: " + counterFive.get());
        }).start();
    }


}