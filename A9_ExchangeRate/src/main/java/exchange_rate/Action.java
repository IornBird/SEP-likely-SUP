package exchange_rate;

import java.util.Arrays;

public class Action {
    static void convert(){
        try {
            int from = Arrays.stream(Cal_main.dollars).toList().indexOf(Cal_main.from.getValue());
            int  to  = Arrays.stream(Cal_main.dollars).toList().indexOf(Cal_main.to.getValue());
            double inp = Double.valueOf(Cal_main.inp.getText());
            double ret = inp * rate[to] / rate[from];

            Cal_main.ans.setText((inp) + Cal_main.dollars[from] + " = " + (ret) + Cal_main.dollars[to]);
        } catch(NumberFormatException n){}
    }
    static void exchange(){
        Object from = Cal_main.from.getValue(),
                to  = Cal_main.to.getValue();
        Cal_main.from.setValue(to);
        Cal_main.to.setValue(from);
    }

    final static double[] rate = {
            1,29.42,124.819687,0.913381,6.347357
    };
}
