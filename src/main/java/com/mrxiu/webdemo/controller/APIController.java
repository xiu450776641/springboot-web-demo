package com.mrxiu.webdemo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mrxiu.webdemo.entity.Task;
import com.mrxiu.webdemo.entity.User;
import com.mrxiu.webdemo.mapper.TaskMapper;
import com.mrxiu.webdemo.mapper.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class APIController {

    private UserMapper userMapper;
    private TaskMapper taskMapper;

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    @ResponseBody
    public int saveOrUpdateUser(@RequestBody User user) {
        if ("".equals(user.getId()) && null != user.getId()) {
            return userMapper.updateById(user);
        }
        return userMapper.insert(user);
    }

    @RequestMapping(value = "/user/{userId}", method = RequestMethod.DELETE)
    public int deleteUser(@PathVariable Long userId) {
        return userMapper.deleteById(userId);
    }

    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
    public User getById(@PathVariable Long userId) {
        QueryWrapper wrapper = new QueryWrapper<User>();
        wrapper.eq("id", userId);
        return userMapper.selectOne(wrapper);
    }

    /**
     * Task
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/tasks", method = RequestMethod.PUT)
    public int saveOrUpdateTask(@RequestBody User user) {
        if ("".equals(user.getId()) && null != user.getId()) {
            return userMapper.updateById(user);
        }
        return userMapper.insert(user);
    }

    @RequestMapping(value = "/tasks/{taskId}", method = RequestMethod.DELETE)
    public int deleteTask(@PathVariable Long taskId) {
        return taskMapper.deleteById(taskId);
    }

    @RequestMapping(value = "/tasks", method = RequestMethod.GET)
    public List<Task> getTasks() {
        return taskMapper.selectList(new QueryWrapper<>());
    }

    @RequestMapping(value = "/tasks/{taskId}", method = RequestMethod.GET)
    public Task getTaskById(@PathVariable Long taskId) {
        QueryWrapper wrapper = new QueryWrapper<User>();
        wrapper.eq("id", taskId);
        return taskMapper.selectOne(wrapper);
    }

    @RequestMapping(value = "/tasks", method = RequestMethod.POST)
    public int saveTask(@RequestBody User user) {
        return userMapper.insert(user);
    }
}
