package TranslationSCT;

import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.yakindu.sct.model.resource.SCTResourceFactory;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.SGraphFactory;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.sgraph.Vertex;
import org.yakindu.sct.ui.editor.DiagramActivator;
import org.yakindu.sct.ui.editor.editor.StatechartDiagramEditor;
import org.yakindu.sct.ui.editor.factories.FactoryUtils;

import Factory.FactoryTransformation;
import hamsters.HamstersAPI;
import hamsters.HamstersOperator;

import org.eclipse.emf.common.util.*;

public class WriteFile {

	public static void main(Statechart sc) throws Exception
	{
		
		/*SGraphFactory factory;
		Statechart statechart;
		Region region;
		Vertex state;
		Vertex state2;
		Transition trans;
		
		factory = SGraphFactory.eINSTANCE;
		statechart = SGraphFactory.eINSTANCE.createStatechart();
		statechart.setName("TA MERE");
		region = factory.createRegion();
		region.setName("REGION");
		statechart.getRegions().add(region);
		state = factory.createEntry();
		state.setName("ETAT");
		state2 = factory.createState();
		state2.setName("ETAT2");
		region.getVertices().add(state);
		region.getVertices().add(state2);
		trans = factory.createTransition();
		trans.setSource(state);
		trans.setTarget(state2);
	*/
		URI uri = URI.createFileURI("/Users/daviddang/Desktop/MONFICHIER.sct");
	/*	Statechart sc;
		SGraphFactory factory = SGraphFactory.eINSTANCE;
		sc = factory.createStatechart();
		sc.setName("Test");
		Region re = factory.createRegion();
		re.setName("RegTest");
		sc.getRegions().add(re);
		State s = FactoryTransformation.enabletoSc(hOP);
		re.getVertices().add(s);
		*/
		
		
		
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("sct", new SCTResourceFactory());
		
		ResourceSet reset = new ResourceSetImpl();
		reset.getResourceFactoryRegistry().getExtensionToFactoryMap().put("sct", new SCTResourceFactory());
		XMIResourceImpl ress = new XMIResourceImpl(uri);
		ress.getContents().add(sc);
		ress.save(Collections.EMPTY_MAP);

	}
}
