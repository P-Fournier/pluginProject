package plugins;

public class ToLowerCase implements Plugin {

	public ToLowerCase(){
		
	}
	@Override
	public String transform(String s) {
		return s.toLowerCase();
	}

	@Override
	public String getLabel() {
		return "to lower case plugin";
	}

}
