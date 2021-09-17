/*
@Name:Rachel Minkowitz
@Date: 10-29-2020
@Version:2.0
@Description: This program reads a list of numbers, checks if they're valid 
atomic numbers, and classifies them using a small list of classsifications - a 
subset of the Periodic Table. After listing my own atomic numbers, the computer 
does a sequential search in order to match up my atomic 
numbers with the atomic numbers from a different list which includes 
the information on certain chemical elements and if they match up the name,
atomic Weight, group, classification, and amount of protons, neutrons and 
electrons are printed. This small subset of the Periodic Table  doesn't include 
all the elements, therefore for certain elements that are valid yet not listed 
are printed as not classified yet. The program then counts how many numbers are 
listed, how many were valid atomic numbers and how many were invalid. 
    This program uses various methods, and methods are called within other 
methods, they're not only called in the main method. The program begins with 
calling the PrintStream Class which allows us to print to a plain text file, 
also we call the File class which with the help of the Scanner object enables 
the program to read from an already existing file as input- in our case we're 
going to be able to read from two lists in the same program. I start the 
Homework4_20 class with setting up the public object PrintStream printer 'ps'so 
that all the methods are able to access it and print to the .txt file. The main 
method is started and since we're using the PrintStream method we throw any 
exceptions that may arise. I start with setting up one of the files that our 
program is reading from called "hmwk4input.txt". This file includes the list of 
numbers that I created, which I want to classify using the small Periodic Table.
I call this input file 'myList'. I then sent my printStream object 'ps' to print
to a file called "hmwk4output.txt". I set up my counter variables as ints for 
the various counters and initialize them to 0. These counters will keep track of
the amount of numbers from myList that are valid atomic numbers and not valid. I 
now start my while loop which takes us through the entire program. As long as 
myList has another number to feed in, the program takes the next number in myList
and sets it as the atomicNumber. The program then calls the method checkNumber 
using the atomicNumber as the argument, calculates whether the atomicNumber is 
between 0 and 118 which would be valid atomicNumbers and returns true or false. 
Within the main I set up a boolean variable called checkNumber2 that stores the 
return (true/false) of the method checkNumber. I now compute, if checkNumber2 = 
true, I continue to compute the rest of the program. Otherwise the computer 
prints the statement that the atomic Number is not valid and adds one to the 
errorCounter. If the atomicNumber is valid the main method prints the atomic 
number, calls the method classify and adds one to the validCounter. The method 
classify does a lot of the program's work by calling other smaller methods. 
Classify is passed the atomicNumber from myList and starts with reading the 
element's name. The method readName is called and readName is passed an integer-
the atomicNumber from myList. readName does a sequential search by accessing the
file "BrooklynCollegeAttachment_2.txt" which has the small periodic table 
information that we are searching for. A while loop takes each piece of 
information from the small periodic table and stores it in a different variable-
it storesthe atomicNumber2 (the atomic Number from the BCAttachment list), the 
string atomicName, atomicWeight, group and period so that now we can refference 
them within this method. Once the information is filled, if the atomic 
number that was passed in from myList and the atomic number that was stored from 
the "BrooklynCollegeAttachment_2.txt" aka atomicNumber2 is the same this 
means that the periodic Table list has the information for my atomic number and 
this function should return the atomicName. Otherwise the function should return
a string that wont be seen - "xxx". Our Classify method initializes a variable 
'name2' as the readName function aka - name2 is equal to the return value from 
the readName function so it's an atomicName or "xxx". We continue in classify 
if name2 does not equal "xxx" then we continue to classify the information, if 
it does equal to "xxx" then we say that this element isn't classified yet- it's 
not on our "BrooklynCollegeAttachment_2.txt" list. If the atomicName is returned
the program continues to call the method printName which recieves the atomic name
- which I've declared as name2 (in the classify method) and prints this name. 
Now we do the same process with the other two methods called readAtomicWeight and 
readGroup which return values are either the atomicWeight/group. These values
are declared in the classify method and sent into the methods printAtomicWeight 
and printGroup which then print what was read from the BCAttachment list. I 
now continue to see if these elements are part of the groups Noble Gas, Alakli
Metal, or Alkaline by calling various methods. The boolean method isNableGas 
takes in the group, checks if the group is 18 and returns as true or false. If 
this method returns as true the method classify prints the calssification that 
it's a noble gas. The boolean method isAlkaliMetal takes in the group, checks if 
the group is 1 and returns as true or false. If this method returns as true the 
method classify prints the calssification that it's an alkali metal. The boolean 
method isAlkaline takes in the group, checks if the group is 2 and returns as 
true or false. If this method returns as true the method classify prints the 
calssification that it's an alkaline. If none of these return true then the 
method prints that this element's group hasnt been classified yet. Now the program
prints the amount of protons which is the same as the atomicNumber, the neutrons 
which are the atomicWeight minus the atomicNumber and the electrons which are the 
same as the atomicNumber. Now that the classify method is done the program 
adds one to the counter of numbers of input in general- valid and invalid. The 
last step of the program is to print all of the counters. Now the main Method is 
finished. 
I personally had a hard time with this program. Since there were many different 
methods that were working together I needed to stay aware of what was passing 
what, what was returning what, the different types they were returning etc. I 
started writing my code without the proper orginization but after some 
guidance I saw things a lot clearer. This homework definetely gave me a 
MUCH better understanding of parameters/ arguments and return statements. I also
was pleasantly surprised to see that scanning from two different text files in 
one program is just as easy as scanning from one! The sequential search made 
sense to me, but feels a bit impractical...I hope to see how sorting and 
searching changes that. Honestly, I felt that this homework was thorough but a
much needed exercise so thank you! I'm already waiting on Homework5!  
 */
