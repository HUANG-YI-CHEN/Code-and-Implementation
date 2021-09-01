@echo off
setlocal enabledelayedexpansion
set mult=1
for /l %%i in (1,1,9) do for /l %%j in (1,1,9) do ( set /a mult=%%i*%%j & echo %%ix%%j=!mult! )
endlocal
pause