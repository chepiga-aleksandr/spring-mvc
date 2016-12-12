package ua.edu.khibs.resalex.service;

import org.springframework.transaction.annotation.Transactional;
import ua.edu.khibs.resalex.Dao.MenuDao;
import ua.edu.khibs.resalex.model.Menu;

import java.util.List;

public class MenuService {

    private MenuDao menuDao;

    @Transactional
    public List<Menu> getAllMenu() {
        return menuDao.findAllMenu();
    }

    public List getMenuBreakfast (String name){
        return menuDao.findMenuByType("breakfast");
    }

    public List getMenuLunch (String name){
        return menuDao.findMenuByType("lunch");
    }

    public List getMenuDinner (String name){
        return menuDao.findMenuByType("dinner");
    }

    @Transactional
    public void setMenuDao(MenuDao menuDao) {
        this.menuDao = menuDao;
    }
}

