package com.up.study.message.board.framework.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.up.study.message.board.config.AppProperties;
import com.up.study.message.board.framework.util.SpringContextHolder;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.autoconfigure.web.ServerProperties;

import java.io.IOException;

/**
 * 文件路径序列化器，在文件前面加上资源路径与域名
 *
 * @author fish_temp_author
 * @since fish_temp_since
 */
public class FileSerializer extends JsonSerializer<String> {

    @Override
    public void serialize(String value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        ServerProperties serverProperties = SpringContextHolder.getBean(ServerProperties.class);
        Integer port = serverProperties.getPort();
        String contextPath = serverProperties.getServlet().getContextPath();
        if (StringUtils.isNotBlank(value)) {
            gen.writeString("http://localhost:" + port + contextPath + "/" + value);
        }
    }
}
