package it.polito.tdp.formulaone.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.formulaone.db.FormulaOneDAO;

public class Model {

	
	Graph<Race, DefaultWeightedEdge> grafo;
	FormulaOneDAO dao=new FormulaOneDAO();
	Map<Integer, Race> mappa;
	
	public void creaGrafo(Season stagione) {
		grafo=new SimpleWeightedGraph<Race, DefaultWeightedEdge>(DefaultWeightedEdge.class);
		mappa=new TreeMap<Integer, Race>();
		System.out.println(stagione.getYear());
		List<Race> lista=new ArrayList<Race>();
		System.out.println(dao.getAllRace(stagione.getYear()).size());
		lista.addAll(dao.getAllRace(stagione.getYear()));
		
		if(!lista.isEmpty()) {
			Graphs.addAllVertices(grafo, lista);
		}
		
		for(Race r: lista) {
			mappa.put(r.getRaceId(), r);
		}
		
		for(Archi a: dao.getArchi(stagione.getYear())) {
			DefaultWeightedEdge arco=grafo.getEdge(mappa.get(a.getGara1()), mappa.get(a.getGara2()));
			if(arco==null) {
				Graphs.addEdge(grafo,mappa.get(a.getGara1()), mappa.get(a.getGara2()), a.getNumPiloti() );
			}
		}
		
		System.out.println("Grafo creato "+grafo.vertexSet().size()+" vertici e archi "+grafo.edgeSet().size());
		
	}

	
	
	
	
	public List<DefaultWeightedEdge> cercaArcoPesoMassimo(){
		List<DefaultWeightedEdge> lista=new ArrayList<DefaultWeightedEdge>();
		double max=Integer.MIN_VALUE;
		
		for(DefaultWeightedEdge a: grafo.edgeSet()) {
			if(grafo.getEdgeWeight(a)>max) {
				max=grafo.getEdgeWeight(a);
				lista.clear();
				lista.add(a);
			}else if(grafo.getEdgeWeight(a)==max){
				lista.add(a);
			}
		}
		
		
		return lista;
	}
	
	
	
	
	
	
	
	
	
	public List<Season> getSeason() {
		return dao.getAllSeasons() ;
	}





	public Graph<Race, DefaultWeightedEdge> getGrafo() {
		return grafo;
	}





	public void setGrafo(Graph<Race, DefaultWeightedEdge> grafo) {
		this.grafo = grafo;
	}






}
