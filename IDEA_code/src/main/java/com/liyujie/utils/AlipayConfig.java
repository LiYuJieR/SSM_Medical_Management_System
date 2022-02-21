package com.liyujie.utils;

import com.alipay.api.AlipayClient;

public class AlipayConfig {

//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2021000119615103";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEuwIBADANBgkqhkiG9w0BAQEFAASCBKUwggShAgEAAoIBAQDCSYpy/8ImH8E9ItfP7VszDdyBcE9NDCGUe9WPRbFwlKp9FV5rSxXyMuOuINUx2a9ED5ZHWzRPaOuHnP936qACVJo8lIdyJ6mXn8p6HjXxBAUC41QEB+2p9gjxwm9YXYRPyPM4UibkYOrBIiS0w7uqj69DMoedLCqhVj/E2hQxd3YCkD26gAV8/V6xGEtxhZL699tGFiCR/35vyLPUOLnj3rX7GqbL2De7rizfILCcMFOXN0Ug8JP9nEXhXrCINODUHOmRJNOPP6UfM/9sMVufSMIGqjS6QniQcSboYjP0eB+9DaFKuSl1trQfxo4RYIFi5TEc5iFHZ/UyxeHLFwcBAgMBAAECgf8tiQ7p5Qeb59VifsgV84tsa9NCgxAS/sTgCCYFblAoEq/ioR+ABhkeqs6yAP/2rw5k5UJTdwzLj8uj/Sfi8xqNcUa07BrSpnkZEFpkRLBfzJFgG+eVCkapjwCJqQhvrXtVN8PJb3euDwj2OwpfU4CoeQSauz0NmUxkg9JuUK5q6SwYRueszfJzHwbRA/gvxzB/7BL1C2Fn4OG3+sBcZ2EgpW0FPw2quy4yeG5BR4yQQrXvXsD5zI+5YSvP3Ch5asZjJn3LmN7vH2mkVptkfcm1Q0+lvZM4Em1UIdqe7oB+6PC8KpjyRUScwvRQVapbE7/HO2OSlRPG+zKb3DiehbECgYEA6Z5VRR4M20ODoFzcYsaby4L5/jYUvw6HWjtgHqcqdAGgT2HXkySX4A3nNcZiWuuorDgk64Bb62ck0fydYKLbbfJ9SH60VlTtgyVMQXaDY74ZCftOXNhZUUs5+RnfEk5NXTRXuuLxKzwYNosyazlpkckNUE4J9mqi5rgLxHx6OJsCgYEA1OaUkmp9T4pAPphSJ84fpCZy4dgIeTFMP4YRPmPcLkiI1vRCwvT4ddnu9ABhTdN5rxHtRxWwO7BRf+BbCjP2QIQTWMVC+vYU64OAR6QxdwdekgbfKR8mZY+hEP5cNSitKnLr8rlpNjD1rDE2W6GYnya5TE77hzHafylpxe2S8pMCgYAArzYQvcXL3qbEEYGTyIEsV3XkCMSGysQav5HIhTTaoiaWFPNMuw622VOUFMC1A3u7BW8WQYoDZon1E4higBeketFjJPviRN1tRO60QmSgJi5smQ/htcCNPGsvD6RXqWMQotae9Ys/VS28+ytqpQBqLOydD51321ge1Osz6ClzgQKBgEKHy+X1YTN6AJmPAB1wTHL/kOcCm6NDxJAVVU4p5qSQBjMmIbbK1tn9QK7/b2jirSQIdh3AqVH9x3ouokSN+GYw39rdyhCi1ebDMVMx/EM2CleXziULlvQl7i9hTW9PRs39G76+MiK9KgilWFdKKGeTslQmWnPlIGKcjnFLzKABAoGBAL+MzpcqyEPi4+0qZSOGEa+B2iLYtg9L7J88zBtr2ZR3F1LovAjbSLoFqrU5uB6izH3IfYhdVlzNjjbqF3tu0qtNCNdWOAfUDAniWIj9tX1OvTONU/MeypTa0Vi5D7MjgG/nCCx/iREA3Rb2PQX7BxCRBwdg95V5VJRHfbS26uv3";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA4ESuERjlcWN4F5aPV2nZPCVuzzkw5rY/zhyMyY136q8mt8u5ccDa8NL5EMJxgxcMH5oB06eZrU36Ikgq/B2VqgwSCfR0OECUBSdhG9xwp9qG5CVlX3y8kmZdvKrBGDhj4fagZTiYJWB6jGat3JmoNIRdsNowj/tmOhtsh0584PTwgUASCSMDI5a6vf6Yhn7QW1Wia/KTZFTJIlPxTfQaQ8Jj9aE1JQCW+qrqGaEarz47rEy3IebczuLzmakYae6JdShLPfZU1+6zZrNTcI4aScN4TGHKh4WRzR4d1spXx+NNn+qKZQxCWhiQJ77jrWgdyE9EYQSRlpJnfsLGry0bHwIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://localhost:8080/SSM_MedicalSystem_Web_exploded/alipay/notify_url.jsp";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://localhost:8080/SSM_MedicalSystem_Web_exploded/alipay/return_url.jsp";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "D:\\JAVAprojects\\alipay_trade\\";
}
