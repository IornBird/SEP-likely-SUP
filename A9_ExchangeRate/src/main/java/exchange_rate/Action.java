package exchange_rate;

public class Action {
    private static final ExchangeRateService SERVICE = new ExchangeRateService(
            Cal_main.dollars,
            new double[]{1, 29.42, 124.819687, 0.913381, 6.347357}
    );

    static void convert(){
        try {
            String from = (String) Cal_main.from.getValue();
            String to = (String) Cal_main.to.getValue();
            double inp = Double.valueOf(Cal_main.inp.getText());
            double ret = SERVICE.convert(inp, from, to);

            Cal_main.ans.setText(inp + from + " = " + ret + to);
        } catch(NumberFormatException n){
        }
    }

    static void exchange(){
        Object from = Cal_main.from.getValue(),
                to  = Cal_main.to.getValue();
        Cal_main.from.setValue(to);
        Cal_main.to.setValue(from);
    }
}
