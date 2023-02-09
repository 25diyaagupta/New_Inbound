package com.New_Inbound.New_Inbound;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class TableCreator implements CommandLineRunner {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... args) throws Exception {
        String query1 = "IF OBJECT_ID('asn_audit', 'U') IS NULL CREATE TABLE asn_audit(asn_number varchar(255), json nvarchar(max), created_by varchar(255), created_timestamp datetime, updated_by varchar(255), updated_timestamp datetime, is_pod_uploaded bit, primary key(asn_number))";

        String query2 = "IF OBJECT_ID('receiving_info', 'U') IS NULL CREATE TABLE receiving_info (txnType varchar(255), invNo varchar(255), dockAssignmentValidation varchar(255), invDate date, shipmentNumber varchar(255), deliveryDate date, vehicleType varchar(255), vehicleNo varchar(255), refDocNo varchar(255), "
                        + "appointmentNumber varchar(255), destinationWhCode varchar(255), originCode varchar(255), sellerName varchar(255), poNumber varchar(255), secondaryCaseVerified varchar(255), primaryCaseValidated varchar(255), verificationPending varchar(255), validationPending varchar(255), totalPrimaryCase int, "
                        + "totalSecondaryCase int,primaryCaseStatus varchar(255), secondaryCaseStatus varchar(255), primaryCaseList varchar(max), channelId varchar(255), vrnCheck varchar(255), receivingPrimaryCaseId varchar(255), receivingSecondaryCaseId varchar(255), isPodUploaded bit, podFile varchar(255), fileName varchar(255), "
                        + " updatedBy varchar(255), updateDate datetime, id varchar(255), operationType varchar(255), searchParameter varchar(255), deviceId varchar(255), PRIMARY KEY (refDocNo))";

        String query3 = "IF OBJECT_ID('t_receiving_secondary', 'U') IS NULL CREATE TABLE t_receiving_secondary(asn_number varchar(255), secondary_case_id varchar(255), is_verified varchar(255), totalCsqty int, palletTypeIndicator varchar(255), availableVolume varchar(255), availableWeight varchar(255), zone varchar(255), vrncheck varchar(255), primary key (asn_number, secondary_case_id))";

        String query4 = "IF OBJECT_ID('t_receiving_primary', 'U') IS NULL CREATE TABLE t_receiving_primary(asn_number varchar(255), secondary_case_id varchar(255), primary_case_id varchar(255), pc_json nvarchar(max), step varchar(255), status varchar(255), primary key(asn_number, secondary_case_id, primary_case_id))";
        jdbcTemplate.update(query1);
        jdbcTemplate.update(query2);
        jdbcTemplate.update(query3);
        jdbcTemplate.update(query4);

    }
}
