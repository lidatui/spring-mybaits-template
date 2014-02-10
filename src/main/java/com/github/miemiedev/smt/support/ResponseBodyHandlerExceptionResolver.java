package com.github.miemiedev.smt.support;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.AbstractHandlerMethodExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 *凡是方法标识@ResponseBody的遇到异常都返回为JSON格式
 */
public class ResponseBodyHandlerExceptionResolver extends AbstractHandlerMethodExceptionResolver {

    private HttpMessageConverter messageConverter;

    @Override
    protected ModelAndView doResolveHandlerMethodException(HttpServletRequest request, HttpServletResponse response, HandlerMethod handlerMethod, Exception ex) {
        logger.error(request.getRequestURI(),ex);
        if(handlerMethod.getMethodAnnotation(ResponseBody.class) != null){
            try {
                response.setStatus(500);
                return writeJson(request, response, new ErrorMessage(ex.getMessage()));
            } catch (IOException e) {
                logger.error(ex.getMessage(),e);
            }
        }
        return null;
    }

    private ModelAndView writeJson(HttpServletRequest request, HttpServletResponse response, Object value) throws IOException {
        HttpInputMessage inputMessage = new ServletServerHttpRequest(request);
        List<MediaType> acceptedMediaTypes = inputMessage.getHeaders().getAccept();
        if (acceptedMediaTypes.isEmpty()) {
            acceptedMediaTypes = Collections.singletonList(MediaType.ALL);
        }
        MediaType.sortByQualityValue(acceptedMediaTypes);
        HttpOutputMessage outputMessage = new ServletServerHttpResponse(response);
        Class<?> returnValueType = value.getClass();
        for (MediaType acceptedMediaType : acceptedMediaTypes) {
            if (messageConverter.canWrite(returnValueType, acceptedMediaType)) {
                messageConverter.write(value, acceptedMediaType, outputMessage);
                return new ModelAndView();
            }
        }
        return null;
    }

    public void setMessageConverter(HttpMessageConverter messageConverter) {
        this.messageConverter = messageConverter;
    }

}
