package khasbatov;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ipAddressesTest {

    ipAddresses ip = new ipAddresses();

    @Test
    public void ipArrToLong() throws Exception {

        int [] arr_1 = {10,10,10,10};
        int [] arr_2 = {19,16,1,24};

        assertEquals(168430090, ip.ipArrToLong(arr_1));
        assertEquals(319815960, ip.ipArrToLong(arr_2));
    }

    @Test
    public void longToString() throws Exception {

        assertEquals("10.10.10.10", ip.longToString(168430090));
        assertEquals("1.132.103.185", ip.longToString(25454521));
    }

    @Test
    public void stringParser() throws Exception {

        int [] arr_1 = {10,10,10,10};
        int [] arr_2 = {192,168,217,24};

        assertEquals(true, java.util.Arrays.equals(arr_1, ip.stringParser("10.10.10.10")));
        assertEquals(false, java.util.Arrays.equals(arr_2, ip.stringParser("10.10.10.10")));

        assertEquals(true, java.util.Arrays.equals(arr_2, ip.stringParser("192.168.217.24")));
        assertEquals(false, java.util.Arrays.equals(arr_1, ip.stringParser("192.168.217.24")));

    }

}

