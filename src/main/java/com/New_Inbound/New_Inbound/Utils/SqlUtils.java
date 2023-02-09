package com.New_Inbound.New_Inbound.Utils;

public class SqlUtils {

    public static String InsertAsnAudit = "INSERT INTO asn_audit (asn_number, json, created_by, created_timestamp, updated_by, updated_timestamp, is_pod_uploaded) "
                                        + " VALUES (:asn_number, :json, :created_by, GETDATE(), :updated_by, GETDATE(), :is_pod_uploaded)";

    public static String InsertReceivingInfo = " INSERT INTO receiving_info (txnType, invNo, dockAssignmentValidation, invDate, shipmentNumber, deliveryDate, "
                    + " vehicleType, vehicleNo, refDocNo, appointmentNumber, destinationWhCode, originCode, sellerName, poNumber,  "
                    + " secondaryCaseVerified, primaryCaseValidated, verificationPending, validationPending, totalPrimaryCase, totalSecondaryCase, primaryCaseStatus, "
                    + " secondaryCaseStatus, primaryCaseList, channelId, vrnCheck, receivingPrimaryCaseId, "
                    + " receivingSecondaryCaseId, isPodUploaded, podFile, fileName, updatedBy, updateDate, id, operationType, searchParameter, deviceId) "
                    + " VALUES (:txnType, :invNo, :dockAssignmentValidation, :invDate, :shipmentNumber, :deliveryDate, :vehicleType, :vehicleNo, :refDocNo,  "
                    + " :appointmentNumber, :destinationWhCode, :originCode, :sellerName, :poNumber, :secondaryCaseVerified, "
                    + " :primaryCaseValidated, :verificationPending, :validationPending, :totalPrimaryCase, :totalSecondaryCase, :primaryCaseStatus, "
                    + " :secondaryCaseStatus, :primaryCaseList, :channelId, :vrnCheck, :receivingPrimaryCaseId, :receivingSecondaryCaseId, "
                    + " :isPodUploaded, :podFile, :fileName, :updatedBy, GETDATE(), :id, :operationType, :searchParameter, :deviceId)";

    public static String InsertSecondaryCases = "INSERT INTO t_receiving_secondary (asn_number, secondary_case_id, is_verified, totalCsqty, palletTypeIndicator,"
                    + " availableVolume, availableWeight, zone, vrncheck) VALUES (:asn_number, :secondary_case_id, :is_verified, :totalCsqty, :palletTypeIndicator,"
                    + " :availableVolume, :availableWeight, :zone, :vrncheck)";

    public static String InsertPrimaryCases = "Insert into t_receiving_primary(asn_number, secondary_case_id, primary_case_id, pc_json, step, status) values "
                    + " (:asn_number, :secondary_case_id, :primary_case_id, :pc_json, :step, :status)";

}
