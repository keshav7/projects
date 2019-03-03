package com.projects.lc.server.wrapper.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HotelBookingTime {
    int time;
    Boolean arrival; // false if departure type
}
