package game.test;

import java.util.*;

public class FlowerWar {
    private Map<String,Integer> valueMap = new HashMap<>();
    private List<Player> playerList = new ArrayList<>();
    private String[] cardName = { "38광땡", "광떙", "장떙", "9떙", "8땡", "7땡", "6땡", "5땡", "4땡", "3땡", "2땡", "1땡", "알리", "독사",
    "구삥", "장삥", "장사", "세륙", "갑오", "8끗", "7끗", "6끗", "5끗", "4끗", "3끗", "2끗", "1끗", "망통", "땡잡이", "구사", "멍텅구리 구사",
    "암행어사" };

    public FlowerWar(){
        int cnt = 0;
        for (String name : cardName) {
            valueMap.put(name, 30 - cnt);
            cnt++;
        }
    }

    public void addPlayer(Player player){
        playerList.add(player);
    }
    
    public Player matchUp() {
        Collections.sort(playerList, new Comparator<Player>() {
            @Override
            public int compare(Player o1, Player o2) {
                return valueMap.get(o2.getCardsName()) - valueMap.get(o1.getCardsName());
            }
        });

        boolean special = false;
        if (valueMap.get(playerList.get(0).getCardsName()) == 29) {
            System.out.println("암행어사 찾아라");
            for(Player player : playerList ){
                if( player.isArmhang() ){
                    return player;
                }
            }
        }
        
        if (valueMap.get(playerList.get(0).getCardsName()) <= 28) {
            System.out.println("멍텅구리 구사를 찾아라");
            for(Player player : playerList ){
                if( player.isMungturng() ){
                    special = true;
                    break;
                }
            }
        }

        if (valueMap.get(playerList.get(0).getCardsName()) <= 27
                && valueMap.get(playerList.get(0).getCardsName()) >= 19) {
            System.out.println("땡잡이를 찾아라");
            for(Player player : playerList ){
                if( player.isDdangJob() ){
                    return player;
                }
            }
        }

        if (valueMap.get(playerList.get(0).getCardsName()) <= 18) {
            System.out.println("구사를 찾아라");
            for(Player player : playerList ){
                if( player.isGusa() ){
                    special = true;
                    break;
                }
            }
        }

        if( !special ){
            if( playerList.get(0).getCardsName().equals( playerList.get(1).getCardsName() )){
                return null;
            }else{
                return playerList.get(0);
            }
        } return null;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }
}