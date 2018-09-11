package jackson;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * �����ṩ����������Ԫ����
 * @author accountwcx@qq.com
 *
 */
public class DataBuilder {
    private static final String[] chars = new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b",
            "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w",
            "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R",
            "S", "T", "U", "V", "W", "X", "Y", "Z" };

    private static final int charNum = 62;

    // ����String��󳤶�
    private static final int maxStrLength = 100;

    // ����StringĬ�ϳ���
    private static final int defaultStrLength = 50;

    // ����List��󳤶�
    private static final int maxListSize = 100;

    // ����ListĬ�ϳ���
    private static final int defaultListSize = 10;

    // ����Map���Key����
    private static final int maxMapSize = 100;

    // ����MapĬ��Key����
    private static final int defaultMapSize = 10;

    // ����Map��Value����������
    private static final String[] types = new String[] { "boolean", "int", "long", "double", "date", "string"};
    private static final int typeNum = 6;

    private static final Random random = new Random();

    /**
     * ����������ȵ��ַ���
     * @return �ַ���
     */
    public static String randomString(){
        return randomString(random.nextInt(maxStrLength));
    }

    /**
     * ����ָ�����ȵ��ַ���
     * @param len �ַ�������
     * @return
     */
    public static String randomString(int len) {
        if (len < 1 || len > maxStrLength) {
            // ����ַ������ȳ�����Χ��ʹ��Ĭ�ϳ���
            len = defaultStrLength;
        }

        StringBuilder sb = new StringBuilder(len);

        for (int i = 0; i < len; i++) {
            sb.append(chars[random.nextInt(charNum)]);
        }

        return sb.toString();
    }

    /**
     * ����List������List��Ԫ�ص��������
     * @return
     */
    public static List<String> randomStringList() {
        return randomStringList(random.nextInt(maxListSize));
    }

    /**
     * ����List����
     * @param size List��Ԫ�ص����� 
     * @return
     */
    public static List<String> randomStringList(int size) {
        if (size < 1 || size > maxListSize) {
            size = defaultListSize;
        }

        List<String> list = new ArrayList<String>();

        for (int i = 0; i < size; i++) {
            list.add(randomString(random.nextInt(maxStrLength)));
        }

        return list;
    }

    /**
     * �������Map������������key���������
     * @return
     */
    public static Map<String, Object> randomMap() {
        return randomMap(random.nextInt(maxMapSize));
    }

    /**
     * �������Map����
     * @param size ������key������
     * @return
     */
    public static Map<String, Object> randomMap(int size) {
        if (size < 1 || size > maxMapSize) {
            size = defaultMapSize;
        }

        Map<String, Object> map = new HashMap<String, Object>();

        for (int i = 0; i < size; i++) {
            String type = types[random.nextInt(typeNum)];
            if ("boolean".equals(type)) {
                map.put("key" + i, random.nextBoolean());
            } else if ("int".equals(type)) {
                map.put("key" + i, random.nextInt());
            } else if ("long".equals(type)) {
                map.put("key" + i, random.nextLong());
            } else if ("double".equals(type)) {
                map.put("key" + i, random.nextDouble());
            } else if ("date".equals(type)) {
                map.put("key" + i, new Date());
            } else if ("string".equals(type)) {
                map.put("key" + i, randomString(random.nextInt(maxStrLength)));
            }
        }

        return map;
    }
}