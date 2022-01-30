package adapter;

import java.awt.Component;

import model.GuiManager;
import model.PageTypes;

public class GuiManagerAdapter implements AdapterInterface{
	GuiManager m_guiManager;
	public GuiManagerAdapter(GuiManager guiManager) {
		m_guiManager = guiManager;
	}
	
	public void add(Component comp, Object constraints) {
		m_guiManager.add(comp, constraints);
	}
	
	public void loadPage(PageTypes type) {
		m_guiManager.loadPage(type);
	}
}
