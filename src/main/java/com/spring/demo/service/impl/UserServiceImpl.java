package com.spring.demo.service.impl;

import com.spring.demo.dao.IUserDao;
import com.spring.demo.entity.User;
import com.spring.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jie.a.xie on 8/31/2020.
 */

/**
 * @Service    -- service标注业务层组件
 * 这个注解是写在类上面的，标注将这个类交给Spring容器管理，spring容器要为他创建对象
 *
 * @autowired  -- DI注入
 * 这个注解是用来修饰变量的，写在变量上面，并且由系统底层代理创建这个变量的实例，
 * 并注入到这个类中，就不用自己手动去创建对象了
 *
 * @Qulifier --匹配bean
 * 当有多个bean一样的时候，需要给@autowired表明需要注入的bean
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Override
    public String getUserName(int userId) {
        User user = userDao.findById(userId).get();
        return user.getName();
    }

    @Override
    public String getUserPhone(String name) {
        User user = userDao.findUserByName(name);
        return user.getPhone();
    }

    @Override
    public int saveUser(String name) {
        User user = new User();
        user.setName(name);
        user.setPhone("123123");
        user = userDao.save(user);
        return user.getId();
    }

    @Override
    public User getUser(String phone) {
        return userDao.findUserByPhone2(phone);
    }
}
