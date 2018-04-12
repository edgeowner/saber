package com.demo.saber.web.controller.price;

import com.demo.saber.application.PriceApplication;
import com.demo.saber.application.vo.PriceVO;
import com.demo.saber.exceptions.BizException;
import com.demo.saber.infrastructure.mapper.PriceMapper;
import com.demo.saber.infrastructure.po.Price;
import com.demo.saber.utils.ThreadPool;
import com.demo.saber.utils.ThreadPoolConfig;
import com.demo.saber.web.webutils.WebUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/price")
public class PriceController {

    @Autowired
    private PriceApplication priceApplication;

    @Autowired
    private PriceMapper priceMapper;
    @Autowired
    private ThreadPoolConfig config;


    /**
     * 多线程并发执行Demo ,无锁场景下的更新
     *
     * @param priceVO
     * @return message
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> updatePrice(@RequestBody PriceVO priceVO) {

        try {
            if (priceVO == null) {
                throw new BizException(BizException.NUM_VALIDATION, "priceVO is null");
            }

            for (int i = 0; i < 10; i++) {
                final int count = i;
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        toUpdatePrice(count);
                    }
                });
                config.submit(thread);
            }
            return WebUtil.success("price更新成功");
        } catch (BizException ex) {
            log.error("更新价格失败", ExceptionUtils.getFullStackTrace(ex));
            return WebUtil.error(ex.getErrorMessage());
        }

    }


    private void toUpdatePrice(int count) {
        log.info(MessageFormat.format("thread create start:{0} ", count));
        Price price = priceMapper.selectByPrimaryKey(1);
        int ron = 10;
        price.setFront(price.getFront().subtract(new BigDecimal(ron)));
        price.setEnd(price.getEnd().add(new BigDecimal(ron)));
        priceMapper.updateByPrimaryKey(price);
        price.setId(null);
        priceMapper.insertSelective(price);
        log.info(MessageFormat.format("thread create end:{0} ", count));
    }
}
