package com.example.projectmanagemnt.models;

import lombok.Data;

@Data
public class File {
    private long id;
    private String name;
    private String size;
    private String path;
    private long item_id;
    private String item_type;
}
