package model.table;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;

import model.dataStore.DSFactory;
import model.except.ExtenException;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.person.Person;




public class PersonModel extends AbstractTableModel
{
    private final static String[] tblHeader =
                            { "ID", "Last name", "First name", "Age", "Image", "Phone" };
    private final static Class[] clmClass =
        {Integer.class, String.class, String.class, Integer.class, ImageIcon.class, String.class};
    
    public final static int COLUMNS = 6;
    
    public final static int ID_COL  = 0;
    public final static int LN_COL  = 1;
    public final static int FN_COL  = 2;
    public final static int AG_COL  = 3;
    public final static int PI_COL  = 4;
    public final static int PH_COL  = 5;
    
    private List<Person> plist = new ArrayList<Person>();
	
	public void save (String Fname)
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
	
	
	public void load(String fname)
        {	        
            try {
                if(fname!=null)
                {
                    plist = DSFactory.getInstance(fname).load();
                    fireTableDataChanged();
                }
                
                
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
	public int getColumnCount() 
	{
		return COLUMNS;
	}
	
        //Get RowCount at the jTable 
	@Override
	public int getRowCount() 
	{
		return plist.size();
	}

	@Override
        public String getColumnName(int column) 
	{
            return tblHeader[column];
        }  
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) 
        {
            Object res = null;
            Person p = plist.get(rowIndex);
            switch (columnIndex) {
                case ID_COL :
                        res = p.getId();
                        break;
                case LN_COL:
                        res = p.getLn();
                        break;
                case FN_COL:
                        res = p.getFn();
                        break;
                case AG_COL:
                        res = p.getAge();
                        break;
                case PH_COL:
                        res = p.getPh();
                        break;
                case PI_COL:
                        res = p.getIm();
                        if ((res == null) || res.equals(" ") || res.equals("")) {
                            res = convertImagee("user.jpg");
                        }
                        else{
                            res = convertImagee((String) res);
                        }
                        
                        
                        break;
            }
            return res;
	}

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
       
        Person p = plist.get(rowIndex);
       
        switch (columnIndex) {
                
                case LN_COL:
                        p.setLn((String) aValue);
                        break;
                case FN_COL:
                        p.setFn((String) aValue);
                        break;
                case AG_COL:
                        p.setAge((Integer) aValue);
                        break;
                case PH_COL:
                        p.setPh((String) aValue);
                        break;
            }
    }
    public void setValueImage(String aValue, int rowIndex, int columnIndex) {
       
        Person p = plist.get(rowIndex);

        p.setIm((String) aValue);

    }
	
    @Override
    public Class<?> getColumnClass(int columnIndex) {                                                               
            return clmClass[columnIndex];
    }  	

    @Override
    public boolean isCellEditable(int row, int col) {
            return (col != ID_COL && col != PI_COL);
    };
    
    public void addRow() {
            Integer newId = (plist.size()>0)? plist.get(plist.size()-1).getId()+1 : 0 ;
            plist.add(new Person(newId, "", "", 0, null, ""));
            this.fireTableRowsInserted(plist.size(), plist.size());
            
        }
 
    public void deleteRow(int row) {

        if(row>=0)
        {
            plist.remove(row);
            this.fireTableRowsDeleted(row, row);

        }
    }

    public ImageIcon convertImagee(String url) {
        Image img = (new ImageIcon(url)).getImage();  
        BufferedImage bi = new BufferedImage(60, 50, BufferedImage.TYPE_INT_ARGB);  
        Graphics g = bi.createGraphics();  
        g.drawImage(img, 0, 0, 60, 50, null); 
        
        return new ImageIcon(bi);
    }
}
