import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {
    static String inputString =
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, " +
                    "sed do eiusmod tempor incididunt ut labore et dolore magna " +
                    "aliqua. Ut enim ad minim veniam, quis nostrud exercitation " +
                    "ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis " +
                    "aute irure dolor in reprehenderit in voluptate velit esse " +
                    "cillum dolore eu fugiat nulla pariatur. Excepteur sint " +
                    "occaecat cupidatat non proident, sunt in culpa qui officia " +
                    "deserunt mollit anim id est laborum.";

    public static void main(String[] args) {
        Map<Character, Integer> charDistribution = new HashMap<>();

        // Потратим немного лишней памяти, чтобы индексом и charAt() не гемороиться
        char[] chars = inputString.toCharArray();

        // Основной цикл
        for (char c : chars) {
            if (charDistribution.containsKey(c)) {
                charDistribution.put(c, charDistribution.get(c) + 1);
            } else {
                charDistribution.put(c, 1);
            }
        }

        // Ищем просто мин и макс
        int minimum = Integer.MAX_VALUE;
        int maximum = Integer.MIN_VALUE;
        int currentInt;
        for (Map.Entry<Character, Integer> characterIntegerEntry : charDistribution.entrySet()) {
            currentInt = characterIntegerEntry.getValue();
            if (currentInt > maximum) {
                maximum = currentInt;
            }
            if (currentInt < minimum) {
                minimum = currentInt;
            }
        }

        System.out.printf("Minimum chars: %d, Maximum chars: %d", minimum, maximum);
    }
}
