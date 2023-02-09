package com.New_Inbound.New_Inbound.Models.Cases;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SecondaryCaseDetails {

    @SerializedName(value = "secondaryCaseId", alternate = {"secondary_case_id"})
    @Expose
    public String secondaryCaseId;

    @SerializedName(value = "totalCsQty", alternate = {"total_cs_qty"})
    @Expose
    public int totalCsQty;

//    @SerializedName("step")
//    @Expose
//    public InboundFlowSteps step;
//
//    @SerializedName("status")
//    @Expose
//    public InboundFlowStatus status;

    @SerializedName(value = "primaryCaseDetails", alternate = {"primary_case_details"})
    @Expose
    public List<@Valid PrimaryCaseDetails> primaryCaseDetails;

    @SerializedName("palletTypeIndicator")
    public String palletTypeIndicator;

    @SerializedName("availableVolume")
    public Float availableVolume;

    @SerializedName("availableWeight")
    public Float availableWeight;
//    @SerializedName("zone")
//    public List<Zone> zone;

    @SerializedName("verified")
    @Expose
    public boolean verified;

    @Expose
    public String vrnCheck;
}
