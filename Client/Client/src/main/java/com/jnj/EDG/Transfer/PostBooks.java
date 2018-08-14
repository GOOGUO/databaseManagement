package com.jnj.EDG.Transfer;

import org.jboss.logging.Logger;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;


public class PostBooks {
    private static Logger logger = Logger.getLogger(PostBooks.class);

    public Object postBooks(MultiValueMap<String, Object> bookMap) {
        Object result = null;
        try {
            RestTemplate rest = new RestTemplate();
            result = rest.postForObject("http://localhost:8080/books/add", bookMap, String.class);
        } catch (Exception e) {
            logger.error("发送消息发生异常" + e);
            e.printStackTrace();
        }
        return result;
    }
}
