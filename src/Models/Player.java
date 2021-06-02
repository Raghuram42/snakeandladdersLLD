package Models;

public class Player {
    private String playerName;

    /**
     * @param playerName
     */
    public Player(String playerName) {
        this.playerName = playerName;

    }

    /**
     * @return the playerName
     */
    public String getPlayerName() {
        return playerName;
    }

    /**
     * @param playerName the playerName to set
     */
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

}
