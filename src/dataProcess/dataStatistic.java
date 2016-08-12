package dataProcess;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;

import model.timeStatistic;
import model.userData;
import model.weibo;
/**
 * 提供一些数据统计的方式，包括不同时间点微博发送的点赞转发数量统计等
 * @author coco1
 *
 */

public class dataStatistic {
/**
 * 统计不同时间点的微博点赞转发数据统计
 * @param li
 * @return
 */
	public static HashMap<Integer, timeStatistic> processDate(LinkedList<userData> li){
		HashMap<Integer , timeStatistic> map = new HashMap<Integer , timeStatistic> ();
		for (userData list:li){
			int weibo_count = 1;
			int comment_count = list.getComment_count();
			int like_count = list.getLike_count();
			int forward_count = list.getForward_count();
			timeStatistic ts = new timeStatistic(weibo_count,comment_count,like_count,forward_count);
			
			Date a = list.getTime();
			int hour  = dateProcess(a);
			if(map.containsKey(hour))
			{
				map.get(hour).setComment_count(map.get(hour).getComment_count() + comment_count);
				map.get(hour).setForward_count(map.get(hour).getForward_count() + forward_count);
				map.get(hour).setLike_count(map.get(hour).getLike_count() + like_count);
				map.get(hour).setWeibo_num(map.get(hour).getWeibo_num() + 1);
			}
			else
			{
				map.put(hour, ts);
			}
			
		}
		return map;
	}
	/**
	 * 提供不同微博字数的点赞转发统计
	 * @param li
	 * @return
	 */
	
	public static HashMap<Integer, weibo> processContentnum(LinkedList<userData> li){
		HashMap<Integer , weibo> map = new HashMap<Integer , weibo> ();
		for (userData list:li){
			int comment_count = list.getComment_count();
			int like_count = list.getLike_count();
			int forward_count = list.getForward_count();
			int content_length = list.getContent().length();
			weibo wb = new weibo(comment_count,like_count,forward_count);
			if(map.containsKey(content_length))
			{
				map.get(content_length).setComment(map.get(content_length).getComment() + comment_count);
				map.get(content_length).setForward(map.get(content_length).getForward() + forward_count);
				map.get(content_length).setLike(map.get(content_length).getLike() + like_count);
				map.get(content_length).setWeibo_num(map.get(content_length).getWeibo_num() + 1);
			}
			else
			{
				map.put(content_length, wb);
			}
			
		}
		return map;
	}
	public static int dateProcess(Date date){
		@SuppressWarnings("deprecation")
		int hour = date.getHours();
		return hour;
	}

	
}
