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

    public static void main(String[] args) throws IOException {

        final int MIN_IP_VALUE = 0;
        final int MAX_IP_VALUE = 255;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String first_ip = reader.readLine();
       // String last_ip = reader.readLine();

        List<String> ip_list = new ArrayList<String>();


        String ip_block="";
        for(int i=0; i<first_ip.length(); i++){

            if(!first_ip.substring(i,i+1).equals(".")){

                ip_block = ip_block.concat(first_ip.substring(i,i+1));
            } else {
                ip_list.add(ip_block);
                ip_block = "";
            }

            if(i == first_ip.length()-1){
                ip_list.add(ip_block);
            }
            System.out.println(ip_block);
        }

        System.out.println(ip_list);

    }


    }


