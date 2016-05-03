package translationTaskModelToStachart;

import org.yakindu.sct.model.sgraph.CompositeElement;
import org.yakindu.sct.model.sgraph.FinalState;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.RegularState;
import org.yakindu.sct.model.sgraph.SGraphFactory;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.Transition;
//import org.yakindu.sct.model.sgraph.*;
import org.yakindu.sct.model.sgraph.impl.SGraphFactoryImpl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource.Factory;

import hamsters.HamstersAPI;
import hamsters.HamstersNode;
import hamsters.HamstersOperator;
import hamsters.HamstersTask;
import hamsters.OperatorType;

/**
 * FactoryTransformation
 * Classe servant à faire une transformation en un stateChart selon un opérateur lotos
 * @author frozenhand
 */
public class TaskModelTranslation {
	/**
	 * factory est une instance de SGaphFactory de la bibliotheque Yakindu
	 */
	static SGraphFactory factory = SGraphFactory.eINSTANCE;

	/**
	 * Transform permet de retourner un stateChart  à partir d'une HamsterAPI
	 * @param hAPI une HamstersAPI
	 * @return un stateChart
	 * @throws Exception exception levée en cas de creation du stateChart ou de ses régions
	 */
	public static Statechart Transform(HamstersAPI hAPI) throws Exception {
		Statechart sc;
		sc = factory.createStatechart();
		sc.setName("initial stateChart");
		Region re = factory.createRegion();
		re.setName("initial region");
		sc.getRegions().add(re);
		State s = factory.createState();

		HamstersNode ha = hAPI.getHamstersNode().get(0);
		if (ha instanceof HamstersTask)
			ha = (HamstersNode) ha.getChildren().get(0);
		if (ha instanceof HamstersOperator) {
			switch (ha.getDescription()) {
				case ">>" :
					s = EnableTranslation.enabletoSc((HamstersOperator) ha);
					re.getVertices().add(s);
					break;
				case "[]" :
					s = ChoiceTranslation.choiceToSc((HamstersOperator) ha);
					re.getVertices().add(s);
					break;
				case "[>" :
					s = DisableTranslation.disableToSc((HamstersOperator) ha);
					re.getVertices().add(s);
					break;
				case "|||" :
					s = ConcurrencyTranslation.concurrencyToSc((HamstersOperator) ha);
					re.getVertices().add(s);
					break;
				case "|>" :
					s = SuspendResumeTranslation.suspendResumeToSc((HamstersOperator) ha);
					re.getVertices().add(s);
					break;
				case "|=|" :
					s = OrderIndependentTranslation.orderindependantToSC((HamstersOperator) ha);
					re.getVertices().add(s);
					break;

			}
		}

		FinalState fs = factory.createFinalState();
		s.getRegions().get(s.getRegions().size() - 1).getVertices().add(fs);
		Transition lastTransition = factory.createTransition();
		int last = s.getRegions().get(s.getRegions().size() - 1).getVertices().size() - 2;

		return sc;
	}

	/**
	 * appel retourne un état selon l'opérateur lotos du noeud hamstersNode
	 * et le transformé en StateChart
	 * @param hN un noeud hamsters
	 * @return un  état
	 */
	public static State recursiveTranslation(HamstersNode hN) {
		HamstersOperator ha = null;
		if (hN instanceof HamstersTask) {
			ha = (HamstersOperator) hN.getChildren().get(0);
		} else if (hN instanceof HamstersOperator) {
			ha = (HamstersOperator) hN;
		}
		switch (ha.getDescription()) {
			case ">>" :
				return EnableTranslation.enabletoSc(ha);
			case "[]" :
				return ChoiceTranslation.choiceToSc(ha);
			case "[>" :
				return DisableTranslation.disableToSc(ha);
			case "|||" :
				return ConcurrencyTranslation.concurrencyToSc(ha);
			case "|>" :
				return SuspendResumeTranslation.suspendResumeToSc(ha);
			case "|=|" : 
				return OrderIndependentTranslation.orderindependantToSC(ha);
		}
		return null;
	}
}
