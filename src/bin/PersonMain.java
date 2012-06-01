package bin;

import controller.PersonController;
import model.PersonModel;
import view.PersonView;




public class PersonMain {
	
	//Create model, view, and controller.
	public static void main(String[] args)
	{
		
		
		PersonModel  model = new PersonModel();
		PersonView   view = new PersonView(model);
		PersonController controller = new PersonController(model, view);
		
		view.setVisible(true);
		


	}


}
