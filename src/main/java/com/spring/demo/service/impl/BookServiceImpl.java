package com.spring.demo.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.spring.demo.entity.Book;
import com.spring.demo.entity.Boss;
import com.spring.demo.entity.User;
import com.spring.demo.entity.westPerson;
import com.spring.demo.service.IBookService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;


import java.util.Collection;
import java.util.Date;
import java.util.List;


@Service
public class BookServiceImpl implements IBookService {
    private static final Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);//日志输出的
    @Autowired
    private MongoTemplate mongoTemplate;//mongoDB的模板
    private MongoOperations mongoOperations;

    @Override
    public String saveBook(Book book) {
        book.setCreateDate(new Date());
        mongoTemplate.save(book);//save跟insert的用法
        //insert: 若新增数据的主键已经存在，则会抛 org.springframework.dao.DuplicateKeyException 异常提示主键重复，不保存当前数据。
        //save：如果主键已经存在，则对数据进行覆盖
        //insert: 可以一次性插入一整个列表，而不用进行遍历操作，效率相对较高。
        //save: 需要遍历列表，进行一个个的插入
        return "SaVeBoOk SuCcEsSfUl";
    }

    @Override
    public List<westPerson> findAll() {
        return mongoTemplate.findAll(westPerson.class);
    }

    @Override
    public String insertAll(JSONArray bookList) {

        List list = JSONArray.parseArray(bookList.toJSONString(),westPerson.class);
        System.out.println(list);
        Collection<westPerson> bookCollection = list;
        mongoTemplate.insertAll(bookCollection);
        return null;
    }

    //往一个document中插入一个document
    @Override
    public void insertDocument(String id , Boss boss) {

        Query query=new Query(Criteria.where("name").is("id"));//兄弟，注意一下
        //别导错包了
        //Criteria构造条件，如.gt大于，.lt小于，regex模糊查询等，query封装查询条件
        Update update=new Update();
        update.set("Boss",boss);
        mongoTemplate.upsert(query,update,westPerson.class);
    }

    @Override
    public void updateBook(String name, Book book) {
        try {
            Update update=new Update();
        } catch (Exception E) {

        }
    }
//更新WestPerson信息
    @Override
    public void updatePerson(westPerson westperson) {
          Update update=new Update();
          update.set("boss",westperson.getBoss());

          Query query=new Query();
          query.addCriteria(Criteria.where("name").is(westperson.getName()));
          mongoTemplate.upsert(query,update,westPerson.class);//最后一个为实体
    }
    //插入一个文档


}
