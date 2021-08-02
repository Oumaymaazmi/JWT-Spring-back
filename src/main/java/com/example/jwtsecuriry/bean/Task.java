package com.example.jwtsecuriry.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class Task {
    @javax.persistence.Id @GeneratedValue
    private Long id;
    private String nom;


}
