package com.spring.demo.entity;

public class Boss {
    @Override
    public String toString() {
        return "Boss{" +
                "name='" + name + '\'' +
                ", describ='" + describ + '\'' +
                '}';
    }

    public String getDescrib() {
        return describ;
    }

    public void setDescrib(String describ) {
        this.describ = describ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
    private String describ;

}
