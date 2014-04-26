public class DoodlerPowerUpdate extends ScoreDecorator {
    
    String scoreUpdateReason = "Doodler took a power update which updated the score";
    
    DoodlerPowerUpdate(IRealTimeScorer scorer) {
        super(scorer);
    }
    
    @Override
    public void updateScore() {
        super.setScore(getScore() + 20);
    }
    
    @Override
    public int getScore() {
        return super.getScore();
    }
    
    public String getScoreUpdateReason() {
        return scoreUpdateReason;
    }
}
