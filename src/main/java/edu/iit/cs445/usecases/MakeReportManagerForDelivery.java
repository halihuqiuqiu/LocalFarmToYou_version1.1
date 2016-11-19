package edu.iit.cs445.usecases;

import edu.iit.cs445.database.Database;
import edu.iit.cs445.entitites.ReportManagerForDelivery;
import edu.iit.cs445.exception.BadRequestException;

/**
 * Created by YongYang on 11/18/16.
 */
public class MakeReportManagerForDelivery {
    public static ReportManagerForDelivery makeReport(String mrid){
        if(mrid.equals("1")) {
            ReportManagerForDelivery report = new ReportManagerForDelivery();
            report.setMrid("1");
            report.setName("Orders placed today");
            report.setOrders_placed(Database.getOrderMap().size());
            return report;
        }else{
            throw new BadRequestException();
        }
    }
}
