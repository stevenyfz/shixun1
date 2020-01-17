package study.homework2.service;

import study.homework2.pojo.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findById(Integer id);

    void insert(User user);

    void delete(User user);
}
