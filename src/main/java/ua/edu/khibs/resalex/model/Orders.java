package ua.edu.khibs.resalex.model;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name = "orders_to_dish",
            joinColumns = @JoinColumn(name = "orders_id"),
            inverseJoinColumns = @JoinColumn(name = "dish_id")
    )
    private List<Dish> listOfDishInOrder;

    @Column(name = "table_number")
    private Integer numberOfTable;

    @Column(name = "order_date")
    private Date orderDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<Dish> getListOfDishInOrder() {
        return listOfDishInOrder;
    }

    public void setListOfDishInOrder(List<Dish> listOfDishInOrder) {
        this.listOfDishInOrder = listOfDishInOrder;
    }

    public Integer getNumberOfTable() {
        return numberOfTable;
    }

    public void setNumberOfTable(Integer numberOfTable) {
        this.numberOfTable = numberOfTable;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
}
