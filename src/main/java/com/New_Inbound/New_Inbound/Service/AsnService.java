package com.New_Inbound.New_Inbound.Service;

import com.New_Inbound.New_Inbound.Dao.AsnDao;
import com.New_Inbound.New_Inbound.Models.ShipmentDetail;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

//import java.sql.Date;

//import java.util.Date;

@Service
public class AsnService implements AsnDao {

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Autowired
    Gson gson;

    @Override
    public void addAsn(ShipmentDetail asnAudit) {

        String asn_number = asnAudit.getRefDocNumber();
        String json = gson.toJson(asnAudit);
        String created_by = asnAudit.getCreated_by();
        String updated_by = asnAudit.getUpdated_by();

        int id_pod_uploaded = asnAudit.getPodFile() == null ? 0 : 1;

        String insertAsnAudit = "INSERT INTO inbound_receiving (asn_number, json, created_by, created_timestamp, updated_by, updated_timestamp, is_pod_uploaded) VALUES (:asn_number, :json, :created_by, GETDATE(), :updated_by, GETDATE(), :is_pod_uploaded)";
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("asn_number", asn_number);
        parameters.addValue("json", json);
        parameters.addValue("created_by", created_by);
        parameters.addValue("updated_by", updated_by);
        parameters.addValue("is_pod_uploaded", id_pod_uploaded);

        namedParameterJdbcTemplate.update(insertAsnAudit, parameters);




    }
}
