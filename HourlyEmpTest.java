/*
 *  HourlyEmpTest.java
 *  Test cases for hourly employees in Assignment 3, AUCSC 112 Lab
 *
 *  by R. Heise
 *  Feb. 10, 2023 (modified Feb. 12, 2024 to make it run under IntelliJ)
 *
 */

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

class HourlyEmpTest {

    //==========================================================================
    /*
     * Tests of calcGrossPay method, of class HourlyEmp.
     */
    @Test
    public void testCalcGrossPay60000() {
        System.out.println("calcGrossPay");
        HourlyEmp instance = new HourlyEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                36.23, 2, 3, 2000);
        instance.setHoursWorked(140);
        double expResult = 5072.20;
        double result = instance.calcGrossPay();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.getGrossPay(), 0.01);
    }
    @Test
    public void testCalcGrossPay60000WithOver1() {
        System.out.println("calcGrossPay");
        HourlyEmp instance = new HourlyEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                36.23, 2, 3, 2000);
        instance.setHoursWorked(141);
        double expResult = 5126.55;
        double result = instance.calcGrossPay();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.getGrossPay(), 0.01);
    }
    @Test
    public void testCalcGrossPay60000WithOver2() {
        System.out.println("calcGrossPay");
        HourlyEmp instance = new HourlyEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                36.23, 2, 3, 2000);
        instance.setHoursWorked(147);
        double expResult = 5452.62;
        double result = instance.calcGrossPay();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.getGrossPay(), 0.01);
    }
    @Test
    public void testCalcGrossPay60000WithDoubleOver() {
        System.out.println("calcGrossPay");
        HourlyEmp instance = new HourlyEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                36.23, 2, 3, 2000);
        instance.setHoursWorked(147.5);
        double expResult = 5488.84;
        double result = instance.calcGrossPay();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.getGrossPay(), 0.01);
    }

    @Test
    public void testCalcGrossPay60000WithDoubleOverMore() {
        System.out.println("calcGross Pay");
        HourlyEmp instance = new HourlyEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                47.23, 2, 3, 2000);
        instance.setHoursWorked(180);
        calcPriorItems(instance); //gPay = 8501.40
        instance.calcGrossPay();
        double expResult = 10225.30;
        assertEquals(expResult, instance.getGrossPay(), 0.01);
    }

    @Test
    public void testCalcGrossPay13999() {
        System.out.println("calcGrossPay");
        HourlyEmp instance = new HourlyEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                15.65, 2, 3, 2000);
        instance.setHoursWorked(74.5);
        double expResult = 1165.93;
        double result = instance.calcGrossPay();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.getGrossPay(), 0.01);
    }

    //==========================================================================
    /*
     * Tests of calculating tax method, of class HourlyEmp, inherited from
     * Employee.
     */
    @Test
    public void testCalcTax60000() {
        System.out.println("calcTax");
        HourlyEmp instance = new HourlyEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                36.23, 2, 3, 2000);
        instance.setHoursWorked(147);
        instance.calcGrossPay();
        double expResult = 1145.05;
        double result = instance.calcTax();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.getTax(), 0.01);
    }
    @Test
    public void testCalcTax14000() {
        System.out.println("calcTax");
        HourlyEmp instance = new HourlyEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                15.00, 2, 3, 2000);
        instance.setHoursWorked(78);
        instance.calcGrossPay();
        double expResult = 175.50;
        double result = instance.calcTax();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.getTax(), 0.01);
    }
    @Test
    public void testCalcTax13999() {
        System.out.println("calcTax");
        HourlyEmp instance = new HourlyEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                15.00, 2, 3, 2000);
        instance.setHoursWorked(77);
        instance.calcGrossPay();
        double expResult = 0.0;
        double result = instance.calcTax();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.getTax(), 0.01);
    }
    @Test
    public void testCalcTax49999() {
        System.out.println("calcTax");
        HourlyEmp instance = new HourlyEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                25.85, 2, 3, 2000);
        instance.setHoursWorked(152);
        instance.calcGrossPay();
        double expResult = 622.34;
        double result = instance.calcTax();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.getTax(), 0.01);
    }
    @Test
    public void testCalcTax50000() {
        System.out.println("calcTax");
        HourlyEmp instance = new HourlyEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                36.00, 2, 3, 2000);
        instance.setHoursWorked(115.75);
        instance.calcGrossPay();
        double expResult = 875.07;
        double result = instance.calcTax();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.getTax(), 0.01);
    }
    @Test
    public void testCalcTax99999() {
        System.out.println("calcTax");
        HourlyEmp instance = new HourlyEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                60.20, 2, 3, 2000);
        instance.setHoursWorked(138);
        instance.calcGrossPay();
        double expResult = 1744.60;
        double result = instance.calcTax();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.getTax(), 0.01);
    }
    @Test
    public void testCalcTax100000() {
        System.out.println("calcTax");
        HourlyEmp instance = new HourlyEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                45.50, 2, 3, 2000);
        instance.setHoursWorked(163.5);
        instance.calcGrossPay();
        double expResult = 2170.81;
        double result = instance.calcTax();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.getTax(), 0.01);
    }
    @Test
    public void testCalcTax149999() {
        System.out.println("calcTax");
        HourlyEmp instance = new HourlyEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                200.00, 2, 3, 2000);
        instance.setHoursWorked(62.25);
        instance.calcGrossPay();
        double expResult = 3237.00;
        double result = instance.calcTax();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.getTax(), 0.01);
    }
    @Test
    public void testCalcTax150000() {
        System.out.println("calcTax");
        HourlyEmp instance = new HourlyEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                200.00, 2, 3, 2000);
        instance.setHoursWorked(62.5);
        instance.calcGrossPay();
        double expResult = 3625.00;
        double result = instance.calcTax();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.getTax(), 0.01);
    }

    //==========================================================================
    /*
     * Tests of calculating ei method, of class HourlyEmp, inherited from
     * Employee.
     */
    @Test
    public void testCalcEiOverMax() {
        System.out.println("CalcEi");
        HourlyEmp instance = new HourlyEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                36.23, 2, 3, 2000);
        instance.setHoursWorked(147);
        instance.calcGrossPay(); //5452.62
        double expResult = 74.17; //Max reached
        double result = instance.calcEi();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.getEi(), 0.01);
    }
    @Test
    public void testCalcEi14000() {
        System.out.println("CalcEi");
        HourlyEmp instance = new HourlyEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                15.00, 2, 3, 2000);
        instance.setHoursWorked(78);
        instance.calcGrossPay(); //1170.00
        double expResult = 18.49;
        double result = instance.calcEi();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.getEi(), 0.01);
    }


    //==========================================================================
    /*
     * Tests of calculating cpp method, of class HourlyEmp, inherited from
     * Employee.
     */
    @Test
    public void testCalcCppOverMax() {
        System.out.println("calcCpp");
        HourlyEmp instance = new HourlyEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                36.23, 2, 3, 2000);
        instance.setHoursWorked(147);
        instance.calcGrossPay(); //5452.62
        double expResult = 266.67;
        double result = instance.calcCpp();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.getCpp(), 0.01);
    }
    @Test
    public void testCalcCpp14000() {
        System.out.println("calcCpp");
        HourlyEmp instance = new HourlyEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                15.00, 2, 3, 2000);
        instance.setHoursWorked(78);
        instance.calcGrossPay(); //1170.00
        double expResult = 63.77;
        double result = instance.calcCpp();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.getCpp(), 0.01);
    }

    //==========================================================================
    /*
     * Tests of calculating net pay method, of class HourlyEmp, inherited from
     * Employee.
     */
    @Test
    public void testCalcNetPay122703() {
        System.out.println("calcNetPay");
        HourlyEmp instance = new HourlyEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                47.23, 2, 3, 2000);
        instance.setHoursWorked(180);
        calcPriorItems(instance); //gPay = 10225.30 cpp = 266.67 ei = 74.17
        //tax = 2658.67
        instance.calcNetPay();
        double expResult = 7225.88; //Net pay
        assertEquals(expResult, instance.getNetPay(), 0.01);
    }
    @Test
    public void testCalcNetPay14000() {
        System.out.println("calcNetPay");
        HourlyEmp instance = new HourlyEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                15.00, 2, 3, 2000);
        instance.setHoursWorked(78);
        calcPriorItems(instance);
        instance.calcNetPay();
        double expResult = 912.24; //Net pay
        assertEquals(expResult, instance.getNetPay(), 0.01);
    }

    public void calcPriorItems(HourlyEmp instance){
        instance.calcGrossPay();
        instance.calcEi();
        instance.calcCpp();
        instance.calcTax();
    }

    //==========================================================================
    /*
     * Tests of printing pay info, of class HourlyEmp, inherited from
     * Employee.
     */
    @Test
    public void testPrintMid() {
        System.out.println("PrintMid");

        //Set up the capture of the output, from standard out
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        //Here is the actual test starting
        HourlyEmp instance = new HourlyEmp("Jon Doe",
                "4112 66 St\r\nCamrose, AB",
                75.00, 2, 3, 2000);

        instance.printPayCheque(60); //Output captured in outContent
        String expResult = //top line and id num removed
                "Jon Doe\r\n" +
                        "4112 66 St\r\n" +
                        "Camrose, AB\r\n" +
                        "--------------------------------------------\r\n" +
                        "   Hours worked: 60.00   Rate: 75.00\r\n" +
                        "--------------------------------------------\r\n" +
                        "   Gross Pay:     4500.00\r\n" +
                        "   Tax:            945.00\r\n" +
                        "   CPP:            245.25\r\n" +
                        "   EI:              71.10\r\n" +
                        "\r\n" +
                        "   Net Pay:       3238.65\r\n" +
                        "===============================================\r\n";
        System.setOut(originalOut);
        String savedOut = removeIdNum(outContent.toString());
        assertEquals(expResult, savedOut);

        //Restore standard out
        System.setOut(originalOut);
    }


    /**
     * Strips off the id num of the pay check.  Done by removing the first
     * two lines.
     * @param original - pay check string with id num
     * @return - pay check string without id num
     *
     * Note:  I have left it to print the actual string that is left
     * so that someone can see the literal values that they have.
     * Note 2:  If someone has trouble, and the output "looks" the same,
     * just check that each and every line ends in \r\n (Windows end of
     * line).
     */
    public String removeIdNum(String original){
        String newString = "";
        int index = 0;

        try{
            //move over first '\n'
            while(original.charAt(index) != '\n'){
                index++;
            }
            index++; //go past '\n'
            //move over 2nd '\n'
            while(original.charAt(index) != '\n'){
                index++;
            }
            index++; //go past '\n'

            while(index < original.length()){
                if (original.charAt(index) == '\n'){
                    System.out.println();
                }
                else if (original.charAt(index) < ' ') {
                    System.out.println("'" + (int) original.charAt(index)
                            + "'");
                }
                else {
                    System.out.println("'" + original.charAt(index) + "'");
                }
                newString = newString + original.charAt(index);
                index++;
            }
            return newString;
        }
        catch (Exception e){return "";}
    }

    //==========================================================================

    /**
     * Test of setHoursWorked method, of class HourlyEmp.
     */
    @Test
    public void testSetHoursWorked() {
        System.out.println("setHoursWorked");
        double hours = 0.0;
        HourlyEmp instance = new HourlyEmp();
        instance.setHoursWorked(hours);
        assertEquals(hours, instance.getHoursWorked());
    }

    //==========================================================================
}