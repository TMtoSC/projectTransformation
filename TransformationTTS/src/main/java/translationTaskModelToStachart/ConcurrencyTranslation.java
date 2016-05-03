package translationTaskModelToStachart;

import org.yakindu.sct.model.sgraph.Entry;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.SGraphFactory;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Synchronization;
import org.yakindu.sct.model.sgraph.Transition;

import fr.projectM1.frozenhand.TransformationTTS.Concurrency;
import fr.projectM1.frozenhand.TransformationTTS.ConcurrencyWithAbstractTasks;
import fr.projectM1.frozenhand.TransformationTTS.EnablewithAbstractTasks;
import hamsters.HamstersAPI;
import hamsters.HamstersNode;
import hamsters.HamstersOperator;
import statechartsInXML.WriteFile;

/**
 * * ConcurrencyFactory 
 * @author Florent Cabric
 * Classe créant l'opérateur concurrence en SC
 */
public class ConcurrencyTranslation extends TaskModelTranslation{
	/**
	 * mise en place de la factory
	 */
	private static SGraphFactory sgraph = SGraphFactory.eINSTANCE;
	
	/**
	 * 
	 * @param hOP prend un opérateur en paramètre
	 * @return un Etat composé de sous états
	 */
	public static State concurrencyToSc(HamstersOperator hOP) {
		/**
		 * Création de l'orthogonal State.
		 */
		State ortogonalFirst = sgraph.createState();
		ortogonalFirst.isOrthogonal();
		ortogonalFirst.setName(hOP.getDescription());

		/**
		 * Ajout de la première région.
		 */
		
		Region r = sgraph.createRegion();
		r.setName("Première région concurrence");
		ortogonalFirst.getRegions().add(r);
		
		/**
		 * Création de l'entrée du statecharts
		 */
		Entry entry = sgraph.createEntry();
		r.getVertices().add(entry);


		/**
		 * création du premier état
		 */
		State s = sgraph.createState();
		
		/**
		 * Si état feuille création d'un état simple
		 * sinon appel de la récursivité
		 */
		if (hOP.getChildren().get(0).isLeaf()) {
			s.setName(hOP.getChildren().get(0).getDescription());
			r.getVertices().add(s);
		}
		else {
			HamstersNode ha = hOP.getChildren().get(0);
			s = recursiveTranslation(ha);
			r.getVertices().add(s);
		}
		/**
		 * creation de la transition de entrée vers nouvel état
		 */
		Transition t = sgraph.createTransition();
		t.setSource(entry);
		t.setTarget(s);
		/**
		 * création de la deuxieme concurrence en cas de concurrence binaire
		 */
		
		if( hOP.getChildren().size() <= 2){
			/** 
			 * création de la région qui sera concurrente à la première
			 * ajout de celle ci dans l'état orthogonal	
			 */
			Region r2 = sgraph.createRegion();
				ortogonalFirst.getRegions().add(r2);
				r2.setName("Deuxieme Region");
				/**
				 * création de l'entrée de la région 
				 * et ajout de celle ci
				 */
				Entry entry2 = sgraph.createEntry();
				r2.getVertices().add(entry2);

				/**
				 * création de l'état
				 */
				State s2 = sgraph.createState();
				
				/**
				 * Si état feuille création d'un état simple
				 * sinon appel de la récursivité
				 */
				if (hOP.getChildren().get(1).isLeaf()) {
					s2.setName(hOP.getChildren().get(1).getDescription());
					r2.getVertices().add(s2);
				}
				else {
					HamstersNode ha2 = hOP.getChildren().get(1);
					s2 = recursiveTranslation(ha2);
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
					ortogonalFirst.getRegions().add(newreg);
				}
				else {
				
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
				Entry enttemp = sgraph.createEntry();
				Region newr = sgraph.createRegion();
				newr.setName("Région n° " + i+i);
				scomp.getRegions().add(newr);
				newr.getVertices().add(enttemp);
				/**
				 * ajout du nouvel état !
				 */
				State news = sgraph.createState();
				if(hOP.getChildren().get(i).isLeaf()){
					news.setName(hOP.getChildren().get(i).getDescription());
				}
				else {
					news = recursiveTranslation(hOP.getChildren().get(i));
					news.setName(hOP.getChildren().get(i).getDescription());
				}
				newr.getVertices().add(news);
				Transition t2 = sgraph.createTransition();
				t2.setSource(enttemp);
				t2.setTarget(news);
				/**
				 * creation de la dernière région concurrente
				 */
				
	
				if(i == hOP.getChildren().size() -2) {
					Region rtemp2 = sgraph.createRegion();
					rtemp2.setName("Concurrency ||| n°" + (i+1) + " ");
					Entry entrytemp2 = sgraph.createEntry();
					State lastState = sgraph.createState();
					scomp.getRegions().add(rtemp2);
					rtemp2.getVertices().add(entrytemp2);
					if(hOP.getChildren().get(i+1).isLeaf()){
						lastState.setName(hOP.getChildren().get(i+1).getDescription());
					}
					else {
				
						lastState = recursiveTranslation(hOP.getChildren().get(i+1));
						lastState.setName(hOP.getChildren().get(i+1).getDescription());
					}
					rtemp2.getVertices().add(lastState);	
					Transition t3 = sgraph.createTransition();
					t3.setSource(entrytemp2);
					t3.setTarget(lastState);
				}
				scomptemp = scomp;
				newreg = null;
				t2 = null;
			}
		
		}

		return ortogonalFirst;
	}
}
