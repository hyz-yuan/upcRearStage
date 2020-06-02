package cn.edu.upc.hyz.service;

import cn.edu.upc.hyz.manage.model.RightsSetLN;
import cn.edu.upc.hyz.manage.model.Rights;

import java.util.List;

public interface PriManageService {
    public List<RightsSetLN> selectAllPrivilege();
    public void insertNewPrivilege(Rights rights);
    public Rights selectPrivilegeManage(long id);
    public void updatePrivilege(Rights privilegeManage);
    public List<RightsSetLN> selectRightByRole(Integer roleId);
}
