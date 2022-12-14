package cn.chen.springcloud.dao;

import org.apache.ibatis.annotations.Param;

public interface StorageDao {
    /**
     * 扣减库存
     */
    void decrease(@Param("productId") Long productId, @Param("count") Integer count);
}
