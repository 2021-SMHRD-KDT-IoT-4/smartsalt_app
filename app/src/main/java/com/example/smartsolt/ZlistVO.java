package com.example.smartsolt;

public class ZlistVO {

    private String tv_z_numbering;
    private String tv_z_name;
    private String tv_z_indoor_temp;
    private String btn_move_con;
    private String btn_move_sen;

    public ZlistVO(String tv_z_numbering, String tv_z_name, String tv_z_indoor_temp, String btn_move_con, String btn_move_sen) {
        this.tv_z_numbering = tv_z_numbering;
        this.tv_z_name = tv_z_name;
        this.tv_z_indoor_temp = tv_z_indoor_temp;
        this.btn_move_con = btn_move_con;
        this.btn_move_sen = btn_move_sen;
    }

    public String getTv_z_numbering() {
        return tv_z_numbering;
    }

    public void setTv_z_numbering(String tv_z_numbering) {
        this.tv_z_numbering = tv_z_numbering;
    }

    public String getTv_z_name() {
        return tv_z_name;
    }

    public void setTv_z_name(String tv_z_name) {
        this.tv_z_name = tv_z_name;
    }

    public String getTv_z_indoor_temp() {
        return tv_z_indoor_temp;
    }

    public void setTv_z_indoor_temp(String tv_z_indoor_temp) {
        this.tv_z_indoor_temp = tv_z_indoor_temp;
    }

    public String getBtn_move_con() {
        return btn_move_con;
    }

    public void setBtn_move_con(String btn_move_con) {
        this.btn_move_con = btn_move_con;
    }

    public String getBtn_move_sen() {
        return btn_move_sen;
    }

    public void setBtn_move_sen(String btn_move_sen) {
        this.btn_move_sen = btn_move_sen;
    }
}
