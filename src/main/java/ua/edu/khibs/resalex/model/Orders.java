package ua.edu.khibs.resalex.model;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table (name = "orders")
public class Orders {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private Long id;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn (name = "employee_id", referencedColumnName = "id")
    private Integer employeeId;

@ManyToMany
@JoinColumn (name = "dish_to_orders", referencedColumnName = "")

    private Integer dishToOrder;

    @Column (name = "table_number")
    private Integer numberOgTable;

    @Column (name = "order_date")
    private Date orderDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getDishToOrder() {
        return dishToOrder;
    }

    public void setDishToOrder(Integer dishToOrder) {
        this.dishToOrder = dishToOrder;
    }

    public Integer getNumberOgTable() {
        return numberOgTable;
    }

    public void setNumberOgTable(Integer numberOgTable) {
        this.numberOgTable = numberOgTable;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", employeeId=" + employeeId +
                ", dishToOrder=" + dishToOrder +
                ", numberOgTable=" + numberOgTable +
                ", orderDate=" + orderDate +
                '}';
    }
}
