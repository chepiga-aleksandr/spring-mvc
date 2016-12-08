package ua.edu.khibs.resalex.Dao;

import java.util.List;

public interface MenuDao {

 List findAllMenu();

 List findMenuByType (String name);

}
