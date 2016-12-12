package ua.edu.khibs.resalex.Dao;

import ua.edu.khibs.resalex.model.Menu;
import java.util.List;

public interface MenuDao {
 List<Menu> findAllMenu();
 List findMenuByType (String name);
}
