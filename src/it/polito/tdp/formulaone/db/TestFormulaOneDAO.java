package it.polito.tdp.formulaone.db;

import java.util.List;

import it.polito.tdp.formulaone.model.Season;

public class TestFormulaOneDAO {

	public static void main(String[] args) {

		FormulaOneDAO dao = new FormulaOneDAO();

		List<Season> seasons = dao.getAllSeasons();
		//System.out.println(seasons);
		System.out.println(dao.getAllRace(2003).size()+"\n");
		System.out.println(dao.getArchi(2003).size());

	}

}
