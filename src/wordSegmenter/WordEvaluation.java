package wordSegmenter;

import java.util.HashMap;
import java.util.Map;
import org.apdplat.word.WordSegmenter;
import org.apdplat.word.segmentation.*;

public class WordEvaluation {
	public Map<String, String> segMore(String text) {
	  Map<String, String> map = new HashMap<>();
	  for(SegmentationAlgorithm segmentationAlgorithm : SegmentationAlgorithm.values()){
	    map.put(segmentationAlgorithm.getDes(), seg(text, segmentationAlgorithm));
	  }
	  return map;
	}
	private static String seg(String text, SegmentationAlgorithm segmentationAlgorithm) {
	  StringBuilder result = new StringBuilder();
	  for(Word word : WordSegmenter.segWithStopWords(text, segmentationAlgorithm)){
	    result.append(word.getText()).append(" ");
	  }
	  return result.toString();
	  }
	
}
