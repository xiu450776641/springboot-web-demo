package com.mrxiu.webdemo.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Task {
    private Long id;
    private String task;
    private String day;
    private String reminder;
}