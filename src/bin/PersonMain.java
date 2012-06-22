package bin;

import controller.PersonController;
import model.table.PersonModel;
import view.MainFrame;

public class PersonMain {
	
	//Create model, view, and controller.
	public static void main(String[] args)
	{
		
		
		PersonModel model = new PersonModel();
		MainFrame  view = new MainFrame(model);
		PersonController controller = new PersonController(model, view);
		
		view.setVisible(true);
		


	}


}
