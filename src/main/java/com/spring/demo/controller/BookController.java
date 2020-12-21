package com.spring.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.spring.demo.entity.Book;
import com.spring.demo.entity.westPerson;
import com.spring.demo.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class BookController {
    @Autowired
    private IBookService bookService;

    @Autowired
    private JdbcTemplate template;
    @PostMapping("findalluser")
    public List<Map<String, Object>> findalluser(){
        String sql="select * from user";

        return template.queryForList(sql);
    }
    @PostMapping("/savebook")
    public String savebook(@RequestBody Book book){
        return bookService.saveBook(book);
    }


    @PostMapping("/insertBoss")
    public String insertDocument(
            @RequestBody String id,
            @RequestBody String BossMesseger
    ){
        System.out.println("fuckyou");

        System.out.println(BossMesseger);
        System.out.println(id==BossMesseger);
        return "insertDocument Successful";
    }


    @PostMapping("/findall")

    public List bookList(){
        return bookService.findAll();
    }
    @PostMapping("/insertAll")
    public String insertAll(@RequestBody JSONArray booCollection){
          bookService.insertAll(booCollection);
        return "sucess";
    }
    /**
     * 应该还有修改mongodb的东西
     */
    @PostMapping("/update")
    public String  updateBook(@RequestBody Book book,
    @RequestBody String id){
        bookService.updateBook(id,book);
        return "update Successful";
    }

    /**
     * 尝试更新表
     */
    @PostMapping("/updateperson")
    public String updateperson(@RequestBody JSONObject personJSON){

        try{
            westPerson westperson=JSONObject.parseObject(JSON.toJSONBytes(personJSON),westPerson.class);
            bookService.updatePerson(westperson);
        }catch (Exception e){

        }
        return "succesful";
    }
}
