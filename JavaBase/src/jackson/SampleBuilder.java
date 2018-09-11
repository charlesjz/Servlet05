package jackson;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;

import com.alibaba.fastjson.JSON;

/**
 * ��������
 * @author accountwcx@qq.com
 *
 */
public class SampleBuilder {

    public static void main(String[] args) {
        int sampleSize = 100000;
        String jsonDataPath = "d:\\samples_json.dat";
        String objectDataPath = "d:\\samples_object.dat";

        buildJsonSamples(sampleSize, 10, 10, jsonDataPath);
        buildObjectSamples(sampleSize, 10, 10, objectDataPath);
    }

    public static List<String> loadJSONSamples(String filePath) {
        List<String> list = new LinkedList<String>();

        File file = new File(filePath);
        if (!file.exists()) {
            return list;
        }

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
            String line = br.readLine();            
            while(line != null){
                list.add(line);
                line = br.readLine();
            }           
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != br) {
                try {
                    br.close();
                } catch (IOException e) {
                }
            }
        }

        return list;
    }

    @SuppressWarnings("unchecked")
    public static List<SampleEntity> loadSamples(String filePath) {
        List<SampleEntity> list = new LinkedList<SampleEntity>();

        File file = new File(filePath);
        if (!file.exists()) {
            return list;
        }

        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(file));
            list = (List<SampleEntity>) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != ois) {
                try {
                    ois.close();
                } catch (IOException e) {
                }
            }
        }

        return list;
    }

    /**
     * ��������
     * 
     * @param sampleSize ��������
     * @param listSize ����List����
     * @param mapKeyNum ����Map��Key����
     * @return ����List
     */
    public static List<SampleEntity> buildSamples(int sampleSize, int listSize, int mapKeyNum) {
        List<SampleEntity> list = new LinkedList<SampleEntity>();
        for (int i = 0; i < sampleSize; i++) {
            list.add(new SampleEntity(listSize, mapKeyNum));
        }

        return list;
    }

    /**
     * ��Ĭ�ϲ�����������������listSizeĬ��Ϊ10��mapKeyNumĬ��Ϊ10��
     * 
     * @param sampleSize
     * @return ����List
     */
    public static List<SampleEntity> buildSamples(int sampleSize) {
        List<SampleEntity> list = new LinkedList<SampleEntity>();
        for (int i = 0; i < sampleSize; i++) {
            list.add(new SampleEntity());
        }

        return list;
    }

    /**
     * ������������������JSON���л������浽�ļ��С�
     * 
     * @param sampleSize ��������
     * @param listSize ����List����
     * @param mapKeyNum ����Map��Key������
     * @param filePath ����������ļ�·��
     */
    public static void buildJsonSamples(int sampleSize, int listSize, int mapKeyNum, String filePath) {
        File file = new File(filePath);
        File parent = file.getParentFile();
        if (!parent.exists()) {
            parent.mkdirs();
        }

        if (file.exists()) {
            file.delete();
        }

        List<SampleEntity> list = buildSamples(sampleSize, listSize, mapKeyNum);

        StringBuilder sb = new StringBuilder();
        for (SampleEntity item : list) {
            sb.append(JSON.toJSONString(item));
            sb.append("\n");
        }

        BufferedWriter bw = null;
        try {
            file.createNewFile();

            bw = new BufferedWriter(new FileWriter(file));
            bw.write(sb.toString());
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != bw) {
                try {
                    bw.close();
                } catch (IOException e) {
                }
            }
        }
    }

    public static void buildJsonSamples(int sampleSize, String filePath) {
        File file = new File(filePath);
        File parent = file.getParentFile();
        if (!parent.exists()) {
            parent.mkdirs();
        }

        if (file.exists()) {
            file.delete();
        }

        List<SampleEntity> list = buildSamples(sampleSize);

        StringBuilder sb = new StringBuilder();
        for (SampleEntity item : list) {
            sb.append(JSON.toJSONString(item));
            sb.append("\n");
        }

        BufferedWriter bw = null;
        try {
            file.createNewFile();

            bw = new BufferedWriter(new FileWriter(file));
            bw.write(sb.toString());
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != bw) {
                try {
                    bw.close();
                } catch (IOException e) {
                }
            }
        }
    }

    public static void buildObjectSamples(int sampleSize, String filePath) {
        List<SampleEntity> list = buildSamples(sampleSize);

        File file = new File(filePath);
        File parent = file.getParentFile();
        if (!parent.exists()) {
            parent.mkdirs();
        }

        if (file.exists()) {
            file.delete();
        }

        ObjectOutputStream oos = null;
        try {
            file.createNewFile();

            oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(list);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != oos) {
                try {
                    oos.close();
                } catch (IOException e) {
                }
            }
        }
    }

    /**
     * �����������󣬲����浽ָ���ļ�
     * 
     * @param sampleSize ������С
     * @param listSize ������List�ֶγ���
     * @param mapKeyNum ������Map����Key����
     * @param filePath ���������·��
     */
    public static void buildObjectSamples(int sampleSize, int listSize, int mapKeyNum, String filePath) {
        List<SampleEntity> list = buildSamples(sampleSize, listSize, mapKeyNum);

        File file = new File(filePath);
        File parent = file.getParentFile();
        if (!parent.exists()) {
            parent.mkdirs();
        }

        if (file.exists()) {
            file.delete();
        }

        ObjectOutputStream oos = null;
        try {
            file.createNewFile();

            oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(list);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != oos) {
                try {
                    oos.close();
                } catch (IOException e) {
                }
            }
        }
    }
}