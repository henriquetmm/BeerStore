
package beerproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.*;

/**
 *
 * @author Henrique
 */
public class Catalog {

    public static int pos = 0;
    public static ArrayList<Beer> list = new ArrayList<>();

    static Beer Budweiser = new Beer(10, "Lager", false, "Budweiser");
    static Beer Heineken= new Beer(30, "Lager", false, "Heineken");
    static Beer Rickards= new Beer(30, "Ale", false, "Rickard's Red");
    static Beer Coors= new Beer(10, "Lager", false, "Coors");
    static Beer Corona= new Beer(10,"Lager",false,"Corona");
    static Beer Urquell= new Beer(40,"Pilsner", false, "Pilsner Urquell");
    static Beer Old= new Beer(10, "Pilsner", false, "Old Style Pilsner");
    static Beer Steam= new Beer(20, "Pilsner", false, "Steam Whistle");
    static Beer Kolsh= new Beer(30, "Ale", false, "1857 kolsch-style ale");
    static Beer three=  new Beer(20, "Ale", false, "360 pale ale");
    static Beer Blue= new Beer(20,"Wheat", false, "Belgian Moon");
    static Beer Delirium= new Beer(30, "Ale", false, "Delirium Tremens");
    static Beer Granville= new Beer(20, "Ale", false, "Granville English Bay");
    static Beer Franziskaner= new Beer(30, "Wheat",false, "Franziskaner");
    static Beer Hoegaarden= new Beer(20, "Wheat", false, "Hoegaarden");
    static Beer Allagash =new Beer(10, "Wheat", false, "Allagash White");
    static Beer Brooklyn= new Beer(50, "Ale",true, "Brooklyn East India Pale Ale Beer");
    static Beer Goose= new Beer(60, "Ale", true,"Goose Island");
    static Beer Dogfish=new Beer(70, "Ale",true, "90 Minute IPA");
    
    /**
     * Method for adding a beer to the ArrayList
     * @param b 
     */
    public static void add(Beer b){
        list.add(b);
        pos = list.indexOf(b);
    }
     /**
     * Initializes list, adds the preset beers to Arraylist
     */
   /* public static void iniList() {
        list.add(Urquell);
        list.add(Steam);
        list.add(Old);
        list.add(Budweiser);
        list.add(Heineken);
        list.add(Coors);
        list.add(Corona);
        list.add(Rickards);
        list.add(Kolsh);
        list.add(three);
        list.add(Delirium);
        list.add(Granville);
        list.add(Blue);
        list.add(Franziskaner);
        list.add(Hoegaarden);
        list.add(Allagash);
        list.add(Brooklyn);
        list.add(Goose);
        list.add(Dogfish);
        
    }*/
    /**
     * Method for removing a Beer object from the ArrayList
     * @return 
     */
    public static String remove(){
        list.remove(pos);
        if(pos == 0){
            return "First position removed";
        }
        else{
            return "Beer removed";
        }
    }
    /**
     * Fetches the next object in the array, uses the pos for index, which indicates the user last alteration
     * @return 
     */
    public static String next() {
        if (pos + 1 < list.size()) {
            pos++;
            return list.get(pos).toString();
        }

        return "No next";
    }
    /**
     * Finds the previous object in in the ArrayList, uses the pos for index, which indicates the user last alteration
     * @return 
     */
    public static String previous() {
        if (pos - 1 >= 0) {
            pos--;
            return list.get(pos).toString();
        }
        return "No previous";
    }
   
    /**
     * Searches for a beer by name using a keyword entered by the user.
     * Matches any combination of characters before or after the keyword
     * @param name
     * @return 
     */
    public static String search(String name) {
        String res = "";
        boolean done = false;
        for (Beer b : list) {
            if (b.getName().matches("(.*)"+name+"(.*)")) {
                System.out.println(b.getName().equals(name));
                res = res + b.toString();
                pos = list.indexOf(b);
                done = true;

            }

        }
        if (!done) {
            res = "No results";
        }
        System.out.println(pos);
        return res;
    }
    /**
     * Searches by the IBU value
     * @param ibu
     * @return 
     */
    public static String searchIbu(int ibu) {
        boolean done = false;
        String res = "";
        for (Beer b : list) {
            if (b.getIbu() == ibu) {
                res = res + b.toString();
                pos = list.indexOf(b);
                done = true;

            }

        }
        if (!done) {
            res = "No results";
        }
        return res;
    }
    /**
     * Searches by style, selected on a dropdown list
     * @param style
     * @return 
     */
    public static String searchStyle(String style) {

        String res = "";
        for (Beer b : list) {
            if (b.getStyle().equals(style)) {
                res = res + b.toString();
                pos = list.indexOf(b);
            }

        }
        return res;
    }
    /**
     * Indicates that the beer follows the german purity law
     * @param IPA
     * @return 
     */
    public static String searchIPA(boolean IPA) {
        String res = "";
        boolean done = false;
        for (Beer b : list) {
            if (b.isIPA()) {
                res = res + b.toString();
                pos = list.indexOf(b);
                done = true;
            }

        }
        if (!done) {
            res = "No results";
        }
        return res;
    }
     public static void Readfile(){
         File file = new File("catalog.txt");
        try{
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                Beer b = new Beer(Integer.parseInt(sc.nextLine()), sc.nextLine(), Boolean.parseBoolean(sc.nextLine()), sc.nextLine());
                list.add(b);
            }}
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
     }
     
     
     
     public static void WriteFile(){
         Beer.openFile();
          for (Beer b : list) {
              Beer.addRecord(b);
          }
          Beer.closeFile();
     }
}
