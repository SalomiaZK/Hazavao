package com.salomia.zk.service.model;

import lombok.Getter;


public record Message(
        String role,
        String content
) {}
