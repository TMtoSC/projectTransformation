package fr.projectM1.frozenhand.TransformationTTS;

import java.io.File;

import taskModelCreation.Enable;


public class TaskModel 
{
	private File xmlFile;
	private Enable seq;

	
	public TaskModel(File file)
	{
		xmlFile = file;
		setSeq(new Enable());
	}
	
	public TaskModel()
	{
		setSeq(new Enable());
	}
	
	public String getName()
	{
		return xmlFile.getName();
	}

	public Enable getSeq() {
		return seq;
	}

	public void setSeq(Enable seq) {
		this.seq = seq;
	}

}
