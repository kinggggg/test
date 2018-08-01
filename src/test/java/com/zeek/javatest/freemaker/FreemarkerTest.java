package com.zeek.javatest.freemaker;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: weibo_li
 * @since: 2018-08-01 下午2:11
 */
public class FreemarkerTest {

    Configuration cfg = null;

    @Before
    public void setUp() throws Exception {
        cfg = new Configuration(Configuration.VERSION_2_3_28);
        cfg.setDirectoryForTemplateLoading(new File("/Users/weibo_li/Documents/code/Test/src/test/resources/freemarker"));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
    }

    @Test
    public void test01() throws Exception {

        Map<String, Object> root = new HashMap();
        root.put("hello", "Big Joe");

        FreemarkerPerson person = new FreemarkerPerson("zhangsan", 12);
        FreemarkerStudent student = new FreemarkerStudent("北京", new Date());
        person.setStudent(student);
        root.put("person", person);

        FreemarkerPerson person1 = new FreemarkerPerson("lisi", 20);
        person.setStudent(student);
//        root.put("person1", person1);

        Template temp = cfg.getTemplate("hello.ftl");

        Writer out = new OutputStreamWriter(System.out);
        temp.process(root, out);

    }
}
