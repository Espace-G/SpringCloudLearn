package cn.chen.springcloud.dao;


import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

public interface AccountDao {

    void decrease(@Param("userId") Long userId, @Param("money") BigDecimal money);
}
