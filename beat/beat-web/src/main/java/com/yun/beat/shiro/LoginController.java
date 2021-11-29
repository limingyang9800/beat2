package com.yun.beat.shiro;

import com.yun.beat.biz.service.LoginService;
import com.yun.beat.dao.entity.ShiroRole;
import com.yun.beat.dao.entity.ShiroUser;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author lmy
 * @date 2021/7/2 17:42
 */
@Slf4j
@RestController
@RequestMapping("/rest")
public class LoginController {

    @Autowired
    private LoginService loginService;
    /**
     * POST登录
     * @param
     * @return
     */
    @ApiOperation(value="获取当前用户", notes="根据id获取当前用户",tags = "shiro",httpMethod = "POST")
    @PostMapping(value = "/login")
    public String login(@RequestBody ShiroUser user) {
        // 添加用户认证信息
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        // 进行验证，这里可以捕获异常，然后返回对应信息
        SecurityUtils.getSubject().login(usernamePasswordToken);
        log.info("获取当前的用户信息{}",user);
        return "login ok!";
    }


    /**
     * 添加用户
     * @param user
     * @return
     */
    @ApiOperation(value="增加用户", notes="增加用户",tags = "shiro",httpMethod = "POST")
    @PostMapping(value = "/addUser")
    public void addUser(@RequestBody ShiroUser user) {
        user = loginService.addUser(user);
        log.info("添加用户成功{}",user);
    }

    /**
     * 添加角色
     * @param role
     * @return
     */
    @ApiOperation(value="增加角色", notes="增加角色",tags = "shiro",httpMethod = "POST")
    @PostMapping(value = "/addRole")
    public void addRole(@RequestBody ShiroRole role) {
        role = loginService.addRole(role);
        log.info("添加角色成功{}",role);
    }

    /**
     * 注解的使用
     * @return
     */
    @ApiOperation(value="创建", notes="创建",tags = "shiro")
    @RequiresRoles("admin")
    @RequiresPermissions("create")
    @GetMapping(value = "/create")
    public String create() {
        return "Create success!";
    }

    @ApiOperation(value="首页", notes="首页",tags = "shiro")
    @GetMapping(value = "/index")
    public String index() {
        return "index page!";
    }

    @ApiOperation(value="错误", notes="错误",tags = "shiro")
    @GetMapping(value = "/error")
    public String error() {
        return "error page!";
    }


    /**
     * 退出的时候是get请求，主要是用于退出
     * @return
     */
    @ApiOperation(value="退出首页", notes="退出首页",tags = "shiro")
    @GetMapping(value = "/logino")
    public String login() {
        return "login";
    }

    @ApiOperation(value="注销退出", notes="注销退出",tags = "shiro")
    @GetMapping(value = "/logout")
    public String logout() {
        return "logout";
    }
}
