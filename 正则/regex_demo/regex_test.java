package regex_demo;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class regex_test {
    public static List<Map<String,String>> address(String address){
        //正则表达式
        String regex="(?<nation>[^国]+共和国|)(?<province>[^省]+省|)(?<city>[^市]+市|)(?<country>[^区]+区|)(?<town>[^街]+街|.+镇)(?<village>.*)";
        //获取matcher对象
        Matcher m= Pattern.compile(regex).matcher(address);
        String province=null,city=null,country=null,town=null,village=null,nation=null;
        List<Map<String,String>> table=new ArrayList<Map<String, String>>();
        Map<String,String> row=null;
        while (m.find()){
            row=new LinkedHashMap<String, String>();
            nation=m.group("nation");
            row.put("nation",nation==null?"":nation.trim());
            province=m.group("province");
            row.put("province",province==null?"":province.trim());
            city=m.group("city");
            row.put("city",city==null?"":city.trim());
            country=m.group("country");
            row.put("country",country==null?"":country.trim());
            town=m.group("town");
            row.put("town",town==null?"":town.trim());
            village=m.group("village");
            row.put("village",village==null?"":village.trim());
            table.add(row);
        }
        return table;
    }

    public static void main(String[] args) {
        //List<Map<String,String>> table=addressResolution("中华人名共和国吉林省长春市二道区临河街万兴小区4栋2门");
        List<Map<String,String>> table=address("中华人名共和国吉林省河北省石家庄市武林区砂石街河东小区8栋1单元");
        System.out.println(table);
        System.out.println(table.get(0).get("nation"));
        System.out.println(table.get(0).get("province"));
        System.out.println(table.get(0).get("city"));
        System.out.println(table.get(0).get("country"));
        System.out.println(table.get(0).get("town"));
        System.out.println(table.get(0).get("village"));
    }
}