package homework4_2.pkg0;

import java.io.PrintStream;
import java.io.File;
import java.util.Scanner;

public class Homework4_20 {

    public static PrintStream ps;

    public static void main(String[] args) throws Exception {

        Scanner myList = new Scanner(new File("hmwk4input.txt"));
        ps = new PrintStream("hmwk4output.txt");

        int errorCounter = 0;
        int validCounter = 0;
        int counter = 0;

        while (myList.hasNext()) {

            int atomicNumber = myList.nextInt();

            boolean checknumber2 = checkNumber(atomicNumber);
            if (checknumber2 == true) {

                ps.printf("Atomic Number: %d is valid\n", atomicNumber);

                classify(atomicNumber);
                validCounter++;

            } else {
                ps.printf("Atomic Number: %d is NOT valid\n", atomicNumber);
                errorCounter++;
            }
            counter++;
            ps.println("\n");
        }
        ps.println("Total data in input: " + counter);
        ps.println("Total Valid data in input: " + validCounter);
        ps.println("Total errors in input: " + errorCounter);
    }// end main 

//checkNumber checks if the atomic number inputed is valid - between 0 and 118
//I send in the atomicNumber from myList to check if it's valid
//the method returns true if the number is valid and false if it's invalid 
    public static boolean checkNumber(int atomicNumber) {
        if (0 < atomicNumber && atomicNumber <= 118) {
            return true;
        }
        return false;
    }//end method checkNumber

//finds the name of the element from the corresponding list "BrooklynCollegeAttachment_2.txt"
//I send in the atomicNumber from myList to match up with the other list 
//If the 2 numbers match the method returns the atomicName, otherwise  "xxx"
    public static String readName(int atomicNumber) throws Exception {

        Scanner sc = new Scanner(new File("BrooklynCollegeAttachment_2.txt"));

        while (sc.hasNext()) {
            int atomicNumber2 = sc.nextInt();
            String atomicName = sc.next();
            int atomicWeight = sc.nextInt();
            int group = sc.nextInt();
            int period = sc.nextInt();

            if (atomicNumber == atomicNumber2) {
                return atomicName;
            }
        }
        return "xxx";
    }//end method readName

//finds the atomicWeight from the BC list that matches with the atomic number 
//I send in the atomicNumber from myList
//If the 2 numbers match it returns the atomicWeight, otherwise it returns 0
    public static int readAtomicWeight(int atomicNumber) throws Exception {

        Scanner sc = new Scanner(new File("BrooklynCollegeAttachment_2.txt"));

        while (sc.hasNext()) {
            int atomicNumber2 = sc.nextInt();
            String atomicName = sc.next();
            int atomicWeight = sc.nextInt();
            int group = sc.nextInt();
            int period = sc.nextInt();
            if (atomicNumber == atomicNumber2) {
                return atomicWeight;
            }
        }
        return 0;
    }//end method readAtomicWeight
    
//finds the group listed for my atomicNumber from the BC list 
//I send in the atomicNumber from myList
//If the 2 numbers match, the method returns the group from the BC list, 
//otherwise it jumps out of the while and returns 0
    public static int readGroup(int atomicNumber) throws Exception {

        Scanner sc = new Scanner(new File("BrooklynCollegeAttachment_2.txt"));

        while (sc.hasNext()) {
            int atomicNumber2 = sc.nextInt();
            String atomicName = sc.next();
            int atomicWeight = sc.nextInt();
            int group = sc.nextInt();
            int period = sc.nextInt();
            if (atomicNumber == atomicNumber2) {
                return group;
            }
        }
        return 0;
    }//end method readGroup

//printName prints the atomicName
//the atomic Number passed in is the atomicNumber returned from readName()
//the method prints a statement and therefore is "void"
    public static void printName(String atomicName) throws Exception {
        ps.println("Name: " + atomicName);
    }//end printName 
    
//printAtomicWeight prints the atomicWeight
//the atomic weight passed in is the atomicWeight returned from readAtomicWeight
//the method prints a statement and therefore is "void"
    public static void printAtomicWeight(int atomicWeight) {
        ps.println("Atomic Weight: " + atomicWeight);
    }//end printAtomicWeight
    
//printGroup prints the group of the element
//the group passed in is the group returned from the method readGroup()
//the method prints a statement and therefore is "void"
    public static void printGroup(int group) {
        ps.println("Group: " + group);
    }// end method printGroup

//isNobleGas checks if the element is a noble gas by checking if the group is 18
//I send in the argument "group"
//the method returns the boolean true if the group is 18 and false if it's not 
    public static boolean isNobleGas(int group) throws Exception {
        if (group == 18) {
            return true;
        }
        return false;
    }//end isNableGas
    
//isAlkaliMetal checks if the element is an alkali metal-check if the group is 1
//I send in the argument "group"
//the method returns true if the group is 1 and false if it's not 
    public static boolean isAlkaliMetal(int group) {
        if (group == 1) {
            return true;
        }
        return false;
    }// end isAlakliMetal
    
//isAlkaline checks if the element is an alkaline by checking if the group is 2
//I send in the argument "group"
//the method returns true if the group is 2 and false if it's not 
    public static boolean isAlkaline(int group) {
        if (group == 2) {
            return true;
        }
        return false;
    }//end isAlkaline
    
//this method invokes several methods to classify/print the information for each 
//atomicNumber 
//we have to pass in the atomicNumber from myList in order to classify 
//this method prints many different values and therefore is declared as void
    public static void classify(int atomicNumber) throws Exception {
        String name2 = readName(atomicNumber);
        if (name2 != "xxx") {
            printName(name2);

            int atomicWeight2 = readAtomicWeight(atomicNumber);
            printAtomicWeight(atomicWeight2);
            int group2 = readGroup(atomicNumber);
            printGroup(group2);

            if (isNobleGas(group2) == true) {
                ps.println("Noble Gas");
            } else if (isAlkaliMetal(group2) == true) {
                ps.println("Alkali metal");
            } else if (isAlkaline(group2) == true) {
                ps.println("Alkaline");
            } else {
                ps.println("Not classified.");
            }

            ps.printf("Protons:%d", atomicNumber);
            int neutrons = atomicWeight2 - atomicNumber;
            ps.printf("  Neutrons:%d", neutrons);
            ps.printf("  Electrons:%d", atomicNumber);

        } else {
            ps.println("Element not classified yet");
        }
    } // end method classify

}// end Homework4_20
