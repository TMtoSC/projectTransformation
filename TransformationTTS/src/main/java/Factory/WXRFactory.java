/**
 * La class WXRFactory permet d'enregistrer sur son pc un fichier xml après transformation
 * @author frozenhandgroup
 */
package Factory;

import TranslationSCT.WriteFile;
import taskModelCreation.WXR;

public class WXRFactory {

	/**
	 * La méthode main permet la transformation d'un fichier xml de WXR
	 * et propose un frame pour l'enregistrement du fichier après transformation
	 * @param args les arguments
	 */
	public static void main(String[] args) {
		taskModelCreation.WXR wxr = new WXR();
		try {
			WriteFile.main(FactoryTransformation.Transform(wxr.getAPI()), "/Users/daviddang/Desktop/WXRTest");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
