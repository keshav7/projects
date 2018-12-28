package service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
import org.springframework.beans.factory.annotation.Autowired;

public class OrderServiceImpl {

    @Autowired
    LocationRepository locationRepository;

    @Override
    public Location save(Location location) throws AirlineException{
        try {
            return locationRepository.save(location);
        } catch (Exception e) {
            throw new AirlineException(Errors.LMS_INTERNAL_ERROR, e);
        }
    }

    @Override
    public Location findById(Long locationId) throws AirlineException{
        try {
            return locationRepository.findOne(locationId);
        } catch (Exception e) {
            throw new AirlineException(Errors.LMS_INTERNAL_ERROR, e);
        }
    }
}
