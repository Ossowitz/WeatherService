package ru.iooko.weatherservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Weather {

    @JsonProperty("location")
    private Location location;

    @JsonProperty("current")
    private Current current;

    @Data
    public static class Location {
        @JsonProperty("name")
        private String name;
    }

    @Data
    public static class Current {
        @JsonProperty("temp_c")
        private double temperature;

        @JsonProperty("condition")
        private Condition condition;

        @Data
        public static class Condition {
            @JsonProperty("text")
            private String text;
        }
    }
}
