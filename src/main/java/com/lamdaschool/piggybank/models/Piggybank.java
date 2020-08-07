package com.lamdaschool.piggybank.models;

import javax.persistence.*;

@Entity
@Table(name="coins")

public class Piggybank
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long coinid;
    private String name;
    private String namepural;
    private Long value;
    private int quantity;

    public Piggybank(String name, String namepural, Long value, int quantity)
    {
        this.name = name;
        this.namepural = namepural;
        this.value = value;
        this.quantity = quantity;
    }

    public Piggybank()
    {

    }

    public Long getCoinid() {
        return coinid;
    }

    public void setCoinid(Long coinid) {
        this.coinid = coinid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNamepural() {
        return namepural;
    }

    public void setNamepural(String namepural) {
        this.namepural = namepural;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Piggybank{" +
                "coinid=" + coinid +
                ", name='" + name + '\'' +
                ", namepural='" + namepural + '\'' +
                ", value=" + value +
                ", quantity=" + quantity +
                '}';
    }
}
