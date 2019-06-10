package com.shardingjdbc.service.test;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

/**
 * AbstractMybatisService
 *
 * @author <a href="morse.jiang@foxmail.com">JiangWen</a>
 * @version 1.0.0, 2018/6/6 0006 10:23
 */
public abstract class AbstractMybatisService<M extends BaseMapper<T>, T> extends ServiceImpl<M, T> {



}
