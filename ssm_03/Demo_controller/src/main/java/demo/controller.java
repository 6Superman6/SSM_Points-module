package demo;

import demo.mapper.UserMapper;
import demo.model.User;
import demo.service.UserService;
import demo.utils.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/user")
public class controller {

    @Autowired
    private UserService userService;

    // 添加数据
    @RequestMapping(path = "/add",method = RequestMethod.POST)
    public ServerResponse add(@Valid User user)
    {
        return userService.insert(user);
    }

    // 删除数据
    @RequestMapping(path = "/del/{id}",method = RequestMethod.DELETE)
    public ServerResponse del(@PathVariable("id") int id)
    {
        return userService.delete(id);
    }

    // 修改数据
    @RequestMapping(path = "/do",method = RequestMethod.POST)
    public ServerResponse update(@Valid User user)
    {
        return userService.update(user);
    }

    // 获取数据--通过编号
    @RequestMapping(path = "/do/{id}",method = RequestMethod.GET)
    public ServerResponse get(@PathVariable("id") int id)
    {
        return userService.get(id);
    }

    // 获取全部数据
    @RequestMapping(path = "/do",method = RequestMethod.GET)
    public ServerResponse findAll()
    {
        return userService.findAll();
    }

    // 获取数据--通过用户名
    @RequestMapping(path = "/name/{name}",method = RequestMethod.GET)
    public ServerResponse getByName(@PathVariable("name") String name)
    {
        return userService.getyName(name);
    }



}
