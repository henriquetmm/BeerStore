/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beerproject;

import java.util.Formatter;

/**
 *
 * @author henri
 */
public class Beer {
    int ibu = 0;
    String style = "Ale";
    boolean IPA = false;
    String name = "Beer";
    /**
     * Constructor takes an int for IBU, a String for style, boolean for IPA, String for Name
     * 
     */
    public Beer(int ibu,String style, boolean IPA, String name ){
        setIbu(ibu);
        setStyle(style);
        setIPA(IPA);
        setName(name);
    }
    /**
     * Returns an int for IBU value
     * @return 
     */
    public int getIbu() {
        return ibu;
    }
    /**
     * Sets IBU value for the object
     * @param ibu 
     */
    public void setIbu(int ibu) {
        if(ibu > 0 && ibu < 100)
        this.ibu = ibu;
        else
            throw new IllegalArgumentException("Invalid IBU value ");
    }
    /**
     * Gets object style ins String format
     * @return 
     */
    public String getStyle() {
        return style;
    }
    /**
     * Sets the beer style
     * @param style 
     */
    public void setStyle(String style) {
        if(style.trim().length() > 0)
        this.style = style;
        else
          throw new IllegalArgumentException("Invalid Style Name");  
    }
    /**
     * Return boolean value IPA
     * @return 
     */
    public boolean isIPA() {
        return IPA;
    }
    /**
     * Sets a IPA status, boolean
     * @param IPA
     */
    public void setIPA(boolean IPA) {
        this.IPA = IPA;
    }
    /**
     * Returns the name of the Beer in String form
     * @return 
     */
    public String getName() {
        return name;
    }
    /**
     * Sets the name of the beer
     * @param name 
     */
    public void setName(String name) {
    if(name.trim().length() > 0)
        this.name = name;
        else
          throw new IllegalArgumentException("Invalid Style Name"); 
    }
    /**
     * To string method returns a description of the beer, formatted
     * @return 
     */
    public String toString(){
        return String.format("Beer name: " + name + "\n" + "Beer style:  " +style + "\nIBU: " + ibu + "\nIndia Pale Ale: " + IPA + "\n-------------\n");
    }
    static Formatter x;
    public static void addRecord(Beer b){
        x.format("%s\n",Integer.toString(b.getIbu()));
        x.format("%s\n",b.getStyle());
        x.format("%s\n", Boolean.toString(b.isIPA()));
        x.format("%s\n",b.getName());
        
        
        
    }
    public static void openFile() {
        try {
            x = new Formatter("catalog.txt");
        }
        catch(Exception e){
            System.out.println("Error");
        }
    }
   public static void closeFile(){
        x.close();}
}
