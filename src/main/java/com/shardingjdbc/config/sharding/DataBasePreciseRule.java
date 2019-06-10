package com.shardingjdbc.config.sharding;

import io.shardingsphere.api.algorithm.sharding.PreciseShardingValue;
import io.shardingsphere.api.algorithm.sharding.standard.PreciseShardingAlgorithm;

import java.util.Collection;
import java.util.Random;

/**
 * 数据库分片规则
 *
 * @author Mos
 */
public class DataBasePreciseRule implements PreciseShardingAlgorithm<String> {

  private static Random random = new Random();

  @Override
  public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<String> shardingValue) {
    int size = availableTargetNames.size();
    int index = random.nextInt(size) + 1;
    int temp = 1;
    for (String tableName : availableTargetNames) {
      if (temp == index) {
        return tableName;
      }
      temp++;
    }
    throw new IllegalArgumentException();
  }
}
