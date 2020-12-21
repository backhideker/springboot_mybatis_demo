package com.spring.demo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.io.Serializable;
import java.util.List;

@Document(collection = "westperson")
public class westPerson implements Serializable {
    public Document getAccomplishment() {
        return accomplishment;
    }

    public void setAccomplishment(Document accomplishment) {
        this.accomplishment = accomplishment;
    }

    public String getDescri() {
        return descri;
    }

    public void setDescri(String descri) {
        this.descri = descri;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "westPerson{" +

                ", name='" + name + '\'' +
                ", descri='" + descri + '\'' +
                ", accomplishment=" + accomplishment +
                ", boss=" + boss +
                '}';
    }





    public List getBoss() {
        return boss;
    }

    public void setBoss(List boss) {
        this.boss = boss;
    }


    private String name;
    private String descri;
    private Document accomplishment;//成就
    private List boss;//上司集合，反正都是瞎几把写的


}
