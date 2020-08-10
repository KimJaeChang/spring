package kr.co.twocamp.board;

public class BoardReply {
	private int reno;
	private String rewriter;
	private String rememo;
	private String redate;
	private int bno;
	private int rating;
	
	public int getReno() {
		return reno;
	}
	public void setReno(int reno) {
		this.reno = reno;
	}
	public String getRewriter() {
		return rewriter;
	}
	public void setRewriter(String rewriter) {
		this.rewriter = rewriter;
	}
	public String getRememo() {
		return rememo;
	}
	public void setRememo(String rememo) {
		this.rememo = rememo;
	}
	public String getRedate() {
		return redate;
	}
	public void setRedate(String redate) {
		this.redate = redate;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	
	
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	@Override
	public String toString() {
		return "BoardReply [reno=" + reno + ", rewriter=" + rewriter + ", rememo=" + rememo + ", redate=" + redate
				+ ", bno=" + bno + ", rating=" + rating + "]";
	}
	
	

}
