package com.huang.aop.config;

import com.huang.aop.annoation.Test;
import com.huang.base.Base;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.DefaultParameterNameDiscoverer;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author huang
 * @Classname TestConfig
 * @Description TODO
 * @Date 2019/8/20 20:13
 * @Created by huang
 */
@Component("huanggeTest")
@Aspect
public class TestConfig extends Base {

    /**
     * SpEL
     */
    private SpelExpressionParser spelExpressionParser = new SpelExpressionParser();

    private DefaultParameterNameDiscoverer defaultParameterNameDiscoverer = new DefaultParameterNameDiscoverer();

    @Autowired
    private Huangge huangge;

    /**
     * SpEL表达式缓存Key生成器.
     * 注解中传入key参数，则使用此生成器生成缓存.
     *
     * @param spELString
     * @param joinPoint
     * @return
     */
    private String generateKeyBySpEL(String spELString, ProceedingJoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        String[] paramNames = defaultParameterNameDiscoverer.getParameterNames(methodSignature.getMethod());
        Expression expression = spelExpressionParser.parseExpression(spELString);
        EvaluationContext context = new StandardEvaluationContext(huangge);
        Object[] args = joinPoint.getArgs();
        for(int i = 0 ; i < args.length ; i++) {
            context.setVariable(paramNames[i], args[i]);
        }
        return expression.getValue(context).toString();
    }

    @Around("@annotation(test)")
    public Object around(ProceedingJoinPoint joinPoint, Test test){
        String val = test.value();
        //val = generateKeyBySpEL(val,joinPoint);

        String regex = "(?<=\\()(.+?)(?=\\))";
        Pattern pattern = Pattern.compile (regex);
        Matcher matcher = pattern.matcher (val);
        while (matcher.find ()) {
            //System.out.println (matcher.group ());
           String id = generateKeyBySpEL(matcher.group (), joinPoint);
        }

        return  null;
    }

    public static void main(String[] args) {
        String regex = "(?<=\\()(.+?)(?=\\))";
        Pattern pattern = Pattern.compile (regex);
        Matcher matcher = pattern.matcher ("test('123123','123wrwr')");
        while (matcher.find ()) {
            //System.out.println (matcher.group ());
            String[] arr = matcher.group ().split(",");
            for (String s : arr) {
                System.out.println(s);
            }
            System.out.println();
        }
        regex = ".+(?=\\()";
        pattern = Pattern.compile (regex);
        matcher = pattern.matcher("testqwqqeqweqwe('123123','123wrwr')");
        while (matcher.find ()) {
            //System.out.println (matcher.group ());
           // String[] arr = matcher.group ().split(",");
           // for (String s : arr) {
           //     System.out.println(s);
          //  }
            System.out.println(matcher.group ());
        }
    }

}
