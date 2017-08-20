package ydmusic.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ydmusic.web.po.Music;
import ydmusic.web.po.MusicList;
import ydmusic.web.po.PlayList;

public class MySQLMusic {

	DBhelper dbhelper = new DBhelper();

	public List<PlayList> getPlaylist() {
		List<PlayList> albumList = new ArrayList<PlayList>();
		PreparedStatement preStmt = null;
		ResultSet rs = null;
		Connection conn = null;
		try {
			conn = dbhelper.getConnection();
			String sql = "SELECT * FROM playlist";
			preStmt = conn.prepareStatement(sql);
			rs = preStmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("playsId");
				String title = rs.getString("title");
				String nb = rs.getString("nb");
				String img = rs.getString("img");
				albumList.add(new PlayList(id, title, nb, img));
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbhelper.closeAll(conn, preStmt, rs);
		}
		return albumList;
	}

	
	public List<String> getMusicIdList() {
		List<String> musicidlist = new ArrayList<String>();
		PreparedStatement preStmt = null;
		ResultSet rs = null;
		Connection conn = null;
		try {
			conn = dbhelper.getConnection();
			String sql = "SELECT musicId FROM musiclist";
			preStmt = conn.prepareStatement(sql);
			rs = preStmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("musicId");
				musicidlist.add(id);
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbhelper.closeAll(conn, preStmt, rs);
		}
		return musicidlist;
	}
	
	
	public List<Music> getMusics(){
		List<Music> musics = new ArrayList<Music>();
		PreparedStatement preStmt = null;
		ResultSet rs = null;
		Connection conn = null;
		try {
			conn = dbhelper.getConnection();
			String sql = "SELECT * FROM  `music` WHERE  `musicName` !=  '' LIMIT 0 , 30";
			preStmt = conn.prepareStatement(sql);
			rs = preStmt.executeQuery();
			while (rs.next()) {
				String musicId = rs.getString("musicId");
				String musicName = rs.getString("musicName");
				String artistName = rs.getString("artistName");
				String lyric = rs.getString("lyric");
				String mp3Url = rs.getString("mp3Url");
				String musicPic = rs.getString("musicPic");
				musics.add(new Music(musicId,lyric,mp3Url,musicPic,artistName,musicName));
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbhelper.closeAll(conn, preStmt, rs);
		}
		return musics;
	}
	
	public Music getMusicById(String mid){
		Music music = null;
		PreparedStatement preStmt = null;
		ResultSet rs = null;
		Connection conn = null;
		try {
			conn = dbhelper.getConnection();
			String sql = "SELECT * FROM music WHERE musicName != '' AND musicId = ?";
			preStmt = conn.prepareStatement(sql);
			preStmt.setString(1, mid);
			rs = preStmt.executeQuery();
			System.out.println(sql);
			while (rs.next()) {
				String musicId = rs.getString("musicId");
				String musicName = rs.getString("musicName");
				String artistName = rs.getString("artistName");
				String lyric = rs.getString("lyric");
				String mp3Url = rs.getString("mp3Url");
				String musicPic = rs.getString("musicPic");
				music = new Music(musicId,lyric,mp3Url,musicPic,artistName,musicName);
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbhelper.closeAll(conn, preStmt, rs);
		}
		return music;
	
	}
	
	public List<Music> getMusicByName(String sname){
		List<Music> musics = new ArrayList<Music>();
		PreparedStatement preStmt = null;
		Connection conn = null;
		ResultSet rs = null;
		try{
			conn = dbhelper.getConnection();
			String sql = "SELECT * FROM music WHERE musicName like ? LIMIT 0 , 10";
			preStmt = conn.prepareStatement(sql);
			preStmt.setString(1, "%"+sname+"%");
			System.out.println(preStmt.toString());
			rs = preStmt.executeQuery();
			while(rs.next()){
				String musicId = rs.getString("musicId");
				String musicName = rs.getString("musicName");
				String artistName = rs.getString("artistName");
				String lyric = rs.getString("lyric");
				String mp3Url = rs.getString("mp3Url");
				String musicPic = rs.getString("musicPic");
				musics.add(new Music(musicId,lyric,mp3Url,musicPic,artistName,musicName));
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbhelper.closeAll(conn, preStmt, rs);
		}
		return musics;
	}
	
	public List<Music> getMusicByNames(String sname,String aname){
		List<Music> musics = new ArrayList<Music>();
		PreparedStatement preStmt = null;
		Connection conn = null;
		ResultSet rs = null;
		try{
			conn = dbhelper.getConnection();
			String sql = "SELECT * FROM music WHERE musicName LIKE ? AND artistName LIKE ? LIMIT 0 , 10";
			preStmt = conn.prepareStatement(sql);
			preStmt.setString(1, "%"+sname+"%");
			preStmt.setString(2, "%"+aname+"%");
			System.out.println(preStmt.toString());
			rs = preStmt.executeQuery();
			while(rs.next()){
				String musicId = rs.getString("musicId");
				String musicName = rs.getString("musicName");
				String artistName = rs.getString("artistName");
				String lyric = rs.getString("lyric");
				String mp3Url = rs.getString("mp3Url");
				String musicPic = rs.getString("musicPic");
				musics.add(new Music(musicId,lyric,mp3Url,musicPic,artistName,musicName));
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbhelper.closeAll(conn, preStmt, rs);
		}
		return musics;
	}
	
	
	public MusicList getMusicsById(String mid) {
		PreparedStatement preStmt = null;
		ResultSet rs = null;
		Connection conn = null;
		MusicList music = null;
		try {
			conn = dbhelper.getConnection();
			String sql = "SELECT * FROM musiclist WHERE musicId = ?";
			preStmt = conn.prepareStatement(sql);
			preStmt.setString(1, mid);
			rs = preStmt.executeQuery();
			System.out.println(sql);
			while (rs.next()) {
				String musicId = rs.getString("musicId");
				String musicName = rs.getString("musicName");
//				String artistName = rs.getString("artistName");
				music = new MusicList(musicId, musicName);
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbhelper.closeAll(conn, preStmt, rs);
		}
		return music;
	}
	
	
	public List<MusicList> getMusicList() {
		List<MusicList> musiclist = new ArrayList<MusicList>();
		PreparedStatement preStmt = null;
		ResultSet rs = null;
		Connection conn = null;
		try {
			conn = dbhelper.getConnection();
			String sql = "SELECT musicId, musicName FROM musiclist";
			preStmt = conn.prepareStatement(sql);
			rs = preStmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("musicId");
				String musicName = rs.getString("musicName");
				musiclist.add(new MusicList(id,musicName));
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbhelper.closeAll(conn, preStmt, rs);
		}
		return musiclist;
	}
	
	// public Album selectAlbum(String album_id) throws Exception {
	// Album album = null;
	// Connection conn = null;
	// PreparedStatement preStmt = null;
	// ResultSet rs = null;
	// try {
	// conn = dbhelper.getConnection();
	// String sql = "SELECT * FROM album WHERE id = " + album_id;
	// preStmt = conn.prepareStatement(sql);
	// rs = preStmt.executeQuery();
	//
	// while (rs.next()) {
	// String id = rs.getString("id");
	// String name = rs.getString("album_name");
	// String singer = rs.getString("singer");
	// String url = rs.getString("album_url");
	// album = new Album(id, name, singer, url);
	// }
	// } catch (SQLException se) {
	// se.printStackTrace();
	// } catch (Exception e) {
	// e.printStackTrace();
	// } finally {
	// dbhelper.closeAll(conn, preStmt, rs);
	// }
	//
	// //判断是否有为空，根据id查询，抛出异常，提示用户不存在该id
	// if(album == null){
	// throw new CustomException("修改的专辑信息不存在");
	// }
	// return album;
	// }

	// public int updateAlbum(String album_id, Album album) {
	// Connection conn = null;
	// PreparedStatement preStmt = null;
	// int rs = 0;
	// try {
	// conn = dbhelper.getConnection();
	// String sql =
	// "update album set  album_name=?,singer=?,album_url=? where id=?";//
	// 注意要有where条件
	// preStmt = conn.prepareStatement(sql);
	// preStmt.setString(1, (album.getAlbum_name()));
	// preStmt.setString(2, (album.getSinger()));// 或者：preStmt.setInt(1,值);
	// preStmt.setString(3, (album.getAlbum_url()));
	// preStmt.setString(4, album.getId());
	// rs = preStmt.executeUpdate();
	//
	// } catch (SQLException se) {
	// se.printStackTrace();
	// } catch (Exception e) {
	// e.printStackTrace();
	// } finally {
	// dbhelper.closeAll(conn, preStmt, null);
	// }
	// return rs;
	// }

	public int insertPlays(PlayList plays) {
		Connection conn = null;
		PreparedStatement preStmt = null;
		int rs = 0;
		try {
			conn = dbhelper.getConnection();
			String sql = "insert into playlist (playsId,title,img,nb) values(?,?,?,?)";
			preStmt = conn.prepareStatement(sql);
			preStmt.setString(1, plays.getPlaysId());
			preStmt.setString(2, plays.getTitle());
			preStmt.setString(3, plays.getImg());
			preStmt.setString(4, plays.getNb());
			rs = preStmt.executeUpdate();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbhelper.closeAll(conn, preStmt, null);
		}
		return rs;
	}

	public int insertPlays(List<PlayList> listPlays) {

		Connection conn = null;
		PreparedStatement preStmt = null;
		int rs = 0;
		try {
			conn = dbhelper.getConnection();
			for (PlayList plays : listPlays) {
				String sql = "insert into playlist (playsId,title,img,nb) values(?,?,?,?)";
				preStmt = conn.prepareStatement(sql);
				preStmt.setString(1, plays.getPlaysId());
				preStmt.setString(2, plays.getTitle());
				preStmt.setString(3, plays.getImg());
				preStmt.setString(4, plays.getNb());
				rs = preStmt.executeUpdate();
				if (rs != 0) {
					System.out.println("插入成功");
				}
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbhelper.closeAll(conn, preStmt, null);
		}
		return rs;
	}

	public boolean isInsertMusics(Connection conn,PreparedStatement preStmt,String musicId) {
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM musiclist WHERE musicId = ?";
			preStmt = conn.prepareStatement(sql);
			preStmt.setString(1, musicId);
			rs = preStmt.executeQuery();
			if (rs.next())
				return true;
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if (rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}

	public int insertMusics(List<MusicList> listMusics) {

		Connection conn = null;
		PreparedStatement preStmt = null;
		int rs = 0;
		try {
			conn = dbhelper.getConnection();
			for (MusicList musics : listMusics) {
				if (!isInsertMusics(conn,preStmt,musics.getMusicId())) {
					String sql = "insert into musiclist (musicId,musicName,artistName,artistId,albumId,albumName,albumPic) values(?,?,?,?,?,?,?)";
					preStmt = conn.prepareStatement(sql);
					System.out.println("musics.getMusicId(): "
							+ musics.getMusicId());
					System.out.println("musics.getMusicName(): "
							+ musics.getMusicName());
					System.out.println("musics.getArtistName(): "
							+ musics.getArtistName());
					System.out.println("musics.getArtistId(): "
							+ musics.getArtistId());
					System.out.println("musics.getAlbumId(): "
							+ musics.getAlbumId());
					System.out.println("musics.getAlbumName(): "
							+ musics.getAlbumName());
					System.out.println("musics.getAlbumPic(): "
							+ musics.getAlbumPic());
					preStmt.setString(1, musics.getMusicId());
					preStmt.setString(2, musics.getMusicName());
					preStmt.setString(3, musics.getArtistName());
					preStmt.setString(4, musics.getArtistId());
					preStmt.setString(5, musics.getAlbumId());
					preStmt.setString(6, musics.getAlbumName());
					preStmt.setString(7, musics.getAlbumPic());
					rs = preStmt.executeUpdate();
					if (rs != 0) {
						System.out.println("插入成功");
					}
				}
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbhelper.closeAll(conn, preStmt, null);
		}
		return rs;
	}
	


	// public int deleteAlbum(String album_id) {
	// Connection conn = null;
	// PreparedStatement preStmt = null;
	// int rs = 0;
	// try {
	// conn = dbhelper.getConnection();
	// String sql = "delete from album where id = ?";
	// preStmt = conn.prepareStatement(sql);
	// preStmt.setString(1, album_id);
	// rs = preStmt.executeUpdate();
	// } catch (SQLException se) {
	// se.printStackTrace();
	// } catch (Exception e) {
	// e.printStackTrace();
	// } finally {
	// dbhelper.closeAll(conn, preStmt, null);
	// }
	// return rs;
	// }

	// public List<Album> searchAlbum(String searchContent) {
	// List<Album> albumList = new ArrayList<Album>();
	// Connection conn = null;
	// PreparedStatement preStmt = null;
	// ResultSet rs = null;
	// try {
	//
	// conn = dbhelper.getConnection();
	// String sql;
	// sql = "SELECT * FROM album WHERE album_name LIKE ?";
	// preStmt = conn.prepareStatement(sql);
	// preStmt.setString(1, "%" + searchContent + "%");
	// rs = preStmt.executeQuery();
	// System.out.println(preStmt.toString());
	// while (rs.next()) {
	//
	// String id = rs.getString("id");
	// System.out.println(id);
	// String name = rs.getString("album_name");
	// String singer = rs.getString("singer");
	// String url = rs.getString("album_url");
	// albumList.add(new Album(id, name, singer, url));
	// }
	//
	// } catch (SQLException se) {
	// se.printStackTrace();
	// } catch (Exception e) {
	// e.printStackTrace();
	// } finally {
	// dbhelper.closeAll(conn, preStmt, rs);
	// }
	// return albumList;
	// }

	public static void main(String[] args) throws SQLException {
		MySQLMusic mySQLMusic = new MySQLMusic();
//		List<Music> musis = mySQLMusic.getMusics();
//		System.out.println(musis.size());
//		Music musicById = mySQLMusic.getMusicById("668519");
//		System.out.println(musicById.getMusicName());
		
		List<Music> musicByName = mySQLMusic.getMusicByNames("三世","图");
		System.out.println(musicByName.size());

	}

}
