package cn.leancloud.xb.model;

import cn.leancloud.xb.utils.MessageUtil;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by stone on 2017/1/22.
 */
@XmlRootElement(name = "xml")
public class ResVoiceMsg extends Message {

    @XmlElement(name = "Voice")
    private Voice voice;

    public ResVoiceMsg() {
        setMsgType(MessageUtil.REQ_MESSAGE_TYPE_VOICE);

    }

    public Voice getVoice() {
        return voice;
    }

    public void setVoice(Voice voice) {
        this.voice = voice;
    }
}
