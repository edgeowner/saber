package com.demo.saber.utils;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.util.*;

/**
 * @author zhangsunny
 */
public class BAAuthUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(BAAuthUtil.class);
    private static final String HMAC_SHA1_ALGORITHM = "HmacSHA1";

    public Map<String, String> getBasicAuthHeader(String method, String uri, String appKey, String appSecret) {
        Map<String, String> header = new HashMap<String, String>();
        String date = getAuthDate(new Date());
        String encryptStr = String.format("%s %s%n%s", method, uri, date);

        String sign = getSignature(appSecret, encryptStr);

        header.put("Date", date);
        header.put("Authorization", String.format("%s %s:%s", "MWS", appKey, sign));
        return header;
    }

    public static String getAuthorization(String method, String uri, String date, String clientId, String secret) {
        String stringToSign = method + " " + uri + "\n" + date;
        String signature = getSignature(stringToSign, secret);
        String authorization = "MWS" + " " + clientId + ":" + signature;
        return authorization;
    }
    public static String getSignature(String data, String secret) {
        String result;
        try {
            SecretKeySpec signingKey = new SecretKeySpec(secret.getBytes(), HMAC_SHA1_ALGORITHM);
            Mac mac = Mac.getInstance(HMAC_SHA1_ALGORITHM);
            mac.init(signingKey);
            byte[] rawHmac = mac.doFinal(data.getBytes());
            result = Base64.encodeBase64String(rawHmac);
        } catch (Exception e) {
            LOGGER.error(ExceptionUtils.getFullStackTrace(e));
            throw new RuntimeException("Failed to generate HMAC : " + e.getMessage());
        }
        return result;
    }

    public static String getAuthDate(Date date) {
        return DateFormatUtils.format(date, "EEE, dd MMM yyyy HH:mm:ss z", TimeZone.getTimeZone("GMT"), Locale.ENGLISH);
    }
}
