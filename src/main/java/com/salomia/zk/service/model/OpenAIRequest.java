package com.salomia.zk.service.model;

import java.util.List;

public record OpenAIRequest(String model, List<Message> messages, double temperature) {}
