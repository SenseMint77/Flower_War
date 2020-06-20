package game.test;
import java.util.*;

public class Player{
    private String playerName;
    private int[] cards = new int[2];
    private String cardsName;

    private boolean ddangJob= false;
    private boolean gusa = false;
    private boolean mungturng = false;
    private boolean armhang = false;

    public Player(String playerName) {
        this.playerName = playerName;
    }

    private String identifyJokbo(int card1, int card2) {
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

            if( (card1 == 14) && (card2 == 19) ) setMungturng(true);
            else if( (card1 % 10 == 4) && (card2 % 10== 9) ) setGusa(true);
            else if( (card1 == 14 ) && card2 ==17 ) setArmhang(true);

        } else if ((card1 + card2) % 10 == 0) {
            jokbo = "망통";
            if( (card1%10 == 3) && (card2%10 == 7)) setDdangJob(true);
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
        cardsName = identifyJokbo(cards[0], cards[1]);
    }

    public boolean isDdangJob() {
        return ddangJob;
    }

    public void setDdangJob(boolean ddangJob) {
        this.ddangJob = ddangJob;
    }

    public boolean isGusa() {
        return gusa;
    }

    public void setGusa(boolean gusa) {
        this.gusa = gusa;
    }

    public boolean isMungturng() {
        return mungturng;
    }

    public void setMungturng(boolean mungturng) {
        this.mungturng = mungturng;
    }

    public boolean isArmhang() {
        return armhang;
    }

    public void setArmhang(boolean armhang) {
        this.armhang = armhang;
    }

}