package com.etc.test.entity;

import jakarta.annotation.sql.DataSourceDefinition;
import lombok.Data;

@Data
public class User {
    private Integer userId;
    private String userName="admin";
    private String password="admin";
}
