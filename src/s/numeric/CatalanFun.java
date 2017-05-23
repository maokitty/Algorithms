package s.numeric;

import java.math.BigInteger;

/**
 * Created by liwangchun on 17/5/23.
 * 假设圆的直径是1000,000,000,000,圆心在C，在圆上做半径AC,BC，作BD垂直于AC，使得 |bd|=1,且角bca小于90度 求AD
      AD=(AC-CD)=(AC-根号下(BC^2-BD^2))
      http://people.csail.mit.edu/devadas/numerics_demo/chord.html
 */
public class CatalanFun {
    public static void main(String[] args) {
        CatalanFun cf = new CatalanFun();
        String value=cf.generateNumber();
        System.out.println(value);
    }
    public  String generateNumber(){
        BigInteger ten = new BigInteger("10",10);
        CatalanFuc cf = new CatalanFuc(ten.pow(12));
        IncrementalNewton ct=new IncrementalNewton(1,1024,cf);
        ct.newtonMagic();
        return ct.toString();
    }

    private interface Function{
        BigInteger fx(BigInteger x,int precision);
        BigInteger dfx(BigInteger x,int precision);
    }

    private class CatalanFuc implements  Function{
        private BigInteger ten = new BigInteger("10",10);
        private BigInteger two = new BigInteger("2",10);
        private BigInteger rn; //初始值

        public CatalanFuc(BigInteger initValue){
           this.rn = initValue;
        }
        @Override
        public BigInteger fx(BigInteger x, int precision) {
            // f(x) = x**2 - n * x + 1 = x * (x - n) + 1
            BigInteger multiplier = ten.pow(precision);
            BigInteger scaledn=rn.multiply(multiplier);
            BigInteger z=x.multiply(x.subtract(scaledn)).add(multiplier.pow(2));
            return z;
        }

        @Override
        public BigInteger dfx(BigInteger x, int precision) {
            // df(x)/dx = 2 * x - n
            BigInteger scaledn=rn.multiply(ten.pow(precision));
            BigInteger z = x.multiply(two).subtract(scaledn);
            return z;
        }
    }

    private class IncrementalNewton{
        private BigInteger x;//存储计算的结果
        private int precision;
        private Function f;
        public IncrementalNewton(Integer initial,int precision,Function f){
            this.x = new BigInteger(initial.toString(),10);
            this.precision = precision;
            this.f = f;
        }
        public void newtonMagic() {
            while (true){
                BigInteger fatx=f.fx(x, precision);
                BigInteger dfatx=f.dfx(x, precision);
                BigInteger xn=x.subtract(fatx.divide(dfatx));
                if (xn.compareTo(x)==0){
                    return;
                }
                x=xn;
            }
        }

        @Override
        public String toString() {
            String strsult=x.toString();
            StringBuilder num = new StringBuilder("0.");
            int i=0;
            while (i++<precision-strsult.length()){
                num.append("0");
            }
            num.append(strsult);
            return num.toString();
        }
    }
}
