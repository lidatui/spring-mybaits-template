package com.github.miemiedev.smt.web;

import com.github.miemiedev.mybatis.paginator.PageQuery;
import com.github.miemiedev.mybatis.paginator.SortInfo;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 *
 */
public class BaseController {

    protected static final String sortExpression = "nlssort( ? ,'NLS_SORT=SCHINESE_PINYIN_M')";

    public PageQuery getPageQuery(){
        return getPageQuery(null);
    }

    public PageQuery getPageQuery(String defaultSort){
        Integer page = Integer.valueOf(getParameter("page", "1"));
        Integer limit =  Integer.valueOf(getParameter("limit", "15"));
        String sort = getParameter("sort", defaultSort);

        PageQuery pageQuery = new PageQuery(page, limit);

        List<SortInfo> sortInfos = getSortInfos(sort);
        pageQuery.getSortInfoList().addAll(sortInfos);

        return pageQuery;
    }

    protected String getParameter(String name){
        return getParameter(name,"");
    }

    protected List<SortInfo> getSortInfos(String sort){
        return SortInfo.parseSortColumns(sort);
    }

    protected String getParameter(String name, String defaultValue){
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes)ra).getRequest();
        String value = request.getParameter(name);
        if(value == null || value.equals("")){
            return defaultValue;
        }
        return value;
    }
}
