package app.algorithm;

import java.util.*;

public class Sertda {
    static String[] cardName = { "38광땡", "광떙", "장떙", "9떙", "8땡", "7땡", "6땡", "5땡", "4땡", "3땡", "2땡", "1땡", "알리", "독사",
            "구삥", "장삥", "장사", "세륙", "갑오", "8끗", "7끗", "6끗", "5끗", "4끗", "3끗", "2끗", "1끗", "망통", "땡잡이", "구사", "멍텅구리 구사",
            "암행어사" };

    public static void main(String[] args) {
        Map<String, Integer> cardNameValue = new HashMap<>();
        int cnt = 0;
        for (String name : cardName) {
            cardNameValue.put(name, 30 - cnt);
            cnt++;
        }

        int[] cards1 = new int[2];
        int[] cards2 = new int[2];
        int[] cards3 = new int[2];

        ArrayList<Integer> cardPack = new ArrayList<Integer>();
        for (int i = 1; i <= 20; i++)
            cardPack.add(i);

        Collections.shuffle(cardPack);
        
        cards1[0] = cardPack.get(0);
        cards1[1] = cardPack.get(1);

        cards2[0] = cardPack.get(2);
        cards2[1] = cardPack.get(3);

        cards3[0] = cardPack.get(4);
        cards3[1] = cardPack.get(5);

        FlowerWar player1 = new FlowerWar("아귀");
        player1.setCards(cards1);
        FlowerWar player2 = new FlowerWar("짝귀");
        player2.setCards(cards2);
        FlowerWar player3 = new FlowerWar("평경장");
        player3.setCards(cards3);
        List<FlowerWar> playList = new ArrayList<>();
        playList.add(player1);
        playList.add(player2);
        playList.add(player3);

        for (FlowerWar name : playList) {
            System.out.println(name.getPlayerName() + "의 패 : " + name.getCardsName());
            System.out.println("(" + name.getCards()[0] + ", " + name.getCards()[1] + ")");
        }
        System.out.println("그 승자는 " + matchUp(playList, cardNameValue));

    }

    public static String matchUp(List<FlowerWar> playerList, Map<String, Integer> valueMap) {
        String winner = null;
        Collections.sort(playerList, new Comparator<FlowerWar>() {
            @Override
            public int compare(FlowerWar o1, FlowerWar o2) {
                return valueMap.get(o2.getCardsName()) - valueMap.get(o1.getCardsName());
            }
        });

        if (valueMap.get(playerList.get(0).getCardsName()) == 29) {
            System.out.println("암행어사 찾아라");
        }
        if (valueMap.get(playerList.get(0).getCardsName()) <= 28) {
            System.out.println("멍텅구리 구사를 찾아라");
        }
        if (valueMap.get(playerList.get(0).getCardsName()) <= 27
                && valueMap.get(playerList.get(0).getCardsName()) >= 19) {
            System.out.println("땡잡이를 찾아라");
        }
        if (valueMap.get(playerList.get(0).getCardsName()) <= 18) {
            System.out.println("구사를 찾아라");
        }
        winner = playerList.get(0).getPlayerName();
        return winner;
    }

}

class FlowerWar {
    private String playerName;
    private int[] cards = new int[2];
    private String cardsName;

    public FlowerWar(String playerName) {
        this.playerName = playerName;

    }

    private String rankLevel(int card1, int card2) {
        String jokbo = null;
        if (card1 == 13 && card2 == 18) {
            jokbo = "38광땡";
        } else if (card1 % 10 == card2 % 10) {
            if (card1 % 10 == 0) {
                jokbo = "장땡";
            } else {
                jokbo = card1 % 10 + "땡";
            }
        } else if ((card1 == 11 && card2 == 13) || (card1 == 11 && card2 == 18)) {
            jokbo = "광떙";
        } else if ((card1 % 10) == 1 && (card2 % 10) == 2) {
            jokbo = "알리";
        } else if ((card1 % 10) == 1 && (card2 % 10) == 4) {
            jokbo = "독사";
        } else if ((card1 % 10) == 1 && (card2 % 10) == 9) {
            jokbo = "구삥";
        } else if ((card1 % 10) == 1 && (card2 % 10) == 0) {
            jokbo = "장삥";
        } else if ((card1 % 10) == 4 && (card2 % 10) == 0) {
            jokbo = "장사";
        } else if ((card1 % 10) == 4 && (card2 % 10) == 6) {
            jokbo = "세륙";
        } else if ((card1 + card2) % 10 == 9) {
            jokbo = "갑오";
        } else if ((card1 + card2) % 10 < 9 && (card1 + card2) % 10 != 0) {
            jokbo = (card1 + card2) % 10 + "끗";
        } else if ((card1 + card2) % 10 == 0) {
            jokbo = "망통";
        }
        return jokbo;
    }

    public String getCardsName() {
        return cardsName;
    }

    public int[] getCards() {
        return cards;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setCards(int[] cards) {
        this.cards = cards;
        Arrays.sort(cards);
        cardsName = rankLevel(cards[0], cards[1]);
    }

}

class 족보서열하기<String> implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        // TODO Auto-generated method stub
        return 0;
    }
    
    
}