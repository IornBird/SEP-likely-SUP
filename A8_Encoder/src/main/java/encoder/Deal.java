package encoder;

import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;

import java.io.*;

public class Deal {
    static void d(int i) throws IOException {//,,,"複製",
        File f = new File("encoded_text.txt");
        switch (i){
            case 0: //新建
                if(f.exists()){
                    coder_main.message.setText("新建失敗");
                }else{
                    f.createNewFile();
                    coder_main.message.setText("已新建");
                }
                return;
            case 1: //存檔
                if(coder_main.out.getText().isEmpty()){
                    coder_main.message.setText("存檔失敗");
                } else {
                    BufferedWriter bf = new BufferedWriter(new FileWriter(f));
                    bf.append(coder_main.out.getText());
                    bf.flush();
                    bf.close();
                    coder_main.message.setText("已存檔");
                }
                return;
            case 2: //編碼
                String in=coder_main.inp.getText();
                if(in.isEmpty()){
                    coder_main.message.setText("編碼失敗");
                    return;
                }
                String out="";
                byte buffer[]=in.getBytes();
                for(byte b:buffer){
                    out+=String.valueOf(b);
                }
                coder_main.out.setText(out);
                coder_main.message.setText("已編碼");
                return;
            case 3: //複製
                if(coder_main.out.getText().isEmpty()){
                    coder_main.message.setText("複製失敗");
                }else {
                    Clipboard c = Clipboard.getSystemClipboard();
                    ClipboardContent cc =new ClipboardContent();
                    cc.putString(coder_main.out.getText());
                    c.setContent(cc);
                    coder_main.message.setText("已複製");
                }
                return;
            case 4: //清空
                coder_main.inp.setText("");
                coder_main.out.setText("");
                coder_main.message.setText("已清空");
                return;
        }
    }
}
