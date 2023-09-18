package kr.co.kmarket.dto.cs;

public class ArticleDTO {
	
	private int no;
	private int parent;
	private int comment;
	private String cate;
	private String type;
	private String title;
	private String content;
	private String writer;
	private int hit;
	private String regip;
	private String rdate;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getParent() {
		return parent;
	}
	public void setParent(int parent) {
		this.parent = parent;
	}
	public int getComment() {
		return comment;
	}
	public void setComment(int comment) {
		this.comment = comment;
	}
	public String getCate() {
		return cate;
	}
	public void setCate(String cate) {
		this.cate = cate;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getRegip() {
		return regip;
	}
	public void setRegip(String regip) {
		this.regip = regip;
	}
	public String getRdate() {
		return rdate;
	}
	public void setRdate(String rdate) {
		this.rdate = rdate;
	}
	
	//날짜 재설정
	public void setRdateYYMMDD(String rdate) {
		this.rdate = rdate.substring(2, 10);
	}
	
	//아이디 마스킹 처리
	public String maskWriter(String writer) {
        if (writer!= null && writer.length() > 2) {
            String maskedUserId = writer.substring(0, 2) + "**";
            return maskedUserId;
        }
        return writer;
    }
	
	@Override
	public String toString() {
		return "ArticleDTO [no=" + no + ", parent=" + parent + ", comment=" + comment + ", cate=" + cate + ", type="
				+ type + ", title=" + title + ", content=" + content + ", writer=" + writer + ", hit=" + hit
				+ ", regip=" + regip + ", rdate=" + rdate + "]";
	}
	
	
	

}