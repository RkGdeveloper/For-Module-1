package com.bookshow.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.bookshow.dbconfig.DbUtil;
import com.bookshow.dto.BookShow;

public class BookShowDAOImpl implements IBookShowDAO{

	@Override
	public ArrayList<BookShow> getAllShowDetails() {
		
		ArrayList<BookShow> alShow = new ArrayList<BookShow>();
		BookShow sb;
		Connection con = DbUtil.getConnection();
		String q = "SELECT * from ShowDetails";
		
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(q);
			while(rs.next()){
				sb = new BookShow();
				sb.setShowId(rs.getString(1));
				sb.setShowName(rs.getString(2));
				sb.setLocation(rs.getString(3));
				sb.setShowDate(rs.getString(4));
				sb.setAvSeats(rs.getInt(5));
				sb.setPriceTicket(rs.getDouble(6));
				
				alShow.add(sb);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return alShow;
	}

	@Override
	public BookShow getAllShowById(String showId) {
		BookShow sb=null;
		Connection con = DbUtil.getConnection();
		String q = "SELECT * from ShowDetails where ShowId  = '?'";
		
		try {
			PreparedStatement st = con.prepareStatement(q);
			st.setString(1, showId);
			
			ResultSet rs = st.executeQuery(q);
			while(rs.next()){
				sb = new BookShow();
				sb.setShowId(rs.getString(1));
				sb.setShowName(rs.getString(2));
				sb.setLocation(rs.getString(3));
				sb.setShowDate(rs.getString(4));
				sb.setAvSeats(rs.getInt(5));
				sb.setPriceTicket(rs.getDouble(6));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return sb;
	}

	@Override
	public int updateSeatForShow(int bookSeat, String showId) {
		
		int exec = 0;
		String query = "update showdetails set avseats = avseats - ? where showId = ?";
		Connection con = DbUtil.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, bookSeat);
			pst.setString(2, showId);
			exec = pst.executeUpdate();
			
			System.out.println("row updated"+exec);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return exec;
	}

}
