package ydmusic.web.po;

import java.util.List;

public class MusicList {
	private String musicId;
	private String musicName;
	private String artistName;
	private String artistId;
	private String albumId;
	private String albumName;
	private String albumPic;
	
	public MusicList() {
		super();
	}
	
	public MusicList(String musicId, String musicName) {
		super();
		this.musicId = musicId;
		this.musicName = musicName;
	}

	public MusicList(String musicId, String musicName, String artistName,
			String artistId, String albumId, String albumName, String albumPic) {
		super();
		this.musicId = musicId;
		this.musicName = musicName;
		this.artistName = artistName;
		this.artistId = artistId;
		this.albumId = albumId;
		this.albumName = albumName;
		this.albumPic = albumPic;
	}
	public String getMusicId() {
		return musicId;
	}
	public void setMusicId(String musicId) {
		this.musicId = musicId;
	}
	public String getMusicName() {
		return musicName;
	}
	public void setMusicName(String musicName) {
		this.musicName = musicName;
	}
	public String getArtistName() {
		return artistName;
	}
	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}
	public String getArtistId() {
		return artistId;
	}
	public void setArtistId(String artistId) {
		this.artistId = artistId;
	}
	public String getAlbumId() {
		return albumId;
	}
	public void setAlbumId(String albumId) {
		this.albumId = albumId;
	}
	public String getAlbumName() {
		return albumName;
	}
	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}
	public String getAlbumPic() {
		return albumPic;
	}
	public void setAlbumPic(String albumPic) {
		this.albumPic = albumPic;
	}
	
}
