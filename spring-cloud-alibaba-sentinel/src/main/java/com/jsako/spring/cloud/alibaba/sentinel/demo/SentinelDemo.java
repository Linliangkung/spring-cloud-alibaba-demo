package com.jsako.spring.cloud.alibaba.sentinel.demo;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.context.ContextUtil;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityRule;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityRuleManager;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.alibaba.csp.sentinel.util.TimeUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: JsAko
 * @Email: 359270069@qq.com
 * @Date 2021/1/7 18:44
 * @Description:
 */
public class SentinelDemo {

    public static void main(String[] args) throws InterruptedException {
        initFlowRules();


        for(int i=0;i<10000;i++){
            new Thread(() -> {
                ContextUtil.enter("test", "App1");
                long startTime = TimeUtil.currentTimeMillis();
                Entry entry = null;
                try {
                    entry = SphU.entry("HelloWorld");
                    /*您的业务逻辑 - 开始*/

                    //  System.out.println("hello world");
                    /*您的业务逻辑 - 结束*/
                } catch (BlockException e) {
                    /*流控逻辑处理 - 开始*/
                    System.out.println("block!");
                    e.printStackTrace();
                    /*流控逻辑处理 - 结束*/
                } finally {
                    if (entry != null) {
                        entry.exit();
                        long cost = TimeUtil.currentTimeMillis() - startTime;
                        System.out.println(
                                TimeUtil.currentTimeMillis() + " one request pass, cost " + cost + " ms");
                    }
                }
            }
            ).start();
        }
    }

    private static void initFlowRules() {
        List<FlowRule> rules = new ArrayList<>();
        FlowRule rule = new FlowRule();
        rule.setResource("HelloWorld");
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        rule.setControlBehavior(RuleConstant.CONTROL_BEHAVIOR_WARM_UP_RATE_LIMITER); // 流控效果：匀速排队模式
        rule.setCount(1000);
//        rule.setMaxQueueingTimeMs(20 * 1000);
        rules.add(rule);
        AuthorityRule rule1 = new AuthorityRule();
        rule1.setStrategy(RuleConstant.AUTHORITY_BLACK);
        rule1.setResource("HelloWorldxx");
        rule1.setLimitApp("App1");
        AuthorityRuleManager.loadRules(Collections.singletonList(rule1));
        FlowRuleManager.loadRules(rules);
    }


    private static void initFlowRules2() {
        List<FlowRule> rules = new ArrayList<>();
        FlowRule rule = new FlowRule();
        rule.setResource("HelloWorld");
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
//        rule.setControlBehavior(RuleConstant.CONTROL_BEHAVIOR_RATE_LIMITER); // 流控效果：匀速排队模式
        rule.setCount(10);
//        rule.setMaxQueueingTimeMs(20 * 1000);
        rules.add(rule);
        FlowRuleManager.loadRules(rules);
    }

}
