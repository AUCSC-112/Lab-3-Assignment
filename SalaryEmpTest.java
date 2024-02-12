import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

class SalaryEmpTest {
    //==========================================================================
    /*
     * Tests of calcGrossPay method, of class SalaryEmp.
     */
    @Test
    public void testCalcGrossPay60000() {
        System.out.println("calcGrossPay");
        SalaryEmp instance = new SalaryEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                60000, 2, 3, 2000);
        double expResult = 5000.00;
        double result = instance.calcGrossPay();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.getGrossPay(), 0.01);
    }
    @Test
    public void testCalcGrossPay15000() {
        System.out.println("calcGrossPay");
        SalaryEmp instance = new SalaryEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                15000, 2, 3, 2000);
        double expResult = 1250.00;
        double result = instance.calcGrossPay();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.getGrossPay(), 0.01);
    }
    @Test
    public void testCalcGrossPay13999() {
        System.out.println("calcGrossPay");
        SalaryEmp instance = new SalaryEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                13999.99, 2, 3, 2000);
        double expResult = 1166.67;
        double result = instance.calcGrossPay();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.grossPay, 0.01);
    }

    //==========================================================================   
    /*
     * Tests of calculating tax method, of class SalaryEmp, inherited from
     * Employee.
     */
    @Test
    public void testCalcTax60000() {
        System.out.println("calcTax");
        SalaryEmp instance = new SalaryEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                60000, 2, 3, 2000);
        instance.calcGrossPay();
        double expResult = 1050.00;
        double result = instance.calcTax();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.getTax(), 0.01);
    }
    @Test
    public void testCalcTax14000() {
        System.out.println("calcTax");
        SalaryEmp instance = new SalaryEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                14000, 2, 3, 2000);
        instance.calcGrossPay();
        double expResult = 175.00;
        double result = instance.calcTax();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.getTax(), 0.01);
    }
    @Test
    public void testCalcTax13999() {
        System.out.println("calcTax");
        SalaryEmp instance = new SalaryEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                13999.99, 2, 3, 2000);
        instance.calcGrossPay();
        double expResult = 0.0;
        double result = instance.calcTax();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.getTax(), 0.01);
    }
    @Test
    public void testCalcTax49999() {
        System.out.println("calcTax");
        SalaryEmp instance = new SalaryEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                49999.99, 2, 3, 2000);
        instance.calcGrossPay();
        double expResult = 625.0;
        double result = instance.calcTax();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.getTax(), 0.01);
    }
    @Test
    public void testCalcTax50000() {
        System.out.println("calcTax");
        SalaryEmp instance = new SalaryEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                50000, 2, 3, 2000);
        instance.calcGrossPay();
        double expResult = 875.0;
        double result = instance.calcTax();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.getTax(), 0.01);
    }
    @Test
    public void testCalcTax99999() {
        System.out.println("calcTax");
        SalaryEmp instance = new SalaryEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                99999.99, 2, 3, 2000);
        instance.calcGrossPay();
        double expResult = 1750.0;
        double result = instance.calcTax();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.getTax(), 0.01);
    }
    @Test
    public void testCalcTax100000() {
        System.out.println("calcTax");
        SalaryEmp instance = new SalaryEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                100000, 2, 3, 2000);
        instance.calcGrossPay();
        double expResult = 2166.67;
        double result = instance.calcTax();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.getTax(), 0.01);
    }
    @Test
    public void testCalcTax149999() {
        System.out.println("calcTax");
        SalaryEmp instance = new SalaryEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                149999.99, 2, 3, 2000);
        instance.calcGrossPay();
        double expResult = 3250;
        double result = instance.calcTax();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.getTax(), 0.01);
    }
    @Test
    public void testCalcTax150000() {
        System.out.println("calcTax");
        SalaryEmp instance = new SalaryEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                150000, 2, 3, 2000);
        instance.calcGrossPay();
        double expResult = 3625;
        double result = instance.calcTax();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.getTax(), 0.01);
    }

    //==========================================================================
    /*
     * Tests of calculating ei method, of class SalaryEmp, inherited from
     * Employee.
     */
    @Test
    public void testCalcEi18000() {
        System.out.println("CalcEi");
        SalaryEmp instance = new SalaryEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                18000, 2, 3, 2000);
        instance.calcGrossPay();
        double expResult = 23.70;
        double result = instance.calcEi();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.getEi(), 0.01);
    }
    @Test
    public void testCalcEi14004() {
        System.out.println("CalcEi");
        SalaryEmp instance = new SalaryEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                14004, 2, 3, 2000);
        instance.calcGrossPay();
        double expResult = 18.44;
        double result = instance.calcEi();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.getEi(), 0.01);
    }
    @Test
    public void testCalcEi13999() {
        System.out.println("CalcEi");
        SalaryEmp instance = new SalaryEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                13999.99, 2, 3, 2000);
        instance.calcGrossPay();
        double expResult = 18.43;
        double result = instance.calcEi();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.getEi(), 0.01);
    }
    @Test
    public void testCalcEi49999() {
        System.out.println("CalcEi");
        SalaryEmp instance = new SalaryEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                49999.99, 2, 3, 2000);
        instance.calcGrossPay();
        double expResult = 65.83;
        double result = instance.calcEi();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.getEi(), 0.01);
    }
    @Test
    public void testCalcEi50000() {
        System.out.println("CalcEi");
        SalaryEmp instance = new SalaryEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                50000, 2, 3, 2000);
        instance.calcGrossPay();
        double expResult = 65.83;
        double result = instance.calcEi();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.getEi(), 0.01);
    }
    @Test
    public void testCalcEi99999() {
        System.out.println("CalcEi");
        SalaryEmp instance = new SalaryEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                99999.99, 2, 3, 2000);
        instance.calcGrossPay();
        double expResult = 74.17;
        double result = instance.calcEi();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.getEi(), 0.01);
    }
    @Test
    public void testCalcEi100000() {
        System.out.println("CalcEi");
        SalaryEmp instance = new SalaryEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                100000, 2, 3, 2000);
        instance.calcGrossPay();
        double expResult = 74.17;
        double result = instance.calcEi();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.getEi(), 0.01);
    }
    @Test
    public void testCalcEi149999() {
        System.out.println("CalcEi");
        SalaryEmp instance = new SalaryEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                149999.99, 2, 3, 2000);
        instance.calcGrossPay();
        double expResult = 74.17;
        double result = instance.calcEi();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.getEi(), 0.01);
    }
    @Test
    public void testCalcEi150000() {
        System.out.println("CalcEi");
        SalaryEmp instance = new SalaryEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                150000, 2, 3, 2000);
        instance.calcGrossPay();
        double expResult = 74.17;
        double result = instance.calcEi();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.getEi(), 0.01);
    }

    //This one checks max
    @Test
    public void testCalcEiOverMax() {
        System.out.println("CalcEi");
        SalaryEmp instance = new SalaryEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                500000, 2, 3, 2000);
        instance.calcGrossPay();  //EI is 658.33 per month
        double expResult = 74.17;
        double result = instance.calcEi();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.getEi(), 0.01);
    }

    //==========================================================================
    /*
     * Tests of calculating cpp method, of class SalaryEmp, inherited from
     * Employee.
     */
    @Test
    public void testCalcCpp56000() {
        System.out.println("calcCpp");
        SalaryEmp instance = new SalaryEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                56000, 2, 3, 2000);
        instance.calcGrossPay();
        double expResult = 254.33;
        double result = instance.calcCpp();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.getCpp(), 0.01);
    }
    @Test
    public void testCalcCpp14000() {
        System.out.println("calcCpp");
        SalaryEmp instance = new SalaryEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                14000, 2, 3, 2000);
        instance.calcGrossPay();
        double expResult = 63.58;
        double result = instance.calcCpp();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.getCpp(), 0.01);
    }
    @Test
    public void testCalcCpp13999() {
        System.out.println("calcCpp");
        SalaryEmp instance = new SalaryEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                13999.99, 2, 3, 2000);
        instance.calcGrossPay();
        double expResult = 63.58;
        double result = instance.calcCpp();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.getCpp(), 0.01);
    }
    @Test
    public void testCalcCpp49999() {
        System.out.println("calcCpp");
        SalaryEmp instance = new SalaryEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                49999.99, 2, 3, 2000);
        instance.calcGrossPay();
        double expResult = 227.08;
        double result = instance.calcCpp();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.getCpp(), 0.01);
    }
    @Test
    public void testCalcCpp50000() {
        System.out.println("calcCpp");
        SalaryEmp instance = new SalaryEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                50000, 2, 3, 2000);
        instance.calcGrossPay();
        double expResult = 227.08;
        double result = instance.calcCpp();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.getCpp(), 0.01);
    }
    @Test
    public void testCalcCpp58000() {
        System.out.println("calcCpp");
        SalaryEmp instance = new SalaryEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                58000, 2, 3, 2000);
        instance.calcGrossPay();
        double expResult = 263.42;
        double result = instance.calcCpp();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.getCpp(), 0.01);
    }
    @Test
    public void testCalcCpp100000() {
        System.out.println("calcCpp");
        SalaryEmp instance = new SalaryEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                100000, 2, 3, 2000);
        instance.calcGrossPay();
        double expResult = 266.67;
        double result = instance.calcCpp();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.getCpp(), 0.01);
    }
    @Test
    public void testCalcCpp149999() {
        System.out.println("calcCpp");
        SalaryEmp instance = new SalaryEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                149999.99, 2, 3, 2000);
        instance.calcGrossPay();
        double expResult = 266.67;
        double result = instance.calcCpp();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.getCpp(), 0.01);
    }
    @Test
    public void testCalcCpp150000() {
        System.out.println("calcCpp");
        SalaryEmp instance = new SalaryEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                150000, 2, 3, 2000);
        instance.calcGrossPay();
        double expResult = 266.67;
        double result = instance.calcCpp();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.getCpp(), 0.01);
    }

    //This one checks max
    @Test
    public void testCalcCppOverMax() {
        System.out.println("CalcCpp");
        SalaryEmp instance = new SalaryEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                500000, 2, 3, 2000);
        instance.calcGrossPay();  //cpp is 2270.83 per month
        double expResult = 266.67;
        double result = instance.calcCpp();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.getCpp(), 0.01);
    }

    //==========================================================================
    /*
     * Tests of calculating net pay method, of class SalaryEmp, inherited from
     * Employee.
     */
    @Test
    public void testCalcNetPay60000() {
        System.out.println("calcPay");
        SalaryEmp instance = new SalaryEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                60000, 2, 3, 2000);
        calcPriorItems(instance); //gPay = 5000, cpp = 266.67, ei = 74.17
        //tax = 1050
        instance.calcNetPay();
        double expResult = 3609.16; //Net pay
        assertEquals(expResult, instance.getNetPay(), 0.01);
    }
    @Test
    public void testCalcNetPay14000() {
        System.out.println("calcPay");
        SalaryEmp instance = new SalaryEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                14000, 2, 3, 2000);
        calcPriorItems(instance); //gPay = 1166.67 cpp = 63.58 ei = 18.43
        //tax = 175.00
        instance.calcNetPay();
        double expResult = 909.66; //Net pay
        assertEquals(expResult, instance.getNetPay(), 0.01);
    }
    @Test
    public void testCalcNetPay13999() {
        System.out.println("calcPay");
        SalaryEmp instance = new SalaryEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                13999.99, 2, 3, 2000);
        calcPriorItems(instance);
        instance.calcNetPay();
        double expResult = 1084.65; //Net pay
        assertEquals(expResult, instance.getNetPay(), 0.01);
    }
    @Test
    public void testCalcNetPay49999() {
        System.out.println("calcPay");
        SalaryEmp instance = new SalaryEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                49999.99, 2, 3, 2000);
        calcPriorItems(instance); //gPay = 4166.67 cpp = 227.08 ei = 65.83
        //tax = 625.00
        instance.calcNetPay();
        double expResult = 3248.75; //Net pay
        assertEquals(expResult, instance.getNetPay(), 0.01);
    }
    @Test
    public void testCalcNetPay50000() {
        System.out.println("calcPay");
        SalaryEmp instance = new SalaryEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                50000, 2, 3, 2000);
        calcPriorItems(instance); //gPay = 4166.67 cpp = 227.08 ei = 65.83
        //tax = 875.00
        instance.calcNetPay();
        double expResult = 2998.75; //Net pay
        assertEquals(expResult, instance.getNetPay(), 0.01);
    }
    @Test
    public void testCalcNetPay99999() {
        System.out.println("calcPay");
        SalaryEmp instance = new SalaryEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                99999.99, 2, 3, 2000);
        calcPriorItems(instance); //gPay = 8333.33 cpp = 266.67 ei = 74.17
        //tax =1750.00
        instance.calcNetPay();
        double expResult = 6242.49; //Net pay
        assertEquals(expResult, instance.getNetPay(), 0.01);
    }
    @Test
    public void testCalcNetPay100000() {
        System.out.println("calcPay");
        SalaryEmp instance = new SalaryEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                100000, 2, 3, 2000);
        calcPriorItems(instance); //gPay = 8333.33 cpp = 266.67 ei = 74.17
        //tax = 2166.67
        instance.calcNetPay();
        double expResult = 5825.83; //Net pay
        assertEquals(expResult, instance.getNetPay(), 0.01);
    }
    @Test
    public void testCalcNetPay149999() {
        System.out.println("calcPay");
        SalaryEmp instance = new SalaryEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                149999.99, 2, 3, 2000);
        calcPriorItems(instance); //gPay = 12500 cpp = 266.67 ei = 74.17
        //tax = 3250
        instance.calcNetPay();
        double expResult = 8909.16; //Net pay
        assertEquals(expResult, instance.getNetPay(), 0.01);
    }
    @Test
    public void testCalcNetPay150000() {
        System.out.println("calcPay");
        SalaryEmp instance = new SalaryEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                150000, 2, 3, 2000);
        calcPriorItems(instance);  //gPay = 12500 cpp = 266.67 ei = 74.17
        //tax = 3625
        instance.calcNetPay();
        double expResult = 8534.16; //Net pay
        assertEquals(expResult, instance.getNetPay(), 0.01);
    }

    public void calcPriorItems(SalaryEmp instance){
        instance.calcGrossPay();
        instance.calcEi();
        instance.calcCpp();
        instance.calcTax();
    }

    //==========================================================================
    /*
     * Tests of printing pay info, of class SalaryEmp, inherited from
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
        SalaryEmp instance = new SalaryEmp("Jon Doe",
                "4112 66 St\r\nCamrose, AB",
                75000, 2, 3, 2000);

        instance.printPayCheque(); //Output captured in outContent
        String expResult = //top line and id num removed
                "Jon Doe\r\n" +
                        "4112 66 St\r\n" +
                        "Camrose, AB\r\n" +
                        "--------------------------------------------\r\n" +
                        "   Hours worked: 189.00   Rate: 75000.00\r\n" +
                        "--------------------------------------------\r\n" +
                        "   Gross Pay:     6250.00\r\n" +
                        "   Tax:           1312.50\r\n" +
                        "   CPP:            266.67\r\n" +
                        "   EI:              74.17\r\n" +
                        "\r\n" +
                        "   Net Pay:       4596.66\r\n" +
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
}