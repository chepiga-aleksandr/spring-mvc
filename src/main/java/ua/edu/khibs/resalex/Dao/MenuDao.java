package ua.edu.khibs.resalex.Dao;

import ua.edu.khibs.resalex.model.Menu;

import java.util.List;

public interface MenuDao {

 void saveNewMenu(Menu menu);

 List<Menu> findAllMenu();

 Menu findMenuByName(String name);

 Menu findMenuById (Long id);

 void updateMenu (Menu menu);

}
