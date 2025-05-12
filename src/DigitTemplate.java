import java.util.List;
import java.util.ArrayList;

class DigitTemplate {
    private final int digit;
    private final int[][] template;

    public static List<DigitTemplate> createStandardTemplates() {
        List<DigitTemplate> templates = new ArrayList<>();
        
        // 0 템플릿
        templates.add(new DigitTemplate(0, new int[][] {
            {0, 1, 1, 1, 1, 0, 0},
            {1, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 1},
            {0, 1, 1, 1, 1, 1, 0}
        }));
        
        // 1 템플릿
        templates.add(new DigitTemplate(1, new int[][] {
            {0, 0, 0, 1, 0, 0, 0},
            {0, 0, 1, 1, 0, 0, 0},
            {0, 1, 0, 1, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0},
            {0, 1, 1, 1, 1, 1, 0}
        }));
        
        // 2 템플릿
        templates.add(new DigitTemplate(2, new int[][] {
        	 {0, 1, 1, 1, 1, 1, 0},
             {1, 0, 0, 0, 0, 0, 1},
             {0, 0, 0, 0, 0, 1, 0},
             {0, 0, 0, 1, 1, 0, 0},
             {0, 1, 1, 0, 0, 0, 0},
             {1, 1, 1, 1, 1, 1, 1}
        }));
        
        // 3 템플릿
        templates.add(new DigitTemplate(3, new int[][] {
        	{0, 1, 1, 1, 1, 1, 0},
            {1, 0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 0, 1, 0},
            {0, 0, 0, 1, 1, 0, 0},
            {1, 0, 0, 0, 0, 0, 1},
            {0, 1, 1, 1, 1, 1, 0}
        }));
        
        // 4 템플릿
        templates.add(new DigitTemplate(4, new int[][] {
        	{0, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 1, 1, 0, 0},
            {0, 0, 1, 0, 1, 0, 0},
            {0, 1, 0, 0, 1, 0, 0},
            {1, 1, 1, 1, 1, 1, 1},
            {0, 0, 0, 0, 1, 0, 0}
        }));
        
        // 5 템플릿
        templates.add(new DigitTemplate(5, new int[][] {
        	{1, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 0},
            {1, 1, 1, 1, 1, 1, 0},
            {0, 0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 0}
        }));
        
        // 6 템플릿
        templates.add(new DigitTemplate(6, new int[][] {
        	{0, 0, 1, 1, 1, 0, 0},
            {0, 1, 0, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 0, 0},
            {1, 1, 1, 1, 1, 1, 0},
            {1, 0, 0, 0, 0, 0, 1},
            {0, 1, 1, 1, 1, 1, 0}
        }));
        
        // 7 템플릿
        templates.add(new DigitTemplate(7, new int[][] {
        	{1, 1, 1, 1, 1, 1, 1},
            {0, 0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 0, 1, 0},
            {0, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 1, 0, 0, 0},
            {0, 0, 1, 0, 0, 0, 0}
        }));
        
        // 8 템플릿
        templates.add(new DigitTemplate(8, new int[][] {
        	{0, 1, 1, 1, 1, 1, 0},
            {1, 0, 0, 0, 0, 0, 1},
            {0, 1, 1, 1, 1, 1, 0},
            {1, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 1},
            {0, 1, 1, 1, 1, 1, 0}
        }));
        
        // 9 템플릿
        templates.add(new DigitTemplate(9, new int[][] {
        	{0, 1, 1, 1, 1, 1, 0},
            {1, 0, 0, 0, 0, 0, 1},
            {0, 1, 1, 1, 1, 1, 1},
            {0, 0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 0, 0, 1}
        }));
        
        return templates;
    }
    
    public DigitTemplate(int digit, int[][] template) {
        this.digit = digit;
        this.template = template;
    }
    
    public int getDigit() {
        return digit;
    }
    
    public int[][] getTemplate() {
        return template;
    }
}
