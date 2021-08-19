package com.example.smartsolt;

public class ZlistVO {

    // 수정불가
    // numbering은 결정지 or 증발지 확인해주는 ID
    private String z_numbering;
    private String z_place_size;
    private String z_pump_move;
    // 센서를 통한 현재 정보 입력
    private String z_salinity_now;
    private String z_wire_temp_now;
    private String z_indoor_temp_now;
    private String z_indoor_humid_now;
    private String z_water_temp_now;
    private String z_water_high_now;
    // 센서 설정값
    private String z_salinity_set;
    private String z_indoor_humid_set;
    private String z_water_temp_set;
    private String z_wire_temp_set;
    private String z_water_high_set;

    public ZlistVO(String z_numbering, String z_place_size, String z_pump_move, String z_salinity_now,
                   String z_wire_temp_now, String z_indoor_temp_now, String z_indoor_humid_now,
                   String z_water_temp_now, String z_water_high_now) {
        this.z_numbering = z_numbering;
        this.z_place_size = z_place_size;
        this.z_pump_move = z_pump_move;
        this.z_salinity_now = z_salinity_now;
        this.z_wire_temp_now = z_wire_temp_now;
        this.z_indoor_temp_now = z_indoor_temp_now;
        this.z_indoor_humid_now = z_indoor_humid_now;
        this.z_water_temp_now = z_water_temp_now;
        this.z_water_high_now = z_water_high_now;
    }

    public ZlistVO(String z_numbering, String z_pump_move, String z_salinity_now, String z_wire_temp_now,
                   String z_indoor_temp_now, String z_indoor_humid_now, String z_water_temp_now,
                   String z_water_high_now, String z_salinity_set, String z_indoor_humid_set,
                   String z_water_temp_set, String z_wire_temp_set, String z_water_high_set) {
        this.z_numbering = z_numbering;
        this.z_pump_move = z_pump_move;
        this.z_salinity_now = z_salinity_now;
        this.z_wire_temp_now = z_wire_temp_now;
        this.z_indoor_temp_now = z_indoor_temp_now;
        this.z_indoor_humid_now = z_indoor_humid_now;
        this.z_water_temp_now = z_water_temp_now;
        this.z_water_high_now = z_water_high_now;
        this.z_salinity_set = z_salinity_set;
        this.z_indoor_humid_set = z_indoor_humid_set;
        this.z_water_temp_set = z_water_temp_set;
        this.z_wire_temp_set = z_wire_temp_set;
        this.z_water_high_set = z_water_high_set;
    }

    public String getZ_numbering() {
        return z_numbering;
    }

    public void setZ_numbering(String z_numbering) {
        this.z_numbering = z_numbering;
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

    public String getZ_salinity_now() {
        return z_salinity_now;
    }

    public void setZ_salinity_now(String z_salinity_now) {
        this.z_salinity_now = z_salinity_now;
    }

    public String getZ_wire_temp_now() {
        return z_wire_temp_now;
    }

    public void setZ_wire_temp_now(String z_wire_temp_now) {
        this.z_wire_temp_now = z_wire_temp_now;
    }

    public String getZ_indoor_temp_now() {
        return z_indoor_temp_now;
    }

    public void setZ_indoor_temp_now(String z_indoor_temp_now) {
        this.z_indoor_temp_now = z_indoor_temp_now;
    }

    public String getZ_indoor_humid_now() {
        return z_indoor_humid_now;
    }

    public void setZ_indoor_humid_now(String z_indoor_humid_now) {
        this.z_indoor_humid_now = z_indoor_humid_now;
    }

    public String getZ_water_temp_now() {
        return z_water_temp_now;
    }

    public void setZ_water_temp_now(String z_water_temp_now) {
        this.z_water_temp_now = z_water_temp_now;
    }

    public String getZ_water_high_now() {
        return z_water_high_now;
    }

    public void setZ_water_high_now(String z_water_high_now) {
        this.z_water_high_now = z_water_high_now;
    }

    public String getZ_salinity_set() {
        return z_salinity_set;
    }

    public void setZ_salinity_set(String z_salinity_set) {
        this.z_salinity_set = z_salinity_set;
    }

    public String getZ_indoor_humid_set() {
        return z_indoor_humid_set;
    }

    public void setZ_indoor_humid_set(String z_indoor_humid_set) {
        this.z_indoor_humid_set = z_indoor_humid_set;
    }

    public String getZ_water_temp_set() {
        return z_water_temp_set;
    }

    public void setZ_water_temp_set(String z_water_temp_set) {
        this.z_water_temp_set = z_water_temp_set;
    }

    public String getZ_wire_temp_set() {
        return z_wire_temp_set;
    }

    public void setZ_wire_temp_set(String z_wire_temp_set) {
        this.z_wire_temp_set = z_wire_temp_set;
    }

    public String getZ_water_high_set() {
        return z_water_high_set;
    }

    public void setZ_water_high_set(String z_water_high_set) {
        this.z_water_high_set = z_water_high_set;
    }
}
