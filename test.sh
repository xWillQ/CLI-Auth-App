echo "Simplest scenarios"
echo "------------------------------------------------------------"
echo "Test 1.1"
echo "Input: <NONE>"
echo "Expected result: Manual and exit code 1"
echo "Result:"
nohup java -jar app.jar
echo $?
echo "------------------------------------------------------------"
echo "Test 1.2"
echo "Input: -h"
echo "Expected result: Manual and exit code 1"
echo "Result:"
nohup java -jar app.jar -h
echo $?
echo "------------------------------------------------------------"
echo "Test 1.3"
echo "Input: -q"
echo "Expected result: Manual and exit code 0"
echo "Result:"
nohup java -jar app.jar -q
echo $?
echo "------------------------------------------------------------"
echo
echo "Authentication"
echo "------------------------------------------------------------"
echo "Test 2.1"
echo "Input: -login vasya -pass 123"
echo "Expected result: exit code 0"
echo "Result:"
nohup java -jar app.jar -login vasya -pass 123
echo $?
echo "------------------------------------------------------------"
echo "Test 2.2"
echo "Input: -login VASYA -pass 123"
echo "Expected result: exit code 2"
echo "Result:"
nohup java -jar app.jar -login VASYA -pass 123
echo $?
echo "------------------------------------------------------------"
echo "Test 2.3"
echo "Input: -login VASYA -pass 1234"
echo "Expected result: exit code 2"
echo "Result:"
nohup java -jar app.jar -login VASYA -pass 1234
echo $?
echo "------------------------------------------------------------"
echo "Test 2.4"
echo "Input: -login asd -pass asd"
echo "Expected result: exit code 3"
echo "Result:"
nohup java -jar app.jar -login asd -pass asd
echo $?
echo "------------------------------------------------------------"
echo "Test 2.5"
echo "Input: -pass admin -login admin"
echo "Expected result: exit code 0"
echo "Result:"
nohup java -jar app.jar -pass admin -login admin
echo $?
echo "------------------------------------------------------------"
echo "Test 2.6"
echo "Input: -pass 123 -login vasya"
echo "Expected result: exit code 0"
echo "Result:"
nohup java -jar app.jar -pass 123 -login vasya
echo $?
echo "------------------------------------------------------------"
echo "Test 2.7"
echo "Input: -login admin -pass adn"
echo "Expected result: exit code 4"
echo "Result:"
nohup java -jar app.jar -login admin -pass adn
echo $?
echo "------------------------------------------------------------"
echo
echo "Authorization"
echo "------------------------------------------------------------"
echo "Test 3.1"
echo "Input: -login vasya -pass 123 -role READ -res A"
echo "Expected result: exit code 0"
echo "Result:"
nohup java -jar app.jar -login vasya -pass 123 -role READ -res A
echo $?
echo "------------------------------------------------------------"
echo "Test 3.2"
echo "Input: -login vasya -pass 123 -role READ -res A -h"
echo "Expected result: Manual and exit code 1"
echo "Result:"
nohup java -jar app.jar -login vasya -pass 123 -role READ -res A -h
echo $?
echo "------------------------------------------------------------"
echo "Test 3.3"
echo "Input: -login vasya -pass 123 -role WRITE -res A -h"
echo "Expected result: Manual and exit code 1"
echo "Result:"
nohup java -jar app.jar -login vasya -pass 123 -role WRITE -res A -h
echo $?
echo "------------------------------------------------------------"
echo "Test 3.4"
echo "Input: -login vasya -pass 123 -role WRITE -res A"
echo "Expected result: exit code 6"
echo "Result:"
nohup java -jar app.jar -login vasya -pass 123 -role WRITE -res A
echo $?
echo "------------------------------------------------------------"
echo "Test 3.5"
echo "Input: -login vasya -pass 123 -role DELETE -res A"
echo "Expected result: exit code 5"
echo "Result:"
nohup java -jar app.jar -login vasya -pass 123 -role DELETE -res A
echo $?
echo "------------------------------------------------------------"
echo "Test 3.6"
echo "Input: -pass admin -login admin -role EXECUTE -res A.B"
echo "Expected result: exit code 0"
echo "Result:"
nohup java -jar app.jar -pass admin -login admin -role EXECUTE -res A.B
echo $?
echo "------------------------------------------------------------"
echo "Test 3.7"
echo "Input: -pass admin -login admin -role EXECUTE -res A.B.C"
echo "Expected result: exit code 0"
echo "Result:"
nohup java -jar app.jar -pass admin -login admin -role EXECUTE -res A.B.C
echo $?
echo "------------------------------------------------------------"
echo "Test 3.8"
echo "Input: -pass admin -login admin -role EXECUTE -res A.D.S"
echo "Expected result: exit code 6"
echo "Result:"
nohup java -jar app.jar -pass admin -login admin -role EXECUTE -res A.D.S
echo $?
echo "------------------------------------------------------------"
echo "Test 3.9"
echo "Input: -pass admin -login admin -role EXECUTE -res A"
echo "Expected result: exit code 6"
echo "Result:"
nohup java -jar app.jar -pass admin -login admin -role EXECUTE -res A
echo $?
echo "------------------------------------------------------------"
echo
echo "Accounting"
echo "------------------------------------------------------------"
echo "Test 4.1"
echo "Input: -login vasya -pass 123 -role READ -res A -ds 2020-03-12 -de 2020-03-13 -vol 10"
echo "Expected result: exit code 0"
echo "Result:"
nohup java -jar app.jar -login vasya -pass 123 -role READ -res A -ds 2020-03-12 -de 2020-03-13 -vol 10
echo $?
echo "------------------------------------------------------------"
echo "Test 4.2"
echo "Input: -login vasya -pass 123 -role WRITE -res A -ds 2020-03-12 -de 2020-03-13 -vol 10"
echo "Expected result: exit code 6"
echo "Result:"
nohup java -jar app.jar -login vasya -pass 123 -role WRITE -res A -ds 2020-03-12 -de 2020-03-13 -vol 10
echo $?
echo "------------------------------------------------------------"
echo "Test 4.3"
echo "Input: -login vasya -pass 123 -role READ -res A -ds 2020-03-13 -de 2020-03-12 -vol 10"
echo "Expected result: exit code 7"
echo "Result:"
nohup java -jar app.jar -login vasya -pass 123 -role READ -res A -ds 2020-03-13 -de 2020-03-12 -vol 10
echo $?
echo "------------------------------------------------------------"
echo "Test 4.4"
echo "Input: -login vasya -pass 123 -role READ -res A -ds 2020/03/12 -de 2020/03/13 -vol 10"
echo "Expected result: exit code 7"
echo "Result:"
nohup java -jar app.jar -login vasya -pass 123 -role READ -res A -ds 2020/03/12 -de 2020/03/13 -vol 10
echo $?
echo "------------------------------------------------------------"
echo "Test 4.5"
echo "Input: -login vasya -pass 123 -role READ -res A -ds 2020.03.12 -de 2020.03.13 -vol 10"
echo "Expected result: exit code 7"
echo "Result:"
nohup java -jar app.jar -login vasya -pass 123 -role READ -res A -ds 2020.03.12 -de 2020.03.13 -vol 10
echo $?
echo "------------------------------------------------------------"
echo "Test 4.6"
echo "Input: -pass admin -login admin -role EXECUTE -res A.B -ds 2020-03-12 -de 2020-03-13 -vol 10"
echo "Expected result: exit code 0"
echo "Result:"
nohup java -jar app.jar -pass admin -login admin -role EXECUTE -res A.B -ds 2020-03-12 -de 2020-03-13 -vol 10
echo $?

$SHELL