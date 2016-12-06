package ua.edu.khibs.resalex.service;

import org.springframework.transaction.annotation.Transactional;
import ua.edu.khibs.resalex.Dao.RestaurantDao;
import ua.edu.khibs.resalex.model.Restaurant;

public class RestaurantService {

    private RestaurantDao restaurantDao;

    @Transactional
    public Restaurant getInfo() {

        return restaurantDao.allInformation();
    }

    @Transactional
    public void setRestaurantDao(RestaurantDao restaurantDao) {
        this.restaurantDao = restaurantDao;
    }

}
