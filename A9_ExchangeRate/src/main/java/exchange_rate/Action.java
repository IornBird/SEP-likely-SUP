package exchange_rate;

public class Action {
    private static final ExchangeRateService SERVICE = new ExchangeRateService(
            Cal_main.dollars,
            new double[]{1, 29.42, 124.819687, 0.913381, 6.347357}
    );

    static void convert(){
        Cal_main app = Cal_main.getInstance();
        try {
            String from = app.from.getValue();
            String to = app.to.getValue();
            double inp = Double.valueOf(app.inp.getText());
            double ret = SERVICE.convert(inp, from, to);

            app.ans.setText(inp + from + " = " + ret + to);
        } catch(NumberFormatException n){
        }
    }

    static void exchange(){
        Cal_main app = Cal_main.getInstance();
        String from = app.from.getValue(),
                to = app.to.getValue();
        app.from.setValue(to);
        app.to.setValue(from);
    }
}
