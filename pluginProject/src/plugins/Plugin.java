package plugins;

public interface Plugin {
	
	/**
	 * transformation apply to the string past in parameter
	 * @param s string modification
	 * @return the transformed string
	 */
	public String transform(String s);
	
	/**
	 * the plugin's name in the tools menu
	 * @return the plugin's name
	 */
	public String getLabel();
}
