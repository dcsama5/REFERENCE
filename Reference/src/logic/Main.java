package logic;/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 *
 * @author Administrator
 * 
 * This Main class currently implements the JDBC Interface. The add / show functions
 * are available to view.
 */
public class Main implements ApplicationInterface {
    
    public static final ApplicationContext ctx = new ClassPathXmlApplicationContext("logic/xmlconfig.xml");
    public static Scanner sc = new Scanner(System.in);
    //public static JDBCExcerptSpitter exc = (JDBCExcerptSpitter) ctx.getBean("excerptDAO");
    public static ExcerptSpitterDAO exc = (ExcerptSpitterDAO) ctx.getBean("hibernateExcerptSpitter");
    public static void main(String[] args) throws SQLException
    {
        String input = sc.nextLine();
        
        while(!input.equalsIgnoreCase("quit"))
        {
            
            System.out.println("about shto execute" + input);
            switch(input.toUpperCase())
            {
                case "INSERT":
                    insertEntry();
                    break;
                case "SHOW":
                    showData();
                    break;
                case "DELETE":
                        deleteEntry();
                        break;
                    
            }
            
            input = sc.nextLine();
        }
        System.out.println("end of program");
    }
    
    private static void insertEntry()
    {
        Excerpt c = new Excerpt();
        ExcerptIdentifier id = new ExcerptIdentifier();
        
        System.out.println("Enter account");
        c.setAccount(sc.nextLine());
        System.out.println("Enter excerpt");
      //  c.setExcerpt(sc.nextLine()); 
        id.setExcerpt(sc.nextLine());
        System.out.println("Enter link");
        c.setLink(sc.nextLine());
        System.out.println("Enter any comments you'd like to add");
        c.setComments(sc.nextLine());
        c.setId(id);
        
        exc.addExcerpt(c);
        
    }
    
    private static void showData() {
       Date date = new Date(113, 7, 1);
       List<Excerpt> objects = exc.retrieveByDate("AMEER");
       
       for(int i=0; i<objects.size(); i++)
       {    
           System.out.println(objects.get(i).getAccount()+"\t"+objects.get(i).getComments()+"\t"+objects.get(i).getLink());
       }
        
    }

    private static void deleteEntry() {
        
        
            
    }
    /**
     * Generates a map of all column value pairs for each row on the database. Expects only a single
     * rows
     */
    /*
    private static void getMappedExcerpt() {
         Map<String, Object> allExcerpts = exc.getMappedExcerpt();
        
        for(String s : allExcerpts.keySet())
        {
           Object obj =  allExcerpts.get(s);
            System.out.println(s + obj);
            
        }
    }*/
    @Override
    public void somemethod() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    

}
