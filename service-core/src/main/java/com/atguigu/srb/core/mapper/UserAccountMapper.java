package com.atguigu.srb.core.mapper;

import com.atguigu.srb.core.pojo.entity.UserAccount;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import feign.Param;

import java.math.BigDecimal;

/**
 * <p>
 * 用户账户 Mapper 接口
 * </p>
 *
 * @author Zcc
 * @since 2022-08-23
 */
public interface UserAccountMapper extends BaseMapper<UserAccount> {

    void updateAccount( @Param("bindCode")String bindCode,
                        @Param("amount")BigDecimal amount,
                        @Param("freezeAmount")BigDecimal freezeAmount);
}
