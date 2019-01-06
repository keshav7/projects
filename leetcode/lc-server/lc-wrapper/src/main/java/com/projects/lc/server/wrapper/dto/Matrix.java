package com.projects.lc.server.wrapper.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Matrix {

    private Integer start;
    private Integer end;

    @Override
    public int hashCode()
    {
        String str = start.toString() + end.toString();
        return str.hashCode();
    }

    @Override
    public boolean equals(Object o)
    {
        String str = start.toString() + end.toString();
        return str.equals(o);
    }

}
