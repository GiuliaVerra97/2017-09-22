package it.polito.tdp.formulaone.model;

public class TestModel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Model model=new Model();
		Season s=new Season(2003, "stagione");
		model.creaGrafo(s);
		System.out.println("arco con massimo peso\n"+model.cercaArcoPesoMassimo());
		
	}

}
