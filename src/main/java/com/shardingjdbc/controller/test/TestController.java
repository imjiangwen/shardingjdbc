package com.shardingjdbc.controller.test;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.shardingjdbc.domain.test.TableOne;
import com.shardingjdbc.domain.test.TableTwo;
import com.shardingjdbc.service.test.TableOneService;
import com.shardingjdbc.service.test.TableTwoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * TableOneService
 *
 * @author : code generator
 * @version : 1.0
 * @since : 2019-06-10
 */
@Controller
@RequestMapping
public class TestController {

  @Autowired
  private TableOneService tableOneService;
  @Autowired
  private TableTwoService tableTwoService;


  /**
   * 测试分库分表
   * @return
   */
  @ResponseBody
  @GetMapping("test1")
  @Transactional(rollbackFor = Exception.class)
  public Object test1() {
    for (int i = 1; i <= 5; i++) {
      TableOne tableOne = new TableOne();
      tableOne.setPhone("phone");
      tableOneService.insert(tableOne);
    }
    return "ok";
  }

  /**
   * 只测试分库
   * @return
   */
  @ResponseBody
  @GetMapping("test2")
  @Transactional(rollbackFor = Exception.class)
  public Object test2() {
    for (int i = 1; i <= 5; i++) {
      TableTwo tableTwo = new TableTwo();
      tableTwo.setName("name");
      tableTwoService.insert(tableTwo);
    }
    return "ok";
  }

  /**
   * 测试查询 - 分页，排序
   *
   * @return
   */
  @ResponseBody
  @GetMapping("test3")
  public Object test3() {
    EntityWrapper<TableOne> ew = new EntityWrapper<>();
    ew.orderBy("id");
    Page<TableOne> page = new Page<>();
    return tableOneService.selectPage(page, ew);
  }

  /**
   * 测试修改
   *
   * @return
   */
  @ResponseBody
  @GetMapping("test4")
  @Transactional(rollbackFor = Exception.class)
  public Object test4() {
    TableOne tableOne = tableOneService.selectById("04a2f7856ecc45fc8e383480186b8959");
    tableOne.setPhone(System.currentTimeMillis() + "");
    tableOneService.updateById(tableOne);
    return tableOne;
  }

}
