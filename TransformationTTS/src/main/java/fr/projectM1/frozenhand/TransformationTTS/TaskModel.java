package fr.projectM1.frozenhand.TransformationTTS;

import java.io.File;
import hamsters.HamstersAPI;

public class TaskModel 
{
	private File xmlFile;
	private HamstersAPI hamAPI = new HamstersAPI("Sequence 1");
	
	public TaskModel(File file)
	{
		xmlFile = file;
	}
	
	public TaskModel()
	{
		
	}
	
	public String getName()
	{
		return xmlFile.getName();
	}

}
