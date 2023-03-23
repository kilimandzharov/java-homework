package com.kirillmozharov.repository;

import com.kirillmozharov.model.Line;
import com.kirillmozharov.model.Station;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class MetroRepository {
    private HashMap<Line, ArrayList<Station>> linesMap = new HashMap<>();

    public MetroRepository(String source) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(source))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] vals = line.split(",");
                Line metroLine = new Line(vals[0], vals[1]);
                Station station = new Station(vals[2], Integer.parseInt(vals[3]), metroLine);
                ArrayList<Station> stationsArray = linesMap.getOrDefault(metroLine, new ArrayList<>());
                stationsArray.add(station);
                linesMap.put(metroLine, stationsArray);
            }
        }
    }


    /**
     * 2. maxTraffic
     * Реализовать метод, который возвращает станции с максимальным пассажиропотоком
     * @return
     */
    public ArrayList<Station> maxTraffic() {
        int maxTraffic = 0;
        ArrayList<Station> result = new ArrayList<>();
        for (Map.Entry<Line, ArrayList<Station>> lineArrayListEntry : this.linesMap.entrySet()) {
            ArrayList<Station> stations = lineArrayListEntry.getValue();
            for (Station station : stations) {
                if (station.getPeopleCount() > maxTraffic) {
                    maxTraffic = station.getPeopleCount();
                }
            }
        }

        for (Map.Entry<Line, ArrayList<Station>> lineArrayListEntry : this.linesMap.entrySet()) {
            ArrayList<Station> stations = lineArrayListEntry.getValue();
            for (Station station : stations) {
                if (station.getPeopleCount() == maxTraffic) {
                    result.add(station);
                }
            }
        }

        return result;
    }

    /**
     * 3. sumTraffic
     * Вычислить суммарный пассажиропоток каждой линии
     * @return
     */
    public HashMap<Line, Integer> sumTraffic() {
        HashMap<Line, Integer> result = new HashMap<>();
        int count = 0;
        for (Map.Entry<Line, ArrayList<Station>> lineArrayListEntry : this.linesMap.entrySet()) {
            ArrayList<Station> stations = lineArrayListEntry.getValue();
            for (Station station : stations) {
                count += station.getPeopleCount();
            }
            result.put(lineArrayListEntry.getKey(), count);
        }

        return result;
    }

    /**
     * 4. sortByStationName
     * Произвести сортировку коллекции по названию станции
     */
    public ArrayList<Station> sort() {
        ArrayList<Station> stations = new ArrayList<>();
        //TODO add data to list
        stations.sort(null);
        return stations;
    }

    public void save(String fileName) throws IOException {
        ArrayList<Station> sort = this.sort();
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))) {
            for (Station station : sort) {
                //TODO save to file
            }
        }
    }
}
