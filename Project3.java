import java.io.*;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
//assistance citation: Professor Shields helped me code the encryption method to take care of spaces by suggesting I create ArrayList alphabet

public class Project3
{
    public static void main(String[] args)
    {

        //declare and initialize ArrayList alphabet
        ArrayList <Character> alphabet = new ArrayList<>();
        alphabet.add('a');
        alphabet.add('b');
        alphabet.add('c');
        alphabet.add('d');
        alphabet.add('e');
        alphabet.add('f');
        alphabet.add('g');
        alphabet.add('h');
        alphabet.add('i');
        alphabet.add('j');
        alphabet.add('k');
        alphabet.add('l');
        alphabet.add('m');
        alphabet.add('n');
        alphabet.add('o');
        alphabet.add('p');
        alphabet.add('q');
        alphabet.add('r');
        alphabet.add('s');
        alphabet.add('t');
        alphabet.add('u');
        alphabet.add('v');
        alphabet.add('w');
        alphabet.add('x');
        alphabet.add('y');
        alphabet.add('z');
        alphabet.add('A');
        alphabet.add('B');
        alphabet.add('C');
        alphabet.add('D');
        alphabet.add('E');
        alphabet.add('F');
        alphabet.add('G');
        alphabet.add('H');
        alphabet.add('I');
        alphabet.add('J');
        alphabet.add('K');
        alphabet.add('L');
        alphabet.add('M');
        alphabet.add('N');
        alphabet.add('O');
        alphabet.add('P');
        alphabet.add('Q');
        alphabet.add('R');
        alphabet.add('S');
        alphabet.add('T');
        alphabet.add('U');
        alphabet.add('V');
        alphabet.add('W');
        alphabet.add('X');
        alphabet.add('Y');
        alphabet.add('Z');

        //declare variable alphabetString
        String alphabetString = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

        //declare Scanner scan
        Scanner scan = new Scanner(System.in);

        //declare and initialize boolean repeat to be true
        boolean repeat;

        //execute do-loop
        do
        {
            //set the value of boolean repeat to be true
            repeat = true;

            //print Strings explaining the menu
            System.out.print("1 -- Encode/Encrypt a message" + '\n' +
                            "2 -- Decode/Decrypt a message" + '\n' +
                            "3 -- Quit/Exit" + '\n');

            //declare and initialize variable input to be the value of the user's input
            String input = scan.next();

            //execute code in if-block if value of variable input is "1"
            if (input.equals("1"))
            {
                //invoke method encodeMessage
                encodeMessage(alphabet);
            }
            //execute code in else if-block if value of variable input is "2"
            else if (input.equals("2"))
            {
                //invoke method decodeMessage
                decodeMessage(alphabetString);
            }
            //execute code in else if-block if value of variable input is "3"
            else if (input.equals("3"))
            {
                //set the value of boolean to be false
                repeat = false;
            }
            //execute code in else-block assuming the value of variable input does not match any of the menu items
            else
            {
                //print String stating that the input must be one of the menu option
                System.err.println("Error! Input must be one of the menu options");

                scan.nextLine();
            }

            //print empty line
            System.out.println();

        }
        //loop do-loop while value of variable repeat is true
        while (repeat);

    }

