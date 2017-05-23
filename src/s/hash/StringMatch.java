package s.hash;

import java.io.*;

/**
 * Created by liwangchun on 17/4/24.
 */
public class StringMatch {
    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(new File("/path/to/file")));
            String line = br.readLine();
            while (line!=null){
                stringBuffer.append(line.toLowerCase());
                line = br.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(br!=null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        String longStr = stringBuffer.toString();
        String findStr = "java";
        RollingHash findRH = new RollingHash(findStr);
        int lenFind = findStr.length();
        int lenLong = longStr.length();
        int count = 0;
        long start = System.currentTimeMillis();
        RollingHash longRH = new RollingHash(longStr.substring(0,lenFind));
        for (int i=0;i<lenLong-lenFind+1;i++){
            if (longRH.hash() == findRH.hash()){

                if (findStr.equals(longStr.substring(i,i+lenFind)))
                  count++;
            }
            if (i+lenFind<lenLong){
                longRH.slide(longStr.charAt(i),longStr.charAt(i+lenFind));
            }
        }
        System.out.println(count+":time:"+(System.currentTimeMillis()-start));
    }
}
class RollingHash{
    private int chash;
//    private int base;
    private int prime;
//    private int magic;
    public RollingHash(String str){
//        this.base = 7;
        this.prime = 499999;

        char[] chars=str.toCharArray();
        int len = chars.length;
        int n = len-1;
//        this.magic= (int)Math.pow(this.base,len) % this.prime;
        for (char c:chars){
            this.chash+=(int)c;
            n--;
        }
    }
    public void slide(char preChar,char nextchar){
        this.chash = (this.chash-(int)preChar+(int)nextchar)%prime;
        if (this.chash<0)
        {
            this.chash += prime;
        }
    }
    public int hash(){
        return this.chash;
    }
}
