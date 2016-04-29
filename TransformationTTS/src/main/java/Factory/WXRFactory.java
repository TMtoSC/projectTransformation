package Factory;

import TranslationSCT.WriteFile;
import taskModelCreation.WXR;

public class WXRFactory {

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
