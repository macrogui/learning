import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternTest {
    public static void main(String[] args) {
        PatternTest patternTest = new PatternTest();
        patternTest.test5();
    }

    public void test5(){
        String content = "310101199003070991";
        String rgex = "^[1-9][0-9]{5}(18|19|20)[0-9]{2}((0[1-9])|(1[0-2]))(([0-2][1-9])|10|20|30|31)[0-9]{3}[0-9Xx]$";
        Pattern p = Pattern.compile(rgex);
        Matcher matcher = p.matcher(content);
        if (matcher.find()) {
            String group = matcher.group(0);
            System.out.println(group);
        }
    }

    public void test4(){
        String content = "{&NULL_VERIFICATION}";
        String rgex = "\\{\\&(.*?)\\}";
        Pattern p = Pattern.compile(rgex);
        Matcher matcher = p.matcher(content);
        if (matcher.find()) {
            String group = matcher.group(1);
            System.out.println(group);
        }
    }

    public void test1(){
        Pattern p = Pattern.compile("a*b");
        Matcher m = p.matcher("aaaaab");
        boolean b = m.matches();
        boolean c = m.matches();
        System.out.println(b);
    }
    public void test2(){
        String content = "I am noob from runoob.com.";

        String pattern = ".+runoob";

        boolean isMatch = Pattern.matches(pattern, content);
        System.out.println("字符串中是否包含了 'runoob' 子字符串? " + isMatch);

        Pattern r = Pattern.compile(pattern);
        Matcher matcher = r.matcher(content);
        System.out.println(matcher.find());
        System.out.println(matcher.group(0));
        content = matcher.replaceAll("xxx");
        System.out.println(content);
        // 按指定模式在字符串查找
//        String line = "This order was placed for QT3000! OK?";
//        String pattern = "(\\D*)(\\d+)(.*)";
//
//        // 创建 Pattern 对象
//        Pattern r = Pattern.compile(pattern);
//
//        // 现在创建 matcher 对象
//        Matcher m = r.matcher(line);
//        if (m.find( )) {
//            System.out.println("Found value: " + m.group(0) );
//            System.out.println("Found value: " + m.group(1) );
//            System.out.println("Found value: " + m.group(2) );
//            System.out.println("Found value: " + m.group(3) );
//        } else {
//            System.out.println("NO MATCH");
//        }
    }
    public void test3(){
        Map<String, String> sqlParamsMap = new HashMap<>();
        sqlParamsMap.put("db", "default");
        sqlParamsMap.put("table", "table");
        sqlParamsMap.put("filter", "x>1");
        sqlParamsMap.put("field", "field");
        String content = "select * from ${db}.${table} where (${filter}) and (${field} is null)";
        String rgex = "\\$\\{(.*?)\\}";
        Pattern pattern = Pattern.compile(rgex);
        Matcher m = pattern.matcher(content);
//        int index = 1;
        StringBuffer sb = new StringBuffer();
        while (m.find()) {
            String paramName = m.group(1);
            m.appendReplacement(sb, sqlParamsMap.get(paramName));
            System.out.println(paramName);
//            index++;
        }
        m.appendTail(sb);
        System.out.println(sb.toString());
//        String s = m.replaceAll("?");
//        System.out.println(s);
//
//        StringBuilder newSql = new StringBuilder(s);
//        int paramLoc = 1;


//        StringBuffer sb = new StringBuffer();
//        while (m.find()) {
//            m.appendReplacement(sb, "dog");
//            System.out.println(sb.toString());
//        }
//        m.appendTail(sb);
//        System.out.println(sb.toString());



//        while (getCharIndexFromSqlByParamLocation(s, '?', paramLoc) > 0) {
//            // check the user has set the needs parameters
//            if (sqlParamsMap.containsKey(paramLoc)) {
//                int tt = getCharIndexFromSqlByParamLocation(newSql.toString(), '?', 1);
//                newSql.deleteCharAt(tt);
//                newSql.insert(tt, parameters.get(paramLoc).getValue());
//            }
//            paramLoc++;
//        }
    }
    private static int getCharIndexFromSqlByParamLocation(final String sql, final char cchar,
                                                          final int paramLoc) {
        int signalCount = 0;
        int charIndex = -1;
        int num = 0;
        for (int i = 0; i < sql.length(); i++) {
            char c = sql.charAt(i);
            if (c == '\'' || c == '\\')// record the count of char "'" and char "\"
            {
                signalCount++;
            } else if (c == cchar && signalCount % 2 == 0) {// check if the ? is really the parameter
                num++;
                if (num == paramLoc) {
                    charIndex = i;
                    break;
                }
            }
        }
        return charIndex;
    }
}
