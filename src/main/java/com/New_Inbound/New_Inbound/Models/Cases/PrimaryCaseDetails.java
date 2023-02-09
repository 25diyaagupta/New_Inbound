package com.New_Inbound.New_Inbound.Models.Cases;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PrimaryCaseDetails {
    @SerializedName(value = "primaryCaseId", alternate = {"primary_case_id"})
    @Expose
    public String primaryCaseId;
    @SerializedName("oldPrimaryCaseId")
    @Expose
    public String oldPrimaryCaseId;
    @SerializedName(value = "totalEaQty", alternate = {"total_ea_qty"})
    @Expose
    public int totalEaQty;
    @SerializedName("volume")
    public float volume;
    @SerializedName("weight")
    public float weight;
    @SerializedName("step")
    @Expose
    public String step;
    @SerializedName("status")
    @Expose
    public String status;
//    @SerializedName(value = "skuDetails", alternate = {"sku_details"})
//    @Expose
//    public List<@Valid SkuDetails> skuDetails;
    @SerializedName(value = "caseHeight", alternate = {"case_height"})
    @Expose
    public float caseHeight;
    @SerializedName(value = "caseBreadth", alternate = {"case_breadth"})
    @Expose
    public float caseBreadth;
    @SerializedName(value = "caseLength", alternate = {"case_length"})
    @Expose
    public float caseLength;
    @SerializedName(value = "caseWeight", alternate = {"case_weight"})
    @Expose
    public float caseWeight;
    @SerializedName(value = "isDimensionsCaptured", alternate = {"is_dimensions_captured"})
    @Expose
    public boolean isDimensionsCaptured;
    public String caseZone;
    public String caseBinLocation;
    public String caseBinCheckDigit;

    public int receivingSkuId;
}
