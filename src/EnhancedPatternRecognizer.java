import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class EnhancedPatternRecognizer extends SimplePatternRecognizer {
    private static final double ENHANCED_THRESHOLD = 0.75; //오차범위 임계값
    
    @Override
    protected double getSimilarityThreshold() {
        return ENHANCED_THRESHOLD;
    }
    

    public List<DigitMatch> recognizeAllPossibleMatches(DigitPattern pattern) {
        Map<Integer, Double> scores = getRecognitionScores(pattern);
        List<DigitMatch> matches = new ArrayList<>();
        
        for (Map.Entry<Integer, Double> entry : scores.entrySet()) {
            if (entry.getValue() >= getSimilarityThreshold()) {
                matches.add(new DigitMatch(entry.getKey(), entry.getValue()));
            }
        }
        
        return matches;
    }
    
    
    public class DigitMatch {
        private final int digit;
        private final double confidence;
        
        public DigitMatch(int digit, double confidence) {
            this.digit = digit;
            this.confidence = confidence;
        }
        
        public int getDigit() {
            return digit;
        }
        
        public double getConfidence() {
            return confidence;
        }
        
        @Override
        public String toString() {
            return String.format("Digit %d (confidence: %.2f%%)", digit, confidence * 100);
        }
    }
}