package com.mbyte.easy.borrow.service.impl;

import com.mbyte.easy.borrow.entity.Borrow;
import com.mbyte.easy.borrow.mapper.BorrowMapper;
import com.mbyte.easy.borrow.service.IBorrowService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 历史借阅记录表 服务实现类
 * </p>
 *
 * @author 会写代码的怪叔叔
 * @since 2019-07-31
 */
@Service
public class BorrowServiceImpl extends ServiceImpl<BorrowMapper, Borrow> implements IBorrowService {

}
