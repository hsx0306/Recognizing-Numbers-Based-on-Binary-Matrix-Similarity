import java.util.Map;
import java.util.Scanner;

public class DigitRecognitionApp {
    public static void main(String[] args) {
        // recognizer 생성
        PatternRecognizer recognizer = new SimplePatternRecognizer();
        
        // 유저에게 입력받기
        int[][] userInput = getUserInputPattern();
        
        // 입력받은 값을 바탕으로 DigitPattern 작성
        DigitPattern pattern = new DigitPattern(userInput);
        
        // 결과 가지고 오기
        Map<Integer, Double> allScores = recognizer.getRecognitionScores(pattern);
        int bestMatchDigit = recognizer.recognizeDigit(pattern);
        
        // 예측값 발표
        System.out.println("This pattern represents the number " + bestMatchDigit);
        
        // 각각의 스코어 출력
        for (int digit = 0; digit <= 9; digit++) {
            double score = allScores.getOrDefault(digit, 0.0);
            System.out.printf("%d : %.1f%%\n", digit, score * 100);
        }
    }
    

    private static int[][] getUserInputPattern() {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = new int[6][7];
        
        System.out.println("Input your matrix (6x7):");
        
        // 각각 입력
        for (int i = 0; i < 6; i++) {
            System.out.print("Row " + (i+1) + ": ");
            String line = scanner.nextLine().trim();
            String[] values = line.split("\\s+");
            
            // 입력 검증
            if (values.length != 7) {
                System.out.println("Error: Each row must have exactly 7 values (0 or 1). Please try again.");
                i--; //실패했을 경우 다시
                continue;
            }
            
            // 분석값
            for (int j = 0; j < 7; j++) {
                try {
                    int value = Integer.parseInt(values[j]);
                    if (value != 0 && value != 1) {
                        throw new NumberFormatException("Values must be 0 or 1");
                    }
                    matrix[i][j] = value;
                } catch (NumberFormatException e) {
                    System.out.println("Error: Invalid input. Only 0 and 1 are allowed. Please try again.");
                    i--; //실패했을 경우 다시
                    break;
                }
            }
        }
        
        // Matrix 입력
        System.out.println("\nYou entered:");
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        
        return matrix;
    }

    
    private static void testPattern(PatternRecognizer recognizer, int[][] inputArray, String label) {
        DigitPattern pattern = new DigitPattern(inputArray);
        int recognizedDigit = recognizer.recognizeDigit(pattern);
        Map<Integer, Double> allScores = recognizer.getRecognitionScores(pattern);
        
        System.out.println("\n" + label + ":");
        System.out.println("This pattern represents the number " + recognizedDigit);
        
        // 각 숫자별 예측값 출력
        for (int digit = 0; digit <= 9; digit++) {
            double score = allScores.getOrDefault(digit, 0.0);
            System.out.printf("%d : %.1f%%\n", digit, score * 100);
        }
    }
}