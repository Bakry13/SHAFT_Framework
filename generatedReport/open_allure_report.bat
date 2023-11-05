@echo off
:: If you're using a portable Java version, uncomment the below two lines and update them to use the correct path
:: set JAVA_HOME=C:\Users\Bakry-OsmanM\.jdks\openjdk-17.0.1
:: set path=%JAVA_HOME%\bin;%path%
set path=allure\allure-2.20.1\bin;%path%
allure serve allure-results
pause
exit