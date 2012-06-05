package model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;

import dataStore.DSFactory;
import except.ExtenException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import person.Person;




public class PersonModel extends AbstractTableModel
{
	
	private List<Person> plist = new ArrayList<Person>();
	
	public void Save (String Fname)
	{
            try {
                DSFactory.getInstance(Fname).save(plist);
            } catch (IOException ex) {
                Logger.getLogger(PersonModel.class.getName()).log(Level.SEVERE, null, ex);
            }
            catch (ExtenException ex) {
                Logger.getLogger(PersonModel.class.getName()).log(Level.SEVERE, null, ex);
            }
	}
	
	
	public void Load(String Fname)
        {	        
            try {
                plist = DSFactory.getInstance(Fname).load();
            } catch (IOException ex) {
                Logger.getLogger(PersonModel.class.getName()).log(Level.SEVERE, null, ex);
            }
            catch (ExtenException ex) {
                Logger.getLogger(PersonModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


	public List<Person> getPlist() 
	{
		return plist;
	}

	public void setPlist(List<Person> plist) 
	{
		this.plist = plist;
	}


	//****Table Model
	
	public void setRow( int rowIndex, Person p )
	{
		plist.set(rowIndex, p);
	}
	public void addRow( Person p )
	{
		plist.add(p);
	}
	
	@Override
	//Get ColumnCount at the jTable
	public int getColumnCount() 
	{
		return 5;
	}

	@Override
	//Get RowCount at the jTable 
	public int getRowCount() 
	{
		
		return plist.size();
	}

	@Override
        public String getColumnName(int column) 
	{
            return new String[]{"ID", "Lname", "Fname", "Age", "Photo"}[column];
        }  
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return plist.get(rowIndex).getId();
		case 1:
			return plist.get(rowIndex).getLn();
		case 2:
			return plist.get(rowIndex).getFn();
		case 3:
			return plist.get(rowIndex).getAge();	
		}
		return null;
		
	}
	
	@Override
        public Class<?> getColumnClass(int columnIndex) {                                                               
            return new Class[]{Integer.class, String.class, String.class, Integer.class, ImageIcon.class}[columnIndex];
        }  	
    
	@Override
	public boolean isCellEditable(int arg0, int arg1) {
		return false;
	};
}
