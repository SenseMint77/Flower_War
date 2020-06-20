package game.test;

import java.util.*;

public class Sertda {
    public static void main(String[] args) {

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

        int[] cards4 = new int[2];
        cards4[0]= cardPack.get(6);
        cards4[1] = cardPack.get(7);

        Player player1 = new Player("아귀");
        player1.setCards(cards1);
        Player player2 = new Player("짝귀");
        player2.setCards(cards2);
        Player player3 = new Player("평경장");
        player3.setCards(cards3);
        Player player4 = new Player("고진호");
        player4.setCards(cards4);
        
        FlowerWar game = new FlowerWar();
        game.addPlayer(player1);
        game.addPlayer(player2);
        game.addPlayer(player3);
        game.addPlayer(player4);

        for (Player name : game.getPlayerList()) {
            System.out.println(name.getPlayerName() + "의 패 : " + name.getCardsName());
            System.out.println("(" + name.getCards()[0] + ", " + name.getCards()[1] + ")");
        }

        System.out.println( "승자는 " + game.matchUp().getPlayerName() );

    }

}
