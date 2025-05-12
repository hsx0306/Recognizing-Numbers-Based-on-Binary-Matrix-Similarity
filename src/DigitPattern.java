class DigitPattern {
    private int[][] pattern;
    
    public DigitPattern(int[][] pattern) {
        this.pattern = pattern;
    }
    
    public int[][] getPattern() {
        return pattern;
    }
    
    public double calculateSimilarity(int[][] other) {
        // 길이 범위 확인
        if (pattern.length != other.length || pattern[0].length != other[0].length) {
            return 0.0;
        }
        
        int rows = pattern.length;
        int cols = pattern[0].length;
        int totalPixels = rows * cols;
        int matchingPixels = 0;
        
        // 일치하는 개수 카운트
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (pattern[i][j] == other[i][j]) {
                    matchingPixels++;
                }
            }
        }
        
        // 백분율 유사성 반환시키기
        return (double) matchingPixels / totalPixels;
    }
}
