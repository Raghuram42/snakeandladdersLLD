package Models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Board {
    private int size;
    private List<Snake> snakes;
    private List<Ladder> ladders;
    private List<Player> players;
    private HashMap<String, Integer> playerpieces;

    /**
     * @param snakes
     * @param ladders
     * @param players
     * @param playerpieces
     */
    public Board(int size) {
        this.snakes = new ArrayList<Snake>();
        this.ladders = new ArrayList<Ladder>();
        this.players = new ArrayList<Player>();
        this.playerpieces = new HashMap<String, Integer>();
        this.setSize(size);
    }

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * @return the playerpieces
     */
    public HashMap<String, Integer> getPlayerpieces() {
        return playerpieces;
    }

    /**
     * @param playerpieces the playerpieces to set
     */
    public void setPlayerpieces(HashMap<String, Integer> playerpieces) {
        this.playerpieces = playerpieces;
    }

    /**
     * @return the players
     */
    public List<Player> getPlayers() {
        return players;
    }

    /**
     * @param players the players to set
     */
    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    /**
     * @return the ladders
     */
    public List<Ladder> getLadders() {
        return ladders;
    }

    /**
     * @param ladders the ladders to set
     */
    public void setLadders(List<Ladder> ladders) {
        this.ladders = ladders;
    }

    /**
     * @return the snakes
     */
    public List<Snake> getSnakes() {
        return snakes;
    }

    /**
     * @param snakes the snakes to set
     */
    public void setSnakes(List<Snake> snakes) {
        this.snakes = snakes;
    }

}
