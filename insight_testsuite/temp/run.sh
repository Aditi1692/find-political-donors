#!/bin/bash
#
# Use this shell script to compile (if necessary) your code and then execute it. Below is an example of what might be found in this file if your program was written in Python
#
#INPUT_FOLDER=/home/aditi/aditi_political_donors/find-political-donors/
INPUT_FOLDER=/c/Users/ADJJAIN/workspace/aditi-political-donors/find-political-donors/
TEST_FOLDER=$INPUT_FOLDER/insight_testsuite/tests/test_1
java -jar $INPUT_FOLDER/find_political_donors.jar $TEST_FOLDER/input/itcont.txt $TEST_FOLDER/output/medianvals_by_zip.txt $TEST_FOLDER/output/medianvals_by_date.txt
