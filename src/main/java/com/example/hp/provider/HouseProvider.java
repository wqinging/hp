package com.example.hp.provider;

import com.example.hp.domian.Page;
import org.springframework.util.StringUtils;

import java.util.List;


public class HouseProvider {

    public String findHouse(String subArg,  String typeArg, Page page){
        String sql = "select * from house where 1=1 ";
		StringBuffer sb = new StringBuffer(sql);
		if (!StringUtils.isEmpty(subArg)) {
		    sb.append(" and subway like " + " concat('%','" + subArg + "','%')");
		}
		if (!StringUtils.isEmpty(typeArg)) {
			if (typeArg.equals("4室以上")) {
				sb.append(
						" and house_type NOT LIKE CONCAT('%','1室','%') AND house_type NOT LIKE CONCAT('%','2室','%') AND house_type NOT LIKE CONCAT('%','3室','%') AND house_type NOT LIKE CONCAT('%','4室','%')");
			} else {
				sb.append(" and house_type like concat('%','" + typeArg + "','%')");
			}
		}
		sb.append(" limit " + page.getPage() + "," + page.getSize());
        return sb.toString();
    }

    public String countHouse(String subArg, String typeArg){
        int count = 0;
		String sql = "select count(*) from house where 1=1 ";
		StringBuffer sb = new StringBuffer(sql);
		if (!StringUtils.isEmpty(subArg)) {
		    sb.append(" and subway like " + " concat('%','" + subArg + "','%')");
		}
		if (!StringUtils.isEmpty(typeArg)) {
			if (typeArg.equals("4室以上")) {
				sb.append(
						" and house_type NOT LIKE CONCAT('%','1室','%') AND house_type NOT LIKE CONCAT('%','2室','%') AND house_type NOT LIKE CONCAT('%','3室','%') AND house_type NOT LIKE CONCAT('%','4室','%')");
			} else {
				sb.append(" and house_type like concat('%','" + typeArg + "','%')");
			}
		}
        return sb.toString();
    }

    public String getByIdIn(List<Integer> ids){
		String sql = "select * from house where id in ( ";
		StringBuffer sb = new StringBuffer(sql);
		for(Integer id : ids){
			sb.append(id).append(",");
		}
		int index = sb.lastIndexOf(",");
		sb.delete(index,index);
		sb.append(")");
		return sb.toString();
	}

}
