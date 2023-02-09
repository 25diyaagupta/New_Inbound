package com.New_Inbound.New_Inbound.Models;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Getter;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ShipmentDetail {
    @SerializedName(value = "txnType", alternate = {"txn_type"})
    @Expose
    public String txnType;
    @SerializedName(value = "invNo", alternate = {"inv_no"})
    @Expose
    public String invNo;
    @SerializedName(value = "dockAssignmentValidation", alternate = {"active_status"})
    @Expose
    public String dockAssignmentValidation;
    @SerializedName(value = "invDate", alternate = {"inv_date"})
    @Expose
    @Pattern(regexp = "^$|^[0-9]{13}$", message = "Date should be in 13 digit epoch format")
    public String invDate;
    @SerializedName(value = "shipmentNumber", alternate = {"shipment_number"})
    @Expose
    public String shipmentNumber;
    @SerializedName(value = "deliveryDate", alternate = {"delivery_date"})
    @Expose
    @Pattern(regexp = "^$|^[0-9]{13}$", message = "Date should be in 13 digit epoch format")
    public String deliveryDate;
    @SerializedName(value = "vehicleType", alternate = {"vehicle_type"})
    @Expose
    public String vehicleType;
    @SerializedName(value = "vehicleNo", alternate = {"vehicle_no"})
    @Expose
    public String vehicleNo;
    @SerializedName(value = "refDocNo", alternate = {"ref_doc_no"})
    @Expose
    public String refDocNumber;
    @SerializedName(value = "appointmentNumber", alternate = {"appointment_number"})
    @Expose
    public String appointmentNumber;
    @SerializedName(value = "destinationWhCode", alternate = {"destination_wh_code"})
    @Expose
    public String destinationWhCode;
    @SerializedName(value = "originCode", alternate = {"origin_code"})
    @Expose
    public String originCode;
    @SerializedName(value = "sellerName", alternate = {"seller_name"})
    @Expose
    public String sellerName;
    @SerializedName(value = "poNumber", alternate = {"po_Number"})
    @Expose
    public String poNumber;
    //    @SerializedName(value = "operationType", alternate = {"operation_type"})
//    @Expose
//    public OperationType operationType;
//    @SerializedName(value = "secondaryCase", alternate = {"secondary_case"})
//    @Expose
//    public List<@Valid SecondaryCase> secondaryCase = null;
    @SerializedName(value = "secondaryCaseVerified")
    @Expose
    public Integer secondaryCaseVerified = null;
    @SerializedName(value = "primaryCaseValidated")
    @Expose
    public Integer primaryCaseValidated = null;
    @SerializedName(value = "verificationPending")
    @Expose
    public Integer verificationPending = null;
    @SerializedName(value = "validationPending")
    @Expose
    public Integer validationPending = null;
    @SerializedName(value = "totalPrimaryCase")
    @Expose
    public Integer totalPrimaryCase = null;
    @SerializedName(value = "totalSecondaryCase")
    @Expose
    public Integer totalSecondaryCase = null;
    @SerializedName(value = "primaryCaseStatus")
    @Expose
    public String primaryCaseStatus = null;
    @SerializedName(value = "secondaryCaseStatus")
    @Expose
    public String secondaryCaseStatus = null;
//    @SerializedName(value = "primaryCaseList", alternate = {"primary_case_list"})
//    @Expose
//    public List<PrimaryCaseDetail> primaryCaseList;
    @SerializedName(value = "channelId")
    @Expose
    public String channelId;

    @Expose
    public String vrnCheck;

    public String receivingPrimaryCaseId;
    public String receivingSecondaryCaseId;

    public boolean isPodUploaded;
    public String podFile;

    public ShipmentDetail(ShipmentDetail shipmentDetailCopy, String receivingPrimaryCaseIdCopy, String receivingSecondaryCaseIdCopy) {
        this.txnType = shipmentDetailCopy.txnType;
        this.invNo = shipmentDetailCopy.invNo;
        this.invDate = shipmentDetailCopy.invDate;
        this.shipmentNumber = shipmentDetailCopy.shipmentNumber;
        this.deliveryDate = shipmentDetailCopy.deliveryDate;
        this.refDocNumber = shipmentDetailCopy.refDocNumber;
        this.appointmentNumber = shipmentDetailCopy.appointmentNumber;
        this.originCode = shipmentDetailCopy.originCode;
        this.poNumber = shipmentDetailCopy.poNumber;
        this.receivingPrimaryCaseId = receivingPrimaryCaseIdCopy;
        this.receivingSecondaryCaseId = receivingSecondaryCaseIdCopy;
    }

}
