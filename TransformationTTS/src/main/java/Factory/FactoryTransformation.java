package Factory;

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

public class FactoryTransformation {
	static SGraphFactory factory = SGraphFactory.eINSTANCE;

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
					s = EnableFactory.enabletoSc((HamstersOperator) ha);
					re.getVertices().add(s);
					break;
				case "[]" :
					s = ChoiceFactory.choiceToSc((HamstersOperator) ha);
					re.getVertices().add(s);
					break;
				case "[>" :
					s = DisableFactory.disableToSc((HamstersOperator) ha);
					re.getVertices().add(s);
					break;
				case "|||" :
					s = ConcurrencyFactory.concurrencyToSc((HamstersOperator) ha);
					re.getVertices().add(s);
					break;
				case "|>" :
					s = SuspendResumeFactory.suspendResumeToSc((HamstersOperator) ha);
					re.getVertices().add(s);
					break;
				case "|=|" :
					s = OrderIndependantFactory.orderindependantToSC((HamstersOperator) ha);
					re.getVertices().add(s);
					break;

			}
		}

		FinalState fs = factory.createFinalState();
		s.getRegions().get(s.getRegions().size() - 1).getVertices().add(fs);
		Transition lastTransition = factory.createTransition();
		int last = s.getRegions().get(s.getRegions().size() - 1).getVertices().size() - 2;
		// lastTransition.setSource(s.getRegions().get(s.getRegions().size()-1).getVertices().get(last));
		// lastTransition.setTarget(fs);
		return sc;
	}

	public static State appel(HamstersNode hN) {
		HamstersOperator ha = null;
		if (hN instanceof HamstersTask) {
			ha = (HamstersOperator) hN.getChildren().get(0);
		} else if (hN instanceof HamstersOperator) {
			ha = (HamstersOperator) hN;
		}
		switch (ha.getDescription()) {
			case ">>" :
				return EnableFactory.enabletoSc(ha);
			case "[]" :
				return ChoiceFactory.choiceToSc(ha);
			case "[>" :
				return DisableFactory.disableToSc(ha);
			case "|||" :
				return ConcurrencyFactory.concurrencyToSc(ha);
			case "|>" :
				return SuspendResumeFactory.suspendResumeToSc(ha);
			case "|=|" : 
				return OrderIndependantFactory.orderindependantToSC(ha);
		}
		return null;
	}
}
