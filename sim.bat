@echo off
setlocal enabledelayedexpansion
echo welcome to robot simulator
echo --------------------------
echo Please enter the file name you want to run (with .java extension):
set /p name="--> "
set "filePath=.\robotsim\examples\%name%"
echo %filePath%
echo.
set "userClassPath=.\lib\JGameGrid.jar;.\robotsim\lib\RobotSim.jar"

for %%f in ("%filePath%") do (
    set "fileName=%%~nf"
)

if exist %filePath% (
    if exist ".\jdk\bin\" (
        echo.
        echo compiling the file...
        ".\jdk\bin\javac" -classpath %userClassPath% %filePath%
        echo compiling complete..
        echo.
        echo running the class file...
        ".\jdk\bin\java" -cp .\robotsim\examples;%userClassPath% !fileName!
    ) else (
        echo Local JDK not found. using system JDK...
        echo.
        echo checking JDK install or not...
        where java >nul 2>&1
        if %ERRORLEVEL% equ 0 (
            echo Java is installed and found in PATH.
            echo Checking Java version...
            java -version
            echo.
            echo compiling the file...
            javac -classpath %userClassPath% .\robotsim\examples\%name%
            echo compiling complete...
            echo.
            echo running the class file...
            java -cp .\robotsim\examples;%userClassPath% !fileName!
        ) else (
            echo Java is not found in PATH or not installed.
            echo Please ensure Java is installed and its 'bin' directory is added to the system PATH.
        )
    )
) else (
    echo file does not exist
)
endlocal
pause