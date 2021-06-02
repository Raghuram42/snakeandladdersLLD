package Models;

public class Ladder {
    private int start;
    private int end;

    /**
     * @param start
     * @param end
     */
    public Ladder(int start, int end) {
        this.start = start;
        this.end = end;
    }

    /**
     * @return the start
     */
    public int getStart() {
        return start;
    }

    /**
     * @return the end
     */
    public int getEnd() {
        return end;
    }

    /**
     * @param end the end to set
     */
    public void setEnd(int end) {
        this.end = end;
    }

    /**
     * @param start the start to set
     */
    public void setStart(int start) {
        this.start = start;
    }

}
