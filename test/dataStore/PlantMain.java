package dataStore;



import converter.FlowerConvertCSV;
import converter.TreeConvertCSV;
import java.io.IOException;
import plant.Flower;
import plant.Flower;
import plant.PlantList;
import plant.Tree;
import plant.Tree;

class PlantMain{
    public static PlantList initList0() {
        PlantList list = new PlantList();
      
        return list;
    }

    public static PlantList initList1() {
        PlantList list = new PlantList();
        FlowerConvertCSV t = new FlowerConvertCSV();
        TreeConvertCSV t2 = new TreeConvertCSV();
    
        Flower o = new Flower();
        o =( Flower) t.fromString("Flower;0;Rose;Ukraine;red;purpose;12;true;30.0;");
        list.add(o);
        
        return list;
    }
    
    public static PlantList initListM() {
        PlantList list = new PlantList();
        FlowerConvertCSV t = new FlowerConvertCSV();
        TreeConvertCSV t2 = new TreeConvertCSV();
    
        Flower o = new Flower();
        o =( Flower) t.fromString("Flower;0;Rose;Ukraine;red;purpose;12;true;30.0;");
        Tree o1 = new Tree();
        o1 =( Tree) t2.fromString("Tree;1;Dub;Ukraine;50.0;60.5;2.0;Leafy;Center;cool;");
        Flower o2 = new Flower();
        o2=( Flower) t.fromString("Flower;2;Tulpan;Goland;dark;strict;8;false;25.0;");
        Flower o3 = new Flower();
        o3 =( Flower) t.fromString("Flower;3;Rose2;Ukraine;red;purpose;15;true;20.0;");
        Tree o4 = new Tree();
        o4 =( Tree) t2.fromString("Tree;4;Dub434;Ukraine;50.0;60.5;2.0;Leafy;Center;bron;");

        list.add(o1); list.add(o); list.add(o2); list.add(o3); list.add(o4); 
        return list;
    }
   public static void main(String[] a){
       
        FlowerConvertCSV t = new FlowerConvertCSV();
        TreeConvertCSV t2 = new TreeConvertCSV();
    
        Tree o = new Tree();
        o =( Tree) t2.fromString("Tree;4;Dub434;Ukraine;50.0;60.5;2.0;Leafy;Center;bron;");
        Tree o2 = new Tree();
        o2 =( Tree) t2.fromString("Tree;5;Dub434;Ukraine;50.0;60.5;2.0;Leafy;Center;bron;");
        
        System.out.println(o2.equals(o));
   }
}