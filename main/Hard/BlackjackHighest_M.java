package Hard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

public class BlackjackHighest_M {
//    Your program should output below, above, or blackjack

    public static String BlackjackHighest(String[] strArr) {
        LinkedHashMap<String, Integer> cardValues = new LinkedHashMap<>();
        cardValues.put("two", 2);
        cardValues.put("three", 3);
        cardValues.put("four", 4);
        cardValues.put("five", 5);
        cardValues.put("six", 6);
        cardValues.put("seven", 7);
        cardValues.put("eight", 8);
        cardValues.put("nine", 9);
        cardValues.put("ten", 10);
        cardValues.put("king", 10);
        cardValues.put("jack", 10);
        cardValues.put("queen", 10);
        cardValues.put("ace", 11);

        List<String> cards = Arrays.stream(strArr).collect(Collectors.toList());
        int count = getCountCards(strArr, cardValues);

        if (count > 21 && !cards.contains("ace")) {
            return "above " + getHighestCard(strArr, cardValues);
        } else if (count > 21 && cards.contains("ace")) {
            cardValues.remove("ace");
            cardValues.put("ace", 1);

            if (count - 10 == 21) {
                return "blackjack " + getHighestCard(strArr, cardValues);
            } else {
                return "below " + getHighestCard(strArr, cardValues);
            }

        } else if (count == 21) {
            return "blackjack " + getHighestCard(strArr, cardValues);
        } else {
            return "below " + getHighestCard(strArr, cardValues);
        }

    }

    private static String getHighestCard(String[] strArr, HashMap<String, Integer> cardValues) {
        int max = 0;
        String maxCard = "";

        List<String> cards = Arrays.stream(strArr).collect(Collectors.toList());

        for (String card : cardValues.keySet()) {
            if (cards.contains(card)) {
                int value = cardValues.get(card);
                if (value >= max) {
                    max = value;
                    maxCard = card;
                }
            }

        }

        return maxCard;
    }

    private static int getCountCards(String[] strArr, HashMap<String, Integer> cardValues) {
        int count = 0;

        for (int i = 0; i < strArr.length; i++) {
            String card = strArr[i];
            count += cardValues.get(card);
        }

        return count;
    }

    public static void main(String[] args) {
//        String[] strings = {"four", "ace", "ten"};
//        System.out.println(BlackjackHighest(strings));
//
//        String[] strings1 = {"ace", "queen"};
//        System.out.println(BlackjackHighest(strings1));

        String[] strings2 = {"queen", "ace", "ten"};
        System.out.println(BlackjackHighest(strings2));

        String[] strings3 = {"four", "four", "four", "four", "four", "ace"};
        System.out.println(BlackjackHighest(strings3));

        String[] strings4 = {"two", "three", "four", "five", "six", "ace"};
        System.out.println(BlackjackHighest(strings4));

    }

}
