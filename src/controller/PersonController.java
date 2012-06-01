package controller;

import dataStore.ADS;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import model.PersonModel;
import view.PersonView;


public class PersonController {
	
	//The Controller needs to interact with both the Model and View.
	PersonModel m_model;
	PersonView m_view;
	ADS ds;
	List<String> res = new ArrayList<String>();
	String [] item = null;
	
	
	
	public PersonController (PersonModel model, PersonView view)
	{
		 m_model = model;
		 m_view = view;
		 
		 
		//Add listeners to the view.
                 
		view.addButtonFromDBListener(new ButtonFromDBListener());
		view.addButtonFromXMListener(new ButtonFromXMListener());
		view.addButtonFromCSVListener(new ButtonFromCSVListener());
		view.addButtonDeleteListener(new ButtonDeleteListener());
		view.addButtonSaveFileListener(new ButtonSaveFileListener());
		view.addButtonSaveDBListener(new ButtonSaveDBListener());
		view.addButtonCancelListener(new ButtonCancelListener());
		view.addButtonFrDBListener(new ButtonFrDBListener());
		view.addButtonToDBListener(new ButtonToDBListener());
		
		view.addTableMouseListener(new TAbleMouseListener());
		
	}
		
		//inner class ButtonFromDBListener
		
		//Backand
		class ButtonFrDBListener implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				m_model.Load(".DB"); 
				m_view.ShowData();	
			}
		}
		
		class ButtonToDBListener implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				
				m_model.Save(".toDB");
				
			}
		}
	
		class ButtonFromDBListener implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				m_model.Load(".DB");
				m_view.ShowData();	
			}
		}
		//inner class ButtonFromXMListener
		class ButtonFromXMListener implements ActionListener
		{
			
			public void actionPerformed(ActionEvent e)
			{
				m_model.Load("D:\\Temp\\MVC\\resXML.xml");
				m_view.ShowData();	
			}
		}
		
		//inner class ButtonFromCSVistener
		class ButtonFromCSVListener implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				m_model.Load("D:\\Temp\\MVC\\resCSV.csv");
				m_view.ShowData();	
			}
		}
		
		//inner class ButtonDeleteListener
		class ButtonDeleteListener implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				//m_view.ResetTable();
			}
		}
		
		//inner class ButtonSaveFileListener
		class ButtonSaveFileListener implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				m_view.FileChoice();
			}
		}
		
		//inner class ButtonSaveFileListener
		class ButtonSaveDBListener implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				m_model.Save(".DB");
				int res=0;
				if (res == JFileChooser.APPROVE_OPTION) 
				{
					JOptionPane.showMessageDialog(m_view, "Данные сохраненны");
				}
			}
		}
		
		//inner class ButtonCancelListener
		class ButtonCancelListener implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				m_view.CancelPersonView();
			}
		}
		
		//inner class TAbleMouseListener
		class TAbleMouseListener implements MouseListener
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				 if (e.getClickCount() == 2)
		         {
		         	//Insert form
					 m_view.InsRowToFrm();
		         }
		         
			}
			

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		}
		
		
	}


