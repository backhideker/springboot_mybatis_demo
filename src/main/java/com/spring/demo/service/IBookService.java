package com.spring.demo.service;

import com.alibaba.fastjson.JSONArray;
import com.spring.demo.entity.Book;
import com.spring.demo.entity.Boss;
import com.spring.demo.entity.User;
import com.spring.demo.entity.westPerson;

import java.util.List;

public interface IBookService {
    String saveBook(Book book);
    List<westPerson> findAll();
    String insertAll(JSONArray booList);

    void insertDocument(String id, Boss boss);
    void updateBook(String id, Book book);
    void updatePerson(westPerson westperson);

}
