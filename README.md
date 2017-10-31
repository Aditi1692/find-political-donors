# find-political-donors

Task: To help political consultants to identify possible donors for a variety of upcoming election campaigns.

Generated output files:
1. medianvals_by_zip.txt: contains a calculated running median, total dollar amount and total number of contributions by recipient and zip code.
2. medianvals_by_date.txt: has the calculated median, total dollar amount and total number of contributions by recipient and date.

# Instructions to run the program:

run.sh: Give the input/output file name path in the following format:

java -jar find_political_donors.jar $input_filename_path/itcont.txt $output_filename_path/medianvals_by_zip.txt $output_filename_path/medianvals_by_date.txt 

You can run the test with the following command from within the insight_testsuite folder:

insight_testsuite~$ ./run_tests.sh 

On a failed test, the output of run_tests.sh should look like:

[FAIL]: test_1
[Thu Mar 30 16:28:01 PDT 2017] 0 of 1 tests passed

On success:

[PASS]: test_1
[Thu Mar 30 16:25:57 PDT 2017] 1 of 1 tests passed

                
# Approach for the problem:

The program is written in JAVA 8 language. I have created two java class files: User_by_zip.java and User_by_date.java. The main class is present in find_political_donors.java.

1. For generating medianvals_by_zip.txt, I have extracted User name and their corresponding zip code and stored them as the key in a map. The value of this map  is the object that contains all the attributes required for generating the output file. This object contains the list of all the amount which can be further used to calculate the median. Also, it contains the cumulative amount corresponding to the user with the same zipcode.

2. For generating medianvals_by_date.txt, I have extracted User name and their corresponding transaction date and stored them as the key in a map. The value of this map  is the object that contains all the attributes required for generating the output file. This object contains the list of all the amount which can be further used to calculate the median. Also, it contains the cumulative amount corresponding to the user with the same transaction date.

The only difference between the two files is that the output for the file medianvals_by_zip.txt is generated line by line but for medianvals_by_date.txt it is generated after reading the input. The map is sorted and then it is iterated to generate the output.
