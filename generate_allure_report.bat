@echo off
:: If you already have a valid JAVA_HOME environment variable set, feel free to comment the below two lines
set JAVA_HOME=C:\Users\Bakry-OsmanM\.jdks\openjdk-17.0.1
set path=%JAVA_HOME%\bin;%path%
set path=C:\Users\Bakry-OsmanM\.m2\repository\allure\allure-2.20.1\bin;%path%
allure serve allure-results -h localhost
pause
exit