package com.kirillmozharov.repository;

import com.kirillmozharov.model.Line;
import com.kirillmozharov.model.Station;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class MetroRepository {
    HashMap<Line, ArrayList<Station>> linesMap;

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

    public void save() throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"))) {
            for (Map.Entry<Line, ArrayList<Station>> lineArrayListEntry : this.linesMap.entrySet()) {
                for (Station station : lineArrayListEntry.getValue()) {
                    bufferedWriter.write(station.toCSV());
                }
            }
        }
    }

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

    public void sortByStationName() {
        for (Map.Entry<Line, ArrayList<Station>> lineArrayListEntry : this.linesMap.entrySet()) {
            ArrayList<Station> stations = lineArrayListEntry.getValue();
            stations.sort(null);
        }
    }
}
