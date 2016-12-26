package ua.edu.khibs.resalex.service;

import org.springframework.transaction.annotation.Transactional;
import ua.edu.khibs.resalex.Dao.DishDao;
import ua.edu.khibs.resalex.Dao.MenuDao;
import ua.edu.khibs.resalex.model.Dish;
import ua.edu.khibs.resalex.model.Menu;

import java.util.ArrayList;
import java.util.List;

public class MenuService {

    private MenuDao menuDao;
    private DishDao dishDao;

    @Transactional
    public List<Menu> getAllMenu() {
        return menuDao.findAllMenu();
    }

    @Transactional
    public Menu getMenuById(Long id) {
        return menuDao.findMenuById(id);
    }

    @Transactional
    public List<Dish> getDishToAddToMenu(String menuName) {
        List<Dish> menuDish = menuDao.findMenuByName(menuName).getListOfDishes();
        List<Dish> allDishes = dishDao.findAllDishes();
        List<Dish> dishToAdd = new ArrayList<>();

        for (Dish d : allDishes) {
            if (!menuDish.contains(d)) {
                dishToAdd.add(d);
            }
        }
        return dishToAdd;
    }

    @Transactional
    public void updateMenuInfo(Long id, String name) {
        Menu menu = menuDao.findMenuById(id);
        menu.setInfo(name);
        menuDao.updateMenu(menu);
    }

    @Transactional
    public void addDishToMenu(String menuName, String[] dishToAdd) {
        Menu menu = menuDao.findMenuByName(menuName);
        List<Dish> menuDish = menu.getListOfDishes();

        for (String dishName : dishToAdd) {

            Dish dish = dishDao.findDishByName(dishName);

            menuDish.add(dish);
        }
        menu.setListOfDishes(menuDish);
        menuDao.updateMenu(menu);
    }

    @Transactional
    public void addNewMenu(String name, List<Dish> dishes) {

        Menu menu = new Menu();
        menu.setName(name);
        menu.setListOfDishes(dishes);
        menuDao.saveNewMenu(menu);
    }

    public Menu getMenuBreakfast(String name) {
        return menuDao.findMenuByName("breakfast");
    }

    public Menu getMenuLunch(String name) {
        return menuDao.findMenuByName("lunch");
    }

    public Menu getMenuDinner(String name) {
        return menuDao.findMenuByName("dinner");
    }

    @Transactional
    public void setMenuDao(MenuDao menuDao) {
        this.menuDao = menuDao;
    }

    @Transactional
    public void setDishDao(DishDao dishDao) {
        this.dishDao = dishDao;
    }
}

