package net.xjdsz.entity;

import java.util.Date;

/**
 * Created by dingshuo on 2016/12/28.
 */
public class Info {
    private Date TM;
    private String DESC;
    private Integer FLAG;

    public Date getTM() {
        return TM;
    }

    public void setTM(Date TM) {
        this.TM = TM;
    }

    public String getDESC() {
        return DESC;
    }

    public void setDESC(String DESC) {
        this.DESC = DESC;
    }

    public Integer getFLAG() {
        return FLAG;
    }

    public void setFLAG(Integer FLAG) {
        this.FLAG = FLAG;
    }

    @Override
    public String toString() {
        return "TM="+TM.toString()+",DESC="+DESC+",FALG="+FLAG;
    }
}
