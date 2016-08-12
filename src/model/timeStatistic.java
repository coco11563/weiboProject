package model;

public class timeStatistic {
	private int weibo_num;
	private int comment_count;
	private int like_count;
	private int forward_count;
	public timeStatistic(int weibo_num , int comment_count , int like_count , int forward_count){
		this.setComment_count(comment_count);
		this.setForward_count(forward_count);
		this.setLike_count(like_count);
		this.setWeibo_num(weibo_num);
	}
	public void print(){
		System.out.println("这个时间点的情况为：微博数量"+ this.weibo_num + "\n评论数量："+ this.comment_count + "\n喜欢数量:"+ this.like_count+"\n转发总数:"+this.forward_count+"\n");
	}
	public void print_rate(){
		System.out.println("这个时间点的情况为：微博数量"+ this.weibo_num + "\n评论数量比上微博总数："+ (double)this.comment_count/this.weibo_num + "\n喜欢数量比上微博总数:"+ (double)this.like_count/this.weibo_num+"\n转发总数比上微博总数:"+(double)this.forward_count/this.weibo_num+"\n");
	}
	/**
	 * @return the weibo_num
	 */
	public int getWeibo_num() {
		return weibo_num;
	}
	/**
	 * @param weibo_num the weibo_num to set
	 */
	public void setWeibo_num(int weibo_num) {
		this.weibo_num = weibo_num;
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
}
