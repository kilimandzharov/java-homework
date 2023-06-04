package com.kirillmozharov.repository;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.kirillmozharov.model.Galaxy;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GalaxyRepository {
    private Galaxy galaxy;
    public GalaxyRepository(String fileName) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        this.galaxy = xmlMapper.readValue(new File(fileName), Galaxy.class);
    }

    public void save(String fileName) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))) {
            bufferedWriter.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
            xmlMapper.writeValue(bufferedWriter, this.galaxy);
        }
    }
}
