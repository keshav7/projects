package com.projects.airline.server.core.repository.impl;

import com.google.common.collect.ImmutableMap;
import com.projects.airline.server.core.domain.Flight;
import com.projects.airline.server.core.exception.AirlineException;
import com.projects.airline.server.core.repository.FlightRepositoryCustom;
import com.projects.airline.server.core.request.CreateFlightRequest;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FlightRepositoryImpl extends SearchRepository implements FlightRepositoryCustom{

    private static DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    public List<Flight> search(CreateFlightRequest request) throws AirlineException {

        StringBuilder queryBuilder = new StringBuilder("SELECT fl from Flight fl INNER JOIN FETCH fl.airlineCompany ac " +
                "INNER JOIN FETCH fl.sourceLoc sl INNER JOIN FETCH fl.destLoc dl ");

        List<String> queryParamStringList = this.setFilterCriteria(request);
        Map<String, Object> namedParamMap = this.getNamedParam(request);

        if (namedParamMap.size() > 0) {
            queryBuilder.append(" WHERE ");
            queryBuilder.append(StringUtils.join(queryParamStringList, " and "));
        }
        List<Flight> results = find(null, 1000, queryBuilder.toString(),
                namedParamMap);

        List<Flight> responseSet = new ArrayList<>();
        if (CollectionUtils.isEmpty(results)) {
            return responseSet;
        }

        for (Flight flight : results) {
            responseSet.add(flight);
        }

        return responseSet;
    }

    @Override
    public Long count(CreateFlightRequest request) throws AirlineException {
        return null;
    }

    private List<String> setFilterCriteria(CreateFlightRequest searchDto) {
        List<String> queryParamStringList = new ArrayList<>();
        if (searchDto.getSrcLocation() != null && !searchDto.getSrcLocation().isEmpty()) {
            queryParamStringList.add(" fl.sourceLoc = :sourceLoc ");
        }
        if (searchDto.getAirlineCompany() != null && !searchDto.getAirlineCompany().isEmpty()) {
            queryParamStringList.add(" fl.airlineCompany = :airlineCompany ");
        }
        if (searchDto.getDestLocation() != null && !searchDto.getDestLocation().isEmpty()) {
            queryParamStringList.add(" fl.destLoc = :destLoc ");
        }
        if (searchDto.getDesignArrTimeSrc() != null) {
            queryParamStringList.add(" fl.designSrcArrivalTime >= :designSrcArrivalTime ");
        }
        return queryParamStringList;
    }

    private Map<String, Object> getNamedParam(CreateFlightRequest searchDto) throws AirlineException {
        ImmutableMap.Builder<String, Object> namedParamMapBuilder = ImmutableMap.<String, Object>builder();

        if (searchDto.getSrcLocation() != null && !searchDto.getSrcLocation().isEmpty()) {
            namedParamMapBuilder.put("sourceLoc", searchDto.getSrcLocation());
        }

        if (searchDto.getDestLocation() != null && !searchDto.getDestLocation().isEmpty()) {
            namedParamMapBuilder.put("destLoc", searchDto.getDestLocation());
        }

        if (searchDto.getAirlineCompany() != null && !searchDto.getAirlineCompany().isEmpty()) {
            namedParamMapBuilder.put("airlineCompany", searchDto.getAirlineCompany());
        }

        // from date criteria at source
        if (searchDto.getDesignArrTimeSrc() != null && !searchDto.getDesignArrTimeSrc().isEmpty()) {
            DateTime dateTime = formatter.parseDateTime(searchDto.getDesignArrTimeSrc());
            namedParamMapBuilder.put("designSrcArrivalTime", dateTime);
        }

        ImmutableMap<String, Object> namedParamMap = namedParamMapBuilder.build();
        return namedParamMap;
    }


}
