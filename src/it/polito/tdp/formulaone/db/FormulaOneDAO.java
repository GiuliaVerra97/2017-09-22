package it.polito.tdp.formulaone.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.formulaone.model.Archi;
import it.polito.tdp.formulaone.model.Race;
import it.polito.tdp.formulaone.model.Season;

public class FormulaOneDAO {

	public List<Season> getAllSeasons() {
		String sql = "SELECT year, url FROM seasons ORDER BY year";
		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			List<Season> list = new ArrayList<>();
			while (rs.next()) {
				list.add(new Season(rs.getInt("year"), rs.getString("url")));
			}
			conn.close();
			return list;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	
	public List<Race> getAllRace(int anno) {
		String sql = "SELECT raceId, YEAR, ROUND, circuitId, NAME, DATE, TIME, url, YEAR(DATE) AS anno " + 
				"FROM races " + 
				"WHERE YEAR=?";
		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, anno);
			ResultSet rs = st.executeQuery();
			List<Race> list = new ArrayList<>();
			while (rs.next()) {
				list.add(new Race(rs.getInt("raceId"), rs.getInt("YEAR"), rs.getInt("ROUND"), rs.getInt("circuitId"), rs.getString("NAME"), rs.getDate("DATE").toLocalDate(), null, rs.getString("url")));
			}
			conn.close();
			return list;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	
	public List<Archi> getArchi(int anno) {
		String sql = "SELECT COUNT(r1.driverId) as numPiloti, ra1.raceId, ra2.raceId " + 
				"	FROM races AS ra1, races AS ra2, results AS r1, results AS r2 " + 
				"	WHERE ra1.raceId=r1.raceId AND ra2.raceId=r2.raceId AND ra1.YEAR=? AND ra2.YEAR=? AND r1.driverId=r2.driverId AND ra1.raceId>ra2.raceId AND r1.statusId=1 AND r2.statusId=1 " + 
				"	GROUP BY ra1.raceId, ra2.raceId " + 
				"	";
		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, anno);
			st.setInt(2, anno);
			ResultSet rs = st.executeQuery();
			List<Archi> list = new ArrayList<>();
			while (rs.next()) {
				list.add(new Archi(rs.getInt("ra1.raceId"), rs.getInt("ra2.raceId"), rs.getInt("numPiloti")));
			}
			conn.close();
			return list;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	

}
