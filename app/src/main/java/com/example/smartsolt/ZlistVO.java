package com.example.smartsolt;

public class ZlistVO {

    private String tv_z_numbering;
    private String z_salinity;
    private String tv_z_indoor_temp;
    private String z_indoor_humid;
    private String z_water_temp;
    private String z_wire_temp;
    private String z_water_high;
    private String z_place_size;
    private String z_pump_move;

    public ZlistVO(String tv_z_numbering, String tv_z_indoor_temp, String z_salinity, String z_indoor_humid, String z_water_temp, String z_wire_temp, String z_water_high, String z_place_size, String z_pump_move) {
        this.tv_z_numbering = tv_z_numbering;
        this.tv_z_indoor_temp = tv_z_indoor_temp;
        this.z_salinity = z_salinity;
        this.z_indoor_humid = z_indoor_humid;
        this.z_water_temp = z_water_temp;
        this.z_wire_temp = z_wire_temp;
        this.z_water_high = z_water_high;
        this.z_place_size = z_place_size;
        this.z_pump_move = z_pump_move;
    }

    public String getTv_z_numbering() {
        return tv_z_numbering;
    }

    public void setTv_z_numbering(String tv_z_numbering) {
        this.tv_z_numbering = tv_z_numbering;
    }



    public String getTv_z_indoor_temp() {
        return tv_z_indoor_temp;
    }

    public void setTv_z_indoor_temp(String tv_z_indoor_temp) {
        this.tv_z_indoor_temp = tv_z_indoor_temp;
    }




    public String getZ_salinity() {
        return z_salinity;
    }

    public void setZ_salinity(String z_salinity) {
        this.z_salinity = z_salinity;
    }

    public String getZ_indoor_humid() {
        return z_indoor_humid;
    }

    public void setZ_indoor_humid(String z_indoor_humid) {
        this.z_indoor_humid = z_indoor_humid;
    }

    public String getZ_water_temp() {
        return z_water_temp;
    }

    public void setZ_water_temp(String z_water_temp) {
        this.z_water_temp = z_water_temp;
    }

    public String getZ_wire_temp() {
        return z_wire_temp;
    }

    public void setZ_wire_temp(String z_wire_temp) {
        this.z_wire_temp = z_wire_temp;
    }

    public String getZ_water_high() {
        return z_water_high;
    }

    public void setZ_water_high(String z_water_high) {
        this.z_water_high = z_water_high;
    }

    public String getZ_place_size() {
        return z_place_size;
    }

    public void setZ_place_size(String z_place_size) {
        this.z_place_size = z_place_size;
    }

    public String getZ_pump_move() {
        return z_pump_move;
    }

    public void setZ_pump_move(String z_pump_move) {
        this.z_pump_move = z_pump_move;
    }
}
