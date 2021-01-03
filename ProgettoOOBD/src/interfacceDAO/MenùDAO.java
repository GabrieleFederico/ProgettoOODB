package interfacceDAO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface MenùDAO {
	
	public ArrayList<String> getMenùByRistorante(String nomeRistorante) throws SQLException;
}
