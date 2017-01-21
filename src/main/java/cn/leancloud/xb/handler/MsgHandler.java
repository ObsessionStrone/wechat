package cn.leancloud.xb.handler;

import cn.leancloud.xb.model.Message;

/**
 * @author Leo.yy   Created on 16/9/29.
 * @description
 * @see
 */
public interface MsgHandler {

    /**
     * 处理消息
     * @param from
     * @return
     */
    Message handle(Message from);

    boolean match(Message msg);
}
