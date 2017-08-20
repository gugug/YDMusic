package ydmusic.web.po;

public class PlayList {
	private String playsId;
	private String title;
	private String nb;
	private String img;
	
	public PlayList() {
		super();
	}

	public PlayList(String playsId, String title, String nb, String img) {
		super();
		this.playsId = playsId;
		this.title = title;
		this.nb = nb;
		this.img = img;
	}
	
	public String getPlaysId() {
		return playsId;
	}
	public void setPlaysId(String playsId) {
		this.playsId = playsId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getNb() {
		return nb;
	}
	public void setNb(String nb) {
		this.nb = nb;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}

}
