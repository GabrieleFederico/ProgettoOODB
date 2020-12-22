package dbConn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnessioneDB {

	private static ConnessioneDB istanza;
    private Connection connessione = null;
    private final String USERNAME = "postgres";
    private final String PASSWORD = "2802dueMILA";
    private final String IP = "localhost";
    private final String PORT = "5432";
    private String url = "jdbc:postgresql://"+IP+":"+PORT+"/postgres";
    
    private ConnessioneDB() throws SQLException{
    	
    	try {
    		
    		Class.forName("org.postgresql.Driver");
    		connessione = DriverManager.getConnection(url, USERNAME, PASSWORD);
    		
    	}
    	catch(ClassNotFoundException e){
    		System.out.println("Creazione di una Connessione al database fallita: "+ e.getMessage());
    		
    	}
    }

    public Connection getConnessione() {
    	return connessione;
    }
    
    public static ConnessioneDB getIstanza() throws SQLException {
    	if(istanza == null) {
    		istanza = new ConnessioneDB();
    	}
    	else if(istanza.getConnessione().isClosed()){
    		istanza = new ConnessioneDB();
    		
    	}
    	return istanza;
    }
    
}
