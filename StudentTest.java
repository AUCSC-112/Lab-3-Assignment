import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    //==========================================================================
    /*
     * Tests of calcGpa method, of class Student.
     */
    @Test
    void testCalcGpa0Courses() {
        System.out.println("CalcGPA no courses");
        Student instance = new Student("Puff The Magic Dragon",
                "4112 66 St \nCamrose, AB",
                2, 3, 2000);
        double expResult = 0;
        double result = instance.calcGpa();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.getGpa(), 0.01);
    }

    @Test
    void testCalcGpa1Courses() {
        System.out.println("CalcGPA 1 course");
        Student instance = new Student("Puff The Magic Dragon",
                "4112 66 St \nCamrose, AB",
                2, 3, 2000);
        instance.addCourse("AUCSC 112", 96.74);
        double expResult = 96.74;
        double result = instance.calcGpa();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.getGpa(), 0.01);
    }

    @Test
    void testCalcGpa2Courses() {
        System.out.println("CalcGPA 2 courses");
        Student instance = new Student("Puff The Magic Dragon",
                "4112 66 St \nCamrose, AB",
                2, 3, 2000);
        instance.addCourse("AUCSC 112", 96.74);
        instance.addCourse("AUCSC 111", 68.79);
        double expResult = 82.765;
        double result = instance.calcGpa();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.getGpa(), 0.01);
    }

    @Test
    void testCalcGpa3Courses() {
        System.out.println("CalcGPA 3 courses");
        Student instance = new Student("Puff The Magic Dragon",
                "4112 66 St \nCamrose, AB",
                2, 3, 2000);
        instance.addCourse("AUCSC 112", 96.74);
        instance.addCourse("AUCSC 111", 68.79);
        instance.addCourse("AUBIO 110", 72.34);
        double expResult = 79.29;
        double result = instance.calcGpa();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.getGpa(), 0.01);
    }

    @Test
    void testCalcGpa12Courses() {
        System.out.println("CalcGPA 12 courses");
        Student instance = new Student("Puff The Magic Dragon",
                "4112 66 St \nCamrose, AB",
                2, 3, 2000);
        instance.addCourse("AUCSC 112", 75);
        instance.addCourse("AUCSC 111", 78);
        instance.addCourse("AUBIO 110", 91);
        instance.addCourse("AUBWE 101", 52);

        instance.addCourse("AUPHY 111", 80);
        instance.addCourse("AUCHE 110", 72);
        instance.addCourse("AUIDS 101", 72);
        instance.addCourse("AUENG 106", 76);

        instance.addCourse("AUPED 110", 92);
        instance.addCourse("AUKIN 102", 98);
        instance.addCourse("AUCSC 218", 65);
        instance.addCourse("AUIDS 201", 94);

        double expResult = 78.75;
        double result = instance.calcGpa();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.getGpa(), 0.01);
    }

    //==========================================================================
    /*
     * Test of printReport method, of class Student.
     */
    @Test
    void printReport() {
        System.out.println("PrintReport");

        //Set up the capture of the output, from standard out
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        //Here is the actual test starting
        Student instance = new Student("Puff the Magic Dragon",
                "4112 66 St\r\nCamrose, AB",
                2, 3, 2000);
        instance.addCourse("AUCSC 112", 4);
        instance.addCourse("AUMAT 116", 3.3);
        instance.addCourse("AUCSC 111", 3.7);
        instance.addCourse("AUMAT 120", 3.0);

        instance.printReport(); //Output captured in outContent
        String expResult = //top line and id num removed
                "Puff the Magic Dragon\r\n" +
                        "4112 66 St\r\n" +
                        "Camrose, AB\r\n" +
                        "--------------------------------------------\r\n" +
                        "   AUCSC 112:        4.00\r\n" +
                        "   AUMAT 116:        3.30\r\n" +
                        "   AUCSC 111:        3.70\r\n" +
                        "   AUMAT 120:        3.00\r\n" +
                        "\r\n" +
                        "         GPA:        3.50\r\n" +
                        "===============================================\r\n";
        System.setOut(originalOut);
        String savedOut = removeIdNum(outContent.toString());
        assertEquals(expResult, savedOut);

        //Restore standard out
        System.setOut(originalOut);
    }

    //==========================================================================
    /**
     * Strips off the id num of the report.  Done by removing the first
     * two lines.
     * @param original - report string with id num
     * @return - report string without id num
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
                    System.out.print("'" + (int) original.charAt(index)
                            + "'");
                }
                else {
                    System.out.print("'" + original.charAt(index) + "'");
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