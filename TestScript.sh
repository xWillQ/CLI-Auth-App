nohup java -jar ${BASH_SOURCE%/*}/app.jar &
nohup java -jar ${BASH_SOURCE%/*}/app.jar -h &
nohup java -jar ${BASH_SOURCE%/*}/app.jar -q &
nohup java -jar ${BASH_SOURCE%/*}/app.jar -login vasya -pass 123 &
nohup java -jar ${BASH_SOURCE%/*}/app.jar -login VASYA -pass 123 &
nohup java -jar ${BASH_SOURCE%/*}/app.jar -login asd -pass asd &
nohup java -jar ${BASH_SOURCE%/*}/app.jar -login admin -pass 123 &
nohup java -jar ${BASH_SOURCE%/*}/app.jar -login admin -pass admin &
nohup java -jar ${BASH_SOURCE%/*}/app.jar -login vasya -pass 123 -role READ -res A &
nohup java -jar ${BASH_SOURCE%/*}/app.jar -login vasya -pass 123 -role DELETE -res A &
nohup java -jar ${BASH_SOURCE%/*}/app.jar -login vasya -pass 123 -role WRITE -res A &
nohup java -jar ${BASH_SOURCE%/*}/app.jar -login vasya -pass 123 -role READ -res A &
nohup java -jar ${BASH_SOURCE%/*}/app.jar -login admin -pass admin -role WRITE -res A.B.C &
nohup java -jar ${BASH_SOURCE%/*}/app.jar -login petr -pass petr101 -role DELETE -res A.B.C &
nohup java -jar ${BASH_SOURCE%/*}/app.jar -login vasya -pass 123 -role DELETE -res &
nohup java -jar ${BASH_SOURCE%/*}/app.jar -login admin -pass admin -role READ -res A.B.D &
nohup java -jar ${BASH_SOURCE%/*}/app.jar -login admin -pass admin -role EXECUTE -res A &
nohup java -jar ${BASH_SOURCE%/*}/app.jar -login vasya -pass 123 -role READ -res A -ds 2020-03-12 -de 2020-03-13 -vol 10 &
nohup java -jar ${BASH_SOURCE%/*}/app.jar -login vasya -pass 123 -role WRITE -res A -ds 2020-03-12 -de 2020-03-13 -vol 10 &
nohup java -jar ${BASH_SOURCE%/*}/app.jar -login vasya -pass 123 -role WRITE -res A -ds 2020-03-13 -de 2020-03-12 -vol 10 &
nohup java -jar ${BASH_SOURCE%/*}/app.jar -login vasya -pass 123 -role WRITE -res A -ds 2020/03/12 -de 2020/03/13 -vol 10 &
nohup java -jar ${BASH_SOURCE%/*}/app.jar -login vasya -pass 123 -role WRITE -res A -ds 2020.03.12 -de 2020.03.13 -vol 10 &
