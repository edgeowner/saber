package com.demo.saber.web.webutils;

import com.google.common.collect.Maps;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Map;

/**
 * Created by zhangsunny on 2017/1/4.
 */
public class WebUtil {

    public static final String DATA = "data";

    public static final String MESSAGE = "message";

    public static final String CODE = "status";

    public static final String VERSION = "version";


    public static ResponseEntity<Map<String, Object>> success() {
        Map result = Maps.newHashMap();
        Map data = Maps.newHashMap();
        data.put(MESSAGE, ResponseConstants.RES_SUCCESS_MSG);
        result.put(DATA, data);
        result.put(CODE, ResponseConstants.RES_SUCCESS);
        return new ResponseEntity(result, HttpStatus.OK);
    }

    public static ResponseEntity<Map<String, Object>> success(String msg) {
        Map result = Maps.newHashMap();
        Map data = Maps.newHashMap();
        data.put(MESSAGE, msg);
        result.put(DATA, data);
        result.put(CODE, ResponseConstants.RES_SUCCESS);
        return new ResponseEntity(result, HttpStatus.OK);
    }

    public static ResponseEntity<Map<String, Object>> success(String msg, String version) {
        Map result = Maps.newHashMap();
        Map data = Maps.newHashMap();
        data.put(MESSAGE, msg);
        data.put(VERSION, version);
        result.put(CODE, ResponseConstants.RES_SUCCESS);
        result.put(DATA, data);
        return new ResponseEntity(result, HttpStatus.OK);
    }

    public static ResponseEntity<Map<String, Object>> forbidden(String msg) {
        Map result = Maps.newHashMap();
        Map data = Maps.newHashMap();
        data.put(MESSAGE, msg);
        result.put(DATA, data);
        result.put(CODE, ResponseConstants.FORBIDDEN);
        return new ResponseEntity(result, HttpStatus.OK);
    }

    public static ResponseEntity<Map<String, Object>> result(Object object) {
        Map result = Maps.newHashMap();
        result.put(DATA, object);
        result.put(CODE, ResponseConstants.RES_SUCCESS);
        return new ResponseEntity(result, HttpStatus.OK);
    }

    public static ResponseEntity<Map<String, Object>> result(String msg, final String extendData, Object object) {
        Map result = Maps.newHashMap();
        Map data = Maps.newHashMap();
        data.put(extendData, object);
        data.put(MESSAGE, msg);
        result.put(DATA, data);
        result.put(CODE, ResponseConstants.RES_SUCCESS);
        return new ResponseEntity(result, HttpStatus.OK);
    }

    public static ResponseEntity<Map<String, Object>> error(String msg) {
        Map result = Maps.newHashMap();
        Map data = Maps.newHashMap();
        data.put(MESSAGE, msg);
        result.put(DATA, data);
        result.put(CODE, ResponseConstants.RES_FAIL);
        return new ResponseEntity(result, HttpStatus.OK);
    }

    public static ResponseEntity<Map<String, Object>> error(String msg, final String extentData, Object object) {
        Map result = Maps.newHashMap();
        Map data = Maps.newHashMap();
        data.put(MESSAGE, msg);
        data.put(extentData, object);
        result.put(DATA, data);
        result.put(CODE, ResponseConstants.RES_FAIL);
        return new ResponseEntity(result, HttpStatus.OK);
    }

    public static ResponseEntity<Map<String, Object>> error(Object object) {
        Map result = Maps.newHashMap();
        result.put(DATA, object);
        result.put(CODE, ResponseConstants.RES_FAIL);
        return new ResponseEntity(result, HttpStatus.OK);
    }


    public static ResponseEntity<Map<String, Object>> errorWithPop(String msg, String pop) {
        Map result = Maps.newHashMap();
        Map data = Maps.newHashMap();
        data.put("tips", pop);
        data.put(MESSAGE, msg);
        result.put(DATA, data);
        result.put(CODE, ResponseConstants.RES_FAIL);
        return new ResponseEntity(result, HttpStatus.OK);
    }

    /**
     * @description 返回弹窗
     */
    public static ResponseEntity<Map<String, Object>> resultTip(String tip) {
        Map result = Maps.newHashMap();
        Map data = Maps.newHashMap();
        data.put("tip", tip);
        result.put(DATA, data);
        result.put(CODE, ResponseConstants.RES_SUCCESS);
        return new ResponseEntity(result, HttpStatus.OK);
    }


    public static ResponseEntity<Map<String, Object>> successSpecial() {
        Map result = Maps.newHashMap();
        Map data = Maps.newHashMap();
        result.put(DATA, data);
        result.put(CODE, ResponseConstants.RES_SUCCESS);
        return new ResponseEntity(result, HttpStatus.OK);
    }

    public static ResponseEntity<Map<String, Object>> errorSpecial() {
        Map result = Maps.newHashMap();
        Map data = Maps.newHashMap();
        result.put(DATA, data);
        result.put(CODE, ResponseConstants.RES_FAIL);
        return new ResponseEntity(result, HttpStatus.OK);
    }
}
