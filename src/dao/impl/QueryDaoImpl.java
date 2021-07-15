package dao.impl;
import dao.CrudUtil;
import dao.QueryDAO;

import java.sql.ResultSet;

public class QueryDaoImpl implements QueryDAO {

    @Override
    public String getId() throws Exception {
        ResultSet set = CrudUtil.execute("SELECT code FROM Course ORDER BY code DESC LIMIT 1");
        String code="C001";
        if (set.next()){
            String temp=set.getString(1);
            String[] cs = temp.split("C");
            int selectedId=Integer.parseInt(cs[1]);
            if (selectedId>10){
                code="C0"+(selectedId+1);
            }
        }
        return code;
    }
}
