package wordSegmenter;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.apdplat.word.WordSegmenter;
import org.apdplat.word.segmentation.Word;

public class Test {
	public static Map<String, List<Word>> contrast(String text){
	    Map<String,  List<Word>> map = new LinkedHashMap<>();
	    map.put("word分词器", WordSegmenter.seg(text));
	    return map;
	}
	public static Map<String, Map<String, String>> contrastMore(String text){
	    Map<String, Map<String, String>> map = new LinkedHashMap<>();
	    map.put("word分词器", new WordEvaluation().segMore(text));
	    return map;
	}
	public static void show(Map<String, List<Word>> map){
	    map.keySet().forEach(k -> {
	        System.out.println(k + " 的分词结果：");
	        AtomicInteger i = new AtomicInteger();
	        map.get(k).forEach(v -> {
	            System.out.println("\t" + i.incrementAndGet() + " 、" + v);
	        });
	    });
	}
	public static void showMore(Map<String, Map<String, String>> map){
	    map.keySet().forEach(k->{
	        System.out.println(k + " 的分词结果：");
	        AtomicInteger i = new AtomicInteger();
	        map.get(k).keySet().forEach(a -> {
	            System.out.println("\t" + i.incrementAndGet()+ " 、【"   + a + "】\t" + map.get(k).get(a));
	        });
	    });
	}
	public static void main(String[] args) {
	    show(contrast("市场需求推动、信息技术革新，国内金融业面临着前所未有的挑战和机遇。如何稳稳抓住现有的转型机会——信息化金融呢？关注“思科联天下”并回复“F001”，即可与思科资深顾问工程师马旻探讨思科金融行业解决方案！ #万物互联##金融#"));
	    showMore(contrastMore("市场需求推动、信息技术革新，国内金融业面临着前所未有的挑战和机遇。如何稳稳抓住现有的转型机会——信息化金融呢？关注“思科联天下”并回复“F001”，即可与思科资深顾问工程师马旻探讨思科金融行业解决方案！ #万物互联##金融#"));
	}
}
