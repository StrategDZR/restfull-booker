package com.example.specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.ResponseSpecification;

public class ResponseSpecs {

    public static ResponseSpecification logResponse() {
        return new ResponseSpecBuilder()
                .log(LogDetail.ALL)
                .build();
    }
}