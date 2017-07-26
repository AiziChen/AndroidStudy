package com.cnsunrun.androidstudy.alipay;

/**
 * Created by ZhouBin on 2017/7/25.
 * Effect: 支付宝的业务参数
 */

public class AlipayBean {


    private String subject;       //商品的标题/交易标题/订单标题/订单关键字
    private String out_trade_no; // 	商户网站唯一订单号
    private String total_amount;   //订单总金额，单位为元，精确到小数点后两位
    private String seller_id;       //收款支付宝用户ID

    public AlipayBean(String subject, String out_trade_no, String total_amount) {
        this.subject = subject;
        this.out_trade_no = out_trade_no;
        this.total_amount = total_amount;
    }

    public AlipayBean(String subject, String out_trade_no, String total_amount, String seller_id) {
        this.subject = subject;
        this.out_trade_no = out_trade_no;
        this.total_amount = total_amount;
        this.seller_id = seller_id;
    }

    public String getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(String seller_id) {
        this.seller_id = seller_id;
    }

    public String getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(String total_amount) {
        this.total_amount = total_amount;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }
}
