package dataProcess;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apdplat.word.segmentation.SegmentationAlgorithm;
import org.apdplat.word.segmentation.SegmentationFactory;
import org.apdplat.word.segmentation.Word;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import model.userData;
import wordSegmenter.WordSegmenter;

public class contentCut {
	private static final Logger LOGGER = LoggerFactory.getLogger(WordSegmenter.class);    
	public static Map<Word,Integer> contentProcess(LinkedList<userData> sentences)
	{
		long start = System.currentTimeMillis();
		int i=1;
        Map<Word, Integer> m = new HashMap<Word, Integer>();
        for(userData user : sentences){
        	String sentence = user.getContent();
            List<Word> words = segWithStopWords(sentence,SegmentationAlgorithm.MaximumMatching);
            for(Word w : words)
            {
            	if(m.containsKey(w))
            	{
            		m.put(w, m.get(w)+1);
            	}
            	else
            	{
            		m.put(w, 1);
            	}
            }
            LOGGER.info((i++)+"、切分句子: "+sentence);
            LOGGER.info("    切分结果："+words);
        }
        m.entrySet().stream().sorted((a,b)->b.getValue().compareTo(a.getValue())).forEach(e->
        LOGGER.info(e.getKey()+"\t"+e.getValue()));
        long cost = System.currentTimeMillis() - start;
        LOGGER.info("耗时: "+cost+" 毫秒");
        return m;
	}
	 /**
     * 对文本进行分词，保留停用词
     * 使用双向最大匹配算法
     * @param text 文本
     * @return 分词结果
     */
    public static List<Word> segWithStopWords(String text){
        return SegmentationFactory.getSegmentation(SegmentationAlgorithm.MaxNgramScore).seg(text);
    }
    /**
     * 对文本进行分词，保留停用词
     * 可指定其他分词算法
     * @param text 文本
     * @param segmentationAlgorithm 分词算法
     * @return 分词结果
     */
    public static List<Word> segWithStopWords(String text, SegmentationAlgorithm segmentationAlgorithm){
        return SegmentationFactory.getSegmentation(segmentationAlgorithm).seg(text);
    }
    public static void main(String args[]){
    	LinkedList<userData> li = dataRead.readFile(dataRead.getTrain_path());
    	@SuppressWarnings("unused")
		Map<Word,Integer> m = contentCut.contentProcess(li);
    }
}
