package cn.edu.upc.hyz.service;


import cn.edu.upc.hyz.model.Report;

import java.util.List;

public interface ReportService {
    List<Report> getListByParam(int pid, int gid, int eid);
    void  insertReport(Report report);
}
