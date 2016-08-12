package model;

public class weibo{
	private int comment = 0;
	private int like = 0;
	private int forward = 0;
	private int weibonum = 1;
	/**
	 * 
	 * @param comment
	 * @param like
	 * @param forward
	 */
	public void print(){
		System.out.println("这个时间点的情况为：微博数量"+ this.weibonum + "\n评论数量："+ this.comment + "\n喜欢数量:"+ this.like+"\n转发总数:"+this.forward+"\n");
	}
	public void print_rate(){
		System.out.println("这个时间点的情况为：微博数量"+ this.weibonum + "\n评论："+ (double)this.comment/this.weibonum + "\n喜欢:"+ (double)this.like/this.weibonum+"\n转发:"+(double)this.forward/this.weibonum+"\n");
	}
	public weibo(int comment,int like , int forward){
		this.setComment(comment);
		this.setLike(like);
		this.setForward(forward);
	}
	/**
	 * @return the comment
	 */
	public int getComment() {
		return comment;
	}
	/**
	 * @param comment the comment to set
	 */
	public void setComment(int comment) {
		this.comment = comment;
	}
	/**
	 * @return the like
	 */
	public int getLike() {
		return like;
	}
	/**
	 * @param like the like to set
	 */
	public void setLike(int like) {
		this.like = like;
	}
	/**
	 * @return the forward
	 */
	public int getForward() {
		return forward;
	}
	/**
	 * @param forward the forward to set
	 */
	public void setForward(int forward) {
		this.forward = forward;
	}
	public int getWeibo_num() {
		// TODO Auto-generated method stub
		return this.weibonum;
	}
	public void setWeibo_num(int weibonum) {
		this.weibonum = weibonum;
	}
}
