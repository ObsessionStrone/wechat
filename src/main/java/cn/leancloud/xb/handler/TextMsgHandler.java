package cn.leancloud.xb.handler;

import cn.leancloud.xb.model.Message;
import cn.leancloud.xb.model.TextMsg;
import cn.leancloud.xb.talk.Robot;
import cn.leancloud.xb.talk.RobotCenter;
import cn.leancloud.xb.utils.MessageUtil;

/**
 * @author Leo.yy   Created on 16/9/29.
 * @description
 * @see
 */
public class TextMsgHandler implements MsgHandler {

    private Robot robot = new RobotCenter();

    @Override
    public Message handle(Message from) {
        TextMsg msg = new TextMsg();
        String ans = robot.talk(((TextMsg) from).getContent());
        System.out.println(ans);
        msg.setContent(ans);
        return msg;
    }

    @Override
    public boolean match(Message msg) {
        return MessageUtil.REQ_MESSAGE_TYPE_TEXT.equals(msg.getMsgType());
    }


}
