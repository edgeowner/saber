package com.demo.saber.web.controller.price;

import com.demo.saber.application.vo.PriceVersionVO;
import com.demo.saber.exceptions.BizException;
import com.demo.saber.infrastructure.mapper.PriceVersionMapper;
import com.demo.saber.infrastructure.po.PriceVersion;
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
@RequestMapping("/priceverion")
public class PriceVersionController {


    @Autowired
    private PriceVersionMapper priceVersionMapper;


    @Autowired
    private ThreadPoolConfig config;

    /**
     * 多线程并发执行Demo ,乐观锁场景下的更新
     *
     * @param priceVersionVO
     * @return message
     */
    @RequestMapping(value = "/threadPriceVersion", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> updatePrice(@RequestBody PriceVersionVO priceVersionVO) {

        try {
            if (priceVersionVO == null) {
                throw new BizException(BizException.NUM_VALIDATION, "priceVersionVO is null");
            }

            for (int i = 0; i < 10; i++) {
                final int count = i;
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        PriceVersion priceVersion = priceVersionMapper.selectByPrimaryKey(1);
                        int ron = 10;
                        //"本次消费=" + ron
                        log.info(MessageFormat.format("当前线程({0})本次消费={1}", count, ron));
                        priceVersion.setFront(new BigDecimal(ron));
                        int backflag = priceVersionMapper.updateByVersion(priceVersion);
                        if (backflag == 0) {
                            log.error(MessageFormat.format("当前线程({0})更新失败", count));
                        } else {
                            log.error(MessageFormat.format("当前线程({0})更新成功", count));
                        }

                    }
                });
                config.submit(thread);
            }
            return WebUtil.success("priceVersion更新成功");
        } catch (BizException ex) {
            log.error("更新priceVersion失败", ExceptionUtils.getFullStackTrace(ex));
            return WebUtil.error(ex.getErrorMessage());
        }

    }
}
