package com.yun.beat.web.controller;

import com.yun.beat.biz.service.DemoService;
import com.yun.beat.dao.entity.UserDao;

import com.yun.beat.web.WebResponse;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/rest")
public class DemoController {

    private static Logger log = LoggerFactory.getLogger(DemoController.class);

    @Autowired
    private DemoService demoService;


    @ApiOperation(value="获取当前用户", notes="根据id获取当前用户",tags = "UserName",httpMethod = "GET")
    @RequestMapping(value="/test/{id}",method = RequestMethod.GET,produces = "application/json")
    public UserDao test(@PathVariable Integer id) {
        System.out.println(demoService.test( id).toString());
        return demoService.test(id);
    }



    @RequestMapping(value="/addUser",method = RequestMethod.POST,produces = "application/json")
    @ApiOperation(value="添加用户", notes="添加新的用户",tags = "UserName",httpMethod = "POST")
   /* @ApiImplicitParams({
            @ApiImplicitParam(name="id",value="用户id",required=true,dataType="Integer" ),
            @ApiImplicitParam(name="name",value="用户名称",required=true,dataType="String" ),
            @ApiImplicitParam(name="information",value="用户描述",required=true,dataType="String" )
    })*/
    @ApiResponses({
            @ApiResponse(code=200,message = "成功",response=WebResponse.class)
    })
    public WebResponse<Map<String,Object>> saveUser(@RequestBody UserDao userdao){
        demoService.saveUser(userdao);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("id",userdao.getId());
        WebResponse<Map<String,Object>> response=WebResponse.getSuccessResponse(map);
        return response;
    }

}
