package com.example.smartsolt;

public class SettingVO {

    private String id;
    private int z_place_size, k_place_size;
    private int z_numbering, k_numbering;

    public SettingVO(String id, int z_place_size, int k_place_size) {
        this.id = id;
        this.z_place_size = z_place_size;
        this.k_place_size = k_place_size;
    }
    public SettingVO(int z_numbering, int z_place_size,int k_numbering, int k_place_size) {
        this.z_numbering = z_numbering;
        this.z_place_size = z_place_size;
        this.k_numbering = k_numbering;
        this.k_place_size = k_place_size;
    }

    public int getZ_numbering() {
        return z_numbering;
    }

    public void setZ_numbering(int z_numbering) {
        this.z_numbering = z_numbering;
    }

    public int getK_numbering() {
        return k_numbering;
    }

    public void setK_numbering(int k_numbering) {
        this.k_numbering = k_numbering;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getZ_place_size() {
        return z_place_size;
    }

    public void setZ_place_size(int z_place_size) {
        this.z_place_size = z_place_size;
    }

    public int getK_place_size() {
        return k_place_size;
    }

    public void setK_place_size(int k_place_size) {
        this.k_place_size = k_place_size;
    }
}


