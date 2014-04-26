public abstract class ScoreDecorator implements IRealTimeScorer {
    IRealTimeScorer realTimeScorer;
    
    ScoreDecorator(IRealTimeScorer scorer) {
        this.realTimeScorer = scorer;
    }
    
    public abstract void updateScore();
    
    public int getScore() {
        return realTimeScorer.getScore();
    }
    
    public void setScore(int score) {
        realTimeScorer.setScore(score);
    }
}
