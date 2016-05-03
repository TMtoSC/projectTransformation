package translationTaskModelToStachart;

import org.yakindu.sct.model.sgraph.Entry;
import org.yakindu.sct.model.sgraph.EntryKind;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.SGraphFactory;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Transition;

import fr.projectM1.frozenhand.TransformationTTS.Disable;
import fr.projectM1.frozenhand.TransformationTTS.SuspendResume;
import hamsters.HamstersNode;
import hamsters.HamstersOperator;
import statechartsInXML.WriteFile;

/**
 * SuspendResumeFactory 
 * Classe servant à créer un état d'un stateChart avec l'opérateur Enable
 * tout en lui attachant des tâches
 * @author frozenhandgroup
 */
public class SuspendResumeTranslation extends TaskModelTranslation {
	
	/**
	 * sgraph est une instance de SGaphFactory de la bibliothèque Yakindu
	 */
	private static SGraphFactory sgraph = SGraphFactory.eINSTANCE;

	/**
	 * permet de parcourir une structure hiérachique de type hamsterOperateur
	 * et construit un état du stateChart
	 * @param hOP un hamsterOperateur pour parcourir la structure arborescente 
	 * @return un état 
	 */
	public static State suspendResumeToSc(HamstersOperator hOP) {
		State e = sgraph.createState();
		e.isComposite();
		e.setName(hOP.getDescription());
		Region r = sgraph.createRegion();
		e.getRegions().add(r);
		Entry deepHistory = sgraph.createEntry();
		deepHistory.setKind(EntryKind.DEEP_HISTORY);
		State temp = null;
		Transition t = null;
		/**
		 * création de l'état se faisant suspendre
		 */
		State suspend = sgraph.createState();
		suspend.isComposite();
		suspend.setName("suspend");
		r.getVertices().add(suspend);
		/**
		 * création de l'état suspentant
		 */
		State resume = sgraph.createState();
		resume.isComposite();
		resume.setName("Resume");
		r.getVertices().add(resume);
		/**
		 * création de la région qui se fait suspendre et ajout de celle-ci 
		 */
		Region rSusp = sgraph.createRegion();
		suspend.getRegions().add(rSusp);

		/**
		 * création de la région suspentrice
		 */
		Region rResu = sgraph.createRegion();
		resume.getRegions().add(rResu);

		/**
		 * transition permettant la suspension
		 */
		Transition suspentrice = sgraph.createTransition();
		suspentrice.setSource(suspend);
		suspentrice.setTarget(resume);
		/**
		 * Ajout du deepHistory dans la région
		 */
		rSusp.getVertices().add(deepHistory);
		
		State suspElement = sgraph.createState();
		if(!(hOP.getChildren().get(0).isLeaf())) {
			suspElement = recursiveTranslation(hOP.getChildren().get(0));
		}
		suspElement.setName(hOP.getChildren().get(0).getDescription());
		rSusp.getVertices().add(suspElement);
		
		State resuElement = sgraph.createState();
		if(!(hOP.getChildren().get(1).isLeaf())) {
			resuElement = recursiveTranslation(hOP.getChildren().get(0));
		}
		resuElement.setName(hOP.getChildren().get(1).getDescription());
		rResu.getVertices().add(resuElement);

		return e;
	}
	


}
