/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package appliswap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Teckos
 */
public class connexion {
     Connection con;
	String url;
        
         public connexion()
	{
		
	      
               // url="jdbc:mysql:appliswap";
               //url="jdbc:mysql:bdle26bl1";
            //url="jdbc:mysql://localhost/appliswap";  
            url="jdbc:mysql://192.168.10.4/appliswap";
                
                
               // connexion à la base de données
                
		try
		{
                //con=DriverManager.getConnection(url,"root","");
			con=DriverManager.getConnection(url,"root","admin");
                        
			 System.out.println("connexion à la base de données réussie");
		}
		catch(SQLException e)
		{
			System.out.println("problème de connexion à la base"+e.toString());
		}
                //chargement de notre pilote
                 try
		{
                    Class.forName("com.mysql.jdbc.Driver");
		    System.out.println("chargement du pilote réussi");
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("problème de chargement de pilote"+e.toString());
		}
        }
        
         public Connection get_connexion()
	{
		return con;
	}
    
    
}