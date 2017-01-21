package cn.leancloud.xb.model;

import cn.leancloud.xb.utils.MessageUtil;
import com.thoughtworks.xstream.XStream;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.StringReader;

/**
 * @author Leo.yy   Created on 16/9/29.
 * @description
 * @see
 */

@XmlRootElement(name = "xml")
public class VoiceMsg extends Message {

    private static XStream xStream = null;

    public VoiceMsg() {
        setMsgType(MessageUtil.REQ_MESSAGE_TYPE_VOICE);

    }
    @XmlElement(name = "MediaId")
    private String mediaId;

    @XmlElement(name = "Format")
    private String format;

    @XmlElement(name = "Recognition")
    private String recognition;


    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getRecognition() {
        return recognition;
    }

    public void setRecognition(String recognition) {
        this.recognition = recognition;
    }

    @Override
    public String toXml() {
        initXstream();
        return xStream.toXML(this);
    }

    public static VoiceMsg fromXml(String xml) {
        initXstream();
        return (VoiceMsg) xStream.fromXML(new StringReader(xml));
    }

    private static void initXstream() {
        if (xStream != null) {
            return;
        }

        try {
            xStream = new XStream();
            xStream.alias("xml", VoiceMsg.class);
            xStream.aliasField("ToUserName", VoiceMsg.class, "toUserName");
            xStream.aliasField("FromUserName", VoiceMsg.class, "fromUserName");
            xStream.aliasField("CreateTime", VoiceMsg.class, "createTime");
            xStream.aliasField("MsgType", VoiceMsg.class, "msgType");
            xStream.aliasField("MediaId", VoiceMsg.class, "mediaId");
            xStream.aliasField("Format", VoiceMsg.class, "format");
            xStream.aliasField("Recognition", VoiceMsg.class, "recognition");
            xStream.aliasField("MsgId", VoiceMsg.class, "msgId");
        } catch (Throwable throwable) {
            xStream = null;
        }
    }

}
