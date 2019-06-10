package com.shardingjdbc.config.sharding;

import io.shardingsphere.api.algorithm.sharding.PreciseShardingValue;
import io.shardingsphere.api.algorithm.sharding.standard.PreciseShardingAlgorithm;

import java.util.Collection;

/**
 * 数据表分片规则
 *
 * @author Mos
 */
public class DataTablePreciseRule implements PreciseShardingAlgorithm<String> {

  @Override
  public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<String> shardingValue) {
    for (String name : availableTargetNames) {
      int index = (Math.abs(shardingValue.getValue().hashCode()) % 2) + 1;
      if (name.lastIndexOf(index + "") > -1) {
        return name;
      }
    }
    throw new RuntimeException("not found table");
  }
}
