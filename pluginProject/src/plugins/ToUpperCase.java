package plugins;

public class ToUpperCase implements Plugin {
	
	public ToUpperCase(){
		
	}
	@Override
	public String transform(String s) {
		return s.toUpperCase();
	}

	@Override
	public String getLabel() {
		return "to upper case plugin";
	}

}
