package com.atguigu.sms;

import com.atguigu.srb.sms.util.SmsProperties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Stack;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UtilsTests {
    @Test
    public void testProperties(){
        System.out.println(SmsProperties.KEY_ID);
        System.out.println(SmsProperties.KEY_SECRET);
        System.out.println(SmsProperties.REGION_Id);
    }

    @Test
    public int calPoints(String[] ops) {
            Stack<Integer> stack = new Stack<Integer>();
            int total = 0;
            for(String op:ops){
                switch(op){
                    case "+":
                        int a = stack.pop();
                        int b = stack.peek();
                        int c = a+b;
                        stack.push(a);
                        stack.push(c);
                        total += c;
                    case "D":
                        int d = stack.peek();
                        int e = d*2;
                        stack.push(e);
                        total += e;
                    case "C":
                        int f = stack.pop();
                        total = total - f;
                    default:
                        int score = Integer.parseInt(op);
                        total += score;
                        stack.push(score);
                        break;

                }


            }
            return total;

        }
    }
