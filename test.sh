echo "Test 1.1; no input; expected result: Manual and exit code 1"
echo "Result:"
nohup java -jar app.jar
echo $?
echo"-----------------------------------------------"
echo

echo "Test 1.2; input: -h; expected result: Manual and exit code 1"
echo "Result:"
nohup java -jar app.jar -h
echo $?
echo"-----------------------------------------------"
echo

echo "Test 1.3; input: -q; expected result: Manual and exit code 0"
echo "Result:"
nohup java -jar app.jar -q
echo $?
echo"-----------------------------------------------"
echo

echo "Test 2.1; input: -login vasya -pass 123; expected result: Exit code 0"
echo "Result:"
nohup java -jar app.jar -login vasya -pass 123
echo $?
echo"-----------------------------------------------"
echo

echo "Test 2.2; input: -login VASYA -pass 123; expected result: Exit code 2"
echo "Result:"
nohup java -jar app.jar -login VASYA -pass 123
echo $?
echo"-----------------------------------------------"
echo

echo "Test 2.3; input: -login asd -pass asd; expected result: Exit code 3"
echo "Result:"
nohup java -jar app.jar -login asd -pass asd
echo $?
echo"-----------------------------------------------"
echo

echo "Test 2.4; input: -login admin -pass 123; expected result: Exit code 4"
echo "Result:"
nohup java -jar app.jar -login admin -pass 123
echo $?
echo"-----------------------------------------------"
echo

echo "Test 2.5; input: -login admin -pass admin; expected result: Exit code 0"
echo "Result:"
nohup java -jar app.jar -login admin -pass admin
echo $?
echo"-----------------------------------------------"
echo

echo "Test 3.1; input: -login vasya -pass 123 -role READ -res A; expected result: Exit code 0"
echo "Result:"
nohup java -jar app.jar -login vasya -pass 123 -role READ -res A
echo $?
echo"-----------------------------------------------"
echo

echo "Test 3.2; input: -login vasya -pass 123 -role DELETE -res A; expected result: Exit code 5"
echo "Result:"
nohup java -jar -login vasya -pass 123 -role DELETE -res A
echo $?
echo"-----------------------------------------------"
echo

echo "Test 3.3; input: -login vasya -pass 123 -role WRITE -res A; expected result: Exit code 6"
echo "Result:"
nohup java -jar app.jar -login vasya -pass 123 -role WRITE -res A
echo $?
echo"-----------------------------------------------"
echo

echo "Test 3.4; input: -login vasya -pass 123 -role READ -res A.B; expected result: Exit code 0"
echo "Result:"
nohup java -jar app.jar -login vasya -pass 123 -role READ -res A.B
echo $?
echo"-----------------------------------------------"
echo

echo "Test 3.5; input: -login admin -pass admin -role WRITE -res A.B.C; expected result: Exit code 0"
echo "Result:"
nohup java -jar app.jar -login admin -pass admin -role WRITE -res A.B.C
echo $?
echo"-----------------------------------------------"
echo

echo "Test 3.6; input: -login petr -pass petr101 -role DELETE -res A.B.C; expected result: Exit code 0"
echo "Result:"
nohup java -jar app.jar -login petr -pass petr101 -role DELETE -res A.B.C
echo $?
echo"-----------------------------------------------"
echo

echo "Test 3.7; input: -login vasya -pass 123 -role DELETE -res A; expected result: Exit code 4"
echo "Result:"
nohup java -jar app.jar -login vasya -pass 123 -role DELETE -res A
echo $?
echo"-----------------------------------------------"
echo

echo "Test 3.8; input: app.jar -login vasya -pass 123 -role DELETE -res A.B.C; expected result: Exit code 6"
echo "Result:"
nohup java -jar app.jar -login vasya -pass 123 -role DELETE -res A.B.C
echo $?
echo"-----------------------------------------------"
echo

echo "Test 3.9; input: app.jar -login admin -pass admin -role READ -res A.B.D; expected result: Exit code 6"
echo "Result:"
nohup java -jar app.jar -login admin -pass admin -role READ -res A.B.D
echo $?
echo"-----------------------------------------------"
echo

echo "Test 3.10; input: app.jar -login admin -pass admin -role EXECUTE -res A; expected result: Exit code 0"
echo "Result:"
nohup java -jar app.jar -login admin -pass admin -role EXECUTE -res A
echo $?
echo"-----------------------------------------------"
echo

echo "Test 4.1; input: app.jar -login vasya -pass 123 -role READ -res A -ds 2020-03-12 -de 2020-03-13 -vol 10; expected result: Exit code 0"
echo "Result:"
nohup java -jar app.jar -login vasya -pass 123 -role READ -res A -ds 2020-03-12 -de 2020-03-13 -vol 10
echo $?
echo"-----------------------------------------------"
echo

echo "Test 4.2; input: app.jar -login vasya -pass 123 -role WRITE -res A -ds 2020-03-12 -de 2020-03-13 -vol 10; expected result: Exit code 6"
echo "Result:"
nohup java -jar app.jar -login vasya -pass 123 -role WRITE -res A -ds 2020-03-12 -de 2020-03-13 -vol 10
echo $?
echo"-----------------------------------------------"
echo

echo "Test 4.3; input: app.jar -login vasya -pass 123 -role WRITE -res A -ds 2020-03-13 -de 2020-03-12 -vol 10; expected result: Exit code 7"
echo "Result:"
nohup java -jar app.jar -login vasya -pass 123 -role WRITE -res A -ds 2020-03-13 -de 2020-03-12 -vol 10
echo $?
echo"-----------------------------------------------"
echo

echo "Test 4.4; input: app.jar -login vasya -pass 123 -role WRITE -res A -ds 2020/03/12 -de 2020/03/13 -vol 10; expected result: Exit code 7"
echo "Result:"
nohup java -jar app.jar -login vasya -pass 123 -role WRITE -res A -ds 2020/03/12 -de 2020/03/13 -vol 10
echo $?
echo"-----------------------------------------------"
echo

echo "Test 4.5; input: app.jar -login vasya -pass 123 -role WRITE -res A -ds 2020.03.12 -de 2020.03.13 -vol 10; expected result: Exit code 7"
echo "Result:"
nohup java -jar app.jar -login vasya -pass 123 -role WRITE -res A -ds 2020.03.12 -de 2020.03.13 -vol 10
$SHELL