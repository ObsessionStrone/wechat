package cn.leancloud.xb.handler;

import cn.leancloud.xb.model.Message;
import cn.leancloud.xb.model.TextMsg;
import cn.leancloud.xb.utils.MessageUtil;

/**
 * @author Leo.yy   Created on 16/9/29.
 * @description
 * @see
 */
public class NotSupportMsgHandler implements MsgHandler {

    @Override
    public Message handle(Message from) {
        TextMsg msg = new TextMsg();
        msg.setContent("暂时只支持文字和语音消息哦");

        return msg;
    }

    @Override
    public boolean match(Message msg) {
        return !MessageUtil.REQ_MESSAGE_TYPE_TEXT.equals(msg.getMsgType())
                && !MessageUtil.REQ_MESSAGE_TYPE_VOICE.equals(msg.getMsgType());
    }
}
