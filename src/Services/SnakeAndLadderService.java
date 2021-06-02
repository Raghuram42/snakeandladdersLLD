package Services;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import Models.Board;
import Models.Ladder;
import Models.Player;
import Models.Snake;

public class SnakeAndLadderService {
    private Board SnakeAndLadderBoard;
    private Queue<Player> players;
    private int noOfPlayers;
    private static int DEFAULTBOARDSIZE = 100;
    private int size;

    SnakeAndLadderService(int size) {
        this.SnakeAndLadderBoard = new Board(size);
        this.players = new LinkedList<Player>();
        this.size = size;
    }

    public SnakeAndLadderService() {
        this(DEFAULTBOARDSIZE);
    }

    public void setPlayers(List<Player> players) {
        this.noOfPlayers = players.size();
        HashMap<String, Integer> playerPieces = new HashMap<String, Integer>();
        for (Player p : players) {
            this.players.offer(p);
            playerPieces.put(p.getPlayerName(), 0);
        }
        this.SnakeAndLadderBoard.setPlayerpieces(playerPieces);
    }

    public void setSnakes(List<Snake> snakes) {
        this.SnakeAndLadderBoard.setSnakes(snakes);
    }

    public void setLadders(List<Ladder> ladders) {
        this.SnakeAndLadderBoard.setLadders(ladders);
    }

    public void startGame() {

        while (!isGameEnded()) {
            int diceValue = getCurrentRollValue();
            Player curPlayer = this.players.poll();
            movePosition(curPlayer, diceValue);
            if (isPlayerWon(curPlayer)) {
                System.out.println("Player " + curPlayer.getPlayerName() + " won the game!!");
                this.SnakeAndLadderBoard.getPlayerpieces().remove(curPlayer.getPlayerName());
            } else {
                this.players.offer(curPlayer);
            }
        }
    }

    public boolean isGameEnded() {
        return this.players.size() < noOfPlayers;
    }

    public int getCurrentRollValue() {
        return DiceService.roll();
    }

    public void movePosition(Player player, int diceValue) {

        int currPosition = this.SnakeAndLadderBoard.getPlayerpieces().get(player.getPlayerName());

        int nextPosition = currPosition + diceValue;

        if (nextPosition > this.size) {
            nextPosition = currPosition;
        } else {
            nextPosition = getNewPositionWithSnakesLadders(nextPosition);
        }

        this.SnakeAndLadderBoard.getPlayerpieces().put(player.getPlayerName(), nextPosition);

        System.out.println(
                "Player " + player.getPlayerName() + " moved from position " + currPosition + " to " + nextPosition);
    }

    public int getNewPositionWithSnakesLadders(int nextPosition) {

        int nextnewPositon;
        do {
            nextnewPositon = nextPosition;
            for (Snake nextSnake : this.SnakeAndLadderBoard.getSnakes()) {
                if (nextSnake.getStart() == nextPosition)
                    nextPosition = nextSnake.getEnd();
            }

            for (Ladder nextLadder : this.SnakeAndLadderBoard.getLadders()) {
                if (nextLadder.getStart() == nextPosition)
                    nextPosition = nextLadder.getEnd();
            }
        } while (nextnewPositon != nextPosition);
        return nextPosition;

    }

    public boolean isPlayerWon(Player player) {

        return this.SnakeAndLadderBoard.getPlayerpieces().get(player.getPlayerName()) == size;
    }
}
