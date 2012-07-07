package dialog;

/**
 * Created by Exadel Studio
 *
 */
public class Welcome {
    String name;
    String inputName;

    public Welcome() {}

    public String check() {
    	inputName = name;
    	return "continue";
    }

    public void setName(String name) {
    	this.name = name;
    }

    public String getName() {
    	return name;
    }

    public void setInputName(String name) {
    	this.inputName = name;
    }

    public String getInputName() {
    	return inputName;
    }

    public String accept() {
    	name = inputName;
    	return "ok";
    }
}