@echo off
rem route print | for /f "tokens=4" %i in ('find "0.0.0.0"') do @echo %i & exit /b
FOR /F "tokens=4 delims= " %%i in ('route print ^| find "0.0.0.0"') do echo %%i & goto NEXT
:NEXT
pause