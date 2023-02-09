package com.New_Inbound.New_Inbound.Controllers;

import com.New_Inbound.New_Inbound.Dao.AsnDao;
import com.New_Inbound.New_Inbound.Models.AsnAudit;
import com.New_Inbound.New_Inbound.Models.ShipmentDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AsnController {

    @Autowired
    AsnDao asnDao;

    @PostMapping("/post-asn")
    public String getAsn(@RequestBody ShipmentDetail asnAudit){
        asnDao.addAsn(asnAudit);
        return "Success";
    }



}
