package com.atguigu.srb.core.service;

import com.atguigu.srb.core.pojo.entity.LendItem;
import com.atguigu.srb.core.pojo.vo.InvestVO;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 标的出借记录表 服务类
 * </p>
 *
 * @author Zcc
 * @since 2022-08-23
 */
public interface LendItemService extends IService<LendItem> {

    List<LendItem> selectByLendId(Long lendId, Integer status);


    List<LendItem> selectByLendId(Long lendId);

    String commitInvest(InvestVO investVO);

    @Transactional(rollbackFor = Exception.class)
    void notify(Map<String, Object> paramMap);
}
