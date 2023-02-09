package com.New_Inbound.New_Inbound.Mapper;

import com.New_Inbound.New_Inbound.Models.Cases.PrimaryCaseDetails;
import com.New_Inbound.New_Inbound.Models.Cases.SecondaryCaseDetails;
import com.New_Inbound.New_Inbound.Models.ShipmentDetail;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

public class MapParam {
    @Autowired
    Gson gson;

    public MapSqlParameterSource MapAuditParam(ShipmentDetail shipmentDetail){
        MapSqlParameterSource auditParam = new MapSqlParameterSource();
        auditParam.addValue("asn_number", shipmentDetail.getRefDocNumber());
        auditParam.addValue("json", gson.toJson(shipmentDetail));
        auditParam.addValue("created_by", shipmentDetail.getCreated_by());
        auditParam.addValue("updated_by", shipmentDetail.getUpdated_by());
        auditParam.addValue("is_pod_uploaded", shipmentDetail.getPodFile() == null ? 0 : 1);

        return auditParam;
    }

    public MapSqlParameterSource MapReceivingInfo(ShipmentDetail shipmentDetail){

        MapSqlParameterSource newShipment = new MapSqlParameterSource();
        newShipment.addValue("txnType", shipmentDetail.getTxnType());
        newShipment.addValue("invNo", shipmentDetail.getInvNo());
        newShipment.addValue("dockAssignmentValidation", shipmentDetail.getDockAssignmentValidation());
        newShipment.addValue("invDate", shipmentDetail.getInvDate());
        newShipment.addValue("shipmentNumber",shipmentDetail.getShipmentNumber());
        newShipment.addValue("deliveryDate", shipmentDetail.getDeliveryDate());
        newShipment.addValue("vehicleType", shipmentDetail.getVehicleType());
        newShipment.addValue("vehicleNo", shipmentDetail.getVehicleNo());
        newShipment.addValue("refDocNo", shipmentDetail.getRefDocNumber());
        newShipment.addValue("appointmentNumber", shipmentDetail.getAppointmentNumber());
        newShipment.addValue("destinationWhCode", shipmentDetail.getDestinationWhCode());
        newShipment.addValue("originCode", shipmentDetail.getOriginCode());
        newShipment.addValue("sellerName", shipmentDetail.getSellerName());
        newShipment.addValue("poNumber", shipmentDetail.getPoNumber());
        newShipment.addValue("secondaryCaseVerified", shipmentDetail.getSecondaryCaseVerified());
        newShipment.addValue("primaryCaseValidated", shipmentDetail.getPrimaryCaseValidated());
        newShipment.addValue("verificationPending", shipmentDetail.getVerificationPending());
        newShipment.addValue("validationPending", shipmentDetail.getValidationPending());
        newShipment.addValue("totalPrimaryCase", shipmentDetail.getTotalPrimaryCase());
        newShipment.addValue("totalSecondaryCase", shipmentDetail.getTotalSecondaryCase());
        newShipment.addValue("primaryCaseStatus", shipmentDetail.getPrimaryCaseStatus());
        newShipment.addValue("secondaryCaseStatus", shipmentDetail.getSecondaryCaseStatus());
        newShipment.addValue("primaryCaseList", null);
        newShipment.addValue("channelId", shipmentDetail.getChannelId());
        newShipment.addValue("vrnCheck", shipmentDetail.getVrnCheck());
        newShipment.addValue("receivingPrimaryCaseId", shipmentDetail.getReceivingPrimaryCaseId());
        newShipment.addValue("receivingSecondaryCaseId", shipmentDetail.getReceivingSecondaryCaseId());
        newShipment.addValue("isPodUploaded", null);
        newShipment.addValue("podFile", shipmentDetail.getPodFile());
        newShipment.addValue("fileName", shipmentDetail.getFileName());
        newShipment.addValue("updatedBy", shipmentDetail.getUpdated_by());
//        newShipment.addValue("updateDate", null);
        newShipment.addValue("id", shipmentDetail.getId());
        newShipment.addValue("operationType", shipmentDetail.getOperationType());
        newShipment.addValue("searchParameter", shipmentDetail.getSearchParameter());
        newShipment.addValue("deviceId", shipmentDetail.getDeviceId());

        return newShipment;
    }

    public MapSqlParameterSource MapSecondaryCase(String asn_number, SecondaryCaseDetails secondaryCaseDetails){
        MapSqlParameterSource secondaryParam = new MapSqlParameterSource();
        secondaryParam.addValue("asn_number", asn_number);
        secondaryParam.addValue("secondary_case_id", secondaryCaseDetails.getSecondaryCaseId());
        secondaryParam.addValue("is_verified", "NO");
        secondaryParam.addValue("totalCsqty", secondaryCaseDetails.getTotalCsQty());
        secondaryParam.addValue("palletTypeIndicator", secondaryCaseDetails.getPalletTypeIndicator());
        secondaryParam.addValue("availableVolume", secondaryCaseDetails.getAvailableVolume());
        secondaryParam.addValue("availableWeight", secondaryCaseDetails.getAvailableWeight());
        secondaryParam.addValue("zone", null);
        secondaryParam.addValue("vrncheck", secondaryCaseDetails.getVrnCheck());

        return secondaryParam;
    }

    public MapSqlParameterSource MapPrimaryCase(String asn_number, String secondaryCaseId, PrimaryCaseDetails primaryCaseDetails){
        MapSqlParameterSource primaryParam = new MapSqlParameterSource();

        primaryParam.addValue("asn_number", asn_number);
        primaryParam.addValue("secondary_case_id", secondaryCaseId);
        primaryParam.addValue("primary_case_id", primaryCaseDetails.getPrimaryCaseId());
        primaryParam.addValue("pc_json", gson.toJson(primaryCaseDetails));
        primaryParam.addValue("step", primaryCaseDetails.getStep());
        primaryParam.addValue("status", primaryCaseDetails.getStatus());
        return  primaryParam;
    }
}
