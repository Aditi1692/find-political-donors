# find-political-donors

Task: To help political consultants to identify possible donors for a variety of upcoming election campaigns.

Generated output files:
1. medianvals_by_zip.txt: contains a calculated running median, total dollar amount and total number of contributions by recipient and zip code.
2. medianvals_by_date.txt: has the calculated median, total dollar amount and total number of contributions by recipient and date.

Instructions to run the program:
You can run the test with the following command from within the insight_testsuite folder:

insight_testsuite~$ ./run_tests.sh 
On a failed test, the output of run_tests.sh should look like:

[FAIL]: test_1
[Thu Mar 30 16:28:01 PDT 2017] 0 of 1 tests passed
On success:

[PASS]: test_1
[Thu Mar 30 16:25:57 PDT 2017] 1 of 1 tests passed

Directory Structure:

├── README.md 
├── run.sh
├── src
│   └── find_political_donors.py
├── input
│   └── itcont.txt
├── output
|   └── medianvals_by_zip.txt
|   └── medianvals_by_date.txt
├── insight_testsuite
    └── run_tests.sh
    └── tests
        └── test_1
        |   ├── input
        |   │   └── itcont.txt
        |   |__ output
        |   │   └── medianvals_by_zip.txt
        |   |__ └── medianvals_by_date.txt
        ├── your-own-test
            ├── input
            │   └── your-own-input.txt
            |── output
                └── medianvals_by_zip.txt
                └── medianvals_by_date.txt
                
Approach for the problem:

The program is written in JAVA 8 language. I have created two java class files: User_by_zip.java and User_by_date.java. The main class is present in find_political_donors.java.
1. For generating medianvals_by_zip.txt, I have extracted User name and their corresponding zip code and stored them as the key in a map. The value of this map  
