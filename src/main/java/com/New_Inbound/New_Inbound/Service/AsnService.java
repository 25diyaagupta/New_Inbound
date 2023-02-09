package com.New_Inbound.New_Inbound.Service;

import com.New_Inbound.New_Inbound.Dao.AsnDao;
import com.New_Inbound.New_Inbound.Mapper.MapParam;
import com.New_Inbound.New_Inbound.Models.Cases.PrimaryCaseDetails;
import com.New_Inbound.New_Inbound.Models.Cases.SecondaryCaseDetails;
import com.New_Inbound.New_Inbound.Models.ShipmentDetail;
import com.New_Inbound.New_Inbound.Utils.SqlUtils;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsnService implements AsnDao {

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Autowired
    Gson gson;

    @Autowired
    MapParam mapParam;

    @Override
    public void addAsn(ShipmentDetail shipmentDetail) {

        String asn_number = shipmentDetail.getRefDocNumber();
        String InsertAsnAudit = SqlUtils.InsertAsnAudit;
        MapSqlParameterSource AuditParam = mapParam.MapAuditParam(shipmentDetail);
        namedParameterJdbcTemplate.update(InsertAsnAudit, AuditParam);


        String InsertReceivingInfo = SqlUtils.InsertReceivingInfo;
        MapSqlParameterSource ReceivingParam = mapParam.MapReceivingInfo(shipmentDetail);
        namedParameterJdbcTemplate.update(InsertReceivingInfo, ReceivingParam);


        List<SecondaryCaseDetails> secondaryCaseDetailsList = shipmentDetail.getSecondaryCase();

        for(SecondaryCaseDetails sc : secondaryCaseDetailsList){

            String secondaryCaseId = sc.getSecondaryCaseId();
            String InsertSecondaryCases = SqlUtils.InsertSecondaryCases;
            MapSqlParameterSource secondaryParam = mapParam.MapSecondaryCase(asn_number, sc);
            namedParameterJdbcTemplate.update(InsertSecondaryCases, secondaryParam);

            List<PrimaryCaseDetails> primaryCaseDetails = sc.getPrimaryCaseDetails();

            for(PrimaryCaseDetails pc : primaryCaseDetails){

                String pc_gson = gson.toJson(pc);
                String InsertPrimaryCases = SqlUtils.InsertPrimaryCases;
                MapSqlParameterSource primaryParam = mapParam.MapPrimaryCase(asn_number, secondaryCaseId, pc);
                namedParameterJdbcTemplate.update(InsertPrimaryCases, primaryParam);
            }
        }
    }
}
