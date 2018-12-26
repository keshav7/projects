package com.projects.tracker.server.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
public enum Errors implements com.projects.core.datatypes.enumInterfaces.Errors {

    /**
     * For new errors, add at last
     */

    LMS_INTERNAL_ERROR("INTERNAL_ERROR", 1401, HttpStatus.INTERNAL_SERVER_ERROR, "Internal Error"),
    LMS_INVALID_WEIGHT_UNIT("INVALID_WEIGHT_UNIT", 1402, HttpStatus.BAD_REQUEST, "Not a valid weight unit."),
    LMS_INVALID_VOLUME_UNIT("INVALID_VOLUME_UNIT", 1403, HttpStatus.BAD_REQUEST, "Not a valid volume unit."),
    LMS_NO_SUCH_TR_LINE_ITEM_EXISTS("NO_SUCH_TR_LINE_ITEM_EXISTS", 1404, HttpStatus.BAD_REQUEST, "No such TR line item exists."),
    LMS_INVALID_STATE_TRANSITION("INVALID_STATE_TRANSITION", 1405, HttpStatus.FORBIDDEN, "Invalid state transition."),
    LMS_TR_LINE_ITEM_NOT_IN_CREATED_STATE("TR_LINE_ITEM_NOT_IN_CREATED_STATE", 1406, HttpStatus.FORBIDDEN, "TR line item is not in created state."),
    LMS_CONSIGNMENT_NOT_FOUND("CONSIGNMENT_NOT_FOUND", 1407, HttpStatus.BAD_REQUEST, "Consignment not found"),
    LMS_CONTAINER_SERVICE_EXCEPTION("CONTAINER_SERVICE_EXCEPTION", 1408, HttpStatus.BAD_REQUEST, "Error in container serviceManager."),
    LMS_INVALID_DIMENSION_UNIT("INVALID_DIMENSION_UNIT", 1409, HttpStatus.BAD_REQUEST, "Not a valid dimension unit."),
    LMS_INVALID_CURRENCY_UNIT("INVALID_CURRENCY_UNIT", 1410, HttpStatus.BAD_REQUEST, "Not a valid currency unit."),
    LMS_PASS_STATUS_AND_TR_LINE_ITEM_IDS("EITHER_PASS_STATUS_OR_TR_LINE_ITEM_IDS", 1411, HttpStatus.BAD_REQUEST, "Either pass consignment status and tr line item ids."),
    LMS_CONSIGNMENT_NOT_IN_OPENED_STATE("CONSIGNMENT_NOT_IN_OPENED_STATE", 1412, HttpStatus.FORBIDDEN, "Consignment Not in opened state"),
    LMS_PARSING_FAILED("PARSING_STRING_TO_LONG_FAILED", 1413, HttpStatus.BAD_REQUEST, "Failed to parse string to long"),
    LMS_LOAD_UNIT_NOT_FOUND("LOAD_UNIT_NOT_FOUND", 1414, HttpStatus.BAD_REQUEST, "Load unit not found."),
    LMS_LOAD_UNIT_NOT_IN_A_CONSIGNMENT("LOAD_UNIT_NOT_IN_A_CONSIGNMENT", 1415, HttpStatus.BAD_REQUEST, "There is no consignment for given load unit."),
    LMS_CONSIGNMENT_NOT_IN_DISPATCH_STATUS("CONSIGNMENT_NOT_IN_DISPATCH_STATUS", 1416, HttpStatus.FORBIDDEN, "Consignment is not in dispatch status."),
    LMS_JSON_PROCESSING_EXCEPTION("JSON_PROCESSING_EXCEPTION", 1417, HttpStatus.INTERNAL_SERVER_ERROR, "Error in json processing."),
    LMS_ERROR_COPYING_OBJECTS("ERROR_COPYING_OBJECTS", 1418, HttpStatus.INTERNAL_SERVER_ERROR, "Error in copying from one object to another."),
    LMS_CANNOT_CANCEL_LOAD_UNIT_INSIDE_CONSIGNMENT("CANNOT_CANCEL_LOAD_UNIT_INSIDE_CONSIGNMENT", 1419, HttpStatus.BAD_REQUEST, "Load unit is inside a consignment, cannot cancel it. Remove from consignment and then re-try."),
    LMS_NOT_VALID_LOAD_UNIT_STATE_FOR_COMPLETING_CONSIGNMENT("NOT_VALID_LOAD_UNIT_STATE_FOR_COMPLETING_CONSIGNMENT", 1420, HttpStatus.INTERNAL_SERVER_ERROR, "Consignment has some load units which are not in proper state required for completion of consignment."),
    LMS_LOAD_REQUEST_NOT_FOUND_FOR_TR_LINE_ITEM_EXT_ID("LOAD_REQUEST_NOT_FOUND_FOR_TR_LINE_ITEM_EXT_ID", 1421, HttpStatus.BAD_REQUEST, "Load request not found for tr line item ext id"),
    LMS_OPERATION_NOT_ALLOWED_AT_LOCATION("OPERATION_NOT_ALLOWED_AT_CURRENT_LOCATION", 1422, HttpStatus.BAD_REQUEST, "Operation not allowed at current location"),
    LMS_PAGE_SIZE_ERROR("LMS_PAGE_SIZE_ERROR", 1423, HttpStatus.BAD_REQUEST, "Page size is larger"),
    LMS_DATE_PARSE_ERROR("LMS_DATE_PARSE_ERROR", 1424, HttpStatus.BAD_REQUEST, "Date is not in correct format"),
    LMS_REQUEST_MANAGER_SERVICE_EXCEPTION("LOAD_MANAGER_SERVICE_EXCEPTION", 1425, HttpStatus.BAD_REQUEST, "Error in request manager serviceManager"),
    GROUP_ID_NOT_FOUND("GROUP_ID_NOT_FOUND_IN_REQUEST_MANAGER", 1426, HttpStatus.BAD_REQUEST, "Group ID not found in Request Manager serviceManager"),
    LMS_LOAD_UNIT_EXPECTED_AT_OTHER_LOCATION("OPERATION_NOT_ALLOWED_AT_CURRENT_LOCATION", 1427, HttpStatus.BAD_REQUEST, "Load Unit needs to be delivered at different location"),
    LMS_LOAD_UNIT_EXPECTATION_NOT_FOUND_INCORRECT_LOCATION("EXPECTATION_NOT_FOUND_INCORRECT_LOCATION", 1428, HttpStatus.BAD_REQUEST, "Load Unit needs to be delivered at different location"),
    LMS_LOAD_UNIT_LOCATION_INCORRECT("LOAD_UNIT_NOT_EXPECTED_AT_LOCATION", 1431, HttpStatus.BAD_REQUEST, "Load unit location is incorret"),
    LMS_LOAD_UNIT_EXPECTATION_NOT_FOUND_CORRECT_LOCATION("EXPECTATION_NOT_FOUND_CORRECT_LOCATION", 1429, HttpStatus.BAD_REQUEST, "Load Unit not picked. Deliver location correct."),
    LMS_PASS_STATUS_AND_TRIP_IDS("EITHER_PASS_STATUS_OR_TRIP_IDS", 1430, HttpStatus.BAD_REQUEST, "Either pass consignment status and trip ids."),
    REASON_CODE_NOT_SENT("REASON_CODE_NOT_SENT", 1431, HttpStatus.BAD_REQUEST, "Generic deliver reason code not sent"),
    LMS_SORTATION_NOT_ALLOWED_FOR_NON_MPS("LMS_SORTATION_NOT_ALLOWED_FOR_NON_MPS", 1432 , HttpStatus.BAD_REQUEST , "Sorting not allowed for non mps entity"),
    LMS_CONNECTION_MANAGER_EXCEPTION("LMS_CONNECTION_MANAGER_EXCEPTION", 1433 , HttpStatus.INTERNAL_SERVER_ERROR, "Error while calling connection manager"),
    LMS_UNSUPPORTED_TIER_TYPE("LMS_UNSUPPORTED_TIER_TYPE", 1434, HttpStatus.BAD_REQUEST, "Unsupported trier type"),
    LMS_PARSING_TO_DTO_FAILED("LMS_PARSING_TO_DTO_FAILED", 1435 , HttpStatus.INTERNAL_SERVER_ERROR , "Parsing to dto failed"),
    LMS_FAILED_TO_GET_SERVICE_REQUEST_DETAIL("LMS_FAILED_TO_GET_SERVICE_REQUEST", 1436 , HttpStatus.INTERNAL_SERVER_ERROR , "Failed to get serviceManager request detail"),
    LMS_FAILED_TO_GET_RESORT_MATRIX_DETAIL("LMS_FAILED_TO_GET_RESORT_MATRIX_DETAIL", 1437 , HttpStatus.INTERNAL_SERVER_ERROR , "Failed to get resort matrix detail"),
    LMS_RESORT_LANE_ZONE_ERROR("LMS_RESORT_LANE_ZONE_ERROR", 1438, HttpStatus.INTERNAL_SERVER_ERROR, "Resort lane zone repository error"),
    LMS_LOCATION_SERVICE_ERROR("LMS_LOCATION_SERVICE_ERROR", 1439, HttpStatus.INTERNAL_SERVER_ERROR, "Location serviceManager error"),
    LMS_LOCATION_NOT_FOUND("LMS_LOCATION_NOT_FOUND", 1440, HttpStatus.BAD_REQUEST, "No location found"),
    REQUEST_MANAGER_SERVICE_ISSUE("REQUEST_MANAGER_SERVICE_ISSUE", 1441, HttpStatus.INTERNAL_SERVER_ERROR, "Request manager serviceManager Issue"),
    LMS_LOAD_UNIT_DOES_NOT_EXIST_IN_TRANSPORT("LMS_LOAD_UNIT_DOES_NOT_EXIST_IN_TRANSPORT", 1442, HttpStatus.BAD_REQUEST, "Load unit does not exist in transport system"),
    LMS_LOAD_UNIT_PRESENT_IN_PICKED_STATE("LMS_LOAD_UNIT_PRESENT_IN_PICKED_STATE", 1443, HttpStatus.BAD_REQUEST, "Load unit already exist in picked state"),
    LMS_LOAD_UNIT_PRESENT_IN_LOST_STATE("LMS_LOAD_UNIT_PRESENT_IN_LOST_STATE", 1444, HttpStatus.BAD_REQUEST, "Load unit already exist in lost state"),
    LMS_LOAD_UNIT_EXPECTATION_FOUND_CORRECT_LOCATION("LMS_LOAD_UNIT_EXPECTATION_FOUND_CORRECT_LOCATION", 1445, HttpStatus.BAD_REQUEST, "Load Unit expectation created and can be delivered at current location"),
    LMS_NO_RESORT_ZONE_FOUND("LMS_NO_RESORT_ZONE_FOUND", 1446, HttpStatus.BAD_REQUEST, "No resort zone found for given trackingId and locationId"),
    LMS_MISMATCH_IN_SR_TRACKING_ID_AND_ERP_CONSIGNMENT_TRACKING_IDS("LMS_MISMATCH_IN_SR_TRACKING_ID_AND_ERP_CONSIGNMENT_TRACKING_IDS",
            1447, HttpStatus.BAD_REQUEST, "There is mismatch in erp consignment shipment tracking ids and serviceManager request tracking ids"),
    LMS_INVALID_LOADING_SESSION("LMS_INVALID_LOADING_SESSION",
            1448, HttpStatus.FORBIDDEN, "Loading is either already completed or has not started yet, cannot perform loading activities now."),
    LMS_MISSING_PICK_UP_PROOF_INFO("LMS_MISSING_PICK_UP_PROOF_INFO",
            1449, HttpStatus.BAD_REQUEST, "Missing pickup proof info, which is required for dispatching consignment."),
    LMS_SESSION_ID_REQUIRED("LMS_SESSION_ID_REQUIRED",
            1450, HttpStatus.BAD_REQUEST, "Session id is required for loading related activities."),
    LMS_LOAD_UNIT_NOT_IN_PICKED_STATE("LMS_LOAD_UNIT_NOT_IN_PICKED_STATE", 1448, HttpStatus.BAD_REQUEST, "Load unit not in picked"),
    LMS_CONSIGNMENT_ALREADY_CLOSED("LMS_CONSIGNMENT_ALREADY_CLOSED", 1449, HttpStatus.BAD_REQUEST, "Cannot remove load unit consignment already closed"),
    LMS_CONSIGNMENT_CLOSURE_CHECKS_FAILED("LMS_CONSIGNMENT_CLOSURE_CHECKS_FAILED", 1450, HttpStatus.BAD_REQUEST, "Some checks for consignment closure has failed."),
    LMS_INVALID_REASON_FOR_DG_OFFLOAD("LMS_INVALID_REASON_FOR_DG_OFFLOAD", 1451, HttpStatus.BAD_REQUEST, "Invalid reason for DG Offload."),
    LMS_INVALID_CONSIGNMENT_STATE("LMS_INVALID_CONSIGNMENT_STATE", 1452, HttpStatus.FORBIDDEN, "Invalid consignment state."),
    LMS_SEARCH_FIELD_ERROR("LMS_SEARCH_FIELD_ERROR", 1453, HttpStatus.BAD_REQUEST, "At least one search parameter should be present for load search");

    @Getter
    private String code;
    @Getter
    private int internalErrorCode;
    @Getter
    private HttpStatus status;
    @Getter
    private String description;
}
