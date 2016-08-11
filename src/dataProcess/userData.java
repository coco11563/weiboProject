package dataProcess;

import java.util.Date;
/**
 * 	 * @param comment_count
	 * @param like_count
	 * @param forward_count
	 * @param uid
	 * @param mid
	 * @param time
	 * @param content
 * @author coco1
 *
 */
public class userData {
	private int comment_count;
	private int like_count;
	private int forward_count;
	private String uid;
	private String mid;
	private Date time;
	private String content;
	/**
	 * 
	 * @param comment_count
	 * @param like_count
	 * @param forward_count
	 * @param uid
	 * @param mid
	 * @param time
	 * @param content
	 */
	public userData(String uid,String mid, Date time,int forward_count,  int comment_count,int like_count, String content){
		this.setComment_count(comment_count);
		this.setContent(content);
		this.setForward_count(forward_count);
		this.setLike_count(like_count);
		this.setMid(mid);
		this.setUid(uid);
		this.setTime(time);
		System.out.println("新建一条微博对象，微博发博时间：" + this.time.toString() +"\n博主号："+this.uid+"\n此条微博号："+this.mid+ 
				"\n转发数"+ this.forward_count+"\n点赞数："+ this.like_count + "\n评论数"+this.comment_count+"\n微博内容："+
				this.content);
		System.out.println("------------------------------next---------------------------------");
		
	}
	public static void main(String args[])
	{
//		userData us = new userData(1,1,1,"coco11563","u563",new Date(),"测试");
	}
	
	/**
	 * @return the comment_count
	 */
	public int getComment_count() {
		return comment_count;
	}
	/**
	 * @param comment_count the comment_count to set
	 */
	public void setComment_count(int comment_count) {
		this.comment_count = comment_count;
	}
	/**
	 * @return the like_count
	 */
	public int getLike_count() {
		return like_count;
	}
	/**
	 * @param like_count the like_count to set
	 */
	public void setLike_count(int like_count) {
		this.like_count = like_count;
	}
	/**
	 * @return the forward_count
	 */
	public int getForward_count() {
		return forward_count;
	}
	/**
	 * @param forward_count the forward_count to set
	 */
	public void setForward_count(int forward_count) {
		this.forward_count = forward_count;
	}
	/**
	 * @return the uid
	 */
	public String getUid() {
		return uid;
	}
	/**
	 * @param uid the uid to set
	 */
	public void setUid(String uid) {
		this.uid = uid;
	}
	/**
	 * @return the mid
	 */
	public String getMid() {
		return mid;
	}
	/**
	 * @param mid the mid to set
	 */
	public void setMid(String mid) {
		this.mid = mid;
	}
	/**
	 * @return the time
	 */
	public Date getTime() {
		return time;
	}
	/**
	 * @param time the time to set
	 */
	public void setTime(Date time) {
		this.time = time;
	}
	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
}
