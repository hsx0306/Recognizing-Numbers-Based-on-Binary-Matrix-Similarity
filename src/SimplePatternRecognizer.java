import java.util.Map;
import java.util.HashMap;

class SimplePatternRecognizer extends TemplateBasedRecognizer {
    private static final double DEFAULT_THRESHOLD = 0.8; // 유사도 임계값
    
    public SimplePatternRecognizer() {
        initializeTemplates();
    }
    
    @Override
    protected void initializeTemplates() {
        digitTemplates = DigitTemplate.createStandardTemplates();
    }
    
    @Override
    protected double getSimilarityThreshold() {
        return DEFAULT_THRESHOLD;
    }
    
    public int recognizeDigit(DigitPattern pattern, double customThreshold) {
        Map<Integer, Double> scores = getRecognitionScores(pattern);
        
        // 일치값찾기
        int bestMatch = -1;
        double highestSimilarity = customThreshold;
        
        for (Map.Entry<Integer, Double> entry : scores.entrySet()) {
            if (entry.getValue() > highestSimilarity) {
                highestSimilarity = entry.getValue();
                bestMatch = entry.getKey();
            }
        }
        
        return bestMatch;
    }
    
    @Override
    public int recognizeDigit(DigitPattern pattern) {
        return recognizeDigit(pattern, getSimilarityThreshold());
    }
    
    @Override
    public Map<Integer, Double> getRecognitionScores(DigitPattern pattern) {
        Map<Integer, Double> scores = new HashMap<>();
        
        // 각 숫자 템플릿에 대한 실제 유사성 점수 계산
        for (DigitTemplate template : digitTemplates) {
            double similarity = pattern.calculateSimilarity(template.getTemplate());
            scores.put(template.getDigit(), similarity);
        }
        
        return scores;
    }
}