    public static void encodeMessage(ArrayList<Character> alphabet)
    {
        //declare Scanner scan
        Scanner scan = new Scanner(System.in);

        //declare boolean repeat
        boolean repeat;

        //execute do-loop
        do
        {
            //set value of boolean repeat to be false
            repeat = false;

            //declare ArrayList encryptedChar
            ArrayList<String> encryptedChar = new ArrayList();

            //declare and initialize variable encryptedMessage to be ""
            String encryptedMessage = "";

            //prompt user to enter the name of the file in which they have their encryption key
            System.out.println("Enter the name of the file with your encryption key.");

            //declare and initialize variable fileKey to be the value of the user's input
            String fileKey = scan.next();

            scan.nextLine();

            //prompt user to enter the name of the output file where the encrypted text will be saved
            System.out.println("Enter the name of the output file where the encrypted text will be saved.");

            //declare and initialize variable fileOutput to be the value of the user's input
            String fileOutput = scan.next();

            scan.nextLine();

            //prompt user to enter the message to be encrypted
            System.out.println("Enter the message to be encrypted.");

            //declare and initialize variable originalString to be the value of the user's input
            String originalString = scan.nextLine();

            //declare and initialize Scanner object inputStream as null
            Scanner inputStream = null;

            //declare and initialize PrintWriter object outputStream as null
            PrintWriter outputStream = null;

            //execute try-block
            try
            {
                //nested constructor used to initialize Scanner object inputStream by passing anonymous object FileInputStream (constructed by passing variable fileKey) as an argument
                inputStream = new Scanner(new FileInputStream(fileKey));

                //nested constructor used to initialize PrintWriter object outputStream by passing anonymous object FileOutputStream (constructed by passing variable fileOutput) as an argument
                outputStream = new PrintWriter(new FileOutputStream(fileOutput, true));
            }
            //execute catch-block if a file cannot be found
            catch(FileNotFoundException f)
            {
                //print String stating that the file cannot be found and that the program is returning to the menu
                System.err.println("Error occurred. File cannot be found. Returning to menu.");

                //print empty line
                System.out.println();

                //break out of method encodeMessage();
                break;
            }

            //declare variable encryptionKey
            String encryptionKey;

            //execute try-block
            try
            {
                //initialize String encryptionKey to be the value of the String in the file with the encryption key
                encryptionKey = inputStream.next();
            }
            //execute catch-block if the file with the encryption is blank/does not have any String value
            catch (NoSuchElementException e)
            {
                //set the value of encryptionKey to be ""
                encryptionKey = "";
            }

            //execute if-block if value of variable encryptionKey is blank
            if(encryptionKey.isBlank())
            {
                //return String stating that the file containing the key was empty
                System.err.println("Error occurred. File containing encryption key was empty. Returning to menu.");
            }
            //execute else if-block if the length of variable encryptionKey does NOT equal 52
            else if (encryptionKey.length() != 52)
            {
                //return String stating that the file containing the key does not contain 52 characters
                System.err.println("Error occurred. File containing encryption key does not contain 52 characters. Returning to menu.");
            }
            //execute else-block if file containing the encryption key is NOT blank and contains 52 characters
            else
            {
                //loop through the indexes of variable originalString
                for (int i = 0; i < originalString.length(); i++)
                {
                    //execute if-block if the Arraylist alphabet contains the char at index i of variable originalString
                    if (alphabet.contains(originalString.charAt(i)))
                    {
                        //execute if-block if index of Arraylist alphabet's element (that matches the char of variable originalString at index i) is equal to 52
                        if (alphabet.indexOf(originalString.charAt(i)) == 52)
                        {
                            //add char at index 52 of variable encryptionKey to the Arraylist encryptedChar
                            encryptedChar.add(encryptionKey.substring(52));
                        }
                        //executed else-block if index of Arraylist alphabet's element (that matches the char of variable originalString at index i) is NOT equal to 52
                        else
                        {
                            //add the char of variable encryptionKey at index of Arraylist alphabet's element (that matches the char of variable originalString at index i) to the Arraylist encryptedChar
                            encryptedChar.add(encryptionKey.substring(alphabet.indexOf(originalString.charAt(i)), (alphabet.indexOf(originalString.charAt(i)) + 1)));
                        }
                    }
                    //execute else-block if the Arraylist alphabet does NOT contain the char at index i of variable originalString
                    else
                    {
                        //add String value " " to the Arraylist encryptedChar
                        encryptedChar.add(" ");
                    }
                }

                //loop through all the indexes of array encryptedChar
                for (int i = 0; i < encryptedChar.size(); i++)
                {
                    //add the char element at index i of Arraylist encryptedChar to variable encryptedMessage
                    encryptedMessage = encryptedMessage + encryptedChar.get(i);
                }

                //append the value of variable encryptedMessage to the output file
                outputStream.println(encryptedMessage);

                //print String stating what the encrypted message is
                System.out.println("The encrypted message is: " + encryptedMessage);

                //print empty line
                System.out.println();

                //print String asking user to enter yes if he or she wants to encrypt another message
                System.out.println("Would you like to encrypt another message? If so, enter yes.");

                //declare and initialize variable input to be the value of the user's input
                String input = scan.next();

                //execute if-block if the value of variable input equals "yes"
                if (input.equalsIgnoreCase("yes"))
                {
                    //set the value of the boolean repeat to be true
                    repeat = true;
                }
            }

            //close inputStream
            inputStream.close();

            //close outputStream
            outputStream.close();

            //print empty line
            System.out.println();
        }
        //repeat the do-loop if value of boolean repeat is true
        while (repeat);
    }

