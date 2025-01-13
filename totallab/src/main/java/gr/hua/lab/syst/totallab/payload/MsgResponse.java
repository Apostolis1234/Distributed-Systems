package gr.hua.lab.syst.totallab.payload;

import org.springframework.data.web.ProjectedPayload;

@ProjectedPayload
public class MsgResponse {

    private String msg;

    public MsgResponse(String msg) {
        this.msg = msg;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
}
