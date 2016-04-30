package Factory;

import org.yakindu.sct.model.sgraph.Entry;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.SGraphFactory;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Transition;

import TranslationSCT.WriteFile;
import hamsters.HamstersAPI;
import hamsters.HamstersNode;
import hamsters.HamstersOperator;
import taskModelCreation.Concurrency;
import taskModelCreation.Enable2;

public class ConcurrencyFactory extends FactoryTransformation{
	private static SGraphFactory sgraph = SGraphFactory.eINSTANCE;
	public static State concurrencyToSc(HamstersOperator hOP) {
		/**
		 * Création de l'orthogonal State.
		 */
		State e = sgraph.createState();
		Entry entry = sgraph.createEntry();
		e.isOrthogonal();
		e.setName(hOP.getDescription());
		/**
		 * Ajout de la première région.
		 */
		Region r = sgraph.createRegion();
		e.getRegions().add(r);
		Region r2 = sgraph.createRegion();
		e.getRegions().add(r2);
		r.getVertices().add(entry);
		r.setName("Premiere Région");
		r2.setName("Deuxieme Region");
		State s = sgraph.createState();
		Transition t = sgraph.createTransition();
		
		HamstersNode ha = hOP.getChildren().get(0);
		s = appel(ha);
		r.getVertices().add(s);
		HamstersNode ha2 = hOP.getChildren().get(1);
		State s2 = sgraph.createState();
		s2 = appel(ha2);
		r2.getVertices().add(s2);
		
		/**
		 * ajout du premier état.
		 */
		/*
		if(!(hOP.getChildren().get(0).isLeaf())) {
			HamstersNode ha = hOP.getChildren().get(0);	
			s = appel(ha);
				r.getVertices().add(s);
		}
		else {
			s.setName(hOP.getChildren().get(0).getDescription());
			t.setSource(entry);
			t.setTarget(s);
		}
		/**
		if(hOP.getChildren().size() >2) {
			for(int i = 1 ; i < hOP.getChildren().size()-1; i++ ) {
				/**
				 * création de la deuxieme concurrence
				 * avec un état orthogonal 
				 */
		/*
				t = sgraph.createTransition();
				State rec = sgraph.createState();
				/**
				 * State Leaf
				 * 
				 */
		/*		State sl = sgraph.createState();
				rec.isOrthogonal();
				Entry ent = sgraph.createEntry();
				/**
				 * création de la première région
				 */
		/*		Region regtemp = sgraph.createRegion();
				rec.getRegions().add(regtemp);
				/**
				 * ajout de l'entrée
				 */
		/*		regtemp.getVertices().add(ent);
				/**
				 * si ce n'est pas une feuille
				 * ajout récursif
				 */
		/*		if(!(hOP.getChildren().get(i).isLeaf())) {
						HamstersNode ha = hOP.getChildren().get(i);	
						State so = sgraph.createState();
						so = appel(ha);
						regtemp.getVertices().add(so);					
				}
				else {
					/**
					 * si l'état est une feuille.
					 * Ajout de l'état à la région précédement créee
					 * 
					 */
					
		/*			regtemp.getVertices().add(sl);
					sl.setName(hOP.getChildren().get(i).getDescription());
				}
					Transition t2 = sgraph.createTransition();
					t2.setSource(entry);
					t2.setTarget(sl);
				
				if( i == hOP.getChildren().size() -2){
					/**
					 * Creation du dernier etat de la concurrence
					 * Quand on arrive au niveau de la dernière concurrence
					 * 
					 */
		/*			Region lastreg = sgraph.createRegion();
					rec.getRegions().add(lastreg);
					lastreg.getVertices().add(ent);
					/**
					 * Si l'état n'est pas une feuille
					 */
		/*			if(!(hOP.getChildren().get(i+1).isLeaf())) {
						HamstersNode ha = hOP.getChildren().get(i+1);	
						s = appel(ha);
						regtemp.getVertices().add(s);					
				}
				else {
					/**
					 * si l'état est une feuille
					 */
		/*			State lastState = sgraph.createState();
					regtemp.getVertices().add(lastState);
					lastState.setName(hOP.getChildren().get(i+1).getDescription());
					
				}
					t2 = sgraph.createTransition();
					t2.setSource(entry);
					t2.setTarget(s);
				}
			rec = null;
			}
		}
		else {
			r2.setName("Deuxieme Région |||");
			State s2 = sgraph.createState();
			Transition t2 = sgraph.createTransition();
			/**
			 * ajout du premier état.
			 */
		/*	if(!(hOP.getChildren().get(1).isLeaf())) {
				HamstersNode ha = hOP.getChildren().get(1);	
				s2 = appel(ha);
				r2.getVertices().add(s2);
			}
			else {
				s2.setName(hOP.getChildren().get(1).getDescription());
				t2.setSource(entry);
				t2.setTarget(s2);
			}
		}
		/*
		State s = sgraph.createState();
		r.getVertices().add(s);
		s.setName("Lol");
		
		e.setName("Concurrency");
		Region r2 = sgraph.createRegion();
		
		r2.setName("Deuxieme Région");
		State s2 = sgraph.createState();
		r2.getVertices().add(s2);
		s2.setName("Lol2");
		e.getRegions().add(r2);
		HamstersOperator hp;
		Entry ent = sgraph.createEntry();
		ent.setName("MyEntry");*/
		return e;
	}
	public static void main(String[] args) throws Exception{
		Concurrency e = new Concurrency();
    	HamstersAPI hampi = e.getAPI();
    	WriteFile.main(FactoryTransformation.Transform(hampi),".\\lol");
	}
}
