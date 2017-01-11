package khasbatov;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ipAddresses {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String first_ip = reader.readLine();
        String last_ip = reader.readLine();

        int[] first_ip_arr = stringParser(first_ip);
        int[] last_ip_arr = stringParser(last_ip);

        long first = ipArrToLong(first_ip_arr);
        long last = ipArrToLong(last_ip_arr);

        while (first<last-1) {
            first++;
            System.out.println(longToString(first));
        }
    }

    public static long ipArrToLong(int [] ip_arr) {

        return (Long.valueOf(ip_arr[0]) << 24) +
                (Long.valueOf(ip_arr[1]) << 16) +
                (Long.valueOf(ip_arr[2]) << 8) +
                (Long.valueOf(ip_arr[3]));
    }

    public static String longToString(long val) {

        StringBuffer buffer = new StringBuffer();
        buffer.append((val & 0xFF000000) >> 24).append('.');
        buffer.append((val & 0x00FF0000) >> 16).append('.');
        buffer.append((val & 0x0000FF00) >> 8).append('.');
        buffer.append(val & 0x000000FF);
        return buffer.toString();
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
        int [] first_ip = new int[4];
        for (int i = 0; i < 4; i++) {
            first_ip[i] = Integer.parseInt(ip_list.get(i));
        }
        return first_ip;
    }
}