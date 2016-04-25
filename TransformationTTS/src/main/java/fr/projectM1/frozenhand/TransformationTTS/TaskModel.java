package fr.projectM1.frozenhand.TransformationTTS;

import java.io.File;

import taskModelCreation.Sequence;


public class TaskModel 
{
	private File xmlFile;
	private Sequence seq;

	
	public TaskModel(File file)
	{
		xmlFile = file;
		setSeq(new Sequence());
	}
	
	public TaskModel()
	{
		setSeq(new Sequence());
	}
	
	public String getName()
	{
		return xmlFile.getName();
	}

	public Sequence getSeq() {
		return seq;
	}

	public void setSeq(Sequence seq) {
		this.seq = seq;
	}

}
