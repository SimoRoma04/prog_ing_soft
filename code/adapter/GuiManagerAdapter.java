package adapter;

import model.GuiManager;

public class GuiManagerAdapter implements AdapterInterface{
	GuiManager m_guiManager;
	public GuiManagerAdapter(GuiManager guiManager)
	{
		m_guiManager = guiManager;
	}
}
