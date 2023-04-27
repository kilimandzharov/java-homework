package com.kirillmozharov.model;

public interface Figure extends CsvInstance {
    double square();
    double perimeter();
    String getName();
}
