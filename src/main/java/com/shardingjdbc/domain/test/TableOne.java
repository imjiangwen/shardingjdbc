package com.shardingjdbc.domain.test;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;




/**
 * 表1
 *
 * @author : code generator
 * @version : 1.0
 * @since : 2019-06-10
 */
@TableName("table_one")
public class TableOne implements Serializable  {
  private static final long serialVersionUID = 1L;

      @TableId(value = "id")
  private String id;
    
  /** phone - 手机号 */
  @TableField(value = "phone")
  private String phone;

  

    public String  getId  () {
        return this.id;
      }
  
    public String  getPhone  () {
    return phone;
  }

  
    public void setId (String  id) {
        this.id = id;
      }

  
    public void setPhone (String  phone) {
    this.phone = phone;
  }
  
  }