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
import taskModelCreation.ConcurrencyWithEnable;
import taskModelCreation.Enable2;

public class ConcurrencyFactory extends FactoryTransformation{
	private static SGraphFactory sgraph = SGraphFactory.eINSTANCE;
	public static State concurrencyToSc(HamstersOperator hOP) {
		/**
		 * Création de l'orthogonal State.
		 */
		State compositeFirst = sgraph.createState();
		
		compositeFirst.isOrthogonal();
		compositeFirst.setName("|||");
		/**
		 * Ajout de la première région.
		 */
		Entry entry = sgraph.createEntry();
		Region r = sgraph.createRegion();
		r.setName("Reg 0");
		compositeFirst.getRegions().add(r);
		
		
		r.getVertices().add(entry);		
		State s = sgraph.createState();
		
		
		if (hOP.getChildren().get(0).isLeaf()) {
			s.setName(hOP.getChildren().get(0).getDescription());
			r.getVertices().add(s);
		}
		else {
			HamstersNode ha = hOP.getChildren().get(0);
			s = appel(ha);
			r.getVertices().add(s);
		}
		/**
		 * creation de la transition de entrée vers nouvel état
		 */
		Transition t = sgraph.createTransition();
		t.setSource(entry);
		t.setTarget(s);
		/**
		 * création de la deuxieme concurrenc en cas de concurrence binaire
		 */
		
		if( hOP.getChildren().size() <= 2){
				Region r2 = sgraph.createRegion();
				compositeFirst.getRegions().add(r2);
				r2.setName("Deuxieme Region");
				Entry entry2 = sgraph.createEntry();
				r2.getVertices().add(entry2);
				State s2 = sgraph.createState();
				/**
				 * Traitement différent si feuille ou si pas feuille
				 */
				
				if (hOP.getChildren().get(1).isLeaf()) {
					s2.setName(hOP.getChildren().get(1).getDescription());
					r2.getVertices().add(s2);
				}
				else {
					HamstersNode ha2 = hOP.getChildren().get(1);
					
					s2 = appel(ha2);
					r2.getVertices().add(s2);
				}
				/**
				 * creation de la transition entrée vers nouvel état.
				 */
				Transition t2 = sgraph.createTransition();
				t2.setSource(entry2);
				t2.setTarget(s2);
		}
		/** 
		 * création de la boucle de concurrence.
		 */
		else {
			State scomp = null;
			State scomptemp = null;
			for(int i = 1 ; i < hOP.getChildren().size() -1 ; i++) {
				Region newreg = sgraph.createRegion();
				newreg.setName("Region n° "+ i);
				newreg.setName("Concurrency ||| n°" + i + " ");
				Entry entrytemp = sgraph.createEntry();
				scomp = sgraph.createState();
				scomp.isComposite();
				scomp.setName("Composite state n° " + i + " ");
				if(i ==1) {
					compositeFirst.getRegions().add(newreg);
				}
				else {
					/*scomptemp = sgraph.createState();
					scomptemp.isComposite();
					scomptemp.setName("Lolilol");*/
					scomptemp.getRegions().add(newreg);
				}
				
				/**
				 * ajout de l'étt dans la nouvelle région
				 */
			
				newreg.getVertices().add(entrytemp);
				newreg.getVertices().add(scomp);
				/**
				 * création de la région de gauche du nouvel état composite
				 */
				Region newr = sgraph.createRegion();
				newr.setName("Région n° " + i+i);
				scomp.getRegions().add(newr);
				/**
				 * ajout du nouvel état !
				 */
				if(hOP.getChildren().get(i).isLeaf()){
					State news = sgraph.createState();
					news.setName(hOP.getChildren().get(i).getDescription());
					newr.getVertices().add(news);
				}
				else {
					State news = sgraph.createState();
					news = appel(hOP.getChildren().get(i));
					news.setName(hOP.getChildren().get(i).getDescription());
					newr.getVertices().add(news);
				}
				/**
				 * creation de la dernière région concurrente
				 */
				
				if(i == hOP.getChildren().size() -2) {
					Region rtemp2 = sgraph.createRegion();
					rtemp2.setName("Concurrency ||| n°" + (i+1) + " ");
					Entry entrytemp2 = sgraph.createEntry();
					State scomp2 = sgraph.createState();
					scomp.getRegions().add(rtemp2);
					if(hOP.getChildren().get(i+1).isLeaf()){
						scomp2.setName(hOP.getChildren().get(i+1).getDescription());
					}
					else {
				
						scomp2 = appel(hOP.getChildren().get(i+1));
						scomp2.setName(hOP.getChildren().get(i+1).getDescription());
					}
					rtemp2.getVertices().add(scomp2);	
				}
				scomptemp = scomp;
				newreg = null;
			}
		
		}

		return compositeFirst;
	}
	public static void main(String[] args) throws Exception{
		ConcurrencyWithEnable e = new ConcurrencyWithEnable();
    	HamstersAPI hampi = e.getAPI();
    	WriteFile.main(FactoryTransformation.Transform(hampi),".\\lol");
	}
}
