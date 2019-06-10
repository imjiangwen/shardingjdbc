package com.shardingjdbc.domain.test;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;




/**
 * 
 *
 * @author : code generator
 * @version : 1.0
 * @since : 2019-06-10
 */
@TableName("table_two")
public class TableTwo implements Serializable  {
  private static final long serialVersionUID = 1L;

      @TableId(value = "id")
  private String id;
    
  /** name -  */
  @TableField(value = "name")
  private String name;

  

    public String  getId  () {
        return this.id;
      }
  
    public String  getName  () {
    return name;
  }

  
    public void setId (String  id) {
        this.id = id;
      }

  
    public void setName (String  name) {
    this.name = name;
  }
  
  }