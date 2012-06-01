package view;

import java.awt.Button;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.Iterator;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.PersonModel;


public class PersonView extends JFrame
{
	PersonModel tmodel;
	
	JFileChooser fc = new JFileChooser();
	
	//Components
	Button FromDB = new Button("From DB");
	Button FromXML = new Button("FromXML");
	Button FromCSV = new Button("FromCSV");
	Button FromJson = new Button("FromJson");
	Button remove = new Button("Delete");
	Button SaveFile = new Button("Save to File");
	Button SaveDB = new Button("Save to DB");
	Button Cancel = new Button("Cancel");
	Button ToDB = new Button("ToDB");
	Button FrDB = new Button("FrDB");
	JTable table;
	
	
	//Constructor
	public PersonView (PersonModel model)
	{
		tmodel = model;		
		table = new JTable();
		
		
				
		table.setModel(tmodel);
		table.setRowHeight(50);
		
		getContentPane().add(new JScrollPane(table));
		
		JPanel buttons = new JPanel();
		
		//Table(grid) buttons
		GridLayout gl = new GridLayout(2, 0, 5, 5);
		buttons.setLayout(gl);
				
		buttons.add(FromDB);
		buttons.add(FromXML);
		buttons.add(FromCSV);
		buttons.add(FromJson);
		buttons.add(ToDB);
		buttons.add(FrDB);
		buttons.add(SaveFile);
		buttons.add(SaveDB);
		buttons.add(remove);
		buttons.add(Cancel);
				
		getContentPane().add(buttons, "South");
		
		table.setDefaultEditor(String.class, null);
		this.setTitle("Person");
		this.setSize(400, 300);
		this.setVisible(true);
		this.setLocation(300, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
		

	public	void addButtonFrDBListener(ActionListener frdb)
		{
			FrDB.addActionListener(frdb);
		}
		
	public	void addButtonToDBListener(ActionListener todb)
		{
			ToDB.addActionListener(todb);
		}
		
		//
	
	public	void addButtonFromDBListener(ActionListener fdb)
		{
			FromDB.addActionListener(fdb);
                }
		
		//Listener of FromXML Button
	public	void addButtonFromXMListener(ActionListener fxm)
		{
			FromXML.addActionListener(fxm);
		}
		
		//Listener of FromCSV Button
	public	void addButtonFromCSVListener(ActionListener fcs)
		{
			FromCSV.addActionListener(fcs);
		}
		
		//Listener of FromJson Button
	public	void addButtonFromJsonListener(ActionListener fjs)
		{
			FromJson.addActionListener(fjs);
		}
		
		//Listener of Delete Button
	public	void addButtonDeleteListener(ActionListener dlt)
		{
			remove.addActionListener(dlt);
		}
		
		//Listener of SaveFile Button
	public	void addButtonSaveFileListener(ActionListener sfl)
		{
			SaveFile.addActionListener(sfl);
		}
		
		//Listener of SaveDB Button
	public	void addButtonSaveDBListener(ActionListener sdb)
		{
			SaveDB.addActionListener(sdb);
		}
		
		//Listener of Cancel Button
	public	void addButtonCancelListener(ActionListener ext)
		{
			Cancel.addActionListener(ext);
		}
		
		
		//***Mouse Listeners
	public  void addTableMouseListener(MouseListener mse)
		{
			table.addMouseListener(mse);
		}
		
		//Cancel PersonView
		public void CancelPersonView()
		{
			dispose();
		}

		
	//Show data at the Table
	public  void ShowData() 
		{
			
			table.revalidate();
		
		}
	// Insert Data to Edit Form (frmPerson)
	public void InsRowToFrm() 
                {
			//frmPerson pers = new frmPerson(PersonView.this, tmodel);

			String resultId = "";
			String resultFn = "";
			String resultLn = "";
			String resultAge = "";

			int[] selectedRows = table.getSelectedRows();
			for (int i = 0; i < selectedRows.length; i++) {
				int selIndex = selectedRows[i];

				Object valueID = tmodel.getValueAt(selIndex, 0);
				Object valueFname = tmodel.getValueAt(selIndex, 1);
				Object valueLname = tmodel.getValueAt(selIndex, 2);
				Object valueAge = tmodel.getValueAt(selIndex, 3);
				Object valuePh = tmodel.getValueAt(selIndex, 4);

				resultId = resultId + valueID;
				resultFn = resultFn + valueFname;
				resultLn = resultLn + valueLname;
				resultAge = resultAge + valueAge; 


			}
//			pers.getFieldFn().setText(resultFname);
//			pers.getFieldLn().setText(resultLname);
//			pers.getFieldId().setText(resultID);
//			pers.getFieldAg().setText(resultAge);
//			pers.getLabelPh().setIcon(imageTab);
		}
		
				
		public void FileChoice ()
		{
			int res = 0;
			if (res == JOptionPane.YES_OPTION) 
			{
				fc.setDialogTitle("Сохранение файла");
				// настройка режима
				fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
				int res1 = fc.showSaveDialog(PersonView.this);
				
			}
			// Let know about success
			if (res == JFileChooser.APPROVE_OPTION) 
			{
				// Get File Name
				File file = fc.getSelectedFile();

				// Save file for absolute path
				tmodel.Save(file.getAbsolutePath());

				JOptionPane.showMessageDialog(PersonView.this, "Файл сохранен");
			}

						
		}
		
			
}