    public static void decodeMessage(String alphabetString)
    {
        //declare Scanner scan
        Scanner scan = new Scanner(System.in);

        //declare boolean repeat
        boolean repeat;

        //execute do-loop
        do
        {
            //set value of boolean repeat to be false
            repeat = false;

            //declare ArrayList decryptedChar
            ArrayList<String> decryptedChar = new ArrayList();

            //declare and initialize variable decryptedMessage to be ""
            String decryptedMessage = "";

            //prompt user to enter the name of the file in which they have their encryption key
            System.out.println("Enter the name of the file with your encryption key.");

            //declare and initialize variable fileKey to be the value of the user's input
            String fileKey = scan.next();

            scan.nextLine();

            //prompt user to enter the name of the output file where the decrypted text will be saved
            System.out.println("Enter the name of the output file where the decrypted text will be saved.");

            //declare and initialize variable fileOutput to be the value of the user's input
            String fileOutput = scan.next();

            scan.nextLine();

            //prompt user to enter the message to be encrypted
            System.out.println("Enter the message to be decrypted.");

            //declare and initialize variable originalString to be the value of the user's input
            String originalString = scan.nextLine();

            //declare and initialize Scanner object inputStream as null
            Scanner inputStream = null;

            //declare and initialize PrintWriter object outputStream as null
            PrintWriter outputStream = null;

            //execute try-block
            try
            {
                //nested constructor used to initialize Scanner object inputStream by passing anonymous object FileInputStream (constructed by passing variable fileKey) as an argument
                inputStream = new Scanner(new FileInputStream(fileKey));

                //nested constructor used to initialize PrintWriter object outputStream by passing anonymous object FileOutputStream (constructed by passing variable fileOutput) as an argument
                outputStream = new PrintWriter(new FileOutputStream(fileOutput, true));
            }
            //execute catch-block if a file cannot be found
            catch(FileNotFoundException n)
            {
                //print String stating that the file cannot be found and that the program is returning to the menu
                System.err.println("Error occurred. File cannot be found. Returning to menu.");

                //print empty line
                System.out.println();

                //break out of method decodeMessage();
                break;
            }

            //declare variable encryptionKey
            String encryptionKey;

            //execute try-block
            try
            {
                //initialize String encryptionKey to be the value of the String in the file with the encryption key
                encryptionKey = inputStream.next();
            }
            //execute catch-block if the file with the encryption is blank/does not have any String value
            catch (NoSuchElementException e)
            {
                //set the value of encryptionKey to be ""
                encryptionKey = "";
            }

            //execute if-block if the value of variable encryptionKey is blank
            if (encryptionKey.isBlank())
            {
                //return String stating that the file containing the key was empty
                System.err.println("Error occurred. File containing encryption key was empty. Returning to menu.");
            }
            //execute else if-block if the length of variable encryptionKey does NOT equal 52
            else if (encryptionKey.length() != 52)
            {
                //return String stating that the file containing the key does not contain 52 characters
                System.err.println("Error occurred. File containing encryption key does not contain 52 characters. Returning to menu.");
            }
            //execute else-block if file containing the encryption key is NOT blank and contains 52 characters
            else
            {
                //declare Arraylist charsOfEncryptKey
                ArrayList<Character> charsOfEncryptKey = new ArrayList<>();

                //loop through the indexes of variable encryptionKey
                for(int i = 0; i < encryptionKey.length(); i++)
                {
                    //add the char at index i of variable encryptionKey to the Arraylist charsOfEncryptKey
                    charsOfEncryptKey.add(encryptionKey.charAt(i));
                }

                //loop the indexes of variable originalString
                for (int i = 0; i < originalString.length(); i++)
                {
                    //execute if-block if the Arraylist charsOfEncryptKey contains the char at index i of variable originalString
                    if(charsOfEncryptKey.contains(originalString.charAt(i)))
                    {
                        //execute if-block if index of Arraylist charsOfEncryptKey's element (that matches the char of variable originalString at index i) is equal to 52
                        if(charsOfEncryptKey.indexOf(originalString.charAt(i)) == 52)
                        {
                            //add char at index 52 of variable alphabetString to the Arraylist decryptedChar
                            decryptedChar.add(alphabetString.substring(52));
                        }
                        //execute if-block if index of Arraylist charsOfEncryptKey's element (that matches the char of variable originalString at index i) is NOT equal to 52
                        else
                        {
                            //add the char of variable alphabetString at index of Arraylist charOfEncryptKey's element (that matches the char of variable originalString at index i) to the Arraylist decryptedChar
                            decryptedChar.add(alphabetString.substring(charsOfEncryptKey.indexOf(originalString.charAt(i)), (charsOfEncryptKey.indexOf(originalString.charAt(i)) + 1)));
                        }
                    }
                    //add the String value " " to Arraylist decryptedChar
                    else
                    {
                        decryptedChar.add(" ");
                    }
                }

                //loop through all the indexes array decryptedChar
                for (int i = 0; i < decryptedChar.size(); i++)
                {
                    //add the char element at index i of Arraylist decryptedChar to variable decryptedMessage
                    decryptedMessage = decryptedMessage + decryptedChar.get(i);
                }

                //append the value of variable encryptedMessage to the output file
                outputStream.println(decryptedMessage);

                //print String stating what the decrypted message is
                System.out.println("The decrypted message is: " + decryptedMessage);

                //print empty line
                System.out.println();

                //print String asking user to enter yes if he or she wants to decrypt another message
                System.out.println("Would you like to decrypt another message? If so, enter yes.");

                //declare and initialize variable input to be the value of the user's input
                String input = scan.next();

                //execute if-block if the value of variable input equals "yes"
                if (input.equalsIgnoreCase("yes"))
                {
                    //set the value of the boolean repeat to be true
                    repeat = true;
                }
            }
            //close inputStream
            inputStream.close();

            //close outputStream
            outputStream.close();

            //print empty line
            System.out.println();
        }
        //loop do-loop while value of boolean repeat is true
        while(repeat);
    }
}
/*
"C:\Program Files\Java\jdk-20\bin\java.exe" "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA 2023.2.1\lib\idea_rt.jar=56960:C:\Program Files\JetBrains\IntelliJ IDEA 2023.2.1\bin" -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath C:\Users\enngu\IdeaProjects\CSC121Project3\out\production\CSC121Project3 Project3
1 -- Encode/Encrypt a message
2 -- Decode/Decrypt a message
3 -- Quit/Exit
one
Error! Input must be one of the menu options

1 -- Encode/Encrypt a message
2 -- Decode/Decrypt a message
3 -- Quit/Exit
4
Error! Input must be one of the menu options

1 -- Encode/Encrypt a message
2 -- Decode/Decrypt a message
3 -- Quit/Exit
1
Enter the name of the file with your encryption key.
nonExistent.txt
Enter the name of the output file where the encrypted text will be saved.
encodedOutput.txt
Enter the message to be encrypted.
My dog is named Snowy
Error occurred. File cannot be found. Returning to menu.


1 -- Encode/Encrypt a message
2 -- Decode/Decrypt a message
3 -- Quit/Exit
1
Enter the name of the file with your encryption key.
empty.txt
Enter the name of the output file where the encrypted text will be saved.
encodedOutput.txt
Enter the message to be encrypted.
My dog is named Snowy
Error occurred. File containing encryption key was empty. Returning to menu.


1 -- Encode/Encrypt a message
2 -- Decode/Decrypt a message
3 -- Quit/Exit
1
Enter the name of the file with your encryption key.
incompleteEncryptKey.txt
Enter the name of the output file where the encrypted text will be saved.
encodedOutput.txt
Enter the message to be encrypted.
My dog is named Snowy
Error occurred. File containing encryption key does not contain 52 characters. Returning to menu.


1 -- Encode/Encrypt a message
2 -- Decode/Decrypt a message
3 -- Quit/Exit
1
Enter the name of the file with your encryption key.
encryptKey.txt
Enter the name of the output file where the encrypted text will be saved.
encodedOutput.txt
Enter the message to be encrypted.
My dog is named Snowy
The encrypted message is: Nv ifj pl kwnzi Lkfev

Would you like to encrypt another message? If so, enter yes.
yes

Enter the name of the file with your encryption key.
encryptKey.txt
Enter the name of the output file where the encrypted text will be saved.
encodedOutput.txt
Enter the message to be encrypted.
I have a yellow zebra
The encrypted message is: P ywaz w vzrrfe xzgdw

Would you like to encrypt another message? If so, enter yes.
no


1 -- Encode/Encrypt a message
2 -- Decode/Decrypt a message
3 -- Quit/Exit
2
Enter the name of the file with your encryption key.
nonExistent.txt
Enter the name of the output file where the decrypted text will be saved.
decodedOutput.txt
Enter the message to be decrypted.
P rfaz bpxxw
Error occurred. File cannot be found. Returning to menu.


1 -- Encode/Encrypt a message
2 -- Decode/Decrypt a message
3 -- Quit/Exit
2
Enter the name of the file with your encryption key.
empty.txt
Enter the name of the output file where the decrypted text will be saved.
decodedOutput.txt
Enter the message to be decrypted.
P rfaz bpxxw
Error occurred. File containing encryption key was empty. Returning to menu.


1 -- Encode/Encrypt a message
2 -- Decode/Decrypt a message
3 -- Quit/Exit
2
Enter the name of the file with your encryption key.
incompleteEncryptKey.txt
Enter the name of the output file where the decrypted text will be saved.
decodedOutput.txt
Enter the message to be decrypted.
P rfaz bpxxw
Error occurred. File containing encryption key does not contain 52 characters. Returning to menu.


1 -- Encode/Encrypt a message
2 -- Decode/Decrypt a message
3 -- Quit/Exit
2
Enter the name of the file with your encryption key.
encryptKey.txt
Enter the name of the output file where the decrypted text will be saved.
decodedOutput.txt
Enter the message to be decrypted.
P rfaz bpxxw
The decrypted message is: I love pizza

Would you like to decrypt another message? If so, enter yes.
yes

Enter the name of the file with your encryption key.
encryptKey.txt
Enter the name of the output file where the decrypted text will be saved.
decodedOutput.txt
Enter the message to be decrypted.
Uyzdz wdz lzazk mfrfdl pk uyz dwpkgfe
The decrypted message is: There are seven colors in the rainbow

Would you like to decrypt another message? If so, enter yes.
no


1 -- Encode/Encrypt a message
2 -- Decode/Decrypt a message
3 -- Quit/Exit
3


Process finished with exit code 0
 */