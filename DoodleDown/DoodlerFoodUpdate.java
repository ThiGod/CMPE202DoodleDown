public class DoodlerFoodUpdate extends ScoreDecorator {
    
    String scoreUpdateReason = "Game speed increase updated the score";
    
    DoodlerFoodUpdate(IRealTimeScorer scorer) {
        super(scorer);
    }
    
    @Override
    public void updateScore() {
        setScore(getScore() + 10);
    }
    
    @Override
    public int getScore() {
        return super.getScore();
    }
    
    @Override
    public void setScore(int score) {
        super.setScore(score);
    }
    
    public String getScoreUpdateReason() {
        return scoreUpdateReason;
    }
}
