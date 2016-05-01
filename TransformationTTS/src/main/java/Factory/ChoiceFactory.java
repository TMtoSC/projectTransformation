/**
 * Permet de créer un état d'un stateChart avec l'opérateur choice
 * tout en lui attachant des tâches
 * @author frozenhandgroup
 */
package Factory;

import org.yakindu.sct.model.sgraph.Choice;
import org.yakindu.sct.model.sgraph.Entry;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.SGraphFactory;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Transition;

import TranslationSCT.WriteFile;
import hamsters.HamstersOperator;

public class ChoiceFactory extends FactoryTransformation {
	/**
	 * factory est une instance de SGaphFactory de la bibliotheque Yakindu
	 */
	private static SGraphFactory sgraph = SGraphFactory.eINSTANCE;

	/**
	 * permet de parcourir une structure hiérachique de type hamsterOperateur
	 * et construit un état du stateChart
	 * @param hOP un hamsterOperateur pour parcourir la structure arborescente 
	 * @return un état 
	 */
	public static State choiceToSc(HamstersOperator hOP) {
		// création de l'état composite initial
		State e = sgraph.createState();
		e.isComposite();
		e.setName(hOP.getDescription());
		
		// création de la région de cet état composite
		Region r = sgraph.createRegion();
		e.getRegions().add(r);
		
		// création du point d'entrée de la région link au premier état qui ammorce le choix
		Entry ent = sgraph.createEntry();
		r.getVertices().add(ent);
		
		// création de l'état ammorcant le choix
		Choice initialChoiceState = sgraph.createChoice();
		r.getVertices().add(initialChoiceState);
		
		// création de la transition entre l'entry et l'état ammorcant le choix
		Transition firstTransition = sgraph.createTransition();
		firstTransition.setSource(ent);
		firstTransition.setTarget(initialChoiceState);
		// variable concernant les différents fils du choix 
		State temp = null;
		Transition t = null;
		
		// création des fils et de ses transitions avec le parent 
		for (int i = 0; i < hOP.getChildren().size(); i++) {
			if(!(hOP.getChildren().get(i).getClass().equals(HamstersOperator.class)))
			{
				temp = sgraph.createState();
				temp.setName(hOP.getChildren().get(i).getDescription());
				r.getVertices().add(temp);
			}
			else {
				/**
				 * Faire attention
				 * possibilité de bug !
				 */
				HamstersOperator ot = (HamstersOperator) hOP.getChildren().get(i);
				temp = appel(ot);
				r.getVertices().add(temp);
			}

			// création de toutes les transitions
			t = sgraph.createTransition();
			t.setSource(initialChoiceState);
			t.setTarget(temp);
			t = null;
		}
		return e;
	}
	
	/**
	 * Permet de simuler la création d'une tâche avec l'opérateur choice
	 * @param args
	 */
	public static void main (String[] args){
		taskModelCreation.Choice c = new taskModelCreation.Choice();
		try {
			WriteFile.main(FactoryTransformation.Transform(c.getAPI()),"/Users/daviddang/Desktop/choiceTest");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
