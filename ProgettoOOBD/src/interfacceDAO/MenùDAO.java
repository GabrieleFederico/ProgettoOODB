package interfacceDAO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface Men�DAO {
	
	public ArrayList<String> getMen�ByRistorante(String nomeRistorante) throws SQLException;
}
