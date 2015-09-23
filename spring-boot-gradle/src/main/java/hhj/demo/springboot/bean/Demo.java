package hhj.demo.springboot.bean;

import java.util.Date;

/**
 * demo
 * 
 * @author huanghaijun
 * @version 1.0
 * @since 2015-07-17
 */
public class Demo extends BaseModel {

    private Integer id;
    private String title;
    private Date addtime;
    private String info;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }
}