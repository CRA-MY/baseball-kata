public class GueseResult {
    private boolean solved;
    private int strikes;
    private int balls;

    public GueseResult(boolean solved, int strikes, int balls) {
        this.solved = solved;
        this.strikes = strikes;
        this.balls = balls;
    }

    public boolean isSolved() {
        return solved;
    }

    public int getStrikes() {
        return strikes;
    }

    public int getBalls() {
        return balls;
    }
}
