package service.api;

import com.projects.core.datatypes.dto.ClientResponse;
import domain.Company;
import exception.FCException;
import request.OrderRequest;

public interface CompanyManagerService {
    ClientResponse addCompany(Company company, String requestedBy,
                              String requestId) throws FCException;
}
