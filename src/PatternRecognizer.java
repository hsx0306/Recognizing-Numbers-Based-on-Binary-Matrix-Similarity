import java.util.Map;

interface PatternRecognizer {
    int recognizeDigit(DigitPattern pattern);
    Map<Integer, Double> getRecognitionScores(DigitPattern pattern);
}