package cn.leancloud.xb.handler;

import cn.leancloud.xb.model.Message;
import cn.leancloud.xb.model.TextMsg;
import cn.leancloud.xb.model.VoiceMsg;
import cn.leancloud.xb.talk.Robot;
import cn.leancloud.xb.talk.RobotCenter;
import cn.leancloud.xb.utils.MessageUtil;

import java.util.Date;

/**
 *
 */
public class VoiceMsgHandler implements MsgHandler {

    private Robot robot = new RobotCenter();

    @Override
    public Message handle(Message from) {
        VoiceMsg msg = new VoiceMsg();
        String ans = robot.talk(((VoiceMsg) from).getRecognition());
        System.out.println(ans);
        TextMsg res = new TextMsg();
        exchangeMsgName(msg,res);
        res.setContent(ans);
        return res;
    }

    @Override
    public boolean match(Message msg) {
        return MessageUtil.REQ_MESSAGE_TYPE_VOICE.equals(msg.getMsgType());
    }

    private void exchangeMsgName(Message from, Message to) {
        to.setFromUserName(from.getToUserName());
        to.setToUserName(from.getFromUserName());
        to.setCreateTime((new Date()).getTime());
    }


}
