package khasbatov;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ruslan on 10.01.17.
 */
public class ipAddresses {

    final int MIN_IP_VALUE = 0;
    final int MAX_IP_VALUE = 255;

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String first_ip = reader.readLine();
        String last_ip = reader.readLine();

        int [] first_ip_arr = stringParser(first_ip);
        int [] last_ip_arr = stringParser(last_ip);

    }


    public static int[] stringParser(String string){

        List<String> ip_list = new ArrayList<String>();
        String ip_block="";
        for(int i=0; i<string.length(); i++){

            if(!string.substring(i,i+1).equals(".")){
                ip_block = ip_block.concat(string.substring(i,i+1));
            } else {
                ip_list.add(ip_block);
                ip_block = "";
            }

            if(i == string.length()-1){
                ip_list.add(ip_block);
            }
        }
        System.out.println(ip_list);

        int [] first_ip = new int[4];
        for (int i = 0; i < 4; i++) {
            first_ip[i]=Integer.parseInt(ip_list.get(i));
        }

        return first_ip;

    }

}


