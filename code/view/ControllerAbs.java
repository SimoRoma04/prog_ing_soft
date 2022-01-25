package view;

public abstract class ControllerAbs {
	
	private String m_name;
	
	public ControllerAbs(String name) {
		m_name = name;
	}
	
	public String getName() {
		return m_name;
	}
}
