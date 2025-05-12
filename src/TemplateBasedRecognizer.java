import java.util.ArrayList;
import java.util.List;

abstract class TemplateBasedRecognizer implements PatternRecognizer {
	// 각 숫자의 템플릿 패턴 목록
    protected List<DigitTemplate> digitTemplates = new ArrayList<>();
    protected abstract void initializeTemplates();
    protected abstract double getSimilarityThreshold();
}
