package adapter;

import java.awt.Component;

import model.GuiManager;

public class GuiManagerAdapter implements AdapterInterface{
	GuiManager m_guiManager;
	public GuiManagerAdapter(GuiManager guiManager)
	{
		m_guiManager = guiManager;
	}
	
	public void add(Component comp, Object constraints)
	{
		m_guiManager.add(comp, constraints);
	}
}
