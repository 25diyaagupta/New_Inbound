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
        String query1 = " CREATE TABLE IF NOT EXISTS inbound_receiving(asn_number varchar(255), json nvarchar(max), step varchar(255) , created_by varchar(255), created_timestamp datetime, updated_by varchar(255), updated_timestamp datetime, is_pod_uploaded bit, primary key(asn_number) )";
        String query2 = " CREATE TABLE IF NOT EXISTS t_receiving_secondary(asn_number varchar(255),  secondary_case_id varchar(255), is_verified varchar(255), totalCsqty int, status varchar(255), primary key (asn_number, secondary_case_id) )";
        String query3 = " CREATE TABLE IF NOT EXISTS t_receiving_primary(asn_number varchar(255), secondary_case_id varchar(255), primary_case_id varchar(255), pc_json nvarchar(max), step varchar(255), status varchar(255), primary key(asn_number, secondary_case_id, primary_case_id) )";
        jdbcTemplate.update(query1);
        jdbcTemplate.update(query2);
        jdbcTemplate.update(query3);

    }
}
